package com.talhanation.smallships.client.model.sail.banner;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;
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
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public abstract class SailBannerModel {
    /** Total banner surface size in model pixels, matching the vanilla flag. */
    public static final float BANNER_WIDTH = 20.0F;
    public static final float BANNER_HEIGHT = 40.0F;

    /** Prefix of the part names that make up a banner surface. */
    private static final String SEGMENT_PREFIX = "segment_";

    /** Vanilla banner pattern textures are laid out on a 64x64 sheet. */
    private static final float TEXTURE_SIZE = 64.0F;
    /** Pixel origin of the front flag face in the pattern texture. */
    private static final float FRONT_U = 1.0F;
    /** Pixel origin of the (horizontally mirrored) back flag face. */
    private static final float BACK_U = 22.0F;
    private static final float FLAG_V = 1.0F;

    /** Offset of the front/back quads from the strip plane, in model pixels. */
    private static final float SURFACE_OFFSET = 0.05F;
    /** Tolerance when checking whether a row of the 20x40 layout is full. */
    private static final float LAYOUT_EPSILON = 0.01F;

    /**
     * Where one strip sits in the 20x40 banner layout, derived from the baked
     * cube bounds. {@code flatX} tells which axis the strip is flat on: true
     * means zero depth on X with the width running along Z, false means zero
     * depth on Z with the width running along X.
     */
    private record SegmentLayout(int groupIndex, int segmentIndex, float uStartPx, float vStartPx, float widthPx, float heightPx, boolean flatX) {
    }

    private record SegmentPose(Matrix4f pose, Matrix3f normal, ModelPart.Cube cube, SegmentLayout layout, boolean mirrorU) {
    }

    /** A strip before its place in the layout is known, used while baking. */
    private record RawSegment(int segmentIndex, ModelPart part, ModelPart.Cube cube, float widthPx, float heightPx, boolean flatX) {
    }

    /** Everything the bake step derives from the part tree. */
    private record BakedLayout(Map<ModelPart.Cube, SegmentLayout> layouts, List<ModelPart> groupParts, List<List<ModelPart>> segmentParts) {
    }

    private final ModelPart root;
    private final Map<ModelPart.Cube, SegmentLayout> layouts;
    private final List<ModelPart> groupParts;
    private final List<List<ModelPart>> segmentParts;

    protected SailBannerModel(@NotNull LayerDefinition layerDefinition) {
        this.root = layerDefinition.bakeRoot();
        BakedLayout bakedLayout = createLayout(this.root, this.getClass().getSimpleName());
        this.layouts = bakedLayout.layouts();
        this.groupParts = bakedLayout.groupParts();
        this.segmentParts = bakedLayout.segmentParts();
    }

    /** The baked part tree, for subclasses that want to animate their strips. */
    protected @NotNull ModelPart getRoot() {
        return this.root;
    }

    /** Number of banner surfaces this model holds. */
    protected int getGroupCount() {
        return this.groupParts.size();
    }

    /**
     * The node a banner surface hangs from. Rotating it moves the whole
     * surface around its pivot without touching the strip curvature.
     */
    protected @NotNull ModelPart getGroupPart(int groupIndex) {
        return this.groupParts.get(groupIndex);
    }

    /** The strips of a banner surface, in the order of their names. */
    protected @NotNull List<ModelPart> getSegmentParts(int groupIndex) {
        return this.segmentParts.get(groupIndex);
    }

    /** Whether a whole banner surface renders, e.g. depending on the sail state. */
    protected boolean isGroupVisible(@NotNull Ship ship, int groupIndex) {
        return true;
    }

    /** Whether a single strip renders, e.g. for partially reefed sails. */
    protected boolean isSegmentVisible(@NotNull Ship ship, int groupIndex, int segmentIndex) {
        return true;
    }

    /**
     * Flips the horizontal texture direction of a surface. The direction of the
     * width axis is already handled per axis, this is for a surface modeled
     * against the reading direction of the banner on top of that.
     */
    protected boolean isGroupMirrored(int groupIndex) {
        return false;
    }

    /**
     * Renders all pattern layers of the given banner item onto the visible
     * strips. Must be called inside the same pose stack the sail model was
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
     * Walks the baked part tree once and snapshots the pose of every visible
     * strip. The snapshots are then reused for every pattern layer so all
     * layers share identical vertices.
     */
    private @NotNull List<SegmentPose> collectSegmentPoses(@NotNull Ship ship, @NotNull PoseStack poseStack) {
        List<SegmentPose> segmentPoses = new ArrayList<>();
        this.root.visit(poseStack, (pose, path, index, cube) -> {
            SegmentLayout layout = this.layouts.get(cube);
            if (layout == null) return;
            if (!this.isGroupVisible(ship, layout.groupIndex())) return;
            if (!this.isSegmentVisible(ship, layout.groupIndex(), layout.segmentIndex())) return;
            segmentPoses.add(new SegmentPose(new Matrix4f(pose.pose()), new Matrix3f(pose.normal()), cube, layout, this.isGroupMirrored(layout.groupIndex())));
        });
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
        SegmentLayout layout = segmentPose.layout();
        ModelPart.Cube cube = segmentPose.cube();
        boolean flatX = layout.flatX();
        // looking at the front of a Z flat surface, from +Z towards -Z, +X runs
        // to the right and the width axis matches the reading direction of the
        // banner. On an X flat surface, seen from +X towards -X, +Z runs to the
        // left instead, so its width axis has to be flipped to read correctly
        boolean mirrorU = segmentPose.mirrorU() != flatX;
        float uStart = mirrorU ? BANNER_WIDTH - layout.uStartPx() - layout.widthPx() : layout.uStartPx();

        // the back face samples the mirrored back region so the pattern reads
        // correctly from behind, exactly like a vanilla banner
        float frontU0 = (FRONT_U + uStart) / TEXTURE_SIZE;
        float frontU1 = (FRONT_U + uStart + layout.widthPx()) / TEXTURE_SIZE;
        float backU0 = (BACK_U + BANNER_WIDTH - uStart) / TEXTURE_SIZE;
        float backU1 = (BACK_U + BANNER_WIDTH - uStart - layout.widthPx()) / TEXTURE_SIZE;
        if (mirrorU) {
            float swap = frontU0;
            frontU0 = frontU1;
            frontU1 = swap;
            swap = backU0;
            backU0 = backU1;
            backU1 = swap;
        }
        float v0 = (FLAG_V + layout.vStartPx()) / TEXTURE_SIZE;
        float v1 = (FLAG_V + layout.vStartPx() + layout.heightPx()) / TEXTURE_SIZE;

        float y0 = cube.minY;
        float y1 = cube.maxY;
        float w0 = flatX ? cube.minZ : cube.minX;
        float w1 = flatX ? cube.maxZ : cube.maxX;
        // center of the flat axis, so a strip modeled with a small residual
        // depth still gets its quads placed symmetrically around the surface
        float plane = flatX ? (cube.minX + cube.maxX) * 0.5F : (cube.minZ + cube.maxZ) * 0.5F;

        this.emitQuad(segmentPose, vertexConsumer, plane + SURFACE_OFFSET, y0, y1, w0, w1, frontU0, frontU1, v0, v1, 1.0F, color, packedLight);
        this.emitQuad(segmentPose, vertexConsumer, plane - SURFACE_OFFSET, y0, y1, w0, w1, backU0, backU1, v0, v1, -1.0F, color, packedLight);
    }

    private void emitQuad(@NotNull SegmentPose segmentPose, @NotNull VertexConsumer vertexConsumer, float plane, float y0, float y1, float w0, float w1, float u0, float u1, float v0, float v1, float facing, int color, int packedLight) {
        boolean flatX = segmentPose.layout().flatX();
        Vector3f normal = segmentPose.normal().transform(new Vector3f(flatX ? facing : 0.0F, 0.0F, flatX ? 0.0F : facing));
        if (facing > 0.0F) {
            this.emitVertex(segmentPose, vertexConsumer, plane, y0, w0, u0, v0, normal, color, packedLight);
            this.emitVertex(segmentPose, vertexConsumer, plane, y1, w0, u0, v1, normal, color, packedLight);
            this.emitVertex(segmentPose, vertexConsumer, plane, y1, w1, u1, v1, normal, color, packedLight);
            this.emitVertex(segmentPose, vertexConsumer, plane, y0, w1, u1, v0, normal, color, packedLight);
        } else {
            this.emitVertex(segmentPose, vertexConsumer, plane, y0, w1, u1, v0, normal, color, packedLight);
            this.emitVertex(segmentPose, vertexConsumer, plane, y1, w1, u1, v1, normal, color, packedLight);
            this.emitVertex(segmentPose, vertexConsumer, plane, y1, w0, u0, v1, normal, color, packedLight);
            this.emitVertex(segmentPose, vertexConsumer, plane, y0, w0, u0, v0, normal, color, packedLight);
        }
    }

    private void emitVertex(@NotNull SegmentPose segmentPose, @NotNull VertexConsumer vertexConsumer, float plane, float y, float w, float u, float v, @NotNull Vector3f normal, int color, int packedLight) {
        boolean flatX = segmentPose.layout().flatX();
        float x = (flatX ? plane : w) / 16.0F;
        float z = (flatX ? w : plane) / 16.0F;
        // no fluent chaining here: the SpriteCoordinateExpander returned by
        // Material#buffer leaks its delegate from addVertex, so a chained
        // setUv would bypass the sprite UV remap and sample the whole atlas
        vertexConsumer.addVertex(segmentPose.pose(), x, y / 16.0F, z);
        vertexConsumer.setColor(color);
        vertexConsumer.setUv(u, v);
        vertexConsumer.setOverlay(OverlayTexture.NO_OVERLAY);
        vertexConsumer.setLight(packedLight);
        vertexConsumer.setNormal(normal.x(), normal.y(), normal.z());
    }

    /**
     * Collects the {@code segment_N} strips of the baked tree and lays them out
     * over the 20x40 banner area: strips are placed left to right in the order
     * of their name and wrap into the next row once the row is full. Groups are
     * indexed by their sorted node names, so the indices handed to the
     * visibility hooks stay stable regardless of the part traversal order.
     */
    private static @NotNull BakedLayout createLayout(@NotNull ModelPart root, @NotNull String modelName) {
        Map<String, ModelPart> groupPartsByName = new TreeMap<>();
        Map<String, List<RawSegment>> rawGroups = new TreeMap<>();
        root.visit(new PoseStack(), (pose, path, index, cube) -> {
            String[] nodes = path.split("/");
            int segmentIndex = parseSegmentIndex(nodes[nodes.length - 1]);
            if (segmentIndex < 0) return;
            float extentX = cube.maxX - cube.minX;
            float extentY = cube.maxY - cube.minY;
            float extentZ = cube.maxZ - cube.minZ;
            boolean flatX = extentX <= extentZ;
            String groupName = nodes.length > 2 ? nodes[1] : "";
            groupPartsByName.putIfAbsent(groupName, resolvePart(root, nodes, nodes.length > 2 ? 1 : 0));
            rawGroups.computeIfAbsent(groupName, key -> new ArrayList<>())
                    .add(new RawSegment(segmentIndex, resolvePart(root, nodes, nodes.length - 1), cube, flatX ? extentZ : extentX, extentY, flatX));
        });

        Map<ModelPart.Cube, SegmentLayout> layouts = new IdentityHashMap<>();
        List<ModelPart> groupParts = new ArrayList<>();
        List<List<ModelPart>> segmentParts = new ArrayList<>();
        for (Map.Entry<String, List<RawSegment>> rawGroup : rawGroups.entrySet()) {
            List<RawSegment> rawSegments = rawGroup.getValue();
            rawSegments.sort(Comparator.comparingInt(RawSegment::segmentIndex));
            List<ModelPart> parts = new ArrayList<>();
            float u = 0.0F;
            float v = 0.0F;
            float rowHeight = 0.0F;
            for (int segmentIndex = 0; segmentIndex < rawSegments.size(); segmentIndex++) {
                RawSegment rawSegment = rawSegments.get(segmentIndex);
                if (u > 0.0F && u + rawSegment.widthPx() > BANNER_WIDTH + LAYOUT_EPSILON) {
                    u = 0.0F;
                    v += rowHeight;
                    rowHeight = 0.0F;
                }
                layouts.put(rawSegment.cube(), new SegmentLayout(groupParts.size(), segmentIndex, u, v, rawSegment.widthPx(), rawSegment.heightPx(), rawSegment.flatX()));
                if (!parts.contains(rawSegment.part())) parts.add(rawSegment.part());
                u += rawSegment.widthPx();
                rowHeight = Math.max(rowHeight, rawSegment.heightPx());
            }
            float coveredHeight = v + rowHeight;
            if (Math.abs(coveredHeight - BANNER_HEIGHT) > LAYOUT_EPSILON) {
                SmallShipsMod.LOGGER.warn("{}: banner surface \"{}\" covers {} of {} pixels in height, the pattern will not line up with the banner item",
                        modelName, rawGroup.getKey(), coveredHeight, BANNER_HEIGHT);
            }
            groupParts.add(groupPartsByName.get(rawGroup.getKey()));
            segmentParts.add(List.copyOf(parts));
        }
        return new BakedLayout(layouts, List.copyOf(groupParts), List.copyOf(segmentParts));
    }

    private static @NotNull ModelPart resolvePart(@NotNull ModelPart root, String @NotNull [] nodes, int depth) {
        ModelPart part = root;
        for (int i = 1; i <= depth; i++) {
            part = part.getChild(nodes[i]);
        }
        return part;
    }

    /**
     * Index of a {@code segment_N} part, ignoring any suffix Blockbench appends
     * to keep names unique across groups ({@code segment_0_2}). Returns -1 for
     * parts that are not strips of a banner surface.
     */
    private static int parseSegmentIndex(@NotNull String name) {
        if (!name.startsWith(SEGMENT_PREFIX)) return -1;
        int end = SEGMENT_PREFIX.length();
        while (end < name.length() && Character.isDigit(name.charAt(end))) {
            end++;
        }
        if (end == SEGMENT_PREFIX.length()) return -1;
        return Integer.parseInt(name.substring(SEGMENT_PREFIX.length(), end));
    }
}