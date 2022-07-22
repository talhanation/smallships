package com.talhanation.smallships.entities;

import com.mojang.blaze3d.vertex.PoseStack;
import com.talhanation.smallships.Main;
import com.talhanation.smallships.client.render.RenderCannon;
import com.talhanation.smallships.entities.projectile.CannonBallEntity;
import com.talhanation.smallships.init.ModItems;
import com.talhanation.smallships.init.SoundInit;
import com.talhanation.smallships.network.MessageShootCannon;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public abstract class AbstractCannonShip extends AbstractShipDamage{
    private static final EntityDataAccessor<Integer> RIGHT_CANNON_COUNT = SynchedEntityData.defineId(AbstractCannonShip.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> LEFT_CANNON_COUNT = SynchedEntityData.defineId(AbstractCannonShip.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> LEFT_CANNON = SynchedEntityData.defineId(AbstractCannonShip.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> RIGHT_CANNON = SynchedEntityData.defineId(AbstractCannonShip.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> LEFT_SHOOT_COOLDOWN = SynchedEntityData.defineId(AbstractCannonShip.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> RIGHT_SHOOT_COOLDOWN = SynchedEntityData.defineId(AbstractCannonShip.class, EntityDataSerializers.INT);

    public AbstractCannonShip(EntityType<? extends AbstractCannonShip> type, Level world) {
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
    public void addAdditionalSaveData(CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.putInt("RightCannonCount", getRightCannonCount());
        nbt.putInt("LeftCannonCount", getLeftCannonCount());
        nbt.putInt("LeftShootCoolDown", getLeftShootCoolDown());
        nbt.putInt("RightShootCoolDown", getRightShootCoolDown());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        setRightCannonCount(nbt.getInt("RightCannonCount"));
        setLeftCannonCount(nbt.getInt("LeftCannonCount"));
        setRightShootCoolDown(nbt.getInt("RightShootCoolDown"));
        setLeftShootCoolDown(nbt.getInt("LeftShootCoolDown"));
    }

    ////////////////////////////////////GET////////////////////////////////////

    public abstract int getMaxCannons();

    public int getTotalCannonCount(){
        return getRightCannonCount() + getLeftCannonCount();
    }

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
        SimpleContainer inventory = this.getInventory();
        for(int i = 0; i < inventory.getContainerSize(); i++){
            ItemStack itemStack = inventory.getItem(i);
            if (itemStack.getItem() == Items.GUNPOWDER){
                return true;
            }
        }
        return false;
    }

    public boolean hasCannonBall(){
        SimpleContainer inventory = this.getInventory();
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

    public Vec3 getShootVector(){
        Vec3 forward = this.getForward().normalize();
        Vec3 VecRight = forward.yRot(-3.14F/2).normalize();
        Vec3 VecLeft  = forward.yRot(3.14F/2).normalize();


        Vec3 playerVec = this.getDriver().getLookAngle().normalize();

        if (playerVec.distanceTo(VecLeft) > playerVec.distanceTo(VecRight)) {
            return VecRight;
        }

        if (playerVec.distanceTo(VecLeft) < playerVec.distanceTo(VecRight)) {
            return VecLeft;
        }
        return null;
    }

    public void startCannons(boolean a) {
        if ((this.getTotalCannonCount() >= 1)) {
            shootCannons();
        }
    }

    public void shootCannons() {
        Vec3 shootVector = this.getShootVector();
        Vec3 forward = this.getForward();

        Vec3 VecRight = forward.yRot(-3.14F/2).normalize();
        Vec3 VecLeft  = forward.yRot(3.14F/2).normalize();
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

            float f2 = 0;
            for(int i = 0; i < cannonCount; i++){
                switch (i) {
                    case 0 -> f2 = 0.2F;
                    case 1 -> f2 = -1.4F;
                    case 2 -> f2 = -3.8F;
                }
            if (canShoot())
                shootCannon(forward, shootVector, yShootVec, speed, f2, k, x0);
            }
        }
    }

    public void shootCannon(Vec3 forward, Vec3 shootVector, double yShootVec, float speed, float f2, float k, float x0){
        float f0 = Mth.cos(this.getYRot() * ((float) Math.PI / 180F)) * x0;
        float f1 = Mth.sin(this.getYRot() * ((float) Math.PI / 180F)) * x0;
        //float f2 = 0.2F; // /-/vorne /+/zurück
        double d1 = this.getX() - forward.x * (double) f2 + (double) f0;
        double d2 = this.getY() - forward.y + 1;//hoch
        double d3 = this.getZ() - forward.z * (double) f2 + (double) f1;

        CannonBallEntity cannonBallEntity = new CannonBallEntity(this.level, this.getDriver(), d1, d2, d3);
        cannonBallEntity.shoot(shootVector.x() ,yShootVec , shootVector.z(), speed, k);
        this.level.addFreshEntity(cannonBallEntity);
        this.level.playSound(null, this.getX(), this.getY() + 4, this.getZ(), SoundEvents.TNT_PRIMED, this.getSoundSource(), 10.0F, 0.8F + 0.4F * this.random.nextFloat());
        this.level.playSound(null, this.getX(), this.getY() + 4, this.getZ(), SoundInit.CANNON_SHOOT.get(), this.getSoundSource(), 10.0F, 0.8F + 0.4F * this.random.nextFloat());

        //decrease items
        handleItemsOnShoot();
    }

    ////////////////////////////////////OTHER FUNCTIONS////////////////////////////////////

    public void handleItemsOnShoot() {
        SimpleContainer inventory = this.getInventory();

        int cannonball = 0;
        int gunpowder = 0;

        Item gunpowderItem = Items.GUNPOWDER;
        Item cannonballItem = ModItems.CANNONBALL.get();

        this.shrinkItemInInv(inventory, gunpowderItem, 1);
        this.shrinkItemInInv(inventory, cannonballItem, 1);
    }
    
    public void renderCannon(double Zoffset, double height, float angle, PoseStack matrixStack, MultiBufferSource buffer , int packedLight, float partialTicks) {
        if (getLeftCannonCount() != 0) {
            for (int i = 0; i < getLeftCannonCount(); i++) {
                double offset = switch (i) {
                    case 0 -> 1;
                    case 1 -> -0.2;
                    case 2 -> -1.5;
                    default -> 0;
                };
                RenderCannon.renderCannon(Zoffset, offset, height, angle, this, partialTicks, matrixStack, buffer, packedLight);
            }
        }
        if (getRightCannonCount() != 0) {
            for (int i = 0; i < getRightCannonCount(); i++) {
                double offset = switch (i) {
                    case 0 -> -1;
                    case 1 -> 0.2;
                    case 2 -> 1.5;
                    default -> 0;
                };
                RenderCannon.renderCannon(Zoffset, offset, height, angle + 180, this, partialTicks, matrixStack, buffer, packedLight);
            }
        }
    }

    public void onInteractionWithCannon(Player player, ItemStack itemStack) {
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

    public void shrinkItemInInv(SimpleContainer inventory, Item item, int count){

        for (int i = 0; i < inventory.getContainerSize(); i++){
            ItemStack itemStackInSlot = inventory.getItem(i);
            Item itemInSlot = itemStackInSlot.getItem();
            if (itemInSlot == item){
                itemStackInSlot.shrink(count);
                break;
            }
        }
    }
}