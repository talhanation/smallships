package com.talhanation.smallships.forge.client;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.client.ClientInitializer;
import com.talhanation.smallships.client.model.*;
import com.talhanation.smallships.client.model.projectile.CannonBallModel;
import com.talhanation.smallships.client.model.projectile.ChainShotModel;
import com.talhanation.smallships.client.model.projectile.GrapeShotModel;
import com.talhanation.smallships.client.option.ModGameOptions;
import com.talhanation.smallships.client.renderer.entity.*;
import com.talhanation.smallships.world.entity.ModEntityTypes;
import com.talhanation.smallships.world.particles.forge.ModParticleProvidersImpl;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.core.particles.ParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import oshi.util.tuples.Pair;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = SmallShipsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModBus {
    @SubscribeEvent
    static void init(FMLClientSetupEvent event) {
        ClientInitializer.init();
    }

    @SubscribeEvent
    static void initRegisterRendererRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntityTypes.CANNON_BALL, CannonBallRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.CHAIN_SHOT, ChainShotRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.GRAPE_SHOT, GrapeShotRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.GROUND_CANNON, GroundCannonRenderer::new);

        event.registerEntityRenderer(ModEntityTypes.COG, CogRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.BRIGG, BriggRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.GALLEY, GalleyRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.DRAKKAR, DrakkarRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.DHOW, DhowRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.GALLEON, GalleonRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.CARAVEL, CaravelRenderer::new);
    }

    @SubscribeEvent
    static void initRegisterRendererLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(CannonBallModel.LAYER_LOCATION, CannonBallModel::createBodyLayer);
        event.registerLayerDefinition(ChainShotModel.LAYER_LOCATION, ChainShotModel::createBodyLayer);
        event.registerLayerDefinition(GrapeShotModel.LAYER_LOCATION, GrapeShotModel::createBodyLayer);
        event.registerLayerDefinition(CannonModel.LAYER_LOCATION, CannonModel::createBodyLayer);

        event.registerLayerDefinition(CogModel.LAYER_LOCATION, CogModel::createBodyLayer);
        event.registerLayerDefinition(BriggModel.LAYER_LOCATION, BriggModel::createBodyLayer);
        event.registerLayerDefinition(GalleyModel.LAYER_LOCATION, GalleyModel::createBodyLayer);
        event.registerLayerDefinition(DrakkarModel.LAYER_LOCATION, DrakkarModel::createBodyLayer);
        event.registerLayerDefinition(DhowModel.LAYER_LOCATION, DhowModel::createBodyLayer);
        event.registerLayerDefinition(CaravelModel.LAYER_LOCATION, CaravelModel::createBodyLayer);
        event.registerLayerDefinition(GalleonModel.LAYER_LOCATION, GalleonModel::createBodyLayer);
    }

    @SubscribeEvent
    static void initRegisterKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(ModGameOptions.SAIL_KEY);
        event.register(ModGameOptions.ENTER_CANNON_BARREL_KEY);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @SubscribeEvent
    public static void registerParticleProviders(RegisterParticleProvidersEvent event) {
        for (Pair<ParticleType<?>, Object> particleProvider : ModParticleProvidersImpl.PARTICLE_PROVIDERS) {
            if (particleProvider.getB() instanceof ParticleProvider) {
                event.registerSpecial(particleProvider.getA(), (ParticleProvider) particleProvider.getB());
            } else {
                event.registerSpriteSet(particleProvider.getA(), (ParticleEngine.SpriteParticleRegistration) particleProvider.getB());
            }
        }
    }
}