package com.talhanation.smallships.entities;

import com.talhanation.smallships.entities.sailboats.AbstractDhowEntity;
import com.talhanation.smallships.init.ModEntityTypes;
import com.talhanation.smallships.inventory.DhowContainer;
import com.talhanation.smallships.items.ModItems;
import com.talhanation.smallships.util.DhowItemStackHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.BannerItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.items.ItemStackHandler;

public class DhowEntity extends AbstractDhowEntity {

    public boolean Cargo_0;
    public boolean Cargo_1;
    public boolean Cargo_2;
    public boolean Cargo_3;

   private static final DataParameter<Integer> CARGO = EntityDataManager.defineId(AbstractDhowEntity.class, DataSerializers.INT);

    public DhowEntity(EntityType<? extends AbstractDhowEntity> entityType, World worldIn) {
        super(entityType, worldIn);
    }

    @Override
    public void tick(){
        super.tick();

        this.getCargo();
        if (0 < this.getCargo()) Cargo_0 = true;
        else Cargo_0 = false;
        if (1 < this.getCargo()) Cargo_1 = true;
        else Cargo_1 = false;
        if (2 < this.getCargo()) Cargo_2 = true;
        else Cargo_2 = false;
        if (3 < this.getCargo()) Cargo_3 = true;
        else Cargo_3 = false;

    }

    protected ItemStackHandler initInventory() {

        return new DhowItemStackHandler<DhowEntity>(27, this) {
            protected void onContentsChanged(int slot) {
                int sigma, tempload = 0;
                for (int i = 0; i < getSlots(); i++) {
                    if (!getStackInSlot(i).isEmpty())
                        tempload++;
                }
                if (tempload > 26) {
                    sigma = 4;
                } else if (tempload > 13) {
                    sigma = 3;
                } else if (tempload > 6) {
                    sigma = 2;
                } else if (tempload > 2) {
                    sigma = 1;
                } else {
                    sigma = 0;
                }
                (this.dhow).getEntityData().set(DhowEntity.CARGO, sigma);
            }
        };
    }

    public DhowEntity(World worldIn, double x, double y, double z) {
        this(ModEntityTypes.DHOW_ENTITY.get(), worldIn);
        setPos(x, y, z);
        setDeltaMovement(Vector3d.ZERO);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    public DhowEntity(FMLPlayMessages.SpawnEntity spawnEntity, World worldIn) {
        this(ModEntityTypes.DHOW_ENTITY.get(), worldIn);
    }

    @Override
    public ActionResultType interact(PlayerEntity player, Hand hand) {
        ItemStack itemInHand = player.getItemInHand(hand);

        if (itemInHand.getItem() instanceof BannerItem){
            onInteractionWithBanner(itemInHand,player);
            return ActionResultType.SUCCESS;
        }

        else if (itemInHand.getItem() instanceof ShearsItem){
            if (this.getHasBanner()){
                onInteractionWithShears(player);
                return ActionResultType.SUCCESS;
            }
            return ActionResultType.PASS;
        }

        else if (player.isSecondaryUseActive()) {
            if (this.isVehicle() && !(getControllingPassenger() instanceof PlayerEntity)){
                    this.ejectPassengers();
                    this.passengerwaittime = 200;
            }
            else {
                if (!(getControllingPassenger() instanceof PlayerEntity) ) {
                    openContainer(player);
                } return ActionResultType.sidedSuccess(this.level.isClientSide);
            } return ActionResultType.PASS;
        } else if (this.outOfControlTicks < 60.0F) {
            if (!this.level.isClientSide) {
                return player.startRiding(this) ? ActionResultType.CONSUME : ActionResultType.PASS;

            } else {
                return ActionResultType.SUCCESS;
            }
        } else {
            return ActionResultType.PASS;
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void handleEntityEvent(byte id) {
            super.handleEntityEvent(id);
    }

    @Override
    public double getPassengersRidingOffset() {
        return 1.0D;
    }



    public int getCargo() {
        return this.entityData.get(CARGO);
    }

    @Override
    public void openContainer(PlayerEntity player) {
            player.openMenu(new SimpleNamedContainerProvider((id, inv, plyr) -> new DhowContainer(id, inv, this), getDisplayName()));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(CARGO, 0);
    }

    @Override
    protected void readAdditionalSaveData(CompoundNBT compound) {
        super.readAdditionalSaveData(compound);
        this.entityData.set(CARGO, compound.getInt("Cargo"));
    }

    @Override
    protected void addAdditionalSaveData(CompoundNBT compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Cargo", this.entityData.get(CARGO));
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
            f = f - 1.75F;
            if (passenger instanceof AnimalEntity)
                d = (float)(d -0.15D);
            Vector3d vector3d = (new Vector3d((double)f, 0.0D, 0.0D + d)).yRot(-this.yRot * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));
            passenger.setPos(this.getX() + vector3d.x, this.getY() + (double)f1, + this.getZ() + vector3d.z);
            passenger.yRot += this.deltaRotation;
            passenger.setYHeadRot(passenger.getYHeadRot() + this.deltaRotation);
            clampRotation(passenger);
        }

    }

    public Item getItemBoat() {
        switch (this.getBoatType()) {
            case OAK:
            default:
                return ModItems.OAK_DHOW_ITEM.get();
            case SPRUCE:
                return ModItems.SPRUCE_DHOW_ITEM.get();
            case BIRCH:
                return ModItems.BIRCH_DHOW_ITEM.get();
            case JUNGLE:
                return ModItems.JUNGLE_DHOW_ITEM.get();
            case ACACIA:
                return ModItems.ACACIA_DHOW_ITEM.get();
            case DARK_OAK:
                return ModItems.DARK_OAK_DHOW_ITEM.get();

            //BOP
            case BOP_CHERRY:
                return ModItems.BOP_CHERRY_DHOW_ITEM.get();
            case BOP_DEAD:
                return ModItems.BOP_DEAD_DHOW_ITEM.get();
            case BOP_FIR:
                return ModItems.BOP_FIR_DHOW_ITEM.get();
            case BOP_HELLBARK:
                return ModItems.BOP_HELLBARK_DHOW_ITEM.get();
            case BOP_JACARANDA:
                return ModItems.BOP_JACARANDA_DHOW_ITEM.get();
            case BOP_MAGIC:
                return ModItems.BOP_MAGIC_DHOW_ITEM.get();
            case BOP_MAHOGANY:
                return ModItems.BOP_MAHOGANY_DHOW_ITEM.get();
            case BOP_PALM:
                return ModItems.BOP_PALM_DHOW_ITEM.get();
            case BOP_REDWOOD:
                return ModItems.BOP_REDWOOD_DHOW_ITEM.get();
            case BOP_UMBRAN:
                return ModItems.BOP_UMBRAN_DHOW_ITEM.get();
            case BOP_WILLOW:
                return ModItems.BOP_WILLOW_DHOW_ITEM.get();
            //LOTR
            case LOTR_APPLE:
                return ModItems.LOTR_APPLE_DHOW_ITEM.get();
            case LOTR_ASPEN:
                return ModItems.LOTR_ASPEN_DHOW_ITEM.get();
            case LOTR_BEECH:
                return ModItems.LOTR_BEECH_DHOW_ITEM.get();
            case LOTR_CEDAR:
                return ModItems.LOTR_CEDAR_DHOW_ITEM.get();
            case LOTR_CHERRY:
                return ModItems.LOTR_CHERRY_DHOW_ITEM.get();
            case LOTR_CHARRED:
                return ModItems.LOTR_CHARRED_DHOW_ITEM.get();
            case LOTR_CYPRESS:
                return ModItems.LOTR_CYPRESS_DHOW_ITEM.get();
            case LOTR_FIR:
                return ModItems.LOTR_FIR_DHOW_ITEM.get();
            case LOTR_GREEN_OAK:
                return ModItems.LOTR_GREEN_OAK_DHOW_ITEM.get();
            case LOTR_HOLLY:
                return ModItems.LOTR_HOLLY_DHOW_ITEM.get();
            case LOTR_LAIRELOSSE:
                return ModItems.LOTR_LAIRELOSSE_DHOW_ITEM.get();
            case LOTR_LARCH:
                return ModItems.LOTR_LARCH_DHOW_ITEM.get();
            case LOTR_LEBETHRON:
                return ModItems.LOTR_LEBETHRON_DHOW_ITEM.get();
            case LOTR_MALLORN:
                return ModItems.LOTR_MALLORN_DHOW_ITEM.get();
            case LOTR_MAPLE:
                return ModItems.LOTR_MAPLE_DHOW_ITEM.get();
            case LOTR_MIRK_OAK:
                return ModItems.LOTR_MIRK_OAK_DHOW_ITEM.get();
            case LOTR_PEAR:
                return ModItems.LOTR_PEAR_DHOW_ITEM.get();
            case LOTR_PINE:
                return ModItems.LOTR_PINE_DHOW_ITEM.get();
            case LOTR_ROTTEN:
                return ModItems.LOTR_ROTTEN_DHOW_ITEM.get();

            //ENVI//
            case ENVI_CHERRY:
                return ModItems.ENVI_CHERRY_DHOW_ITEM.get();
            case ENVI_WILLOW:
                return ModItems.ENVI_WILLOW_DHOW_ITEM.get();
            case ENVI_WISTERIA:
                return ModItems.ENVI_WISTERIA_DHOW_ITEM.get();
        }
    }

    @Override
    protected boolean canAddPassenger(Entity passenger) {
        return (getPassengers().size() < 10);
    }


}
