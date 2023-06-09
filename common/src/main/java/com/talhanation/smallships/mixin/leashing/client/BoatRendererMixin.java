package com.talhanation.smallships.mixin.leashing.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.talhanation.smallships.duck.BoatLeashAccess;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BoatRenderer.class)
public abstract class BoatRendererMixin extends EntityRenderer<Boat> {
    @SuppressWarnings("unused")
    protected BoatRendererMixin(EntityRendererProvider.Context context) {
        super(context);
        throw new AssertionError();
    }

    @Shadow public abstract @NotNull ResourceLocation getTextureLocation(Boat boat);

    @SuppressWarnings("SimplifiableConditionalExpression")
    @Override
    public boolean shouldRender(Boat boat, Frustum frustum, double d, double e, double f) {
        if (super.shouldRender(boat, frustum, d, e, f)) {
            return true;
        } else {
            Entity entity = ((BoatLeashAccess)boat).getLeashHolder();
            return entity != null ? frustum.isVisible(entity.getBoundingBoxForCulling()) : false;
        }
    }

    @Inject(method = "render(Lnet/minecraft/world/entity/vehicle/Boat;FFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V", at = @At(value = "RETURN"))
    private void renderLeashBoat(Boat boat, float f, float g, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, CallbackInfo ci) {
        Entity entity = ((BoatLeashAccess)boat).getLeashHolder();
        if (entity != null) {
            this.renderLeash(boat, g, poseStack, multiBufferSource, entity);
        }
    }

    private <E extends Entity> void renderLeash(Boat $$0, float $$1, PoseStack $$2, MultiBufferSource $$3, E $$4) {
        $$2.pushPose();
        Vec3 $$5 = $$4.getRopeHoldPosition($$1);
        double $$6 = (Mth.lerp($$1, 0.0D, 0.0D) * (float) (Math.PI / 180.0)) + (Math.PI / 2);
        Vec3 $$7 = $$0.getLeashOffset($$1);
        double $$8 = Math.cos($$6) * $$7.z + Math.sin($$6) * $$7.x;
        double $$9 = Math.sin($$6) * $$7.z - Math.cos($$6) * $$7.x;
        double $$10 = Mth.lerp($$1, $$0.xo, $$0.getX()) + $$8;
        double $$11 = Mth.lerp($$1, $$0.yo, $$0.getY()) + $$7.y;
        double $$12 = Mth.lerp($$1, $$0.zo, $$0.getZ()) + $$9;
        $$2.translate($$8, $$7.y, $$9);
        float $$13 = (float)($$5.x - $$10);
        float $$14 = (float)($$5.y - $$11);
        float $$15 = (float)($$5.z - $$12);
        VertexConsumer $$17 = $$3.getBuffer(RenderType.leash());
        Matrix4f $$18 = $$2.last().pose();
        float $$19 = Mth.invSqrt($$13 * $$13 + $$15 * $$15) * 0.025F / 2.0F;
        float $$20 = $$15 * $$19;
        float $$21 = $$13 * $$19;
        BlockPos $$22 = BlockPos.containing($$0.getEyePosition($$1));
        BlockPos $$23 = BlockPos.containing($$4.getEyePosition($$1));
        int $$24 = this.getBlockLightLevel($$0, $$22);
        int $$25 = this.entityRenderDispatcher.getRenderer($$4).getBlockLightLevel($$4, $$23);
        int $$26 = $$0.getLevel().getBrightness(LightLayer.SKY, $$22);
        int $$27 = $$0.getLevel().getBrightness(LightLayer.SKY, $$23);

        for(int $$28 = 0; $$28 <= 24; ++$$28) {
            addVertexPair($$17, $$18, $$13, $$14, $$15, $$24, $$25, $$26, $$27, 0.025F, $$20, $$21, $$28, false);
        }

        for(int $$29 = 24; $$29 >= 0; --$$29) {
            addVertexPair($$17, $$18, $$13, $$14, $$15, $$24, $$25, $$26, $$27, 0.0F, $$20, $$21, $$29, true);
        }

        $$2.popPose();
    }

    private static void addVertexPair(
            VertexConsumer $$0,
            Matrix4f $$1,
            float $$2,
            float $$3,
            float $$4,
            int $$5,
            int $$6,
            int $$7,
            int $$8,
            float $$10,
            float $$11,
            float $$12,
            int $$13,
            boolean $$14
    ) {
        float $$15 = (float)$$13 / 24.0F;
        int $$16 = (int)Mth.lerp($$15, (float)$$5, (float)$$6);
        int $$17 = (int)Mth.lerp($$15, (float)$$7, (float)$$8);
        int $$18 = LightTexture.pack($$16, $$17);
        float $$19 = $$13 % 2 == ($$14 ? 1 : 0) ? 0.7F : 1.0F;
        float $$20 = 0.5F * $$19;
        float $$21 = 0.4F * $$19;
        float $$22 = 0.3F * $$19;
        float $$23 = $$2 * $$15;
        float $$24 = $$3 > 0.0F ? $$3 * $$15 * $$15 : $$3 - $$3 * (1.0F - $$15) * (1.0F - $$15);
        float $$25 = $$4 * $$15;
        $$0.vertex($$1, $$23 - $$11, $$24 + $$10, $$25 + $$12).color($$20, $$21, $$22, 1.0F).uv2($$18).endVertex();
        $$0.vertex($$1, $$23 + $$11, $$24 + (float) 0.025 - $$10, $$25 - $$12).color($$20, $$21, $$22, 1.0F).uv2($$18).endVertex();
    }
}
