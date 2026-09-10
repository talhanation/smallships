package com.talhanation.smallships.world.particles.wood;

import com.talhanation.smallships.world.dockyard.DockyardRecipe;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.TerrainParticle;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

/**
 * A splinter knocked out of a hull by a cannon ball.
 *
 * A {@link TerrainParticle} on purpose: it takes its sprite straight off the
 * planks of the wood type the ship is built from, so every variant throws its
 * own timber and the mod ships no debris texture at all.
 *
 * What is changed against the block dust it descends from is what makes it read
 * as wreckage instead of a puff: it lives several seconds instead of a fraction
 * of one, it is bigger, and it does not sink out of sight when it lands in the
 * water. Spawned through addAlwaysVisibleParticle, see WoodDebris - a broadside
 * is watched from further off than the 32 blocks a normal particle survives.
 */
public class WoodDebrisParticle extends TerrainParticle {
    /** the shortest a splinter lies around, in ticks */
    private static final int MIN_LIFETIME = 70;
    /** how much longer than that it may last, in ticks */
    private static final int LIFETIME_SPREAD = 90;
    /**
     * Block dust is drawn at 0.6 brightness so it reads as a shadow of the
     * block. Splinters are the timber itself and are only knocked back a
     * little, or a dark oak hull would throw black flecks.
     */
    private static final float SHADE = 0.85F;

    protected WoodDebrisParticle(ClientLevel level, double x, double y, double z, double vx, double vy, double vz, BlockState blockState) {
        super(level, x, y, z, vx, vy, vz, blockState);
        // the Particle constructor rolls its own spread into the velocity it is
        // handed, which would throw every splinter the same way - the burst is
        // aimed by whoever spawns it, so it is put back here
        this.xd = vx;
        this.yd = vy;
        this.zd = vz;

        this.lifetime = MIN_LIFETIME + this.random.nextInt(LIFETIME_SPREAD);
        this.gravity = 0.9F;
        this.friction = 0.96F;
        this.quadSize *= 1.4F + this.random.nextFloat() * 0.8F;
        this.rCol = SHADE;
        this.gCol = SHADE;
        this.bCol = SHADE;
    }

    @Override
    public void tick() {
        super.tick();
        // wood floats. Without this the splinters drop straight through the sea
        // and the wreckage of a broadside is gone the moment it reaches the
        // surface, which is the one place anyone is looking
        if (this.level.getFluidState(BlockPos.containing(this.x, this.y, this.z)).is(FluidTags.WATER)) {
            this.yd += 0.02D;
            this.xd *= 0.7D;
            this.zd *= 0.7D;
        }
    }

    /**
     * @return the planks the given ship variant is built from. Goes through the
     * dockyards' table rather than a second one of its own: what a hull is made
     * of is decided once, and it is decided where it is paid for.
     */
    public static BlockState plankStateOf(Boat.Type woodType) {
        return Block.byItem(DockyardRecipe.plankItemOf(woodType)).defaultBlockState();
    }

    public static class Provider implements ParticleProvider<WoodDebrisParticleOptions> {
        @Nullable
        @Override
        public Particle createParticle(WoodDebrisParticleOptions options, ClientLevel level, double x, double y, double z, double vx, double vy, double vz) {
            return new WoodDebrisParticle(level, x, y, z, vx, vy, vz, plankStateOf(options.woodType()));
        }
    }
}