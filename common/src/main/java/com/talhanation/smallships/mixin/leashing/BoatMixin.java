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
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.UUID;

@Mixin(Boat.class)
public abstract class BoatMixin implements BoatLeashAccess {
    @Unique private Boat smallships$self() {
        return (Boat)(Object)this;
    }

    @Unique private boolean smallships$isClientSide() {
        return smallships$self().level().isClientSide();
    }

    @Unique private static final String LEASH_TAG = "Leash";

    @Unique @Nullable private Entity smallships$leashHolder;

    @Unique private int smallships$delayedLeashHolderId;

    @Unique @Nullable private CompoundTag smallships$leashInfoTag;

    @Inject(method = "tick", at = @At(value = "HEAD"))
    private void tickLeash(CallbackInfo ci) {
        if (!this.smallships$isClientSide() && (smallships$self() instanceof Leashable || smallships$self().getClass().equals(Boat.class))) {
            this.smallships$tickLeash();
        }
    }

    @Inject(method = "addAdditionalSaveData", at = @At(value = "HEAD"))
    private void addAdditionalSaveDataAdditionalShipData(CompoundTag compoundTag, CallbackInfo ci) {
        if (this.smallships$leashHolder != null) {
            CompoundTag leashTag = new CompoundTag();
            if (this.smallships$leashHolder instanceof LivingEntity) {
                UUID uUID = this.smallships$leashHolder.getUUID();
                leashTag.putUUID("UUID", uUID);
            } else if (this.smallships$leashHolder instanceof HangingEntity) {
                BlockPos blockPos = ((HangingEntity)this.smallships$leashHolder).getPos();
                leashTag.putInt("X", blockPos.getX());
                leashTag.putInt("Y", blockPos.getY());
                leashTag.putInt("Z", blockPos.getZ());
            }

            compoundTag.put(LEASH_TAG, leashTag);
        } else if (this.smallships$leashInfoTag != null) {
            compoundTag.put(LEASH_TAG, this.smallships$leashInfoTag.copy());
        }
    }

    @Inject(method = "readAdditionalSaveData", at = @At(value = "HEAD"))
    private void readAdditionalSaveDataAdditionalShipData(CompoundTag compoundTag, CallbackInfo ci) {
        if (compoundTag.contains(LEASH_TAG, 10)) {
            this.smallships$leashInfoTag = compoundTag.getCompound(LEASH_TAG);
        }
    }

    @Inject(method = "interact", at = @At(value = "HEAD"), cancellable = true)
    private void interactLeashShip(Player player, InteractionHand interactionHand, CallbackInfoReturnable<InteractionResult> cir) {
        if (smallships$self() instanceof Leashable || smallships$self().getClass().equals(Boat.class)) {
            if (this.smallships$getLeashHolder() == player) {
                this.smallships$dropLeash(true, !player.getAbilities().instabuild);
                cir.setReturnValue(InteractionResult.sidedSuccess(this.smallships$isClientSide()));
            }
            ItemStack itemStack = player.getItemInHand(interactionHand);
            if (itemStack.is(Items.LEAD) && this.smallships$canBeLeashed()) {
                this.smallships$setLeashedTo(player, true);
                itemStack.shrink(1);
                cir.setReturnValue(InteractionResult.sidedSuccess(this.smallships$isClientSide()));
            }
        }
    }

    @Unique
    protected void smallships$tickLeash() {
        if (this.smallships$leashInfoTag != null) {
            this.smallships$restoreLeashFromSave();
        }

        if (this.smallships$leashHolder != null) {
            //noinspection DataFlowIssue
            if (!smallships$self().isAlive() || !this.smallships$leashHolder.isAlive()) {
                this.smallships$dropLeash(true, true);
            }
        }

        Entity entity = this.smallships$getLeashHolder();
        if (entity != null && entity.level() == smallships$self().level()) {
            float distanceToHolderEntity = smallships$self().distanceTo(entity);
            if (distanceToHolderEntity > 10.0F) {
                this.smallships$dropLeash(true, true);
            } else if (distanceToHolderEntity > 6.0F) {
                double d1 = (entity.getX() - smallships$self().getX()) / (double)distanceToHolderEntity;
                double d2 = (entity.getY() - smallships$self().getY()) / (double)distanceToHolderEntity;
                double d3 = (entity.getZ() - smallships$self().getZ()) / (double)distanceToHolderEntity;
                double shipWeight = smallships$self() instanceof Leashable? -((Leashable) smallships$self()).getDefaultShipWeight() / (((Leashable) smallships$self()).getDefaultShipWeight() + 1) + 1 : 0.4F;
                smallships$self().setDeltaMovement(smallships$self().getDeltaMovement().add(Math.copySign(d1 * d1 * shipWeight, d1), Math.copySign(d2 * d2 * shipWeight, d2), Math.copySign(d3 * d3 * shipWeight, d3)));
            }
        }
    }

    public void smallships$dropLeash(boolean shouldUnlink, boolean shouldDropItem) {
        if (this.smallships$leashHolder != null) {
            this.smallships$leashHolder = null;
            this.smallships$leashInfoTag = null;
            if (!this.smallships$isClientSide() && shouldDropItem) {
                smallships$self().spawnAtLocation(Items.LEAD, 4);
            }

            if (!this.smallships$isClientSide() && shouldUnlink && smallships$self().level() instanceof ServerLevel serverLevel) {
                serverLevel.getChunkSource().broadcast(smallships$self(), new ClientboundSetEntityLinkPacket(smallships$self(), null));
            }
        }

    }

    @Unique
    public boolean smallships$canBeLeashed() {
        return !this.smallships$isLeashed() && !(smallships$self().getFirstPassenger() instanceof Player);
    }

    public boolean smallships$isLeashed() {
        return this.smallships$leashHolder != null;
    }

    @Nullable
    public Entity smallships$getLeashHolder() {
        if (this.smallships$leashHolder == null && this.smallships$delayedLeashHolderId != 0 && this.smallships$isClientSide()) {
            this.smallships$leashHolder = smallships$self().level().getEntity(this.smallships$delayedLeashHolderId);
        }

        return this.smallships$leashHolder;
    }

    public void smallships$setLeashedTo(Entity entity, boolean shouldLink) {
        this.smallships$leashHolder = entity;
        this.smallships$leashInfoTag = null;
        if (!this.smallships$isClientSide() && shouldLink && smallships$self().level() instanceof ServerLevel serverLevel) {
            serverLevel.getChunkSource().broadcast(smallships$self(), new ClientboundSetEntityLinkPacket(smallships$self(), this.smallships$leashHolder));
        }

        if (smallships$self().isPassenger()) {
            smallships$self().stopRiding();
        }

    }

    public void smallships$setDelayedLeashHolderId(int i) {
        this.smallships$delayedLeashHolderId = i;
        this.smallships$dropLeash(false, false);
    }

    @Unique
    private void smallships$restoreLeashFromSave() {
        if (this.smallships$leashInfoTag != null && smallships$self().level() instanceof ServerLevel serverLevel) {
            assert this.smallships$leashInfoTag != null;
            if (this.smallships$leashInfoTag.hasUUID("UUID")) {
                UUID uUID = this.smallships$leashInfoTag.getUUID("UUID");
                Entity entity = serverLevel.getEntity(uUID);
                if (entity != null) {
                    this.smallships$setLeashedTo(entity, true);
                    return;
                }
            } else if (this.smallships$leashInfoTag.contains("X", 99) && this.smallships$leashInfoTag.contains("Y", 99) && this.smallships$leashInfoTag.contains("Z", 99)) {
                BlockPos blockPos = NbtUtils.readBlockPos(this.smallships$leashInfoTag);
                this.smallships$setLeashedTo(LeashFenceKnotEntity.getOrCreateKnot(smallships$self().level(), blockPos), true);
                return;
            }

            if (smallships$self().tickCount > 100) {
                smallships$self().spawnAtLocation(Items.LEAD, 4);
                this.smallships$leashInfoTag = null;
            }
        }
    }
}
