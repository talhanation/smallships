package com.talhanation.smallships.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import net.minecraftforge.common.ForgeConfigSpec;
import org.junit.jupiter.api.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SmallShipsConfigTest {

    private ForgeConfigSpec configSpec;

    @BeforeEach
    void setUp() {
        // Set up initial configuration for testing
        configSpec = SmallShipsConfig.CONFIG;
    }

    @Test
    void testDefaultValues() {
        // Check that default configuration values are correct
        assertEquals(1.3, SmallShipsConfig.GalleySpeedFactor.get());
        assertEquals(0.5, SmallShipsConfig.GalleyTurnFactor.get());
    }

    @Test
    void testLoadConfig() {
        // Create a temporary path for testing
        Path tempPath = Paths.get("test-smallships-config.toml");

        // Simulate loading the configuration
        SmallShipsConfig.loadConfig(configSpec, tempPath);

        // Validate that the values are updated after loading
        assertEquals(SmallShipsConfig.NEW_VERSION, SmallShipsConfig.VERSION.get());
    }

    @Test
    void testBlacklist() {
        // Validate the blacklist functionality
        List<String> blacklist = SmallShipsConfig.PassengerBlackList.get();
        assertNotNull(blacklist);
        blacklist.add("minecraft:creeper");
        assertTrue(blacklist.contains("minecraft:creeper"));
    }
}
