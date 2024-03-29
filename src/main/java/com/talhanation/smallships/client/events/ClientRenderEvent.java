package com.talhanation.smallships.client.events;

import com.talhanation.smallships.Main;
import com.talhanation.smallships.client.model.ModelCannon;
import com.talhanation.smallships.client.model.ModelCannonBall;
import com.talhanation.smallships.client.model.ModelCog;
import com.talhanation.smallships.client.render.RenderCannonBall;
import com.talhanation.smallships.client.render.RenderEntityBrigg;
import com.talhanation.smallships.client.render.RenderEntityCog;
import com.talhanation.smallships.init.ModEntityTypes;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD , value = Dist.CLIENT)
public class ClientRenderEvent {
    public static EntityRendererProvider.Context context;
    public static void register() {
        EntityRenderers.register(ModEntityTypes.COG.get(), ctx -> {
            context = ctx; // Its strange, but I couldn't find any other way to access the EntityRendererProvider.Context. See: net.minecraft.client.renderer.entity.EntityRenderDispatcher.onResourceManagerReload
            return new RenderEntityCog(ctx);
        });

        EntityRenderers.register(ModEntityTypes.BRIGG.get(), ctx -> {
            context = ctx; // Its strange, but I couldn't find any other way to access the EntityRendererProvider.Context. See: net.minecraft.client.renderer.entity.EntityRenderDispatcher.onResourceManagerReload
            return new RenderEntityBrigg(ctx);
        });
        EntityRenderers.register(ModEntityTypes.CANNON_BALL.get(), RenderCannonBall::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModelCog.LAYER_LOCATION, ModelCog::createBodyLayer);
        event.registerLayerDefinition(ModelCannon.LAYER_LOCATION, ModelCannon::createBodyLayer);
        event.registerLayerDefinition(ModelCannonBall.LAYER_LOCATION, ModelCannonBall::createBodyLayer);
    }
}