package com.talhanation.smallships.entities;

import com.talhanation.smallships.Main;
import com.talhanation.smallships.entities.projectile.CannonBallEntity;
import com.talhanation.smallships.network.MessageShootCannon;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public abstract class AbstractCannonShip extends AbstractShipDamage{
    private static final DataParameter<Integer> CANNON_COUNT = EntityDataManager.defineId(AbstractCannonShip.class, DataSerializers.INT);
    private static final DataParameter<Boolean> LEFT_CANNON = EntityDataManager.defineId(AbstractCannonShip.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> RIGHT_CANNON = EntityDataManager.defineId(AbstractCannonShip.class, DataSerializers.BOOLEAN);
    public float shootCounter;

    public AbstractCannonShip(EntityType<? extends AbstractCannonShip> type, World world) {
        super(type, world);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(CANNON_COUNT, 2);
    }

    ////////////////////////////////////TICK////////////////////////////////////

    @Override
    public void tick() {
        super.tick();
    }

    ////////////////////////////////////SAVE////////////////////////////////////

    @Override
    public void addAdditionalSaveData(CompoundNBT nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.putInt("CannonCount", getCannonCount());
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT nbt) {
        super.readAdditionalSaveData(nbt);
        setCannonCount(nbt.getInt("CannonCount"));
    }

    ////////////////////////////////////GET////////////////////////////////////

    public int getCannonCount(){
        return entityData.get(CANNON_COUNT);
    }

    public boolean getRightCannon() {
        return entityData.get(RIGHT_CANNON);
    }

    public boolean getLeftCannon() {
        return entityData.get(LEFT_CANNON);
    }


    ////////////////////////////////////SET////////////////////////////////////

    public void setCannonCount(int count){
        entityData.set(CANNON_COUNT, count);
    }

    public void setCannonSide(boolean left, boolean right){
        this.entityData.set(LEFT_CANNON, left);
        this.entityData.set(RIGHT_CANNON, right);
    }

    ////////////////////////////////////ON FUNCTIONS////////////////////////////////////

    public void onCannonKeyPressed(){
        Main.SIMPLE_CHANNEL.sendToServer(new MessageShootCannon(true));
    }

    public Vector3d getShootVector(){
        Vector3d forward = this.getForward();
        Vector3d VecRight = forward.yRot(-3.14F/2);
        Vector3d VecLeft  = forward.yRot(3.14F/2);

        Direction shipDirection = this.getDirection();
        Direction playerDirection = this.getDriver().getDirection();

        switch (shipDirection){
            case NORTH:
                if (playerDirection == Direction.EAST) {
                    setCannonSide(false, true);
                    return VecRight;
                }
                if (playerDirection == Direction.WEST){
                    setCannonSide(true, false);
                    return VecLeft;
                }
                break;
            case SOUTH:
                if (playerDirection == Direction.EAST) {
                    setCannonSide(true, false);
                    return VecLeft;
                }
                if (playerDirection == Direction.WEST){
                    setCannonSide(false, true);
                    return VecRight;
                }
                break;
            case EAST:
                if (playerDirection == Direction.NORTH) {
                    setCannonSide(true, false);
                    return VecLeft;
                }
                if (playerDirection == Direction.SOUTH){
                    setCannonSide(false, true);
                    return VecRight;
                }
                break;
            case WEST:
                if (playerDirection == Direction.NORTH) {
                    setCannonSide(false, true);
                    return VecRight;
                }
                if (playerDirection == Direction.SOUTH){
                    setCannonSide(true, false);
                    return VecLeft;
                }
                break;
        }
        setCannonSide(false,false);
        return null;
    }

    public void shootCannon(boolean s) {
        Vector3d shootVector = this.getShootVector();
        Vector3d forward = this.getForward();
        float speed = 5F;
        float x0 = 0;
        if (shootVector == null){
            return;
        }
        if (getLeftCannon()){
            x0 = 2.1F; //rechst //links
        }
        if (getRightCannon()){
            x0 = -2.1F; //rechst //links
        }
        float f0 = MathHelper.cos(this.yRot * ((float)Math.PI / 180F)) * x0;
        float f1 = MathHelper.sin(this.yRot * ((float)Math.PI / 180F)) * x0;
        float f2 =  -0.75F; // /-/vorne /+/zurück
        double d1 = this.getX() - forward.x * (double) f2 + (double) f0;
        double d2 = this.getY() - forward.y + 1.3D;//hoch
        double d3 = this.getZ() - forward.z * (double) f2 + (double) f1;
        CannonBallEntity cannonBall = new CannonBallEntity(this.level, this.getDriver(), d1,d2,d3);
        //LlamaSpitEntity
        //cannonParticles(d1,d2,d3);
        cannonBall.shoot(shootVector.x(), shootVector.y(), shootVector.z(), speed, 10);
        this.level.addFreshEntity(cannonBall);
        this.level.playSound(null, this.getX(), this.getY() + 4, this.getZ(), SoundEvents.GENERIC_EXPLODE, this.getSoundSource(), 10.0F, 0.8F + 0.4F * this.random.nextFloat());
        //this.level.playSound(null, this.getX(), this.getY() + 4, this.getZ(), ModSoundEvents.CANNON_SHOOT, this.getSoundSource(), 10.0F, 0.8F + 0.4F * this.random.nextFloat());

    }


    ////////////////////////////////////PARTICLE FUNCTIONS////////////////////////////////////



    ////////////////////////////////////OTHER FUNCTIONS////////////////////////////////////


}