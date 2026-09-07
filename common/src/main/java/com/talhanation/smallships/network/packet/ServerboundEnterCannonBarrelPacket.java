package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.entity.cannon.GroundCannonEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public record ServerboundEnterCannonBarrelPacket(int cannonID, int entityID) implements ModPacket {
    public static final ResourceLocation ID = ModPackets.id("server_enter_cannon_barrel");

    public static ServerboundEnterCannonBarrelPacket read(FriendlyByteBuf buf) {
        return new ServerboundEnterCannonBarrelPacket(buf.readInt(), buf.readInt());
    }

    @Override
    public ResourceLocation id() {
        return ID;
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        buf.writeInt(this.cannonID);
        buf.writeInt(this.entityID);
    }

    @Override
    public void handler(Player player) {
        Entity entity = player.level().getEntity(this.entityID);
        Entity cannon = player.level().getEntity(this.cannonID);
        if (entity != null && cannon != null && cannon instanceof GroundCannonEntity cannonEntity) {
            cannonEntity.putEntityIntoBarrel(entity);
        }
    }

    @Override
    public ModPacket.Side side() {
        return ModPacket.Side.SERVERBOUND;
    }
}
