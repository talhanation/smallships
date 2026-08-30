package com.talhanation.smallships.world.entity.ship;

import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.world.entity.ModEntityTypes;
import com.talhanation.smallships.world.entity.ship.hitbox.ShipPartEntity;
import com.talhanation.smallships.world.entity.ship.seat.ShipSeat;
import com.talhanation.smallships.world.entity.ship.abilities.*;
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

public class BriggEntity extends ContainerShip implements Bannerable, Sailable, Cannonable, Seatable, Ability {
    public static final String ID = "brigg";

    /** Two fully square rigged masts: by far the largest canvas and a heavy iron bound hull. */
    private static final Map<ShipUpgrade, Integer> UPGRADE_COSTS = Map.of(
            ShipUpgrade.IRON_SCANTLINGS, 12,
            ShipUpgrade.COTTON_SAILS, 4,
            ShipUpgrade.COPPER_PLATING, 8
    );
    private static final int ORIGINAL_CONTAINER_SIZE = SmallShipsConfig.Common.shipContainerBriggContainerSize.get();

    public BriggEntity(EntityType<? extends Boat> entityType, Level level) {
        super(entityType, level, ORIGINAL_CONTAINER_SIZE);
    }

    private BriggEntity(Level level, double d, double e, double f) {
        this(ModEntityTypes.BRIGG, level);
        this.setPos(d, e, f);
        this.xo = d;
        this.yo = e;
        this.zo = f;
    }

    public static BriggEntity summon(Level level, double d, double e, double f) {
        return new BriggEntity(level, d, e, f);
    }

    @Override
    public Map<ShipUpgrade, Integer> getUpgradeCosts() {
        return UPGRADE_COSTS;
    }

    @Override
    public SmallShipsConfig.ShipAttributes getConfiguredAttributes() {
        return SmallShipsConfig.Common.briggAttributes;
    }

    @Override
    public @NotNull Item getDropItem() {
        if (!SmallShipsConfig.Common.shipGeneralDoItemDrop.get()) return ItemStack.EMPTY.getItem();
        return ModItems.BRIGG_ITEMS.get(this.getVariant());
    }

    @Override
    public BiomeModifierType getBiomeModifierType() {
        return SmallShipsConfig.Common.shipModifierBriggBiome.get();
    }

    /**
     * The longest hull of the fleet: three hull boxes plus fore and main mast.
     */
    private static final List<ShipPartEntity.Definition> PARTS = List.of(
            ShipPartEntity.Definition.hull(0, -0.4F, 0.0F, 3.25F, 2.1F),//middle top
            ShipPartEntity.Definition.hull(-2.5F, -0.4F, 0.0F, 3.2F, 2.1F),//back
            ShipPartEntity.Definition.hull(2.5F, -0.4F, 0.0F, 3.0F, 2.1F),//front

            ShipPartEntity.Definition.mast(2.1F, 0.0F, 0.30F, 10.5F),//front mast
            ShipPartEntity.Definition.mast(-1.4F, 0.0F, 0.30F, 11.7F));//back mast

    @Override
    public List<ShipPartEntity.Definition> getParts() {
        return PARTS;
    }
    private static final float seatHeight = 0.7F;
    private static final List<ShipSeat> SEATS = List.of(
            ShipSeat.driver(0, -2.75F, seatHeight,0.75F),
            ShipSeat.passenger(1, -2.75F, seatHeight, -0.75F),

            ShipSeat.cannon(2, -1.75F, seatHeight, 0.8F, 0),
            ShipSeat.cannon(3, -1.75F, seatHeight, -0.8F, 1),

            ShipSeat.gunner(4, -0.75F, seatHeight,1.0F, 0),
            ShipSeat.gunner(5, -0.75F, seatHeight,-1.0F, 1),
            ShipSeat.passenger(6, -0.75F, seatHeight, 0.0F),

            ShipSeat.cannon(7, 0.25F, seatHeight, 1.0F, 2),
            ShipSeat.passenger(8, 0.25F, seatHeight, 0.0F),
            ShipSeat.cannon(9, 0.25F, seatHeight, -1.0F, 3),

            // gunner seats, inboard next to their cannon slot (seat v = -cannon offsetX)
            ShipSeat.gunner(13, 1.25F, seatHeight,1.0F, 2),
            ShipSeat.passenger(11, 1.25F, seatHeight, 0.0F),
            ShipSeat.gunner(14, 1.25F, seatHeight,-1.0F, 3),

            ShipSeat.cannon(10, 2.25F, seatHeight, 1.0F, 4),
            ShipSeat.cannon(12, 2.25F, seatHeight, -1.0F, 5),

            ShipSeat.gunner(15, 3.00F, seatHeight, 0.75F, 4),
            ShipSeat.gunner(16, 3.00F, seatHeight,-0.75F, 5)
    );

    @Override
    public List<ShipSeat> getSeats() {
        return SEATS;
    }

    @Override
    public void waterSplash(){
        Vec3 vector3d = this.getViewVector(0.0F);
        float f0 = Mth.cos(this.getYRot() * ((float)Math.PI / 180F)) * 1.2F;
        float f1 = Mth.sin(this.getYRot() * ((float)Math.PI / 180F)) * 1.2F;
        float f2 =  4F - this.random.nextFloat() * 0.7F; // höhe
        float f2_ =  -2.3F - this.random.nextFloat() * 0.7F;
        float x = 0; //verschiebung nach rechts/links
        for (int i = 0; i < 2; ++i) {                                                                                                                             //höhe
            this.level().addParticle(ParticleTypes.DOLPHIN, this.getX() - vector3d.x * (double) f2 + (double) f0, this.getY() - vector3d.y + 0.5D, this.getZ() - vector3d.z * (double) f2 + (double) f1, 0.0D, 0.0D, 0.0D);
            this.level().addParticle(ParticleTypes.DOLPHIN, this.getX() - vector3d.x * (double) f2 - (double) f0, this.getY() - vector3d.y + 0.5D, this.getZ() - vector3d.z * (double) f2 - (double) f1, 0.0D, 0.0D, 0.0D);
            this.level().addParticle(ParticleTypes.DOLPHIN, this.getX() - vector3d.x * (double) f2 + (double) f0, this.getY() - vector3d.y + 0.5D, this.getZ() - vector3d.z * (double) f2 + (double) f1 * 5.1, 0.0D, 0.0D, 0.0D);
            this.level().addParticle(ParticleTypes.DOLPHIN, this.getX() - vector3d.x * (double) f2 - (double) f0, this.getY() - vector3d.y + 0.5D, this.getZ() - vector3d.z * (double) f2 - (double) f1 * 5.1, 0.0D, 0.0D, 0.0D);

            this.level().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2 + (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) f2 + (double) f1, 0.0D, 0.0D, 0.0D);
            this.level().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2 - (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) f2 - (double) f1, 0.0D, 0.0D, 0.0D);
            this.level().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2 + (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) f2 + (double) f1 * 1.1, 0.0D, 0.0D, 0.0D);
            this.level().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2 - (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) f2 - (double) f1 * 1.1, 0.0D, 0.0D, 0.0D);

            this.level().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2_ + (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) + (double) f1, 0.0D, 0.0D, 0.0D);
            this.level().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2_ - (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) - (double) f1, 0.0D, 0.0D, 0.0D);
            this.level().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2_ + (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) + (double) f1 * 1.1, 0.0D, 0.0D, 0.0D);
            this.level().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2_ - (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) - (double) f1 * 1.1, 0.0D, 0.0D, 0.0D);

            this.level().addParticle(ParticleTypes.BUBBLE, this.getX() - vector3d.x * (double) f2_ + (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) + (double) f1, 0.0D, 0.0D, 0.0D);
            this.level().addParticle(ParticleTypes.BUBBLE, this.getX() - vector3d.x * (double) f2_ - (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) - (double) f1, 0.0D, 0.0D, 0.0D);
            this.level().addParticle(ParticleTypes.BUBBLE, this.getX() - vector3d.x * (double) f2_ + (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) + (double) f1 * 1.1, 0.0D, 0.0D, 0.0D);
            this.level().addParticle(ParticleTypes.BUBBLE, this.getX() - vector3d.x * (double) f2_ - (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) - (double) f1 * 1.1, 0.0D, 0.0D, 0.0D);
        }
    }

    /**
     *  Cannon Positioning:
     *  offset X: Defines the X offset -> positive will increase a placement in ships backward
     *  offset Y: Defines the Y offset -> positive will increase a placement in height
     *  offset X: Defines the Z offset -> positive will increase a placement in ships left if its right-sided it will auto negate
     **/
    public CannonPosition getCannonPosition(int index){
        List<CannonPosition> positionList = new ArrayList<>();
        CannonPosition pos1 = new CannonPosition(1.4, -0.1, 0.75, true);
        CannonPosition pos2 = new CannonPosition(1.4, -0.1, 0.75, false);

        CannonPosition pos3 = new CannonPosition(-0.1, -0.1, 0.85, true);
        CannonPosition pos4 = new CannonPosition(-0.1, -0.1, 0.85, false);

        CannonPosition pos5 = new CannonPosition(-1.5, -0.1, 0.75, true);
        CannonPosition pos6 = new CannonPosition(-1.5, -0.1, 0.75, false);
        positionList.add(pos1);
        positionList.add(pos2);
        positionList.add(pos3);
        positionList.add(pos4);
        positionList.add(pos5);
        positionList.add(pos6);

        return positionList.get(index);
    }

    public double getCannonAimY(){
        return 3.5D;
    }

    @Override
    public byte getMaxCannonPerSide(){
        return 3;
    }

    /* ---------------- wind profile ---------------- */

    /**
     * Two masts with a mixed rig, historically described as both fast and
     * handy. Flattest profile in the mod: never strong, never weak - that is
     * the all rounder identity and keeps it from dominating through wind too.
     * The three zone multipliers always sum to 3.0.
     */
    @Override
    public float getHeadWindMultiplier() {
        return 0.25F;
    }

    @Override
    public float getSideWindMultiplier() {
        return 1.20F;
    }

    @Override
    public float getTailWindMultiplier() {
        return 1.40F;
    }
}