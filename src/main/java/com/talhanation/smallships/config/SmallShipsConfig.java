package com.talhanation.smallships.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class SmallShipsConfig {


    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec CONFIG;
    public static final ForgeConfigSpec.IntValue VERSION;
    public static final int NEW_VERSION = 10;

    public static final ForgeConfigSpec.BooleanValue PlaySwimSound;
    public static final ForgeConfigSpec.BooleanValue WaterMobFlee;

    public static final ForgeConfigSpec.DoubleValue GalleySpeedFactor;
    public static final ForgeConfigSpec.DoubleValue GalleyTurnFactor;
    public static final ForgeConfigSpec.DoubleValue WarGalleySpeedFactor;
    public static final ForgeConfigSpec.DoubleValue WarGalleyTurnFactor;
    public static final ForgeConfigSpec.DoubleValue CogSpeedFactor;
    public static final ForgeConfigSpec.DoubleValue CogTurnFactor;
    public static final ForgeConfigSpec.DoubleValue DrakkarSpeedFactor;
    public static final ForgeConfigSpec.DoubleValue DrakkarTurnFactor;
    public static final ForgeConfigSpec.DoubleValue DrakkarIceBreakSpeed;
    public static final ForgeConfigSpec.DoubleValue RowBoatSpeedFactor;
    public static final ForgeConfigSpec.DoubleValue RowBoatTurnFactor;
    public static final ForgeConfigSpec.DoubleValue BriggSpeedFactor;
    public static final ForgeConfigSpec.DoubleValue BriggTurnFactor;
    public static final ForgeConfigSpec.DoubleValue DhowSpeedFactor;
    public static final ForgeConfigSpec.DoubleValue DhowTurnFactor;
    public static final ForgeConfigSpec.DoubleValue ShipZoom;
    public static final ForgeConfigSpec.BooleanValue EnterThirdPerson;
    public static final ForgeConfigSpec.BooleanValue MakeWaveAnimation;
    public static final ForgeConfigSpec.DoubleValue BriggHealth;
    public static final ForgeConfigSpec.DoubleValue CogHealth;
    public static final ForgeConfigSpec.DoubleValue DrakkarHealth;
    public static final ForgeConfigSpec.DoubleValue GalleyHealth;
    public static final ForgeConfigSpec.DoubleValue RowBoatHealth;
    public static final ForgeConfigSpec.DoubleValue WarGalleyHealth;
    public static final ForgeConfigSpec.DoubleValue DhowHealth;



    public static final ForgeConfigSpec.ConfigValue<List<String>> PassengerBlackList;

    static {
        VERSION = BUILDER.comment("\n" +"##Version, do not change!##")
                .defineInRange("Version", 0, 0, Integer.MAX_VALUE);

        BUILDER.comment("Small Ships Config:").push("Ships");

        GalleySpeedFactor = BUILDER.comment("""

                        ----Galley Speed Factor.----
                        \t(takes effect after restart)
                        \tdefault: 1.3""")
                .worldRestart()
                .defineInRange("GalleySpeedFactor", 1.3, 0.0, 2.0);

        GalleyTurnFactor = BUILDER.comment("""

                        ----Galley Turn Factor.----
                        \t(takes effect after restart)
                        \tdefault: 0.5""")
                .worldRestart()
                .defineInRange("GalleyTurnFactor", 0.5, 0.0, 1.0);

        CogSpeedFactor = BUILDER.comment("""

                        ----Cog Speed Factor.----
                        \t(takes effect after restart)
                        \tdefault: 1.25""")
                .worldRestart()
                .defineInRange("CogSpeedFactor", 1.25, 0.0, 2.0);

        CogTurnFactor = BUILDER.comment("""

                        ----Cog Turn Factor.----
                        \t(takes effect after restart)
                        \tdefault: 0.1""")
                .worldRestart()
                .defineInRange("CogTurnFactor", 0.1, 0.0, 1.0);

        WarGalleySpeedFactor = BUILDER.comment("""

                        ----War Galley Speed Factor.----
                        \t(takes effect after restart)
                        \tdefault: 1.15""")
                .worldRestart()
                .defineInRange("WarGalleySpeedFactor", 1.15, 0.0, 2.0);

        WarGalleyTurnFactor = BUILDER.comment("""

                        ----War Galley Turn Factor.----
                        \t(takes effect after restart)
                        \tdefault: 0.4""")
                .worldRestart()
                .defineInRange("WarGalleyTurnFactor", 0.4, 0.0, 1.0);

        DrakkarSpeedFactor = BUILDER.comment("""

                        ----Drakkar Speed Factor.----
                        \t(takes effect after restart)
                        \tdefault: 1.25""")
                .worldRestart()
                .defineInRange("DrakkarSpeedFactor", 1.25, 0.0, 2.0);

        DrakkarTurnFactor = BUILDER.comment("""

                        ----Drakkar Turn Factor.----
                        \t(takes effect after restart)
                        \tdefault: 0.3""")
                .worldRestart()
                .defineInRange("DrakkarTurnFactor", 0.3, 0.0, 1.0);

        DrakkarIceBreakSpeed = BUILDER.comment("""

                        ----Drakkar Ice Break Speed.----
                        \t(takes effect after restart)
                        \thigher values = slower break speed
                        \tdefault: 2.0""")
                .worldRestart()
                .defineInRange("DrakkarIceBreakSpeed", 2.0, 0.0, 100);

        RowBoatSpeedFactor = BUILDER.comment("""

                        ----Row Boat Speed Factor.----
                        \t(takes effect after restart)
                        \tdefault: 1.0""")
                .worldRestart()
                .defineInRange("RowBoatSpeedFactor", 1.0, 0.0, 2.0);

        RowBoatTurnFactor = BUILDER.comment("""

                        ----Row Boat Turn Factor.----
                        \t(takes effect after restart)
                        \tdefault: 0.8""")
                .worldRestart()
                .defineInRange("RowBoatTurnFactor", 0.8, 0.0, 1.0);

        BriggSpeedFactor = BUILDER.comment("""

                        ----Brigg Speed Factor.----
                        \t(takes effect after restart)
                        \tdefault: 1.28""")
                .worldRestart()
                .defineInRange("BriggSpeedFactor", 1.28, 0.0, 2.0);

        BriggTurnFactor = BUILDER.comment("""

                        ----Brigg Turn Factor.----
                        \t(takes effect after restart)
                        \tdefault: 0.2""")
                .worldRestart()
                .defineInRange("BriggTurnFactor", 0.2, 0.0, 1.0);

        DhowSpeedFactor = BUILDER.comment("""

                        ----Dhow Speed Factor.----
                        \t(takes effect after restart)
                        \tdefault: 1.35""")
                .worldRestart()
                .defineInRange("DhowSpeedFactor", 1.35, 0.0, 2.0);

        DhowTurnFactor = BUILDER.comment("""

                        ----Dhow Turn Factor.----
                        \t(takes effect after restart)
                        \tdefault: 0.3""")
                .worldRestart()
                .defineInRange("DhowTurnFactor", 0.3, 0.0, 1.0);

        PlaySwimSound = BUILDER.comment("""

                        ----Should Ships Make Swimming sounds?----
                        \t(takes effect after restart)
                        \tdefault: true""")
                .define("PlaySwimSound", true);

        WaterMobFlee = BUILDER.comment("""

                        ----Should Ships Make WaterMobs flee?----
                        \t(takes effect after restart)
                        \tdefault: true""")
                .define("WaterMobFlee", true);

        ShipZoom = BUILDER.comment("""

                        ----Ship Zoom.----
                        \t(takes effect after restart)
                        \tdefault: 0.2""")
                .worldRestart()
                .defineInRange("ShipZoom", 6D, 1D, 20D);

        EnterThirdPerson = BUILDER.comment("""

                        ----Should the player enter ships in third person?----
                        \t(takes effect after restart)
                        \tdefault: true""")
                .worldRestart()
                .define("EnterThirdPerson", true);

        MakeWaveAnimation = BUILDER.comment("""

                        ----Should the Ships make waving animation?----
                        \t(takes effect after restart)
                        \tdefault: true""")
                .worldRestart()
                .define("MakeWaveAnimation", true);

        BriggHealth = BUILDER.comment("""

                        ----Brigg Health.----
                        \t(takes effect after restart)
                        \t(vanilla boat value = 60)
                        \tdefault: 600""")
                .worldRestart()
                .defineInRange("BriggHealth", 600.0, 0.0, 10000.0);

        CogHealth = BUILDER.comment("""

                        ----Cog Health.----
                        \t(takes effect after restart)
                        \t(vanilla boat value = 60)
                        \tdefault: 300.0""")
                .worldRestart()
                .defineInRange("CogHealth", 300.0, 0.0, 10000.0);

        DrakkarHealth = BUILDER.comment("""

                        ----Drakkar Health.----
                        \t(takes effect after restart)
                        \t(vanilla boat value = 60)
                        \tdefault: 360""")
                .worldRestart()
                .defineInRange("DrakkarHealth", 360.0, 0.0, 10000.0);

        GalleyHealth = BUILDER.comment("""

                        ----Galley Health.----
                        \t(takes effect after restart)
                        \t(vanilla boat value = 60)
                        \tdefault: 600""")
                .worldRestart()
                .defineInRange("GalleyHealth", 600.0, 0.0, 10000.0);

        RowBoatHealth = BUILDER.comment("""

                        ----Row Boat Health.----
                        \t(takes effect after restart)
                        \t(vanilla boat value = 60)
                        \tdefault: 100""")
                .worldRestart()
                .defineInRange("RowBoatHealth", 100.0, 0.0, 10000.0);

        WarGalleyHealth = BUILDER.comment("""

                        ----War Galley Health.----
                        \t(takes effect after restart)
                        \t(vanilla boat value = 60)
                        \tdefault: 600""")
                .worldRestart()
                .defineInRange("WarGalleyHealth", 600.0, 0.0, 10000.0);

        DhowHealth = BUILDER.comment("""

                        ----Dhow Health.----
                        \t(takes effect after restart)
                        \t(vanilla boat value = 60)
                        \tdefault: 400""")
                .worldRestart()
                .defineInRange("DhowHealth", 400.0, 0.0, 10000.0);

        PassengerBlackList = BUILDER.comment("""

                        ----Passenger Blacklist----
                        \t(takes effect after restart)
                        \tEntities in this list won't be able to get on the boat, for example: ["minecraft:creeper", "minecraft:sheep"]""")
                .worldRestart()
                .define("Passenger BlackList", new ArrayList<>());

        CONFIG = BUILDER.build();
    }
    // do we need this?
    public static void loadConfig(ForgeConfigSpec spec, Path path) {
        CommentedFileConfig configData = CommentedFileConfig.builder(path)
                .sync()
                .autosave()
                .writingMode(WritingMode.REPLACE)
                .build();
        configData.load();
        spec.setConfig(configData);
        if (VERSION.get() != NEW_VERSION) {
            configData = CommentedFileConfig.builder(path)
                    .sync()
                    .autosave()
                    .writingMode(WritingMode.REPLACE)
                    .build();
            spec.setConfig(configData);
            VERSION.set(NEW_VERSION);
            configData.save();
        }
    }
}
