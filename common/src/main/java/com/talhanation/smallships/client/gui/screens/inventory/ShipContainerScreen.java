package com.talhanation.smallships.client.gui.screens.inventory;

import com.mojang.blaze3d.systems.RenderSystem;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.math.Kalkuel;
import com.talhanation.smallships.world.entity.ship.ContainerShip;
import com.talhanation.smallships.world.inventory.ShipContainerMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;

public class ShipContainerScreen extends AbstractContainerScreen<ShipContainerMenu> {
    private static final ResourceLocation CONTAINER_BACKGROUND = new ResourceLocation("textures/gui/container/generic_54.png");
    public static final int FONT_COLOR = 4210752;
    private final int rowCount;
    private final int pageCount;
    private final int pageIndex;
    private final ContainerShip containerShip;

    public ShipContainerScreen(ShipContainerMenu shipContainerMenu, Inventory inventory, Component component) {
        super(shipContainerMenu, inventory, component);
        this.imageHeight = 114 + this.getMenu().getRowCount() * 18;
        this.inventoryLabelY = this.imageHeight - 94;
        this.containerShip = shipContainerMenu.getContainerShip();

        this.rowCount = this.getMenu().getRowCount();
        this.pageCount = this.getMenu().getPageCount();
        this.pageIndex = this.getMenu().getPageIndex();
    }

    @Override
    public void render(GuiGraphics guiGraphics, int i, int j, float f) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, i, j, f);
        this.renderTooltip(guiGraphics, i, j);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float f, int i, int j) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, CONTAINER_BACKGROUND);
        int k = (this.width - this.imageWidth) / 2;
        int l = (this.height - this.imageHeight) / 2;
        guiGraphics.blit(new ResourceLocation(SmallShipsMod.MOD_ID,"blit1"), k, l, 0, 0, this.imageWidth, this.rowCount * 18 + 17);
        guiGraphics.blit(new ResourceLocation(SmallShipsMod.MOD_ID,"blit2"), k, l + this.rowCount * 18 + 17, 0, 126, this.imageWidth, 96);
    }

    @Override
    protected void init() {
        super.init();
        int zeroLeftPos = leftPos + 160;
        int zeroTopPos = topPos + 15;

        if (this.minecraft == null || this.minecraft.player == null) {
            SmallShipsMod.LOGGER.error("Minecraft client or LocalPlayer is null?! Couldn't render page buttons.");
            return;
        }

        if (this.pageCount > 1 && this.pageIndex + 1 > 1){
            this.addRenderableWidget(
                    new Button.Builder(Component.literal("<-"), button -> this.getMenu().clickMenuButton(this.minecraft.player, -1))
                            .bounds(zeroLeftPos - 205, zeroTopPos, 40, 20)
                            .build());
        }

        if(this.pageCount > 1 && this.pageIndex + 1 < this.pageCount){
            this.addRenderableWidget(
                    new Button.Builder(Component.literal("->"), button -> this.getMenu().clickMenuButton(this.minecraft.player, 1))
                            .bounds(zeroLeftPos + 20, zeroTopPos, 40, 20)
                            .build());
        }
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int i, int j) {
        super.renderLabels(guiGraphics, i, j);
        float dmg = this.containerShip.getDamage() * 100 / this.containerShip.getAttributes().maxHealth;
        guiGraphics.drawString(font, (Mth.ceil(dmg) + "%"), 156 - (Mth.floor(Math.log10(Mth.ceil(dmg)))) * 6, 6, FONT_COLOR);

        float maxSpeed = (Mth.ceil(Kalkuel.getKilometerPerHour(this.containerShip.maxSpeed)));
        float currentSpeed = (Mth.ceil(Kalkuel.getKilometerPerHour(this.containerShip.getSpeed())));
        guiGraphics.drawString(font, currentSpeed + "/" + maxSpeed + " km/h", 50, 6, FONT_COLOR);

        if (this.pageCount > 1) guiGraphics.drawString(font, (this.pageIndex + 1) + "/"  + this.pageCount, 150 - (Mth.floor(Math.log10(this.pageCount))) * 6, this.rowCount*18+19, FONT_COLOR);
    }
}
