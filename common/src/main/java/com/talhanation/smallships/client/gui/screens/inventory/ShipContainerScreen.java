package com.talhanation.smallships.client.gui.screens.inventory;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.math.Kalkuel;
import com.talhanation.smallships.world.entity.ship.ContainerShip;
import com.talhanation.smallships.world.entity.ship.ShipUpgrade;
import com.talhanation.smallships.world.entity.ship.abilities.Cannonable;
import com.talhanation.smallships.world.entity.ship.abilities.Shieldable;
import com.talhanation.smallships.world.entity.ship.sail.SailDamage;
import com.talhanation.smallships.world.inventory.ShipContainerMenu;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;

public class ShipContainerScreen extends AbstractContainerScreen<ShipContainerMenu> {
    private static final ResourceLocation RESOURCE_LOCATION = ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID,"textures/gui/ship_inventory.png" );
    public static final int FONT_COLOR = 4210752;
    /** centre of the gap between the two page buttons, in menu local coordinates */
    private static final int PAGE_LABEL_X = 142;
    private static final int PAGE_LABEL_Y = 127;
    private final int rowCount;
    private final int pageCount;
    private final int pageIndex;
    private final ContainerShip containerShip;
    private final int offset = 40;
    private int origLeftPos;
    private int origTopPos;

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
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTick);
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        this.renderUpgradePanel(guiGraphics, mouseX, mouseY);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float f, int i, int j) {
        int k = offset + (this.width - this.imageWidth) / 2;
        int l = (this.height - this.imageHeight) / 2;
        guiGraphics.blit(RESOURCE_LOCATION, k, l, 0, 0, this.imageWidth, this.rowCount * 18 + 17);
        guiGraphics.blit(RESOURCE_LOCATION, k, l + this.rowCount * 18 + 17, 0, 126, this.imageWidth, 96);
    }

    @Override
    protected void init() {
        this.origLeftPos = this.leftPos;
        this.origTopPos = this.topPos;
        this.leftPos = offset + (this.width - this.imageWidth) / 2;
        this.topPos = (this.height - this.imageHeight) / 2;

        if (this.minecraft == null || this.minecraft.player == null) {
            SmallShipsMod.LOGGER.error("Minecraft client or LocalPlayer is null?! Couldn't render page buttons.");
            return;
        }

        // render page forwards / backwards buttons
        Button backward = this.addRenderableWidget(new Button.Builder(Component.literal("<"),
                button -> this.getMenu().clickMenuButton(this.minecraft.player, -1))
                .pos(leftPos + 115, topPos + 125).size(12, 12)
                .build());

        backward.active = this.pageCount > 1 && this.pageIndex + 1 > 1;

        Button forward = this.addRenderableWidget(new Button.Builder(Component.literal(">"),
                button -> this.getMenu().clickMenuButton(this.minecraft.player, 1))
                .pos(leftPos + 157, topPos + 125)
                .size(12, 12)
                .build());
        forward.active = this.pageCount > 1 && this.pageIndex + 1 < this.pageCount;
    }

    /**
     * Upgrade panel right next to the ship info: one icon field per dockyard
     * upgrade. Installed upgrades show a green frame, missing ones are
     * darkened; the tooltip lists the name and the benefit.
     */
    private void renderUpgradePanel(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        ShipUpgrade[] upgrades = ShipUpgrade.values();
        int x = this.leftPos + this.imageWidth + 4;
        int y = this.topPos + 20;

        List<Component> tooltip = null;
        int shown = 0;
        for (ShipUpgrade upgrade : upgrades) {
            // only INSTALLED upgrades are shown
            if (!upgrade.isInstalled(this.containerShip)) continue;
            int boxY = y + shown * 24;
            shown++;

            guiGraphics.fill(x, boxY, x + 22, boxY + 22, 0xFF55B14C);
            guiGraphics.fill(x + 1, boxY + 1, x + 21, boxY + 21, 0xFF2B2B2B);
            guiGraphics.renderItem(upgrade.getCost(), x + 3, boxY + 3);

            if (mouseX >= x && mouseX < x + 22 && mouseY >= boxY && mouseY < boxY + 22) {
                tooltip = new ArrayList<>();
                tooltip.add(Component.translatable(upgrade.getTranslationKey()).withStyle(ChatFormatting.GOLD));
                tooltip.add(Component.translatable(upgrade.getDescriptionTranslationKey()).withStyle(ChatFormatting.GRAY));
            }
        }
        if (tooltip != null) {
            guiGraphics.renderComponentTooltip(this.font, tooltip, mouseX, mouseY);
        }
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int i, int j) {
        super.renderLabels(guiGraphics, i, j);
        String name = this.containerShip.getDisplayName().getString();

        String smallShipTypeRaw = this.containerShip.getType().getDescription().getString();
        String smallShipType = smallShipTypeRaw.substring(0,1).toUpperCase() + smallShipTypeRaw.substring(1);

        int currentPassengers = this.containerShip.getPassengers().size();
        int maxPassengers = this.containerShip.getMaxPassengers();

        int maxAttachment = 0;
        int currentAttachment = 0;
        if(this.containerShip instanceof Cannonable cannonable){
            maxAttachment =  cannonable.getMaxCannonPerSide() * 2;
            currentAttachment = cannonable.getCannonCount();
        }
        else if (this.containerShip instanceof Shieldable shieldable){
            maxAttachment =  shieldable.getMaxShieldsPerSide() * 2;
            currentAttachment = shieldable.getShields().size();
        }

        // The ship inventory is the quick glance: how beaten up is she, in one
        // number. The exact point counts belong in the dockyard, where the
        // player is about to pay for them.
        int hullDamagePercent = Mth.clamp(Mth.ceil(this.containerShip.getDamage() * 100.0F / this.containerShip.getAttributes().maxHealth), 0, 100);
        int sailDamagePercent = Mth.clamp(100 - Mth.floor(SailDamage.getHealth(this.containerShip) * 100.0F / SailDamage.MAX_HEALTH), 0, 100);

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
        int leftPos2 = 323;
        int topPos = 38;
        int gap = 14;
        guiGraphics.pose().pushPose();
        guiGraphics.pose().scale(0.7F, 0.7F, 1F);
        String attachment = this.containerShip instanceof Shieldable ? "Shields:" : "Cannons:";

        //guiGraphics.drawString(font, "Name:", leftPos, topPos + gap * 0, FONT_COLOR, false);
        guiGraphics.drawString(font, "Type:", leftPos, topPos + gap * 0, FONT_COLOR, false);
        guiGraphics.drawString(font, "Crew:", leftPos, topPos + gap * 1, FONT_COLOR, false);
        guiGraphics.drawString(font, "Speed " + unit + ":", leftPos, topPos + gap * 2, FONT_COLOR, false);
        guiGraphics.drawString(font, "Hull Dmg.:", leftPos, topPos + gap * 3, FONT_COLOR, false);
        guiGraphics.drawString(font, "Sail Dmg.:", leftPos, topPos + gap * 4, FONT_COLOR, false);
        guiGraphics.drawString(font, attachment, leftPos, topPos + gap * 5, FONT_COLOR, false);

        //guiGraphics.drawString(font, name, leftPos2, topPos + gap * 0, FONT_COLOR, false);
        guiGraphics.drawString(font, smallShipType, leftPos2, topPos + gap * 0, FONT_COLOR, false);
        guiGraphics.drawString(font, currentPassengers + "/" + maxPassengers, leftPos2, topPos + gap * 1, FONT_COLOR, false);
        guiGraphics.drawString(font, currentSpeed + "/" + maxSpeed, leftPos2, topPos + gap * 2, FONT_COLOR, false);
        guiGraphics.drawString(font, hullDamagePercent + "%", leftPos2, topPos + gap * 3, FONT_COLOR, false);
        guiGraphics.drawString(font, sailDamagePercent + "%", leftPos2, topPos + gap * 4, FONT_COLOR, false);
        guiGraphics.drawString(font, currentAttachment + "/" + maxAttachment, leftPos2, topPos + gap * 5, FONT_COLOR, false);

        guiGraphics.pose().popPose();

        // The page number belongs BETWEEN the two page buttons, and OUTSIDE the
        // 0.7 scale block above: it was drawn shrunken, and offset by
        // origLeftPos on top of that - a coordinate frame renderLabels is not
        // in. The buttons sit at local x 115..127 and 157..169, y 125..137.
        if (this.pageCount > 1) {
            String page = (this.pageIndex + 1) + "/" + this.pageCount;
            guiGraphics.drawString(font, page, PAGE_LABEL_X - font.width(page) / 2, PAGE_LABEL_Y, FONT_COLOR, false);
        }
    }
}