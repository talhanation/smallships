package com.talhanation.smallships.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.talhanation.smallships.Main;
import com.talhanation.smallships.entities.AbstractInventoryEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.talhanation.smallships.entities.AbstractShipDamage;
import com.talhanation.smallships.inventory.BasicShipContainer;
import com.talhanation.smallships.network.MessageOpenGui;
import de.maxhenkel.corelib.inventory.ScreenBase;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.client.gui.components.Button;

public class BasicShipInvScreen extends ScreenBase<BasicShipContainer> {

    private static final ResourceLocation GUI_TEXTURE = new ResourceLocation("textures/gui/container/generic_54.png");

    private final BasicShipContainer container;
    private final AbstractInventoryEntity ship;
    private final Inventory playerInventory;

    public BasicShipInvScreen(BasicShipContainer container, Inventory playerInventory, Component title) {
        super(GUI_TEXTURE, container, playerInventory, title);
        this.ship = container.getShip();
        this.playerInventory = playerInventory;
        this.container = container;
        imageWidth = 176;
        imageHeight = 222;
    }


    @Override
    protected void init() {
        super.init();
        int zeroLeftPos = leftPos + 160;
        int zeroTopPos = topPos + 15;

        if (ship.getMaxInvPage() > 1 && ship.getInvPage() > 1){
            addRenderableWidget(new Button(zeroLeftPos - 205, zeroTopPos, 40, 20, Component.literal("<-"), button -> {

                Main.SIMPLE_CHANNEL.sendToServer(new MessageOpenGui(playerInventory.player, ship, 0));
                ship.setInvPage(ship.getInvPage() - 1);
            }));
        }

        if(ship.getMaxInvPage() > 1 && ship.getInvPage() < ship.getMaxInvPage()){
            addRenderableWidget(new Button(zeroLeftPos + 20, zeroTopPos, 40, 20, Component.literal("->"), button -> {

                    ship.setInvPage(ship.getInvPage() + 1);
                    Main.SIMPLE_CHANNEL.sendToServer(new MessageOpenGui(playerInventory.player, ship, 54));
            }));
        }
    }


    @Override
    protected void renderLabels(PoseStack matrixStack, int mouseX, int mouseY) {
        super.renderLabels(matrixStack, mouseX, mouseY);
        boolean renderInvPage = ship.getMaxInvPage() != 1;
        font.draw(matrixStack, ship.getDisplayName().getVisualOrderText(), 8, 6, FONT_COLOR);
        font.draw(matrixStack, playerInventory.getDisplayName().getVisualOrderText(), 8, imageHeight - 95, FONT_COLOR);
        if (renderInvPage)font.draw(matrixStack,ship.getInvPage() + "/"  + ship.getMaxInvPage(), 50, 6, FONT_COLOR);
        font.draw(matrixStack,"Damage: " + (double) Math.round(((AbstractShipDamage) ship).getShipDamage()) + "%", 95, 6, FONT_COLOR);
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