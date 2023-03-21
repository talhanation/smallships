package com.talhanation.smallships.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Matrix4f;
import com.talhanation.smallships.duck.BoatLeashAccess;
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
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.minecraft.client.renderer.entity.MobRenderer.addVertexPair;

@Mixin(BoatRenderer.class)
public class BoatRendererMixin extends EntityRenderer<Boat> {
    protected BoatRendererMixin(EntityRendererProvider.Context context) {
        super(context);
        throw new AssertionError();
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(Boat entity) {
        throw new AssertionError();
    }

    //LEASH FEATURE

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

    private <E extends Entity> void renderLeash(Boat boat, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, E entity) {
        poseStack.pushPose();
        Vec3 vec3 = entity.getRopeHoldPosition(f);
        double d = (Mth.lerp(f, 0.0D, 0.0D) * 0.017453292F) + 1.5707963267948966;
        Vec3 vec32 = boat.getLeashOffset();
        double e = Math.cos(d) * vec32.z + Math.sin(d) * vec32.x;
        double g = Math.sin(d) * vec32.z - Math.cos(d) * vec32.x;
        double h = Mth.lerp(f, boat.xo, boat.getX()) + e;
        double i = Mth.lerp(f, boat.yo, boat.getY()) + vec32.y;
        double j = Mth.lerp(f, boat.zo, boat.getZ()) + g;
        poseStack.translate(e, vec32.y, g);
        float k = (float)(vec3.x - h);
        float l = (float)(vec3.y - i);
        float m = (float)(vec3.z - j);
        float n = 0.025F;
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.leash());
        Matrix4f matrix4f = poseStack.last().pose();
        float o = Mth.fastInvSqrt(k * k + m * m) * n / 2.0F;
        float p = m * o;
        float q = k * o;
        BlockPos blockPos = new BlockPos(boat.getEyePosition(f));
        BlockPos blockPos2 = new BlockPos(entity.getEyePosition(f));
        int r = this.getBlockLightLevel(boat, blockPos);
        int s = this.entityRenderDispatcher.getRenderer(entity).getBlockLightLevel(entity, blockPos2);
        int t = boat.level.getBrightness(LightLayer.SKY, blockPos);
        int u = boat.level.getBrightness(LightLayer.SKY, blockPos2);

        int v;
        for(v = 0; v <= 24; ++v) {
            addVertexPair(vertexConsumer, matrix4f, k, l, m, r, s, t, u, n, n, p, q, v, false);
        }

        for(v = 24; v >= 0; --v) {
            addVertexPair(vertexConsumer, matrix4f, k, l, m, r, s, t, u, n, 0.0F, p, q, v, true);
        }

        poseStack.popPose();
    }
}
