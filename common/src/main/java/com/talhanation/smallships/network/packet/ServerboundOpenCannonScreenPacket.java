package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.entity.cannon.GroundCannonEntity;
import com.talhanation.smallships.world.inventory.ContainerUtility;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

import java.util.UUID;

public record ServerboundOpenCannonScreenPacket(UUID uuid) implements ModPacket {
    public static final ResourceLocation ID = ModPackets.id("server_open_cannon_screen");

    public static ServerboundOpenCannonScreenPacket read(FriendlyByteBuf buf) {
        return new ServerboundOpenCannonScreenPacket(buf.readUUID());
    }

    @Override
    public ResourceLocation id() {
        return ID;
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        buf.writeUUID(this.uuid);
    }

    @Override
    public void handler(Player player) {
        player.level().getEntitiesOfClass(GroundCannonEntity.class, player.getBoundingBoxForCulling()
                        .inflate(16.0D), entity -> entity.getUUID().equals(this.uuid))
                .stream()
                .filter(Entity::isAlive)
                .findAny()
                .ifPresent(entity -> {
                    ContainerUtility.openCannonMenu(player, entity);
                });
    }

    @Override
    public Side side() {
        return Side.SERVERBOUND;
    }
}
