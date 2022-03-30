package com.talhanation.smallships.entities;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.talhanation.smallships.Main;
import com.talhanation.smallships.client.render.RenderCannon;
import com.talhanation.smallships.entities.projectile.CannonBallEntity;
import com.talhanation.smallships.init.ModItems;
import com.talhanation.smallships.init.SoundInit;
import com.talhanation.smallships.network.MessageShootCannon;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public abstract class AbstractCannonShip extends AbstractShipDamage{
    private static final DataParameter<Integer> RIGHT_CANNON_COUNT = EntityDataManager.defineId(AbstractCannonShip.class, DataSerializers.INT);
    private static final DataParameter<Integer> LEFT_CANNON_COUNT = EntityDataManager.defineId(AbstractCannonShip.class, DataSerializers.INT);
    private static final DataParameter<Boolean> LEFT_CANNON = EntityDataManager.defineId(AbstractCannonShip.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> RIGHT_CANNON = EntityDataManager.defineId(AbstractCannonShip.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Integer> LEFT_SHOOT_COOLDOWN = EntityDataManager.defineId(AbstractCannonShip.class, DataSerializers.INT);
    private static final DataParameter<Integer> RIGHT_SHOOT_COOLDOWN = EntityDataManager.defineId(AbstractCannonShip.class, DataSerializers.INT);

    public AbstractCannonShip(EntityType<? extends AbstractCannonShip> type, World world) {
        super(type, world);

    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(RIGHT_CANNON_COUNT, 0);
        this.entityData.define(LEFT_CANNON_COUNT, 0);
        this.entityData.define(RIGHT_CANNON, false);
        this.entityData.define(LEFT_CANNON, false);
        this.entityData.define(LEFT_SHOOT_COOLDOWN, 30);
        this.entityData.define(RIGHT_SHOOT_COOLDOWN, 30);
    }
    ////////////////////////////////////TICK////////////////////////////////////

    @Override
    public void tick() {
        super.tick();
        updateCountdown();

        if (this.getDriver() != null) {

          //  Vector3d forward = this.getForward().normalize();
          //  Vector3d VecLeft  = forward.yRot(3.14F/2).normalize();
          //  Vector3d playerVec = this.getDriver().getLookAngle().normalize();
            //this.getDriver().sendMessage(new StringTextComponent("Timer: "), this.getDriver().getUUID());
        }
    }

    private void updateCountdown() {
        if (this.getRightShootCoolDown() >= 0) {
            this.setRightShootCoolDown(getRightShootCoolDown() - 1);
        }

        if (this.getLeftShootCoolDown() >= 0) {
            this.setLeftShootCoolDown(getLeftShootCoolDown() - 1);
        }
    }

    ////////////////////////////////////SAVE////////////////////////////////////

    @Override
    public void addAdditionalSaveData(CompoundNBT nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.putInt("RightCannonCount", getRightCannonCount());
        nbt.putInt("LeftCannonCount", getLeftCannonCount());
        nbt.putInt("LeftShootCoolDown", getLeftShootCoolDown());
        nbt.putInt("RightShootCoolDown", getRightShootCoolDown());
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT nbt) {
        super.readAdditionalSaveData(nbt);
        setRightCannonCount(nbt.getInt("RightCannonCount"));
        setLeftCannonCount(nbt.getInt("LeftCannonCount"));
        setRightShootCoolDown(nbt.getInt("RightShootCoolDown"));
        setLeftShootCoolDown(nbt.getInt("LeftShootCoolDown"));
    }

    ////////////////////////////////////GET////////////////////////////////////

    public abstract int getMaxCannons();

    public int getRightShootCoolDown(){
        return this.entityData.get(RIGHT_SHOOT_COOLDOWN);
    }

    public int getLeftShootCoolDown(){
        return this.entityData.get(LEFT_SHOOT_COOLDOWN);
    }

    public int getRightCannonCount(){
        return entityData.get(RIGHT_CANNON_COUNT);
    }

    public int getLeftCannonCount(){
        return entityData.get(LEFT_CANNON_COUNT);
    }

    public boolean getRightCannon() {
        return entityData.get(RIGHT_CANNON);
    }

    public boolean getLeftCannon() {
        return entityData.get(LEFT_CANNON);
    }

    public boolean canShoot(){
        return hasGunPowder() && hasCannonBall();
    }

    public boolean hasGunPowder(){
        Inventory inventory = this.getInventory();
        for(int i = 0; i < inventory.getContainerSize(); i++){
            ItemStack itemStack = inventory.getItem(i);
            if (itemStack.getItem() == Items.GUNPOWDER){
                return true;
            }
        }
        return false;
    }

    public boolean hasCannonBall(){
        Inventory inventory = this.getInventory();
        for(int i = 0; i < inventory.getContainerSize(); i++){
            ItemStack itemStack = inventory.getItem(i);
            if (itemStack.getItem() == ModItems.CANNONBALL.get()){
                return true;
            }
        }
        return false;
    }

    ////////////////////////////////////SET////////////////////////////////////

    public void setRightCannonCount(int count){
        entityData.set(RIGHT_CANNON_COUNT, count);
    }

    public void setLeftCannonCount(int count){
        entityData.set(LEFT_CANNON_COUNT, count);
    }

    public void setRightShootCoolDown(int i){
        this.entityData.set(RIGHT_SHOOT_COOLDOWN, i);
    }

    public void setLeftShootCoolDown(int i){
        this.entityData.set(LEFT_SHOOT_COOLDOWN, i);
    }


    ////////////////////////////////////ON FUNCTIONS////////////////////////////////////

    public void onCannonKeyPressed(){
        if (this.getLeftShootCoolDown() <= 0 || this.getRightShootCoolDown() <= 0) {
            Main.SIMPLE_CHANNEL.sendToServer(new MessageShootCannon(true));
        }
    }

    public Vector3d getShootVector(){
        Vector3d forward = this.getForward().normalize();
        Vector3d VecRight = forward.yRot(-3.14F/2).normalize();
        Vector3d VecLeft  = forward.yRot(3.14F/2).normalize();


        Vector3d playerVec = this.getDriver().getLookAngle().normalize();

        if (playerVec.distanceTo(VecLeft) > playerVec.distanceTo(VecRight)) {
            return VecRight;
        }

        if (playerVec.distanceTo(VecLeft) < playerVec.distanceTo(VecRight)) {
            return VecLeft;
        }
        return null;
    }

    public void startCannons(boolean a) {
        this.level.playSound(null, this.getX(), this.getY() + 4, this.getZ(), SoundEvents.TNT_PRIMED, this.getSoundSource(), 10.0F, 0.8F + 0.4F * this.random.nextFloat());
        shootCannons();
    }

    public void shootCannons() {
        Vector3d shootVector = this.getShootVector();
        Vector3d forward = this.getForward();

        Vector3d VecRight = forward.yRot(-3.14F/2).normalize();
        Vector3d VecLeft  = forward.yRot(3.14F/2).normalize();
        boolean shoot = false;
        float x0 = 0;
        int cannonCount = 0;

        if (shootVector == null) {
            return;
        }

        if (shootVector.distanceTo(VecLeft) > shootVector.distanceTo(VecRight) && this.getRightShootCoolDown() <= 0) {
            this.setRightShootCoolDown(60);
            x0 = -1F; //rechst //links
            cannonCount = getRightCannonCount();
            shoot = true;
        }

        if (shootVector.distanceTo(VecLeft) < shootVector.distanceTo(VecRight) && this.getLeftShootCoolDown() <= 0) {
            this.setLeftShootCoolDown(60);
            x0 = 1F; //rechst //links
            cannonCount = getLeftCannonCount();
            shoot = true;
        }

        if (shoot){

            float speed = 2.5F;
            float k = 2F;

            boolean playerView= getDriver().getLookAngle().y >= 0;
            double yShootVec = playerView ? shootVector.y() + getDriver().getLookAngle().y * 0.75F : shootVector.y() + 0.25F;

;
            float f2 = 0;
            this.getDriver().sendMessage(new StringTextComponent("cannons: " + cannonCount), getDriver().getUUID());
            for(int i = 0; i < cannonCount; i++){
                switch (i){
                    case 0: f2 = 0.2F;
                    break;
                    case 1: f2 = -1.4F;
                    break;
                    case 2: f2 = -3.8F;
                    break;
                }
            if (canShoot())
                shootCannon(forward, shootVector, yShootVec, speed, f2, k, x0);
            }
        }
    }

    public void shootCannon(Vector3d forward, Vector3d shootVector, double yShootVec, float speed, float f2, float k, float x0){
        float f0 = MathHelper.cos(this.yRot * ((float) Math.PI / 180F)) * x0;
        float f1 = MathHelper.sin(this.yRot * ((float) Math.PI / 180F)) * x0;
        //float f2 = 0.2F; // /-/vorne /+/zurück
        double d1 = this.getX() - forward.x * (double) f2 + (double) f0;
        double d2 = this.getY() - forward.y + 1;//hoch
        double d3 = this.getZ() - forward.z * (double) f2 + (double) f1;

        CannonBallEntity cannonBallEntity = new CannonBallEntity(this.level, this.getDriver(), d1, d2, d3);
        cannonBallEntity.shoot(shootVector.x() ,yShootVec , shootVector.z(), speed, k);
        this.level.addFreshEntity(cannonBallEntity);
        this.level.playSound(null, this.getX(), this.getY() + 4, this.getZ(), SoundInit.CANNON_SHOOT.get(), this.getSoundSource(), 10.0F, 0.8F + 0.4F * this.random.nextFloat());

        //decrease items
        handleItemsOnShoot();
    }

    ////////////////////////////////////OTHER FUNCTIONS////////////////////////////////////

    public void handleItemsOnShoot(){
        Inventory inventory = this.getInventory();
        for(int i = 0; i < inventory.getContainerSize(); i++) {
            ItemStack itemStack = inventory.getItem(i);
            if (itemStack.getItem() == Items.GUNPOWDER) {
                itemStack.shrink(1);
            }
        }

        for(int i = 0; i < inventory.getContainerSize(); i++){
            ItemStack itemStack = inventory.getItem(i);
            if (itemStack.getItem() == Items.IRON_BLOCK){
                itemStack.shrink(1);
            }
        }
    }

    public void renderCannon(MatrixStack matrixStack, IRenderTypeBuffer buffer , int packedLight, float partialTicks) {
        if (getLeftCannonCount() != 0) {
            for (int i = 0; i < getLeftCannonCount(); i++) {
                double offset = 0;
                switch (i) {
                    case 0:
                        offset = 1;
                        break;
                    case 1:
                        offset = -0.2;
                        break;
                    case 2:
                        offset = -1.5;
                        break;
                }
                RenderCannon.renderCannon(offset, 0,this, partialTicks, matrixStack, buffer, packedLight);
            }
        }
        if (getRightCannonCount() != 0) {
            for (int i = 0; i < getRightCannonCount(); i++) {
                double offset = 0;
                switch (i) {
                    case 0:
                        offset = -1;
                        break;
                    case 1:
                        offset = 0.2;
                        break;
                    case 2:
                        offset = 1.5;
                        break;
                }
                RenderCannon.renderCannon(offset,180, this, partialTicks, matrixStack, buffer, packedLight);
            }
        }
    }

    public void onInteractionWithCannon(PlayerEntity player, ItemStack itemStack) {
        if (getRightCannonCount() + getLeftCannonCount() != getMaxCannons()) {
            if (getRightCannonCount() == getLeftCannonCount()) {
                setRightCannonCount(getRightCannonCount() + 1);
            } else
                setLeftCannonCount(getLeftCannonCount() + 1);

            if (!player.isCreative()) {
                itemStack.shrink(1);
            }
        }
    }
}