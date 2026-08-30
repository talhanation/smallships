package com.talhanation.smallships.world.entity.ship;

import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.world.entity.ModEntityTypes;
import com.talhanation.smallships.world.entity.ship.abilities.*;
import com.talhanation.smallships.world.entity.ship.hitbox.ShipPartEntity;
import com.talhanation.smallships.world.entity.ship.seat.ShipSeat;
import com.talhanation.smallships.world.item.ModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CaravelEntity extends ContainerShip implements Bannerable, Sailable, Cannonable, Seatable, Ability {
    public static final String ID = "caravel";

    /** A small, fine hull, but two full lateen sails to cut and sew. */
    private static final Map<ShipUpgrade, Integer> UPGRADE_COSTS = Map.of(
            ShipUpgrade.IRON_SCANTLINGS, 5,
            ShipUpgrade.COTTON_SAILS, 2,
            ShipUpgrade.COPPER_PLATING, 4
    );
    private static final int ORIGINAL_CONTAINER_SIZE = SmallShipsConfig.Common.shipContainerCaravelContainerSize.get();
    public CaravelEntity(EntityType<? extends Boat> entityType, Level level) {
        super(entityType, level, ORIGINAL_CONTAINER_SIZE);
    }

    private CaravelEntity(Level level, double d, double e, double f) {
        this(ModEntityTypes.CARAVEL, level);
        this.setPos(d, e, f);
        this.xo = d;
        this.yo = e;
        this.zo = f;
    }

    public static CaravelEntity summon(Level level, double d, double e, double f) {
        return new CaravelEntity(level, d, e, f);
    }

    @Override
    public Map<ShipUpgrade, Integer> getUpgradeCosts() {
        return UPGRADE_COSTS;
    }

    @Override
    public SmallShipsConfig.ShipAttributes getConfiguredAttributes() {
        return SmallShipsConfig.Common.caravelAttributes;
    }

    @Override
    public @NotNull Item getDropItem() {
        if (!SmallShipsConfig.Common.shipGeneralDoItemDrop.get()) return ItemStack.EMPTY.getItem();
        return ModItems.CARAVEL_ITEMS.get(this.getVariant());
    }

    @Override
    public BiomeModifierType getBiomeModifierType() {
        return SmallShipsConfig.Common.shipModifierCaravelBiome.get();
    }

    private static final List<ShipPartEntity.Definition> PARTS = List.of(
            ShipPartEntity.Definition.hull(-4.0F, 0.0F, 0.0F, 2.0F, 1.25F),//back
            ShipPartEntity.Definition.hull(-4.0F, 0.85F, 0.0F, 2.0F, 1.25F),//back above
            ShipPartEntity.Definition.hull(-2.5F, 0.0F, 0.0F, 2.5F, 1.25F),//middle back
            ShipPartEntity.Definition.hull(-3.0F, 0.85F, 0.0F, 2.5F, 1.25F),//middle back above
            ShipPartEntity.Definition.hull(2.5F, 0.0F, 0.0F, 2.5F, 1.25F),//middle front
            ShipPartEntity.Definition.hull(3.5F, 0.0F, 0.0F, 2.0F, 1.25F),//front
            ShipPartEntity.Definition.hull(4.5F, 1.00F, 0.0F, 0.75F, 1.6F),//front tip
            ShipPartEntity.Definition.mast(2.2F, 0.0F, 0.30F, 10.75F),//front mast
            ShipPartEntity.Definition.mast(-2.0F, 0.0F, 0.30F, 9.5F));//back mast
    @Override
    public List<ShipPartEntity.Definition> getParts() {
        return PARTS;
    }

    private static final List<ShipSeat> SEATS = java.util.List.of(
            ShipSeat.driver(0, -2.6F, 0.95F,0.7F),
            ShipSeat.passenger(1, -2.6F,0.95F, -0.7F),

            ShipSeat.gunner(2, -1.5F, 0.12F,0.7F, 0),
            ShipSeat.gunner(3, -1.5F, 0.12F,-0.7F, 1),

            ShipSeat.passenger(4, 0.25F,0.12F, 0.7F),
            ShipSeat.passenger(5, 0.25F, 0.12F,-0.7F),

            ShipSeat.gunner(6, 1.5F, 0.12F,0.7F, 2),
            ShipSeat.gunner(7, 1.5F, 0.12F,-0.7F, 3),

            ShipSeat.passenger(8, 3.0F,0.12F, 0.7F),
            ShipSeat.passenger(9, 3.0F, 0.12F,-0.7F)
    );

    @Override
    public List<ShipSeat> getSeats() {
        return SEATS;
    }

    /**
     *  Cannon Positioning:
     *  offset X: Defines the X offset -> positive will increase a placement in ships backward
     *  offset Y: Defines the Y offset -> positive will increase a placement in height
     *  offset X: Defines the Z offset -> positive will increase a placement in ships left if its right-sided it will auto negate
     **/
    public CannonPosition getCannonPosition(int index){
        List<CannonPosition> positionList = new ArrayList<>();
        CannonPosition pos1 = new CannonPosition(0.75, 0.46, 0.8, true);
        CannonPosition pos2 = new CannonPosition(0.75, 0.46, 0.8, false);

        CannonPosition pos3 = new CannonPosition(-1.3, 0.46, 0.8, true);
        CannonPosition pos4 = new CannonPosition(-1.3, 0.46, 0.8, false);

        positionList.add(pos1);
        positionList.add(pos2);
        positionList.add(pos3);
        positionList.add(pos4);

        return positionList.get(index);
    }

    public double getCannonAimY(){
        return 3.0D;
    }

    @Override
    public byte getMaxCannonPerSide(){
        return 2;
    }

    @Override
    public void waterSplash() {
        Vec3 vector3d = this.getViewVector(0.0F);
        float f0 = Mth.cos(this.getYRot() * ((float) Math.PI / 180F)) * 0.8F;
        float f1 = Mth.sin(this.getYRot() * ((float) Math.PI / 180F)) * 0.8F;
        float f0_1 = Mth.cos(this.getYRot() * ((float) Math.PI / 180F)) * 1.6F;
        float f1_1 = Mth.sin(this.getYRot() * ((float) Math.PI / 180F)) * 1.6F;
        float f2 = 2.5F - this.random.nextFloat() * 0.7F;
        float f2_ = -1.3F - this.random.nextFloat() * 0.7F;
        float x = 0;
        for (int i = 0; i < 2; ++i) {
            this.level().addParticle(ParticleTypes.DOLPHIN, this.getX() - vector3d.x * (double) f2 + (double) f0, this.getY() - vector3d.y + 0.5D, this.getZ() - vector3d.z * (double) f2 + (double) f1, 0.0D, 0.0D, 0.0D);
            this.level().addParticle(ParticleTypes.DOLPHIN, this.getX() - vector3d.x * (double) f2 - (double) f0, this.getY() - vector3d.y + 0.5D, this.getZ() - vector3d.z * (double) f2 - (double) f1, 0.0D, 0.0D, 0.0D);
            this.level().addParticle(ParticleTypes.DOLPHIN, this.getX() - vector3d.x * (double) f2 + (double) f0, this.getY() - vector3d.y + 0.5D, this.getZ() - vector3d.z * (double) f2 + (double) f1 * 1.1, 0.0D, 0.0D, 0.0D);
            this.level().addParticle(ParticleTypes.DOLPHIN, this.getX() - vector3d.x * (double) f2 - (double) f0, this.getY() - vector3d.y + 0.5D, this.getZ() - vector3d.z * (double) f2 - (double) f1 * 1.1, 0.0D, 0.0D, 0.0D);

            this.level().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2 + (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) f2 + (double) f1, 0.0D, 0.0D, 0.0D);
            this.level().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2 - (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) f2 - (double) f1, 0.0D, 0.0D, 0.0D);
            this.level().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2 + (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) f2 + (double) f1 * 1.1, 0.0D, 0.0D, 0.0D);
            this.level().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2 - (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) f2 - (double) f1 * 1.1, 0.0D, 0.0D, 0.0D);

            this.level().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2_ + (double) f0_1, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) + (double) f1_1, 0.0D, 0.0D, 0.0D);
            this.level().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2_ - (double) f0_1, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) - (double) f1_1, 0.0D, 0.0D, 0.0D);
            this.level().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2_ + (double) f0_1, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) + (double) f1_1 * 1.1, 0.0D, 0.0D, 0.0D);
            this.level().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2_ - (double) f0_1, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) - (double) f1_1 * 1.1, 0.0D, 0.0D, 0.0D);

            this.level().addParticle(ParticleTypes.BUBBLE, this.getX() - vector3d.x * (double) f2_ + (double) f0_1, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) + (double) f1_1, 0.0D, 0.0D, 0.0D);
            this.level().addParticle(ParticleTypes.BUBBLE, this.getX() - vector3d.x * (double) f2_ - (double) f0_1, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) - (double) f1_1, 0.0D, 0.0D, 0.0D);
            this.level().addParticle(ParticleTypes.BUBBLE, this.getX() - vector3d.x * (double) f2_ + (double) f0_1, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) + (double) f1_1 * 1.1, 0.0D, 0.0D, 0.0D);
            this.level().addParticle(ParticleTypes.BUBBLE, this.getX() - vector3d.x * (double) f2_ - (double) f0_1, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) - (double) f1_1 * 1.1, 0.0D, 0.0D, 0.0D);

        }
    }

    /* ---------------- wind profile ---------------- */

    /**
     * Single square sail, the classic North Sea trader: it waits for a fair wind
     * and runs before it. Readable reference profile for new players.
     * The three zone multipliers always sum to 3.0.
     */
    @Override
    public float getHeadWindMultiplier() {
        return 1.10F;
    }

    @Override
    public float getSideWindMultiplier() {
        return 1.15F;
    }

    @Override
    public float getTailWindMultiplier() {
        return 0.80F;
    }
}