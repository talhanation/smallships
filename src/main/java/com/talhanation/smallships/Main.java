package com.talhanation.smallships;

import com.talhanation.smallships.client.events.ClientRenderEvent;
import com.talhanation.smallships.client.events.KeyEvents;
import com.talhanation.smallships.client.events.PlayerEvents;
import com.talhanation.smallships.client.events.RenderEvents;
import com.talhanation.smallships.client.gui.BasicShipInvScreen;
import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.entities.AbstractShipDamage;
import com.talhanation.smallships.init.ModEntityTypes;
import com.talhanation.smallships.init.ModItems;
import com.talhanation.smallships.init.SoundInit;
import com.talhanation.smallships.inventory.BasicShipContainer;
import com.talhanation.smallships.network.MessageControlShip;
import com.talhanation.smallships.network.MessageOpenGui;
import com.talhanation.smallships.network.MessageSailState;
import com.talhanation.smallships.network.MessageShootCannon;
import de.maxhenkel.corelib.ClientRegistry;
import de.maxhenkel.corelib.CommonRegistry;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.lwjgl.glfw.GLFW;

import javax.annotation.Nullable;
import java.util.UUID;

@Mod("smallships")
public class Main {
    public static final String MOD_ID = "smallships";
    public static SimpleChannel SIMPLE_CHANNEL;
    public static KeyMapping SAIL_KEY;
    public static KeyMapping SAIL_L_KEY;
    public static KeyMapping SAIL_H_KEY;
    public static KeyMapping INV_KEY;
    public static KeyMapping CANNON_KEY;
    public static KeyMapping FORWARD_KEY;
    public static KeyMapping BACK_KEY;
    public static KeyMapping LEFT_KEY;
    public static KeyMapping RIGHT_KEY;

    private static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, Main.MOD_ID);
    public static final RegistryObject<MenuType<BasicShipContainer>> BASIC_SHIP_CONTAINER_TYPE = MENU_TYPES.register("basic_ship_container_type", () -> IForgeMenuType.create(((windowId, inv, data) -> new BasicShipContainer(windowId, getInvEntityByUUID(inv.player, data.readUUID()), inv))));


    public Main() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, SmallShipsConfig.CONFIG);
        //SmallShipsConfig.loadConfig(SmallShipsConfig.CONFIG, FMLPaths.CONFIGDIR.get().resolve("smallships-common.toml"));

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        SoundInit.SOUNDS.register(modEventBus);
        //ModBlocks.BLOCKS.register(modEventBus);
        ModEntityTypes.ENTITY_TYPES.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        //ModItems.registerItems();
        MinecraftForge.EVENT_BUS.register(this);

        MENU_TYPES.register(modEventBus);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> FMLJavaModLoadingContext.get().getModEventBus().addListener(Main.this::clientSetup));
    }

    private void setup(final FMLCommonSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(this);

        SIMPLE_CHANNEL = NetworkRegistry.newSimpleChannel(new ResourceLocation("smallships", "default"), () -> "1.0.0", s -> true, s -> true);

        CommonRegistry.registerMessage(SIMPLE_CHANNEL, 0, MessageControlShip.class);
        CommonRegistry.registerMessage(SIMPLE_CHANNEL, 1, MessageOpenGui.class);
        CommonRegistry.registerMessage(SIMPLE_CHANNEL, 2, MessageSailState.class);
        CommonRegistry.registerMessage(SIMPLE_CHANNEL, 3, MessageShootCannon.class);
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void clientSetup(FMLClientSetupEvent event) {

        FORWARD_KEY = ClientRegistry.registerKeyBinding("key.ship_forward", "category.smallships", GLFW.GLFW_KEY_W);
        BACK_KEY = ClientRegistry.registerKeyBinding("key.ship_back", "category.smallships", GLFW.GLFW_KEY_S);
        LEFT_KEY = ClientRegistry.registerKeyBinding("key.ship_left", "category.smallships", GLFW.GLFW_KEY_A);
        RIGHT_KEY = ClientRegistry.registerKeyBinding("key.ship_right", "category.smallships", GLFW.GLFW_KEY_D);

        SAIL_KEY = ClientRegistry.registerKeyBinding("key.ship_sail", "category.smallships", GLFW.GLFW_KEY_R);
        INV_KEY = ClientRegistry.registerKeyBinding("key.ship_inventory", "category.smallships", GLFW.GLFW_KEY_I);
        SAIL_L_KEY = ClientRegistry.registerKeyBinding("key.lower_ship_sail", "category.smallships", GLFW.GLFW_KEY_J);
        SAIL_H_KEY = ClientRegistry.registerKeyBinding("key.higher_ship_sail", "category.smallships", GLFW.GLFW_KEY_K);
        CANNON_KEY = ClientRegistry.registerKeyBinding("key.cannon_shoot", "category.smallships", GLFW.GLFW_KEY_SPACE);

        ClientRegistry.registerScreen(Main.BASIC_SHIP_CONTAINER_TYPE.get(), BasicShipInvScreen::new);

        MinecraftForge.EVENT_BUS.register(new RenderEvents());
        MinecraftForge.EVENT_BUS.register(new PlayerEvents());
        MinecraftForge.EVENT_BUS.register(new KeyEvents());

        ClientRenderEvent.register();
    }

    @Nullable
    public static AbstractShipDamage getInvEntityByUUID(Player player, UUID uuid) {
        double distance = 10D;
        return player.level.getEntitiesOfClass(AbstractShipDamage.class, new AABB(player.getX() - distance, player.getY() - distance, player.getZ() - distance, player.getX() + distance, player.getY() + distance, player.getZ() + distance), entity -> entity.getUUID().equals(uuid)).stream().findAny().orElse(null);
    }
}