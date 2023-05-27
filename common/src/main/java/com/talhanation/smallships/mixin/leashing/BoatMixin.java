package com.talhanation.smallships.mixin.leashing;

import com.talhanation.smallships.duck.BoatLeashAccess;
import com.talhanation.smallships.world.entity.ship.abilities.Leashable;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.protocol.game.ClientboundSetEntityLinkPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.entity.decoration.LeashFenceKnotEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.UUID;

@Mixin(Boat.class)
public abstract class BoatMixin implements BoatLeashAccess {
    @SuppressWarnings("DataFlowIssue")
    private Boat self() {
        return (Boat)(Object)this;
    }

    private boolean isClientSide() {
        return self().getLevel().isClientSide();
    }

    private static final String LEASH_TAG = "Leash";

    @Nullable
    private Entity leashHolder;

    private int delayedLeashHolderId;

    @Nullable
    private CompoundTag leashInfoTag;

    @Inject(method = "tick", at = @At(value = "HEAD"))
    private void tickLeash(CallbackInfo ci) {
        if (!this.isClientSide() && (self() instanceof Leashable || self().getClass().equals(Boat.class))) {
            this.tickLeash();
        }
    }

    @Inject(method = "addAdditionalSaveData", at = @At(value = "HEAD"))
    private void addAdditionalSaveDataAdditionalShipData(CompoundTag compoundTag, CallbackInfo ci) {
        if (this.leashHolder != null) {
            CompoundTag leashTag = new CompoundTag();
            if (this.leashHolder instanceof LivingEntity) {
                UUID uUID = this.leashHolder.getUUID();
                leashTag.putUUID("UUID", uUID);
            } else if (this.leashHolder instanceof HangingEntity) {
                BlockPos blockPos = ((HangingEntity)this.leashHolder).getPos();
                leashTag.putInt("X", blockPos.getX());
                leashTag.putInt("Y", blockPos.getY());
                leashTag.putInt("Z", blockPos.getZ());
            }

            compoundTag.put(LEASH_TAG, leashTag);
        } else if (this.leashInfoTag != null) {
            compoundTag.put(LEASH_TAG, this.leashInfoTag.copy());
        }
    }

    @Inject(method = "readAdditionalSaveData", at = @At(value = "HEAD"))
    private void readAdditionalSaveDataAdditionalShipData(CompoundTag compoundTag, CallbackInfo ci) {
        if (compoundTag.contains(LEASH_TAG, 10)) {
            this.leashInfoTag = compoundTag.getCompound(LEASH_TAG);
        }
    }

    @Inject(method = "interact", at = @At(value = "HEAD"), cancellable = true)
    private void interactLeashShip(Player player, InteractionHand interactionHand, CallbackInfoReturnable<InteractionResult> cir) {
        if (self() instanceof Leashable || self().getClass().equals(Boat.class)) {
            if (this.getLeashHolder() == player) {
                this.dropLeash(true, !player.getAbilities().instabuild);
                cir.setReturnValue(InteractionResult.sidedSuccess(this.isClientSide()));
            }
            ItemStack itemStack = player.getItemInHand(interactionHand);
            if (itemStack.is(Items.LEAD) && this.canBeLeashed()) {
                this.setLeashedTo(player, true);
                itemStack.shrink(1);
                cir.setReturnValue(InteractionResult.sidedSuccess(this.isClientSide()));
            }
        }
    }

    protected void tickLeash() {
        if (this.leashInfoTag != null) {
            this.restoreLeashFromSave();
        }

        if (this.leashHolder != null) {
            //noinspection DataFlowIssue
            if (!self().isAlive() || !this.leashHolder.isAlive()) {
                this.dropLeash(true, true);
            }
        }

        Entity entity = this.getLeashHolder();
        if (entity != null && entity.getLevel() == self().getLevel()) {
            float distanceToHolderEntity = self().distanceTo(entity);
            if (distanceToHolderEntity > 10.0F) {
                this.dropLeash(true, true);
            } else if (distanceToHolderEntity > 6.0F) {
                double d1 = (entity.getX() - self().getX()) / (double)distanceToHolderEntity;
                double d2 = (entity.getY() - self().getY()) / (double)distanceToHolderEntity;
                double d3 = (entity.getZ() - self().getZ()) / (double)distanceToHolderEntity;
                double shipWeight = self() instanceof Leashable? -((Leashable)self()).getDefaultShipWeight() / (((Leashable)self()).getDefaultShipWeight() + 1) + 1 : 0.4F;
                self().setDeltaMovement(self().getDeltaMovement().add(Math.copySign(d1 * d1 * shipWeight, d1), Math.copySign(d2 * d2 * shipWeight, d2), Math.copySign(d3 * d3 * shipWeight, d3)));
            }
        }
    }

    public void dropLeash(boolean shouldUnlink, boolean shouldDropItem) {
        if (this.leashHolder != null) {
            this.leashHolder = null;
            this.leashInfoTag = null;
            if (!this.isClientSide() && shouldDropItem) {
                self().spawnAtLocation(Items.LEAD, 4);
            }

            if (!this.isClientSide() && shouldUnlink && self().getLevel() instanceof ServerLevel serverLevel) {
                serverLevel.getChunkSource().broadcast(self(), new ClientboundSetEntityLinkPacket(self(), null));
            }
        }

    }

    public boolean canBeLeashed() {
        return !this.isLeashed() && !(self().getFirstPassenger() instanceof Player);
    }

    public boolean isLeashed() {
        return this.leashHolder != null;
    }

    @Nullable
    public Entity getLeashHolder() {
        if (this.leashHolder == null && this.delayedLeashHolderId != 0 && this.isClientSide()) {
            this.leashHolder = self().getLevel().getEntity(this.delayedLeashHolderId);
        }

        return this.leashHolder;
    }

    public void setLeashedTo(Entity entity, boolean shouldLink) {
        this.leashHolder = entity;
        this.leashInfoTag = null;
        if (!this.isClientSide() && shouldLink && self().getLevel() instanceof ServerLevel serverLevel) {
            serverLevel.getChunkSource().broadcast(self(), new ClientboundSetEntityLinkPacket(self(), this.leashHolder));
        }

        if (self().isPassenger()) {
            self().stopRiding();
        }

    }

    public void setDelayedLeashHolderId(int i) {
        this.delayedLeashHolderId = i;
        this.dropLeash(false, false);
    }

    private void restoreLeashFromSave() {
        if (this.leashInfoTag != null && self().getLevel() instanceof ServerLevel serverLevel) {
            if (this.leashInfoTag.hasUUID("UUID")) {
                UUID uUID = this.leashInfoTag.getUUID("UUID");
                Entity entity = serverLevel.getEntity(uUID);
                if (entity != null) {
                    this.setLeashedTo(entity, true);
                    return;
                }
            } else if (this.leashInfoTag.contains("X", 99) && this.leashInfoTag.contains("Y", 99) && this.leashInfoTag.contains("Z", 99)) {
                BlockPos blockPos = NbtUtils.readBlockPos(this.leashInfoTag);
                this.setLeashedTo(LeashFenceKnotEntity.getOrCreateKnot(self().getLevel(), blockPos), true);
                return;
            }

            if (self().tickCount > 100) {
                self().spawnAtLocation(Items.LEAD, 4);
                this.leashInfoTag = null;
            }
        }
    }
}
