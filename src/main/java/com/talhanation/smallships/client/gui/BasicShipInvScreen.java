package com.talhanation.smallships.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.talhanation.smallships.entities.AbstractShipDamage;
import com.talhanation.smallships.inventory.BasicShipContainer;
import de.maxhenkel.corelib.inventory.ScreenBase;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class BasicShipInvScreen extends ScreenBase<BasicShipContainer> {

    private static final ResourceLocation GUI_TEXTURE = new ResourceLocation("textures/gui/container/generic_54.png");

    private final AbstractShipDamage ship;
    private final Inventory playerInventory;

    public BasicShipInvScreen(BasicShipContainer container, Inventory playerInventory, Component title) {
        super(GUI_TEXTURE, container, playerInventory, title);
        this.ship = container.getShip();
        this.playerInventory = playerInventory;

        imageWidth = 176;
        imageHeight = 222;
    }

    @Override
    protected void renderLabels(PoseStack matrixStack, int mouseX, int mouseY) {
        super.renderLabels(matrixStack, mouseX, mouseY);
        font.draw(matrixStack, ship.getDisplayName().getVisualOrderText(), 8, 6, FONT_COLOR);
        font.draw(matrixStack, playerInventory.getDisplayName().getVisualOrderText(), 8, imageHeight - 95, FONT_COLOR);
        font.draw(matrixStack,"Damage: " + (double) Math.round(ship.getShipDamage()) + "%", 95, 6, FONT_COLOR);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    protected void renderBg(PoseStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        super.renderBg(matrixStack, partialTicks, mouseX, mouseY);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
    }
}