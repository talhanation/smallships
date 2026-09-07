package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.config.SyncedServerConfig;
import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

/**
 * Hands the server config values a client needs over on join. Without it a
 * client would draw ship stats and predict ship movement from its own file,
 * which on a server is simply somebody else's setting.
 */
public record ClientboundConfigSyncPacket(SyncedServerConfig.Snapshot snapshot) implements ModPacket {
    public static final ResourceLocation ID = ModPackets.id("client_config_sync");

    public static ClientboundConfigSyncPacket read(FriendlyByteBuf buf) {
        return new ClientboundConfigSyncPacket(SyncedServerConfig.readSnapshot(buf));
    }

    @Override
    public ResourceLocation id() {
        return ID;
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        SyncedServerConfig.writeSnapshot(buf, this.snapshot);
    }

    @Override
    public void handler(Player player) {
        SyncedServerConfig.apply(this.snapshot());
    }

    @Override
    public Side side() {
        return Side.CLIENTBOUND;
    }
}