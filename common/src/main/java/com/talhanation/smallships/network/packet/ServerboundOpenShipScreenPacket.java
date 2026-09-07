package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.entity.ship.ContainerShip;
import com.talhanation.smallships.world.inventory.ContainerUtility;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

import java.util.UUID;

public record ServerboundOpenShipScreenPacket(UUID ship, int pageIndex) implements ModPacket {
    public static final ResourceLocation ID = ModPackets.id("server_open_ship_screen");

    public static ServerboundOpenShipScreenPacket read(FriendlyByteBuf buf) {
        return new ServerboundOpenShipScreenPacket(buf.readUUID(), buf.readInt());
    }

    @Override
    public ResourceLocation id() {
        return ID;
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        buf.writeUUID(this.ship);
        buf.writeInt(this.pageIndex);
    }

    @Override
    public void handler(Player player) {
        player.level().getEntitiesOfClass(ContainerShip.class, player.getBoundingBoxForCulling()
                        .inflate(16.0D), containerShip -> containerShip.getUUID().equals(this.ship))
                .stream()
                .filter(Entity::isAlive)
                .findAny()
                .ifPresent(containerShip -> {
                    int pageIndex = Mth.clamp(this.pageIndex, 0, containerShip.containerData.get(1) - 1);
                    containerShip.containerData.set(2, pageIndex);
                    ContainerUtility.openShipMenu(player, containerShip);
                });
    }

    @Override
    public Side side() {
        return Side.SERVERBOUND;
    }
}
