package com.talhanation.smallships.client.model.sail.banner;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.BannerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector3f;

import java.util.ArrayList;
import java.util.List;

/**
 * Renders the pattern layers of an applied banner item onto a sail as a flat,
 * segmented 20x40 surface that follows the sail curvature.
 * <p>
 * Subclasses only provide geometry data (taken 1:1 from the Blockbench export:
 * root offset, per-segment pivot, z-rotation and box bounds). All UVs are
 * computed here and projected onto the vanilla banner texture layout
 * (front region (1,1)-(21,41), mirrored back region (22,1)-(42,41) on a 64x64
 * pattern texture), so the applied banner looks exactly like its item, front
 * and back. The Blockbench UVs and any {@code LayerDefinition} baking are
 * intentionally ignored; segments are emitted as raw quads because cube UVs
 * cannot express the banner layout on zero-depth boxes.
 * <p>
 * Layer sequence matches {@code BannerRenderer#renderPatterns}: base cloth
 * texture, then the base dye color, then each {@link BannerPatternLayers.Layer}
 * tinted with its color. All layers share identical vertices, so they stack
 * without z-fighting. {@code RenderType::entityTranslucent} is used instead of
 * the vanilla {@code entityNoOutline} because it renders both faces regardless
 * of winding and preserves the alpha ramps of gradient patterns.
 */
public abstract class SailBannerModel {
    /** Total banner surface size in model pixels, matching the vanilla flag. */
    public static final float BANNER_WIDTH = 20.0F;
    public static final float BANNER_HEIGHT = 40.0F;

    /** Vanilla banner pattern textures are laid out on a 64x64 sheet. */
    private static final float TEXTURE_SIZE = 64.0F;
    /** Pixel origin of the front flag face in the pattern texture. */
    private static final float FRONT_U = 1.0F;
    /** Pixel origin of the (horizontally mirrored) back flag face. */
    private static final float BACK_U = 22.0F;
    private static final float FLAG_V = 1.0F;

    /** Offset of the front/back quads from the segment plane, in model pixels. */
    private static final float SURFACE_OFFSET = 0.05F;

    /**
     * One flat strip of the banner surface. Pivot and rotation are relative to
     * the previous segment in the group (the Blockbench parent), so rotations
     * accumulate along the chain and the surface bends around the sail.
     *
     * @param uStartPx horizontal position of this strip in the 20x40 layout
     * @param vStartPx vertical position of this strip in the 20x40 layout
     */
    public record Segment(float pivotX, float pivotY, float pivotZ, float zRot,
                          float boxX, float boxY, float boxZ,
                          float widthPx, float heightPx,
                          float uStartPx, float vStartPx) {
    }

    /**
     * One complete 20x40 banner surface (e.g. one sail). A model may contain
     * several groups; every group renders the same banner independently.
     *
     * @param mirrorU flips the horizontal texture direction of the whole group
     *                in case the modeled surface runs opposite to the banner
     */
    public record Group(float rootX, float rootY, float rootZ, boolean mirrorU, List<Segment> segments) {
    }

    private record SegmentPose(Matrix4f pose, Matrix3f normal, Segment segment, boolean mirrorU) {
    }

    /** Geometry data of this sail type, taken from the Blockbench export. */
    protected abstract @NotNull List<Group> getGroups();

    /** Whether a whole banner surface renders, e.g. depending on the sail state. */
    protected boolean isGroupVisible(@NotNull Ship ship, int groupIndex) {
        return true;
    }

    /** Whether a single strip renders, e.g. for partially reefed sails. */
    protected boolean isSegmentVisible(@NotNull Ship ship, int groupIndex, int segmentIndex) {
        return true;
    }

    /**
     * Renders all pattern layers of the given banner item onto the visible
     * segments. Must be called inside the same pose stack the sail model was
     * rendered in, like {@link ModelPart#render}.
     */
    public void render(@NotNull Ship ship, @NotNull ItemStack bannerStack, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight) {
        if (!(bannerStack.getItem() instanceof BannerItem bannerItem)) return;

        List<SegmentPose> segmentPoses = this.collectSegmentPoses(ship, poseStack);
        if (segmentPoses.isEmpty()) return;

        BannerPatternLayers patternLayers = bannerStack.getOrDefault(DataComponents.BANNER_PATTERNS, BannerPatternLayers.EMPTY);

        this.renderLayer(segmentPoses, ModelBakery.BANNER_BASE, bufferSource, 0xFFFFFFFF, packedLight);
        this.renderLayer(segmentPoses, Sheets.BANNER_BASE, bufferSource, bannerItem.getColor().getTextureDiffuseColor(), packedLight);
        for (BannerPatternLayers.Layer layer : patternLayers.layers()) {
            this.renderLayer(segmentPoses, Sheets.getBannerMaterial(layer.pattern()), bufferSource, layer.color().getTextureDiffuseColor(), packedLight);
        }
    }

    /**
     * Walks each group's segment chain once, accumulating the pivot/rotation
     * transforms, and snapshots the pose of every visible segment. The
     * snapshots are then reused for every pattern layer so all layers share
     * identical vertices.
     */
    private @NotNull List<SegmentPose> collectSegmentPoses(@NotNull Ship ship, @NotNull PoseStack poseStack) {
        List<SegmentPose> segmentPoses = new ArrayList<>();
        List<Group> groups = this.getGroups();
        for (int groupIndex = 0; groupIndex < groups.size(); groupIndex++) {
            Group group = groups.get(groupIndex);
            if (!this.isGroupVisible(ship, groupIndex)) continue;
            poseStack.pushPose();
            poseStack.translate(group.rootX() / 16.0F, group.rootY() / 16.0F, group.rootZ() / 16.0F);
            List<Segment> segments = group.segments();
            for (int segmentIndex = 0; segmentIndex < segments.size(); segmentIndex++) {
                Segment segment = segments.get(segmentIndex);
                poseStack.translate(segment.pivotX() / 16.0F, segment.pivotY() / 16.0F, segment.pivotZ() / 16.0F);
                if (segment.zRot() != 0.0F) poseStack.mulPose(Axis.ZP.rotation(segment.zRot()));
                if (this.isSegmentVisible(ship, groupIndex, segmentIndex)) {
                    segmentPoses.add(new SegmentPose(new Matrix4f(poseStack.last().pose()), new Matrix3f(poseStack.last().normal()), segment, group.mirrorU()));
                }
            }
            poseStack.popPose();
        }
        return segmentPoses;
    }

    private void renderLayer(@NotNull List<SegmentPose> segmentPoses, @NotNull Material material, @NotNull MultiBufferSource bufferSource, int color, int packedLight) {
        VertexConsumer vertexConsumer = material.buffer(bufferSource, RenderType::entityTranslucent);
        for (SegmentPose segmentPose : segmentPoses) {
            this.emitSegment(segmentPose, vertexConsumer, color, packedLight);
        }
    }

    /** Emits the front and back quad of one strip with its UV window of the flag layout. */
    private void emitSegment(@NotNull SegmentPose segmentPose, @NotNull VertexConsumer vertexConsumer, int color, int packedLight) {
        Segment segment = segmentPose.segment();
        float uStart = segmentPose.mirrorU() ? BANNER_WIDTH - segment.uStartPx() - segment.widthPx() : segment.uStartPx();

        // front face UVs at z0/z1; back face samples the mirrored back region
        // so the pattern reads correctly from behind, like a vanilla banner
        float frontU0 = (FRONT_U + uStart) / TEXTURE_SIZE;
        float frontU1 = (FRONT_U + uStart + segment.widthPx()) / TEXTURE_SIZE;
        float backU0 = (BACK_U + (BANNER_WIDTH - uStart)) / TEXTURE_SIZE;
        float backU1 = (BACK_U + (BANNER_WIDTH - uStart - segment.widthPx())) / TEXTURE_SIZE;
        if (segmentPose.mirrorU()) {
            float swap = frontU0;
            frontU0 = frontU1;
            frontU1 = swap;
            swap = backU0;
            backU0 = backU1;
            backU1 = swap;
        }
        float v0 = (FLAG_V + segment.vStartPx()) / TEXTURE_SIZE;
        float v1 = (FLAG_V + segment.vStartPx() + segment.heightPx()) / TEXTURE_SIZE;

        float y0 = segment.boxY() / 16.0F;
        float y1 = (segment.boxY() + segment.heightPx()) / 16.0F;
        float z0 = segment.boxZ() / 16.0F;
        float z1 = (segment.boxZ() + segment.widthPx()) / 16.0F;
        float xFront = (segment.boxX() + SURFACE_OFFSET) / 16.0F;
        float xBack = (segment.boxX() - SURFACE_OFFSET) / 16.0F;

        this.emitQuad(segmentPose, vertexConsumer, xFront, y0, y1, z0, z1, frontU0, frontU1, v0, v1, 1.0F, color, packedLight);
        this.emitQuad(segmentPose, vertexConsumer, xBack, y0, y1, z0, z1, backU0, backU1, v0, v1, -1.0F, color, packedLight);
    }

    private void emitQuad(@NotNull SegmentPose segmentPose, @NotNull VertexConsumer vertexConsumer, float x, float y0, float y1, float z0, float z1, float u0, float u1, float v0, float v1, float normalX, int color, int packedLight) {
        Vector3f normal = segmentPose.normal().transform(new Vector3f(normalX, 0.0F, 0.0F));
        if (normalX > 0.0F) {
            this.emitVertex(segmentPose.pose(), vertexConsumer, x, y0, z0, u0, v0, normal, color, packedLight);
            this.emitVertex(segmentPose.pose(), vertexConsumer, x, y1, z0, u0, v1, normal, color, packedLight);
            this.emitVertex(segmentPose.pose(), vertexConsumer, x, y1, z1, u1, v1, normal, color, packedLight);
            this.emitVertex(segmentPose.pose(), vertexConsumer, x, y0, z1, u1, v0, normal, color, packedLight);
        } else {
            this.emitVertex(segmentPose.pose(), vertexConsumer, x, y0, z1, u1, v0, normal, color, packedLight);
            this.emitVertex(segmentPose.pose(), vertexConsumer, x, y1, z1, u1, v1, normal, color, packedLight);
            this.emitVertex(segmentPose.pose(), vertexConsumer, x, y1, z0, u0, v1, normal, color, packedLight);
            this.emitVertex(segmentPose.pose(), vertexConsumer, x, y0, z0, u0, v0, normal, color, packedLight);
        }
    }

    private void emitVertex(@NotNull Matrix4f pose, @NotNull VertexConsumer vertexConsumer, float x, float y, float z, float u, float v, @NotNull Vector3f normal, int color, int packedLight) {
        // no fluent chaining here: the SpriteCoordinateExpander returned by
        // Material#buffer leaks its delegate from addVertex, so a chained
        // setUv would bypass the sprite UV remap and sample the whole atlas
        vertexConsumer.addVertex(pose, x, y, z);
        vertexConsumer.setColor(color);
        vertexConsumer.setUv(u, v);
        vertexConsumer.setOverlay(OverlayTexture.NO_OVERLAY);
        vertexConsumer.setLight(packedLight);
        vertexConsumer.setNormal(normal.x(), normal.y(), normal.z());
    }
}