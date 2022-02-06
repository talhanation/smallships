package com.talhanation.smallships;

import com.talhanation.smallships.client.events.KeyEvents;
import com.talhanation.smallships.client.events.PlayerEvents;
import com.talhanation.smallships.client.events.RenderEvents;
import com.talhanation.smallships.client.gui.BasicShipInvScreen;
import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.entities.AbstractInventoryEntity;
import com.talhanation.smallships.entities.AbstractShipDamage;
import com.talhanation.smallships.init.ModEntityTypes;
import com.talhanation.smallships.init.ModItems;
import com.talhanation.smallships.init.SoundInit;
import com.talhanation.smallships.inventory.BasicShipContainer;
import com.talhanation.smallships.network.MessageControlShip;
import com.talhanation.smallships.network.MessageOpenGui;
import com.talhanation.smallships.network.MessageSailState;
import de.maxhenkel.corelib.ClientRegistry;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.network.IContainerFactory;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import org.lwjgl.glfw.GLFW;

import javax.annotation.Nullable;
import java.util.UUID;

@Mod("smallships")
public class Main {
    public static final String MOD_ID = "smallships";
    public static SimpleChannel SIMPLE_CHANNEL;
    public static KeyBinding SAIL_KEY;
    public static KeyBinding SAIL_L_KEY;
    public static KeyBinding SAIL_H_KEY;
    public static KeyBinding INV_KEY;
    public static KeyBinding LANTERN_KEY;
    public static KeyBinding CANNON_KEY;
    public static KeyBinding FORWARD_KEY;
    public static KeyBinding BACK_KEY;
    public static KeyBinding LEFT_KEY;
    public static KeyBinding RIGHT_KEY;

    public static ContainerType<BasicShipContainer> BASIC_SHIP_CONTAINER_TYPE;


    public Main() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, SmallShipsConfig.CONFIG);
        SmallShipsConfig.loadConfig(SmallShipsConfig.CONFIG, FMLPaths.CONFIGDIR.get().resolve("smallships-common.toml"));

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addGenericListener(ContainerType.class, this::registerContainers);
        SoundInit.SOUNDS.register(modEventBus);
        //ModBlocks.BLOCKS.register(modEventBus);
        ModEntityTypes.ENTITY_TYPES.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> FMLJavaModLoadingContext.get().getModEventBus().addListener(Main.this::clientSetup));
    }

    private void setup(final FMLCommonSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        SIMPLE_CHANNEL = NetworkRegistry.newSimpleChannel(new ResourceLocation("smallships", "default"), () -> "1.0.0", s -> true, s -> true);

        SIMPLE_CHANNEL.registerMessage(0, MessageControlShip.class, MessageControlShip::toBytes,
                buf -> (new MessageControlShip()).fromBytes(buf),
                (msg, fun) -> msg.executeServerSide(fun.get()));

        SIMPLE_CHANNEL.registerMessage(1, MessageOpenGui.class, MessageOpenGui::toBytes,
                buf -> (new MessageOpenGui()).fromBytes(buf),
                (msg, fun) -> msg.executeServerSide(fun.get()));

        SIMPLE_CHANNEL.registerMessage(2, MessageSailState.class, MessageSailState::toBytes,
                buf -> (new MessageSailState()).fromBytes(buf),
                (msg, fun) -> msg.executeServerSide(fun.get()));

        /*
        SIMPLE_CHANNEL.registerMessage(0, MessagePaddleState.class, MessagePaddleState::toBytes,
                buf -> (new MessagePaddleState()).fromBytes(buf),
                (msg, fun) -> msg.executeServerSide(fun.get()));

        SIMPLE_CHANNEL.registerMessage(2, MessageSteerState.class, MessageSteerState::toBytes,
                buf -> (new MessageSteerState()).fromBytes(buf),
                (msg, fun) -> msg.executeServerSide(fun.get()));

        SIMPLE_CHANNEL.registerMessage(4, MessageIsForward.class, MessageIsForward::toBytes,
                buf -> (new MessageIsForward()).fromBytes(buf),
                (msg, fun) -> msg.executeServerSide(fun.get()));

        SIMPLE_CHANNEL.registerMessage(5, MessageDismount.class, MessageDismount::toBytes,
                buf -> (new MessageDismount()).fromBytes(buf),
                (msg, fun) -> msg.executeServerSide(fun.get()));

        SIMPLE_CHANNEL.registerMessage(6, MessageLantern.class, MessageLantern::toBytes,
                buf -> (new MessageLantern()).fromBytes(buf),
                (msg, fun) -> msg.executeServerSide(fun.get()));

        SIMPLE_CHANNEL.registerMessage(7, MessageShootCannon.class, MessageShootCannon::toBytes,
                buf -> (new MessageShootCannon()).fromBytes(buf),
                (msg, fun) -> msg.executeServerSide(fun.get()));
        */
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
        LANTERN_KEY = ClientRegistry.registerKeyBinding("key.lantern_on/off", "category.smallships", GLFW.GLFW_KEY_L);
        CANNON_KEY = ClientRegistry.registerKeyBinding("key.cannon_shoot", "category.smallships", GLFW.GLFW_KEY_SPACE);

        ClientRegistry.registerScreen(Main.BASIC_SHIP_CONTAINER_TYPE, BasicShipInvScreen::new);

        MinecraftForge.EVENT_BUS.register(new RenderEvents());
        MinecraftForge.EVENT_BUS.register(new PlayerEvents());
        MinecraftForge.EVENT_BUS.register(new KeyEvents());
    }


    @SubscribeEvent
    public void registerContainers(RegistryEvent.Register<ContainerType<?>> event) {
        BASIC_SHIP_CONTAINER_TYPE = new ContainerType<>((IContainerFactory<BasicShipContainer>) (windowId, inv, data) -> {
            AbstractShipDamage ship = getInvEntityByUUID(inv.player, data.readUUID());
            if (ship == null) {
                return null;
            }
            return new BasicShipContainer(windowId, ship, inv);
        });

        BASIC_SHIP_CONTAINER_TYPE.setRegistryName(new ResourceLocation(Main.MOD_ID, "basic_container"));
        event.getRegistry().register(BASIC_SHIP_CONTAINER_TYPE);

    }

    @Nullable
    public static AbstractShipDamage getInvEntityByUUID(PlayerEntity player, UUID uuid) {
        double distance = 10D;
        return player.level.getEntitiesOfClass(AbstractShipDamage.class, new AxisAlignedBB(player.getX() - distance, player.getY() - distance, player.getZ() - distance, player.getX() + distance, player.getY() + distance, player.getZ() + distance), entity -> entity.getUUID().equals(uuid)).stream().findAny().orElse(null);
    }
}