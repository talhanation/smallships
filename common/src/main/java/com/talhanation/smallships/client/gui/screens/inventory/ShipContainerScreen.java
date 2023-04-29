package com.talhanation.smallships.client.gui.screens.inventory;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.inventory.ShipContainerMenu;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

public class ShipContainerScreen extends AbstractContainerScreen<ShipContainerMenu> {
    private static final ResourceLocation CONTAINER_BACKGROUND = new ResourceLocation("textures/gui/container/generic_54.png");
    public static final int FONT_COLOR = 4210752;
    private final int rowCount;
    private final int pageCount;
    private final int pageIndex;
    private final Ship ship;

    public ShipContainerScreen(ShipContainerMenu shipContainerMenu, Inventory inventory, Component component) {
        super(shipContainerMenu, inventory, component);
        this.passEvents = false;
        this.imageHeight = 114 + this.getMenu().getRowCount() * 18;
        this.inventoryLabelY = this.imageHeight - 94;
        this.ship = shipContainerMenu.getShip();

        this.rowCount = this.getMenu().getRowCount();
        this.pageCount = this.getMenu().getPageCount();
        this.pageIndex = this.getMenu().getPageIndex();
    }

    @Override
    public void render(@NotNull PoseStack poseStack, int i, int j, float f) {
        this.renderBackground(poseStack);
        super.render(poseStack, i, j, f);
        this.renderTooltip(poseStack, i, j);
    }

    @Override
    protected void renderBg(@NotNull PoseStack poseStack, float f, int i, int j) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, CONTAINER_BACKGROUND);
        int k = (this.width - this.imageWidth) / 2;
        int l = (this.height - this.imageHeight) / 2;
        this.blit(poseStack, k, l, 0, 0, this.imageWidth, this.rowCount * 18 + 17);
        this.blit(poseStack, k, l + this.rowCount * 18 + 17, 0, 126, this.imageWidth, 96);
    }

    @SuppressWarnings({"CodeBlock2Expr", "ConstantConditions"})
    @Override
    protected void init() {
        super.init();
        int zeroLeftPos = leftPos + 160;
        int zeroTopPos = topPos + 15;

        if (this.pageCount > 1 && this.pageIndex + 1 > 1){
            this.addRenderableWidget(new Button(zeroLeftPos - 205, zeroTopPos, 40, 20, Component.literal("<-"), button -> {
                this.getMenu().clickMenuButton(this.minecraft.player, -1);
            }));
        }

        if(this.pageCount > 1 && this.pageIndex + 1 < this.pageCount){
            this.addRenderableWidget(new Button(zeroLeftPos + 20, zeroTopPos, 40, 20, Component.literal("->"), button -> {
                this.getMenu().clickMenuButton(this.minecraft.player, 1);
            }));
        }
    }

    @Override
    protected void renderLabels(@NotNull PoseStack poseStack, int i, int j) {
        super.renderLabels(poseStack, i, j);
        float dmg = ship.getDamage() * 100 / ship.getAttributes().maxHealth;
        font.draw(poseStack, (Mth.ceil(dmg) + "%"), 150, 6, FONT_COLOR);

        if (this.pageCount > 1) font.draw(poseStack, (this.pageIndex + 1) + "/"  + this.pageCount, 50, 6, FONT_COLOR);
    }
}
