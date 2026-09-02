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

public class GalleyEntity extends ContainerShip implements Bannerable, Sailable, Cannonable, Paddleable, Seatable, Ability {
    public static final String ID = "galley";

    /** Long, narrow and almost all rowing benches: much timber, but the smallest sail in the fleet. */
    private static final Map<ShipUpgrade, Integer> UPGRADE_COSTS = Map.of(
            ShipUpgrade.IRON_SCANTLINGS, 5,
            ShipUpgrade.COTTON_SAILS, 1,
            ShipUpgrade.COPPER_PLATING, 4
    );
    private static final int ORIGINAL_CONTAINER_SIZE = SmallShipsConfig.Server.shipContainerGalleyContainerSize.get();

    public GalleyEntity(EntityType<? extends Boat> entityType, Level level) {
        super(entityType, level, ORIGINAL_CONTAINER_SIZE);
    }

    private GalleyEntity(Level level, double d, double e, double f) {
        this(ModEntityTypes.GALLEY, level);
        this.setPos(d, e, f);
        this.xo = d;
        this.yo = e;
        this.zo = f;
    }

    public static GalleyEntity summon(Level level, double d, double e, double f) {
        return new GalleyEntity(level, d, e, f);
    }

    @Override
    public Map<ShipUpgrade, Integer> getUpgradeCosts() {
        return UPGRADE_COSTS;
    }

    @Override
    public SmallShipsConfig.ShipAttributes getConfiguredAttributes() {
        return SmallShipsConfig.Server.galleyAttributes;
    }

    @Override
    public @NotNull Item getDropItem() {
        if (!SmallShipsConfig.Server.shipGeneralDoItemDrop.get()) return ItemStack.EMPTY.getItem();
        return ModItems.GALLEY_ITEMS.get(this.getVariant());
    }

    @Override
    public BiomeModifierType getBiomeModifierType() {
        return SmallShipsConfig.Server.shipModifierGalleyBiome.get();
    }

    /**
     * Three hull boxes along the keel plus the single mast. Vanilla entity
     * boxes have a SQUARE footprint, so the length of a ship is never one long
     * part but several short ones.
     */
    private static final List<ShipPartEntity.Definition> PARTS = List.of(
            ShipPartEntity.Definition.hull(-2.65F, 0.0F, 0.0F, 2.8F, 1.6F),//back
            ShipPartEntity.Definition.hull(2.65F, 0.0F, 0.0F, 2.5F, 1.6F),//front
            ShipPartEntity.Definition.hull(0.0F, 0.0F, 0.0F, 3.00F, 1.6F),//center
            ShipPartEntity.Definition.hull(4.35F, 0.75F, 0.0F, 1.25F, 1.0F),//front ram
            ShipPartEntity.Definition.mast(-0.275F, 0.0F, 0.3F, 8.5F)//mast
    );

    @Override
    public List<ShipPartEntity.Definition> getParts() {
        return PARTS;
    }

    private static final List<ShipSeat> SEATS = List.of(
            ShipSeat.driver(0, -2.8F, 0.4F,0.0F),
            ShipSeat.passenger(1, -2.2F,0.4F, 0.75F),
            ShipSeat.passenger(2, -2.2F,0.4F, -0.75F),
            ShipSeat.passenger(3, -1.2F,0.4F, 0.75F),
            ShipSeat.passenger(4, -1.2F,0.4F, -0.75F),
            ShipSeat.passenger(5, -0.2F,0.4F, 0.75F),
            ShipSeat.passenger(6, -0.2F,0.4F, -0.75F),

            ShipSeat.gunner(7, 0.8F,0.4F,0.75F, 0),
            ShipSeat.gunner(8, 0.8F,0.4F, -0.75F, 1),

            ShipSeat.cannon(9, 1.8F,0.4F,0.75F, 0),
            ShipSeat.cannon(10, 1.8F,0.4F, -0.75F, 1),

            ShipSeat.passenger(11, 2.6F, 0.4F,0.0F)
            // gunner seats, inboard next to their cannon slot (seat v = -cannon offsetX)
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

    public CannonPosition getCannonPosition(int index){
        List<CannonPosition> positionList = new ArrayList<>();
        CannonPosition pos1 = new CannonPosition(-1.2, 0, 0.6, true);
        CannonPosition pos2 = new CannonPosition(-1.2, 0, 0.6, false);
        positionList.add(pos1);
        positionList.add(pos2);

        return positionList.get(index);
    }

    public double getCannonAimY(){
        return 3.0D;
    }

    @Override
    public byte getMaxCannonPerSide(){
        return 1;
    }

    /* ---------------- wind profile ---------------- */

    /**
     * Lateen rig plus a full oar bank. The oars are its real protection from
     * the wind, so the sail values stay moderate. Side wind focus fits the
     * Mediterranean coastal trade it was built for.
     * The three zone multipliers always sum to 3.0.
     */
    @Override
    public float getHeadWindMultiplier() {
        return 0.70F;
    }

    @Override
    public float getSideWindMultiplier() {
        return 1.40F;
    }

    @Override
    public float getTailWindMultiplier() {
        return 1.00F;
    }

    /**
     * Oars are a wind independent floor, never a bonus: with furled sails the
     * ship still makes this fraction of its max speed, and it can never be
     * pushed past the ceiling by rowing.
     */
    @Override
    public float getOarFactor() {
        return 0.85F;
    }

    @Override
    public float getRamSelfDamageFactor() {
        return 0.0F;
    }
}