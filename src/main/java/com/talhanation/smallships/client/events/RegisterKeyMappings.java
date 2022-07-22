package com.talhanation.smallships.client.events;

import com.talhanation.smallships.Main;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RegisterKeyMappings {
    public static KeyMapping SAIL_KEY;
    public static KeyMapping SAIL_L_KEY;
    public static KeyMapping SAIL_H_KEY;
    public static KeyMapping INV_KEY;
    public static KeyMapping CANNON_KEY;
    public static KeyMapping FORWARD_KEY;
    public static KeyMapping BACKWARD_KEY;
    public static KeyMapping LEFT_KEY;
    public static KeyMapping RIGHT_KEY;

    @SubscribeEvent
    public static void keybindSetup(RegisterKeyMappingsEvent event) {
        System.out.println("registering Keyssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
        FORWARD_KEY = new KeyMapping("key.ship_forward", GLFW.GLFW_KEY_W, "category.smallships");
        BACKWARD_KEY = new KeyMapping("key.ship_backward", GLFW.GLFW_KEY_S, "category.smallships");
        LEFT_KEY = new KeyMapping("key.ship_left", GLFW.GLFW_KEY_A, "category.smallships");
        RIGHT_KEY = new KeyMapping("key.ship_right", GLFW.GLFW_KEY_D, "category.smallships");

        SAIL_KEY = new KeyMapping("key.ship_sail", GLFW.GLFW_KEY_R, "category.smallships");
        INV_KEY = new KeyMapping("key.ship_inventory", GLFW.GLFW_KEY_I, "category.smallships");
        SAIL_L_KEY = new KeyMapping("key.lower_ship_sail", GLFW.GLFW_KEY_J, "category.smallships");
        SAIL_H_KEY = new KeyMapping("key.higher_ship_sail", GLFW.GLFW_KEY_K, "category.smallships");
        CANNON_KEY = new KeyMapping("key.cannon_shoot", GLFW.GLFW_KEY_SPACE, "category.smallships");

        event.register(FORWARD_KEY);
        event.register(BACKWARD_KEY);
        event.register(LEFT_KEY);
        event.register(RIGHT_KEY);

        event.register(SAIL_KEY);
        event.register(INV_KEY);
        event.register(SAIL_L_KEY);
        event.register(SAIL_H_KEY);
        event.register(CANNON_KEY);
    }
}
