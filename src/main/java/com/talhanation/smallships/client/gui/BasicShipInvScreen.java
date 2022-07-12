package com.talhanation.smallships.client.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.talhanation.smallships.Main;
import com.talhanation.smallships.entities.AbstractInventoryEntity;
import com.talhanation.smallships.entities.AbstractShipDamage;
import com.talhanation.smallships.inventory.BasicShipContainer;
import com.talhanation.smallships.network.MessageOpenGui;
import com.talhanation.smallships.network.MessageOpenGuiSecond;
import de.maxhenkel.corelib.inventory.ScreenBase;
import net.minecraft.client.gui.screen.CommandBlockScreen;
import net.minecraft.client.gui.screen.inventory.CreativeScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextComponent;

public class BasicShipInvScreen extends ScreenBase<BasicShipContainer> {

    private static final ResourceLocation GUI_TEXTURE = new ResourceLocation("textures/gui/container/generic_54.png");

    private final BasicShipContainer container;
    private final AbstractInventoryEntity ship;
    private final PlayerInventory playerInventory;

    public BasicShipInvScreen(BasicShipContainer container, PlayerInventory playerInventory, ITextComponent title) {
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
        //HOME POS
        addButton(new Button(leftPos + 90, topPos + 60, 12, 12, new StringTextComponent("->"), button -> {
            //this works but you cant edit the container/ nothing will be saved...
            /*
            BasicShipContainer container = new BasicShipContainer(22222, ship,playerInventory, 54);
            BasicShipInvScreen screen = new BasicShipInvScreen(container, playerInventory, title);
            this.minecraft.setScreen(screen);
            */
            this.onClose();
            Main.LOGGER.debug("Screen send Message done");
            Main.SIMPLE_CHANNEL.sendToServer(new MessageOpenGuiSecond(playerInventory.player, ship));

        }));
    }


    @Override
    protected void renderLabels(MatrixStack matrixStack, int mouseX, int mouseY) {
        super.renderLabels(matrixStack, mouseX, mouseY);
        font.draw(matrixStack, ship.getDisplayName().getVisualOrderText(), 8, 6, FONT_COLOR);
        font.draw(matrixStack, playerInventory.getDisplayName().getVisualOrderText(), 8, imageHeight - 95, FONT_COLOR);
        font.draw(matrixStack,"Damage: " + (double) Math.round(((AbstractShipDamage) ship).getShipDamage()) + "%", 95, 6, FONT_COLOR);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    protected void renderBg(MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        super.renderBg(matrixStack, partialTicks, mouseX, mouseY);
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
    }
}