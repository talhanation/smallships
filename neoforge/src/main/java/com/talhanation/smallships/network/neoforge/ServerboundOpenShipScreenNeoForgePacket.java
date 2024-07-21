package com.talhanation.smallships.network.neoforge;

import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.entity.ship.ContainerShip;
import com.talhanation.smallships.world.inventory.ContainerUtility;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class ServerboundOpenShipScreenNeoForgePacket implements NeoForgePacket {
    private static final ResourceLocation ID = ModPackets.id("server_open_ship_screen");

    private final UUID ship;
    private final int pageIndex;

    @SuppressWarnings("unused")
    ServerboundOpenShipScreenNeoForgePacket(UUID containerShipUUID, int pageIndex) {
        this.ship = containerShipUUID;
        this.pageIndex = pageIndex;
    }

    @SuppressWarnings("unused")
    ServerboundOpenShipScreenNeoForgePacket(FriendlyByteBuf buf) {
        this.ship = buf.readUUID();
        this.pageIndex = buf.readInt();
    }

    @Override
    public void toBytes(FriendlyByteBuf buf) {
        this.write(buf);
    }

    @Override
    public void write(@NotNull FriendlyByteBuf buffer) {
        buffer.writeUUID(this.ship);
        buffer.writeInt(this.pageIndex);
    }

    @Override
    public @NotNull ResourceLocation id() {
        return ID;
    }

    @Override
    public void handle(NeoForgePacket payload, PlayPayloadContext ctx) {
        if (ctx.player().isEmpty()) return;
        Player player = ctx.player().get();
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
}
