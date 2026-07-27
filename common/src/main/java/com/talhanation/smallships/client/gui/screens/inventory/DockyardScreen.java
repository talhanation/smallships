package com.talhanation.smallships.client.gui.screens.inventory;

import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.network.packet.ServerboundDockyardBuildPacket;
import com.talhanation.smallships.network.packet.ServerboundDockyardCannonPacket;
import com.talhanation.smallships.network.packet.ServerboundDockyardRepairPacket;
import com.talhanation.smallships.network.packet.ServerboundDockyardStylePacket;
import com.talhanation.smallships.network.packet.ServerboundDockyardUpgradePacket;
import com.talhanation.smallships.world.dockyard.DockyardRecipe;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.entity.ship.ShipUpgrade;
import com.talhanation.smallships.world.entity.ship.abilities.Bannerable;
import com.talhanation.smallships.world.entity.ship.abilities.Cannonable;
import com.talhanation.smallships.world.entity.ship.abilities.Sailable;
import com.talhanation.smallships.world.entity.ship.sail.SailDamage;
import com.talhanation.smallships.world.block.DockyardBlockEntity;
import net.minecraft.world.item.BannerItem;
import net.minecraft.world.item.DyeItem;
import com.talhanation.smallships.world.item.ModItems;
import net.minecraft.world.item.ItemStack;
import com.talhanation.smallships.world.inventory.DockyardMenu;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import org.jetbrains.annotations.NotNull;
import com.mojang.blaze3d.platform.Lighting;
import net.minecraft.client.renderer.MultiBufferSource;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import java.util.ArrayList;
import java.util.List;

/**
 * The dockyard screen.
 *
 * Build mode (no ship nearby): select ship type + wood type, see the material
 * list validated against the player inventory, start the build (only possible
 * if materials AND a 5x5 water spot are available - the server validates both).
 *
 * Modify mode (nearest ship within 16 blocks): shows the ship as rotating
 * preview, the upgrade icons with hover tooltips (benefit + costs), and
 * install/remove buttons.
 */
public class DockyardScreen extends AbstractContainerScreen<DockyardMenu> {

    /**
     * The tab the player selected. Null means "follow the dockyard": modify a
     * detected ship, otherwise build. As soon as the player clicks a tab this
     * holds his explicit choice, so he can build a new ship even while another
     * one is moored next to the dockyard.
     */
    private Boolean modifyTabSelected = null;
    private TabButton buildTab;
    private TabButton modifyTab;

    private DockyardRecipe.ShipType selectedShipType = DockyardRecipe.ShipType.COG;
    private int woodTypeIndex = 0;

    private Button buildButton;
    private Button repairButton;
    private Button shipTypeButton;
    private Button woodTypeButton;
    private final List<UpgradeButton> upgradeButtons = new ArrayList<>();
    private final List<CannonSlotButton> cannonSlotButtons = new ArrayList<>();
    private final List<StyleButton> styleButtons = new ArrayList<>();
    /** build mode: cached dummy ship for the preview (never added to the world) */
    private Ship previewShip;
    private int previewShipTypeId = -1;
    private int previewWoodIndex = -1;

    /* ---------------- layout ---------------- */

    /** outer padding of the window */
    private static final int PAD = 8;
    /** header strip height (title bar) */
    private static final int HEADER_H = 22;
    /** height of the tab strip sitting directly below the header */
    private static final int TAB_H = 20;
    /** width of a single tab */
    private static final int TAB_W = 74;
    /** width of the left column (controls, stats, materials) */
    private static final int COL_L_W = 150;
    /** width of the right column: fits exactly 5 icon buttons at 24px pitch */
    private static final int COL_R_W = 118;
    /** icon button pitch and per-row capacity of the right column grids */
    private static final int ICON_PITCH = 24;
    private static final int ICONS_PER_ROW = 5;
    /** height reserved for the rotating ship preview at the top right */
    private static final int PREVIEW_H = 60;
    /** y offsets (from contentTop) of the three equipment sections */
    private static final int SEC_UPGRADES = 64;
    private static final int SEC_CANNONS = 105;
    private static final int SEC_STYLE = 170;
    /** a section's buttons start this far below its caption */
    private static final int SEC_LABEL_H = 11;
    /** gap between the two columns */
    private static final int COL_GAP = 6;
    /** height of the footer strip holding the action button / progress bar */
    private static final int FOOTER_H = 34;

    public DockyardScreen(DockyardMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
        // wider and taller than the vanilla container default: the screen holds
        // two columns (controls + stats on the left, preview and equipment on
        // the right) and must not overlap them at any ship type
        this.imageWidth = 290;
        this.imageHeight = 309;
    }

    /** x of the left column content */
    private int colLeftX() {
        return this.leftPos + PAD;
    }

    /** x of the right column content */
    private int colRightX() {
        return this.leftPos + PAD + COL_L_W + COL_GAP;
    }

    /** width of the right column */
    private int colRightW() {
        return COL_R_W;
    }

    /** y of the tab strip */
    private int tabTop() {
        return this.topPos + HEADER_H;
    }

    /** y of the first content row below the header and the tab strip */
    private int contentTop() {
        return this.topPos + HEADER_H + TAB_H;
    }

    /** y of the footer strip */
    private int footerTop() {
        return this.topPos + this.imageHeight - FOOTER_H;
    }

    @Override
    protected void init() {
        super.init();
        this.upgradeButtons.clear();

        int left = this.leftPos;
        int top = this.topPos;

        int colL = this.colLeftX();
        int colR = this.colRightX();
        int cTop = this.contentTop();

        // tab strip: explicit mode switch. The modify tab stays disabled while
        // no ship is detected, so the player can always see that the dockyard
        // has nothing to work on.
        this.buildTab = this.addRenderableWidget(new TabButton(this.leftPos + PAD, this.tabTop(),
                Component.translatable("gui.smallships.dockyard.tab.build"), button -> this.modifyTabSelected = false));
        this.modifyTab = this.addRenderableWidget(new TabButton(this.leftPos + PAD + TAB_W + 2, this.tabTop(),
                Component.translatable("gui.smallships.dockyard.tab.modify"), button -> this.modifyTabSelected = true));
        // seed the visual state so the very first frame is correct: containerTick
        // only runs after the screen has already been rendered once
        boolean modifyNow = this.isModifyMode();
        this.modifyTab.active = this.getShip() != null;
        this.modifyTab.selected = modifyNow;
        this.buildTab.selected = !modifyNow;

        this.shipTypeButton = this.addRenderableWidget(Button.builder(this.getShipTypeText(), button -> {
            this.selectedShipType = DockyardRecipe.ShipType.byId((this.selectedShipType.id + 1) % DockyardRecipe.ShipType.values().length);
            button.setMessage(this.getShipTypeText());
        }).bounds(colL, cTop, COL_L_W, 20).build());

        this.woodTypeButton = this.addRenderableWidget(Button.builder(this.getWoodTypeText(), button -> {
            this.woodTypeIndex = (this.woodTypeIndex + 1) % Boat.Type.values().length;
            button.setMessage(this.getWoodTypeText());
        }).bounds(colL, cTop + 24, COL_L_W, 20).build());

        this.buildButton = this.addRenderableWidget(Button.builder(Component.translatable("gui.smallships.dockyard.build"), button ->
                ModPackets.clientSendPacket(new ServerboundDockyardBuildPacket(this.menu.getDockyardPos(), this.selectedShipType.id, this.woodTypeIndex))
        ).bounds(colL, this.footerTop() + 7, COL_L_W, 20).build());

        this.repairButton = this.addRenderableWidget(Button.builder(Component.translatable("gui.smallships.dockyard.repair"), button ->
                ModPackets.clientSendPacket(new ServerboundDockyardRepairPacket(this.menu.getDockyardPos()))
        ).bounds(colL, this.footerTop() + 7, COL_L_W, 20).build());

        // upgrade buttons (modify mode)
        ShipUpgrade[] upgrades = ShipUpgrade.values();
        for (int i = 0; i < upgrades.length; i++) {
            ShipUpgrade upgrade = upgrades[i];
            UpgradeButton upgradeButton = new UpgradeButton(colR + (i % ICONS_PER_ROW) * ICON_PITCH, cTop + SEC_UPGRADES + SEC_LABEL_H + (i / ICONS_PER_ROW) * ICON_PITCH, upgrade, button ->
                    this.onUpgradeClicked(upgrade));
            this.upgradeButtons.add(this.addRenderableWidget(upgradeButton));
        }

        // cannon slot buttons (modify mode, dockyard-only cannon mounting)
        this.cannonSlotButtons.clear();
        for (int slot = 0; slot < 6; slot++) {
            final int s = slot;
            CannonSlotButton slotButton = new CannonSlotButton(colR + (slot % ICONS_PER_ROW) * ICON_PITCH, cTop + SEC_CANNONS + SEC_LABEL_H + (slot / ICONS_PER_ROW) * ICON_PITCH, slot, button ->
                    this.onCannonSlotClicked(s));
            this.cannonSlotButtons.add(this.addRenderableWidget(slotButton));
        }

        // style bar: dyes and banners detected in the player inventory
        this.styleButtons.clear();
        for (int i = 0; i < 8; i++) {
            StyleButton styleButton = new StyleButton(colR + (i % ICONS_PER_ROW) * ICON_PITCH, cTop + SEC_STYLE + SEC_LABEL_H + (i / ICONS_PER_ROW) * ICON_PITCH, button -> {
                StyleButton sb = (StyleButton) button;
                if (sb.inventorySlot >= 0) {
                    ModPackets.clientSendPacket(new ServerboundDockyardStylePacket(this.menu.getDockyardPos(), sb.inventorySlot));
                }
            });
            this.styleButtons.add(this.addRenderableWidget(styleButton));
        }
    }

    private void onCannonSlotClicked(int slot) {
        Ship ship = this.getShip();
        if (!(ship instanceof Cannonable cannonable)) return;
        boolean mount = !cannonable.isCannonInSlot(slot);
        ModPackets.clientSendPacket(new ServerboundDockyardCannonPacket(this.menu.getDockyardPos(), slot, mount));
    }

    private void onUpgradeClicked(ShipUpgrade upgrade) {
        Ship ship = this.getShip();
        if (ship == null) return;
        boolean install = !upgrade.isInstalled(ship);
        ModPackets.clientSendPacket(new ServerboundDockyardUpgradePacket(this.menu.getDockyardPos(), upgrade.ordinal(), install));
    }

    private Component getShipTypeText() {
        return Component.translatable("gui.smallships.dockyard.ship_type", this.selectedShipType.name());
    }

    private Component getWoodTypeText() {
        return Component.translatable("gui.smallships.dockyard.wood_type", Boat.Type.values()[this.woodTypeIndex].getName());
    }

    private Ship getShip() {
        if (this.minecraft == null || this.minecraft.level == null) return null;
        int shipId = this.menu.getShipId();
        if (shipId < 0) return null;
        Entity entity = this.minecraft.level.getEntity(shipId);
        return entity instanceof Ship ship ? ship : null;
    }

    /**
     * @return true if the screen is currently in modify mode. Without an
     * explicit tab choice this follows ship detection; modify is never possible
     * without a ship, so the flag is ignored in that case.
     */
    private boolean isModifyMode() {
        boolean shipPresent = this.getShip() != null;
        if (!shipPresent) return false;
        return this.modifyTabSelected == null || this.modifyTabSelected;
    }

    @Override
    public void containerTick() {
        super.containerTick();
        boolean modify = this.isModifyMode();
        boolean busy = this.menu.isBusy();

        boolean shipPresent = this.getShip() != null;
        this.modifyTab.active = shipPresent;
        this.modifyTab.selected = modify;
        this.buildTab.selected = !modify;
        this.modifyTab.setTooltip(shipPresent ? null
                : net.minecraft.client.gui.components.Tooltip.create(Component.translatable("gui.smallships.dockyard.tab.no_ship")));

        this.shipTypeButton.visible = !modify;
        this.woodTypeButton.visible = !modify;
        this.buildButton.visible = !modify;
        this.buildButton.active = !busy && this.canAffordSelection();
        Ship repairShip = this.getShip();
        boolean damaged = repairShip != null && (repairShip.getDamage() > 0.0F || SailDamage.getHealth(repairShip) < SailDamage.MAX_HEALTH);
        this.repairButton.visible = modify && damaged;
        if (this.repairButton.visible) {
            // dynamic costs: heavier damage costs more; wool only for torn sails
            var costs = DockyardBlockEntity.getRepairCosts(repairShip);
            boolean afford = true;
            net.minecraft.network.chat.MutableComponent costLine = Component.translatable("gui.smallships.dockyard.repair_cost");
            for (var cost : costs) {
                ItemStack display = cost.getDisplayStack(net.minecraft.world.entity.vehicle.Boat.Type.OAK);
                costLine.append(Component.literal(" " + cost.amount() + "x ")).append(display.getHoverName());
                if (this.menu.getPlayer() != null && !this.menu.getPlayer().hasInfiniteMaterials() && cost.countIn(this.menu.getPlayer()) < cost.amount()) {
                    afford = false;
                }
            }
            this.repairButton.setTooltip(net.minecraft.client.gui.components.Tooltip.create(costLine));
            this.repairButton.active = !busy && afford;
        } else {
            this.repairButton.active = false;
        }
        Ship ship = this.getShip();
        for (UpgradeButton button : this.upgradeButtons) {
            button.visible = modify;
            button.active = modify && !busy;
            button.ship = ship;
        }
        boolean cannonShip = ship instanceof Cannonable;
        int totalSlots = cannonShip ? ((Cannonable) ship).getTotalCannonSlots() : 0;
        for (CannonSlotButton button : this.cannonSlotButtons) {
            button.visible = modify && cannonShip && button.slot < totalSlots;
            button.active = button.visible && !busy;
            button.ship = ship;
        }

        // scan the player inventory for dyes (sailable ships) and banners
        // (bannerable ships): one button per distinct dye color / banner stack
        List<int[]> styleSlots = new ArrayList<>(); // [inventorySlot]
        java.util.Set<String> seenColors = new java.util.HashSet<>();
        Player stylePlayer = this.menu.getPlayer();
        if (modify && ship != null && stylePlayer != null) {
            var items = stylePlayer.getInventory().items;
            for (int slot = 0; slot < items.size() && styleSlots.size() < this.styleButtons.size(); slot++) {
                ItemStack stack = items.get(slot);
                if (stack.getItem() instanceof DyeItem dyeItem && ship instanceof Sailable) {
                    if (dyeItem.getDyeColor().getName().equals(ship.getData(com.talhanation.smallships.world.entity.ship.Ship.SAIL_COLOR))) continue;
                    if (!seenColors.add(dyeItem.getDyeColor().getName())) continue;
                    styleSlots.add(new int[]{slot});
                } else if (stack.getItem() instanceof BannerItem && ship instanceof Bannerable) {
                    styleSlots.add(new int[]{slot});
                }
            }
        }
        for (int i = 0; i < this.styleButtons.size(); i++) {
            StyleButton button = this.styleButtons.get(i);
            if (modify && i < styleSlots.size() && stylePlayer != null) {
                button.inventorySlot = styleSlots.get(i)[0];
                button.displayStack = stylePlayer.getInventory().items.get(button.inventorySlot);
                button.visible = true;
                button.active = !busy;
            } else {
                button.inventorySlot = -1;
                button.displayStack = ItemStack.EMPTY;
                button.visible = false;
                button.active = false;
            }
        }
    }

    private boolean canAffordSelection() {
        Player player = this.menu.getPlayer();
        return player != null && DockyardRecipe.canAfford(this.selectedShipType, player);
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        this.renderTooltip(guiGraphics, mouseX, mouseY);

        for (UpgradeButton button : this.upgradeButtons) {
            if (button.visible && button.active && button.isHoveredOrFocused()) {
                guiGraphics.renderComponentTooltip(this.font, button.getTooltipLines(), mouseX, mouseY);
            }
        }
        for (CannonSlotButton button : this.cannonSlotButtons) {
            if (button.visible && button.active && button.isHoveredOrFocused()) {
                guiGraphics.renderComponentTooltip(this.font, button.getTooltipLines(), mouseX, mouseY);
            }
        }
        for (StyleButton button : this.styleButtons) {
            if (button.visible && button.active && button.isHoveredOrFocused()) {
                guiGraphics.renderComponentTooltip(this.font, button.getTooltipLines(), mouseX, mouseY);
            }
        }
    }

    /**
     * The screen draws its own header, and there is no player inventory grid
     * in this container - so the vanilla title and "Inventory" labels would
     * just print on top of the custom background.
     */
    @Override
    protected void renderLabels(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY) {
    }

    @Override
    protected void renderBg(@NotNull GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        int left = this.leftPos;
        int top = this.topPos;
        int right = left + this.imageWidth;
        int bottom = top + this.imageHeight;

        // window: outer border, body, and a slightly lighter header strip so the
        // title reads as a bar instead of floating text
        guiGraphics.fill(left - 1, top - 1, right + 1, bottom + 1, 0xFF15151A);
        guiGraphics.fill(left, top, right, bottom, 0xFF31313A);
        guiGraphics.fill(left, top, right, top + HEADER_H, 0xFF25252C);
        guiGraphics.fill(left, top + HEADER_H - 1, right, top + HEADER_H, 0xFF15151A);
        guiGraphics.drawString(this.font, this.title, left + PAD, top + 7, 0xFFFFFFFF, false);

        // tab strip background: the tabs themselves are widgets drawn on top,
        // this is the recessed lane they sit in. The closing line is drawn in
        // two spans so it does not cross under the SELECTED tab - that tab has
        // to merge seamlessly into the content panel below it.
        guiGraphics.fill(left, top + HEADER_H, right, this.contentTop(), 0xFF25252C);
        int selX = (this.isModifyMode() ? this.modifyTab : this.buildTab).getX();
        guiGraphics.fill(left, this.contentTop() - 1, selX, this.contentTop(), 0xFF15151A);
        guiGraphics.fill(selX + TAB_W, this.contentTop() - 1, right, this.contentTop(), 0xFF15151A);

        int colL = this.colLeftX();
        int colR = this.colRightX();
        int cTop = this.contentTop();
        int colRW = this.colRightW();

        Ship ship = this.getShip();
        if (this.isModifyMode() && ship != null) {
            // ---------- modify mode ----------
            // left column: name, stats
            guiGraphics.drawString(this.font, ship.getDisplayName().copy().withStyle(ChatFormatting.YELLOW), colL, cTop + 2, 0xFFFFFF, false);
            guiGraphics.drawString(this.font, Component.translatable("gui.smallships.dockyard.modify_hint"), colL, cTop + 14, 0xFF9A9AA5, false);

            int statTop = cTop + 28;
            panel(guiGraphics, colL - 3, statTop - 3, COL_L_W + 6, this.footerTop() - statTop - 2);
            ShipStatPanel.render(guiGraphics, this.font, colL, statTop, ship, ship);

            // right column: preview above the equipment sections
            panel(guiGraphics, colR - 3, cTop - 3, colRW + 6, PREVIEW_H);
            this.renderShipPreview(guiGraphics, ship, colR + colRW / 2, cTop + PREVIEW_H - 12, mouseX, mouseY);

            sectionLabel(guiGraphics, this.font, colR, cTop + SEC_UPGRADES, "gui.smallships.dockyard.section.upgrades");
            sectionLabel(guiGraphics, this.font, colR, cTop + SEC_CANNONS, "gui.smallships.dockyard.section.cannons");
            sectionLabel(guiGraphics, this.font, colR, cTop + SEC_STYLE, "gui.smallships.dockyard.section.style");
        } else {
            // ---------- build mode ----------
            // right column: preview of the selected type
            panel(guiGraphics, colR - 3, cTop - 3, colRW + 6, PREVIEW_H);
            this.renderBuildPreview(guiGraphics, colR + colRW / 2, cTop + PREVIEW_H - 12, mouseX, mouseY);

            // right column below the preview: wind profile of the selection
            int statTop = cTop + PREVIEW_H + 4;
            panel(guiGraphics, colR - 3, statTop - 3, colRW + 6, this.footerTop() - statTop - 2);
            ShipStatPanel.render(guiGraphics, this.font, colR, statTop, null, this.previewShip);

            // left column below the two selector buttons: material list
            int matTop = cTop + 52;
            panel(guiGraphics, colL - 3, matTop - 3, COL_L_W + 6, this.footerTop() - matTop - 2);
            sectionLabel(guiGraphics, this.font, colL, matTop, "gui.smallships.dockyard.section.materials");

            List<ItemStack> materials = DockyardRecipe.getDisplayStacks(this.selectedShipType, Boat.Type.values()[this.woodTypeIndex]);
            List<DockyardRecipe.Ingredient> ingredients = DockyardRecipe.getIngredients(this.selectedShipType);
            int y = matTop + 12;
            int limit = this.footerTop() - 22;
            for (int i = 0; i < materials.size(); i++) {
                // never draw into the footer: long recipes are cut off with a
                // "+N more" line instead of overlapping the build button
                if (y > limit && i < materials.size() - 1) {
                    guiGraphics.drawString(this.font,
                            Component.translatable("gui.smallships.dockyard.more_materials", materials.size() - i).withStyle(ChatFormatting.DARK_GRAY),
                            colL + 2, y + 4, 0xFFFFFF, false);
                    break;
                }
                ItemStack stack = materials.get(i);
                DockyardRecipe.Ingredient ingredient = ingredients.get(i);
                boolean has = this.menu.getPlayer() == null || ingredient.countIn(this.menu.getPlayer()) >= ingredient.amount() || this.menu.getPlayer().hasInfiniteMaterials();
                guiGraphics.renderItem(stack, colL + 2, y);
                guiGraphics.drawString(this.font,
                        Component.literal(ingredient.amount() + "x ").append(stack.getHoverName()),
                        colL + 22, y + 4, has ? 0xFF8CD97A : 0xFFD9453D, false);
                y += 19;
            }
        }

        // footer: separator plus progress bar while the dockyard works
        guiGraphics.fill(left, this.footerTop(), right, this.footerTop() + 1, 0xFF15151A);
        if (this.menu.isBusy() && this.menu.getTotalTime() > 0) {
            int barX = colR;
            int barY = this.footerTop() + 13;
            int barWidth = colRW;
            float progress = (float) this.menu.getProgress() / (float) this.menu.getTotalTime();
            guiGraphics.fill(barX - 1, barY - 1, barX + barWidth + 1, barY + 9, 0xFF15151A);
            guiGraphics.fill(barX, barY, barX + barWidth, barY + 8, 0xFF1B1B1B);
            guiGraphics.fill(barX, barY, barX + (int) (barWidth * Math.min(1.0F, progress)), barY + 8, 0xFF55B14C);
            guiGraphics.drawString(this.font, Component.translatable("gui.smallships.dockyard.working"), barX, barY - 11, 0xFFDDDDDD, false);
        }
    }

    /** Inset panel background: a subtle sunken box grouping one section. */
    private static void panel(GuiGraphics guiGraphics, int x, int y, int width, int height) {
        if (height <= 0) return;
        guiGraphics.fill(x, y, x + width, y + height, 0xFF15151A);
        guiGraphics.fill(x + 1, y + 1, x + width - 1, y + height - 1, 0xFF282830);
    }

    /** Small orange caption above a section. */
    private static void sectionLabel(GuiGraphics guiGraphics, net.minecraft.client.gui.Font font, int x, int y, String translationKey) {
        guiGraphics.drawString(font, Component.translatable(translationKey), x, y, 0xFFFFAA33, false);
    }

    /**
     * Renders the detected ship as a rotating preview into the GUI
     * (same technique as InventoryScreen.renderEntityInInventoryFollowsMouse,
     * concept taken from SiegeWeapons' EntityInScreenRenderer).
     */
    private void renderShipPreview(GuiGraphics guiGraphics, Ship ship, int x, int y, int mouseX, int mouseY) {
        if (this.minecraft == null) return;
        float scale = 8.0F;
        float rotation = (System.currentTimeMillis() % 25200L) / 70.0F;
        Quaternionf pose = new Quaternionf().rotationXYZ(0.20F, (float) Math.toRadians(rotation), (float) Math.PI);

        guiGraphics.pose().pushPose();
        guiGraphics.pose().translate(x, y, 50.0F);
        guiGraphics.pose().scale(scale, scale, -scale);
        guiGraphics.pose().mulPose(pose);

        Lighting.setupForEntityInInventory();
        var dispatcher = this.minecraft.getEntityRenderDispatcher();
        dispatcher.setRenderShadow(false);
        MultiBufferSource.BufferSource bufferSource = this.minecraft.renderBuffers().bufferSource();
        dispatcher.render(ship, 0.0D, -1.0D, 0.0D, 0.0F, 1.0F, guiGraphics.pose(), bufferSource, 15728880);
        bufferSource.endBatch();
        dispatcher.setRenderShadow(true);
        Lighting.setupFor3DItems();

        guiGraphics.pose().popPose();
    }

    /**
     * Build mode: renders a client-only dummy ship of the selected type/wood
     * (created via the ships' summon factories, never added to the world).
     */
    private void renderBuildPreview(GuiGraphics guiGraphics, int x, int y, int mouseX, int mouseY) {
        if (this.minecraft == null || this.minecraft.level == null) return;
        if (this.previewShip == null || this.previewShipTypeId != this.selectedShipType.id || this.previewWoodIndex != this.woodTypeIndex) {
            this.previewShip = this.selectedShipType.summon(this.minecraft.level, 0.0D, -100.0D, 0.0D);
            if (this.previewShip != null) {
                this.previewShip.setVariant(Boat.Type.values()[this.woodTypeIndex]);
            }
            this.previewShipTypeId = this.selectedShipType.id;
            this.previewWoodIndex = this.woodTypeIndex;
        }
        if (this.previewShip != null) {
            this.renderShipPreview(guiGraphics, this.previewShip, x, y, mouseX, mouseY);
        }
    }

    /**
     * A header tab. The selected tab is drawn flush with the content below it
     * (no bottom border) so it reads as part of the panel, the unselected one
     * sits recessed and darker.
     */
    private static class TabButton extends Button {
        private boolean selected;

        protected TabButton(int x, int y, Component label, OnPress onPress) {
            super(x, y, TAB_W, TAB_H, label, onPress, DEFAULT_NARRATION);
        }

        @Override
        protected void renderWidget(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
            int x = this.getX();
            int y = this.getY();
            int right = x + this.width;
            int bottom = y + this.height;

            int body = this.selected ? 0xFF31313A : (this.isHoveredOrFocused() && this.active ? 0xFF2A2A32 : 0xFF212128);
            guiGraphics.fill(x, y, right, bottom, 0xFF15151A);
            guiGraphics.fill(x + 1, y + 1, right - 1, bottom, body);
            if (this.selected) {
                // accent line on top, and no separator at the bottom so the tab
                // merges into the content panel
                guiGraphics.fill(x + 1, y + 1, right - 1, y + 2, 0xFFFFAA33);
            } else {
                guiGraphics.fill(x + 1, bottom - 1, right - 1, bottom, 0xFF15151A);
            }

            int textColor = !this.active ? 0xFF5A5A63 : (this.selected ? 0xFFFFFFFF : 0xFFAAAAB4);
            guiGraphics.drawCenteredString(net.minecraft.client.Minecraft.getInstance().font,
                    this.getMessage(), x + this.width / 2, y + (this.height - 8) / 2 + 1, textColor);
        }
    }

    /**
     * A style button: shows a dye or banner detected in the player inventory.
     * Clicking applies it to the ship after a short dockyard work time.
     */
    private class StyleButton extends Button {
        private int inventorySlot = -1;
        private ItemStack displayStack = ItemStack.EMPTY;

        protected StyleButton(int x, int y, OnPress onPress) {
            super(x, y, 22, 22, Component.empty(), onPress, DEFAULT_NARRATION);
            this.visible = false;
        }

        @Override
        protected void renderWidget(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
            int frame = this.isHoveredOrFocused() ? 0xFFFFFFFF : 0xFF777777;
            guiGraphics.fill(this.getX(), this.getY(), this.getX() + this.width, this.getY() + this.height, frame);
            guiGraphics.fill(this.getX() + 1, this.getY() + 1, this.getX() + this.width - 1, this.getY() + this.height - 1, 0xFF2B2B2B);
            if (!this.displayStack.isEmpty()) {
                guiGraphics.renderItem(this.displayStack, this.getX() + 3, this.getY() + 3);
            }
        }

        public List<Component> getTooltipLines() {
            List<Component> lines = new ArrayList<>();
            lines.add(this.displayStack.getHoverName().copy().withStyle(ChatFormatting.GOLD));
            lines.add((this.displayStack.getItem() instanceof DyeItem
                    ? Component.translatable("gui.smallships.dockyard.click_dye")
                    : Component.translatable("gui.smallships.dockyard.click_banner")).withStyle(ChatFormatting.GREEN));
            return lines;
        }
    }

    /**
     * A cannon slot button: cannon item as icon, green frame when a cannon is
     * mounted in this slot. Click = mount (costs 1 cannon) / dismount (drops it).
     */
    private class CannonSlotButton extends Button {
        private final int slot;
        private Ship ship;

        protected CannonSlotButton(int x, int y, int slot, OnPress onPress) {
            super(x, y, 22, 22, Component.empty(), onPress, DEFAULT_NARRATION);
            this.slot = slot;
        }

        private boolean isMounted() {
            return this.ship instanceof Cannonable cannonable && cannonable.isCannonInSlot(this.slot);
        }

        @Override
        protected void renderWidget(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
            boolean mounted = this.isMounted();
            int frame = mounted ? 0xFF55B14C : (this.isHoveredOrFocused() ? 0xFFFFFFFF : 0xFF777777);
            guiGraphics.fill(this.getX(), this.getY(), this.getX() + this.width, this.getY() + this.height, frame);
            guiGraphics.fill(this.getX() + 1, this.getY() + 1, this.getX() + this.width - 1, this.getY() + this.height - 1, 0xFF2B2B2B);
            guiGraphics.renderItem(new ItemStack(ModItems.CANNON), this.getX() + 3, this.getY() + 3);
            if (!mounted) {
                guiGraphics.fill(this.getX() + 1, this.getY() + 1, this.getX() + this.width - 1, this.getY() + this.height - 1, 0x88000000);
            }
        }

        public List<Component> getTooltipLines() {
            List<Component> lines = new ArrayList<>();
            boolean right = this.ship instanceof Cannonable cannonable && cannonable.getCannonPosition(this.slot) != null && cannonable.getCannonPosition(this.slot).isRightSided;
            lines.add(Component.translatable("gui.smallships.dockyard.cannon_slot", this.slot + 1,
                    Component.translatable(right ? "gui.smallships.dockyard.starboard" : "gui.smallships.dockyard.port")).withStyle(ChatFormatting.GOLD));
            lines.add((this.isMounted()
                    ? Component.translatable("gui.smallships.dockyard.click_remove").withStyle(ChatFormatting.RED)
                    : Component.translatable("gui.smallships.dockyard.click_mount").withStyle(ChatFormatting.GREEN)));
            return lines;
        }
    }

    /**
     * An upgrade icon button: renders the cost item as icon, a green frame if
     * installed, and provides tooltip lines with name, benefit and costs.
     */
    private class UpgradeButton extends Button {
        private final ShipUpgrade upgrade;
        private Ship ship;

        protected UpgradeButton(int x, int y, ShipUpgrade upgrade, OnPress onPress) {
            super(x, y, 22, 22, Component.empty(), onPress, DEFAULT_NARRATION);
            this.upgrade = upgrade;
        }

        @Override
        protected void renderWidget(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
            boolean installed = this.ship != null && this.upgrade.isInstalled(this.ship);
            int frame = installed ? 0xFF55B14C : (this.isHoveredOrFocused() ? 0xFFFFFFFF : 0xFF777777);
            guiGraphics.fill(this.getX(), this.getY(), this.getX() + this.width, this.getY() + this.height, frame);
            guiGraphics.fill(this.getX() + 1, this.getY() + 1, this.getX() + this.width - 1, this.getY() + this.height - 1, 0xFF2B2B2B);
            guiGraphics.renderItem(this.upgrade.getCost(), this.getX() + 3, this.getY() + 3);
        }

        public List<Component> getTooltipLines() {
            boolean installed = this.ship != null && this.upgrade.isInstalled(this.ship);
            List<Component> lines = new ArrayList<>();
            lines.add(Component.translatable(this.upgrade.getTranslationKey()).withStyle(ChatFormatting.GOLD));
            lines.add(Component.translatable(this.upgrade.getDescriptionTranslationKey()).withStyle(ChatFormatting.GRAY));
            lines.add(Component.translatable("gui.smallships.dockyard.cost", this.upgrade.getCostAmount(), this.upgrade.getCost().getHoverName()).withStyle(ChatFormatting.YELLOW));
            lines.add((installed
                    ? Component.translatable("gui.smallships.dockyard.click_remove").withStyle(ChatFormatting.RED)
                    : Component.translatable("gui.smallships.dockyard.click_install").withStyle(ChatFormatting.GREEN)));
            return lines;
        }
    }
}