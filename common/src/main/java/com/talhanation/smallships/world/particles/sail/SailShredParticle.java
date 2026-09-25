package com.talhanation.smallships.world.particles.sail;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.TerrainParticle;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

/**
 * A scrap of canvas torn out of a sail by a ball through the rigging.
 *
 * A {@link TerrainParticle} for the same reason the splinters are one: it takes
 * its sprite straight off the wool block of the sails' own colour, so every dye
 * sheds its own cloth and the mod ships no texture for it.
 *
 * It flies exactly like a splinter does - same lifetime, gravity, drag and the
 * same floating on the water, see
 * {@link com.talhanation.smallships.world.particles.wood.WoodDebrisParticle}.
 * The two things it does differently are how it LOOKS:
 * - it shows the whole wool texture instead of the random 4x4 corner block
 *   dust cuts out of it, so a scrap reads as a piece of that wool block
 * - it is drawn at full brightness instead of the 0.6 block dust is shaded
 *   with, so the scrap has the colour the block has and not a darker one
 */
public class SailShredParticle extends TerrainParticle {
    /** the shortest a scrap lies around, in ticks - same as a splinter */
    private static final int MIN_LIFETIME = 70;
    /** how much longer than that it may last, in ticks - same as a splinter */
    private static final int LIFETIME_SPREAD = 90;

    protected SailShredParticle(ClientLevel level, double x, double y, double z, double vx, double vy, double vz, BlockState blockState) {
        super(level, x, y, z, vx, vy, vz, blockState);
        // the Particle constructor rolls its own spread into the velocity, the
        // burst is aimed by whoever spawns it - put back, like the splinters
        this.xd = vx;
        this.yd = vy;
        this.zd = vz;

        this.lifetime = MIN_LIFETIME + this.random.nextInt(LIFETIME_SPREAD);
        this.gravity = 0.9F;
        this.friction = 0.96F;
        this.quadSize *= 1.4F + this.random.nextFloat() * 0.8F;
        // the wool block as it is: no block dust shading at all
        this.rCol = 1.0F;
        this.gCol = 1.0F;
        this.bCol = 1.0F;
    }

    @Override
    public void tick() {
        super.tick();
        // floats like the splinters do, see WoodDebrisParticle#tick
        if (this.level.getFluidState(BlockPos.containing(this.x, this.y, this.z)).is(FluidTags.WATER)) {
            this.yd += 0.02D;
            this.xd *= 0.7D;
            this.zd *= 0.7D;
        }
    }

    /*
     * TerrainParticle only shows a random quarter by quarter of its sprite -
     * block dust is meant to look like crumbs. A scrap of cloth is meant to look
     * like the wool block, so the full sprite goes on the quad.
     */
    @Override
    protected float getU0() {
        return this.sprite.getU0();
    }

    @Override
    protected float getU1() {
        return this.sprite.getU1();
    }

    @Override
    protected float getV0() {
        return this.sprite.getV0();
    }

    @Override
    protected float getV1() {
        return this.sprite.getV1();
    }

    /**
     * @return the wool block the given sail colour is woven from. Written out
     * like DockyardRecipe#plankItemOf on purpose: 1.20.1 keeps its own dye to
     * wool table private in Sheep, and a registry lookup by built up name would
     * break silently the day anything about the naming changes.
     */
    public static BlockState woolStateOf(DyeColor color) {
        return switch (color) {
            case ORANGE -> Blocks.ORANGE_WOOL.defaultBlockState();
            case MAGENTA -> Blocks.MAGENTA_WOOL.defaultBlockState();
            case LIGHT_BLUE -> Blocks.LIGHT_BLUE_WOOL.defaultBlockState();
            case YELLOW -> Blocks.YELLOW_WOOL.defaultBlockState();
            case LIME -> Blocks.LIME_WOOL.defaultBlockState();
            case PINK -> Blocks.PINK_WOOL.defaultBlockState();
            case GRAY -> Blocks.GRAY_WOOL.defaultBlockState();
            case LIGHT_GRAY -> Blocks.LIGHT_GRAY_WOOL.defaultBlockState();
            case CYAN -> Blocks.CYAN_WOOL.defaultBlockState();
            case PURPLE -> Blocks.PURPLE_WOOL.defaultBlockState();
            case BLUE -> Blocks.BLUE_WOOL.defaultBlockState();
            case BROWN -> Blocks.BROWN_WOOL.defaultBlockState();
            case GREEN -> Blocks.GREEN_WOOL.defaultBlockState();
            case RED -> Blocks.RED_WOOL.defaultBlockState();
            case BLACK -> Blocks.BLACK_WOOL.defaultBlockState();
            default -> Blocks.WHITE_WOOL.defaultBlockState();
        };
    }

    public static class Provider implements ParticleProvider<SailShredParticleOptions> {
        @Nullable
        @Override
        public Particle createParticle(SailShredParticleOptions options, ClientLevel level, double x, double y, double z, double vx, double vy, double vz) {
            return new SailShredParticle(level, x, y, z, vx, vy, vz, woolStateOf(options.color()));
        }
    }
}