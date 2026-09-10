package com.talhanation.smallships.world.particles.wood;

import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.network.packet.ClientboundShipImpactPacket;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

/**
 * Splinters flying off a hull that has been hit, both ends of it.
 *
 * The burst does NOT go out as a vanilla particle packet. Two reasons, and both
 * of them are the range: the server only broadcasts those to whoever stands
 * within 32 blocks, and the client throws away what it does get from further
 * off than that. A ship duel is fought at ten times that distance, so the one
 * thing anyone would ever want to see of it would be the one thing nobody sees.
 *
 * So the hit travels as {@link ClientboundShipImpactPacket} to everyone within
 * {@link #SEND_RANGE} instead, and the client spawns the debris itself through
 * addAlwaysVisibleParticle - the same way the wind lines get past the same
 * limit, see com.talhanation.smallships.client.wind.WindEffects.
 */
public final class WoodDebris {
    /** how far a hit is still worth sending, in blocks */
    public static final double SEND_RANGE = 192.0D;

    /** splinters a plain ball knocks out of the timbers */
    private static final int BASE_COUNT = 32;
    private static final int MIN_COUNT = 22;
    /**
     * A ceiling, not a balance number: grape shot is a dozen pellets and every
     * one of them lands, so without it a single charge would put a thousand
     * long lived particles on screen at once.
     */
    private static final int MAX_COUNT = 45;

    /** how wide the splinters come out of the hole, in blocks per tick */
    private static final double SPREAD = 0.23D;
    /** how much of the burst is thrown upwards, in blocks per tick */
    private static final double LIFT = 0.54D;
    /** how far from the point of impact a splinter may start */
    private static final double SPAWN_JITTER = 0.35D;

    private WoodDebris() {}

    /**
     * Server side: a ball has gone into this ship. Power is the ball types'
     * damage multiplier - a heavier shot tears more out of the side.
     */
    public static void onCannonHit(Ship ship, Vec3 hitPos, float power) {
        if (!(ship.level() instanceof ServerLevel serverLevel)) return;

        int count = Mth.clamp(Math.round(BASE_COUNT * power), MIN_COUNT, MAX_COUNT);
        ClientboundShipImpactPacket packet = new ClientboundShipImpactPacket(
                hitPos.x, hitPos.y, hitPos.z, ship.getVariant().getName(), count, power);

        for (ServerPlayer player : serverLevel.players()) {
            if (player.distanceToSqr(hitPos.x, hitPos.y, hitPos.z) > SEND_RANGE * SEND_RANGE) continue;
            ModPackets.serverSendPacket(player, packet);
        }
    }

    /**
     * Client side: throw the burst. Does nothing anywhere else, so the packet
     * handler does not have to know which side it woke up on.
     */
    public static void spawn(Level level, double x, double y, double z, Boat.Type woodType, int count, float power) {
        if (!level.isClientSide()) return;

        WoodDebrisParticleOptions options = new WoodDebrisParticleOptions(woodType);
        for (int i = 0; i < count; i++) {
            double vx = level.random.nextGaussian() * SPREAD * power;
            double vy = level.random.nextDouble() * LIFT * power;
            double vz = level.random.nextGaussian() * SPREAD * power;

            double px = x + (level.random.nextDouble() * 2.0D - 1.0D) * SPAWN_JITTER;
            double py = y + (level.random.nextDouble() * 2.0D - 1.0D) * SPAWN_JITTER;
            double pz = z + (level.random.nextDouble() * 2.0D - 1.0D) * SPAWN_JITTER;

            // addAlwaysVisibleParticle: past the 32 block culling and past the
            // particle video setting, which would silently drop most of the burst
            level.addAlwaysVisibleParticle(options, true, px, py, pz, vx, vy, vz);
        }
    }
}