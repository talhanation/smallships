package com.talhanation.smallships.client.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.talhanation.smallships.Main;
import com.talhanation.smallships.entities.AbstractShipDamage;
import com.talhanation.smallships.inventory.AdvancedShipContainer;
import com.talhanation.smallships.inventory.BasicShipContainer;
import de.maxhenkel.corelib.inventory.ScreenBase;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class AdvancedShipInvScreen extends ScreenBase<AdvancedShipContainer> {

    private static final ResourceLocation GUI_TEXTURE = new ResourceLocation("textures/gui/container/generic_54.png");

    private final AbstractShipDamage ship;
    private final PlayerInventory playerInventory;

    public AdvancedShipInvScreen(AdvancedShipContainer container, PlayerInventory playerInventory, ITextComponent title) {
        super(GUI_TEXTURE, container, playerInventory, title);
        this.ship = container.getShip();
        this.playerInventory = playerInventory;

        imageWidth = 176;
        imageHeight = 222;
    }

    @Override
    protected void init() {
        super.init();

        if (ship.hasBiggerInv()) {
            addButton(new Button(leftPos - 77, topPos + 74, 8, 12, new StringTextComponent("<"), button -> {
                minecraft.setScreen(new BasicShipInvScreen(new BasicShipContainer(0,this.ship, playerInventory), playerInventory, ship.getDisplayName()));
                ship.openGUI(inventory.player);
            }));
        }



    }


    @Override
    protected void renderLabels(MatrixStack matrixStack, int mouseX, int mouseY) {
        super.renderLabels(matrixStack, mouseX, mouseY);
        font.draw(matrixStack, ship.getDisplayName().getVisualOrderText(), 8, 6, FONT_COLOR);
        font.draw(matrixStack, playerInventory.getDisplayName().getVisualOrderText(), 8, imageHeight - 95, FONT_COLOR);
        font.draw(matrixStack,"Damage: " + (double) Math.round(ship.getShipDamage()) + "%", 95, 6, FONT_COLOR);
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