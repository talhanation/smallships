package com.talhanation.smallships.client.gui.screens.inventory;

import com.mojang.blaze3d.systems.RenderSystem;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.math.Kalkuel;
import com.talhanation.smallships.world.entity.cannon.GroundCannonEntity;
import com.talhanation.smallships.world.inventory.GroundCannonContainerMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;

import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;

public class GroundCannonContainerScreen extends AbstractContainerScreen<GroundCannonContainerMenu> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID,"textures/gui/cannon_inventory.png" );
    public static final int FONT_COLOR = 4210752;
    private final GroundCannonEntity groundCannonEntity;
    private final int offset = 40;
    private int origLeftPos;
    private int origTopPos;

    public GroundCannonContainerScreen(GroundCannonContainerMenu cannonContainerMenu, Inventory playerInventory, Component component) {
        super(cannonContainerMenu, playerInventory, component);
        this.imageHeight = 114;
        this.imageWidth = 256;
        this.inventoryLabelY = this.imageHeight - 94;
        this.groundCannonEntity = cannonContainerMenu.getEntity();
    }

    @Override
    public void renderBg(GuiGraphics guiGraphics, float f, int i, int j){
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1F, 1F, 1F, 1F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        guiGraphics.blit(TEXTURE, leftPos, topPos, 0, 0, imageWidth, imageHeight);
    }

    @Override
    protected void init() {
        this.origLeftPos = this.leftPos;
        this.origTopPos = this.topPos;
        this.leftPos = offset + (this.width - this.imageWidth) / 2;
        this.topPos = (this.height - this.imageHeight) / 2;

        if (this.minecraft == null || this.minecraft.player == null) {
            SmallShipsMod.LOGGER.error("Minecraft client or LocalPlayer is null?! Couldn't render page buttons.");
        }

    }
    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int i, int j) {
        super.renderLabels(guiGraphics, i, j);
        String name = this.groundCannonEntity.getDisplayName().getString();

        String smallShipTypeRaw = this.groundCannonEntity.getType().getDescription().getString();
        String smallShipType = smallShipTypeRaw.substring(0,1).toUpperCase() + smallShipTypeRaw.substring(1);

        int currentPassengers = this.groundCannonEntity.getPassengers().size();
        int maxPassengers = 2;

        int dmg = (int) (this.groundCannonEntity.getHealth() / this.groundCannonEntity.getMaxHealth());

        String unit;
        int maxSpeed;
        int currentSpeed;
        switch (SmallShipsConfig.Client.shipModSpeedUnit.get()){
            default -> {
                unit = "km/h";
                maxSpeed = (Mth.ceil(Kalkuel.getKilometerPerHour(this.groundCannonEntity.maxSpeedInKmH)));
                currentSpeed = (Mth.ceil(Kalkuel.getKilometerPerHour(this.groundCannonEntity.getSpeed())));
            }
            case 1 -> {
                unit = "m/s";
                maxSpeed = (Mth.ceil(Kalkuel.getMeterPerSecond(this.groundCannonEntity.maxSpeedInKmH)));
                currentSpeed = (Mth.ceil(Kalkuel.getMeterPerSecond(this.groundCannonEntity.getSpeed())));
            }
            case 2 -> {
                unit = "knots";
                maxSpeed = (Mth.ceil(Kalkuel.getKnots(this.groundCannonEntity.maxSpeedInKmH)));
                currentSpeed = (Mth.ceil(Kalkuel.getKnots(this.groundCannonEntity.getSpeed())));
            }
            case 3 -> {
                unit = "mph";
                maxSpeed = (Mth.ceil(Kalkuel.getMilesPerHour(this.groundCannonEntity.maxSpeedInKmH)));
                currentSpeed = (Mth.ceil(Kalkuel.getMilesPerHour(this.groundCannonEntity.getSpeed())));
            }
        }

        int leftPos = 130;
        int leftPos2 = 193;
        int topPos = 18;
        int gap = 14;
        guiGraphics.pose().pushPose();
        guiGraphics.pose().scale(0.7F, 0.7F, 1F);


        guiGraphics.drawString(font, "Name:", leftPos, topPos + gap * 0, FONT_COLOR, false);
        guiGraphics.drawString(font, "Type:", leftPos, topPos + gap * 1, FONT_COLOR, false);
        guiGraphics.drawString(font, "Crew:", leftPos, topPos + gap * 2, FONT_COLOR, false);
        guiGraphics.drawString(font, "Speed " + unit + ":", leftPos, topPos + gap * 3, FONT_COLOR, false);
        guiGraphics.drawString(font, "Damage:", leftPos, topPos + gap * 4, FONT_COLOR, false);


        guiGraphics.drawString(font, name, leftPos2, topPos + gap * 0, FONT_COLOR, false);
        guiGraphics.drawString(font, smallShipType, leftPos2, topPos + gap * 1, FONT_COLOR, false);
        guiGraphics.drawString(font, currentPassengers + "/" + maxPassengers, leftPos2, topPos + gap * 2, FONT_COLOR, false);
        guiGraphics.drawString(font, currentSpeed + "/" + maxSpeed, leftPos2, topPos + gap * 3, FONT_COLOR, false);
        guiGraphics.drawString(font, dmg + "%", leftPos2, topPos + gap * 4, FONT_COLOR, false);



        guiGraphics.pose().popPose();
    }
}
