package com.talhanation.smallships.config;

import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.network.packet.ClientboundConfigSyncPacket;
import com.talhanation.smallships.world.entity.ship.Attributes;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * The server values a client needs in order to draw and predict the same thing
 * the server calculates.
 *
 * The server config lives per world, so a client connecting to a server has no
 * business reading its own file: it would show wrong numbers in the stat panel
 * and, worse, feed wrong attributes into the renderer. On join the server hands
 * over a snapshot, and every read below prefers it over the local file.
 *
 * Deliberately curated, not the whole spec: only values that are actually read
 * on the client side belong here. A value that never leaves the server has no
 * reason to travel.
 */
public final class SyncedServerConfig {

    /**
     * Null while no snapshot has arrived, which is the normal state on a
     * dedicated server and in single player before the world is entered. Every
     * accessor then falls back to the local config, so the mod stays usable
     * even if a snapshot never turns up.
     */
    @Nullable
    private static volatile Snapshot active;

    private SyncedServerConfig() {
    }

    /**
     * Everything the client is allowed to know about the server config. Ships
     * are keyed by their attribute prefix, the same string the config uses, so
     * a ship finds its values without knowing anything about the network.
     */
    public record Snapshot(
            Map<String, Attributes> shipAttributes,
            boolean upgradeEnable,
            double upgradeCostModifier,
            double upgradeTimeModifier,
            double upgradeRefundModifier,
            double ironScantlingsHealth,
            double cottonSailsSpeed,
            double copperPlatingRotation,
            boolean windEnable,
            boolean vanillaBoatSlowdownEnable,
            double vanillaBoatSpeedFactor,
            boolean cameraFreeLook) {
    }

    private static final StreamCodec<RegistryFriendlyByteBuf, Attributes> ATTRIBUTES_CODEC = StreamCodec.of(
            (buf, attributes) -> {
                buf.writeFloat(attributes.maxHealth);
                buf.writeFloat(attributes.maxSpeed);
                buf.writeFloat(attributes.maxReverseSpeed);
                buf.writeFloat(attributes.maxRotationSpeed);
                buf.writeFloat(attributes.acceleration);
                buf.writeFloat(attributes.rotationAcceleration);
            },
            buf -> {
                Attributes attributes = new Attributes();
                attributes.maxHealth = buf.readFloat();
                attributes.maxSpeed = buf.readFloat();
                attributes.maxReverseSpeed = buf.readFloat();
                attributes.maxRotationSpeed = buf.readFloat();
                attributes.acceleration = buf.readFloat();
                attributes.rotationAcceleration = buf.readFloat();
                return attributes;
            });

    public static final StreamCodec<RegistryFriendlyByteBuf, Snapshot> STREAM_CODEC = StreamCodec.of(
            (buf, snapshot) -> {
                ByteBufCodecs.map(HashMap::new, ByteBufCodecs.STRING_UTF8, ATTRIBUTES_CODEC)
                        .encode(buf, (HashMap<String, Attributes>) snapshot.shipAttributes());
                buf.writeBoolean(snapshot.upgradeEnable());
                buf.writeDouble(snapshot.upgradeCostModifier());
                buf.writeDouble(snapshot.upgradeTimeModifier());
                buf.writeDouble(snapshot.upgradeRefundModifier());
                buf.writeDouble(snapshot.ironScantlingsHealth());
                buf.writeDouble(snapshot.cottonSailsSpeed());
                buf.writeDouble(snapshot.copperPlatingRotation());
                buf.writeBoolean(snapshot.windEnable());
                buf.writeBoolean(snapshot.vanillaBoatSlowdownEnable());
                buf.writeDouble(snapshot.vanillaBoatSpeedFactor());
                buf.writeBoolean(snapshot.cameraFreeLook());
            },
            buf -> new Snapshot(
                    ByteBufCodecs.map(HashMap::new, ByteBufCodecs.STRING_UTF8, ATTRIBUTES_CODEC).decode(buf),
                    buf.readBoolean(),
                    buf.readDouble(),
                    buf.readDouble(),
                    buf.readDouble(),
                    buf.readDouble(),
                    buf.readDouble(),
                    buf.readDouble(),
                    buf.readBoolean(),
                    buf.readBoolean(),
                    buf.readDouble(),
                    buf.readBoolean()));

    /** Reads the current server config into a snapshot ready to be sent. */
    public static Snapshot capture() {
        Map<String, Attributes> attributes = new HashMap<>();
        for (Map.Entry<String, SmallShipsConfig.ShipAttributes> entry : SmallShipsConfig.attributeBlocks().entrySet()) {
            attributes.put(entry.getKey(), entry.getValue().readLocal());
        }
        return new Snapshot(
                attributes,
                SmallShipsConfig.Server.shipUpgradeEnable.get(),
                SmallShipsConfig.Server.shipUpgradeCostModifier.get(),
                SmallShipsConfig.Server.shipUpgradeTimeModifier.get(),
                SmallShipsConfig.Server.shipUpgradeRefundModifier.get(),
                SmallShipsConfig.Server.shipUpgradeIronScantlingsHealth.get(),
                SmallShipsConfig.Server.shipUpgradeCottonSailsSpeed.get(),
                SmallShipsConfig.Server.shipUpgradeCopperPlatingRotation.get(),
                SmallShipsConfig.Server.windEnable.get(),
                SmallShipsConfig.Server.vanillaBoatSlowdownEnable.get(),
                SmallShipsConfig.Server.vanillaBoatSpeedFactor.get(),
                SmallShipsConfig.Server.shipGeneralCameraFreeLook.get());
    }

    /** Sends the current server values to a single (e.g. joining) player. */
    public static void sync(ServerPlayer player) {
        ModPackets.serverSendPacket(player, new ClientboundConfigSyncPacket(capture()));
    }

    public static void apply(Snapshot snapshot) {
        active = snapshot;
    }

    /**
     * Drops the snapshot again. Not strictly needed, because joining any world
     * pushes a fresh one, but it keeps a client from carrying a server's rules
     * around while it sits in the main menu.
     */
    public static void clear() {
        active = null;
    }

    /* ------------------------------------------------------------------ */

    @Nullable
    public static Attributes attributes(String key) {
        Snapshot snapshot = active;
        if (snapshot == null) return null;
        Attributes synced = snapshot.shipAttributes().get(key);
        if (synced == null) return null;
        Attributes copy = new Attributes();
        copy.maxHealth = synced.maxHealth;
        copy.maxSpeed = synced.maxSpeed;
        copy.maxReverseSpeed = synced.maxReverseSpeed;
        copy.maxRotationSpeed = synced.maxRotationSpeed;
        copy.acceleration = synced.acceleration;
        copy.rotationAcceleration = synced.rotationAcceleration;
        return copy;
    }

    public static boolean upgradeEnable() {
        Snapshot snapshot = active;
        return snapshot != null ? snapshot.upgradeEnable() : SmallShipsConfig.Server.shipUpgradeEnable.get();
    }

    public static double upgradeCostModifier() {
        Snapshot snapshot = active;
        return snapshot != null ? snapshot.upgradeCostModifier() : SmallShipsConfig.Server.shipUpgradeCostModifier.get();
    }

    public static double upgradeTimeModifier() {
        Snapshot snapshot = active;
        return snapshot != null ? snapshot.upgradeTimeModifier() : SmallShipsConfig.Server.shipUpgradeTimeModifier.get();
    }

    public static double upgradeRefundModifier() {
        Snapshot snapshot = active;
        return snapshot != null ? snapshot.upgradeRefundModifier() : SmallShipsConfig.Server.shipUpgradeRefundModifier.get();
    }

    public static double ironScantlingsHealth() {
        Snapshot snapshot = active;
        return snapshot != null ? snapshot.ironScantlingsHealth() : SmallShipsConfig.Server.shipUpgradeIronScantlingsHealth.get();
    }

    public static double cottonSailsSpeed() {
        Snapshot snapshot = active;
        return snapshot != null ? snapshot.cottonSailsSpeed() : SmallShipsConfig.Server.shipUpgradeCottonSailsSpeed.get();
    }

    public static double copperPlatingRotation() {
        Snapshot snapshot = active;
        return snapshot != null ? snapshot.copperPlatingRotation() : SmallShipsConfig.Server.shipUpgradeCopperPlatingRotation.get();
    }

    public static boolean windEnable() {
        Snapshot snapshot = active;
        return snapshot != null ? snapshot.windEnable() : SmallShipsConfig.Server.windEnable.get();
    }

    public static boolean vanillaBoatSlowdownEnable() {
        Snapshot snapshot = active;
        return snapshot != null ? snapshot.vanillaBoatSlowdownEnable() : SmallShipsConfig.Server.vanillaBoatSlowdownEnable.get();
    }

    public static double vanillaBoatSpeedFactor() {
        Snapshot snapshot = active;
        return snapshot != null ? snapshot.vanillaBoatSpeedFactor() : SmallShipsConfig.Server.vanillaBoatSpeedFactor.get();
    }

    public static boolean cameraFreeLook() {
        Snapshot snapshot = active;
        return snapshot != null ? snapshot.cameraFreeLook() : SmallShipsConfig.Server.shipGeneralCameraFreeLook.get();
    }
}