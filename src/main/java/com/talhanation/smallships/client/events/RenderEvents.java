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
            evt.getCamera().move(-evt.getCamera().getMaxZoom(SmallShipsConfig.ShipZoom.get() - 4D), 0D, 0D);
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
}
