package com.talhanation.smallships.world.block;

import com.talhanation.smallships.api.ShipRegistry;
import com.talhanation.smallships.api.ShipType;
import com.talhanation.smallships.world.dockyard.DockyardRecipe;
import com.talhanation.smallships.world.dockyard.DockyardRecipeManager;
import com.talhanation.smallships.world.dockyard.WaterSpawnFinder;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.entity.ship.ShipUpgrade;
import com.talhanation.smallships.world.entity.ship.sail.SailDamage;
import com.talhanation.smallships.world.inventory.DockyardMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Comparator;

/**
 * The dockyard block entity: a small state machine
 * IDLE -> BUILDING_SHIP / INSTALLING_UPGRADE / REMOVING_UPGRADE -> done.
 *
 * - Ships are built from materials in the player inventory (validated at start,
 *   consumed at start) and spawned at a previously validated 5x5 water spot.
 * - Upgrades are installed on / removed from the nearest ship within 16 blocks.
 * - Progress is synced to the menu via ContainerData.
 */
public class DockyardBlockEntity extends BlockEntity implements MenuProvider {
    public static final int SHIP_DETECTION_RANGE = 16;

    public enum Task {
        NONE(0),
        BUILD_SHIP(1),
        INSTALL_UPGRADE(2),
        REMOVE_UPGRADE(3),
        MOUNT_CANNON(4),
        REMOVE_CANNON(5),
        APPLY_DYE(6),
        APPLY_BANNER(7),
        REPAIR(8);

        public final int id;
        Task(int id) { this.id = id; }
        public static Task byId(int id) {
            for (Task task : values()) if (task.id == id) return task;
            return NONE;
        }
    }

    private Task task = Task.NONE;
    private int progress;
    private int totalTime;
    /** BUILD_SHIP task data */
    @Nullable private ResourceLocation shipTypeId;
    private int woodTypeOrdinal;
    @Nullable private BlockPos spawnSpot;
    /** UPGRADE task data */
    private int upgradeOrdinal;
    private int cannonSlot;
    /** APPLY_DYE task data */
    @Nullable private String pendingDyeColor;
    /** APPLY_BANNER task data */
    private net.minecraft.world.item.ItemStack pendingBanner = net.minecraft.world.item.ItemStack.EMPTY;
    @Nullable private java.util.UUID targetShipUUID;

    public DockyardBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntityTypes.DOCKYARD, pos, blockState);
    }

    /* ---------------- menu ---------------- */

    public final ContainerData dataAccess = new ContainerData() {
        @Override
        public int get(int index) {
            return switch (index) {
                case DockyardMenu.DATA_PROGRESS -> DockyardBlockEntity.this.progress;
                case DockyardMenu.DATA_TOTAL_TIME -> DockyardBlockEntity.this.totalTime;
                case DockyardMenu.DATA_TASK -> DockyardBlockEntity.this.task.id;
                case DockyardMenu.DATA_POS_X -> DockyardBlockEntity.this.worldPosition.getX();
                case DockyardMenu.DATA_POS_Y -> DockyardBlockEntity.this.worldPosition.getY();
                case DockyardMenu.DATA_POS_Z -> DockyardBlockEntity.this.worldPosition.getZ();
                case DockyardMenu.DATA_SHIP_ID -> {
                    // while building a ship, no ship is reported - the screen
                    // stays in build mode showing the progress
                    if (DockyardBlockEntity.this.task == Task.BUILD_SHIP) yield -1;
                    Ship ship = DockyardBlockEntity.this.findNearestShip();
                    yield ship != null ? ship.getId() : -1;
                }
                default -> 0;
            };
        }

        @Override
        public void set(int index, int value) {}

        @Override
        public int getCount() {
            return DockyardMenu.DATA_COUNT;
        }
    };

    @Override
    public @NotNull Component getDisplayName() {
        return Component.translatable("block.smallships.dockyard");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int syncId, @NotNull Inventory inventory, @NotNull Player player) {
        return new DockyardMenu(syncId, inventory, this.dataAccess);
    }

    /* ---------------- ship detection ---------------- */

    @Nullable
    public Ship findNearestShip() {
        if (this.level == null) return null;
        BlockPos pos = this.worldPosition;
        AABB area = new AABB(pos).inflate(SHIP_DETECTION_RANGE);
        return this.level.getEntitiesOfClass(Ship.class, area).stream()
                .filter(ship -> !ship.isRemoved())
                // exclusive detection: a ship captured by another dockyard is invisible to this one
                .filter(ship -> !ship.isServicedByOtherDockyard(this.worldPosition))
                .min(Comparator.comparingDouble(ship -> ship.distanceToSqr(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5)))
                .orElse(null);
    }

    /* ---------------- tasks ---------------- */

    public boolean isBusy() {
        return this.task != Task.NONE;
    }

    /**
     * Starts building a ship. Validates materials (player inventory) and a
     * valid 5x5 water spawn spot; consumes the materials immediately.
     * Server side only.
     */
    public void startBuildShip(ServerPlayer player, ShipType shipType, Boat.Type woodType) {
        if (this.level == null || this.level.isClientSide() || this.isBusy()) return;

        // the whitelist is server authoritative: the common config is not
        // synced, so a client may well offer a ship this server does not allow
        if (!ShipRegistry.isBuildable(shipType)) {
            player.displayClientMessage(Component.translatable("gui.smallships.dockyard.ship_not_allowed"), true);
            return;
        }
        // read the recipe fresh: a data pack reload takes effect immediately
        DockyardRecipe recipe = DockyardRecipeManager.get(shipType);
        if (!recipe.canAfford(player)) {
            player.displayClientMessage(Component.translatable("gui.smallships.dockyard.missing_materials"), true);
            return;
        }
        BlockPos spot = WaterSpawnFinder.findSpawnSpot(this.level, this.worldPosition);
        if (spot == null) {
            player.displayClientMessage(Component.translatable("gui.smallships.dockyard.no_water_spot"), true);
            return;
        }

        recipe.consume(player);
        this.task = Task.BUILD_SHIP;
        this.shipTypeId = shipType.getId();
        this.woodTypeOrdinal = woodType.ordinal();
        this.spawnSpot = spot;
        this.totalTime = recipe.buildTime();
        this.progress = 0;
        this.setChanged();
    }

    /**
     * Starts installing or removing an upgrade on the nearest ship.
     * Materials come from the player inventory; removal does not refund.
     * Server side only.
     */
    public void startUpgradeTask(ServerPlayer player, ShipUpgrade upgrade, boolean install) {
        if (this.level == null || this.level.isClientSide() || this.isBusy()) return;

        Ship ship = this.findNearestShip();
        if (ship == null) {
            player.displayClientMessage(Component.translatable("gui.smallships.dockyard.no_ship"), true);
            return;
        }
        if (ship.isServicedByOtherDockyard(this.worldPosition)) {
            player.displayClientMessage(Component.translatable("gui.smallships.dockyard.ship_busy"), true);
            return;
        }
        if (install == upgrade.isInstalled(ship)) return;

        if (install) {
            if (!player.hasInfiniteMaterials()) {
                int count = 0;
                for (var stack : player.getInventory().items) {
                    if (stack.is(upgrade.getCostItem())) count += stack.getCount();
                }
                if (count < upgrade.getCostAmount()) {
                    player.displayClientMessage(Component.translatable("gui.smallships.dockyard.missing_materials"), true);
                    return;
                }
                int remaining = upgrade.getCostAmount();
                for (var stack : player.getInventory().items) {
                    if (remaining <= 0) break;
                    if (stack.is(upgrade.getCostItem())) {
                        int take = Math.min(remaining, stack.getCount());
                        stack.shrink(take);
                        remaining -= take;
                    }
                }
            }
        }

        this.task = install ? Task.INSTALL_UPGRADE : Task.REMOVE_UPGRADE;
        this.upgradeOrdinal = upgrade.ordinal();
        this.targetShipUUID = ship.getUUID();
        ship.setServicingDockyard(this.worldPosition);
        this.totalTime = install ? upgrade.getBuildTime() : 15 * 20;
        this.progress = 0;
        this.setChanged();
    }


    /**
     * Mount / dismount a cannon on the nearest ship (dockyard-only mounting).
     * Mounting consumes one cannon item from the player inventory; removal
     * drops the cannon at the ship.
     */
    public void startCannonTask(ServerPlayer player, int cannonSlot, boolean mount) {
        if (this.level == null || this.level.isClientSide() || this.isBusy()) return;

        Ship ship = this.findNearestShip();
        if (!(ship instanceof com.talhanation.smallships.world.entity.ship.abilities.Cannonable cannonable)) {
            player.displayClientMessage(Component.translatable("gui.smallships.dockyard.no_ship"), true);
            return;
        }
        if (cannonSlot < 0 || cannonSlot >= cannonable.getTotalCannonSlots()) return;
        if (mount == cannonable.isCannonInSlot(cannonSlot)) return;
        if (ship.isServicedByOtherDockyard(this.worldPosition)) {
            player.displayClientMessage(Component.translatable("gui.smallships.dockyard.ship_busy"), true);
            return;
        }

        if (mount) {
            if (!player.hasInfiniteMaterials()) {
                boolean consumed = false;
                for (var stack : player.getInventory().items) {
                    if (stack.is(com.talhanation.smallships.world.item.ModItems.CANNON)) {
                        stack.shrink(1);
                        consumed = true;
                        break;
                    }
                }
                if (!consumed) {
                    player.displayClientMessage(Component.translatable("gui.smallships.dockyard.missing_materials"), true);
                    return;
                }
            }
        }

        this.task = mount ? Task.MOUNT_CANNON : Task.REMOVE_CANNON;
        this.cannonSlot = cannonSlot;
        this.targetShipUUID = ship.getUUID();
        ship.setServicingDockyard(this.worldPosition);
        this.totalTime = 10 * 20;
        this.progress = 0;
        this.setChanged();
    }

    private void finishCannon(Level level, BlockPos pos) {
        if (this.targetShipUUID == null || !(level instanceof ServerLevel serverLevel)) return;
        if (!(serverLevel.getEntity(this.targetShipUUID) instanceof Ship ship)) return;
        if (!(ship instanceof com.talhanation.smallships.world.entity.ship.abilities.Cannonable cannonable)) return;

        ship.clearServicingDockyard(pos);
        boolean mount = this.task == Task.MOUNT_CANNON;
        cannonable.setCannonInSlot(this.cannonSlot, mount);
        if (!mount) {
            ship.spawnAtLocation(com.talhanation.smallships.world.item.ModItems.CANNON);
        }
        level.playSound(null, pos, SoundEvents.ANVIL_USE, SoundSource.BLOCKS, 1.0F, mount ? 1.0F : 0.8F);
        this.targetShipUUID = null;
    }


    /**
     * Style task (dye or banner from the player inventory): validates the item
     * in the given inventory slot, consumes it and applies it to the nearest
     * ship after a short work time.
     */
    public void startStyleTask(ServerPlayer player, int inventorySlot) {
        if (this.level == null || this.level.isClientSide() || this.isBusy()) return;
        if (inventorySlot < 0 || inventorySlot >= player.getInventory().items.size()) return;

        Ship ship = this.findNearestShip();
        if (ship == null) {
            player.displayClientMessage(Component.translatable("gui.smallships.dockyard.no_ship"), true);
            return;
        }
        if (ship.isServicedByOtherDockyard(this.worldPosition)) {
            player.displayClientMessage(Component.translatable("gui.smallships.dockyard.ship_busy"), true);
            return;
        }

        var stack = player.getInventory().items.get(inventorySlot);
        if (stack.getItem() instanceof net.minecraft.world.item.DyeItem dyeItem && ship instanceof com.talhanation.smallships.world.entity.ship.abilities.Sailable) {
            String color = dyeItem.getDyeColor().getName();
            if (color.equals(ship.getData(Ship.SAIL_COLOR))) return;
            if (!player.hasInfiniteMaterials()) stack.shrink(1);
            this.pendingDyeColor = color;
            this.task = Task.APPLY_DYE;
        } else if (stack.getItem() instanceof net.minecraft.world.item.BannerItem && ship instanceof com.talhanation.smallships.world.entity.ship.abilities.Bannerable) {
            this.pendingBanner = stack.copyWithCount(1);
            if (!player.hasInfiniteMaterials()) stack.shrink(1);
            this.task = Task.APPLY_BANNER;
        } else {
            return;
        }

        this.targetShipUUID = ship.getUUID();
        ship.setServicingDockyard(this.worldPosition);
        this.totalTime = 8 * 20;
        this.progress = 0;
        this.setChanged();
    }

    private void finishStyle(Level level, BlockPos pos) {
        if (this.targetShipUUID == null || !(level instanceof ServerLevel serverLevel)) return;
        if (!(serverLevel.getEntity(this.targetShipUUID) instanceof Ship ship)) return;
        ship.clearServicingDockyard(pos);

        if (this.task == Task.APPLY_DYE && this.pendingDyeColor != null) {
            ship.setData(Ship.SAIL_COLOR, this.pendingDyeColor);
            level.playSound(null, pos, SoundEvents.WOOL_PLACE, SoundSource.BLOCKS, 1.0F, 1.2F);
        } else if (this.task == Task.APPLY_BANNER && !this.pendingBanner.isEmpty()) {
            var oldBanner = ship.getData(Ship.BANNER);
            if (!oldBanner.isEmpty()) {
                oldBanner.setCount(1);
                ship.spawnAtLocation(oldBanner, 4);
            }
            ship.setData(Ship.BANNER, this.pendingBanner.copy());
            level.playSound(null, pos, SoundEvents.WOOL_HIT, SoundSource.BLOCKS, 1.0F, 1.0F);
        }
        this.pendingDyeColor = null;
        this.pendingBanner = net.minecraft.world.item.ItemStack.EMPTY;
        this.targetShipUUID = null;
    }


    /**
     * Dynamic repair costs: the more hull damage, the more planks and iron
     * nuggets are needed; damaged sails additionally require wool.
     */
    public static java.util.List<com.talhanation.smallships.world.dockyard.DockyardRecipe.Ingredient> getRepairCosts(Ship ship) {
        java.util.List<com.talhanation.smallships.world.dockyard.DockyardRecipe.Ingredient> costs = new java.util.ArrayList<>();
        float hullFraction = Math.min(1.0F, ship.getDamage() / ship.getAttributes().maxHealth);
        if (hullFraction > 0.0F) {
            costs.add(com.talhanation.smallships.world.dockyard.DockyardRecipe.Ingredient.of(net.minecraft.tags.ItemTags.PLANKS, 2 + (int) Math.ceil(hullFraction * 22.0F)));
            costs.add(com.talhanation.smallships.world.dockyard.DockyardRecipe.Ingredient.of(net.minecraft.world.item.Items.IRON_NUGGET, 1 + (int) Math.ceil(hullFraction * 11.0F)));
        }
        float sailHealth = com.talhanation.smallships.world.entity.ship.sail.SailDamage.getHealth(ship);
        float sailFraction = 1.0F - sailHealth / com.talhanation.smallships.world.entity.ship.sail.SailDamage.MAX_HEALTH;
        if (sailFraction > 0.0F) {
            costs.add(com.talhanation.smallships.world.dockyard.DockyardRecipe.Ingredient.of(net.minecraft.tags.ItemTags.WOOL, 1 + (int) Math.ceil(sailFraction * 7.0F)));
        }
        return costs;
    }


    /**
     * Repair task: fully repairs a damaged ship (hull damage AND sails) for
     * 16 planks from the player inventory within 20 seconds of work time.
     */
    public void startRepairTask(ServerPlayer player) {
        if (this.level == null || this.level.isClientSide() || this.isBusy()) return;

        Ship ship = this.findNearestShip();
        if (ship == null) {
            player.displayClientMessage(Component.translatable("gui.smallships.dockyard.no_ship"), true);
            return;
        }
        if (ship.isServicedByOtherDockyard(this.worldPosition)) {
            player.displayClientMessage(Component.translatable("gui.smallships.dockyard.ship_busy"), true);
            return;
        }
        float hullFraction = Math.min(1.0F, ship.getDamage() / ship.getAttributes().maxHealth);
        float sailFraction = 1.0F - com.talhanation.smallships.world.entity.ship.sail.SailDamage.getHealth(ship) / com.talhanation.smallships.world.entity.ship.sail.SailDamage.MAX_HEALTH;
        if (hullFraction <= 0.0F && sailFraction <= 0.0F) return;

        java.util.List<com.talhanation.smallships.world.dockyard.DockyardRecipe.Ingredient> costs = getRepairCosts(ship);
        if (!DockyardRecipe.canAfford(costs, player)) {
            player.displayClientMessage(Component.translatable("gui.smallships.dockyard.missing_materials"), true);
            return;
        }
        DockyardRecipe.consume(costs, player);

        this.task = Task.REPAIR;
        this.targetShipUUID = ship.getUUID();
        ship.setServicingDockyard(this.worldPosition);
        // work time scales with the damage: 8s base up to ~28s
        this.totalTime = (int) ((8.0F + 16.0F * hullFraction + (sailFraction > 0.0F ? 4.0F : 0.0F)) * 20.0F);
        this.progress = 0;
        this.setChanged();
    }

    private void finishRepair(Level level, BlockPos pos) {
        if (this.targetShipUUID == null || !(level instanceof ServerLevel serverLevel)) return;
        if (!(serverLevel.getEntity(this.targetShipUUID) instanceof Ship ship)) return;
        ship.clearServicingDockyard(pos);

        ship.setDamage(0.0F);
        com.talhanation.smallships.world.entity.ship.sail.SailDamage.repair(ship);
        level.playSound(null, pos, SoundEvents.ANVIL_USE, SoundSource.BLOCKS, 1.0F, 1.4F);
        this.targetShipUUID = null;
    }

    /* ---------------- ticking ---------------- */

    public static void serverTick(Level level, BlockPos pos, BlockState state, DockyardBlockEntity dockyard) {
        // exclusive capture: the dockyard claims its detected ship every second,
        // even while idle - no other dockyard can capture the same ship. The
        // claim expires 2s after the ship leaves the range or the dockyard stops.
        if (level.getGameTime() % 20 == 0) {
            Ship detected = dockyard.findNearestShip();
            if (detected != null) detected.setServicingDockyard(pos);
        }

        if (dockyard.task == Task.NONE) return;

        dockyard.progress++;

        // refresh the exclusive claim on the serviced ship every second
        if (dockyard.targetShipUUID != null && dockyard.progress % 20 == 0 && level instanceof ServerLevel serverLevel
                && serverLevel.getEntity(dockyard.targetShipUUID) instanceof Ship claimedShip) {
            claimedShip.setServicingDockyard(pos);
        }

        // working ambience
        if (dockyard.progress % 30 == 0) {
            level.playSound(null, pos, SoundEvents.WOOD_PLACE, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
        }
        if (level instanceof ServerLevel serverLevel && dockyard.progress % 10 == 0) {
            serverLevel.sendParticles(ParticleTypes.CRIT,
                    pos.getX() + 0.5, pos.getY() + 1.1, pos.getZ() + 0.5,
                    3, 0.3, 0.2, 0.3, 0.01);
        }

        if (dockyard.progress >= dockyard.totalTime) {
            dockyard.finishTask(level, pos);
        }
        dockyard.setChanged();
    }

    private void finishTask(Level level, BlockPos pos) {
        switch (this.task) {
            case BUILD_SHIP -> this.finishBuildShip(level, pos);
            case INSTALL_UPGRADE, REMOVE_UPGRADE -> this.finishUpgrade(level, pos);
            case MOUNT_CANNON, REMOVE_CANNON -> this.finishCannon(level, pos);
            case APPLY_DYE, APPLY_BANNER -> this.finishStyle(level, pos);
            case REPAIR -> this.finishRepair(level, pos);
            default -> {}
        }
        this.task = Task.NONE;
        this.progress = 0;
        this.totalTime = 0;
        this.setChanged();
    }

    private void finishBuildShip(Level level, BlockPos pos) {
        // the ship type can be gone if the addon providing it was removed
        // while a build was still running - drop the task instead of crashing
        ShipType shipType = ShipRegistry.get(this.shipTypeId);
        if (shipType == null) return;
        Boat.Type woodType = Boat.Type.values()[Math.floorMod(this.woodTypeOrdinal, Boat.Type.values().length)];

        BlockPos spot = this.spawnSpot;
        // re-validate; if someone built the spot shut in the meantime, search again
        if (spot == null || !WaterSpawnFinder.isValidSpawnSpot(level, spot)) {
            spot = WaterSpawnFinder.findSpawnSpot(level, pos);
        }
        if (spot == null) {
            // pause: retry in 5 seconds without losing the build
            this.task = Task.BUILD_SHIP;
            this.progress = this.totalTime;
            this.totalTime = this.totalTime + 100;
            return;
        }

        Ship ship = shipType.summon(level, spot.getX() + 0.5, spot.getY() + 1.0, spot.getZ() + 0.5);
        if (ship == null) return;
        ship.setVariant(woodType);
        // face away from the dockyard
        float yaw = (float) Math.toDegrees(Math.atan2(-(spot.getX() + 0.5 - (pos.getX() + 0.5)), spot.getZ() + 0.5 - (pos.getZ() + 0.5)));
        ship.setYRot(yaw);
        level.addFreshEntity(ship);

        level.playSound(null, spot, SoundEvents.PLAYER_SPLASH_HIGH_SPEED, SoundSource.BLOCKS, 3.0F, 1.0F);
        this.spawnSpot = null;
    }

    private void finishUpgrade(Level level, BlockPos pos) {
        if (this.targetShipUUID == null || !(level instanceof ServerLevel serverLevel)) return;
        if (!(serverLevel.getEntity(this.targetShipUUID) instanceof Ship ship)) return;

        ship.clearServicingDockyard(pos);
        ShipUpgrade upgrade = ShipUpgrade.byOrdinal(this.upgradeOrdinal);
        upgrade.setInstalled(ship, this.task == Task.INSTALL_UPGRADE);
        if (this.task == Task.INSTALL_UPGRADE) {
            // the dockyard also fixes the sails while working on the ship
            SailDamage.repair(ship);
        }
        level.playSound(null, pos, SoundEvents.ANVIL_USE, SoundSource.BLOCKS, 1.0F, 1.2F);
        this.targetShipUUID = null;
    }

    /* ---------------- save data ---------------- */

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider provider) {
        super.saveAdditional(tag, provider);
        tag.putInt("Task", this.task.id);
        tag.putInt("Progress", this.progress);
        tag.putInt("TotalTime", this.totalTime);
        if (this.shipTypeId != null) tag.putString("ShipType", this.shipTypeId.toString());
        tag.putInt("WoodType", this.woodTypeOrdinal);
        tag.putInt("Upgrade", this.upgradeOrdinal);
        tag.putInt("CannonSlot", this.cannonSlot);
        if (this.pendingDyeColor != null) tag.putString("PendingDyeColor", this.pendingDyeColor);
        if (!this.pendingBanner.isEmpty()) tag.put("PendingBanner", this.pendingBanner.save(provider));
        if (this.spawnSpot != null) tag.putLong("SpawnSpot", this.spawnSpot.asLong());
        if (this.targetShipUUID != null) tag.putUUID("TargetShip", this.targetShipUUID);
    }

    @Override
    protected void loadAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider provider) {
        super.loadAdditional(tag, provider);
        this.task = Task.byId(tag.getInt("Task"));
        this.progress = tag.getInt("Progress");
        this.totalTime = tag.getInt("TotalTime");
        this.shipTypeId = tag.contains("ShipType") ? ResourceLocation.tryParse(tag.getString("ShipType")) : null;
        this.woodTypeOrdinal = tag.getInt("WoodType");
        this.upgradeOrdinal = tag.getInt("Upgrade");
        this.cannonSlot = tag.getInt("CannonSlot");
        this.pendingDyeColor = tag.contains("PendingDyeColor") ? tag.getString("PendingDyeColor") : null;
        this.pendingBanner = tag.contains("PendingBanner") ? net.minecraft.world.item.ItemStack.parse(provider, tag.getCompound("PendingBanner")).orElse(net.minecraft.world.item.ItemStack.EMPTY) : net.minecraft.world.item.ItemStack.EMPTY;
        this.spawnSpot = tag.contains("SpawnSpot") ? BlockPos.of(tag.getLong("SpawnSpot")) : null;
        this.targetShipUUID = tag.hasUUID("TargetShip") ? tag.getUUID("TargetShip") : null;
    }
}