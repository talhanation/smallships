package com.talhanation.smallships.client.wind;

import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.world.particles.ModParticleTypes;
import com.talhanation.smallships.world.wind.Wind;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.CampfireBlockEntity;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;

/**
 * Spawns the white wind lines on the water surface around the camera.
 * Called once per client tick.
 */
public class WindEffects {
    private static final int RADIUS = 32;

    public static void tick(Minecraft minecraft) {
        if (minecraft.level == null || minecraft.isPaused()) return;
        if (!SmallShipsConfig.Common.windEnable.get() || !SmallShipsConfig.Client.windParticlesEnable.get()) return;

        Wind wind = ClientWindManager.getWind();
        if (wind.strength() < 0.15F) return;

        LocalPlayer player = minecraft.player;
        if (player == null) return;

        Level level = minecraft.level;

        int perTick = (int) Math.ceil(SmallShipsConfig.Client.windParticlesAmount.get() * wind.strength() * 2.0F);

        for (int i = 0; i < perTick; i++) {
            double x = player.getX() + (level.random.nextDouble() * 2.0D - 1.0D) * RADIUS;
            double z = player.getZ() + (level.random.nextDouble() * 2.0D - 1.0D) * RADIUS;
            BlockPos surfacePos = new BlockPos((int)x,(int) player.getBlockY(),(int)z);

            //FluidState fluidState = level.getFluidState(surfacePos.above(3));
            //if (!fluidState.isSource() || !fluidState.getType().isSame(net.minecraft.world.level.material.Fluids.WATER)) continue;

            double y = surfacePos.getY() + 1.02D;
            double speed = 0.075D + 0.20D * wind.strength();
            Vec3 motion = new Vec3(wind.getMotionX() * speed, 0.0D, wind.getMotionZ() * speed);

            // addAlwaysVisibleParticle: bypasses the 32 block distance culling and
            // the particle video setting, which silently dropped many spawns before
            level.addAlwaysVisibleParticle(ParticleTypes.WHITE_SMOKE, true, x, y, z, motion.x, motion.y, motion.z);
        }
    }
}