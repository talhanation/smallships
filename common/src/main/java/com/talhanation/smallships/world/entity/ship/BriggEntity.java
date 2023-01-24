package com.talhanation.smallships.world.entity.ship;

import com.talhanation.smallships.mixin.BoatAccessor;
import com.talhanation.smallships.world.entity.ModEntityTypes;
import com.talhanation.smallships.world.entity.ship.abilities.Bannerable;
import com.talhanation.smallships.world.entity.ship.abilities.Cannonable;
import com.talhanation.smallships.world.entity.ship.abilities.Repairable;
import com.talhanation.smallships.world.entity.ship.abilities.Sailable;
import com.talhanation.smallships.world.item.ModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public class BriggEntity extends ContainerShip implements Bannerable, Sailable, Cannonable, Repairable {
    public static final String ID = "brigg";
    private static final int ORIGINAL_CONTAINER_SIZE = 108;

    public BriggEntity(EntityType<? extends Boat> entityType, Level level) {
        super(entityType, level, ORIGINAL_CONTAINER_SIZE);
    }

    private BriggEntity(Level level, double d, double e, double f) {
        this(ModEntityTypes.BRIGG, level);
        this.setPos(d, e, f);
        this.xo = d;
        this.yo = e;
        this.zo = f;
        this.setData(CONTAINER_SIZE, ORIGINAL_CONTAINER_SIZE);
    }

    public static BriggEntity summon(Level level, double d, double e, double f) {
        return new BriggEntity(level, d, e, f);
    }

    @Override
    public CompoundTag createDefaultAttributes() {
        Attributes attributes = new Attributes();
        attributes.maxHealth = 150.0F;
        attributes.maxSpeed = 0.07F;
        attributes.maxReverseSpeed = 0.005F;
        attributes.maxRotationSpeed = 0.125F;
        attributes.acceleration = 0.00325F;
        attributes.friction = 0.003F;
        CompoundTag tag = new CompoundTag();
        attributes.addSaveData(tag);
        return tag;
    }

    @Override
    protected int getMaxPassengers() {
        return 10;
    }

    @Override
    public @NotNull Item getDropItem() {
        return ModItems.BRIGG_ITEMS.get(this.getBoatType());
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
                    case(0) -> {
                        d = -1.5F;
                        f = 0.75F;
                    }
                    case(1) -> {
                        d = -1.5F;
                        f = -0.75F;
                    }
                    case(2) -> {
                        d = -0.5F;
                        f = -0.75F;
                    }
                    case(3) -> {
                        d = -0.5F;
                        f = 0.75F;
                    }
                    case(4) -> {
                        d = 0.5F;
                        f = -0.75F;
                    }
                    case(5) -> {
                        d = 0.5F;
                        f = 0.75F;
                    }
                    case(6) -> {
                        d = 1.5F;
                        f = -0.75F;
                    }
                    case(7) -> {
                        d = 1.5F;
                        f = 0.75F;
                    }
                    case(8) -> {
                        d = 2.75F;
                        f = 0.5F;
                    }
                    case(9) -> {
                        d = 2.75F;
                        f = -0.5F;
                    }
                    default -> {
                        d = -1.5F;
                        f = 0.5F;
                    }
                }
            }
            d += 1;

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
    public BannerPosition getBannerPosition() {
        return new BannerPosition(90.0F, 90.0F, -6.4D, 1.65D, 0.0D);
    }

    @Override
    public CannonPosition getCannonPosition() {
        return new CannonPosition(-0.55D, -0.75D, -90.0F);
    }

    @Override
    public byte getMaxCannonCountRight() {
        return 3;
    }

    @Override
    public byte getMaxCannonCountLeft() {
        return 3;
    }
}
