package com.talhanation.smallships.world.entity.ship;

import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.world.entity.ModEntityTypes;
import com.talhanation.smallships.world.entity.ship.abilities.*;
import com.talhanation.smallships.world.item.ModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CogEntity extends ContainerShip implements Bannerable, Sailable, Cannonable, Ability {
    public static final String ID = "cog";
    private static final int ORIGINAL_CONTAINER_SIZE = SmallShipsConfig.Common.shipContainerCogContainerSize.get();
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
        attributes.maxHealth = SmallShipsConfig.Common.shipAttributeCogMaxHealth.get().floatValue();
        attributes.maxSpeed = SmallShipsConfig.Common.shipAttributeCogMaxSpeed.get().floatValue();
        attributes.maxReverseSpeed = SmallShipsConfig.Common.shipAttributeCogMaxReverseSpeed.get().floatValue();
        attributes.maxRotationSpeed = SmallShipsConfig.Common.shipAttributeCogMaxRotationSpeed.get().floatValue();
        attributes.acceleration = SmallShipsConfig.Common.shipAttributeCogAcceleration.get().floatValue();
        attributes.rotationAcceleration = SmallShipsConfig.Common.shipAttributeCogRotationAcceleration.get().floatValue();
        CompoundTag tag = new CompoundTag();
        attributes.addSaveData(tag);
        return tag;
    }
    @Override
    public int getMaxPassengers() {
        return 5;
    }

    @Override
    public @NotNull Item getDropItem() {
        if (!SmallShipsConfig.Common.shipGeneralDoItemDrop.get()) return ItemStack.EMPTY.getItem();
        return ModItems.COG_ITEMS.get(this.getVariant());
    }

    @Override
    public BiomeModifierType getBiomeModifierType() {
        return SmallShipsConfig.Common.shipModifierCogBiome.get();
    }

    @Override
    public @NotNull Vec3 getPassengerAttachmentPoint(Entity entity, EntityDimensions dimensions, float partialTick) {
        float v = 0.0F;
        float h = 0.0F;
        if (!this.getPassengers().isEmpty()) {
            int i = this.getPassengers().indexOf(entity);
            switch (i) {
                case(0) -> {
                    v += -2.25F;
                    h = 0.0F;
                }
                case(1) -> {
                    v += -0.9F;
                    h = 0.9F;
                }
                case(2) -> {
                    v += -0.9F;
                    h = -0.9F;
                }
                case(3) -> {
                    v += 0.65F;
                    h = -0.75F;
                }
                case(4) -> {
                    v += 0.65F;
                    h = 0.75F;
                }
                default -> {
                    v += 1.5F;
                    h = 0.0F;
                }
            }
        }

        return new Vec3(v, dimensions.height() - 0.1, h).yRot(-this.getYRot() * (float) (Math.PI / 180.0) - (float) (Math.PI / 2.0F));
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

    // Implement Able-Interfaces
    @Override
    public BannerPosition getBannerPosition() {
        return new BannerPosition(-180.0F, 90.0F, -4.0D, 0.78D, 0.05D);
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
}
