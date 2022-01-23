package com.talhanation.smallships.entities;

import com.talhanation.smallships.DamageSourceShip;
import com.talhanation.smallships.Main;
import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.init.SoundInit;
import com.talhanation.smallships.network.MessageControlShip;
import de.maxhenkel.corelib.math.MathUtils;
import net.minecraft.block.BlockState;
import net.minecraft.block.LilyPadBlock;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public abstract class AbstractSailShip extends AbstractWaterVehicle {

    private float wheelRotation;
    private final float[] paddlePositions = new float[2];
    private float waveAngle;
    private float prevWaveAngle;


    private boolean collidedLastTick;

    private static final DataParameter<Float> SPEED = EntityDataManager.defineId(AbstractSailShip.class, DataSerializers.FLOAT);
    private static final DataParameter<Boolean> FORWARD = EntityDataManager.defineId(AbstractSailShip.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> BACKWARD = EntityDataManager.defineId(AbstractSailShip.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> LEFT = EntityDataManager.defineId(AbstractSailShip.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> RIGHT = EntityDataManager.defineId(AbstractSailShip.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Integer> SAIL_STATE = EntityDataManager.defineId(AbstractSailShip.class, DataSerializers.INT);
    private static final DataParameter<String>  SAIL_COLOR = EntityDataManager.defineId(AbstractSailShip.class, DataSerializers.STRING);

    private static final DataParameter<Integer> TYPE = EntityDataManager.defineId(AbstractSailShip.class, DataSerializers.INT);
    private static final DataParameter<Boolean> LEFT_PADDLE = EntityDataManager.defineId(AbstractSailShip.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> RIGHT_PADDLE = EntityDataManager.defineId(AbstractSailShip.class, DataSerializers.BOOLEAN);
    private float momentum;

    public AbstractSailShip(EntityType<? extends AbstractWaterVehicle> type, World world) {
        super(type, world);
        this.maxUpStep = 0.2F;
    }

    @Override
    protected void defineSynchedData() {
        entityData.define(SPEED, 0F);
        entityData.define(FORWARD, false);
        entityData.define(BACKWARD, false);
        entityData.define(LEFT, false);
        entityData.define(RIGHT, false);
        entityData.define(SAIL_STATE, 0);
        entityData.define(SAIL_COLOR, "white");
        this.entityData.define(TYPE, AbstractSailShip.Type.OAK.ordinal());
    }

    ////////////////////////////////////TICK////////////////////////////////////

    public abstract float getMaxSpeed();
    public abstract float getMaxReverseSpeed();
    public abstract float getAcceleration();
    public abstract float getMaxRotationSpeed();
    public abstract float getMinRotationSpeed();
    public abstract float getRollResistance();
    public abstract float getRotationModifier();
    public abstract double getPlayerYOffset();
    public abstract void WaterSplash();

    @Override
    public void tick() {
        super.tick();
        if (isForward()){
            this.knockBack(this.level.getEntities(this, this.getBoundingBox().inflate(4.0D, 2.0D, 4.0D).move(0.0D, -2.0D, 0.0D), EntityPredicates.NO_CREATIVE_OR_SPECTATOR));
            this.knockBack(this.level.getEntities(this, this.getBoundingBox().inflate(4.0D, 2.0D, 4.0D).move(0.0D, -2.0D, 0.0D), EntityPredicates.NO_CREATIVE_OR_SPECTATOR));

            if (this.checkInWater())
                WaterSplash();
        }
        updateGravity();
        controlShip();
        checkPush();
        move(MoverType.SELF, getDeltaMovement());
        updateWheelRotation();
        updateWaterMobs();
        breakLily();
    }
    ////////////////////////////////////SAVE DATA////////////////////////////////////

    @Override
    protected void addAdditionalSaveData(CompoundNBT nbt) {
        nbt.putString("SailColor", getSailColor());
    }

    @Override
    protected void readAdditionalSaveData(CompoundNBT nbt) {
        this.setSailColor(nbt.getString("SailColor"));
        //this.setOwnerUUID(nbt.getUUID("OwnerUUID"));
    }


    ////////////////////////////////////GET////////////////////////////////////

    public String getSailColor() {
        return this.entityData.get(SAIL_COLOR);
    }

    public boolean getSteerState(int side) {
        return this.entityData.<Boolean>get(side == 0 ? LEFT : RIGHT) && this.getControllingPassenger() != null;
    }

    public Integer getSailState() {
        return entityData.get(SAIL_STATE);
    }

    public boolean getPaddleState(int side) {
        return this.entityData.<Boolean>get(side == 0 ? LEFT_PADDLE : RIGHT_PADDLE) && this.getControllingPassenger() != null;
    }

    public float getKilometerPerHour() {
        return (getSpeed() * 20 * 60 * 60) / 1000;
    }

    public float getBiomeModifier() {
        BlockPos pos = new BlockPos(getX(), getY() - 0.1D, getZ());
        BlockState state = level.getBlockState(pos);
        return 1;
    }

    public float getWheelRotationAmount() {
        return 120F * getSpeed();
    }

    public float getWheelRotation(float partialTicks) {
        return wheelRotation + getWheelRotationAmount() * partialTicks;
    }

    public float getSpeed() {
        return this.entityData.get(SPEED);
    }

    public AbstractWaterVehicle.Type getBoatType() {
        return AbstractWaterVehicle.Type.byId(this.entityData.get(TYPE));
    }

    public float getWaveFactor() {
        return level.isRaining() ? 3F : 1.125F;
    }

    public float getWaveSpeed() {
        return level.isRaining() ? 0.15F : 0.06F;
    }

    public float getWaveAngle(float partialTicks) {
        return MathHelper.lerp(partialTicks, this.prevWaveAngle, this.waveAngle);
    }

    public AbstractSailShip.Type getShipType() {
        return AbstractSailShip.Type.byId(this.entityData.get(TYPE));
    }

    public boolean isForward() {
        if (getDriver() == null) {
            return false;
        }
        return entityData.get(FORWARD);
    }


    public boolean isBackward() {
        if (getDriver() == null) {
            return false;
        }
        return entityData.get(BACKWARD);
    }



    public boolean isLeft() {
        return entityData.get(LEFT);
    }


    public boolean isRight() {
        return entityData.get(RIGHT);
    }

    public boolean isAccelerating() {
        boolean b = (isForward() || isBackward()) && !horizontalCollision;
        return b;
    }

    @OnlyIn(Dist.CLIENT)
    public float getRowingTime(int side, float limbSwing) {
        return this.getPaddleState(side) ? (float) MathHelper.clampedLerp((double) this.paddlePositions[side] - (double) ((float) Math.PI / 8F), (double) this.paddlePositions[side], (double) limbSwing) : 0.0F;
    }

////////////////////////////////////SET////////////////////////////////////

    public void setSailColor(String color) {
        entityData.set(SAIL_COLOR, color);
    }

    public void setSailState(int state) {
        if (state != getSailState()) {
            playSailSound(state);
            entityData.set(SAIL_STATE, state);
        }
    }

    public void setSteerState(boolean left, boolean right){
        this.entityData.set(LEFT, left);
        this.entityData.set(RIGHT, right);
    }

    public void setPaddleState(boolean left, boolean right) {
        this.entityData.set(LEFT_PADDLE, left);
        this.entityData.set(RIGHT_PADDLE, right);
    }

    public void setForward(boolean forward) {
        entityData.set(FORWARD, forward);
    }

    public void setBackward(boolean backward) {
        entityData.set(BACKWARD, backward);
    }

    public void setLeft(boolean left) {
        entityData.set(LEFT, left);
    }

    public void setRight(boolean right) {
        entityData.set(RIGHT, right);
    }

    public void setSpeed(float speed) {
        this.entityData.set(SPEED, speed);
    }

    public void setType(AbstractSailShip.Type boatType) {
        this.entityData.set(TYPE, boatType.ordinal());
    }
    ////////////////////////////////////SERVER////////////////////////////////////

    public void sendSailStateToServer(int state) {
        if (level.isClientSide) {
            //Main.SIMPLE_CHANNEL.sendToServer(new MessageSailState(state));
        }
    }

    public void sendSteerStateToServer(){
        //Main.SIMPLE_CHANNEL.sendToServer(new MessageSteerState(this.getSteerState(0), this.getSteerState(1)));
    }

    @Override
    public boolean canCollideWith(Entity entityIn) {
        //SmallShipsConfig.damageEntities.get() &&
        if (entityIn instanceof LivingEntity && !getPassengers().contains(entityIn)) {
            if (entityIn.getBoundingBox().intersects(getBoundingBox())) {
                float speed = getSpeed();
                if (speed > 0.35F) {
                    float damage = speed * 10;
                    entityIn.hurt(DamageSourceShip.DAMAGE_SHIP, damage);
                }

            }
        }
        return super.canCollideWith(entityIn);
    }


    public void checkPush() {
        List<PlayerEntity> list = level.getEntitiesOfClass(PlayerEntity.class, getBoundingBox().expandTowards(0.2, 0, 0.2).expandTowards(-0.2, 0, -0.2));

        for (PlayerEntity player : list) {
            if (!player.hasPassenger(this) && player.isShiftKeyDown()) {
                double motX = calculateMotionX(0.05F, player.yRot);
                double motZ = calculateMotionZ(0.05F, player.yRot);
                move(MoverType.PLAYER, new Vector3d(motX, 0, motZ));
                return;
            }
        }
    }

    private void controlShip() {
        if (!isVehicle()) {
            setForward(false);
            setBackward(false);
            setLeft(false);
            setRight(false);
        }

        float modifier = getBiomeModifier();

        float maxSp = getMaxSpeed() * modifier;
        float maxBackSp = getMaxReverseSpeed() * modifier;

        float speed = MathUtils.subtractToZero(getSpeed(), getRollResistance());

        if (isForward()) {
            if (speed <= maxSp) {
                speed = Math.min(speed + getAcceleration(), maxSp);
            }
        }

        if (isBackward()) {
            if (speed >= -maxBackSp) {
                speed = Math.max(speed - getAcceleration(), -maxBackSp);
            }
        }

        setSpeed(speed);


        float rotationSpeed = 0;
        if (Math.abs(speed) > 0.02F) {
            rotationSpeed = MathHelper.abs(getRotationModifier() / (float) Math.pow(speed, 2));

            rotationSpeed = MathHelper.clamp(rotationSpeed, getMinRotationSpeed(), getMaxRotationSpeed());
        }

        deltaRotation = 0;

        if (speed < 0) {
            rotationSpeed = -rotationSpeed;
        }

        if (isLeft()) {
            deltaRotation -= rotationSpeed;
        }
        if (isRight()) {
            deltaRotation += rotationSpeed;
        }

        yRot += deltaRotation;
        float delta = Math.abs(yRot - yRotO);
        while (yRot > 180F) {
            yRot -= 360F;
            yRotO = yRot - delta;
        }
        while (yRot <= -180F) {
            yRot += 360F;
            yRotO = delta + yRot;
        }
        /*
        if (horizontalCollision) {
            if (level.isClientSide && !collidedLastTick) {
                onCollision(speed);
                collidedLastTick = true;
            }
        } else {
            */
            setDeltaMovement(calculateMotionX(getSpeed(), yRot), getDeltaMovement().y, calculateMotionZ(getSpeed(), yRot));
            if (level.isClientSide) {
                collidedLastTick = false;

        }
    }

    ////////////////////////////////////ON FUNCTIONS////////////////////////////////////

    public void onKeyPressed() {
        int state = getSailState();

        if (state != 4){
            state = 4;

        }else{
            state = 0;
        }

        sendSailStateToServer(state);
    }

    public void onKeyLowerPressed() {
        int state = getSailState();

        if (state != 4){
            state++;

        }

        sendSailStateToServer(state);
    }

    public void onKeyHigherPressed() {
        int state = getSailState();

        if (state != 0){
            state--;

        }
        sendSailStateToServer(state);
    }


    public void onInteractionWithDye(PlayerEntity player, DyeColor dyeColor, ItemStack itemStack) {
        String color = dyeColor.getName();
        setSailColor(color);
        if (!player.isCreative()) {
            itemStack.shrink(1);
        }
    }

    public void onCollision(float speed) {
        if (level.isClientSide) {
            //Main.SIMPLE_CHANNEL.sendToServer(new MessageCrash(speed, this));
        }
        setSpeed(0.01F);
        setDeltaMovement(0D, getDeltaMovement().y, 0D);
    }

    ////////////////////////////////////UPDATE FUNCTIONS////////////////////////////////////

    public void updateWaterMobs() {
        if (SmallShipsConfig.WaterMobFlee.get()) {
            double radius = 15.0D;
            List<WaterMobEntity> list1 = this.level.getEntitiesOfClass(WaterMobEntity.class, new AxisAlignedBB(getX() - radius, getY() - radius, getZ() - radius, getX() + radius, getY() + radius, getZ() + radius));
            for (WaterMobEntity ent : list1)
                fleeEntity(ent);
        }
    }
    public void updateWheelRotation() {
        wheelRotation += getWheelRotationAmount();
    }

    private void updateGravity() {
        double d0 = (double) -0.04F;
        double d1 = this.isNoGravity() ? 0.0D : (double) -0.04F;
        double d2 = 0.0D;
        this.momentum = 0.05F;
        if (this.previousStatus == AbstractWaterVehicle.Status.IN_AIR && this.status != AbstractWaterVehicle.Status.IN_AIR && this.status != AbstractWaterVehicle.Status.ON_LAND) {
            this.waterLevel = this.getY(1.0D);
            this.setPos(this.getX(), (double) (this.getWaterLevelAbove() - this.getBbHeight()) + 0.101D, this.getZ());
            this.setDeltaMovement(this.getDeltaMovement().multiply(1.0D, 0.0D, 1.0D));
            this.lastYd = 0.0D;
            this.status = AbstractWaterVehicle.Status.IN_WATER;
        } else {
            if (this.status == AbstractWaterVehicle.Status.IN_WATER) {
                d2 = (this.waterLevel - this.getY()) / (double) this.getBbHeight();
                this.momentum = 0.9F;
            }

            Vector3d vector3d = this.getDeltaMovement();
            this.setDeltaMovement(vector3d.x * (double) this.momentum, vector3d.y + d1, vector3d.z * (double) this.momentum);
            this.deltaRotation *= this.momentum;
            if (d2 > 0.0D) {
                Vector3d vector3d1 = this.getDeltaMovement();
                this.setDeltaMovement(vector3d1.x, (vector3d1.y + d2 * 0.06153846016296973D) * 0.75D, vector3d1.z);
            }
        }

    }

    public void updateControls(boolean forward, boolean backward, boolean left, boolean right, PlayerEntity player) {
        boolean needsUpdate = false;

        if (isForward() != forward) {
            setForward(forward);
            needsUpdate = true;
        }

        if (isBackward() != backward) {
            setBackward(backward);
            needsUpdate = true;
        }

        if (isLeft() != left) {
            setLeft(left);
            needsUpdate = true;
        }

        if (isRight() != right) {
            setRight(right);
            needsUpdate = true;
        }
        if (this.level.isClientSide && needsUpdate) {
            Main.SIMPLE_CHANNEL.sendToServer(new MessageControlShip(forward, backward, left, right, player));
        }
    }

    ////////////////////////////////////OTHER FUNCTIONS////////////////////////////////////

    public boolean canPlayerEnterShip(PlayerEntity player) {
        return true;
    }

    @Override
    public ActionResultType interact(PlayerEntity player, Hand hand) {
        if (!canPlayerEnterShip(player)) {
            return ActionResultType.FAIL;
        }
        return super.interact(player, hand);
    }


    //////////////////////////////////////SOUND////////////////////////////////////////////

    public void playSailSound(int state) {
        if (state != 0) {
            this.level.playSound(null, this.getX(), this.getY() + 4 , this.getZ(), SoundInit.SHIP_SAIL_0.get(), this.getSoundSource(), 15.0F, 0.8F + 0.4F * this.random.nextFloat());
        } else {
            this.level.playSound(null, this.getX(), this.getY() + 4, this.getZ(), SoundInit.SHIP_SAIL_1.get(), this.getSoundSource(), 10.0F, 0.8F + 0.4F * this.random.nextFloat());
        }
    }

    ////////////////////////////////////OTHER FUNCTIONS////////////////////////////////////

    public void destroyShip(DamageSource dmg) {
        remove();
    }

    public void fleeEntity(MobEntity entity) {
        double fleeDistance = 10.0D;
        Vector3d vecBoat = new Vector3d(getX(), getY(), getZ());
        Vector3d vecEntity = new Vector3d(entity.getX(), entity.getY(), entity.getZ());
        Vector3d fleeDir = vecEntity.subtract(vecBoat);
        fleeDir = fleeDir.normalize();
        Vector3d fleePos = new Vector3d(vecEntity.x + fleeDir.x * fleeDistance, vecEntity.y + fleeDir.y * fleeDistance, vecEntity.z + fleeDir.z * fleeDistance);
        entity.getNavigation().moveTo(fleePos.x, fleePos.y, fleePos.z, 10.0D);
    }

    private void knockBack(List<Entity> entities) {
        double d0 = (this.getBoundingBox().minX + this.getBoundingBox().maxX) / 2.0D;
        double d1 = (this.getBoundingBox().minZ + this.getBoundingBox().maxZ) / 2.0D;

        for(Entity entity : entities) {
            if (entity instanceof LivingEntity) {
                double d2 = entity.getX() - d0;
                double d3 = entity.getZ() - d1;
                double d4 = Math.max(d2 * d2 + d3 * d3, 0.1D);
                entity.push(d2 / d4 * 0.4D, (double)0.0F, d3 / d4 * 0.4D);
            }
        }

    }

    private boolean checkInWater() {
        AxisAlignedBB axisalignedbb = this.getBoundingBox();
        int i = MathHelper.floor(axisalignedbb.minX);
        int j = MathHelper.ceil(axisalignedbb.maxX);
        int k = MathHelper.floor(axisalignedbb.minY);
        int l = MathHelper.ceil(axisalignedbb.minY + 0.001D);
        int i1 = MathHelper.floor(axisalignedbb.minZ);
        int j1 = MathHelper.ceil(axisalignedbb.maxZ);
        boolean flag = false;
        this.waterLevel = Double.MIN_VALUE;
        BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

        for (int k1 = i; k1 < j; ++k1) {
            for (int l1 = k; l1 < l; ++l1) {
                for (int i2 = i1; i2 < j1; ++i2) {
                    blockpos$mutable.set(k1, l1, i2);
                    FluidState fluidstate = this.level.getFluidState(blockpos$mutable);
                    if (fluidstate.is(FluidTags.WATER)) {
                        float f = (float) l1 + fluidstate.getHeight(this.level, blockpos$mutable);
                        this.waterLevel = Math.max((double) f, this.waterLevel);
                        flag |= axisalignedbb.minY < (double) f;
                    }
                }
            }
        }

        return flag;
    }

    private void breakLily() {
        AxisAlignedBB boundingBox = getBoundingBox();
        double offset = 0.75D;
        BlockPos start = new BlockPos(boundingBox.minX - offset, boundingBox.minY - offset, boundingBox.minZ - offset);
        BlockPos end = new BlockPos(boundingBox.maxX + offset, boundingBox.maxY + offset, boundingBox.maxZ + offset);
        BlockPos.Mutable pos = new BlockPos.Mutable();
        boolean hasBroken = false;
        if (level.hasChunksAt(start, end)) {
            for (int i = start.getX(); i <= end.getX(); ++i) {
                for (int j = start.getY(); j <= end.getY(); ++j) {
                    for (int k = start.getZ(); k <= end.getZ(); ++k) {
                        pos.set(i, j, k);
                        BlockState blockstate = level.getBlockState(pos);
                        if (blockstate.getBlock() instanceof LilyPadBlock) {
                            level.destroyBlock(pos, true);
                            hasBroken = true;
                        }
                    }
                }
            }
        }
        if (hasBroken) {
            level.playSound(null, getX(), getY(), getZ(), SoundEvents.CROP_BREAK, SoundCategory.BLOCKS, 1F, 0.9F + 0.2F * random.nextFloat());
        }
    }


    public Item getItemBoat() {
        switch (this.getBoatType()) {
            case OAK:
            default:
                return Items.OAK_BOAT;
            case SPRUCE:
                return Items.SPRUCE_BOAT;
            case BIRCH:
                return Items.BIRCH_BOAT;
            case JUNGLE:
                return Items.JUNGLE_BOAT;
            case ACACIA:
                return Items.ACACIA_BOAT;
            case DARK_OAK:
                return Items.DARK_OAK_BOAT;
        }
    }

    public enum Type {
        OAK("oak"),
        SPRUCE("spruce"),
        BIRCH("birch"),
        JUNGLE("jungle"),
        ACACIA("acacia"),
        DARK_OAK("dark_oak");
        /*
        //BOP
        BOP_CHERRY("bop_cherry"),
        BOP_DEAD("bop_cherry"),
        BOP_FIR("bop_fir"),
        BOP_HELLBARK("bop_hellbark"),
        BOP_JACARANDA("bop_jacaranda"),
        BOP_MAGIC("bop_magic"),
        BOP_MAHOGANY("bop_mahogany"),
        BOP_PALM("bop_palm"),
        BOP_REDWOOD("bop_redwood"),
        BOP_UMBRAN("bop_umbran"),
        BOP_WILLOW("bop_willow"),
        //LOTR
        LOTR_APPLE("lotr_apple"),
        LOTR_ASPEN("lotr_aspen"),
        LOTR_BEECH("lotr_beech"),
        LOTR_CEDAR("lotr_cedar"),
        LOTR_CHARRED("lotr_charred"),
        LOTR_CHERRY("lotr_cherry"),
        LOTR_CYPRESS("lotr_cypress"),
        LOTR_FIR("lotr_fir"),
        LOTR_GREEN_OAK("lotr_green_oak"),
        LOTR_HOLLY("lotr_holly"),
        LOTR_LAIRELOSSE("lotr_lairelosse"),
        LOTR_LARCH("lotr_larch"),
        LOTR_LEBETHRON("lotr_lebethron"),
        LOTR_MALLORN("lotr_mallorn"),
        LOTR_MAPLE("lotr_maple"),
        LOTR_MIRK_OAK("lotr_mirk_oak"),
        LOTR_PEAR("lotr_pear"),
        LOTR_PINE("lotr_pine"),
        LOTR_ROTTEN("lotr_rotten"),
        //ENVI
        ENVI_CHERRY("envi_cherry"),
        ENVI_WISTERIA("envi_wisteria"),
        ENVI_WILLOW("envi_willow");

         */


        private final String name;

        Type(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }


        public String toString() {
            return this.name;
        }

        /**
         * Get a boat type by it's enum ordinal
         */
        public static AbstractSailShip.Type byId(int id) {
            AbstractSailShip.Type[] aboatentity$type = values();
            if (id < 0 || id >= aboatentity$type.length) {
                id = 0;
            }

            return aboatentity$type[id];
        }

        public static AbstractSailShip.Type getTypeFromString(String nameIn) {
            AbstractSailShip.Type[] aboatentity$type = values();

            for (int i = 0; i < aboatentity$type.length; ++i) {
                if (aboatentity$type[i].getName().equals(nameIn)) {
                    return aboatentity$type[i];
                }
            }

            return aboatentity$type[0];
        }
    }


}