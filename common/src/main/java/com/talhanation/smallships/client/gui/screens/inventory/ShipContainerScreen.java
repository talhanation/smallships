package com.talhanation.smallships.client.gui.screens.inventory;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.math.Kalkuel;
import com.talhanation.smallships.world.entity.ship.ContainerShip;
import com.talhanation.smallships.world.entity.ship.abilities.Cannonable;
import com.talhanation.smallships.world.inventory.ShipContainerMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;

public class ShipContainerScreen extends AbstractContainerScreen<ShipContainerMenu> {
    private static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation(SmallShipsMod.MOD_ID,"textures/gui/ship_inventory.png" );
    public static final int FONT_COLOR = 4210752;
    private final int rowCount;
    private final int pageCount;
    private final int pageIndex;
    private final ContainerShip containerShip;

    public ShipContainerScreen(ShipContainerMenu shipContainerMenu, Inventory inventory, Component component) {
        super(shipContainerMenu, inventory, component);
        this.imageHeight = 114 + this.getMenu().getRowCount() * 18;
        this.imageWidth = 256;
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
        int k = (this.width - this.imageWidth) / 2;
        int l = (this.height - this.imageHeight) / 2;
        guiGraphics.blit(RESOURCE_LOCATION, k, l, 0, 0, this.imageWidth, this.rowCount * 18 + 17);
        guiGraphics.blit(RESOURCE_LOCATION, k, l + this.rowCount * 18 + 17, 0, 126, this.imageWidth, 96);
    }

    @Override
    protected void init() {
        super.init();
        this.leftPos = (this.width - this.imageWidth) / 2;
        this.topPos = (this.height - this.imageHeight) / 2;

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
        guiGraphics.drawString(font, (Mth.ceil(dmg) + "%"), 152 - (Mth.floor(Math.log10(Mth.ceil(dmg)))) * 6, 6, FONT_COLOR, false);

        float maxSpeed = (Mth.ceil(Kalkuel.getKilometerPerHour(this.containerShip.maxSpeed)));
        float currentSpeed = (Mth.ceil(Kalkuel.getKilometerPerHour(this.containerShip.getSpeed())));
        guiGraphics.drawString(font, currentSpeed + "/" + maxSpeed + " km/h", 50, 6, FONT_COLOR, false);

        if (this.pageCount > 1) guiGraphics.drawString(font, (this.pageIndex + 1) + "/"  + this.pageCount, 150 - (Mth.floor(Math.log10(this.pageCount))) * 6, this.rowCount*18+19, FONT_COLOR, false);

        Button backward = this.addRenderableWidget(new Button( leftPos + 115, topPos + 125, 12, 12, Component.literal("<"),
                button -> this.getMenu().clickMenuButton(this.minecraft.player, -1)));
        backward.active = this.pageCount > 1 && this.pageIndex + 1 > 1;


        Button forward = this.addRenderableWidget(new Button(leftPos + 157, topPos + 125, 12, 12, Component.literal(">"),
                button -> this.getMenu().clickMenuButton(this.minecraft.player, 1)));
        forward.active = this.pageCount > 1 && this.pageIndex + 1 < this.pageCount;
    }

    @Override
    protected void renderLabels(@NotNull PoseStack poseStack, int i, int j) {
        super.renderLabels(poseStack, i, j);
        String name = this.containerShip.getDisplayName().getString();

        String smallShipTypeRaw = this.containerShip.getType().getDescription().getString();
        String smallShipType = smallShipTypeRaw.substring(0,1).toUpperCase() + smallShipTypeRaw.substring(1);

        int currentPassengers = this.containerShip.getPassengers().size();
        int maxPassengers = this.containerShip.getMaxPassengers();

        int maxCannons = this.containerShip instanceof Cannonable cannonable ? cannonable.getMaxCannonPerSide() * 2 : 0;
        int currentCannons = this.containerShip instanceof Cannonable cannonable ? cannonable.getCannonCount() : 0;

        int dmg = (int) (this.containerShip.getDamage() * 100 / this.containerShip.getAttributes().maxHealth);

        String unit;
        int maxSpeed;
        int currentSpeed;
        switch (SmallShipsConfig.Client.shipModSpeedUnit.get()){
            default -> {
                unit = "km/h";
                maxSpeed = (Mth.ceil(Kalkuel.getKilometerPerHour(this.containerShip.maxSpeed)));
                currentSpeed = (Mth.ceil(Kalkuel.getKilometerPerHour(this.containerShip.getSpeed())));
            }
            case 1 -> {
                unit = "m/s";
                maxSpeed = (Mth.ceil(Kalkuel.getMeterPerSecond(this.containerShip.maxSpeed)));
                currentSpeed = (Mth.ceil(Kalkuel.getMeterPerSecond(this.containerShip.getSpeed())));
            }
            case 2 -> {
                unit = "knots";
                maxSpeed = (Mth.ceil(Kalkuel.getKnots(this.containerShip.maxSpeed)));
                currentSpeed = (Mth.ceil(Kalkuel.getKnots(this.containerShip.getSpeed())));
            }
            case 3 -> {
                unit = "mph";
                maxSpeed = (Mth.ceil(Kalkuel.getMilesPerHour(this.containerShip.maxSpeed)));
                currentSpeed = (Mth.ceil(Kalkuel.getMilesPerHour(this.containerShip.getSpeed())));
            }
        }

        int leftPos = 260;
        int leftPos2 = 330;
        int topPos = 38;
        int gap = 14;
        poseStack.pushPose();
        poseStack.scale(0.7F, 0.7F, 1F);


        font.draw(poseStack, "Name:", leftPos, topPos + gap * 0, FONT_COLOR);
        font.draw(poseStack, "Type:", leftPos, topPos + gap * 1, FONT_COLOR);
        font.draw(poseStack, "Passengers:", leftPos, topPos + gap * 2, FONT_COLOR);
        font.draw(poseStack, "Speed " + unit + ":", leftPos, topPos + gap * 3, FONT_COLOR);
        font.draw(poseStack, "Damage:", leftPos, topPos + gap * 4, FONT_COLOR);
        font.draw(poseStack, "Cannons:", leftPos, topPos + gap * 5, FONT_COLOR);

        font.draw(poseStack, name, leftPos2, topPos + gap * 0, FONT_COLOR);
        font.draw(poseStack, smallShipType, leftPos2, topPos + gap * 1, FONT_COLOR);
        font.draw(poseStack, currentPassengers + "/" + maxPassengers, leftPos2, topPos + gap * 2, FONT_COLOR);
        font.draw(poseStack, currentSpeed + "/" + maxSpeed, leftPos2, topPos + gap * 3, FONT_COLOR);
        font.draw(poseStack, dmg + "%", leftPos2, topPos + gap * 4, FONT_COLOR);
        font.draw(poseStack, currentCannons + "/" + maxCannons, leftPos2, topPos + gap * 5, FONT_COLOR);

        poseStack.popPose();

        if (this.pageCount > 1) font.draw(poseStack, (this.pageIndex + 1) + "/"  + this.pageCount, 133 - (float)(Mth.floor(Math.log10(this.pageCount))) * 6, this.rowCount*18+19, FONT_COLOR);

    }
}
