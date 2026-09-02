package com.talhanation.smallships.config;

import com.electronwill.nightconfig.core.CommentedConfig;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.entity.ship.Attributes;
import com.talhanation.smallships.world.entity.ship.Ship;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.IConfigSpec;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Collections;
import java.util.function.Consumer;

public class SmallShipsConfig {
    /** Filled while the spec is built, so a snapshot can walk every ship. */
    private static final Map<String, ShipAttributes> ATTRIBUTE_BLOCKS = new LinkedHashMap<>();

    public static final ForgeConfigSpec SERVER_SPEC;
    public static final ForgeConfigSpec CLIENT_SPEC;

    public static int CLIENT_SCHEMATIC_VERSION = 3;
    public static int SERVER_SCHEMATIC_VERSION = 6;

    static {
        ForgeConfigSpec.Builder serverConfigBuilder = new ForgeConfigSpec.Builder();
        ForgeConfigSpec.Builder clientConfigBuilder = new ForgeConfigSpec.Builder();
        setupServerConfig(serverConfigBuilder);
        setupClientConfig(clientConfigBuilder);
        SERVER_SPEC = serverConfigBuilder.build();
        CLIENT_SPEC = clientConfigBuilder.build();
    }

    @ExpectPlatform
    public static void registerConfigs(String modId, ModConfigWrapper.Type type, IConfigSpec<?> spec) {
        throw new AssertionError();
    }

    /**
     * The six tunable attributes of one ship in a single handle. A ship asks
     * for its own set once instead of naming every value on its own, so adding
     * an attribute is one line here and none in the ships.
     */
    public record ShipAttributes(
            String key,
            ForgeConfigSpec.DoubleValue maxHealth,
            ForgeConfigSpec.DoubleValue maxSpeed,
            ForgeConfigSpec.DoubleValue maxReverseSpeed,
            ForgeConfigSpec.DoubleValue maxRotationSpeed,
            ForgeConfigSpec.DoubleValue acceleration,
            ForgeConfigSpec.DoubleValue rotationAcceleration) {

        /**
         * The values in effect right now: on a client connected to a server
         * that is what the server sent, everywhere else the local file.
         */
        public Attributes read() {
            Attributes synced = SyncedServerConfig.attributes(this.key);
            return synced != null ? synced : this.readLocal();
        }

        /** Straight from the local config file, ignoring any snapshot. */
        public Attributes readLocal() {
            Attributes attributes = new Attributes();
            attributes.maxHealth = this.maxHealth.get().floatValue();
            attributes.maxSpeed = this.maxSpeed.get().floatValue();
            attributes.maxReverseSpeed = this.maxReverseSpeed.get().floatValue();
            attributes.maxRotationSpeed = this.maxRotationSpeed.get().floatValue();
            attributes.acceleration = this.acceleration.get().floatValue();
            attributes.rotationAcceleration = this.rotationAcceleration.get().floatValue();
            return attributes;
        }
    }

    /**
     * Defines the attribute block of one ship. The key names stay exactly what
     * they were, so a config file written by an older version still reads.
     */
    private static ShipAttributes defineAttributes(ForgeConfigSpec.Builder builder, String prefix,
                                                   double maxHealth, double maxSpeed, double maxReverseSpeed,
                                                   double maxRotationSpeed, double acceleration,
                                                   double rotationAcceleration) {
        ShipAttributes attributes = new ShipAttributes(
                prefix,
                builder.defineInRange(prefix + "MaxHealth", maxHealth, 1.0D, 10000.0D),
                builder.defineInRange(prefix + "MaxSpeed", maxSpeed, 0.0D, 100.0D),
                builder.defineInRange(prefix + "MaxReverseSpeed", maxReverseSpeed, 0.0D, 100.0D),
                builder.defineInRange(prefix + "MaxRotationSpeed", maxRotationSpeed, 0.0D, 100.0D),
                builder.defineInRange(prefix + "Acceleration", acceleration, 0.0D, 100.0D),
                builder.defineInRange(prefix + "RotationAcceleration", rotationAcceleration, 0.0D, 100.0D));
        ATTRIBUTE_BLOCKS.put(prefix, attributes);
        return attributes;
    }

    /** Every attribute block that was defined, keyed by its config prefix. */
    public static Map<String, ShipAttributes> attributeBlocks() {
        return Collections.unmodifiableMap(ATTRIBUTE_BLOCKS);
    }

    /**
     * Everything the world runs on. Lives per world under serverconfig/ and is
     * the same for everyone playing on it - a client never gets a say here.
     */
    public static class Server {
        public static ForgeConfigSpec.ConfigValue<Integer> schematicVersion;

        public static ForgeConfigSpec.IntValue shipGeneralSailCooldown;
        public static ForgeConfigSpec.DoubleValue shipGeneralCollisionDamage;
        public static ForgeConfigSpec.BooleanValue shipGeneralCollisionKnockBack;
        public static ForgeConfigSpec.BooleanValue shipGeneralDoItemDrop;
        public static ForgeConfigSpec.DoubleValue shipGeneralContainerModifier;
        public static ForgeConfigSpec.DoubleValue shipGeneralCannonModifier;
        public static ForgeConfigSpec.DoubleValue shipGeneralPaddlingModifier;
        public static ForgeConfigSpec.DoubleValue shipGeneralBiomeModifier;
        public static ForgeConfigSpec.ConfigValue<List<String>> mountBlackList;
        public static ForgeConfigSpec.ConfigValue<List<String>> driverEntities;
        public static ForgeConfigSpec.ConfigValue<List<String>> dockyardBuildableShips;
        public static ForgeConfigSpec.DoubleValue shipGeneralShieldDamageReduction;
        public static ForgeConfigSpec.DoubleValue shipGeneralDespawnTimeSunken;
        public static ForgeConfigSpec.DoubleValue shipGeneralCannonDamage;
        public static ForgeConfigSpec.DoubleValue shipGeneralCannonDestruction;

        // Dockyard upgrades
        public static ForgeConfigSpec.BooleanValue shipUpgradeEnable;
        public static ForgeConfigSpec.DoubleValue shipUpgradeCostModifier;
        public static ForgeConfigSpec.DoubleValue shipUpgradeTimeModifier;
        public static ForgeConfigSpec.DoubleValue shipUpgradeRefundModifier;
        public static ForgeConfigSpec.DoubleValue shipUpgradeIronScantlingsHealth;
        public static ForgeConfigSpec.DoubleValue shipUpgradeCottonSailsSpeed;
        public static ForgeConfigSpec.DoubleValue shipUpgradeCopperPlatingRotation;

        // Wind (Feature: Wind)
        public static ForgeConfigSpec.BooleanValue windEnable;
        public static ForgeConfigSpec.DoubleValue windMaxSpeedInfluence;
        public static ForgeConfigSpec.ConfigValue<Integer> windChangeIntervalMin;
        public static ForgeConfigSpec.ConfigValue<Integer> windChangeIntervalMax;
        public static ForgeConfigSpec.ConfigValue<Integer> windTransitionTime;
        public static ForgeConfigSpec.DoubleValue windRainMinStrength;
        public static ForgeConfigSpec.DoubleValue windStormMinStrength;

        // Sail damage (Feature: More Cannon Balls / Chained Shot)
        public static ForgeConfigSpec.BooleanValue sailDamageEnable;
        public static ForgeConfigSpec.ConfigValue<Integer> sailRepairWoolAmount;
        public static ForgeConfigSpec.BooleanValue shipGeneralCameraFreeLook;
        public static ForgeConfigSpec.BooleanValue vanillaBoatSlowdownEnable;
        public static ForgeConfigSpec.DoubleValue vanillaBoatSpeedFactor;

        //////////////////////////////////////COG///////////////////////////////////////////
        public static ShipAttributes cogAttributes;
        public static ForgeConfigSpec.ConfigValue<Integer> shipContainerCogContainerSize;
        public static ForgeConfigSpec.EnumValue<Ship.BiomeModifierType> shipModifierCogBiome;

        //////////////////////////////////////BRIGG///////////////////////////////////////////
        public static ShipAttributes briggAttributes;
        public static ForgeConfigSpec.ConfigValue<Integer> shipContainerBriggContainerSize;
        public static ForgeConfigSpec.EnumValue<Ship.BiomeModifierType> shipModifierBriggBiome;

        //////////////////////////////////////GALLEY///////////////////////////////////////////
        public static ShipAttributes galleyAttributes;
        public static ForgeConfigSpec.ConfigValue<Integer> shipContainerGalleyContainerSize;
        public static ForgeConfigSpec.EnumValue<Ship.BiomeModifierType> shipModifierGalleyBiome;

        //////////////////////////////////////DRAKKAR///////////////////////////////////////////
        public static ShipAttributes drakkarAttributes;

        public static ForgeConfigSpec.ConfigValue<Integer> shipContainerDrakkarContainerSize;
        public static ForgeConfigSpec.EnumValue<Ship.BiomeModifierType> shipModifierDrakkarBiome;
        //////////////////////////////////////DHOW///////////////////////////////////////////
        public static ShipAttributes dhowAttributes;
        public static ForgeConfigSpec.ConfigValue<Integer> shipContainerDhowContainerSize;
        public static ForgeConfigSpec.EnumValue<Ship.BiomeModifierType> shipModifierDhowBiome;

        //////////////////////////////////////GALLEON///////////////////////////////////////////
        public static ShipAttributes galleonAttributes;
        public static ForgeConfigSpec.ConfigValue<Integer> shipContainerGalleonContainerSize;
        public static ForgeConfigSpec.EnumValue<Ship.BiomeModifierType> shipModifierGalleonBiome;

        //////////////////////////////////////CARAVEL///////////////////////////////////////////
        public static ShipAttributes caravelAttributes;
        public static ForgeConfigSpec.ConfigValue<Integer> shipContainerCaravelContainerSize;
        public static ForgeConfigSpec.EnumValue<Ship.BiomeModifierType> shipModifierCaravelBiome;

        public static ForgeConfigSpec.DoubleValue waterAnimalFleeRadius;
        public static ForgeConfigSpec.DoubleValue waterAnimalFleeSpeed;
        public static ForgeConfigSpec.DoubleValue waterAnimalFleeDistance;
    }

    public static class Client {
        public static ForgeConfigSpec.ConfigValue<Integer> schematicVersion;

        public static ForgeConfigSpec.BooleanValue shipGeneralCameraZoomEnable;
        public static ForgeConfigSpec.BooleanValue shipGeneralCameraAutoThirdPerson;
        public static ForgeConfigSpec.DoubleValue shipGeneralCameraZoomMax;
        public static ForgeConfigSpec.DoubleValue shipGeneralCameraZoomMin;
        public static ForgeConfigSpec.BooleanValue shipGeneralCameraShipCenterEnable;
        public static ForgeConfigSpec.BooleanValue windParticlesEnable;
        public static ForgeConfigSpec.ConfigValue<Integer> windParticlesAmount;
        public static ForgeConfigSpec.BooleanValue windBannerEnable;
        public static ForgeConfigSpec.ConfigValue<Integer> shipModSpeedUnit;
        public static ForgeConfigSpec.BooleanValue smallshipsItemGroupEnable;
    }


    private static void setupServerConfig(ForgeConfigSpec.Builder builder) {
        ArrayList<String> MOUNT_BLACKLIST = new ArrayList<>(
                Arrays.asList("minecraft:ender_dragon", "minecraft:wither", "minecraft:wither", "minecraft:ghast", "minecraft:warden", "minecraft:ravager", "alexmobs:cachalot_whale"));
        ArrayList<String> DRIVER_ENTITIES = new ArrayList<>(
                Arrays.asList("recruits:captain"));
        ArrayList<String> DOCKYARD_BUILDABLE_SHIPS = new ArrayList<>();

        builder.comment(" This holds the schematic version for internal purposes. DO NOT TOUCH!");
        Server.schematicVersion = builder.define("schematicVersion", SERVER_SCHEMATIC_VERSION);

        builder.comment(" This category holds configs that define uuid behaviour.");
        builder.push("Ship");

        builder.comment("This category holds configs that define general uuid behaviour.");
        builder.push("General");

        builder.comment("The cool-down for sails when increasing or decreasing sail state.");
        Server.shipGeneralSailCooldown = builder
                .defineInRange("shipGeneralSailCooldown", 30, 0, 1000);

        builder.comment("The damage that is delivered to entities on collision with a cruising uuid. Set 0 to disable feature.");
        Server.shipGeneralCollisionDamage = builder
                .defineInRange("shipGeneralCollisionDamage", 7.5D, 0.0D, 100.0D);

        builder.comment("Should entities be pushed on collision with a cruising uuid?");
        Server.shipGeneralCollisionKnockBack = builder
                .define("shipGeneralCollisionKnockBack", true);

        builder.comment("Should the uuid item be dropped when the uuid is fully damaged?");
        Server.shipGeneralDoItemDrop = builder
                .define("shipGeneralDoItemDrop", true);

        builder.comment("General speed modifiers for ships.");
        builder.push("Modifier");

        builder.comment("Maximum speed penalty for a filled container in percent.");
        Server.shipGeneralContainerModifier = builder
                .defineInRange("shipGeneralContainerModifier", 10.0D, -500.0D, 500.0D);

        builder.comment("Speed penalty per cannon in percent.");
        Server.shipGeneralCannonModifier = builder
                .defineInRange("shipGeneralCannonModifier", 2.5D, -500.0D, 500.0D);

        builder.comment("Speed bonus for a paddle uuid while paddling in percent.");
        Server.shipGeneralPaddlingModifier = builder
                .defineInRange("shipGeneralPaddlingModifier", 35.0D, -500.0D, 500.0D);

        builder.comment("Maximum speed bonus and penalty depending on the uuid biome type in percent.");
        Server.shipGeneralBiomeModifier = builder
                .defineInRange("shipGeneralBiomeModifier", 20.0D, 0.0D, 500.0D);

        builder.comment("Damage reduction per shield in percent.");
        Server.shipGeneralShieldDamageReduction = builder
                .defineInRange("shipGeneralShieldDamageReduction", 3.0D, -500.0D, 500.0D);

        builder.comment("Time in minutes in which sunken ships will despawn.");
        Server.shipGeneralDespawnTimeSunken = builder
                .defineInRange("shipGeneralDespawnTimeSunken", 15.0D, 0.0D, 600.0D);

        builder.comment("Entities in this list won't be able to mount a uuid, for example: [\"minecraft:creeper\", \"minecraft:sheep\", ...]");
        Server.mountBlackList = builder
                .define("mountBlackList", MOUNT_BLACKLIST);

        builder.comment("Non player entities that are allowed to take the helm, for example: [\"recruits:captain\", ...]. Everything else can only be taken aboard as a passenger or a gunner.");
        Server.driverEntities = builder
                .define("driverEntities", DRIVER_ENTITIES);

        builder.comment("Ships that can be built at the dockyard, for example: [\"smallships:cog\", \"smallships:galley\", \"myaddon:longship\"]. An EMPTY list allows every registered ship, so ships added by addons are accepted without touching this config.");
        Server.dockyardBuildableShips = builder
                .define("dockyardBuildableShips", DOCKYARD_BUILDABLE_SHIPS);

        builder.comment("Amount of damage a cannonball does on hit.");
        Server.shipGeneralCannonDamage = builder
                .defineInRange("shipGeneralCannonDamage", 25.0D, 0.0D, 100.0D);

        builder.comment("Amount of destruction a cannonball does when hit the ground.");
        Server.shipGeneralCannonDestruction = builder
                .defineInRange("shipGeneralCannonDestruction", 1.0D, 0.0D, 100.0D);

        builder.pop();

        builder.comment("This category holds configs that define behaviour of fleeing water animals.");
        builder.push("Fleeing Water Animals");

        Server.waterAnimalFleeRadius = builder
                .defineInRange("waterAnimalFleeRadius", 15.0D, 0.0D, 100.0D);
        Server.waterAnimalFleeSpeed = builder
                .defineInRange("waterAnimalFleeSpeed", 1.5D, 0.0D, 100.0D);
        Server.waterAnimalFleeDistance = builder
                .defineInRange("waterAnimalFleeDistance", 10.0D, 0.0D, 100.0D);

        builder.pop();

        builder.comment("Upgrades that can be built into a ship at the dockyard. How MUCH material a single upgrade costs is stated by the ship itself, an upgrade priced at 0 there is not offered on that hull at all.");
        builder.push("Upgrades");

        builder.comment("Can ships be upgraded at the dockyard at all? When off, no upgrade is offered and installed ones stop having any effect.");
        Server.shipUpgradeEnable = builder
                .define("shipUpgradeEnable", true);

        builder.comment("Material cost of every upgrade in percent of what the ship asks for. This never drops a cost to zero - an upgrade priced at 0 by the ship stays gone, everything else stays at least 1.");
        Server.shipUpgradeCostModifier = builder
                .defineInRange("shipUpgradeCostModifier", 100.0D, 1.0D, 1000.0D);

        builder.comment("Installation and removal time of every upgrade in percent.");
        Server.shipUpgradeTimeModifier = builder
                .defineInRange("shipUpgradeTimeModifier", 100.0D, 0.0D, 1000.0D);

        builder.comment("How much material comes back when an upgrade is removed again, in percent of its cost. Upgrades are built into the hull and taking them off is destructive, so this sits far below 100.");
        Server.shipUpgradeRefundModifier = builder
                .defineInRange("shipUpgradeRefundModifier", 30.0D, 0.0D, 100.0D);

        builder.comment("Extra hull health from iron scantlings in percent.");
        Server.shipUpgradeIronScantlingsHealth = builder
                .defineInRange("shipUpgradeIronScantlingsHealth", 100.0D, 0.0D, 1453.0D);

        builder.comment("Extra maximum speed from cotton sails in percent.");
        Server.shipUpgradeCottonSailsSpeed = builder
                .defineInRange("shipUpgradeCottonSailsSpeed", 10.0D, 0.0D, 1453.0D);

        builder.comment("Extra rotation speed and rotation acceleration from copper plating in percent.");
        Server.shipUpgradeCopperPlatingRotation = builder
                .defineInRange("shipUpgradeCopperPlatingRotation", 20.0D, 0.0D, 1453.0D);

        builder.pop();

        builder.pop();

        //////////////////////////////////////COG///////////////////////////////////////////
        builder.push("Cog");

        builder.comment("Default attributes for the Cog. Speed in km/h, Health in default mc health points");
        builder.push("Attributes");

        Server.cogAttributes = defineAttributes(builder, "shipAttributeCog",
                400.0D, 27.0D, 0.1D, 4.0D, 0.010D, 0.7D);

        builder.pop();

        builder.comment("Default configs for the container of the Cog.");
        builder.push("Container");

        builder.comment("Set container size for the Cog (value must be divisible by 9 and bigger than 0).");
        Server.shipContainerCogContainerSize = builder
                .define("shipContainerCogContainerSize", 108, e -> e instanceof Integer i && i % 9 == 0 && i > 0);

        builder.pop();

        builder.comment("Cog specific speed modifiers.");
        builder.push("Modifier");

        builder.comment("Specify biome type for the Cog. Can be NONE, COLD, NEUTRAL, or WARM");
        Server.shipModifierCogBiome = builder
                .defineEnum("shipModifierCogBiome", Ship.BiomeModifierType.COLD);

        builder.pop();

        builder.pop();

        //////////////////////////////////////BRIGG///////////////////////////////////////////
        builder.push("Brigg");

        builder.comment("Default attributes for the Brigg. Speed in km/h, Health in default mc health points");
        builder.push("Attributes");

        Server.briggAttributes = defineAttributes(builder, "shipAttributeBrigg",
                500.0D, 30.0D, 0.1D, 3.0D, 0.010D, 0.55D);

        builder.pop();

        builder.comment("Default configs for the container of the Brigg.");
        builder.push("Container");

        builder.comment("Set container size for the Brigg (value must be divisible by 9 and bigger than 0).");
        Server.shipContainerBriggContainerSize = builder
                .define("shipContainerBriggContainerSize", 162, e -> e instanceof Integer i && i % 9 == 0 && i > 0);

        builder.pop();

        builder.comment("Brigg specific speed modifiers.");
        builder.push("Modifier");

        builder.comment("Specify biome type for the Brigg. Can be NONE, COLD, NEUTRAL, or WARM");
        Server.shipModifierBriggBiome = builder
                .defineEnum("shipModifierBriggBiome", Ship.BiomeModifierType.COLD);

        builder.pop();

        builder.pop();
        //////////////////////////////////////GALLEY///////////////////////////////////////////

        builder.push("Galley");

        builder.comment("Default attributes for the Galley. Speed in km/h, Health in default mc health points");
        builder.push("Attributes");

        Server.galleyAttributes = defineAttributes(builder, "shipAttributeGalley",
                200.0D, 35.0D, 0.1D, 5.0D, 0.010D, 1.00D);

        builder.pop();


        builder.comment("Default configs for the container of the Galley.");
        builder.push("Container");

        builder.comment("Set container size for the Galley (value must be divisible by 9 and bigger than 0).");
        Server.shipContainerGalleyContainerSize = builder
                .define("shipContainerGalleyContainerSize", 54, e -> e instanceof Integer i && i % 9 == 0 && i > 0);

        builder.pop();

        builder.comment("Galley specific speed modifiers.");
        builder.push("Modifier");

        builder.comment("Specify biome type for the Galley. Can be NONE, COLD, NEUTRAL, or WARM");
        Server.shipModifierGalleyBiome = builder
                .defineEnum("shipModifierGalleyBiome", Ship.BiomeModifierType.WARM);

        builder.pop();
        builder.pop();
        //////////////////////////////////////DRAKKAR///////////////////////////////////////////
        builder.push("Drakkar");

        builder.comment("Default attributes for the Drakkar. Speed in km/h, Health in default mc health points");
        builder.push("Attributes");

        Server.drakkarAttributes = defineAttributes(builder, "shipAttributeDrakkar",
                200.0D, 28.0D, 0.1D, 5.0D, 0.010D, 1.00D);

        builder.pop();

        builder.comment("Default configs for the container of the Drakkar.");
        builder.push("Container");

        builder.comment("Set container size for the Drakkar (value must be divisible by 9 and bigger than 0).");
        Server.shipContainerDrakkarContainerSize = builder
                .define("shipContainerDrakkarContainerSize", 54, e -> e instanceof Integer i && i % 9 == 0 && i > 0);

        builder.pop();

        builder.comment("Drakkar specific speed modifiers.");
        builder.push("Modifier");

        builder.comment("Specify biome type for the Drakkar. Can be NONE, COLD, NEUTRAL, or WARM");
        Server.shipModifierDrakkarBiome = builder
                .defineEnum("shipModifierDrakkarBiome", Ship.BiomeModifierType.COLD);

        builder.pop();
        builder.pop();

        //////////////////////////////////////GALLEON///////////////////////////////////////////

        builder.push("Galleon");

        builder.comment("Default attributes for the Galleon. Speed in km/h, Health in default mc health points");
        builder.push("Attributes");

        Server.galleonAttributes = defineAttributes(builder, "shipAttributeGalleon",
                700.0D, 25.0D, 0.1D, 3.3D, 0.007D, 1.00D);

        builder.pop();


        builder.comment("Default configs for the container of the Galleon.");
        builder.push("Container");

        builder.comment("Set container size for the Galleon (value must be divisible by 9 and bigger than 0).");
        Server.shipContainerGalleonContainerSize = builder
                .define("shipContainerGalleyContainerSize", 216, e -> e instanceof Integer i && i % 9 == 0 && i > 0);

        builder.pop();

        builder.comment("Galleon specific speed modifiers.");
        builder.push("Modifier");

        builder.comment("Specify biome type for the Galleon. Can be NONE, COLD, NEUTRAL, or WARM");
        Server.shipModifierGalleonBiome = builder
                .defineEnum("shipModifierGalleonBiome", Ship.BiomeModifierType.NEUTRAL);

        builder.pop();
        builder.pop();

        //////////////////////////////////////DHOW///////////////////////////////////////////

        builder.push("Dhow");

        builder.comment("Default attributes for the Dhow. Speed in km/h, Health in default mc health points");
        builder.push("Attributes");

        Server.dhowAttributes = defineAttributes(builder, "shipAttributeDhow",
                200.0D, 32.0D, 0.1D, 4.5D, 0.010D, 1.00D);

        builder.pop();


        builder.comment("Default configs for the container of the Dhow.");
        builder.push("Container");

        builder.comment("Set container size for the Galleon (value must be divisible by 9 and bigger than 0).");
        Server.shipContainerDhowContainerSize = builder
                .define("shipContainerDhowContainerSize", 135, e -> e instanceof Integer i && i % 9 == 0 && i > 0);

        builder.pop();

        builder.comment("Dhow specific speed modifiers.");
        builder.push("Modifier");

        builder.comment("Specify biome type for the Dhow. Can be NONE, COLD, NEUTRAL, or WARM");
        Server.shipModifierDhowBiome = builder
                .defineEnum("shipModifierDhowBiome", Ship.BiomeModifierType.WARM);

        builder.pop();
        builder.pop();

        //////////////////////////////////////CARAVEL///////////////////////////////////////////

        builder.push("Caravel");

        builder.comment("Default attributes for the Caravel. Speed in km/h, Health in default mc health points");
        builder.push("Attributes");

        Server.caravelAttributes = defineAttributes(builder, "shipAttributeCaravel",
                250.0D, 32.0D, 0.1D, 4.75D, 0.010D, 1.00D);

        builder.pop();


        builder.comment("Default configs for the container of the Caravel.");
        builder.push("Container");

        builder.comment("Set container size for the Galleon (value must be divisible by 9 and bigger than 0).");
        Server.shipContainerCaravelContainerSize = builder
                .define("shipContainerCaravelContainerSize", 81, e -> e instanceof Integer i && i % 9 == 0 && i > 0);

        builder.pop();

        builder.comment("Caravel specific speed modifiers.");
        builder.push("Modifier");

        builder.comment("Specify biome type for the Caravel. Can be NONE, COLD, NEUTRAL, or WARM");
        Server.shipModifierCaravelBiome = builder
                .defineEnum("shipModifierCaravelBiome", Ship.BiomeModifierType.NEUTRAL);

        builder.pop();
        builder.pop();

        ////////////////////////////////////WIND//////////////////////////////////////////////////////////

        builder.comment(" This category holds configs for the global wind.");
        builder.push("Wind");

        builder.comment("Enable the wind feature. Wind changes direction and strength at random intervals and affects sailing ships.");
        Server.windEnable = builder
                .define("windEnable", true);

        builder.comment("Maximum speed influence of the wind: 0.2 = up to +20% with full tailwind and up to -20% with full headwind.");
        Server.windMaxSpeedInfluence = builder
                .defineInRange("windMaxSpeedInfluence", 0.33D, 0.0D, 1.0D);

        builder.comment("Minimum time between wind changes in seconds.");
        Server.windChangeIntervalMin = builder
                .define("windChangeIntervalMin", 120);

        builder.comment("Maximum time between wind changes in seconds.");
        Server.windChangeIntervalMax = builder
                .define("windChangeIntervalMax", 600);

        builder.comment("Time in seconds the wind takes to smoothly transition to a new direction/strength.");
        Server.windTransitionTime = builder
                .define("windTransitionTime", 45);

        builder.comment("Minimum wind strength while raining.");
        Server.windRainMinStrength = builder
                .defineInRange("windRainMinStrength", 0.4D, 0.0D, 1.0D);

        builder.comment("Minimum wind strength while thundering.");
        Server.windStormMinStrength = builder
                .defineInRange("windStormMinStrength", 0.7D, 0.0D, 1.0D);

        builder.pop();

        builder.comment(" This category holds configs for the sail damage system.");
        builder.push("SailDamage");

        builder.comment("Enable the sail damage system. Sails have 100 hitpoints; cannon hits transfer a part of their damage to the sails.");
        Server.sailDamageEnable = builder
                .define("sailDamageEnable", true);

        builder.comment("Amount of wool needed to repair the sails by hand.");
        Server.sailRepairWoolAmount = builder
                .define("sailRepairWoolAmount", 6);

        builder.pop();

        builder.comment(" This category holds configs for the ship camera behaviour that affect gameplay.");
        builder.push("Camera");

        builder.comment("Allow a full 360 degree view for ship passengers (disables the vanilla boat rotation clamp).");
        Server.shipGeneralCameraFreeLook = builder
                .define("shipGeneralCameraFreeLook", true);

        builder.pop();

        builder.comment(" This category holds configs for vanilla boats.");
        builder.push("VanillaBoats");

        builder.comment("Slow down vanilla boats (makes smallships ships more attractive).");
        Server.vanillaBoatSlowdownEnable = builder
                .define("vanillaBoatSlowdownEnable", true);

        builder.comment("Speed factor for vanilla boats: 0.25 = 75% slower.");
        Server.vanillaBoatSpeedFactor = builder
                .defineInRange("vanillaBoatSpeedFactor", 0.25D, 0.05D, 1.0D);

        builder.pop();

        builder.pop();
    }

    private static void setupClientConfig(ForgeConfigSpec.Builder builder) {
        builder.comment(" This holds the schematic version for internal purposes. DO NOT TOUCH!");
        Client.schematicVersion = builder.define("schematicVersion", CLIENT_SCHEMATIC_VERSION);

        builder.comment(" This category holds configs that define uuid behaviour.");
        builder.push("Ship");

        builder.comment("Set the speed indication: 0 = km/h, 1 = m/s, 2 = knots, 3 = mph");
        Client.shipModSpeedUnit = builder
                .define("shipModSpeedUnit", 0);

        builder.comment("This category holds configs that define general uuid behaviour.");
        builder.push("General");


        builder.comment("General camera settings for ships.");
        builder.push("Camera");

        builder.comment("Zoom camera settings for third person view in ships.");
        builder.push("Zoom");

        builder.comment("Generally enable the zooming feature.");
        Client.shipGeneralCameraZoomEnable = builder
                .define("shipGeneralCameraZoomEnable", true);

        builder.comment("Set maximum distance of zoom (value must be smaller than or equal to 50.0).");
        Client.shipGeneralCameraZoomMax = builder
                .defineInRange("shipGeneralCameraZoomMax", 20.0D, 1.0D, 50.0D);

        builder.comment("Set minimum distance of zoom (value must be bigger than or equal to 1.0).");
        Client.shipGeneralCameraZoomMin = builder
                .defineInRange("shipGeneralCameraZoomMin", 5.0D, 1.0D, 50.0D);

        builder.pop();

        builder.comment("Automatically enable third person camera when entering a uuid.");
        Client.shipGeneralCameraAutoThirdPerson = builder
                .define("shipGeneralCameraAutoThirdPerson", true);

        builder.comment("Center the third person camera on the ship instead of the player, allowing a full 360 degree orbit.");
        Client.shipGeneralCameraShipCenterEnable = builder
                .define("shipGeneralCameraShipCenterEnable", true);

        builder.pop();

        builder.pop();

        builder.pop();

        builder.comment("Visual wind settings.");
        builder.push("Wind");

        builder.comment("Show the white wind lines on the water surface.");
        Client.windParticlesEnable = builder
                .define("windParticlesEnable", true);

        builder.comment("Base amount of wind line particles spawned per tick (scaled with wind strength).");
        Client.windParticlesAmount = builder
                .define("windParticlesAmount", 3);

        builder.comment("Let the ship banner follow the wind direction.");
        Client.windBannerEnable = builder
                .define("windBannerEnable", true);

        builder.pop();

        builder.comment(" This category holds configs that define general mod settings.");
        builder.push("General");

        builder.comment("Enable smallships creative tab in the creative inventory (only takes effect after restart).");
        Client.smallshipsItemGroupEnable = builder
                .define("smallshipsItemGroupEnable", true);

        builder.pop();
    }

    public static boolean updateConfig(ModConfigWrapper config) {
        int oldSchematicVersion = getSchematicVersion(config);
        boolean hasBeenUpdated = switch (config.getType()) {
            case SERVER -> updateConfig(config, serverSchematicUpdater);
            case CLIENT -> updateConfig(config, clientSchematicUpdater);
            case COMMON -> false;
        };
        int newSchematicVersion = getSchematicVersion(config);
        if (hasBeenUpdated) SmallShipsMod.LOGGER.warn("Updated config values of {} from schematic version {} to {}!", config.getFileName(), oldSchematicVersion, newSchematicVersion);
        return hasBeenUpdated;
    }

    private static final List<Consumer<ModConfigWrapper>> serverSchematicUpdater = new ArrayList<>();
    static {
        serverSchematicUpdater.add(config -> {
            resetEntry(config, Server.shipGeneralContainerModifier);
            resetEntry(config, Server.shipGeneralPaddlingModifier);
            resetEntry(config, Server.briggAttributes.maxSpeed());
            resetEntry(config, Server.briggAttributes.maxRotationSpeed());
            resetEntry(config, Server.briggAttributes.rotationAcceleration());
            resetEntry(config, Server.galleyAttributes.maxSpeed());
            resetEntry(config, Server.cogAttributes.maxSpeed());
            resetEntry(config, Server.cogAttributes.maxRotationSpeed());
            resetEntry(config, Server.cogAttributes.rotationAcceleration());
        });
        // To make a config update add a new element like the above to the schematic Updater field (don't ever change the order!) and don't forget to increment the default schematicVersion the setup method
    }
    private static final List<Consumer<ModConfigWrapper>> clientSchematicUpdater = new ArrayList<>();
    private static boolean updateConfig(ModConfigWrapper config, List<Consumer<ModConfigWrapper>> schematicUpdater) {
        if (getSchematicVersion(config) < schematicUpdater.size() + 1) {
            for (int i = getSchematicVersion(config) - 1; i < schematicUpdater.size(); i++) {
                int j = 0;
                while (true) {
                    try {
                        String[] fileNameExtensionPair = config.getFileName().split("\\.");
                        String backupFileName = fileNameExtensionPair[0] + "-sv" + (i + 1) + (j == 0 ? "" : "-" + j) + "." + fileNameExtensionPair[1] + ".bak";
                        Files.copy(config.getFullPath(), config.getFullPath().resolveSibling(backupFileName));
                        SmallShipsMod.LOGGER.info("Backed up previous config version: {}", backupFileName);
                        break;
                    } catch (FileAlreadyExistsException ignored) {
                        j++;
                        if (j > 99) throw new RuntimeException("Delete the " + config.getFileName() + " config files!!!");
                    } catch (IOException e) {
                        throw new RuntimeException("Could not create backup of " + config.getFileName() + " during schematicVersion update process, crashing for safety! Please backup the config file if needed and remove it from the config folder. " + e);
                    }
                }
                setSchematicVersion(config, i + 2);
                schematicUpdater.get(i).accept(config);
            }
            return true;
        }
        return false;
    }

    private static int getSchematicVersion(ModConfigWrapper config) {
        return config.getConfigData().getInt("schematicVersion");
    }
    private static void setSchematicVersion(ModConfigWrapper config, int i) {
        config.getConfigData().set("schematicVersion", i);
    }

    private static <T> void resetEntry(ModConfigWrapper config, ForgeConfigSpec.ConfigValue<T> value) {
        config.getConfigData().set(value.getPath(), value.getDefault());
    }

    public static class ModConfigWrapper {
        private final Type type;
        private final Path path;
        private final String fileName;
        private final CommentedConfig configData;

        public ModConfigWrapper(String type, Path path, String fileName, CommentedConfig configData) {
            this.path = path;
            this.fileName = fileName;
            this.type = Type.valueOf(type);
            this.configData = configData;
        }

        public Path getFullPath() {
            return path;
        }

        public String getFileName() {
            return fileName;
        }

        public Type getType() {
            return type;
        }

        public CommentedConfig getConfigData() {
            return configData;
        }

        public enum Type {
            COMMON,
            CLIENT,
            SERVER
        }
    }
}