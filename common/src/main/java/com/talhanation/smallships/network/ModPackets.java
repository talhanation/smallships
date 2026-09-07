package com.talhanation.smallships.network;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.network.packet.*;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

public class ModPackets {
    public static void registerPackets() {
        registerPacket(ServerboundOpenShipScreenPacket.ID, ModPacket.Side.SERVERBOUND, ServerboundOpenShipScreenPacket::read);
        registerPacket(ServerboundToggleShipSailPacket.ID, ModPacket.Side.SERVERBOUND, ServerboundToggleShipSailPacket::read);
        registerPacket(ServerboundShootShipCannonPacket.ID, ModPacket.Side.SERVERBOUND, ServerboundShootShipCannonPacket::read);
        registerPacket(ServerboundShootGroundCannonPacket.ID, ModPacket.Side.SERVERBOUND, ServerboundShootGroundCannonPacket::read);
        registerPacket(ServerboundEnterCannonBarrelPacket.ID, ModPacket.Side.SERVERBOUND, ServerboundEnterCannonBarrelPacket::read);
        registerPacket(ServerboundSetSailStatePacket.ID, ModPacket.Side.SERVERBOUND, ServerboundSetSailStatePacket::read);
        registerPacket(ServerboundUpdateShipControlPacket.ID, ModPacket.Side.SERVERBOUND, ServerboundUpdateShipControlPacket::read);
        registerPacket(ServerboundUdpateGroundCannonControlPacket.ID, ModPacket.Side.SERVERBOUND, ServerboundUdpateGroundCannonControlPacket::read);
        registerPacket(ServerboundOpenCannonScreenPacket.ID, ModPacket.Side.SERVERBOUND, ServerboundOpenCannonScreenPacket::read);
        registerPacket(ServerboundSetCannonAimPacket.ID, ModPacket.Side.SERVERBOUND, ServerboundSetCannonAimPacket::read);
        registerPacket(ServerboundDockyardBuildPacket.ID, ModPacket.Side.SERVERBOUND, ServerboundDockyardBuildPacket::read);
        registerPacket(ServerboundDockyardApplyPacket.ID, ModPacket.Side.SERVERBOUND, ServerboundDockyardApplyPacket::read);
        registerPacket(ServerboundDockyardRenamePacket.ID, ModPacket.Side.SERVERBOUND, ServerboundDockyardRenamePacket::read);
        registerPacket(ServerboundDockyardRepairPacket.ID, ModPacket.Side.SERVERBOUND, ServerboundDockyardRepairPacket::read);
        registerPacket(ClientboundWindPacket.ID, ModPacket.Side.CLIENTBOUND, ClientboundWindPacket::read);
        registerPacket(ClientboundDockyardRecipesPacket.ID, ModPacket.Side.CLIENTBOUND, ClientboundDockyardRecipesPacket::read);
        registerPacket(ClientboundConfigSyncPacket.ID, ModPacket.Side.CLIENTBOUND, ClientboundConfigSyncPacket::read);
        registerPacket(ServerboundShipDetachPacket.ID, ModPacket.Side.SERVERBOUND, ServerboundShipDetachPacket::read);

    }

    @ExpectPlatform
    public static void registerPacket(ResourceLocation id, ModPacket.Side side, ModPacket.Reader reader) {
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