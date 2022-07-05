package com.talhanation.smallships.client.events;

import com.talhanation.smallships.Main;
import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.entities.AbstractSailShip;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;

@OnlyIn(Dist.CLIENT)
public class RenderEvents {

    private static final ResourceLocation SHIP_INFO_TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/gui/ship_info.png");
    private final Minecraft mc;
    private AbstractSailShip lastVehicle;

    public RenderEvents() {
        mc = Minecraft.getInstance();
    }

    @SubscribeEvent
    public void onRender(EntityViewRenderEvent.CameraSetup evt) {
        if (getShip() != null && !mc.options.getCameraType().isFirstPerson()) {
            evt.getInfo().move(-evt.getInfo().getMaxZoom(SmallShipsConfig.ShipZoom.get() - 4D), 0D, 0D);
        }
    }

    @SubscribeEvent
    public void onRender(InputEvent.MouseScrollEvent evt) {
        if (getShip() != null && !mc.options.getCameraType().isFirstPerson()) {
            SmallShipsConfig.ShipZoom.set(Math.max(1D, Math.min(20D, SmallShipsConfig.ShipZoom.get() - evt.getScrollDelta())));
            SmallShipsConfig.ShipZoom.save();
            evt.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent evt) {
        if (evt.side.equals(LogicalSide.SERVER)) {
            return;
        }

        if (!evt.player.equals(mc.player)) {
            return;
        }

        AbstractSailShip vehicle = getShip();

        if (vehicle != null && lastVehicle == null) {
            setThirdPerson(true);
        } else if (vehicle == null && lastVehicle != null) {
            setThirdPerson(false);
        }
        lastVehicle = vehicle;
    }

    private void setThirdPerson(boolean third) {
        if (!SmallShipsConfig.EnterThirdPerson.get()) {
            return;
        }

        if (third) {
            mc.options.setCameraType(CameraType.THIRD_PERSON_BACK);
        } else {
            mc.options.setCameraType(CameraType.FIRST_PERSON);
        }

    }

    private AbstractSailShip getShip() {
        Entity e = mc.player.getVehicle();
        if (e instanceof AbstractSailShip) {
            return (AbstractSailShip) e;
        }
        return null;
    }
/*
    //THIRDPERSON SCREEN
    public void renderShipInfo(MatrixStack matrixStack, AbstractShipDamage ship) {
        matrixStack.pushPose();

        mc.getTextureManager().bind(SHIP_INFO_TEXTURE);

        int texWidth = 110;
        int texHeight = 90;

        int height = mc.getWindow().getGuiScaledHeight();
        int width = mc.getWindow().getGuiScaledWidth();

        float scale = 1; // SmallShipsConfig.CONFIG.ShipInfoScale.get().floatValue();
        matrixStack.scale(scale, scale, 1F);
        matrixStack.translate(-width, -height, 0D);
        matrixStack.translate(((double) width) * (1D / scale), ((double) height * (1D / scale)), 0D);

        int padding = 3;
        int yStart = height - texHeight - padding;
        int xStart = width - texWidth - padding;

        mc.gui.blit(matrixStack, xStart, yStart, 0, 0, texWidth, texHeight);

        FontRenderer font = mc.gui.getFont();

        Function<Integer, Integer> heightFunc = integer -> yStart + 8 + (font.lineHeight + 2) * integer;

        //font.draw(matrixStack, new TranslationTextComponent("tooltip.ship.speed", SmallShipsConfig.shipInfoSpeedType.get().getTextComponent(ship.getDeltaMovement().length())).getVisualOrderText(), xStart + 7, heightFunc.apply(0), 0);
        font.draw(matrixStack, new TranslationTextComponent("tooltip.ship.sailstate", String.valueOf(Math.round(ship.getSailState() * 100F))).getVisualOrderText(), xStart + 7, heightFunc.apply(2), 0);
        //font.draw(matrixStack, new TranslationTextComponent("tooltip.ship.waterbiome", String.valueOf(Math.round(ship.getY()))).getVisualOrderText(), xStart + 7, heightFunc.apply(3), 0);
        //font.draw(matrixStack, new TranslationTextComponent("tooltip.ship.fuel", String.valueOf(ship.getFuel())).getVisualOrderText(), xStart + 7, heightFunc.apply(5), 0);
        font.draw(matrixStack, new TranslationTextComponent("tooltip.ship.damage", String.valueOf(MathUtils.round(ship.getShipDamage(), 2))).getVisualOrderText(), xStart + 7, heightFunc.apply(4), 0);

        matrixStack.popPose();
    }

 */
}
