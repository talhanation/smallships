package com.talhanation.smallships.client.option;

import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

public class ModGameOptions {
    public static final String keyMappingCategory = "category.smallships";

    public static final KeyMapping SAIL_KEY = new KeyMapping("key.smallships.ship_sail", GLFW.GLFW_KEY_R, keyMappingCategory);
    public static final KeyMapping ENTER_CANNON_BARREL_KEY = new KeyMapping("key.smallships.cannon_barrel_enter", GLFW.GLFW_KEY_F, keyMappingCategory);
    /** Hold to aim the ship broadside cannons with the mouse (Better Cannon Gameplay). */
    public static final KeyMapping CANNON_AIM_KEY = new KeyMapping("key.smallships.cannon_aim", GLFW.GLFW_KEY_LEFT_ALT, keyMappingCategory);
    /** Raise the ground cannon barrel (key-only ground cannon aiming). */
    public static final KeyMapping CANNON_BARREL_UP_KEY = new KeyMapping("key.smallships.cannon_barrel_up", GLFW.GLFW_KEY_UP, keyMappingCategory);
    /** Lower the ground cannon barrel (key-only ground cannon aiming). */
    public static final KeyMapping CANNON_BARREL_DOWN_KEY = new KeyMapping("key.smallships.cannon_barrel_down", GLFW.GLFW_KEY_DOWN, keyMappingCategory);
}
