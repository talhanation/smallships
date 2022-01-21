package com.talhanation.smallships;

import com.talhanation.smallships.blocks.ModBlocks;
import com.talhanation.smallships.client.events.KeyEvents;
import com.talhanation.smallships.client.events.PlayerEvents;
import com.talhanation.smallships.client.events.RenderEvents;
import com.talhanation.smallships.client.render.obj.ModelCannonBall;
import com.talhanation.smallships.client.render.obj.ModelCog;
import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.entities.CogEntity;
import com.talhanation.smallships.entities.projectile.CannonBallEntity;
import com.talhanation.smallships.init.ModEntityTypes;
import com.talhanation.smallships.init.SoundInit;
import com.talhanation.smallships.items.ModItems;
import de.maxhenkel.corelib.CommonRegistry;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

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
    public static EntityType<CogEntity> COG_ENTITY;
    public static EntityType<CannonBallEntity> CANNON_BALL;


    public Main() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, SmallShipsConfig.CONFIG);
        SmallShipsConfig.loadConfig(SmallShipsConfig.CONFIG, FMLPaths.CONFIGDIR.get().resolve("smallships-common.toml"));

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(EntityType.class, this::registerEntities);
        SoundInit.SOUNDS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModEntityTypes.ENTITY_TYPES.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> FMLJavaModLoadingContext.get().getModEventBus().addListener(Main.this::clientSetup));
    }

    private void setup(final FMLCommonSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        SIMPLE_CHANNEL = NetworkRegistry.newSimpleChannel(new ResourceLocation("smallships", "default"), () -> "1.0.0", s -> true, s -> true);

        SIMPLE_CHANNEL.registerMessage(0, MessagePaddleState.class, MessagePaddleState::toBytes,
                buf -> (new MessagePaddleState()).fromBytes(buf),
                (msg, fun) -> msg.executeServerSide(fun.get()));

        SIMPLE_CHANNEL.registerMessage(1, MessageSailState.class, MessageSailState::toBytes,
                buf -> (new MessageSailState()).fromBytes(buf),
                (msg, fun) -> msg.executeServerSide(fun.get()));

        SIMPLE_CHANNEL.registerMessage(2, MessageSteerState.class, MessageSteerState::toBytes,
                buf -> (new MessageSteerState()).fromBytes(buf),
                (msg, fun) -> msg.executeServerSide(fun.get()));

        SIMPLE_CHANNEL.registerMessage(3, MessageOpenInv.class, MessageOpenInv::toBytes,
                buf -> (new MessageOpenInv()).fromBytes(buf),
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
    }


    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void clientSetup(FMLClientSetupEvent event) {

        RenderingRegistry.registerEntityRenderingHandler(COG_ENTITY, ModelCog::new);
        RenderingRegistry.registerEntityRenderingHandler(CANNON_BALL, ModelCannonBall::new);

        MinecraftForge.EVENT_BUS.register(new RenderEvents());
        MinecraftForge.EVENT_BUS.register(new PlayerEvents());
        MinecraftForge.EVENT_BUS.register(new KeyEvents());
        SAIL_KEY = ClientRegistry.registerKeyBinding("key.ship_sail", "category.smallships", 82);
        INV_KEY = ClientRegistry.registerKeyBinding("key.ship_inventory", "category.smallships", 73);
        SAIL_L_KEY = ClientRegistry.registerKeyBinding("key.lower_ship_sail", "category.smallships", 74);
        SAIL_H_KEY = ClientRegistry.registerKeyBinding("key.higher_ship_sail", "category.smallships", 75);
        LANTERN_KEY = ClientRegistry.registerKeyBinding("key.lantern_on/off", "category.smallships", 79);
        CANNON_KEY = ClientRegistry.registerKeyBinding("key.cannon_shoot", "category.smallships", 32);
    }



    @SubscribeEvent
    public void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
        COG_ENTITY = CommonRegistry.registerEntity(Main.MOD_ID, "cog", EntityClassification.MISC, CogEntity.class, builder -> {
            builder
                    .setTrackingRange(256)
                    .setUpdateInterval(1)
                    .setShouldReceiveVelocityUpdates(true)
                    .sized(3.5F, 1.25F)
                    .setCustomClientFactory(CogEntity::new);
        });
        event.getRegistry().register(COG_ENTITY);

        CANNON_BALL = CommonRegistry.registerEntity(Main.MOD_ID, "cannon_ball", EntityClassification.MISC, CannonBallEntity.class, builder -> {
            builder
                    .setTrackingRange(4)
                    .setUpdateInterval(10)
                    .setShouldReceiveVelocityUpdates(true)
                    .sized(0.25F, 0.25F)
                    .setCustomClientFactory(CannonBallEntity::new);
        });
        event.getRegistry().register(COG_ENTITY);
    }
}