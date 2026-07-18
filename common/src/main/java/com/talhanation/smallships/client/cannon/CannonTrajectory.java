package com.talhanation.smallships.client.cannon;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;

/**
 * Shared trajectory preview for ship cannons and the ground cannon
 * (SiegeWeapons-ballista style, but white and with the exact cannonball
 * physics of AbstractCannonBall: pos += vel; vel = vel * 0.99 - 0.06y).
 */
public class CannonTrajectory {
    /**
     * Base projectile speed of the Cannon core class (Cannon.speed). The real
     * shot speed is this times the ammo speed multiplier (grape/chained shot,
     * fine grain powder), so callers pass CANNON_SPEED * speedMultiplier for an
     * accurate preview. Gravity is the same for every ammo type, so a slower
     * ball simply produces a shorter, steeper arc.
     */
    public static final float CANNON_SPEED = 2.6F;
    private static final int MAX_STEPS = 200;
    private static final double MAX_DROP = 96.0D;

    /**
     * Simulates the cannonball flight tick by tick.
     *
     * @param start     start point relative to the render origin (entity position)
     * @param direction normalized shoot direction
     * @param speed     initial projectile speed
     * @return the flight path points, relative to the render origin
     */
    public static List<Vec3> calculate(Vec3 start, Vec3 direction, float speed) {
        List<Vec3> points = new ArrayList<>();
        Vec3 pos = start;
        Vec3 velocity = direction.normalize().scale(speed);

        for (int i = 0; i < MAX_STEPS; i++) {
            points.add(pos);
            // exact AbstractCannonBall.tick physics
            pos = pos.add(velocity);
            velocity = velocity.scale(0.99D).add(0.0D, -0.06D, 0.0D);
            if (pos.y < start.y - MAX_DROP) break;
        }
        return points;
    }


    /**
     * SiegeWeapons ballista style: the trajectory is calculated in the LOCAL
     * frame of the rendered cannon (inside its pose stack) - it therefore
     * automatically rotates with the ship and the cannon aim. The surrounding
     * hull pose mirrors x and y (scale -1,-1,1 after normalizing the 1.3
     * hull scale away), which is why the direction is flipped and the gravity
     * is POSITIVE, exactly like in the ballista renderer.
     *
     * @param aimAngle barrel elevation in degrees (positive = up)
     * @param speed    initial projectile speed
     */
    public static List<Vec3> calculateLocal(float aimAngle, float speed) {
        List<Vec3> points = new ArrayList<>();

        double yShootVec = Math.toRadians(aimAngle);
        Vec3 direction = new Vec3(0.0D, yShootVec, 1.0D).normalize().scale(-1.0D);
        Vec3 velocity = direction.scale(speed);
        Vec3 pos = Vec3.ZERO;

        for (int i = 0; i < MAX_STEPS; i++) {
            points.add(pos);
            // cannonball physics in the mirrored frame: drag 0.99, gravity +0.06
            pos = pos.add(velocity);
            velocity = velocity.scale(0.99D).add(0.0D, 0.06D, 0.0D);
            if (pos.y > MAX_DROP) break;
        }
        return points;
    }

    /**
     * Renders the path as a white line (RenderType.lines()).
     * The pose stack must be at the render origin the points are relative to.
     */
    public static void render(PoseStack poseStack, VertexConsumer vertexConsumer, List<Vec3> points) {
        PoseStack.Pose pose = poseStack.last();

        for (int i = 0; i < points.size() - 1; i++) {
            Vec3 p1 = points.get(i);
            Vec3 p2 = points.get(i + 1);
            Vec3 normal = p2.subtract(p1).normalize();

            vertexConsumer.addVertex(pose, (float) p1.x, (float) p1.y, (float) p1.z)
                    .setColor(255, 255, 255, 220)
                    .setNormal(pose, (float) normal.x, (float) normal.y, (float) normal.z);
            vertexConsumer.addVertex(pose, (float) p2.x, (float) p2.y, (float) p2.z)
                    .setColor(255, 255, 255, 220)
                    .setNormal(pose, (float) normal.x, (float) normal.y, (float) normal.z);
        }
    }
}