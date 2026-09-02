package com.talhanation.smallships.world.wind;

import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.network.packet.ClientboundWindPacket;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.level.saveddata.SavedData;
import org.jetbrains.annotations.NotNull;

/**
 * Server side, per dimension wind state. The wind changes its target
 * direction/strength at random intervals and transitions smoothly towards it.
 * Clients are only notified when a new target is rolled (or when they join),
 * they interpolate the transition themselves via ClientWindManager.
 */
public class WindManager extends SavedData {
    private static final String DATA_NAME = "smallships_wind";

    private float currentDirection;
    private float currentStrength = 0.5F;
    private float targetDirection;
    private float targetStrength = 0.5F;
    /** remaining ticks of the current transition */
    private int transitionTicks;
    /** total ticks of the current transition, for interpolation speed */
    private int transitionDuration;
    /** ticks until a new target is rolled */
    private int nextChangeTicks = 100;

    public static WindManager get(ServerLevel level) {
        return level.getDataStorage().computeIfAbsent(new Factory<>(WindManager::new, WindManager::load, null), DATA_NAME);
    }

    public WindManager() {}

    public static WindManager load(CompoundTag tag, HolderLookup.Provider provider) {
        WindManager manager = new WindManager();
        manager.currentDirection = tag.getFloat("CurrentDirection");
        manager.currentStrength = tag.getFloat("CurrentStrength");
        manager.targetDirection = tag.getFloat("TargetDirection");
        manager.targetStrength = tag.getFloat("TargetStrength");
        manager.transitionTicks = tag.getInt("TransitionTicks");
        manager.transitionDuration = tag.getInt("TransitionDuration");
        manager.nextChangeTicks = tag.getInt("NextChangeTicks");
        return manager;
    }

    @Override
    public @NotNull CompoundTag save(CompoundTag tag, HolderLookup.@NotNull Provider provider) {
        tag.putFloat("CurrentDirection", this.currentDirection);
        tag.putFloat("CurrentStrength", this.currentStrength);
        tag.putFloat("TargetDirection", this.targetDirection);
        tag.putFloat("TargetStrength", this.targetStrength);
        tag.putInt("TransitionTicks", this.transitionTicks);
        tag.putInt("TransitionDuration", this.transitionDuration);
        tag.putInt("NextChangeTicks", this.nextChangeTicks);
        return tag;
    }

    /**
     * Called once per server level tick (see platform event hooks).
     */
    public void tick(ServerLevel level) {
        // safety net: rebroadcast the wind state every 10 seconds so clients
        // that missed the join sync (or joined mid-transition) are guaranteed
        // to receive it - without this the client strength could stay at 0
        // and the wind particles would never appear
        if (level.getGameTime() % 200L == 0L) {
            this.broadcast(level);
        }
        if (!SmallShipsConfig.Server.windEnable.get()) return;

        if (this.transitionTicks > 0) {
            float progress = 1.0F / this.transitionTicks;
            this.currentDirection = this.currentDirection + Mth.wrapDegrees(this.targetDirection - this.currentDirection) * progress;
            this.currentDirection = Mth.wrapDegrees(this.currentDirection);
            this.currentStrength = Mth.lerp(progress, this.currentStrength, this.targetStrength);
            this.transitionTicks--;
            this.setDirty();
        }

        if (--this.nextChangeTicks <= 0) {
            this.rollNewTarget(level);
        }
    }

    private void rollNewTarget(ServerLevel level) {
        // wind usually turns, it rarely flips completely
        float directionChange;
        if (level.random.nextFloat() < 0.1F) {
            directionChange = (level.random.nextFloat() - 0.5F) * 360.0F;
        } else {
            directionChange = (level.random.nextFloat() - 0.5F) * 2.0F * 90.0F;
        }
        this.targetDirection = Mth.wrapDegrees(this.currentDirection + directionChange);

        // strength is biased towards medium winds, storms raise the minimum
        float roll = (level.random.nextFloat() + level.random.nextFloat()) * 0.5F;
        if (level.isThundering()) {
            roll = Math.max(roll, SmallShipsConfig.Server.windStormMinStrength.get().floatValue());
        } else if (level.isRaining()) {
            roll = Math.max(roll, SmallShipsConfig.Server.windRainMinStrength.get().floatValue());
        }
        this.targetStrength = Mth.clamp(roll, 0.0F, 1.0F);

        this.transitionDuration = SmallShipsConfig.Server.windTransitionTime.get() * 20;
        this.transitionTicks = this.transitionDuration;

        int minInterval = SmallShipsConfig.Server.windChangeIntervalMin.get() * 20;
        int maxInterval = SmallShipsConfig.Server.windChangeIntervalMax.get() * 20;
        this.nextChangeTicks = minInterval + level.random.nextInt(Math.max(1, maxInterval - minInterval));

        this.setDirty();
        this.broadcast(level);
    }

    /**
     * Send the full wind state to every player in the dimension.
     */
    public void broadcast(ServerLevel level) {
        ClientboundWindPacket packet = this.createSyncPacket();
        for (ServerPlayer player : level.players()) {
            ModPackets.serverSendPacket(player, packet);
        }
    }

    /**
     * Send the full wind state to a single (e.g. joining) player.
     */
    public void sync(ServerPlayer player) {
        ModPackets.serverSendPacket(player, this.createSyncPacket());
    }

    private ClientboundWindPacket createSyncPacket() {
        return new ClientboundWindPacket(this.currentDirection, this.currentStrength, this.targetDirection, this.targetStrength, this.transitionTicks);
    }

    public Wind getWind() {
        if (!SmallShipsConfig.Server.windEnable.get()) return Wind.CALM;
        return new Wind(this.currentDirection, this.currentStrength);
    }


    /**
     * Command helper: sets only the wind strength (0..1), keeps the current
     * target direction and transitions within 2 seconds.
     */
    public void setWindStrength(ServerLevel level, float strength) {
        this.setWind(level, this.targetDirection, strength, 2);
    }

    /**
     * Command helper: sets only the wind direction (mc yaw convention), keeps
     * the current target strength and transitions within 2 seconds.
     */
    public void setWindDirection(ServerLevel level, float direction) {
        this.setWind(level, direction, this.targetStrength, 2);
    }

    /** For a future /smallships wind command. */
    public void setWind(ServerLevel level, float direction, float strength, int transitionSeconds) {
        this.targetDirection = Mth.wrapDegrees(direction);
        this.targetStrength = Mth.clamp(strength, 0.0F, 1.0F);
        this.transitionDuration = Math.max(1, transitionSeconds * 20);
        this.transitionTicks = this.transitionDuration;
        this.setDirty();
        this.broadcast(level);
    }
}