package com.talhanation.smallships.world.entity.ship;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Pose;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public class ShipPart<T extends Entity> extends Entity {
    public final T parentShip;
    public final String name;
    private final EntityDimensions size;

    public ShipPart(T parentShip, String string, float f, float g) {
        super(parentShip.getType(), parentShip.getLevel());
        this.size = EntityDimensions.scalable(f, g);
        this.refreshDimensions();
        this.parentShip = parentShip;
        this.name = string;
    }

    protected void defineSynchedData() {
    }

    protected void readAdditionalSaveData(@NotNull CompoundTag tag) {
    }

    protected void addAdditionalSaveData(@NotNull CompoundTag tag) {
    }

    public boolean isPickable() {
        return true;
    }

    @SuppressWarnings("SimplifiableConditionalExpression")
    public boolean hurt(@NotNull DamageSource source, float f) {
        return this.isInvulnerableTo(source) ? false : this.parentShip.hurt(source, f);
    }

    public boolean is(@NotNull Entity entity) {
        return this == entity || this.parentShip == entity;
    }

    public @NotNull Packet<ClientGamePacketListener> getAddEntityPacket() {
        throw new UnsupportedOperationException();
    }

    public @NotNull EntityDimensions getDimensions(@NotNull Pose pose) {
        return this.size;
    }

    public boolean shouldBeSaved() {
        return false;
    }
}
