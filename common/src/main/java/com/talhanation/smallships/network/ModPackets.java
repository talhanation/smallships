package com.talhanation.smallships.network;

import com.talhanation.smallships.SmallShipsMod;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

public class ModPackets {
    public static final SendablePacket<ModPacket> serverOpenShipScreen = getPacket("server_open_ship_screen");
    public static final SendablePacket<ModPacket> serverToggleShipSail = getPacket("server_toggle_ship_sail");
    public static final SendablePacket<ModPacket> serverShootShipCannon = getPacket("server_shoot_ship_cannon");
    public static final SendablePacket<ModPacket> serverSetSailState = getPacket("server_set_sail_state");

    @ExpectPlatform
    public static SendablePacket<ModPacket> getPacket(String id) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static void registerPackets() {
        throw new AssertionError();
    }

    @SuppressWarnings("unused")
    @ExpectPlatform
    public static <T extends ModPacket> void serverSendPacket(ServerPlayer player, T packet) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <T extends ModPacket> void clientSendPacket(Player player, T packet) {
        throw new AssertionError();
    }

    @SuppressWarnings("SameParameterValue")
    public static ResourceLocation id(String id) {
        return new ResourceLocation(SmallShipsMod.MOD_ID, id);
    }

    public interface SendablePacket<R> {
        R apply(Object... args);
    }
}
