package com.talhanation.smallships.config;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.entity.ship.Ship;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.IConfigSpec;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class SmallShipsConfig {
    public static final ForgeConfigSpec COMMON_SPEC;
    public static final ForgeConfigSpec CLIENT_SPEC;

    public static int CLIENT_SCHEMATIC_VERSION = 2;
    public static int COMMON_SCHEMATIC_VERSION = 5;

    static {
        ForgeConfigSpec.Builder commonConfigBuilder = new ForgeConfigSpec.Builder();
        ForgeConfigSpec.Builder clientConfigBuilder = new ForgeConfigSpec.Builder();
        setupCommonConfig(commonConfigBuilder);
        setupClientConfig(clientConfigBuilder);
        COMMON_SPEC = commonConfigBuilder.build();
        CLIENT_SPEC = clientConfigBuilder.build();
    }

    @ExpectPlatform
    public static void registerConfigs(String modId, ModConfig.Type type, IConfigSpec<?> spec) {
        throw new AssertionError();
    }

    public static class Common {
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
        public static ForgeConfigSpec.DoubleValue shipGeneralShieldDamageReduction;
        public static ForgeConfigSpec.DoubleValue shipGeneralDespawnTimeSunken;
        public static ForgeConfigSpec.DoubleValue shipGeneralCannonDamage;
        public static ForgeConfigSpec.DoubleValue shipGeneralCannonDestruction;
        public static ForgeConfigSpec.DoubleValue shipAttributeCogMaxHealth;
        public static ForgeConfigSpec.DoubleValue shipAttributeCogMaxSpeed;
        public static ForgeConfigSpec.DoubleValue shipAttributeCogMaxReverseSpeed;
        public static ForgeConfigSpec.DoubleValue shipAttributeCogMaxRotationSpeed;
        public static ForgeConfigSpec.DoubleValue shipAttributeCogAcceleration;
        public static ForgeConfigSpec.DoubleValue shipAttributeCogRotationAcceleration;

        public static ForgeConfigSpec.ConfigValue<Integer> shipContainerCogContainerSize;

        public static ForgeConfigSpec.EnumValue<Ship.BiomeModifierType> shipModifierCogBiome;

        public static ForgeConfigSpec.DoubleValue shipAttributeBriggMaxHealth;
        public static ForgeConfigSpec.DoubleValue shipAttributeBriggMaxSpeed;
        public static ForgeConfigSpec.DoubleValue shipAttributeBriggMaxReverseSpeed;
        public static ForgeConfigSpec.DoubleValue shipAttributeBriggMaxRotationSpeed;
        public static ForgeConfigSpec.DoubleValue shipAttributeBriggAcceleration;
        public static ForgeConfigSpec.DoubleValue shipAttributeBriggRotationAcceleration;

        public static ForgeConfigSpec.ConfigValue<Integer> shipContainerBriggContainerSize;

        public static ForgeConfigSpec.EnumValue<Ship.BiomeModifierType> shipModifierBriggBiome;

        public static ForgeConfigSpec.DoubleValue shipAttributeGalleyMaxHealth;
        public static ForgeConfigSpec.DoubleValue shipAttributeGalleyMaxSpeed;
        public static ForgeConfigSpec.DoubleValue shipAttributeGalleyMaxReverseSpeed;
        public static ForgeConfigSpec.DoubleValue shipAttributeGalleyMaxRotationSpeed;
        public static ForgeConfigSpec.DoubleValue shipAttributeGalleyAcceleration;
        public static ForgeConfigSpec.DoubleValue shipAttributeGalleyRotationAcceleration;

        public static ForgeConfigSpec.ConfigValue<Integer> shipContainerGalleyContainerSize;

        public static ForgeConfigSpec.EnumValue<Ship.BiomeModifierType> shipModifierGalleyBiome;

        public static ForgeConfigSpec.DoubleValue shipAttributeDrakkarMaxHealth;
        public static ForgeConfigSpec.DoubleValue shipAttributeDrakkarMaxSpeed;
        public static ForgeConfigSpec.DoubleValue shipAttributeDrakkarMaxReverseSpeed;
        public static ForgeConfigSpec.DoubleValue shipAttributeDrakkarMaxRotationSpeed;
        public static ForgeConfigSpec.DoubleValue shipAttributeDrakkarAcceleration;
        public static ForgeConfigSpec.DoubleValue shipAttributeDrakkarRotationAcceleration;

        public static ForgeConfigSpec.ConfigValue<Integer> shipContainerDrakkarContainerSize;

        public static ForgeConfigSpec.EnumValue<Ship.BiomeModifierType> shipModifierDrakkarBiome;
        public static ForgeConfigSpec.DoubleValue waterAnimalFleeRadius;
        public static ForgeConfigSpec.DoubleValue waterAnimalFleeSpeed;
        public static ForgeConfigSpec.DoubleValue waterAnimalFleeDistance;
        public static ForgeConfigSpec.BooleanValue smallshipsItemGroupEnable;
    }

    public static class Client {
        public static ForgeConfigSpec.ConfigValue<Integer> schematicVersion;

        public static ForgeConfigSpec.BooleanValue shipGeneralCameraZoomEnable;
        public static ForgeConfigSpec.BooleanValue shipGeneralCameraAutoThirdPerson;
        public static ForgeConfigSpec.DoubleValue shipGeneralCameraZoomMax;
        public static ForgeConfigSpec.DoubleValue shipGeneralCameraZoomMin;
        public static ForgeConfigSpec.ConfigValue<Integer> shipModSpeedUnit;
    }


    private static void setupCommonConfig(ForgeConfigSpec.Builder builder) {
        ArrayList<String> MOUNT_BLACKLIST = new ArrayList<>(
                Arrays.asList("minecraft:ender_dragon", "minecraft:wither", "minecraft:wither", "minecraft:ghast", "minecraft:warden", "minecraft:ravager", "alexmobs:cachalot_whale"));

        builder.comment(" This holds the schematic version for internal purposes. DO NOT TOUCH!");
        Common.schematicVersion = builder.define("schematicVersion", COMMON_SCHEMATIC_VERSION);

        builder.comment(" This category holds configs that define ship behaviour.");
        builder.push("Ship");

        builder.comment("This category holds configs that define general ship behaviour.");
        builder.push("General");

        builder.comment("The cool-down for sails when increasing or decreasing sail state.");
        Common.shipGeneralSailCooldown = builder
                .defineInRange("shipGeneralSailCooldown", 30, 0, 1000);

        builder.comment("The damage that is delivered to entities on collision with a cruising ship. Set 0 to disable feature.");
        Common.shipGeneralCollisionDamage = builder
                .defineInRange("shipGeneralCollisionDamage", 7.5D, 0.0D, 100.0D);

        builder.comment("Should entities be pushed on collision with a cruising ship?");
        Common.shipGeneralCollisionKnockBack = builder
                .define("shipGeneralCollisionKnockBack", true);

        builder.comment("Should the ship item be dropped when the ship is fully damaged?");
        Common.shipGeneralDoItemDrop = builder
                .define("shipGeneralDoItemDrop", true);

        builder.comment("General speed modifiers for ships.");
        builder.push("Modifier");

        builder.comment("Maximum speed penalty for a filled container in percent.");
        Common.shipGeneralContainerModifier = builder
                .defineInRange("shipGeneralContainerModifier", 10.0D, -500.0D, 500.0D);

        builder.comment("Speed penalty per cannon in percent.");
        Common.shipGeneralCannonModifier = builder
                .defineInRange("shipGeneralCannonModifier", 2.5D, -500.0D, 500.0D);

        builder.comment("Speed bonus for a paddle ship while paddling in percent.");
        Common.shipGeneralPaddlingModifier = builder
                .defineInRange("shipGeneralPaddlingModifier", 35.0D, -500.0D, 500.0D);

        builder.comment("Maximum speed bonus and penalty depending on the ship biome type in percent.");
        Common.shipGeneralBiomeModifier = builder
                .defineInRange("shipGeneralBiomeModifier", 20.0D, 0.0D, 500.0D);

        builder.comment("Damage reduction per shield in percent.");
        Common.shipGeneralShieldDamageReduction = builder
                .defineInRange("shipGeneralShieldDamageReduction", 3.0D, -500.0D, 500.0D);

        builder.comment("Time in minutes in which sunken ships will despawn.");
        Common.shipGeneralDespawnTimeSunken = builder
                .defineInRange("shipGeneralDespawnTimeSunken", 15.0D, 0.0D, 600.0D);

        builder.comment("Entities in this list won't be able to mount a ship, for example: [\"minecraft:creeper\", \"minecraft:sheep\", ...]");
        Common.mountBlackList = builder
                .define("mountBlackList", MOUNT_BLACKLIST);

        builder.comment("Amount of damage a cannonball does on hit.");
        Common.shipGeneralCannonDamage = builder
                .defineInRange("shipGeneralCannonDamage", 25.0D, 0.0D, 100.0D);

        builder.comment("Amount of destruction a cannonball does when hit the ground.");
        Common.shipGeneralCannonDestruction = builder
                .defineInRange("shipGeneralCannonDestruction", 1.0D, 0.0D, 100.0D);

        builder.pop();

        builder.comment("This category holds configs that define behaviour of fleeing water animals.");
        builder.push("Fleeing Water Animals");

        Common.waterAnimalFleeRadius = builder
                .defineInRange("waterAnimalFleeRadius", 15.0D, 0.0D, 100.0D);
        Common.waterAnimalFleeSpeed = builder
                .defineInRange("waterAnimalFleeSpeed", 1.5D, 0.0D, 100.0D);
        Common.waterAnimalFleeDistance = builder
                .defineInRange("waterAnimalFleeDistance", 10.0D, 0.0D, 100.0D);

        builder.pop();

        builder.pop();

        builder.push("Cog");

        builder.comment("Default attributes for the Cog. Speed in km/h, Health in default mc health points");
        builder.push("Attributes");

        Common.shipAttributeCogMaxHealth = builder
                .defineInRange("shipAttributeCogMaxHealth", 300.0D, 1.0D, 10000.0D);
        Common.shipAttributeCogMaxSpeed = builder
                .defineInRange("shipAttributeCogMaxSpeed", 30.0D, 0.0D, 100.0D);
        Common.shipAttributeCogMaxReverseSpeed = builder
                .defineInRange("shipAttributeCogMaxReverseSpeed", 0.1D, 0.0D, 100.0D);
        Common.shipAttributeCogMaxRotationSpeed = builder
                .defineInRange("shipAttributeCogMaxRotationSpeed", 4.5D, 0.0D, 100.0D);
        Common.shipAttributeCogAcceleration = builder
                .defineInRange("shipAttributeCogAcceleration", 0.015D, 0.0D, 100.0D);
        Common.shipAttributeCogRotationAcceleration = builder
                .defineInRange("shipAttributeCogRotationAcceleration", 0.7D, 0.0D, 100.0D);

        builder.pop();

        builder.comment("Default configs for the container of the Cog.");
        builder.push("Container");

        builder.comment("Set container size for the Cog (value must be divisible by 9 and bigger than 0).");
        Common.shipContainerCogContainerSize = builder
                .define("shipContainerCogContainerSize", 108, e -> e instanceof Integer i && i % 9 == 0 && i > 0);

        builder.pop();

        builder.comment("Cog specific speed modifiers.");
        builder.push("Modifier");

        builder.comment("Specify biome type for the Cog. Can be NONE, COLD, NEUTRAL, or WARM");
        Common.shipModifierCogBiome = builder
                .defineEnum("shipModifierCogBiome", Ship.BiomeModifierType.COLD);

        builder.pop();

        builder.pop();


        builder.push("Brigg");

        builder.comment("Default attributes for the Brigg. Speed in km/h, Health in default mc health points");
        builder.push("Attributes");

        Common.shipAttributeBriggMaxHealth = builder
                .defineInRange("shipAttributeBriggMaxHealth", 450.0D, 0.0D, 10000.0D);
        Common.shipAttributeBriggMaxSpeed = builder
                .defineInRange("shipAttributeBriggMaxSpeed", 35.0D, 0.0D, 100.0D);
        Common.shipAttributeBriggMaxReverseSpeed = builder
                .defineInRange("shipAttributeBriggMaxReverseSpeed", 0.1D, 0.0D, 100.0D);
        Common.shipAttributeBriggMaxRotationSpeed = builder
                .defineInRange("shipAttributeBriggMaxRotationSpeed", 4.0D, 0.0D, 100.0D);
        Common.shipAttributeBriggAcceleration = builder
                .defineInRange("shipAttributeBriggAcceleration", 0.015D, 0.0D, 100.0D);
        Common.shipAttributeBriggRotationAcceleration = builder
                .defineInRange("shipAttributeBriggRotationAcceleration", 0.55D, 0.0D, 100.0D);

        builder.pop();

        builder.comment("Default configs for the container of the Brigg.");
        builder.push("Container");

        builder.comment("Set container size for the Brigg (value must be divisible by 9 and bigger than 0).");
        Common.shipContainerBriggContainerSize = builder
                .define("shipContainerBriggContainerSize", 162, e -> e instanceof Integer i && i % 9 == 0 && i > 0);

        builder.pop();

        builder.comment("Brigg specific speed modifiers.");
        builder.push("Modifier");

        builder.comment("Specify biome type for the Brigg. Can be NONE, COLD, NEUTRAL, or WARM");
        Common.shipModifierBriggBiome = builder
                .defineEnum("shipModifierBriggBiome", Ship.BiomeModifierType.COLD);

        builder.pop();

        builder.pop();


        builder.push("Galley");

        builder.comment("Default attributes for the Galley. Speed in km/h, Health in default mc health points");
        builder.push("Attributes");

        Common.shipAttributeGalleyMaxHealth = builder
                .defineInRange("shipAttributeGalleyMaxHealth", 200.0D, 0.0D, 10000.0D);
        Common.shipAttributeGalleyMaxSpeed = builder
                .defineInRange("shipAttributeGalleyMaxSpeed", 30.0D, 0.0D, 100.0D);
        Common.shipAttributeGalleyMaxReverseSpeed = builder
                .defineInRange("shipAttributeGalleyMaxReverseSpeed", 0.1D, 0.0D, 100.0D);
        Common.shipAttributeGalleyMaxRotationSpeed = builder
                .defineInRange("shipAttributeGalleyMaxRotationSpeed", 5.0D, 0.0D, 100.0D);
        Common.shipAttributeGalleyAcceleration = builder
                .defineInRange("shipAttributeGalleyAcceleration", 0.015D, 0.0D, 100.0D);
        Common.shipAttributeGalleyRotationAcceleration = builder
                .defineInRange("shipAttributeGalleyRotationAcceleration", 1.00D, 0.0D, 100.0D);

        builder.pop();


        builder.comment("Default configs for the container of the Galley.");
        builder.push("Container");

        builder.comment("Set container size for the Galley (value must be divisible by 9 and bigger than 0).");
        Common.shipContainerGalleyContainerSize = builder
                .define("shipContainerGalleyContainerSize", 54, e -> e instanceof Integer i && i % 9 == 0 && i > 0);

        builder.pop();

        builder.comment("Galley specific speed modifiers.");
        builder.push("Modifier");

        builder.comment("Specify biome type for the Galley. Can be NONE, COLD, NEUTRAL, or WARM");
        Common.shipModifierGalleyBiome = builder
                .defineEnum("shipModifierGalleyBiome", Ship.BiomeModifierType.WARM);

        builder.pop();
        builder.pop();

        builder.push("Drakkar");

        builder.comment("Default attributes for the Drakkar. Speed in km/h, Health in default mc health points");
        builder.push("Attributes");

        Common.shipAttributeDrakkarMaxHealth = builder
                .defineInRange("shipAttributeDrakkarMaxHealth", 200.0D, 0.0D, 10000.0D);
        Common.shipAttributeDrakkarMaxSpeed = builder
                .defineInRange("shipAttributeDrakkarMaxSpeed", 30.0D, 0.0D, 100.0D);
        Common.shipAttributeDrakkarMaxReverseSpeed = builder
                .defineInRange("shipAttributeDrakkarMaxReverseSpeed", 0.1D, 0.0D, 100.0D);
        Common.shipAttributeDrakkarMaxRotationSpeed = builder
                .defineInRange("shipAttributeDrakkarMaxRotationSpeed", 5.0D, 0.0D, 100.0D);
        Common.shipAttributeDrakkarAcceleration = builder
                .defineInRange("shipAttributeDrakkarAcceleration", 0.015D, 0.0D, 100.0D);
        Common.shipAttributeDrakkarRotationAcceleration = builder
                .defineInRange("shipAttributeDrakkarRotationAcceleration", 1.00D, 0.0D, 100.0D);

        builder.pop();


        builder.comment("Default configs for the container of the Drakkar.");
        builder.push("Container");

        builder.comment("Set container size for the Drakkar (value must be divisible by 9 and bigger than 0).");
        Common.shipContainerDrakkarContainerSize = builder
                .define("shipContainerDrakkarContainerSize", 54, e -> e instanceof Integer i && i % 9 == 0 && i > 0);

        builder.pop();

        builder.comment("Drakkar specific speed modifiers.");
        builder.push("Modifier");

        builder.comment("Specify biome type for the Drakkar. Can be NONE, COLD, NEUTRAL, or WARM");
        Common.shipModifierDrakkarBiome = builder
                .defineEnum("shipModifierDrakkarBiome", Ship.BiomeModifierType.COLD);

        builder.pop();
        builder.pop();

        builder.pop();
    }

    private static void setupClientConfig(ForgeConfigSpec.Builder builder) {
        builder.comment(" This holds the schematic version for internal purposes. DO NOT TOUCH!");
        Client.schematicVersion = builder.define("schematicVersion", CLIENT_SCHEMATIC_VERSION);

        builder.comment(" This category holds configs that define ship behaviour.");
        builder.push("Ship");

        builder.comment("Set the speed indication: 0 = km/h, 1 = m/s, 2 = knots, 3 = mph");
        Client.shipModSpeedUnit = builder
                .define("shipModSpeedUnit", 0);

        builder.comment("This category holds configs that define general ship behaviour.");
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

        builder.comment("Automatically enable third person camera when entering a ship.");
        Client.shipGeneralCameraAutoThirdPerson = builder
                .define("shipGeneralCameraAutoThirdPerson", true);

        builder.pop();

        builder.pop();

        builder.pop();

        builder.comment(" This category holds configs that define general mod settings.");
        builder.push("General");

        builder.comment("Enable smallships creative tab in the creative inventory (only takes effect after restart).");
        Common.smallshipsItemGroupEnable = builder
                .define("smallshipsItemGroupEnable", false);

        builder.pop();
    }

    public static void updateConfig(ModConfig config) {
        int oldSchematicVersion = getSchematicVersion(config);
        boolean hasBeenUpdated = switch (config.getType()) {
            case COMMON -> updateConfig(config, commonSchematicUpdater);
            case CLIENT -> updateConfig(config, clientSchematicUpdater);
            case SERVER -> false;
        };
        int newSchematicVersion = getSchematicVersion(config);
        if (hasBeenUpdated) SmallShipsMod.LOGGER.warn("Updated config values of " + config.getFileName() + " from schematic version " + oldSchematicVersion + " to " + newSchematicVersion + "!");
    }

    private static final List<Consumer<ModConfig>> commonSchematicUpdater = new ArrayList<>();
    static {
        commonSchematicUpdater.add(config -> {
            resetEntry(config, Common.shipGeneralContainerModifier);
            resetEntry(config, Common.shipGeneralPaddlingModifier);
            resetEntry(config, Common.shipAttributeBriggMaxSpeed);
            resetEntry(config, Common.shipAttributeBriggMaxRotationSpeed);
            resetEntry(config, Common.shipAttributeBriggRotationAcceleration);
            resetEntry(config, Common.shipAttributeGalleyMaxSpeed);
            resetEntry(config, Common.shipAttributeCogMaxSpeed);
            resetEntry(config, Common.shipAttributeCogMaxRotationSpeed);
            resetEntry(config, Common.shipAttributeCogRotationAcceleration);
        });
        // To make a config update add a new element like the above to the schematic Updater field (don't ever change the order!) and don't forget to increment the default schematicVersion the setup method
    }
    private static final List<Consumer<ModConfig>> clientSchematicUpdater = new ArrayList<>();
    private static boolean updateConfig(ModConfig config, List<Consumer<ModConfig>> schematicUpdater) {
        if (getSchematicVersion(config) < schematicUpdater.size() + 1) {
            for (int i = getSchematicVersion(config) - 1; i < schematicUpdater.size(); i++) {
                int j = 0;
                while (true) {
                    try {
                        String[] fileNameExtensionPair = config.getFileName().split("\\.");
                        String backupFileName = fileNameExtensionPair[0] + "-sv" + (i + 1) + (j == 0 ? "" : "-" + j) + "." + fileNameExtensionPair[1] + ".bak";
                        Files.copy(config.getFullPath(), config.getFullPath().resolveSibling(backupFileName));
                        SmallShipsMod.LOGGER.info("Backed up previous config version: " + backupFileName);
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
            config.save();
            return true;
        }
        return false;
    }

    private static int getSchematicVersion(ModConfig config) {
        return config.getConfigData().getInt("schematicVersion");
    }
    private static void setSchematicVersion(ModConfig config, int i) {
        config.getConfigData().set("schematicVersion", i);
    }

    private static <T> void resetEntry(ModConfig config, ForgeConfigSpec.ConfigValue<T> value) {
        config.getConfigData().set(value.getPath(), value.getDefault());
    }
}