package com.talhanation.smallships.client.renderer.entity;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import com.mojang.math.Axis;
import com.talhanation.smallships.client.model.CannonModel;
import com.talhanation.smallships.client.model.ShipModel;
import com.talhanation.smallships.client.model.sail.*;
import com.talhanation.smallships.duck.BoatLeashAccess;
import com.talhanation.smallships.world.entity.projectile.Cannon;
import com.talhanation.smallships.world.entity.ship.*;
import com.talhanation.smallships.world.entity.ship.abilities.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ShieldModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BannerRenderer;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Vec3i;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.*;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.entity.BannerBlockEntity;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.joml.Quaternionf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import static net.minecraft.client.renderer.entity.MobRenderer.addVertexPair;

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

    protected abstract ResourceLocation getTextureLocation(Boat.Type type);

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
        if (!Mth.equal(l, 0.0F)) {
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
        shipModel.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        poseStack.popPose();

        super.render(shipEntity, entityYaw, partialTicks, poseStack, multiBufferSource, packedLight);

        // Pose stack stuff is so weird, that the leash will only render if it's rendered here. Would love to fix this jankiness about models.
        if (shipEntity instanceof Leashable leashShipEntity) {
            renderLeash(leashShipEntity, entityYaw, partialTicks, poseStack, multiBufferSource, packedLight);
        }
    }

    @SuppressWarnings({"unused", "unchecked"})
    private void renderCannon(Cannonable cannonShipEntity, float entityYaw, float partialTicks, PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int packedLight) {
        for(byte i = 0; i < cannonShipEntity.getCannonCount(); i++){
            Cannon cannon = new Cannon(cannonShipEntity.self(), cannonShipEntity.getCannonPosition(i));

            poseStack.pushPose();
            poseStack.mulPose(Axis.YN.rotationDegrees(this.getCannonAngleOffset() + cannon.getAngle()));
            poseStack.translate(cannon.isRightSided() ? -cannon.getOffsetX() : cannon.getOffsetX(), -cannon.getOffsetY() + getCannonHeightOffset(), -cannon.getOffsetZ());

            poseStack.scale(0.6F, 0.6F, 0.6F);

            CannonModel cannonModel = new CannonModel();
            cannonModel.setupAnim((T)cannonShipEntity, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
            VertexConsumer vertexConsumer = multiBufferSource.getBuffer(cannonModel.renderType(cannonShipEntity.getTextureLocation()));
            cannonModel.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
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
        ModelPart model = BannerRenderer.createBodyLayer().bakeRoot();
        model.getChild("pole").visible = false;
        model.getChild("bar").visible = false;
        bannerModel = model;
    }
    @SuppressWarnings("unused")
    private void renderBanner(Bannerable bannerShipEntity, float entityYaw, float partialTicks, PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int packedLight) {
        ItemStack item = bannerShipEntity.self().getData(Ship.BANNER);
        if (item.getItem() instanceof BannerItem bannerItem) {
            poseStack.pushPose();
            Bannerable.BannerPosition pos = bannerShipEntity.getBannerPosition();
            poseStack.mulPose(Axis.YP.rotationDegrees(pos.yp));
            poseStack.mulPose(Axis.ZP.rotationDegrees(pos.zp));
            poseStack.translate(pos.x, pos.y, pos.z);
            poseStack.scale(0.5F, 0.5F, 0.5F);

            float bannerWaveAngle = bannerShipEntity.getBannerWaveAngle(partialTicks);
            if (!Mth.equal(bannerWaveAngle, 0F)) poseStack.mulPose(Axis.XP.rotationDegrees(bannerWaveAngle));

            List<Pair<Holder<BannerPattern>, DyeColor>> patterns = BannerBlockEntity.createPatterns(bannerItem.getColor(), BannerBlockEntity.getItemPatterns(item));
            BannerRenderer.renderPatterns(poseStack, multiBufferSource, packedLight, OverlayTexture.NO_OVERLAY, bannerModel, ModelBakery.BANNER_BASE, true, patterns);
            poseStack.popPose();
        }
    }

    private static final ShieldModel shieldModel = new ShieldModel(Minecraft.getInstance().getEntityModels().bakeLayer(ModelLayers.SHIELD));
    @SuppressWarnings("unused")
    private void renderShields(Shieldable shieldShipEntity, float entityYaw, float partialTicks, PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int packedLight) {
        for(byte i = 0; i < shieldShipEntity.getShields().size(); i++){
            ItemStack itemStack = shieldShipEntity.getShields().get(i);
            if(itemStack.is(Items.SHIELD)){
                poseStack.pushPose();
                Shieldable.ShieldPosition pos = shieldShipEntity.getShieldPosition(i);
                poseStack.translate(pos.x, pos.y, pos.z);
                poseStack.scale(1.0F, -1.0F, -1.0F);
                if (pos.isRightSided) poseStack.mulPose(Vector3f.YP.rotationDegrees(180.0F));
                poseStack.mulPose(Vector3f.XP.rotationDegrees(30.0F));


                //Taken from BlockEntityWithoutLevelRenderer
                boolean flag = BlockItem.getBlockEntityData(itemStack) != null;

                Material material = flag ? ModelBakery.SHIELD_BASE : ModelBakery.NO_PATTERN_SHIELD;
                VertexConsumer vertexConsumer;
                try (TextureAtlasSprite sprite = material.sprite()) {
                    vertexConsumer = sprite.wrap(ItemRenderer.getFoilBufferDirect(multiBufferSource, shieldModel.renderType(material.atlasLocation()), true, itemStack.hasFoil()));
                }

                if (flag) {
                    List<Pair<Holder<BannerPattern>, DyeColor>> patterns = BannerBlockEntity.createPatterns(ShieldItem.getColor(itemStack), BannerBlockEntity.getItemPatterns(itemStack));
                    BannerRenderer.renderPatterns(poseStack, multiBufferSource, packedLight, OverlayTexture.NO_OVERLAY, shieldModel.plate(), material, false, patterns, itemStack.hasFoil());
                } else {
                    shieldModel.plate().render(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
                }

                poseStack.popPose();
            }
        }
    }


    public Vector3f getWaveAngleRotation(){
        return Vector3f.XN;
    }

    @SuppressWarnings({"unused", "EmptyMethod"})
    private void renderPaddle(Paddleable paddleShipEntity, float entityYaw, float partialTicks, PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int packedLight) {

    }

    private static final Map<Class<? extends Ship>, SailModel> sailModels = new HashMap<>();
    static {
        sailModels.put(CogEntity.class, new CogSailModel());
        sailModels.put(BriggEntity.class, new BriggSailModel());
        sailModels.put(GalleyEntity.class, new GalleySailModel());
        sailModels.put(DrakkarEntity.class, new DrakkarSailModel());
    }
    @SuppressWarnings({"unused", "unchecked"})
    private void renderSail(Sailable sailShipEntity, float entityYaw, float partialTicks, PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int packedLight) {
        SailModel sailModel = sailModels.get(sailShipEntity.getClass());
        sailModel.setupAnim(((T)sailShipEntity), partialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(sailModel.renderType(SailModel.getSailColor(sailShipEntity.self().getData(Ship.SAIL_COLOR)).location));
        sailModel.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
    }

    @SuppressWarnings("SimplifiableConditionalExpression")
    @Override
    public boolean shouldRender(T ship, Frustum frustum, double d, double e, double f) {
        if (super.shouldRender(ship, frustum, d, e, f)) {
            return true;
        } else if (ship instanceof Leashable) {
            Entity entity = ((BoatLeashAccess)ship).getLeashHolder();
            return entity != null ? frustum.isVisible(entity.getBoundingBoxForCulling()) : false;
        }
        return false;
    }
    @SuppressWarnings({"unused", "unchecked"})
    private void renderLeash(Leashable leashShipEntity, float entityYaw, float partialTicks, PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int packedLight) {
        Entity leashHolderEntity = ((BoatLeashAccess)leashShipEntity).getLeashHolder();
        if (leashHolderEntity == null) return;
        poseStack.pushPose();
        Vec3 vec3 = leashHolderEntity.getRopeHoldPosition(partialTicks);
        double d = (Mth.lerp(partialTicks, 0.0D, 0.0D) * 0.017453292F) + 1.5707963267948966;
        Vec3 vec32 = ((T)leashShipEntity).getLeashOffset(0.0F);
        double e = Math.cos(d) * vec32.z + Math.sin(d) * vec32.x;
        double g = Math.sin(d) * vec32.z - Math.cos(d) * vec32.x;
        double h = Mth.lerp(partialTicks, ((T)leashShipEntity).xo, ((T)leashShipEntity).getX()) + e;
        double i = Mth.lerp(partialTicks, ((T)leashShipEntity).yo, ((T)leashShipEntity).getY()) + vec32.y;
        double j = Mth.lerp(partialTicks, ((T)leashShipEntity).zo, ((T)leashShipEntity).getZ()) + g;
        poseStack.translate(e, vec32.y, g);
        float k = (float)(vec3.x - h);
        float l = (float)(vec3.y - i);
        float m = (float)(vec3.z - j);
        float n = 0.025F;
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.leash());
        Matrix4f matrix4f = poseStack.last().pose();
        float o = (Mth.fastInvCubeRoot(k * k + m * m) * n / 2.0F);
        float p = m * o;
        float q = k * o;
        Function<Vec3, Vec3i> vec3ToVec3i = vec3d -> new Vec3i(Math.round(Double.valueOf(vec3d.x).floatValue()), Math.round(Double.valueOf(vec3d.y).floatValue()), Math.round(Double.valueOf(vec3d.z).floatValue()));
        BlockPos blockPos = new BlockPos(vec3ToVec3i.apply(((T)leashShipEntity).getEyePosition(partialTicks)));
        BlockPos blockPos2 = new BlockPos(vec3ToVec3i.apply(leashHolderEntity.getEyePosition(partialTicks)));
        int r = this.getBlockLightLevel((T)leashShipEntity, blockPos);
        int s = this.entityRenderDispatcher.getRenderer(leashHolderEntity).getBlockLightLevel(leashHolderEntity, blockPos2);
        int t = ((T)leashShipEntity).level().getBrightness(LightLayer.SKY, blockPos);
        int u = ((T)leashShipEntity).level().getBrightness(LightLayer.SKY, blockPos2);

        int v;
        for(v = 0; v <= 24; ++v) {
            addVertexPair(vertexConsumer, matrix4f, k, l, m, r, s, t, u, n, n, p, q, v, false);
        }

        for(v = 24; v >= 0; --v) {
            addVertexPair(vertexConsumer, matrix4f, k, l, m, r, s, t, u, n, 0.0F, p, q, v, true);
        }

        poseStack.popPose();
    }

    public static String getNameFromType(Boat.Type type) {
        return type.getName().replace(":", "/");
    }
}
