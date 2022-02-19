package com.talhanation.smallships.entities;

import com.talhanation.smallships.Main;
import com.talhanation.smallships.entities.projectile.CannonBallEntity;
import com.talhanation.smallships.init.ModEntityTypes;
import com.talhanation.smallships.inventory.BasicShipContainer;
import com.talhanation.smallships.network.MessageOpenGui;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.LlamaSpitEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;

public class CogEntity extends AbstractCannonShip{

    private static final DataParameter<Integer> CARGO = EntityDataManager.defineId(CogEntity.class, DataSerializers.INT);

    public CogEntity(EntityType<? extends CogEntity> type, World world) {
        super(type, world);
    }

    //Constructor for ShipItem
    public CogEntity(World world, double x, double y, double z) {
        this(ModEntityTypes.COG_ENTITY.get(), world);
        setPos(x, y, z);
        //setDeltaMovement(Vector3d.ZERO);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }


    ///////////////////////////////////TICK/////////////////////////////////////////

    public void tick() {
        super.tick();
        initInventory();
    }

    // hight and width for now as mast
    @Override
    public double getWidth() {
        return 3D;
    }

    @Override
    public double getHeight() {
        return 1.5D;
    }

    ////////////////////////////////////DATA////////////////////////////////////

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(CARGO, 0);
    }

    ////////////////////////////////////SAVE DATA////////////////////////////////////

    @Override
    public void addAdditionalSaveData(CompoundNBT nbt) {
       super.addAdditionalSaveData(nbt);
        nbt.putInt("Cargo", getCargo());
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT nbt) {
        super.readAdditionalSaveData(nbt);
        this.setCargo(nbt.getInt("Cargo"));
    }

    @Override
    public double getShipDefense() { //in %
        return 30;
    }


    ////////////////////////////////////GET////////////////////////////////////

    public int getCargo() {
        return entityData.get(CARGO);
    }

    @Override
    public int getInventorySize() {
        return 54;
    }

    @Override
    public float getMaxSpeed() {
        return 0.5F;
    }

    @Override
    public float getMaxReverseSpeed() {
        return 0.1F;
    }

    @Override
    public float getAcceleration() {
        return 0.03F;
    }

    @Override
    public float getMaxRotationSpeed() {
        return 1.0F;
    }

    @Override
    public float getRotationAcceleration() {
        return 0.3F;
    }

    @Override
    public float getRollResistance() {
        return 0.009F;
    }

    @Override
    public ResourceLocation getLootTable() {
        return null;
    }

    @Override
    public int getPassengerSize() {
        return 6;
    }

    ////////////////////////////////////SET////////////////////////////////////

    public void setCargo(int cargo){
        entityData.set(CARGO, cargo);
    }

    ////////////////////////////////////INTERACTIONS///////////////////////////////

    @Override
    public ActionResultType interact(PlayerEntity player, Hand hand) {

        ItemStack itemInHand = player.getItemInHand(hand);
/*
        if (itemInHand.getItem().equals(Items.LANTERN) && getMaxLanternCount() != getLanternCount()){
            onInteractionWithLantern(player, itemInHand);
            return ActionResultType.SUCCESS;
        }
*/
        if (itemInHand.getItem() == Items.FLINT_AND_STEEL){

            Vector3d forward = player.getViewVector(1);
            float x0 = 0; // /-/rechst /+/links //no need
            float yOffset = 2;// /+/hoch
            float offset = -2;// /-/vorne /+/zurück

            float f0 = MathHelper.cos(this.yRot * ((float)Math.PI / 180F)) * x0;
            float f1 = MathHelper.sin(this.yRot * ((float)Math.PI / 180F)) * x0;
            float f2 = offset;

            double d1 = this.getX() - forward.x * (double) f2 + (double) f0;
            double d2 = this.getY() - forward.y + yOffset;
            double d3 = this.getZ() - forward.z * (double) f2 + (double) f1;

            //LlamaSpitEntity cannonBallEntity = new LlamaSpitEntity(this.level, d1, d2, d3, d1, d2, d3);
            CannonBallEntity cannonBallEntity = new CannonBallEntity(this.level, player, d1, d2, d3);
            cannonBallEntity.shoot(d1, d2, d3, 1, 2);
            level.addFreshEntity(cannonBallEntity);
            return ActionResultType.SUCCESS;
        }

        if (itemInHand.getItem() instanceof DyeItem){
            this.onInteractionWithDye(player, ((DyeItem) itemInHand.getItem()).getDyeColor(), itemInHand);
            return ActionResultType.SUCCESS;
        }

        if (itemInHand.getItem() instanceof BannerItem){
            this.onInteractionWithBanner(itemInHand,player);
            return ActionResultType.SUCCESS;
        }
/*
        if (itemInHand.getItem() instanceof PickaxeItem){
            return this.onInteractionWithAxeItem(player)  ? ActionResultType.SUCCESS : ActionResultType.PASS;
        }
*/
//&& this.getShipDamage() > 0
        else if (itemInHand.getItem() instanceof ShearsItem){
            if (this.getHasBanner()){
                this.onInteractionWithShears(player);
                return ActionResultType.SUCCESS;
            }
            return ActionResultType.PASS;
        }

        else if (player.isSecondaryUseActive()) {

            if (this.isVehicle() && !(getControllingPassenger() instanceof PlayerEntity)){
                this.ejectPassengers();
                //this.passengerwaittime = 200;
            }

            else {
                if (!(getControllingPassenger() instanceof PlayerEntity)) {
                    this.openGUI(player);
                } return ActionResultType.sidedSuccess(this.level.isClientSide);
            } return ActionResultType.PASS;
        }

        else if (!player.isSecondaryUseActive()){

            if (!this.level.isClientSide) {
                return player.startRiding(this) ? ActionResultType.CONSUME : ActionResultType.PASS;

            } else {
                return ActionResultType.SUCCESS;
            }


        } else {
            return ActionResultType.PASS;
        }
    }

    @Override
    public void openGUI(PlayerEntity player) {
        if (player instanceof ServerPlayerEntity) {
            NetworkHooks.openGui((ServerPlayerEntity) player, new INamedContainerProvider() {
                @Override
                public ITextComponent getDisplayName() {
                    return getName();
                }

                @Nullable
                @Override
                public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
                    return new BasicShipContainer(i, CogEntity.this, playerInventory);
                }
            }, packetBuffer -> {packetBuffer.writeUUID(getUUID());});
        } else {
            Main.SIMPLE_CHANNEL.sendToServer(new MessageOpenGui(player));
        }
    }

    @Override
    public boolean doesEnterThirdPerson() {
        return true;
    }


    ////////////////////////////////////OTHER FUNCTIONS////////////////////////////////////
    @Override
    public void WaterSplash(){
        Vector3d vector3d = this.getViewVector(0.0F);
        float f0 = MathHelper.cos(this.yRot * ((float)Math.PI / 180F)) * 0.8F;
        float f1 = MathHelper.sin(this.yRot * ((float)Math.PI / 180F)) * 0.8F;
        float f0_1 = MathHelper.cos(this.yRot * ((float)Math.PI / 180F)) * 1.6F;
        float f1_1 = MathHelper.sin(this.yRot * ((float)Math.PI / 180F)) * 1.6F;
        float f2 =  2.5F - this.random.nextFloat() * 0.7F;
        float f2_ =  -1.3F - this.random.nextFloat() * 0.7F;
        float x = 0;
        for (int i = 0; i < 2; ++i) {
            this.level.addParticle(ParticleTypes.DOLPHIN, this.getX() - vector3d.x * (double) f2 + (double) f0, this.getY() - vector3d.y + 0.5D, this.getZ() - vector3d.z * (double) f2 + (double) f1, 0.0D, 0.0D, 0.0D);
            this.level.addParticle(ParticleTypes.DOLPHIN, this.getX() - vector3d.x * (double) f2 - (double) f0, this.getY() - vector3d.y + 0.5D, this.getZ() - vector3d.z * (double) f2 - (double) f1, 0.0D, 0.0D, 0.0D);
            this.level.addParticle(ParticleTypes.DOLPHIN, this.getX() - vector3d.x * (double) f2 + (double) f0, this.getY() - vector3d.y + 0.5D, this.getZ() - vector3d.z * (double) f2 + (double) f1 * 1.1, 0.0D, 0.0D, 0.0D);
            this.level.addParticle(ParticleTypes.DOLPHIN, this.getX() - vector3d.x * (double) f2 - (double) f0, this.getY() - vector3d.y + 0.5D, this.getZ() - vector3d.z * (double) f2 - (double) f1 * 1.1, 0.0D, 0.0D, 0.0D);

            this.level.addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2 + (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) f2 + (double) f1, 0.0D, 0.0D, 0.0D);
            this.level.addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2 - (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) f2 - (double) f1, 0.0D, 0.0D, 0.0D);
            this.level.addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2 + (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) f2 + (double) f1 * 1.1, 0.0D, 0.0D, 0.0D);
            this.level.addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2 - (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) f2 - (double) f1 * 1.1, 0.0D, 0.0D, 0.0D);

            this.level.addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2_ + (double) f0_1, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) + (double) f1_1, 0.0D, 0.0D, 0.0D);
            this.level.addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2_ - (double) f0_1, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) - (double) f1_1, 0.0D, 0.0D, 0.0D);
            this.level.addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2_ + (double) f0_1, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) + (double) f1_1 * 1.1, 0.0D, 0.0D, 0.0D);
            this.level.addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2_ - (double) f0_1, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) - (double) f1_1 * 1.1, 0.0D, 0.0D, 0.0D);

            this.level.addParticle(ParticleTypes.BUBBLE, this.getX() - vector3d.x * (double) f2_ + (double) f0_1, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) + (double) f1_1, 0.0D, 0.0D, 0.0D);
            this.level.addParticle(ParticleTypes.BUBBLE, this.getX() - vector3d.x * (double) f2_ - (double) f0_1, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) - (double) f1_1, 0.0D, 0.0D, 0.0D);
            this.level.addParticle(ParticleTypes.BUBBLE, this.getX() - vector3d.x * (double) f2_ + (double) f0_1, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) + (double) f1_1 * 1.1, 0.0D, 0.0D, 0.0D);
            this.level.addParticle(ParticleTypes.BUBBLE, this.getX() - vector3d.x * (double) f2_ - (double) f0_1, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) - (double) f1_1 * 1.1, 0.0D, 0.0D, 0.0D);

        }
    }

    @Override
    public void positionRider(Entity passenger) {
        if (hasPassenger(passenger)) {
            float f = -1.75F; //driver x pos
            float d = 0.0F;   //driver z pos
            float x = 0;//global offset
            float f1 = (float) ((this.removed ? 0.02D : getPassengersRidingOffset()) + passenger.getMyRidingOffset());
            if (getPassengers().size() == 2) {
                int i = getPassengers().indexOf(passenger);
                if (i == 0) {

                    f = -1.75F;
                    d = 0.0F;
                } else {
                    f = 1.25F;
                    d = 0.0F;
                }
            } else if (getPassengers().size() == 3) {
                int i = getPassengers().indexOf(passenger);
                if (i == 0) {
                    f = -1.75F;
                    d = 0.0F;
                } else if (i == 1) {
                    f = 1.25F;
                    d = 0.9F;
                } else {
                    f = 1.25F;
                    d = -0.90F;
                }
            }else if (getPassengers().size() == 4) {
                int i = getPassengers().indexOf(passenger);
                if (i == 0) {
                    f = -1.75F;
                    d = 0.0F;
                } else if (i == 1) {
                    f =  1.25F;
                    d = -0.90F;
                } else if (i == 2) {
                    f = 1.25F;
                    d = 0.90F;
                } else {
                    f = 0.45F;
                    d = 0F;
                }
            } else if (getPassengers().size() == 5) {
                int i = getPassengers().indexOf(passenger);
                if (i == 0) {
                    f = -1.75F;
                    d = 0.0F;
                } else if (i == 1) {
                    f =  1.25F;
                    d = -0.90F;
                } else if (i == 2) {
                    f = 1.25F;
                    d = 0.90F;
                } else if (i == 3){
                    f =  0.45F;
                    d = 0.90F;
                } else {
                    f =  0.45F;
                    d = -0.90F;
                }
            }
            f = f + x;
            Vector3d vector3d = (new Vector3d((double)f, 0.0D, 0.0D + d)).yRot(-this.yRot * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));
            passenger.setPos(this.getX() + vector3d.x, this.getY() + (double)f1, + this.getZ() + vector3d.z);
            passenger.yRot += this.deltaRotation;
            passenger.setYHeadRot(passenger.getYHeadRot() + this.deltaRotation);
            applyYawToEntity(passenger);
        }

    }

    public void initInventory(){
        Inventory inventory = this.getInventory();
        int sigma, tempload = 0;
        for (int i = 0; i < inventory.getContainerSize(); i++) {
            if (!inventory.getItem(i).isEmpty())
                tempload++;
        }
        if (tempload > 31) {
            sigma = 4;
        } else if (tempload > 16) {
            sigma = 3;
        } else if (tempload > 8) {
            sigma = 2;
        } else if (tempload > 3) {
            sigma = 1;
        } else {
            sigma = 0;
        }
        entityData.set(CARGO, sigma);
    }
}
