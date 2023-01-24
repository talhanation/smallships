package com.talhanation.smallships.world.entity.ship;

import com.talhanation.smallships.mixin.BoatAccessor;
import com.talhanation.smallships.world.entity.ship.abilities.Bannerable;
import com.talhanation.smallships.world.entity.ship.abilities.Paddleable;
import com.talhanation.smallships.world.entity.ship.abilities.Repairable;
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

public class KhufuEntity extends Ship implements Bannerable, Paddleable, Repairable {
    public static final String ID = "khufu";

    public KhufuEntity(EntityType<? extends Boat> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public CompoundTag createDefaultAttributes() {
        Attributes attributes = new Attributes();
        attributes.maxHealth = 100.0F;
        attributes.maxSpeed = 0.04F;
        attributes.maxReverseSpeed = 0.005F;
        attributes.maxRotationSpeed = 0.2F;
        attributes.acceleration = 0.004F;
        attributes.friction = 0.0035F;
        CompoundTag tag = new CompoundTag();
        attributes.addSaveData(tag);
        return tag;
    }

    @Override
    protected int getMaxPassengers() {
        return 6;
    }

    @Override
    public @NotNull Item getDropItem() {
        return ModItems.COG_ITEMS.get(this.getBoatType());
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

    @Override
    protected float getSinglePassengerXOffset() {
        return -1.75F; // ^ ^ ^+
    }

    // Implement Able-Interfaces
    @Override
    public Bannerable.BannerPosition getBannerPosition() {
        return new Bannerable.BannerPosition(-180.0F, 90.0F, -3.1D, 0.87D, 0.05D);
    }
}
