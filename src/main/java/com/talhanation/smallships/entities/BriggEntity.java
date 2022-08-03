package com.talhanation.smallships.entities;

import com.talhanation.smallships.InventoryEvents;
import com.talhanation.smallships.init.ModEntityTypes;
import com.talhanation.smallships.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class BriggEntity extends AbstractCannonShip{

    public BriggEntity(EntityType<? extends BriggEntity> type, World world) {
        super(type, world);
    }

    //Constructor for ShipItem
    public BriggEntity(World world, double x, double y, double z) {
        this(ModEntityTypes.BRIGG.get(), world);
        setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    ////////////////////////////////////GET////////////////////////////////////

    @Override
    public int getBiomesModifierType() {
        return 0;// 0 = cold; 1 = neutral; 2 = warm;
    }

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
        return 0.0135F; //sensible;
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
    public float getCargoModifier() {
        return this.getCargo() * 0.02F;
    }

    @Override
    public float getCannonModifier() {
        return this.getTotalCannonCount() * 0.02F;
    }

    @Override
    public float getPassengerModifier() {
        return this.getPassengerSize() * 0.01F;
    }

    @Override
    public ResourceLocation getLootTable() {
        return null;
    }

    @Override
    public int getPassengerSize() {
        switch (getTotalCannonCount()) {
            default:
            case 0:
                return 10;
            case 1:
            case 2:
                return 9;
            case 3:
            case 4:
                return 8;
            case 5:
            case 6:
                return 7;
        }
    }

    @Override
    public int getMaxCannons() {
        return 6;
    }

    ////////////////////////////////////INTERACTIONS///////////////////////////////

    @Override
    public ActionResultType interact(PlayerEntity player, Hand hand) {
        ItemStack itemInHand = player.getItemInHand(hand);
        if (player.isSecondaryUseActive()) {

            if (this.isVehicle() && !(getControllingPassenger() instanceof PlayerEntity)) {
                this.ejectPassengers();
            } else {
                if (!(getControllingPassenger() instanceof PlayerEntity)) {
                    InventoryEvents.openShipGUI(player, this,0);
                }
                return ActionResultType.sidedSuccess(this.level.isClientSide);
            }

        }

        if (!this.getSunken()) {
            if (itemInHand.getItem() == ModItems.CANNON_ITEM.get()) {
                this.onInteractionWithCannon(player, itemInHand);
                return ActionResultType.SUCCESS;
            }

            if (itemInHand.getItem() instanceof DyeItem) {
                this.onInteractionWithDye(player, ((DyeItem) itemInHand.getItem()).getDyeColor(), itemInHand);
                return ActionResultType.SUCCESS;
            }

            if (itemInHand.getItem() instanceof BannerItem) {
                this.onInteractionWithBanner(itemInHand, player);
                return ActionResultType.SUCCESS;
            }

            if (itemInHand.getItem() instanceof AxeItem) {
                if (hasPlanks(player.inventory) && hasIronNugget(player.inventory) && getShipDamage() > 16.0D) {
                    this.onInteractionWitAxe(player);
                    return ActionResultType.SUCCESS;
                } else return ActionResultType.FAIL;
            } else if (itemInHand.getItem() instanceof ShearsItem) {
                if (this.getHasBanner()) {
                    this.onInteractionWithShears(player);
                    return ActionResultType.SUCCESS;
                }
                return ActionResultType.PASS;
            }
            if (!player.isSecondaryUseActive()) {

                if (!this.level.isClientSide) {
                    return player.startRiding(this) ? ActionResultType.CONSUME : ActionResultType.PASS;

                } else {
                    return ActionResultType.SUCCESS;
                }
            }
        }

        return ActionResultType.FAIL;
    }


    @Override
    public boolean doesEnterThirdPerson() {
        return true;
    }


    ////////////////////////////////////OTHER FUNCTIONS////////////////////////////////////
    @Override
    public void WaterSplash(){
        Vector3d vector3d = this.getViewVector(0.0F);
        float f0 = MathHelper.cos(this.yRot * ((float)Math.PI / 180F)) * 1.2F;
        float f1 = MathHelper.sin(this.yRot * ((float)Math.PI / 180F)) * 1.2F;
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
            float f1 = (float) ((this.removed ? 0.02D : getPassengersRidingOffset()) + passenger.getMyRidingOffset());
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
            Vector3d vector3d = (new Vector3d((double)f, 0.0D, 0.0D + d)).yRot(-this.yRot * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));
            passenger.setPos(this.getX() + vector3d.x, this.getY() + (double)f1, + this.getZ() + vector3d.z);
            passenger.yRot += this.deltaRotation;
            //passenger.setYHeadRot(passenger.getYHeadRot() + this.deltaRotation);
            applyYawToEntity(passenger);
        }
    }
}
