package com.talhanation.smallships.network;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.network.packet.*;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

public class ModPackets {
    public static void registerPackets() {
        registerPacket(ServerboundOpenShipScreenPacket.ID, ModPacket.Side.SERVERBOUND, ServerboundOpenShipScreenPacket.class, ServerboundOpenShipScreenPacket::read);
        registerPacket(ServerboundToggleShipSailPacket.ID, ModPacket.Side.SERVERBOUND, ServerboundToggleShipSailPacket.class, ServerboundToggleShipSailPacket::read);
        registerPacket(ServerboundShootShipCannonPacket.ID, ModPacket.Side.SERVERBOUND, ServerboundShootShipCannonPacket.class, ServerboundShootShipCannonPacket::read);
        registerPacket(ServerboundShootGroundCannonPacket.ID, ModPacket.Side.SERVERBOUND, ServerboundShootGroundCannonPacket.class, ServerboundShootGroundCannonPacket::read);
        registerPacket(ServerboundEnterCannonBarrelPacket.ID, ModPacket.Side.SERVERBOUND, ServerboundEnterCannonBarrelPacket.class, ServerboundEnterCannonBarrelPacket::read);
        registerPacket(ServerboundSetSailStatePacket.ID, ModPacket.Side.SERVERBOUND, ServerboundSetSailStatePacket.class, ServerboundSetSailStatePacket::read);
        registerPacket(ServerboundUpdateShipControlPacket.ID, ModPacket.Side.SERVERBOUND, ServerboundUpdateShipControlPacket.class, ServerboundUpdateShipControlPacket::read);
        registerPacket(ServerboundUdpateGroundCannonControlPacket.ID, ModPacket.Side.SERVERBOUND, ServerboundUdpateGroundCannonControlPacket.class, ServerboundUdpateGroundCannonControlPacket::read);
        registerPacket(ServerboundOpenCannonScreenPacket.ID, ModPacket.Side.SERVERBOUND, ServerboundOpenCannonScreenPacket.class, ServerboundOpenCannonScreenPacket::read);
        registerPacket(ServerboundSetCannonAimPacket.ID, ModPacket.Side.SERVERBOUND, ServerboundSetCannonAimPacket.class, ServerboundSetCannonAimPacket::read);
        registerPacket(ServerboundDockyardBuildPacket.ID, ModPacket.Side.SERVERBOUND, ServerboundDockyardBuildPacket.class, ServerboundDockyardBuildPacket::read);
        registerPacket(ServerboundDockyardApplyPacket.ID, ModPacket.Side.SERVERBOUND, ServerboundDockyardApplyPacket.class, ServerboundDockyardApplyPacket::read);
        registerPacket(ServerboundDockyardRenamePacket.ID, ModPacket.Side.SERVERBOUND, ServerboundDockyardRenamePacket.class, ServerboundDockyardRenamePacket::read);
        registerPacket(ServerboundDockyardRepairPacket.ID, ModPacket.Side.SERVERBOUND, ServerboundDockyardRepairPacket.class, ServerboundDockyardRepairPacket::read);
        registerPacket(ClientboundWindPacket.ID, ModPacket.Side.CLIENTBOUND, ClientboundWindPacket.class, ClientboundWindPacket::read);
        registerPacket(ClientboundDockyardRecipesPacket.ID, ModPacket.Side.CLIENTBOUND, ClientboundDockyardRecipesPacket.class, ClientboundDockyardRecipesPacket::read);
        registerPacket(ClientboundConfigSyncPacket.ID, ModPacket.Side.CLIENTBOUND, ClientboundConfigSyncPacket.class, ClientboundConfigSyncPacket::read);
        registerPacket(ServerboundShipDetachPacket.ID, ModPacket.Side.SERVERBOUND, ServerboundShipDetachPacket.class, ServerboundShipDetachPacket::read);

    }

    /**
     * The order of the calls above is part of the protocol on forge: its
     * SimpleChannel numbers the messages in registration order and puts that
     * index on the wire. Client and server run the same list, so it lines up -
     * but inserting a packet in the middle shifts everything after it. Append
     * new packets at the end.
     *
     * @param type the CONCRETE packet class. Forge looks its codec up by
     *             message.getClass() in a plain map, so it needs every class in
     *             there by itself; fabric addresses packets by id and ignores it.
     */
    @ExpectPlatform
    public static void registerPacket(ResourceLocation id, ModPacket.Side side, Class<? extends ModPacket> type, ModPacket.Reader reader) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static void serverSendPacket(ServerPlayer player, ModPacket packet) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static void clientSendPacket(ModPacket packet) {
        throw new AssertionError();
    }

    public static ResourceLocation id(String id) {
        return new ResourceLocation(SmallShipsMod.MOD_ID, id);
    }
}