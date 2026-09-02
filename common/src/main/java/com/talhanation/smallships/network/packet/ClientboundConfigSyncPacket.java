package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.config.SyncedServerConfig;
import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Hands the server config values a client needs over on join. Without it a
 * client would draw ship stats and predict ship movement from its own file,
 * which on a server is simply somebody else's setting.
 */
public record ClientboundConfigSyncPacket(SyncedServerConfig.Snapshot snapshot) implements ModPacket {
    public static final Type<ClientboundConfigSyncPacket> TYPE = new Type<>(ModPackets.id("client_config_sync"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ClientboundConfigSyncPacket> CODEC =
            SyncedServerConfig.STREAM_CODEC.map(ClientboundConfigSyncPacket::new, ClientboundConfigSyncPacket::snapshot);

    @Override
    public @NotNull Type<ClientboundConfigSyncPacket> type() {
        return TYPE;
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