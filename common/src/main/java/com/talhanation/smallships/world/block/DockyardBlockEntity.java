package com.talhanation.smallships.world.block;

import com.talhanation.smallships.world.dockyard.DockyardRecipe;
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
        REMOVE_CANNON(5);

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
    private int shipTypeId;
    private int woodTypeOrdinal;
    @Nullable private BlockPos spawnSpot;
    /** UPGRADE task data */
    private int upgradeOrdinal;
    private int cannonSlot;
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
    public void startBuildShip(ServerPlayer player, DockyardRecipe.ShipType shipType, Boat.Type woodType) {
        if (this.level == null || this.level.isClientSide() || this.isBusy()) return;

        if (!DockyardRecipe.canAfford(shipType, player)) {
            player.displayClientMessage(Component.translatable("gui.smallships.dockyard.missing_materials"), true);
            return;
        }
        BlockPos spot = WaterSpawnFinder.findSpawnSpot(this.level, this.worldPosition);
        if (spot == null) {
            player.displayClientMessage(Component.translatable("gui.smallships.dockyard.no_water_spot"), true);
            return;
        }

        DockyardRecipe.consume(shipType, player);
        this.task = Task.BUILD_SHIP;
        this.shipTypeId = shipType.id;
        this.woodTypeOrdinal = woodType.ordinal();
        this.spawnSpot = spot;
        this.totalTime = shipType.buildTime;
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
        this.totalTime = 10 * 20;
        this.progress = 0;
        this.setChanged();
    }

    private void finishCannon(Level level, BlockPos pos) {
        if (this.targetShipUUID == null || !(level instanceof ServerLevel serverLevel)) return;
        if (!(serverLevel.getEntity(this.targetShipUUID) instanceof Ship ship)) return;
        if (!(ship instanceof com.talhanation.smallships.world.entity.ship.abilities.Cannonable cannonable)) return;

        boolean mount = this.task == Task.MOUNT_CANNON;
        cannonable.setCannonInSlot(this.cannonSlot, mount);
        if (!mount) {
            ship.spawnAtLocation(com.talhanation.smallships.world.item.ModItems.CANNON);
        }
        level.playSound(null, pos, SoundEvents.ANVIL_USE, SoundSource.BLOCKS, 1.0F, mount ? 1.0F : 0.8F);
        this.targetShipUUID = null;
    }

    /* ---------------- ticking ---------------- */

    public static void serverTick(Level level, BlockPos pos, BlockState state, DockyardBlockEntity dockyard) {
        if (dockyard.task == Task.NONE) return;

        dockyard.progress++;

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
            default -> {}
        }
        this.task = Task.NONE;
        this.progress = 0;
        this.totalTime = 0;
        this.setChanged();
    }

    private void finishBuildShip(Level level, BlockPos pos) {
        DockyardRecipe.ShipType shipType = DockyardRecipe.ShipType.byId(this.shipTypeId);
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
        tag.putInt("ShipType", this.shipTypeId);
        tag.putInt("WoodType", this.woodTypeOrdinal);
        tag.putInt("Upgrade", this.upgradeOrdinal);
        tag.putInt("CannonSlot", this.cannonSlot);
        if (this.spawnSpot != null) tag.putLong("SpawnSpot", this.spawnSpot.asLong());
        if (this.targetShipUUID != null) tag.putUUID("TargetShip", this.targetShipUUID);
    }

    @Override
    protected void loadAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider provider) {
        super.loadAdditional(tag, provider);
        this.task = Task.byId(tag.getInt("Task"));
        this.progress = tag.getInt("Progress");
        this.totalTime = tag.getInt("TotalTime");
        this.shipTypeId = tag.getInt("ShipType");
        this.woodTypeOrdinal = tag.getInt("WoodType");
        this.upgradeOrdinal = tag.getInt("Upgrade");
        this.cannonSlot = tag.getInt("CannonSlot");
        this.spawnSpot = tag.contains("SpawnSpot") ? BlockPos.of(tag.getLong("SpawnSpot")) : null;
        this.targetShipUUID = tag.hasUUID("TargetShip") ? tag.getUUID("TargetShip") : null;
    }
}
