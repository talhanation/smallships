package com.talhanation.smallships.client.renderer.entity;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import com.mojang.math.Axis;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.client.model.CannonModel;
import com.talhanation.smallships.client.model.ShipModel;
import com.talhanation.smallships.client.model.sail.*;
import com.talhanation.smallships.client.renderer.entity.state.ShipRenderState;
import com.talhanation.smallships.world.entity.projectile.ShipCannon;
import com.talhanation.smallships.world.entity.ship.*;
import com.talhanation.smallships.world.entity.ship.abilities.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.BannerModel;
import net.minecraft.client.model.ShieldModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
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
import net.minecraft.world.item.BannerItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public abstract class  ShipRenderer<T extends Ship> extends EntityRenderer<T, ShipRenderState> {
    protected final Map<Ship.Type, Pair<ResourceLocation, ShipModel<T>>> boatResources;

    public ShipRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius = 0.8F;

        this.boatResources = Stream.of(Ship.Type.values()).collect(ImmutableMap.toImmutableMap(
                (type) -> type,
                (type) -> Pair.of(
                        this.getTextureLocation(type),
                        this.createBoatModel(context, type))));
    }

    @Override
    public @NotNull ShipRenderState createRenderState() {
        return new ShipRenderState();
    }

    @Override
    public void extractRenderState(T entity, ShipRenderState state, float f) {
        super.extractRenderState(entity, state, f);

        state.shipAttributes = entity.getAttributes();
        state.hurtTime = entity.getHurtTime() - f;
        state.hurtDir = entity.getHurtDir();
        state.damage = entity.getDamage() - f;
        state.level = entity.level();
        state.bubbleAngle = entity.getBubbleAngle(f);
        state.waveAngle = entity.getWaveAngle(f);
        state.variant = entity.getVariant();
        state.sunken = entity.isSunken();
        state.yRot = entity.getYRot(f);
        state.rotationSpeed = entity.getRotSpeed();
        state.partialTicks = f;

        state.hasContainer = entity instanceof ContainerShip;
        if (entity instanceof ContainerShip containerShip) {
            state.invFillState = containerShip.getInvFillState();
        }

        if (entity instanceof Cannonable cannonShip) {
            state.cannonable = cannonShip;
        }
        if (entity instanceof Bannerable bannerShip) {
            state.bannerable = bannerShip;
        }
        if (entity instanceof Paddleable) {
            state.isPaddleShip = true;
            state.rowingTimeLeft = entity.getRowingTime(0, f);
            state.rowingTimeRight = entity.getRowingTime(1, f);
        }
        if (entity instanceof Sailable sailShip) {
            state.sailable = sailShip;
        }
        if (entity instanceof Shieldable shieldShip) {
            state.shieldable = shieldShip;
        }
    }

    protected abstract ShipModel<T> createBoatModel(EntityRendererProvider.Context context, Ship.Type type);

    protected ResourceLocation getTextureLocation(Ship.Type type) {
        return ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, "textures/entity/ship/" + ShipRenderer.getNameFromType(type) + ".png");
    }

    @Override
    public void render(ShipRenderState state, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight) {
        Attributes shipAttributes = state.shipAttributes;
        float h = state.hurtTime / ((shipAttributes.maxHealth * state.boundingBoxWidth) / 40.0F);
        float j = state.damage;
        if (j < 0.0F) {
            j = 0.0F;
        } else {
            if (j > shipAttributes.maxHealth * 0.5F) {
                state.level.addParticle(ParticleTypes.LARGE_SMOKE, state.getRandomPosFrom(state.x, 0.5D), state.y + 1.0D, state.getRandomPosFrom(state.z, 0.5D), 0.0D, 0.0D, 0.0D);
            }
        }

        if (h > 0.0F) {
            poseStack.mulPose(Axis.XP.rotationDegrees(Mth.sin(h) * h * j / 10.0F * (float) state.hurtDir));
        }

        float k = state.bubbleAngle;
        if (!Mth.equal(k, 0.0F)) {
            poseStack.mulPose(new Quaternionf().rotateX(k * Mth.DEG_TO_RAD).rotateZ(k * Mth.DEG_TO_RAD));
        }

        float l = state.waveAngle;
        if (!state.sunken && !Mth.equal(l, 0.0F)) {
            poseStack.mulPose(getWaveAngleRotation().rotationDegrees(l));
        }

        Pair<ResourceLocation, ShipModel<T>> pair = this.boatResources.get(state.variant);
        ResourceLocation resourceLocation = pair.getFirst();
        ShipModel<T> shipModel = pair.getSecond();
        poseStack.scale(-1.3F, -1.3F, 1.3F);
        poseStack.mulPose(Axis.YP.rotationDegrees(90.0F + 180.0F));
        shipModel.setupAnim(state);

        if (state.cannonable != null) {
            renderCannon(state, poseStack, multiBufferSource, packedLight);
        }
        if (state.bannerable != null) {
            renderBanner(state, poseStack, multiBufferSource, packedLight);
        }
        if (state.isPaddleShip) {
            renderPaddle(state, poseStack, multiBufferSource, packedLight);
        }
        if (state.sailable != null) {
            renderSail(state, poseStack, multiBufferSource, packedLight);
        }
        if (state.shieldable != null) {
            renderShields(state, poseStack, multiBufferSource, packedLight);
        }


        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(shipModel.renderType(resourceLocation));
        shipModel.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 0xFFFFFFFF);
        poseStack.popPose();

        super.render(state, poseStack, multiBufferSource, packedLight);
    }

    private static final ModelPart cannonModel = CannonModel.createBodyLayer().bakeRoot();

    @SuppressWarnings({"unused"})
    private void renderCannon(ShipRenderState state, PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int packedLight) {
        for (byte i = 0; i < state.cannonable.getCannonCount(); i++) {
            ShipCannon cannon = new ShipCannon(state.cannonable.self(), state.cannonable.getCannonPosition(i));

            poseStack.pushPose();
            poseStack.mulPose(Axis.YN.rotationDegrees(this.getCannonAngleOffset() + cannon.getAngle()));
            poseStack.translate(cannon.isRightSided() ? -cannon.getOffsetX() : cannon.getOffsetX(), -cannon.getOffsetY() + getCannonHeightOffset(), -cannon.getOffsetZ());

            poseStack.scale(0.6F, 0.6F, 0.6F);

            VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.entitySolid(state.cannonable.getTextureLocation()));
            cannonModel.render(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY);

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

    private static final ModelPart bannerModel;
    static {
        ModelPart model = BannerModel.createBodyLayer(false).bakeRoot();
        model.getChild("bar").visible = false;
        bannerModel = model;
    }

    @SuppressWarnings("unused")
    private void renderBanner(ShipRenderState state, PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int packedLight) {
        ItemStack bannerItemStack = state.bannerable.self().getData(Ship.BANNER);
        if (bannerItemStack.getItem() instanceof BannerItem bannerItem) {
            poseStack.pushPose();
            Bannerable.BannerPosition pos = state.bannerable.getBannerPosition();
            poseStack.mulPose(Axis.YP.rotationDegrees(pos.yp));
            poseStack.mulPose(Axis.ZP.rotationDegrees(pos.zp));
            poseStack.translate(pos.x, pos.y, pos.z);
            poseStack.scale(0.5F, 0.5F, 0.5F);

            float bannerWaveAngle = state.bannerable.getBannerWaveAngle(state.partialTicks);

            if (!Mth.equal(bannerWaveAngle, 0F)) {
                poseStack.mulPose(Axis.ZP.rotationDegrees(bannerWaveAngle * 0.5F));
                poseStack.mulPose(Axis.XP.rotationDegrees(bannerWaveAngle));
            }

            BannerPatternLayers bannerPatternLayers = bannerItemStack.getOrDefault(DataComponents.BANNER_PATTERNS, BannerPatternLayers.EMPTY);
            DyeColor dyeColor = bannerItem.getColor();
            BannerRenderer.renderPatterns(poseStack, multiBufferSource, packedLight, OverlayTexture.NO_OVERLAY, bannerModel, ModelBakery.BANNER_BASE, true, dyeColor, bannerPatternLayers);
            poseStack.popPose();
        }
    }

    private static final ShieldModel shieldModel = new ShieldModel(Minecraft.getInstance().getEntityModels().bakeLayer(ModelLayers.SHIELD));

    @SuppressWarnings("unused")
    private void renderShields(ShipRenderState state, PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int packedLight) {
        for (byte i = 0; i < state.shieldable.getShields().size(); i++) {
            ItemStack shieldItemStack = state.shieldable.getShields().get(i);
            if (shieldItemStack.is(Items.SHIELD)) {
                poseStack.pushPose();
                Shieldable.ShieldPosition pos = state.shieldable.getShieldPosition(i);
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

                VertexConsumer vertexConsumer = material.sprite().wrap(ItemRenderer.getFoilBuffer(multiBufferSource, shieldModel.renderType(material.atlasLocation()), true, shieldItemStack.hasFoil()));

                if (flag) {
                    BannerRenderer.renderPatterns(poseStack, multiBufferSource, packedLight, OverlayTexture.NO_OVERLAY, shieldModel.plate(), material, false, Objects.requireNonNullElse(dyeColor, DyeColor.WHITE), bannerPatternLayers, shieldItemStack.hasFoil(), true);
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
    private void renderPaddle(ShipRenderState state, PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int packedLight) {

    }

    private static final Map<Class<? extends Ship>, SailModel> sailModels = new HashMap<>();
    static {
        sailModels.put(CogEntity.class, new CogSailModel());
        sailModels.put(BriggEntity.class, new BriggSailModel());
        sailModels.put(GalleyEntity.class, new GalleySailModel());
        sailModels.put(DrakkarEntity.class, new DrakkarSailModel());
    }

    @SuppressWarnings({"unused"})
    private void renderSail(ShipRenderState state, PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int packedLight) {
        SailModel sailModel = sailModels.get(state.sailable.self().getClass());
        sailModel.setupAnim(state);
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(sailModel.renderType(SailModel.getSailColor(state.sailable.self().getData(Ship.SAIL_COLOR)).location));
        sailModel.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 0xFFFFFFFF);
    }

    public static String getNameFromType(Ship.Type type) {
        return type.getName().replace(":", "/");
    }
}
