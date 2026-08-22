package com.talhanation.smallships.client.renderer.entity;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import com.mojang.math.Axis;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.api.client.ShipRenderRegistry;
import com.talhanation.smallships.client.model.CannonModel;
import com.talhanation.smallships.client.model.ShipModel;
import com.talhanation.smallships.client.model.sail.SailModel;
import com.talhanation.smallships.client.model.sail.banner.MastBannerModel;
import com.talhanation.smallships.client.model.sail.banner.SailBannerModel;
import com.talhanation.smallships.world.entity.cannon.ShipCannon;
import com.talhanation.smallships.world.entity.ship.*;
import com.talhanation.smallships.world.entity.ship.abilities.*;
import com.talhanation.smallships.world.entity.ship.sail.SailDamage;
import com.talhanation.smallships.client.cannon.CannonAimHandler;
import com.talhanation.smallships.client.cannon.CannonTrajectory;
import com.talhanation.smallships.client.wind.ClientWindManager;
import net.minecraft.world.phys.Vec3;
import com.talhanation.smallships.config.SmallShipsConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ShieldModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BannerRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.BannerItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public abstract class  ShipRenderer<T extends Ship> extends EntityRenderer<T> {
    protected final Map<Boat.Type, Pair<ResourceLocation, ShipModel<T>>> boatResources;

    public ShipRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius = 0.8F;

        this.boatResources = Stream.of(Boat.Type.values()).collect(ImmutableMap.toImmutableMap(
                (type) -> type,
                (type) -> Pair.of(
                        this.getTextureLocation(type),
                        this.createBoatModel(context, type))));
    }

    protected abstract ShipModel<T> createBoatModel(EntityRendererProvider.Context context, Boat.Type type);

    protected ResourceLocation getTextureLocation(Boat.Type type) {
        return ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, "textures/entity/ship/" + ShipRenderer.getNameFromType(type) + ".png");
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull T shipEntity) {
        return this.boatResources.get(shipEntity.getVariant()).getFirst();
    }

    @Override
    public void render(T shipEntity, float entityYaw, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int packedLight) {
        Attributes shipAttributes = shipEntity.getAttributes();
        float h = ((float) shipEntity.getHurtTime() - partialTicks) / ((shipAttributes.maxHealth * shipEntity.getBbWidth()) / 40.0F);
        float j = shipEntity.getDamage() - partialTicks;
        if (j < 0.0F) {
            j = 0.0F;
        } else {
            if (j > shipAttributes.maxHealth * 0.5F) {
                shipEntity.level().addParticle(ParticleTypes.LARGE_SMOKE, shipEntity.getRandomX(0.5D), shipEntity.getY() + 1.0D, shipEntity.getRandomZ(0.5D), 0.0D, 0.0D, 0.0D);
            }
        }

        if (h > 0.0F) {
            poseStack.mulPose(Axis.XP.rotationDegrees(Mth.sin(h) * h * j / 10.0F * (float) shipEntity.getHurtDir()));
        }

        float k = shipEntity.getBubbleAngle(partialTicks);
        if (!Mth.equal(k, 0.0F)) {
            poseStack.mulPose(new Quaternionf().rotateX(k * Mth.DEG_TO_RAD).rotateZ(k * Mth.DEG_TO_RAD));
        }

        float l = shipEntity.getWaveAngle(partialTicks);
        if (!shipEntity.isSunken() && !Mth.equal(l, 0.0F)) {
            poseStack.mulPose(getWaveAngleRotation().rotationDegrees(l));
        }

        Pair<ResourceLocation, ShipModel<T>> pair = this.boatResources.get(shipEntity.getVariant());
        ResourceLocation resourceLocation = pair.getFirst();
        ShipModel<T> shipModel = pair.getSecond();
        poseStack.scale(-1.3F, -1.3F, 1.3F);
        poseStack.mulPose(Axis.YP.rotationDegrees(90.0F + 180.0F));
        shipModel.setupAnim(shipEntity, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F);

        if (shipEntity instanceof Cannonable cannonShipEntity) {
            renderCannon(cannonShipEntity, entityYaw, partialTicks, poseStack, multiBufferSource, packedLight);
        }
        if (shipEntity instanceof Bannerable bannerShipEntity) {
            renderBanner(bannerShipEntity, entityYaw, partialTicks, poseStack, multiBufferSource, packedLight);
            renderSailBanner(bannerShipEntity, entityYaw, partialTicks, poseStack, multiBufferSource, packedLight);
        }
        if (shipEntity instanceof Paddleable paddleShipEntity) {
            renderPaddle(paddleShipEntity, entityYaw, partialTicks, poseStack, multiBufferSource, packedLight);
        }
        if (shipEntity instanceof Sailable sailShipEntity) {
            renderSail(sailShipEntity, entityYaw, partialTicks, poseStack, multiBufferSource, packedLight);
        }
        if (shipEntity instanceof Shieldable shieldShipEntity) {
            renderShields(shieldShipEntity, entityYaw, partialTicks, poseStack, multiBufferSource, packedLight);
        }


        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(shipModel.renderType(resourceLocation));
        shipModel.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 0xFFFFFFFF);
        poseStack.popPose();

        super.render(shipEntity, entityYaw, partialTicks, poseStack, multiBufferSource, packedLight);
    }

    private static final CannonModel cannonModel = new CannonModel();

    /**
     * Dockyard preview only: a cannon slot drawn on the model although nothing
     * is mounted there, so the player can see where the gun he is hovering over
     * would end up.
     *
     * Static because it is set for a single draw call from the screen and
     * cleared right after - the world is already rendered by the time a screen
     * draws, so the ghost never reaches the ship floating outside.
     */
    private static int ghostCannonSlot = -1;

    /**
     * Flat white, mostly opaque and steady - no pulse.
     *
     * The alpha stays high on purpose: the ghost is blended against the
     * dockyards' black preview panel, so a faint white does not read as "see
     * through" there, it reads as a black gun. Short of solid so it still tells
     * itself apart from the guns that are actually mounted.
     */
    private static final int GHOST_COLOR = 0xD8FFFFFF;

    public static void setGhostCannon(int slot) {
        ghostCannonSlot = slot;
    }

    public static void clearGhostCannon() {
        ghostCannonSlot = -1;
    }
    @SuppressWarnings({"unused"})
    private void renderCannon(Cannonable cannonShipEntity, float entityYaw, float partialTicks, PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int packedLight) {
        for(int slot = 0; slot < cannonShipEntity.getTotalCannonSlots(); slot++){
            boolean mounted = cannonShipEntity.isCannonInSlot(slot);
            boolean ghost = !mounted && slot == ghostCannonSlot;
            if (!mounted && !ghost) continue;
            ShipCannon cannon = new ShipCannon(cannonShipEntity.self(), cannonShipEntity.getCannonPosition(slot), slot);

            // per-cannon aim (gunner) with broadside fallback (driver)
            float aimRotation = cannonShipEntity.getCannonRotation(slot, cannon.isRightSided());
            float aimAngle = cannonShipEntity.getCannonAngle(slot, cannon.isRightSided());

            poseStack.pushPose();
            poseStack.mulPose(Axis.YN.rotationDegrees(this.getCannonAngleOffset() + cannon.getAngle()));
            poseStack.translate(cannon.isRightSided() ? -cannon.getOffsetX() : cannon.getOffsetX(), -cannon.getOffsetY() + getCannonHeightOffset(), -cannon.getOffsetZ());

            // aim rotation around the cannon's OWN vertical axis (after the translate!)
            poseStack.mulPose(Axis.YN.rotationDegrees(cannon.isRightSided() ? -aimRotation : aimRotation));

            // right click aim mode: white trajectory line, rendered INSIDE the
            // cannon pose like the SiegeWeapons ballista - it follows every ship
            // rotation and the cannon aim automatically. The hull scale (-1.3)
            // is normalized away so the ballista math applies 1:1.
            if (!ghost && CannonAimHandler.isAimingShip(cannonShipEntity.self())
                    && (CannonAimHandler.getAimSlot() >= 0
                    ? slot == CannonAimHandler.getAimSlot()
                    : cannon.isRightSided() == CannonAimHandler.getAimSide())) {
                poseStack.pushPose();
                poseStack.scale(1.0F / 1.3F, 1.0F / 1.3F, 1.0F / 1.3F);
                VertexConsumer lineConsumer = multiBufferSource.getBuffer(RenderType.lines());
                float previewSpeed = CannonTrajectory.CANNON_SPEED * cannonShipEntity.getShotSpeedMultiplier(true);
                // the line fades out towards its far end instead of being cut at
                // the water surface, so no fluid lookup is needed here
                CannonTrajectory.render(poseStack, lineConsumer, CannonTrajectory.calculateLocal(aimAngle, previewSpeed));
                poseStack.popPose();
            }

            poseStack.scale(0.6F, 0.6F, 0.6F);

            // barrel elevation, mc pitch convention (negative = up)
            cannonModel.setLaufPitch(-aimAngle);

            // a ghost has to go through a translucent render type: entitySolid
            // discards the alpha channel and would draw it fully opaque
            VertexConsumer vertexConsumer = multiBufferSource.getBuffer(ghost
                    ? RenderType.entityTranslucent(cannonShipEntity.getTextureLocation())
                    : RenderType.entitySolid(cannonShipEntity.getTextureLocation()));
            cannonModel.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY,
                    ghost ? GHOST_COLOR : 0xFFFFFFFF);

            poseStack.popPose();
        }
    }

    /*********************************************************
     * Offset for Cannon Render:
     * - Positive values will turn the cannon clockwise
     * - Negative values will turn the cannon counter-clockwise
     *********************************************************/
    protected float getCannonAngleOffset() {
        return 0;
    }

    /*********************************************************
     * Offset for Cannon Render:
     * - Positive values will decrease the height
     * - Negative values will increase the height
     *********************************************************/
    protected float getCannonHeightOffset(){
        return 0;
    }

    @SuppressWarnings("unused")
    private void renderBanner(Bannerable bannerShipEntity, float entityYaw, float partialTicks, PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int packedLight) {
        ItemStack bannerItemStack = bannerShipEntity.self().getData(Ship.BANNER);
        if (!(bannerItemStack.getItem() instanceof BannerItem)) return;

        MastBannerModel mastBannerModel = ShipRenderRegistry.getMastBanner(bannerShipEntity.self().getClass());
        if (mastBannerModel == null) return;

        float windOffset = 0.0F;
        if (SmallShipsConfig.Common.windEnable.get() && SmallShipsConfig.Client.windBannerEnable.get()) {
            windOffset = Mth.wrapDegrees(ClientWindManager.getDirection(partialTicks) - entityYaw - 180.0F);
        }

        mastBannerModel.setupAnim(windOffset, bannerShipEntity.getBannerWaveAngle(partialTicks));
        mastBannerModel.render(bannerShipEntity.self(), bannerItemStack, poseStack, multiBufferSource, packedLight);
    }

    private static final ShieldModel shieldModel = new ShieldModel(Minecraft.getInstance().getEntityModels().bakeLayer(ModelLayers.SHIELD));
    @SuppressWarnings("unused")
    private void renderShields(Shieldable shieldShipEntity, float entityYaw, float partialTicks, PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int packedLight) {
        for(byte i = 0; i < shieldShipEntity.getShields().size(); i++){
            ItemStack shieldItemStack = shieldShipEntity.getShields().get(i);
            if(shieldItemStack.is(Items.SHIELD)){
                poseStack.pushPose();
                Shieldable.ShieldPosition pos = shieldShipEntity.getShieldPosition(i);
                poseStack.translate(pos.x, pos.y, pos.z);
                poseStack.scale(0.8F, -0.8F, -0.8F);
                if (pos.isRightSided) poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
                poseStack.mulPose(Axis.XP.rotationDegrees(20.0F));
                poseStack.mulPose(Axis.ZP.rotationDegrees(180.0F));
                //Taken from BlockEntityWithoutLevelRenderer
                BannerPatternLayers bannerPatternLayers = shieldItemStack.getOrDefault(DataComponents.BANNER_PATTERNS, BannerPatternLayers.EMPTY);
                DyeColor dyeColor = shieldItemStack.get(DataComponents.BASE_COLOR);
                boolean flag = !bannerPatternLayers.layers().isEmpty() || dyeColor != null;
                Material material = flag ? ModelBakery.SHIELD_BASE : ModelBakery.NO_PATTERN_SHIELD;

                VertexConsumer vertexConsumer = material.sprite().wrap(ItemRenderer.getFoilBufferDirect(multiBufferSource, shieldModel.renderType(material.atlasLocation()), true, shieldItemStack.hasFoil()));

                if (flag) {
                    BannerRenderer.renderPatterns(poseStack, multiBufferSource, packedLight, OverlayTexture.NO_OVERLAY, shieldModel.plate(), material, false, Objects.requireNonNullElse(dyeColor, DyeColor.WHITE), bannerPatternLayers, shieldItemStack.hasFoil());
                } else {
                    shieldModel.plate().render(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 0xFFFFFFFF);
                }
                shieldModel.handle().render(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 0xFFFFFFFF);
                poseStack.popPose();
            }
        }
    }


    public Axis getWaveAngleRotation(){
        return Axis.ZN;
    }

    @SuppressWarnings({"unused", "EmptyMethod"})
    private void renderPaddle(Paddleable paddleShipEntity, float entityYaw, float partialTicks, PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int packedLight) {

    }

    @SuppressWarnings({"unused", "unchecked"})
    private void renderSail(Sailable sailShipEntity, float entityYaw, float partialTicks, PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int packedLight) {
        // sail damage system: destroyed sails are not rendered at all,
        // torn sails (50 HP or below) use the damaged texture variant
        SailDamage.State sailState = SailDamage.getState(sailShipEntity.self());
        if (sailState == SailDamage.State.DESTROYED) return;
        // a ship without a registered sail model just gets no sail layer
        SailModel sailModel = ShipRenderRegistry.getSail(sailShipEntity.self().getClass());
        if (sailModel == null) return;
        sailModel.setupAnim(((T)sailShipEntity), partialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
        SailModel.Color sailColor = SailModel.getSailColor(sailShipEntity.self().getData(Ship.SAIL_COLOR));
        ResourceLocation sailTexture = sailState == SailDamage.State.TORN ? sailColor.damagedLocation : sailColor.location;
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(sailTexture));
        sailModel.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 0xFFFFFFFF);
    }

    @SuppressWarnings({"unused", "unchecked"})
    private void renderSailBanner(Bannerable bannerShipEntity, float entityYaw, float partialTicks, PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int packedLight) {
        SailDamage.State sailState = SailDamage.getState(bannerShipEntity.self());
        if (sailState == SailDamage.State.DESTROYED) return;

        SailBannerModel sailModel = ShipRenderRegistry.getSailBanner(bannerShipEntity.self().getClass());

        if(sailModel == null) return;

        ItemStack banner = bannerShipEntity.self().getData(Ship.SAIL_BANNER);
        if (banner.isEmpty()) return;
        sailModel.render(bannerShipEntity.self(), banner, poseStack, multiBufferSource, packedLight);
    }

    public static String getNameFromType(Boat.Type type) {
        return type.getName().replace(":", "/");
    }
}