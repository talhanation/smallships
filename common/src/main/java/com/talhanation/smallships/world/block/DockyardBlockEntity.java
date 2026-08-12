package com.talhanation.smallships.world.block;

import com.talhanation.smallships.api.ShipRegistry;
import com.talhanation.smallships.api.ShipType;
import com.talhanation.smallships.world.dockyard.DockyardAction;
import com.talhanation.smallships.world.dockyard.DockyardRecipe;
import com.talhanation.smallships.world.dockyard.DockyardRecipeManager;
import com.talhanation.smallships.world.dockyard.WaterSpawnFinder;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.entity.ship.ShipUpgrade;
import com.talhanation.smallships.world.entity.ship.abilities.Bannerable;
import com.talhanation.smallships.world.entity.ship.abilities.Cannonable;
import com.talhanation.smallships.world.entity.ship.abilities.Sailable;
import com.talhanation.smallships.world.entity.ship.sail.SailDamage;
import com.talhanation.smallships.world.inventory.DockyardMenu;
import com.talhanation.smallships.world.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.BannerItem;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * The dockyard block entity: a small state machine
 * IDLE -> BUILD_SHIP / MODIFY / REPAIR -> done.
 *
 * - Ships are built from materials in the player inventory (validated at start,
 *   consumed at start) and spawned at a previously validated 5x5 water spot.
 * - MODIFY is a BATCH: the screen lets the player tick several rows at once and
 *   sends them as one list. Costs and work times are summed, everything is
 *   applied together when the timer runs out. That is what keeps the rule
 *   "one progress bar, nothing else clickable while it runs" true - a queue of
 *   single tasks would have needed a second state machine on top.
 * - Hull and sails are repaired separately.
 * - Progress is synced to the menu via ContainerData.
 */
public class DockyardBlockEntity extends BlockEntity implements MenuProvider {
    public static final int SHIP_DETECTION_RANGE = 16;

    /**
     * The ids are stable on purpose. 2..7 belonged to the old single step
     * upgrade / cannon / style tasks; a world saved in the middle of one of
     * those simply falls back to NONE instead of resuming something that no
     * longer exists.
     */
    public enum Task {
        NONE(0),
        BUILD_SHIP(1),
        REPAIR(8),
        MODIFY(9);

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
    /** MODIFY task data */
    private final List<DockyardAction> pendingActions = new ArrayList<>();
    /** what is handed back when the batch finishes: full cannons, partial upgrades, the old banner */
    private final List<ItemStack> pendingRefunds = new ArrayList<>();
    @Nullable private String pendingDyeColor;
    private ItemStack pendingBanner = ItemStack.EMPTY;
    /** REPAIR task data */
    private boolean repairHull;
    private boolean repairSails;
    @Nullable private UUID targetShipUUID;

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
                case DockyardMenu.DATA_BUILD_SHIP ->
                        ShipRegistry.indexOf(ShipRegistry.get(DockyardBlockEntity.this.shipTypeId));
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
                // a sunken ship is a wreck: there is nothing left to service,
                // and detecting one would block the build tab for good
                .filter(ship -> !ship.isSunken())
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

    /* ---------------- modify batch ---------------- */

    /**
     * Starts a whole batch of modify actions as ONE task.
     *
     * Every action is validated against the ship and the player inventory here;
     * the client only says what it wants. Materials for the installs are
     * consumed right away, refunds for the removals are handed out when the
     * work is done - the player should not be paid for a job the dockyard has
     * not finished yet.
     */
    public void startModifyTask(ServerPlayer player, List<DockyardAction> actions) {
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

        List<DockyardAction> accepted = new ArrayList<>();
        List<ItemStack> costs = new ArrayList<>();
        List<ItemStack> refunds = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        String dyeColor = null;
        ItemStack banner = ItemStack.EMPTY;
        int time = 0;

        for (DockyardAction action : actions) {
            // the same row twice would be paid for twice and then cancel itself
            if (!seen.add(action.key())) continue;

            switch (action.kind()) {
                case UPGRADE -> {
                    ShipUpgrade upgrade = ShipUpgrade.byOrdinal(action.index());
                    if (action.install() == upgrade.isInstalled(ship)) continue;
                    if (action.install()) {
                        costs.add(upgrade.getCost());
                        time += upgrade.getBuildTime();
                    } else {
                        int refund = upgrade.getRefundAmount();
                        if (refund > 0) refunds.add(new ItemStack(upgrade.getCostItem(), refund));
                        time += upgrade.getRemoveTime();
                    }
                }
                case CANNON -> {
                    if (!(ship instanceof Cannonable cannonable)) continue;
                    if (action.index() < 0 || action.index() >= cannonable.getTotalCannonSlots()) continue;
                    if (action.install() == cannonable.isCannonInSlot(action.index())) continue;
                    // a cannon is bolted onto its carriage, not built into the
                    // hull: it always comes back whole
                    if (action.install()) costs.add(new ItemStack(ModItems.CANNON));
                    else refunds.add(new ItemStack(ModItems.CANNON));
                    time += CANNON_TIME;
                }
                case BANNER -> {
                    if (!(ship instanceof Bannerable)) continue;
                    // there is exactly one banner on a ship, so a second banner
                    // row in the same batch would just overwrite the first
                    if (!banner.isEmpty()) continue;
                    ItemStack current = ship.getData(Ship.BANNER);
                    if (action.install()) {
                        ItemStack source = this.itemAt(player, action.inventorySlot());
                        if (!(source.getItem() instanceof BannerItem)) continue;
                        banner = source.copyWithCount(1);
                        costs.add(source.copyWithCount(1));
                    } else {
                        if (current.isEmpty()) continue;
                        banner = ItemStack.EMPTY;
                    }
                    // the banner that comes off is an item, not a material - it
                    // is never destroyed, no matter which way the row went
                    if (!current.isEmpty()) refunds.add(current.copyWithCount(1));
                    time += STYLE_TIME;
                }
                case SAIL_COLOR -> {
                    if (!(ship instanceof Sailable)) continue;
                    if (dyeColor != null) continue;
                    ItemStack source = this.itemAt(player, action.inventorySlot());
                    if (!(source.getItem() instanceof DyeItem dyeItem)) continue;
                    if (dyeItem.getDyeColor().getName().equals(ship.getData(Ship.SAIL_COLOR))) continue;
                    dyeColor = dyeItem.getDyeColor().getName();
                    costs.add(source.copyWithCount(1));
                    time += STYLE_TIME;
                }
            }
            accepted.add(action);
        }

        if (accepted.isEmpty()) return;
        if (!this.canAfford(player, costs)) {
            player.displayClientMessage(Component.translatable("gui.smallships.dockyard.missing_materials"), true);
            return;
        }
        this.consume(player, costs);

        this.task = Task.MODIFY;
        this.pendingActions.clear();
        this.pendingActions.addAll(accepted);
        this.pendingRefunds.clear();
        this.pendingRefunds.addAll(refunds);
        this.pendingDyeColor = dyeColor;
        this.pendingBanner = banner;
        this.targetShipUUID = ship.getUUID();
        ship.setServicingDockyard(this.worldPosition);
        ship.setDockyardWork(true);
        this.totalTime = Math.max(20, time);
        this.progress = 0;
        this.setChanged();
    }

    /** work time of a single cannon mount / dismount in ticks */
    private static final int CANNON_TIME = 10 * 20;
    /** work time of a banner or dye job in ticks */
    private static final int STYLE_TIME = 8 * 20;

    private void finishModify(Level level, BlockPos pos) {
        if (this.targetShipUUID == null || !(level instanceof ServerLevel serverLevel)) return;
        if (!(serverLevel.getEntity(this.targetShipUUID) instanceof Ship ship)) return;
        ship.clearServicingDockyard(pos);
        ship.setDockyardWork(false);

        for (DockyardAction action : this.pendingActions) {
            switch (action.kind()) {
                case UPGRADE -> {
                    ShipUpgrade upgrade = ShipUpgrade.byOrdinal(action.index());
                    // the sails are NOT touched here: canvas is mended with
                    // wool and nothing else, so a free repair riding along with
                    // an unrelated upgrade would undercut the repair button
                    upgrade.setInstalled(ship, action.install());
                }
                case CANNON -> {
                    if (ship instanceof Cannonable cannonable) cannonable.setCannonInSlot(action.index(), action.install());
                }
                case BANNER -> ship.setData(Ship.BANNER, this.pendingBanner.copy());
                case SAIL_COLOR -> {
                    if (this.pendingDyeColor != null) ship.setData(Ship.SAIL_COLOR, this.pendingDyeColor);
                }
            }
        }
        // refunds land at the DOCKYARD, not at the ship: that is where the
        // player is standing, and a stack dropped over open water is gone
        for (ItemStack refund : this.pendingRefunds) {
            if (!refund.isEmpty()) Containers.dropItemStack(level, pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5, refund.copy());
        }

        level.playSound(null, pos, SoundEvents.ANVIL_USE, SoundSource.BLOCKS, 1.0F, 1.1F);
        this.clearModifyData();
    }

    private void clearModifyData() {
        this.pendingActions.clear();
        this.pendingRefunds.clear();
        this.pendingDyeColor = null;
        this.pendingBanner = ItemStack.EMPTY;
        this.targetShipUUID = null;
    }

    /* ---------------- repair ---------------- */

    /**
     * Dynamic repair costs: the more hull damage, the more planks and iron
     * nuggets are needed; damaged sails need wool by the same rule.
     *
     * Both halves are asked for separately, because the screen offers them as
     * two buttons and each has to show only what IT costs.
     */
    public static List<DockyardRecipe.Ingredient> getRepairCosts(Ship ship, boolean hull, boolean sails) {
        List<DockyardRecipe.Ingredient> costs = new ArrayList<>();
        if (hull) {
            float hullFraction = Math.min(1.0F, ship.getDamage() / ship.getAttributes().maxHealth);
            if (hullFraction > 0.0F) {
                costs.add(DockyardRecipe.Ingredient.of(ItemTags.PLANKS, 2 + (int) Math.ceil(hullFraction * 22.0F)));
                costs.add(DockyardRecipe.Ingredient.of(Items.IRON_NUGGET, 1 + (int) Math.ceil(hullFraction * 11.0F)));
            }
        }
        if (sails) {
            float sailFraction = 1.0F - SailDamage.getHealth(ship) / SailDamage.MAX_HEALTH;
            if (sailFraction > 0.0F) {
                costs.add(DockyardRecipe.Ingredient.of(ItemTags.WOOL, 1 + (int) Math.ceil(sailFraction * 7.0F)));
            }
        }
        return costs;
    }

    /**
     * Repair task: fixes the hull, the sails or both, for materials from the
     * player inventory. The work time scales with the damage.
     */
    public void startRepairTask(ServerPlayer player, boolean hull, boolean sails) {
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
        float hullFraction = hull ? Math.min(1.0F, ship.getDamage() / ship.getAttributes().maxHealth) : 0.0F;
        float sailFraction = sails ? 1.0F - SailDamage.getHealth(ship) / SailDamage.MAX_HEALTH : 0.0F;
        if (hullFraction <= 0.0F && sailFraction <= 0.0F) return;

        List<DockyardRecipe.Ingredient> costs = getRepairCosts(ship, hull, sails);
        if (!DockyardRecipe.canAfford(costs, player)) {
            player.displayClientMessage(Component.translatable("gui.smallships.dockyard.missing_materials"), true);
            return;
        }
        DockyardRecipe.consume(costs, player);

        this.task = Task.REPAIR;
        this.repairHull = hull;
        this.repairSails = sails;
        this.targetShipUUID = ship.getUUID();
        ship.setServicingDockyard(this.worldPosition);
        ship.setDockyardWork(true);
        // work time scales with the damage: 8s base up to ~28s
        this.totalTime = (int) ((8.0F + 16.0F * hullFraction + (sailFraction > 0.0F ? 4.0F : 0.0F)) * 20.0F);
        this.progress = 0;
        this.setChanged();
    }

    private void finishRepair(Level level, BlockPos pos) {
        if (this.targetShipUUID == null || !(level instanceof ServerLevel serverLevel)) return;
        if (!(serverLevel.getEntity(this.targetShipUUID) instanceof Ship ship)) return;
        ship.clearServicingDockyard(pos);
        ship.setDockyardWork(false);

        if (this.repairHull) ship.setDamage(0.0F);
        if (this.repairSails) SailDamage.repair(ship);
        level.playSound(null, pos, SoundEvents.ANVIL_USE, SoundSource.BLOCKS, 1.0F, 1.4F);
        this.targetShipUUID = null;
    }

    /* ---------------- inventory helpers ---------------- */

    private ItemStack itemAt(Player player, int inventorySlot) {
        if (inventorySlot < 0 || inventorySlot >= player.getInventory().items.size()) return ItemStack.EMPTY;
        return player.getInventory().items.get(inventorySlot);
    }

    /**
     * @return true if the player carries every stack in the list. The list may
     * hold the same item twice (two upgrades of the same material), so the
     * amounts are summed per item first.
     */
    private boolean canAfford(Player player, List<ItemStack> costs) {
        if (player.hasInfiniteMaterials()) return true;
        for (ItemStack cost : costs) {
            int required = 0;
            for (ItemStack other : costs) {
                if (ItemStack.isSameItemSameComponents(cost, other)) required += other.getCount();
            }
            if (this.countItem(player, cost) < required) return false;
        }
        return true;
    }

    private int countItem(Player player, ItemStack cost) {
        int count = 0;
        for (ItemStack stack : player.getInventory().items) {
            if (ItemStack.isSameItemSameComponents(stack, cost)) count += stack.getCount();
        }
        return count;
    }

    private void consume(Player player, List<ItemStack> costs) {
        if (player.hasInfiniteMaterials()) return;
        for (ItemStack cost : costs) {
            int remaining = cost.getCount();
            for (ItemStack stack : player.getInventory().items) {
                if (remaining <= 0) break;
                if (!ItemStack.isSameItemSameComponents(stack, cost)) continue;
                int take = Math.min(remaining, stack.getCount());
                stack.shrink(take);
                remaining -= take;
            }
        }
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
            // the ship watches this timestamp: if the refresh stops, it unlocks
            claimedShip.setDockyardWork(true);
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
            case MODIFY -> this.finishModify(level, pos);
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

    /* ---------------- save data ---------------- */

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider provider) {
        super.saveAdditional(tag, provider);
        tag.putInt("Task", this.task.id);
        tag.putInt("Progress", this.progress);
        tag.putInt("TotalTime", this.totalTime);
        if (this.shipTypeId != null) tag.putString("ShipType", this.shipTypeId.toString());
        tag.putInt("WoodType", this.woodTypeOrdinal);
        tag.putBoolean("RepairHull", this.repairHull);
        tag.putBoolean("RepairSails", this.repairSails);
        if (this.pendingDyeColor != null) tag.putString("PendingDyeColor", this.pendingDyeColor);
        if (!this.pendingBanner.isEmpty()) tag.put("PendingBanner", this.pendingBanner.save(provider));
        if (this.spawnSpot != null) tag.putLong("SpawnSpot", this.spawnSpot.asLong());
        if (this.targetShipUUID != null) tag.putUUID("TargetShip", this.targetShipUUID);

        ListTag actions = new ListTag();
        for (DockyardAction action : this.pendingActions) actions.add(action.save());
        tag.put("PendingActions", actions);

        ListTag refunds = new ListTag();
        for (ItemStack refund : this.pendingRefunds) {
            if (!refund.isEmpty()) refunds.add(refund.save(provider));
        }
        tag.put("PendingRefunds", refunds);
    }

    @Override
    protected void loadAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider provider) {
        super.loadAdditional(tag, provider);
        this.task = Task.byId(tag.getInt("Task"));
        this.progress = tag.getInt("Progress");
        this.totalTime = tag.getInt("TotalTime");
        this.shipTypeId = tag.contains("ShipType") ? ResourceLocation.tryParse(tag.getString("ShipType")) : null;
        this.woodTypeOrdinal = tag.getInt("WoodType");
        this.repairHull = tag.getBoolean("RepairHull");
        this.repairSails = tag.getBoolean("RepairSails");
        this.pendingDyeColor = tag.contains("PendingDyeColor") ? tag.getString("PendingDyeColor") : null;
        this.pendingBanner = tag.contains("PendingBanner")
                ? ItemStack.parse(provider, tag.getCompound("PendingBanner")).orElse(ItemStack.EMPTY) : ItemStack.EMPTY;
        this.spawnSpot = tag.contains("SpawnSpot") ? BlockPos.of(tag.getLong("SpawnSpot")) : null;
        this.targetShipUUID = tag.hasUUID("TargetShip") ? tag.getUUID("TargetShip") : null;

        this.pendingActions.clear();
        ListTag actions = tag.getList("PendingActions", 10);
        for (int i = 0; i < actions.size(); i++) this.pendingActions.add(DockyardAction.load(actions.getCompound(i)));

        this.pendingRefunds.clear();
        ListTag refunds = tag.getList("PendingRefunds", 10);
        for (int i = 0; i < refunds.size(); i++) {
            ItemStack.parse(provider, refunds.getCompound(i)).ifPresent(this.pendingRefunds::add);
        }
    }
}