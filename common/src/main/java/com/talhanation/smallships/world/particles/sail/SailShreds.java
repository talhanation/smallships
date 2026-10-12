package com.talhanation.smallships.world.particles.sail;

import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.network.packet.ClientboundSailImpactPacket;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.entity.ship.abilities.Sailable;
import com.talhanation.smallships.world.entity.ship.sail.SailDamage;
import com.talhanation.smallships.world.particles.wood.WoodDebris;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

/**
 * Canvas torn out of a sail that has been shot through, both ends of it.
 *
 * Travels exactly like the splinters do and for the same reason - a vanilla
 * particle packet dies at 32 blocks, a ship duel does not. See {@link WoodDebris}
 * for the long version; this reuses its send range so a rigging hit is seen
 * from wherever the splinters of the same hit are.
 */
public final class SailShreds {
    /**
     * Scraps a plain ball tears out of the canvas. Same base as the splinters:
     * a rigging hit arrives here with the mast share of the power already
     * taken off, see AbstractCannonBall#MAST_DEBRIS_FACTOR.
     */
    private static final int BASE_COUNT = 32;
    private static final int MIN_COUNT = 12;
    /** a ceiling for grape shot, see WoodDebris#MAX_COUNT */
    private static final int MAX_COUNT = 32;

    // thrown exactly like the splinters of the same hit, see WoodDebris -
    // cloth and timber come out of the one hole together

    /** how wide the scraps come out of the hole, in blocks per tick */
    private static final double SPREAD = 0.23D;
    /** how much of the burst is thrown upwards, in blocks per tick */
    private static final double LIFT = 0.54D;
    /** how far from the point of impact a scrap may start */
    private static final double SPAWN_JITTER = 0.35D;

    private SailShreds() {}

    /**
     * Server side: a ball has gone through this ships' rigging. Nothing comes
     * out of a sail that is already gone - the canvas is not rendered any more
     * then, and cloth flying out of thin air would only lie about it.
     */
    public static void onCannonHit(Ship ship, Vec3 hitPos, float power) {
        if (!(ship.level() instanceof ServerLevel serverLevel)) return;
        if (!(ship instanceof Sailable)) return;
        if (SailDamage.getState(ship) == SailDamage.State.DESTROYED) return;

        int count = Mth.clamp(Math.round(BASE_COUNT * power), MIN_COUNT, MAX_COUNT);
        ClientboundSailImpactPacket packet = new ClientboundSailImpactPacket(
                hitPos.x, hitPos.y, hitPos.z, ship.getData(Ship.SAIL_COLOR), count, power);

        for (ServerPlayer player : serverLevel.players()) {
            if (player.distanceToSqr(hitPos.x, hitPos.y, hitPos.z) > WoodDebris.SEND_RANGE * WoodDebris.SEND_RANGE) continue;
            ModPackets.serverSendPacket(player, packet);
        }
    }

    /**
     * Client side: throw the scraps. Does nothing anywhere else, so the packet
     * handler does not have to know which side it woke up on.
     */
    public static void spawn(Level level, double x, double y, double z, DyeColor color, int count, float power) {
        if (!level.isClientSide()) return;

        SailShredParticleOptions options = new SailShredParticleOptions(color);
        for (int i = 0; i < count; i++) {
            double vx = level.random.nextGaussian() * SPREAD * power;
            double vy = level.random.nextDouble() * LIFT * power;
            double vz = level.random.nextGaussian() * SPREAD * power;

            double px = x + (level.random.nextDouble() * 2.0D - 1.0D) * SPAWN_JITTER;
            double py = y + (level.random.nextDouble() * 2.0D - 1.0D) * SPAWN_JITTER;
            double pz = z + (level.random.nextDouble() * 2.0D - 1.0D) * SPAWN_JITTER;

            // addAlwaysVisibleParticle: past the 32 block culling and past the
            // particle video setting, same as the splinters
            level.addAlwaysVisibleParticle(options, true, px, py, pz, vx, vy, vz);
        }
    }
}