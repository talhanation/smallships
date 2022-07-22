package com.talhanation.smallships.entities;

import com.talhanation.smallships.InventoryEvents;
import com.talhanation.smallships.init.ModEntityTypes;
import com.talhanation.smallships.inventory.BasicShipContainer;
import com.talhanation.smallships.network.MessageOpenGui;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.BannerItem;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nullable;

public class BriggEntity extends AbstractCannonShip{

    public BriggEntity(EntityType<? extends BriggEntity> type, Level world) {
        super(type, world);
    }

    //Constructor for ShipItem
    public BriggEntity(Level world, double x, double y, double z) {
        this(ModEntityTypes.BRIGG.get(), world);
        setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    ////////////////////////////////////GET////////////////////////////////////

    @Override
    public double getWidth() {
        return 4D;
    }

    @Override
    public double getHeight() {
        return 1.5D;
    }

    @Override
    public double getShipDefense() { //in %
        return 18;
    }

    @Override
    public int getInventorySize() {
        return 54 + 54;
    }

    @Override
    public float getMaxSpeed() {
        return 7F;
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
        return 4F;
    }

    @Override
    public float getRotationAcceleration() {
        return 0.3F;
    }//not to change

    @Override
    public float getVelocityResistance() {
        return 0.009F;
    }

    @Override
    public ResourceLocation getLootTable() {
        return null;
    }

    @Override
    public int getPassengerSize() {
        return 10;
    }

    @Override
    public int getMaxCannons() {
        return 6;
    }

    ////////////////////////////////////INTERACTIONS///////////////////////////////

    @Override
    public InteractionResult interact(Player player, InteractionHand hand) {
        ItemStack itemInHand = player.getItemInHand(hand);
        if (player.isSecondaryUseActive()) {

            if (this.isVehicle() && !(getControllingPassenger() instanceof PlayerEntity)) {
                this.ejectPassengers();
            } else {
                if (!(getControllingPassenger() instanceof PlayerEntity)) {
                    InventoryEvents.openShipGUI(player, this,0);
                }
                return InteractionResult.sidedSuccess(this.level.isClientSide);
            }

        }

        if (!this.getSunken()) {
            if (itemInHand.getItem() == ModItems.CANNON_ITEM.get()) {
                this.onInteractionWithCannon(player, itemInHand);
                return InteractionResult.SUCCESS;
            }

            if (itemInHand.getItem() instanceof DyeItem) {
                this.onInteractionWithDye(player, ((DyeItem) itemInHand.getItem()).getDyeColor(), itemInHand);
                return InteractionResult.SUCCESS;
            }

            if (itemInHand.getItem() instanceof BannerItem) {
                this.onInteractionWithBanner(itemInHand, player);
                return InteractionResult.SUCCESS;
            }

            if (itemInHand.getItem() instanceof AxeItem) {
                if (hasPlanks(player.inventory) && hasIronNugget(player.inventory) && getShipDamage() > 16.0D) {
                    this.onInteractionWitAxe(player);
                    return InteractionResult.SUCCESS;
                } else return InteractionResult.FAIL;
            } else if (itemInHand.getItem() instanceof ShearsItem) {
                if (this.getHasBanner()) {
                    this.onInteractionWithShears(player);
                    return InteractionResult.SUCCESS;
                }
                return InteractionResult.PASS;
            }
            if (!player.isSecondaryUseActive()) {

                if (!this.level.isClientSide) {
                    return player.startRiding(this) ? InteractionResult.CONSUME : InteractionResult.PASS;

                } else {
                    return InteractionResult.SUCCESS;
                }
            }
        }

        return InteractionResult.FAIL;
    }


    @Override
    public boolean doesEnterThirdPerson() {
        return true;
    }


    ////////////////////////////////////OTHER FUNCTIONS////////////////////////////////////
    @Override
    public void WaterSplash(){
        Vec3 vector3d = this.getViewVector(0.0F);
        float f0 = Mth.cos(this.getYRot() * ((float)Math.PI / 180F)) * 1.2F;
        float f1 = Mth.sin(this.getYRot() * ((float)Math.PI / 180F)) * 1.2F;
        float f2 =  4F - this.random.nextFloat() * 0.7F; // höhe
        float f2_ =  -2.3F - this.random.nextFloat() * 0.7F;
        float x = 0; //verschiebung nach rechts/links
        float y = 4;
        for (int i = 0; i < 2; ++i) {                                                                                                                             //höhe
            this.level.addParticle(ParticleTypes.DOLPHIN, this.getX() - vector3d.x * (double) f2 + (double) f0, this.getY() - vector3d.y + 0.5D, this.getZ() - vector3d.z * (double) f2 + (double) f1, 0.0D, 0.0D, 0.0D);
            this.level.addParticle(ParticleTypes.DOLPHIN, this.getX() - vector3d.x * (double) f2 - (double) f0, this.getY() - vector3d.y + 0.5D, this.getZ() - vector3d.z * (double) f2 - (double) f1, 0.0D, 0.0D, 0.0D);
            this.level.addParticle(ParticleTypes.DOLPHIN, this.getX() - vector3d.x * (double) f2 + (double) f0, this.getY() - vector3d.y + 0.5D, this.getZ() - vector3d.z * (double) f2 + (double) f1 * 5.1, 0.0D, 0.0D, 0.0D);
            this.level.addParticle(ParticleTypes.DOLPHIN, this.getX() - vector3d.x * (double) f2 - (double) f0, this.getY() - vector3d.y + 0.5D, this.getZ() - vector3d.z * (double) f2 - (double) f1 * 5.1, 0.0D, 0.0D, 0.0D);

            this.level.addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2 + (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) f2 + (double) f1, 0.0D, 0.0D, 0.0D);
            this.level.addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2 - (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) f2 - (double) f1, 0.0D, 0.0D, 0.0D);
            this.level.addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2 + (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) f2 + (double) f1 * 1.1, 0.0D, 0.0D, 0.0D);
            this.level.addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2 - (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) f2 - (double) f1 * 1.1, 0.0D, 0.0D, 0.0D);

            this.level.addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2_ + (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) + (double) f1, 0.0D, 0.0D, 0.0D);
            this.level.addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2_ - (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) - (double) f1, 0.0D, 0.0D, 0.0D);
            this.level.addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2_ + (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) + (double) f1 * 1.1, 0.0D, 0.0D, 0.0D);
            this.level.addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2_ - (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) - (double) f1 * 1.1, 0.0D, 0.0D, 0.0D);

            this.level.addParticle(ParticleTypes.BUBBLE, this.getX() - vector3d.x * (double) f2_ + (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) + (double) f1, 0.0D, 0.0D, 0.0D);
            this.level.addParticle(ParticleTypes.BUBBLE, this.getX() - vector3d.x * (double) f2_ - (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) - (double) f1, 0.0D, 0.0D, 0.0D);
            this.level.addParticle(ParticleTypes.BUBBLE, this.getX() - vector3d.x * (double) f2_ + (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) + (double) f1 * 1.1, 0.0D, 0.0D, 0.0D);
            this.level.addParticle(ParticleTypes.BUBBLE, this.getX() - vector3d.x * (double) f2_ - (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) - (double) f1 * 1.1, 0.0D, 0.0D, 0.0D);
        }
    }

    @Override
    public void positionRider(Entity passenger) {
        if (hasPassenger(passenger)) {
            double f = -1.5F;
            double d = 0.75F;
            float f1 = (float) ((this.isRemoved() ? 0.02D : getPassengersRidingOffset()) + passenger.getMyRidingOffset());
            if (getPassengers().size() == 2) {
                int i = getPassengers().indexOf(passenger);
                if (i == 0) {
                    f = -1.5F;
                    d = 0.75F;
                } else {
                    f = -1.5F;
                    d = -0.75F;
                }
            } else if (getPassengers().size() == 3) {
                int i = getPassengers().indexOf(passenger);
                if (i == 0) {
                    f = -1.5F;
                    d = 0.75F;
                } else if (i == 1) {
                    f = -1.5F;
                    d = -0.75F;
                } else {
                    f = -0.5F;
                    d = -0.75F;
                }
            }else if (getPassengers().size() == 4) {
                int i = getPassengers().indexOf(passenger);
                if (i == 0) {
                    f = -1.5F;
                    d = 0.75F;
                } else if (i == 1) {
                    f = -1.5F;
                    d = -0.75F;
                } else if (i == 2) {
                    f = -0.5F;
                    d = -0.75F;
                } else {
                    f = -0.5F;
                    d = 0.75F;
                }
            }else if (getPassengers().size() == 5) {
                int i = getPassengers().indexOf(passenger);
                if (i == 0) {
                    f = -1.5F;
                    d = 0.75F;
                } else if (i == 1) {
                    f = -1.5F;
                    d = -0.75F;
                } else if (i == 2) {
                    f = -0.5F;
                    d = -0.75F;
                } else if (i == 3) {
                    f = -0.5F;
                    d = 0.75F;
                } else {
                    f = 0.5F;
                    d = -0.75F;
                }
            }else if (getPassengers().size() == 6) {
                int i = getPassengers().indexOf(passenger);
                if (i == 0) {
                    f = -1.5F;
                    d = 0.75F;
                } else if (i == 1) {
                    f = -1.5F;
                    d = -0.75F;
                } else if (i == 2) {
                    f = -0.5F;
                    d = -0.75F;
                } else if (i == 3) {
                    f = -0.5F;
                    d = 0.75F;
                } else if(i == 4){
                    f = 0.5F;
                    d = -0.75F;
                } else {
                    f = 0.5F;
                    d = 0.75F;
                }
            }else if (getPassengers().size() == 7) {
                int i = getPassengers().indexOf(passenger);
                if (i == 0) {
                    f = -1.5F;
                    d = 0.75F;
                } else if (i == 1) {
                    f = -1.5F;
                    d = -0.75F;
                } else if (i == 2) {
                    f = -0.5F;
                    d = -0.75F;
                } else if (i == 3) {
                    f = -0.5F;
                    d = 0.75F;
                } else if (i == 4) {
                    f = 0.5F;
                    d = -0.75F;
                } else if (i == 5) {
                    f = 0.5F;
                    d = 0.75F;
                } else {
                    f = 1.5F;
                    d = 0.75F;
                }
            }else if (getPassengers().size() == 8) {
                int i = getPassengers().indexOf(passenger);
                if (i == 0) {
                    f = -1.5F;
                    d = 0.75F;
                } else if (i == 1) {
                    f = -1.5F;
                    d = -0.75F;
                } else if (i == 2) {
                    f = -0.5F;
                    d = -0.75F;
                } else if (i == 3) {
                    f = -0.5F;
                    d = 0.75F;
                } else if (i == 4) {
                    f = 0.5F;
                    d = -0.75F;
                } else if (i == 5) {
                    f = 0.5F;
                    d = 0.75F;
                } else if (i == 6){
                    f = 1.5F;
                    d = -0.75F;
                }else {
                    f = 1.5F;
                    d = 0.75F;
                }
            }else if (getPassengers().size() == 9) {
                int i = getPassengers().indexOf(passenger);
                if (i == 0) {
                    f = -1.5F;
                    d = 0.75F;
                } else if (i == 1) {
                    f = -1.5F;
                    d = -0.75F;
                } else if (i == 2) {
                    f = -0.5F;
                    d = -0.75F;
                } else if (i == 3) {
                    f = -0.5F;
                    d = 0.75F;
                } else if (i == 4) {
                    f = 0.5F;
                    d = -0.75F;
                } else if (i == 5) {
                    f = 0.5F;
                    d = 0.75F;
                } else if (i == 6){
                    f = 1.5F;
                    d = -0.75F;
                }else if (i == 7){
                    f = 1.5F;
                    d = 0.75F;
                }else {
                    f = 2.75F;
                    d = 0.0F;
                }
            }else if (getPassengers().size() == 10) {
                int i = getPassengers().indexOf(passenger);
                if (i == 0) {
                    f = -1.5F;
                    d = 0.75F;
                } else if (i == 1) {
                    f = -1.5F;
                    d = -0.75F;
                } else if (i == 2) {
                    f = -0.5F;
                    d = -0.75F;
                } else if (i == 3) {
                    f = -0.5F;
                    d = 0.75F;
                } else if (i == 4) {
                    f = 0.5F;
                    d = -0.75F;
                } else if (i == 5) {
                    f = 0.5F;
                    d = 0.75F;
                } else if (i == 6){
                    f = 1.5F;
                    d = -0.75F;
                }else if (i == 7){
                    f = 1.5F;
                    d = 0.75F;
                }else if (i == 8){
                    f = 2.75F;
                    d = 0.5F;
                }else {
                    f = 2.75F;
                    d = -0.5F;
                }
            }
            f = f - 0.5;
            Vec3 vector3d = (new Vec3(f, 0.0D, 0.0D + d)).yRot(-this.getYRot() * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));
            passenger.setPos(this.getX() + vector3d.x, this.getY() + (double)f1, this.getZ() + vector3d.z);
            passenger.setYRot(passenger.getYRot() + this.deltaRotation);
            passenger.setYHeadRot(passenger.getYHeadRot() + this.deltaRotation);
            applyOriantationsToEntity(passenger);
        }
    }
}
