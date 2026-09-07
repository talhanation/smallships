package com.talhanation.smallships.neoforge.client;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.client.ClientInitializer;
import com.talhanation.smallships.client.model.*;
import com.talhanation.smallships.client.model.block.DockyardBlockModel;
import com.talhanation.smallships.client.model.projectile.CannonBallModel;
import com.talhanation.smallships.client.model.projectile.ChainShotModel;
import com.talhanation.smallships.client.model.projectile.GrapeShotModel;
import com.talhanation.smallships.client.option.ModGameOptions;
import com.talhanation.smallships.client.renderer.block.DockyardBlockRenderer;
import com.talhanation.smallships.client.renderer.entity.*;
import com.talhanation.smallships.client.renderer.item.DockyardItemRenderer;
import com.talhanation.smallships.world.block.ModBlockEntityTypes;
import com.talhanation.smallships.world.entity.ModEntityTypes;
import com.talhanation.smallships.world.item.ModItems;
import com.talhanation.smallships.world.particles.ModParticleProviders;
import com.talhanation.smallships.world.particles.neoforge.ModParticleProvidersImpl;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.particles.ParticleType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import oshi.util.tuples.Pair;

@SuppressWarnings("unused")
@EventBusSubscriber(modid = SmallShipsMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModBus {
    @SubscribeEvent
    static void init(FMLClientSetupEvent event) {
        ClientInitializer.init();
    }

    @SubscribeEvent
    static void initRegisterRendererRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntityTypes.DOCKYARD, DockyardBlockRenderer::new);

        event.registerEntityRenderer(ModEntityTypes.SHIP_PART, ShipPartRenderer::new);

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
        event.registerLayerDefinition(DockyardBlockModel.LAYER_LOCATION, DockyardBlockModel::createBodyLayer);

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

    // neoforge dropped Item#initializeClient, the dockyard item renderer is
    // handed over here instead
    @SubscribeEvent
    static void initRegisterClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerItem(new IClientItemExtensions() {
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return DockyardItemRenderer.getInstance();
            }
        }, ModItems.DOCKYARD);
    }

    @SubscribeEvent
    static void initRegisterKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(ModGameOptions.SAIL_KEY);
        event.register(ModGameOptions.ENTER_CANNON_BARREL_KEY);
    }

    @SuppressWarnings({"rawtypes", "unchecked", "InstantiationOfUtilityClass"})
    @SubscribeEvent
    public static void registerParticleProviders(RegisterParticleProvidersEvent event) {
        // ModParticleProvidersImpl does not extend ModParticleProviders on neoforge,
        // so the common class has to be loaded by hand - without this the list
        // below stays empty, every particle type keeps its null provider and
        // ParticleEngine#createParticle silently returns null
        new ModParticleProviders();

        for (Pair<ParticleType<?>, Object> particleProvider : ModParticleProvidersImpl.PARTICLE_PROVIDERS) {
            if (particleProvider.getB() instanceof ParticleProvider) {
                event.registerSpecial(particleProvider.getA(), (ParticleProvider) particleProvider.getB());
            } else {
                event.registerSpriteSet(particleProvider.getA(), (ParticleEngine.SpriteParticleRegistration) particleProvider.getB());
            }
        }
    }
}