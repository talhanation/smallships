package com.talhanation.smallships.world.entity.ship;

import com.talhanation.smallships.config.SmallShipsConfig;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DrakkarEntity extends ContainerShip implements Bannerable, Sailable, Shieldable, Repairable, Leashable, Paddleable, IceBreakable {
    public static final String ID = "drakkar";
    private static final int ORIGINAL_CONTAINER_SIZE = SmallShipsConfig.Common.shipContainerDrakkarContainerSize.get();

    private static final List<ShieldPosition> SHIELD_POSITIONS = new ArrayList<>();

    static {
        SHIELD_POSITIONS.add(new ShieldPosition(2.1, 0.8, -1.0, true));
        SHIELD_POSITIONS.add(new ShieldPosition(2.1, 0.8, 1.0, false));
        SHIELD_POSITIONS.add(new ShieldPosition(0.9, 0.8, -1.2, true));
        SHIELD_POSITIONS.add(new ShieldPosition(0.9, 0.8, 1.2, false));
        SHIELD_POSITIONS.add(new ShieldPosition(-0.3, 0.8, -1.2, true));
        SHIELD_POSITIONS.add(new ShieldPosition(-0.3, 0.8, 1.2, false));
        SHIELD_POSITIONS.add(new ShieldPosition(-1.5, 0.8, -1.2, true));
        SHIELD_POSITIONS.add(new ShieldPosition(-1.5, 0.8, 1.2, false));
        SHIELD_POSITIONS.add(new ShieldPosition(-3.0, 0.8, -1.0, true));
        SHIELD_POSITIONS.add(new ShieldPosition(-3.0, 0.8, 1.0, false));
    }

    public DrakkarEntity(EntityType<? extends Boat> entityType, Level level) {
        super(entityType, level, ORIGINAL_CONTAINER_SIZE);
    }

    private DrakkarEntity(Level level, double d, double e, double f) {
        this(ModEntityTypes.DRAKKAR, level);
        this.setPos(d, e, f);
        this.xo = d;
        this.yo = e;
        this.zo = f;
    }

    public static DrakkarEntity summon(Level level, double d, double e, double f) {
        return new DrakkarEntity(level, d, e, f);
    }
    @Override
    public CompoundTag createDefaultAttributes() {
        Attributes attributes = new Attributes();
        attributes.maxHealth = SmallShipsConfig.Common.shipAttributeDrakkarMaxHealth.get().floatValue();
        attributes.maxSpeed = SmallShipsConfig.Common.shipAttributeDrakkarMaxSpeed.get().floatValue();
        attributes.maxReverseSpeed = SmallShipsConfig.Common.shipAttributeDrakkarMaxReverseSpeed.get().floatValue();
        attributes.maxRotationSpeed = SmallShipsConfig.Common.shipAttributeDrakkarMaxRotationSpeed.get().floatValue();
        attributes.acceleration = SmallShipsConfig.Common.shipAttributeDrakkarAcceleration.get().floatValue();
        attributes.rotationAcceleration = SmallShipsConfig.Common.shipAttributeDrakkarRotationAcceleration.get().floatValue();
        CompoundTag tag = new CompoundTag();
        attributes.addSaveData(tag);
        return tag;
    }

    @Override
    public int getMaxPassengers() {
        return 11;
    }

    @Override
    public @NotNull Item getDropItem() {
        if (!SmallShipsConfig.Common.shipGeneralDoItemDrop.get()) return ItemStack.EMPTY.getItem();
        return ModItems.DRAKKAR_ITEMS.get(this.getBoatType());
    }

    @Override
    public BiomeModifierType getBiomeModifierType() {
        return SmallShipsConfig.Common.shipModifierDrakkarBiome.get();
    }

    @Override
    public void positionRider(@NotNull Entity entity) {
        if (this.hasPassenger(entity)) {
            float d = this.getSinglePassengerXOffset(); // ^ ^ ^+
            float e = 0.0F; // ^ ^+ ^
            float f = this.getSinglePassengerZOffset(); // ^+ ^ ^
            float g = (float) ((this.isRemoved() ? 0.009999999776482582 : this.getPassengersRidingOffset()) + entity.getMyRidingOffset());
            if (this.getPassengers().size() > 1) {
                int i = this.getPassengers().indexOf(entity);
                switch (i) {
                    case (0) -> {
                        d = -4.0F;
                        f = 0.0F;
                    }
                    case(1) -> {
                        d = -2.5F;
                        f = 0.75F;
                    }
                    case(2) -> {
                        d = -2.5F;
                        f = -0.75F;
                    }
                    case(3) -> {
                        d = -1.5F;
                        f = -0.75F;
                    }
                    case(4) -> {
                        d = -1.5F;
                        f = 0.75F;
                    }
                    case(5) -> {
                        d = -0.5F;
                        f = -0.75F;
                    }
                    case(6) -> {
                        d = -0.5F;
                        f = 0.75F;
                    }
                    case(7) -> {
                        d = 0.5F;
                        f = -0.75F;
                    }
                    case(8) -> {
                        d = 0.5F;
                        f = 0.75F;
                    }
                    case(9) -> {
                        d = 1.5F;
                        f = 0.5F;
                    }
                    case(10) -> {
                        d = 1.5F;
                        f = -0.5F;
                    }
                    default -> {
                        d = 2.0F;
                        e = 0.75F;
                        f = 0.0F;
                    }
                }
            }
            d += 2;

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

    @Override
    protected float getSinglePassengerXOffset() {
        return -1.7F; // ^ ^ ^+
    }

    protected float getSinglePassengerZOffset() {
        return 0.7F; // ^+ ^ ^
    }

    // Implement Able-Interfaces
    @Override
    public Bannerable.BannerPosition getBannerPosition() {
        return new BannerPosition(0.0F, 270.0F, 4.3D, -0.15D, 0.05D); //+x=up, +y=back, +z=right
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
            this.getLevel().addParticle(ParticleTypes.DOLPHIN, this.getX() - vector3d.x * (double) f2 + (double) f0, this.getY() - vector3d.y + 0.5D, this.getZ() - vector3d.z * (double) f2 + (double) f1, 0.0D, 0.0D, 0.0D);
            this.getLevel().addParticle(ParticleTypes.DOLPHIN, this.getX() - vector3d.x * (double) f2 - (double) f0, this.getY() - vector3d.y + 0.5D, this.getZ() - vector3d.z * (double) f2 - (double) f1, 0.0D, 0.0D, 0.0D);
            this.getLevel().addParticle(ParticleTypes.DOLPHIN, this.getX() - vector3d.x * (double) f2 + (double) f0, this.getY() - vector3d.y + 0.5D, this.getZ() - vector3d.z * (double) f2 + (double) f1 * 5.1, 0.0D, 0.0D, 0.0D);
            this.getLevel().addParticle(ParticleTypes.DOLPHIN, this.getX() - vector3d.x * (double) f2 - (double) f0, this.getY() - vector3d.y + 0.5D, this.getZ() - vector3d.z * (double) f2 - (double) f1 * 5.1, 0.0D, 0.0D, 0.0D);

            this.getLevel().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2 + (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) f2 + (double) f1, 0.0D, 0.0D, 0.0D);
            this.getLevel().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2 - (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) f2 - (double) f1, 0.0D, 0.0D, 0.0D);
            this.getLevel().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2 + (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) f2 + (double) f1 * 1.1, 0.0D, 0.0D, 0.0D);
            this.getLevel().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2 - (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) f2 - (double) f1 * 1.1, 0.0D, 0.0D, 0.0D);

            this.getLevel().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2_ + (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) + (double) f1, 0.0D, 0.0D, 0.0D);
            this.getLevel().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2_ - (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) - (double) f1, 0.0D, 0.0D, 0.0D);
            this.getLevel().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2_ + (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) + (double) f1 * 1.1, 0.0D, 0.0D, 0.0D);
            this.getLevel().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2_ - (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) - (double) f1 * 1.1, 0.0D, 0.0D, 0.0D);

            this.getLevel().addParticle(ParticleTypes.BUBBLE, this.getX() - vector3d.x * (double) f2_ + (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) + (double) f1, 0.0D, 0.0D, 0.0D);
            this.getLevel().addParticle(ParticleTypes.BUBBLE, this.getX() - vector3d.x * (double) f2_ - (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) - (double) f1, 0.0D, 0.0D, 0.0D);
            this.getLevel().addParticle(ParticleTypes.BUBBLE, this.getX() - vector3d.x * (double) f2_ + (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) + (double) f1 * 1.1, 0.0D, 0.0D, 0.0D);
            this.getLevel().addParticle(ParticleTypes.BUBBLE, this.getX() - vector3d.x * (double) f2_ - (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) - (double) f1 * 1.1, 0.0D, 0.0D, 0.0D);
        }
    }

    public ShieldPosition getShieldPosition(int index){
        return SHIELD_POSITIONS.get(index);
    }

    @Override
    public byte getMaxShieldsPerSide(){
        return 5;
    }

    public @Nullable Vec3 applyLeashOffset() {
        return new Vec3(0.0, this.getEyeHeight(), this.getBbWidth() * 0.1F);
    }
}
