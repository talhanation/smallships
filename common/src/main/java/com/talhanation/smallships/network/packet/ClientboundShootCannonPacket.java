package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.entity.cannon.GroundCannonEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.joml.Vector3d;
import org.joml.Vector3f;

public record ClientboundShootCannonPacket(int cannonEntityID, boolean shotEntity, int shotEntityID) implements ModPacket {
    public static final CustomPacketPayload.Type<ClientboundShootCannonPacket> TYPE = new CustomPacketPayload.Type<>(ModPackets.id("client_notify_cannon_shoot"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ClientboundShootCannonPacket> CODEC =
            StreamCodec.composite(ByteBufCodecs.INT, ClientboundShootCannonPacket::cannonEntityID,
                                  ByteBufCodecs.BOOL, ClientboundShootCannonPacket::shotEntity,
                                  ByteBufCodecs.INT, ClientboundShootCannonPacket::shotEntityID,
                    ClientboundShootCannonPacket::new);

    public ClientboundShootCannonPacket(int cannonEntityID, int shotEntityID) {
        this(cannonEntityID, true, shotEntityID);
    }

    public ClientboundShootCannonPacket(int cannonEntityID) {
        this(cannonEntityID, false, -1);
    }

    @Override
    public void handler(Player player) {
        int simulationDistance = Minecraft.getInstance().options.simulationDistance().get();
        Entity cannonEntity = player.level().getEntity(this.cannonEntityID());
        Entity entity = this.shotEntity ? player.level().getEntity(this.shotEntityID) : null;

        if (player.distanceToSqr(cannonEntity) > simulationDistance * simulationDistance) {
            return;
        }

        if (cannonEntity instanceof GroundCannonEntity cannon) {
            if (this.shotEntity && entity != null) {
                cannon.getCannon().clientShootingEntityEffects();
            } else {
                cannon.getCannon().clientShootingEffects();
            }
        }
    }

    @Override
    public ModPacket.Side side() {
        return ModPacket.Side.SERVERBOUND;
    }

    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
