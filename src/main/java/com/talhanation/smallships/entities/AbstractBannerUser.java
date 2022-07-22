package com.talhanation.smallships.entities;

import com.mojang.blaze3d.vertex.PoseStack;
import com.talhanation.smallships.client.render.RenderBanner;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BannerRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraftforge.fmllegacy.network.NetworkHooks;

public abstract class AbstractBannerUser extends AbstractInventoryEntity {
    private static final EntityDataAccessor<Boolean> HAS_BANNER = SynchedEntityData.defineId(AbstractBannerUser.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<ItemStack> BANNER = SynchedEntityData.defineId(AbstractBannerUser.class, EntityDataSerializers.ITEM_STACK);

    private float bannerWaveAngle;
    private float prevBannerWaveAngle;

    public AbstractBannerUser(EntityType<? extends AbstractBannerUser> type, Level world) {
        super(type, world);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(HAS_BANNER, false);
        this.entityData.define(BANNER, Items.WHITE_BANNER.getDefaultInstance());

    }

    ////////////////////////////////////TICK////////////////////////////////////

    @Override
    public void tick() {
        super.tick();
        //for banner wave
        if(getHasBanner()) {
            this.prevBannerWaveAngle = this.bannerWaveAngle;
            this.bannerWaveAngle = (float) Math.sin(getBannerWaveSpeed() * (float) tickCount) * getBannerWaveFactor();
        }
    }

    ////////////////////////////////////REGISTER////////////////////////////////////

    @Override
    public void addAdditionalSaveData(CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.put("banner", getBanner().serializeNBT());
        nbt.putBoolean("hasbanner", getHasBanner());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        if (nbt.contains("hasbanner")) this.setHasBanner(nbt.getBoolean("hasbanner"));
        final Tag banner = nbt.get("banner");
        if (banner instanceof CompoundTag) {
            entityData.set(BANNER, ItemStack.of((CompoundTag) banner));
        }

    }

    ////////////////////////////////////GET////////////////////////////////////

    public boolean getHasBanner(){
        return entityData.get(HAS_BANNER);
    }

    public ItemStack getBanner() {
        return entityData.get(BANNER);
    }

    public float getBannerWaveFactor() {
        return level.isRaining() ? 4.5F : 3.0F;
    }

    public float getBannerWaveSpeed() {
        return level.isRaining() ? 0.55F : 0.25F;
    }

    public float getBannerWaveAngle(float partialTicks) {
        return Mth.lerp(partialTicks, this.prevBannerWaveAngle, this.bannerWaveAngle);
    }

    ////////////////////////////////////SET////////////////////////////////////

    public void setBanner(Player player, ItemStack banner) {
        playBannerSound();
        setHasBanner(true);
        entityData.set(BANNER, banner.copy());
        if (!player.isCreative()) {
            banner.shrink(1);
        }
    }

    public void setHasBanner(boolean bool){
        entityData.set(HAS_BANNER, bool);
    }


    ////////////////////////////////////SOUND////////////////////////////////////

    public void playBannerSound() {
            this.level.playSound(null, this.getX(), this.getY() + 4 , this.getZ(),SoundEvents.WOOL_HIT, this.getSoundSource(), 15.0F, 0.8F + 0.4F * this.random.nextFloat());
        }

    ////////////////////////////////////ON FUNCTIONS////////////////////////////////////

    public boolean onInteractionWithBanner(ItemStack banner, Player player) {
            if (getHasBanner())
                dropBanner();

        setBanner(player,banner);
        return true;
    }

    public void onInteractionWithShears(Player playerEntity) {
            if (getHasBanner()) {
                dropBanner();
                setHasBanner(false);
            }
    }

    ////////////////////////////////////OTHER FUNCTIONS////////////////////////////////////

    public void renderBanner(PoseStack matrixStack, MultiBufferSource buffer ,int packedLight, float partialTicks) {
        if (getHasBanner()) {
            RenderBanner.renderBanner(this, partialTicks, matrixStack, buffer, getBanner(), packedLight, BannerRenderer.createBodyLayer().bakeRoot());
        }
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    public void dropBanner() {
        if (getHasBanner()) {
            getBanner().setCount(1);
            this.spawnAtLocation(getBanner(),  3F );
        }
    }
}
