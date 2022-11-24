/*
 * Decompiled with CFR 0.146.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package port;

import com.talhanation.smallships.world.entity.ship.abilities.Ability;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.function.BiConsumer;

public interface ContainerEntity
extends Container,
MenuProvider, Ability {
    @Nullable
    ResourceLocation getLootTable();

    void setLootTable(@Nullable ResourceLocation var1);

    long getLootTableSeed();

    void setLootTableSeed(long var1);

    NonNullList<ItemStack> getItemStacks();

    void clearItemStacks();

    @Override
    default boolean isEmpty() {
        return this.isChestVehicleEmpty();
    }

    default void addChestVehicleSaveData(CompoundTag compoundTag) {
        if (this.getLootTable() != null) {
            compoundTag.putString("LootTable", this.getLootTable().toString());
            if (this.getLootTableSeed() != 0L) {
                compoundTag.putLong("LootTableSeed", this.getLootTableSeed());
            }
        } else {
            ContainerHelper.saveAllItems(compoundTag, this.getItemStacks());
        }
    }

    default void readChestVehicleSaveData(CompoundTag compoundTag) {
        this.clearItemStacks();
        if (compoundTag.contains("LootTable", 8)) {
            this.setLootTable(new ResourceLocation(compoundTag.getString("LootTable")));
            this.setLootTableSeed(compoundTag.getLong("LootTableSeed"));
        } else {
            ContainerHelper.loadAllItems(compoundTag, this.getItemStacks());
        }
    }

    default void chestVehicleDestroyed(DamageSource damageSource, Level level, Entity entity) {
        Entity entity2;
        if (!level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
            return;
        }
        Containers.dropContents(level, entity, this);
        if (!level.isClientSide && (entity2 = damageSource.getDirectEntity()) != null && entity2.getType() == EntityType.PLAYER) {
            PiglinAi.angerNearbyPiglins((Player)entity2, true);
        }
    }

    default InteractionResult interactWithChestVehicle(BiConsumer<GameEvent, Entity> biConsumer, Player player) {
        player.openMenu(this);
        if (!player.level.isClientSide) {
            biConsumer.accept(GameEvent.CONTAINER_OPEN, player);
            PiglinAi.angerNearbyPiglins(player, true);
            return InteractionResult.CONSUME;
        }
        return InteractionResult.SUCCESS;
    }

    default void unpackChestVehicleLootTable(@Nullable Player player) {
        MinecraftServer minecraftServer = self().getLevel().getServer();
        if (this.getLootTable() != null && minecraftServer != null) {
            LootTable lootTable = minecraftServer.getLootTables().get(this.getLootTable());
            if (player != null) {
                CriteriaTriggers.GENERATE_LOOT.trigger((ServerPlayer)player, this.getLootTable());
            }
            this.setLootTable(null);
            LootContext.Builder builder = new LootContext.Builder((ServerLevel)self().getLevel()).withParameter(LootContextParams.ORIGIN, self().position()).withOptionalRandomSeed(this.getLootTableSeed());
            if (player != null) {
                builder.withLuck(player.getLuck()).withParameter(LootContextParams.THIS_ENTITY, player);
            }
            lootTable.fill(this, builder.create(LootContextParamSets.CHEST));
        }
    }

    default void clearChestVehicleContent() {
        this.unpackChestVehicleLootTable(null);
        this.getItemStacks().clear();
    }

    default boolean isChestVehicleEmpty() {
        for (ItemStack itemStack : this.getItemStacks()) {
            if (itemStack.isEmpty()) continue;
            return false;
        }
        return true;
    }

    default ItemStack removeChestVehicleItemNoUpdate(int n) {
        this.unpackChestVehicleLootTable(null);
        ItemStack itemStack = this.getItemStacks().get(n);
        if (itemStack.isEmpty()) {
            return ItemStack.EMPTY;
        }
        this.getItemStacks().set(n, ItemStack.EMPTY);
        return itemStack;
    }

    default ItemStack getChestVehicleItem(int n) {
        this.unpackChestVehicleLootTable(null);
        return this.getItemStacks().get(n);
    }

    default ItemStack removeChestVehicleItem(int n, int n2) {
        this.unpackChestVehicleLootTable(null);
        return ContainerHelper.removeItem(this.getItemStacks(), n, n2);
    }

    default void setChestVehicleItem(int n, ItemStack itemStack) {
        this.unpackChestVehicleLootTable(null);
        this.getItemStacks().set(n, itemStack);
        if (!itemStack.isEmpty() && itemStack.getCount() > this.getMaxStackSize()) {
            itemStack.setCount(this.getMaxStackSize());
        }
    }

    default SlotAccess getChestVehicleSlot(final int n) {
        if (n >= 0 && n < this.getContainerSize()) {
            return new SlotAccess(){

                @Override
                public ItemStack get() {
                    return ContainerEntity.this.getChestVehicleItem(n);
                }

                @Override
                public boolean set(@NotNull ItemStack itemStack) {
                    ContainerEntity.this.setChestVehicleItem(n, itemStack);
                    return true;
                }
            };
        }
        return SlotAccess.NULL;
    }

    default boolean isChestVehicleStillValid(Player player) {
        return !self().isRemoved() && self().position().closerThan(player.position(), 8.0);
    }

}

