package com.talhanation.smallships.client.gui.screens.inventory;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.math.Kalkuel;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.network.packet.ServerboundShipDetachPacket;
import com.talhanation.smallships.world.block.DockyardBlockEntity;
import com.talhanation.smallships.world.dockyard.DockyardAction;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.item.ModItems;
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
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

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

    /* ---------------- detach panel ---------------- */

    /** box size and pitch of the fittings panel left of the window */
    private static final int FITTING_BOX = 22;
    private static final int FITTING_PITCH = 24;
    /**
     * A galleon carries ten guns plus two banners. In one column that is
     * taller than the whole screen, so the panel grows in two.
     */
    private static final int FITTING_COLUMNS = 2;

    /** one removable fitting of the ship, rebuilt every frame */
    private record Fitting(DockyardAction.Kind kind, int index, ItemStack icon, Component name, int time) {
    }

    /**
     * The fitting the button went down on, null while nothing is held.
     *
     * Compared by kind and index only, never with equals: a Fitting carries an
     * ItemStack, and ItemStack has no value equality. The cannon icon is a new
     * stack on every frame, so record equality declared the held gun "gone"
     * one frame after it was grabbed and no cannon could ever be taken off.
     */
    @Nullable private Fitting held;
    /** when the hold started, in milliseconds */
    private long heldSince;

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
        this.renderFittingPanel(guiGraphics, mouseX, mouseY);
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
            // only INSTALLED upgrades that are still offered are shown
            if (!upgrade.isInstalled(this.containerShip)) continue;
            if (!upgrade.isAvailable(this.containerShip)) continue;
            int boxY = y + shown * 24;
            shown++;

            guiGraphics.fill(x, boxY, x + 22, boxY + 22, 0xFF55B14C);
            guiGraphics.fill(x + 1, boxY + 1, x + 21, boxY + 21, 0xFF2B2B2B);
            guiGraphics.renderItem(upgrade.getCostIcon(), x + 3, boxY + 3);

            if (mouseX >= x && mouseX < x + 22 && mouseY >= boxY && mouseY < boxY + 22) {
                tooltip = new ArrayList<>();
                tooltip.add(Component.translatable(upgrade.getTranslationKey()).withStyle(ChatFormatting.GOLD));
                tooltip.add(Component.translatable(upgrade.getDescriptionTranslationKey(),
                        upgrade.getEffectPercentText()).withStyle(ChatFormatting.GRAY));
            }
        }
        if (tooltip != null) {
            guiGraphics.renderComponentTooltip(this.font, tooltip, mouseX, mouseY);
        }
    }

    /**
     * Everything bolted onto the ship that can come back off: the mounted guns
     * and the two banners. They sit LEFT of the window, opposite the upgrade
     * column, because an upgrade is built into the hull and stays put while
     * these can be taken off right here.
     *
     * @return the fittings in the order they are drawn, guns first
     */
    private List<Fitting> getFittings() {
        List<Fitting> fittings = new ArrayList<>();
        if (this.containerShip instanceof Cannonable cannonable) {
            for (int slot = 0; slot < cannonable.getTotalCannonSlots(); slot++) {
                if (!cannonable.isCannonInSlot(slot)) continue;
                Cannonable.CannonPosition position = cannonable.getCannonPosition(slot);
                boolean starboard = position != null && position.isRightSided;
                Component name = Component.translatable("gui.smallships.dockyard.cannon_slot", slot + 1,
                        Component.translatable(starboard ? "gui.smallships.dockyard.starboard" : "gui.smallships.dockyard.port"));
                fittings.add(new Fitting(DockyardAction.Kind.CANNON, slot,
                        new ItemStack(ModItems.CANNON), name, DockyardBlockEntity.CANNON_TIME));
            }
        }
        ItemStack banner = this.containerShip.getData(Ship.BANNER);
        if (!banner.isEmpty()) {
            fittings.add(new Fitting(DockyardAction.Kind.BANNER, 0, banner,
                    Component.translatable("gui.smallships.dockyard.banner"), DockyardBlockEntity.STYLE_TIME));
        }
        ItemStack sailBanner = this.containerShip.getData(Ship.SAIL_BANNER);
        if (!sailBanner.isEmpty()) {
            fittings.add(new Fitting(DockyardAction.Kind.SAIL_BANNER, 0, sailBanner,
                    Component.translatable("gui.smallships.dockyard.sail_banner"), DockyardBlockEntity.STYLE_TIME));
        }
        return fittings;
    }

    private int fittingPanelX() {
        return this.leftPos - 4 - FITTING_COLUMNS * FITTING_PITCH;
    }

    private int fittingBoxX(int i) {
        return this.fittingPanelX() + (i % FITTING_COLUMNS) * FITTING_PITCH;
    }

    private int fittingBoxY(int i) {
        return this.topPos + 20 + (i / FITTING_COLUMNS) * FITTING_PITCH;
    }

    /** @return the fitting under the cursor, or null. */
    @Nullable
    private Fitting fittingAt(double mouseX, double mouseY) {
        List<Fitting> fittings = this.getFittings();
        for (int i = 0; i < fittings.size(); i++) {
            int x = this.fittingBoxX(i);
            int y = this.fittingBoxY(i);
            if (mouseX >= x && mouseX < x + FITTING_BOX && mouseY >= y && mouseY < y + FITTING_BOX) {
                return fittings.get(i);
            }
        }
        return null;
    }

    /** @return how far the current hold has come, 0 to 1. */
    private float heldProgress() {
        if (this.held == null) return 0.0F;
        long required = Math.max(1L, this.held.time() * 50L);
        return Mth.clamp((net.minecraft.Util.getMillis() - this.heldSince) / (float) required, 0.0F, 1.0F);
    }

    private boolean isHeld(@Nullable Fitting fitting) {
        return fitting != null && this.held != null
                && this.held.kind() == fitting.kind() && this.held.index() == fitting.index();
    }

    private void cancelHold() {
        this.held = null;
    }

    /** Sends the removal and stops the hold. */
    private void completeHold() {
        Fitting fitting = this.held;
        if (fitting == null) return;
        this.cancelHold();
        ModPackets.clientSendPacket(new ServerboundShipDetachPacket(
                this.containerShip.getId(), fitting.kind().ordinal(), fitting.index()));
        if (this.minecraft != null) {
            this.minecraft.getSoundManager().play(
                    net.minecraft.client.resources.sounds.SimpleSoundInstance.forUI(
                            net.minecraft.sounds.SoundEvents.ITEM_PICKUP, 1.0F));
        }
    }

    /**
     * The bar filling up is the action - the player does not have to let go for
     * it to happen, and holding on past the end does nothing more.
     */
    @Override
    protected void containerTick() {
        super.containerTick();
        if (this.held != null && this.heldProgress() >= 1.0F) this.completeHold();
    }

    private void renderFittingPanel(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        List<Fitting> fittings = this.getFittings();
        // the ship is on the stocks: the dockyard is working on it, nobody
        // pulls a gun off it in the meantime
        boolean locked = this.containerShip.isInDockyardWork();
        if (locked) this.cancelHold();

        // a fitting that vanished while it was held (somebody else took it)
        // must not keep counting down
        if (this.held != null) {
            boolean stillThere = false;
            for (Fitting fitting : fittings) {
                if (this.isHeld(fitting)) stillThere = true;
            }
            if (!stillThere) this.cancelHold();
        }

        List<Component> tooltip = null;
        for (int i = 0; i < fittings.size(); i++) {
            Fitting fitting = fittings.get(i);
            int x = this.fittingBoxX(i);
            int y = this.fittingBoxY(i);
            boolean hovering = mouseX >= x && mouseX < x + FITTING_BOX && mouseY >= y && mouseY < y + FITTING_BOX;
            boolean holding = this.isHeld(fitting);

            guiGraphics.fill(x, y, x + FITTING_BOX, y + FITTING_BOX, holding ? 0xFFD9453D : 0xFF6E6E78);
            guiGraphics.fill(x + 1, y + 1, x + FITTING_BOX - 1, y + FITTING_BOX - 1, 0xFF2B2B2B);
            guiGraphics.renderItem(fitting.icon(), x + 3, y + 3);

            if (holding) {
                // the bar runs along the bottom edge of the icon, so the icon
                // itself stays readable while it fills
                float progress = this.heldProgress();
                int barWidth = (int) ((FITTING_BOX - 4) * progress);
                guiGraphics.fill(x + 2, y + FITTING_BOX - 5, x + FITTING_BOX - 2, y + FITTING_BOX - 2, 0xFF15151A);
                if (barWidth > 0) {
                    guiGraphics.fill(x + 2, y + FITTING_BOX - 5, x + 2 + barWidth, y + FITTING_BOX - 2, 0xFF55B14C);
                }
            }

            if (hovering) {
                tooltip = new ArrayList<>();
                tooltip.add(fitting.name().copy().withStyle(ChatFormatting.GOLD));
                tooltip.add((locked
                        ? Component.translatable("gui.smallships.ship.detach_busy")
                        : Component.translatable("gui.smallships.ship.detach_hint", formatDuration(fitting.time())))
                        .withStyle(ChatFormatting.GRAY));
            }
        }
        if (tooltip != null) {
            guiGraphics.renderComponentTooltip(this.font, tooltip, mouseX, mouseY);
        }
    }

    /** Work time as the player reads a clock, same wording as the dockyard. */
    private static String formatDuration(int ticks) {
        int seconds = Math.max(1, Mth.ceil(ticks / 20.0F));
        if (seconds < 60) return seconds + "s";
        return seconds / 60 + ":" + String.format("%02d", seconds % 60) + " min";
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button == 0 && !this.containerShip.isInDockyardWork()) {
            Fitting fitting = this.fittingAt(mouseX, mouseY);
            if (fitting != null) {
                this.held = fitting;
                this.heldSince = net.minecraft.Util.getMillis();
                return true;
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    /**
     * Letting go before the bar is full aborts. The whole point of the hold is
     * that a slip of the mouse cannot cost a cannon.
     */
    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        if (button == 0) this.cancelHold();
        return super.mouseReleased(mouseX, mouseY, button);
    }

    /** Dragging the cursor off the box aborts the hold as well. */
    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
        if (this.held != null && !this.isHeld(this.fittingAt(mouseX, mouseY))) this.cancelHold();
        return super.mouseDragged(mouseX, mouseY, button, dragX, dragY);
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
        int sailDamagePercent = Mth.clamp(100 - Mth.floor(SailDamage.getHealth(this.containerShip) * 100.0F / SailDamage.getMaxHealth(this.containerShip)), 0, 100);

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