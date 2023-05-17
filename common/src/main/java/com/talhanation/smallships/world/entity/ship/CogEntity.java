package com.talhanation.smallships.world.entity.ship;

import com.talhanation.smallships.mixin.controlling.BoatAccessor;
import com.talhanation.smallships.world.entity.ModEntityTypes;
import com.talhanation.smallships.world.entity.ship.abilities.*;
import com.talhanation.smallships.world.item.ModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CogEntity extends ContainerShip implements Bannerable, Sailable, Cannonable, Repairable, Leashable {
    public static final String ID = "cog";
    private static final int ORIGINAL_CONTAINER_SIZE = 108;
    public CogEntity(EntityType<? extends Boat> entityType, Level level) {
        super(entityType, level, ORIGINAL_CONTAINER_SIZE);
    }

    private CogEntity(Level level, double d, double e, double f) {
        this(ModEntityTypes.COG, level);
        this.setPos(d, e, f);
        this.xo = d;
        this.yo = e;
        this.zo = f;
    }

    public static CogEntity summon(Level level, double d, double e, double f) {
        return new CogEntity(level, d, e, f);
    }

    @Override
    public CompoundTag createDefaultAttributes() {
        Attributes attributes = new Attributes();
        attributes.maxHealth = 300.0F;
        attributes.maxSpeed = 6F;
        attributes.maxReverseSpeed = 0.1F;
        attributes.maxRotationSpeed = 4.0F;
        attributes.acceleration = 0.015F;
        attributes.rotationAcceleration = 0.5F;
        CompoundTag tag = new CompoundTag();
        attributes.addSaveData(tag);
        return tag;
    }

    @Override
    protected int getMaxPassengers() {
        return 5;
    }

    @Override
    public @NotNull Item getDropItem() {
        return ModItems.COG_ITEMS.get(this.getBoatType());
    }

    @Override
    public int getBiomesModifierType() {
        return 0;
    }

    @Override
    public void positionRider(@NotNull Entity entity) {
        if (this.hasPassenger(entity)) {
            float d = this.getSinglePassengerXOffset(); // ^ ^ ^+
            float e = 0.0F; // ^ ^+ ^
            float f = 0.0F; // ^+ ^ ^
            float g = (float) ((this.isRemoved() ? 0.009999999776482582 : this.getPassengersRidingOffset()) + entity.getMyRidingOffset());
            if (this.getPassengers().size() > 1) {
                int i = this.getPassengers().indexOf(entity);
                switch (i) {
                    case(0) -> {
                        d = -1.75F;
                        f = 0.0F;
                    }
                    case(1) -> {
                        d = 1.25F;
                        f = -0.90F;
                    }
                    case(2) -> {
                        d = 1.25F;
                        f = 0.90F;
                    }
                    case(3) -> {
                        d = 0.0F;
                        f = 0.90F;
                    }
                    case(4) -> {
                        d = 0.0F;
                        f = -0.90F;
                    }
                    default -> {
                        d = -1.75F;
                        f = 0.90F;
                    }
                }
            }

            Vec3 vec3 = (new Vec3(d, e, f)).yRot(-this.getYRot() * ((float) Math.PI / 180.0F) - ((float)Math.PI / 2.0F));
            entity.setPos(this.getX() + vec3.x, this.getY() + (double) g, this.getZ() + vec3.z);
            entity.setYRot(entity.getYRot() + ((BoatAccessor) this).getDeltaRotation());
            entity.setYHeadRot(entity.getYHeadRot() + ((BoatAccessor) this).getDeltaRotation());
            this.clampRotation(entity);
            if (entity instanceof Animal && this.getPassengers().size() == this.getMaxPassengers()) {
                int j = entity.getId() % 2 == 0 ? 90 : 270;
                entity.setYBodyRot(((Animal) entity).yBodyRot + (float) j);
                entity.setYHeadRot(entity.getYHeadRot() + (float) j);
            }
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
        CannonPosition pos1 = new CannonPosition(1.4, 0.2, 0.6, true);
        CannonPosition pos2 = new CannonPosition(1.4, 0.2, 0.6, false);

        CannonPosition pos3 = new CannonPosition(-0.6, 0.2, 0.6, true);
        CannonPosition pos4 = new CannonPosition(-0.6, 0.2, 0.6, false);

        positionList.add(pos1);
        positionList.add(pos2);
        positionList.add(pos3);
        positionList.add(pos4);

        return positionList.get(index);
    }

    @Override
    public byte getMaxCannonPerSide(){
        return 2;
    }

    @Override
    protected float getSinglePassengerXOffset() {
        return -1.75F; // ^ ^ ^+
    }

    // Implement Able-Interfaces
    @Override
    public BannerPosition getBannerPosition() {
        return new BannerPosition(-180.0F, 90.0F, -4.0D, 0.78D, 0.05D);
    }

    @Override
    public float getDefaultCannonPower() {
        return 4.0F;
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
            this.getLevel().addParticle(ParticleTypes.DOLPHIN, this.getX() - vector3d.x * (double) f2 + (double) f0, this.getY() - vector3d.y + 0.5D, this.getZ() - vector3d.z * (double) f2 + (double) f1, 0.0D, 0.0D, 0.0D);
            this.getLevel().addParticle(ParticleTypes.DOLPHIN, this.getX() - vector3d.x * (double) f2 - (double) f0, this.getY() - vector3d.y + 0.5D, this.getZ() - vector3d.z * (double) f2 - (double) f1, 0.0D, 0.0D, 0.0D);
            this.getLevel().addParticle(ParticleTypes.DOLPHIN, this.getX() - vector3d.x * (double) f2 + (double) f0, this.getY() - vector3d.y + 0.5D, this.getZ() - vector3d.z * (double) f2 + (double) f1 * 1.1, 0.0D, 0.0D, 0.0D);
            this.getLevel().addParticle(ParticleTypes.DOLPHIN, this.getX() - vector3d.x * (double) f2 - (double) f0, this.getY() - vector3d.y + 0.5D, this.getZ() - vector3d.z * (double) f2 - (double) f1 * 1.1, 0.0D, 0.0D, 0.0D);

            this.getLevel().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2 + (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) f2 + (double) f1, 0.0D, 0.0D, 0.0D);
            this.getLevel().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2 - (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) f2 - (double) f1, 0.0D, 0.0D, 0.0D);
            this.getLevel().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2 + (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) f2 + (double) f1 * 1.1, 0.0D, 0.0D, 0.0D);
            this.getLevel().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2 - (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) f2 - (double) f1 * 1.1, 0.0D, 0.0D, 0.0D);

            this.getLevel().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2_ + (double) f0_1, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) + (double) f1_1, 0.0D, 0.0D, 0.0D);
            this.getLevel().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2_ - (double) f0_1, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) - (double) f1_1, 0.0D, 0.0D, 0.0D);
            this.getLevel().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2_ + (double) f0_1, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) + (double) f1_1 * 1.1, 0.0D, 0.0D, 0.0D);
            this.getLevel().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2_ - (double) f0_1, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) - (double) f1_1 * 1.1, 0.0D, 0.0D, 0.0D);

            this.getLevel().addParticle(ParticleTypes.BUBBLE, this.getX() - vector3d.x * (double) f2_ + (double) f0_1, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) + (double) f1_1, 0.0D, 0.0D, 0.0D);
            this.getLevel().addParticle(ParticleTypes.BUBBLE, this.getX() - vector3d.x * (double) f2_ - (double) f0_1, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) - (double) f1_1, 0.0D, 0.0D, 0.0D);
            this.getLevel().addParticle(ParticleTypes.BUBBLE, this.getX() - vector3d.x * (double) f2_ + (double) f0_1, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) + (double) f1_1 * 1.1, 0.0D, 0.0D, 0.0D);
            this.getLevel().addParticle(ParticleTypes.BUBBLE, this.getX() - vector3d.x * (double) f2_ - (double) f0_1, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) - (double) f1_1 * 1.1, 0.0D, 0.0D, 0.0D);

        }
    }

    @Override
    public @Nullable Vec3 applyLeashOffset() {
        return new Vec3(0.0, this.getEyeHeight(), this.getBbWidth() * 0.1F);
    }
}
