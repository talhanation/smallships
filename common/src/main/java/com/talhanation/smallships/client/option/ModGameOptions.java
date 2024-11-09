package com.talhanation.smallships.client.option;

import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

public class ModGameOptions {
    public static final String keyMappingCategory = "category.smallships";

    public static final KeyMapping SAIL_KEY = new KeyMapping("key.smallships.ship_sail", GLFW.GLFW_KEY_R, keyMappingCategory);
    public static final KeyMapping ENTER_CANNON_BARREL_KEY = new KeyMapping("key.smallships.cannon_barrel_enter", GLFW.GLFW_KEY_F, keyMappingCategory);
}
