package com.talhanation.smallships.world.entity.ship.abilities;

import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BannerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;

public interface Bannerable extends Ability {
    BannerPosition getBannerPosition();

    default void tickBannerShip() {
        if (!self().getData(Ship.BANNER).isEmpty()) {
            self().prevBannerWaveAngle = self().bannerWaveAngle;
            self().bannerWaveAngle = (float) Math.sin(this.getBannerWaveSpeed() * (float) self().tickCount) * this.getBannerWaveFactor();
        }
    }

    default void defineBannerShipSynchedData() {
        self().getEntityData().define(Ship.BANNER, ItemStack.EMPTY);
    }

    default void readBannerShipSaveData(CompoundTag tag) {
        Tag bannerTag = tag.get("Banner");
        if (bannerTag instanceof CompoundTag bannerCompound) self().setData(Ship.BANNER, ItemStack.of(bannerCompound));
    }

    default void addBannerShipSaveData(CompoundTag tag) {
        tag.put("Banner", self().getData(Ship.BANNER).save(new CompoundTag()));
    }

    default boolean interactBanner(Player player, InteractionHand interactionHand) {
        ItemStack item = player.getItemInHand(interactionHand);
        ItemStack shipBanner = self().getData(Ship.BANNER);
        shipBanner.setCount(1);
        if (item.getItem() instanceof BannerItem) {
            if (!shipBanner.isEmpty()) self().spawnAtLocation(shipBanner);
            self().setData(Ship.BANNER, item.copy());
            if (!player.isCreative()) item.shrink(1);
            self().getLevel().playSound(player, self().getX(), self().getY() + 4 , self().getZ(), SoundEvents.WOOL_HIT, self().getSoundSource(), 15.0F, 1.0F);
            return true;
        } else if (item.getItem() instanceof ShearsItem && !shipBanner.isEmpty()) {
            self().spawnAtLocation(shipBanner);
            self().setData(Ship.BANNER, ItemStack.EMPTY);
            self().getLevel().playSound(player, self().getX(), self().getY() + 4 , self().getZ(), SoundEvents.WOOL_HIT, self().getSoundSource(), 15.0F, 1.0F);
            return true;
        }
        return false;
    }

    default float getBannerWaveFactor() {
        return self().getLevel().isRaining() ? 4.5F : 3.0F;
    }

    default float getBannerWaveSpeed() {
        return self().getLevel().isRaining() ? 0.55F : 0.25F;
    }

    default float getBannerWaveAngle(float partialTicks) {
        return Mth.lerp(partialTicks, self().prevBannerWaveAngle, self().bannerWaveAngle);
    }

    @SuppressWarnings("ClassCanBeRecord")
    class BannerPosition {
        public final float yp;
        public final float zp;

        public final double x;
        public final double y;
        public final double z;

        public BannerPosition(float yp, float zp, double x, double y, double z) {
            this.yp = yp;
            this.zp = zp;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
