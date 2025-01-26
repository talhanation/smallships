package com.talhanation.smallships.client.renderer.entity.state;

import com.talhanation.smallships.world.entity.ship.Attributes;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.entity.ship.abilities.*;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;

@Environment(EnvType.CLIENT)
public class ShipRenderState extends EntityRenderState {
    private static final RandomSource random = RandomSource.create();

    public Attributes shipAttributes;
    public float hurtTime;
    public float damage;
    public Level level;
    public int hurtDir;
    public float bubbleAngle;
    public float waveAngle;
    public Ship.Type variant;
    public boolean sunken;
    public float yaw;
    public float rotationSpeed;
    public float partialTicks;

    public boolean hasContainer;
    public byte invFillState;

    public Cannonable cannonable;
    public Bannerable bannerable;
    public Paddleable paddleable;
    public Sailable sailable;
    public Shieldable shieldable;

    public double getRandomPosFrom(double pos, double d) {
        return this.getPos(pos, ((double)2.0F * random.nextDouble() - (double)1.0F) * d);
    }

    public double getPos(double pos, double d) {
        return pos + (double)this.boundingBoxWidth * d;
    }
}
