package com.talhanation.smallships.world.entity.cannon;

import com.mojang.datafixers.util.Pair;
import com.talhanation.smallships.world.entity.cannon.ICannonBallContainer;
import com.talhanation.smallships.world.entity.projectile.CannonBallEntity;
import com.talhanation.smallships.world.sound.ModSoundTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.function.BiConsumer;

public class Cannon {
    private final RandomSource random;
    private int time;
    private int coolDown;
    private final Level level;
    /**
     * Where to play sounds at and get the cannonballs from
     */
    private final Entity owner;

    public Cannon(Entity owner) {
        this.owner = owner;
        this.level = owner.level();
        this.random = level.getRandom();
    }

    public void tick(){
        if (coolDown > 0) coolDown--;
    }

    private void resetTimer() {
        this.time = 0;//10 + random.nextInt(10);
    }

    private void setCoolDown() {
        this.coolDown = 0;//50;
    }

    /**
     * @param shootVec
     * @param yShootVec
     * @param pos position from which the ball should be shot
     * @param driverEntity
     * @param speed
     * @param accuracy
     */
    public void trigger(Vec3 shootVec, double yShootVec, Vec3 pos, LivingEntity driverEntity, double accuracy) {
        if (coolDown == 0) {
            if (time > 0) time--; //TODO time is more like how often you have to press space...

            if (time == 0) {
                this.shoot(shootVec, yShootVec, pos, driverEntity, accuracy);
                this.resetTimer();
                this.setCoolDown();
            }
        }
    }

    private void shoot(Vec3 shootVec, double yShootVec, Vec3 pos, LivingEntity driverEntity, double accuracy) {
        if (shootVec != null) {
            CannonBallEntity cannonBallEntity = new CannonBallEntity(this.level, driverEntity, pos.x, pos.y, pos.z);
            cannonBallEntity.shoot(shootVec.x(), yShootVec, shootVec.z(),2.6F, (float) accuracy);
            this.level.addFreshEntity(cannonBallEntity);
            this.owner.playSound(SoundEvents.TNT_PRIMED, 1.0F, 1.0F / (0.4F + 1.2F) + 0.5F);

            this.playCannonShotSound();

            if (this.owner instanceof ICannonBallContainer container) container.consumeCannonBall();
        }
    }

    private void playCannonShotSound() {
        BiConsumer<SoundEvent, Pair<Float, Float>> play = (sound, modifier) -> {
            if (!this.owner.level().isClientSide()) {
                this.owner.playSound(sound, modifier.getFirst(), modifier.getSecond());
            } else {
                this.owner.level().playLocalSound(this.owner.getX(), this.owner.getY() + 4, this.owner.getZ(), sound,
                        this.owner.getSoundSource(), modifier.getFirst(), modifier.getSecond(), false);
            }
        };

        play.accept(ModSoundTypes.CANNON_SHOT, Pair.of(10.0F, 1.0F));
    }
}