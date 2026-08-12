package com.talhanation.smallships.client.gui.screens.inventory;

import com.mojang.blaze3d.platform.Lighting;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.api.ShipRegistry;
import com.talhanation.smallships.api.ShipType;
import com.talhanation.smallships.client.gui.GuiCompat;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.network.packet.ServerboundDockyardApplyPacket;
import com.talhanation.smallships.network.packet.ServerboundDockyardBuildPacket;
import com.talhanation.smallships.network.packet.ServerboundDockyardRenamePacket;
import com.talhanation.smallships.network.packet.ServerboundDockyardRepairPacket;
import com.talhanation.smallships.world.block.DockyardBlockEntity;
import com.talhanation.smallships.world.dockyard.DockyardAction;
import com.talhanation.smallships.world.dockyard.DockyardRecipe;
import com.talhanation.smallships.world.dockyard.DockyardRecipeManager;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.entity.ship.ShipUpgrade;
import com.talhanation.smallships.world.entity.ship.abilities.Bannerable;
import com.talhanation.smallships.world.entity.ship.abilities.Cannonable;
import com.talhanation.smallships.world.entity.ship.abilities.Sailable;
import com.talhanation.smallships.world.inventory.DockyardMenu;
import com.talhanation.smallships.world.item.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractSelectionList;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.BannerItem;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionf;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * The dockyard screen.
 *
 * Two tabs on one background texture:
 *
 * - BUILD: pick a ship type with the arrows next to the preview, see its
 *   attributes on the left, the "about" text below it and the material list on
 *   the right. The wood type is picked from the item dropdown next to the build
 *   button.
 * - MODIFY: the docked ship with its editable name, the two repair buttons and
 *   the upgrade list. Several rows can be ticked at once - the dockyard turns
 *   the whole selection into ONE job with summed costs and one progress bar.
 *
 * The ship in the middle is NOT animated: it is turned by the player with left
 * click + drag, zoomed with the wheel and reset with a double click.
 *
 * All widgets are vanilla widgets or use vanilla sprites; the panels, frames
 * and separators are part of the background texture and are never drawn in
 * code. Every version specific draw call goes through {@link GuiCompat}.
 */
public class DockyardScreen extends AbstractContainerScreen<DockyardMenu> {

    private static final ResourceLocation BACKGROUND = ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, "textures/gui/dockyard.png");
    /** the window sits in the top left corner of a 512x512 sheet */
    private static final int TEXTURE_SIZE = 512;

    /* ---------------- layout: every value is read off the background texture ---------------- */

    private static final int WINDOW_W = 430;
    private static final int WINDOW_H = 211;

    /** the recessed lane at the top the tabs sit in */
    private static final int TAB_STRIP_X = 3;
    private static final int TAB_STRIP_Y = 3;
    private static final int TAB_STRIP_H = 18;
    private static final int TAB_W = 74;

    /** left panel: attributes, wind profile, penalties */
    private static final int STATS_X = 5;
    private static final int STATS_Y = 22;
    private static final int STATS_W = 114;

    /**
     * Center panel: the ship preview. This is the FULL black area - the model
     * is clipped to all of it, including the caption row, so a tall mast may
     * run behind the name and the ship type instead of being cut off above
     * them.
     */
    private static final int PREVIEW_X = 125;
    private static final int PREVIEW_Y = 24;
    private static final int PREVIEW_W = 180;
    private static final int PREVIEW_H = 131;

    /** center panel below the preview: about text (build) / repair buttons (modify) */
    private static final int CENTER_X = 123;
    private static final int CENTER_Y = 163;
    private static final int CENTER_W = 184;
    private static final int CENTER_H = 40;

    /** right panel: material list (build) / upgrade list (modify) */
    private static final int LIST_X = 311;
    private static final int LIST_Y = 22;
    private static final int LIST_W = 114;
    private static final int LIST_H = 135;
    /**
     * AbstractSelectionList centers its rows and hit tests them centered
     * (getEntryAtPosition is final). To get the rows close to the LEFT edge of
     * the panel without the drawing and the hit box drifting apart, the widget
     * itself starts this far left of the panel - the extra strip is excluded
     * again in isMouseOver, see the lists below.
     */
    private static final int LIST_OVERHANG = 4;

    /** right panel bottom: action button and the wood type dropdown */
    private static final int ACTION_X = 310;
    private static final int ACTION_Y = 160;
    private static final int ACTION_W = 116;

    /** height of the progress bar drawn over the lower edge of the preview */
    private static final int PROGRESS_H = 9;

    /* ---------------- colors ---------------- */

    private static final int COLOR_TEXT = 0xFFDDDDDD;
    private static final int COLOR_MUTED = 0xFF9A9AA5;
    private static final int COLOR_HAS = 0xFF8CD97A;
    private static final int COLOR_MISSING = 0xFFD9453D;
    /** upgrade row frames: installed / will be installed */
    private static final int FRAME_INSTALLED = 0xFF55B14C;
    /** upgrade row frames: not installed */
    private static final int FRAME_EMPTY = 0xFF6E6E78;
    /** upgrade row frames: installed AND ticked, so it is about to come off */
    private static final int FRAME_REMOVE = 0xFFD9453D;

    /* ---------------- state ---------------- */

    /**
     * The tab the player selected. Null means "follow the dockyard": modify a
     * detected ship, otherwise build. As soon as the player clicks a tab this
     * holds his explicit choice, so he can build a new ship even while another
     * one is moored next to the dockyard.
     */
    private Boolean modifyTabSelected = null;
    private TabButton buildTab;
    private TabButton modifyTab;

    /** the ship selected in the build tab, null while no ship type is buildable */
    private ShipType selectedShipType;
    private Boat.Type woodType = Boat.Type.OAK;

    private ShipPreview preview;
    private Button prevShipButton;
    private Button nextShipButton;
    private Button sailToggleButton;
    private Button buildButton;
    private Button applyButton;
    private RepairButton repairHullButton;
    private RepairButton repairSailsButton;
    private WoodDropdown woodDropdown;
    private MaterialList materialList;
    private UpgradeList upgradeList;
    private NameField nameField;

    /** build mode: cached dummy ship for the preview (never added to the world) */
    @Nullable private Ship previewShip;
    @Nullable private ShipType previewShipType;
    @Nullable private Boat.Type previewWoodType;
    /** the preview dummy shows its sails set by default, toggled by the player */
    private boolean previewSailsOpen = true;

    /** modify mode: the rows the player ticked, by {@link DockyardAction#key()} */
    private final Set<String> selectedRows = new LinkedHashSet<>();
    /** modify mode: the currently offered rows, rebuilt when the ship or the inventory changes */
    private final List<UpgradeOption> options = new ArrayList<>();
    /** cheap change detector so the list is not rebuilt 20 times a second for nothing */
    private String optionSignature = "";
    /** the cannon slot the cursor rests on, projected onto the preview. -1 = none */
    private int ghostCannonSlot = -1;

    public DockyardScreen(DockyardMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
        this.imageWidth = WINDOW_W;
        this.imageHeight = WINDOW_H;
    }

    /* ---------------- absolute layout helpers ---------------- */

    private int x(int textureX) {
        return this.leftPos + textureX;
    }

    private int y(int textureY) {
        return this.topPos + textureY;
    }

    @Override
    protected void init() {
        super.init();

        // the modify tab stays disabled while no ship is detected, so the
        // player can always see that the dockyard has nothing to work on
        this.buildTab = this.addRenderableWidget(new TabButton(this.x(TAB_STRIP_X), this.y(TAB_STRIP_Y),
                Component.translatable("gui.smallships.dockyard.tab.build"), button -> this.selectTab(false)));
        this.modifyTab = this.addRenderableWidget(new TabButton(this.x(TAB_STRIP_X + TAB_W + 2), this.y(TAB_STRIP_Y),
                Component.translatable("gui.smallships.dockyard.tab.modify"), button -> this.selectTab(true)));

        // the build tab only ever offers what the registry holds and the
        // config allows, so ships coming from addons show up here on their own
        List<ShipType> buildable = ShipRegistry.getBuildable();
        if (this.selectedShipType == null || !buildable.contains(this.selectedShipType)) {
            this.selectedShipType = buildable.isEmpty() ? null : buildable.get(0);
        }

        // The wood dropdown is registered FIRST so its popup wins every click
        // before the widgets underneath it get one. It is not renderable: the
        // popup has to be drawn last of all, see render().
        this.woodDropdown = this.addWidget(new WoodDropdown(this.x(ACTION_X + ACTION_W - 26), this.y(ACTION_Y + 12)));

        this.prevShipButton = this.addRenderableWidget(Button.builder(Component.literal("<"), button -> this.cycleShipType(-1))
                .bounds(this.x(PREVIEW_X + 2), this.y(PREVIEW_Y + PREVIEW_H / 2 - 10), 14, 20).build());
        this.nextShipButton = this.addRenderableWidget(Button.builder(Component.literal(">"), button -> this.cycleShipType(1))
                .bounds(this.x(PREVIEW_X + PREVIEW_W - 16), this.y(PREVIEW_Y + PREVIEW_H / 2 - 10), 14, 20).build());

        // sail state toggle: the preview dummy alone, the modify tab always
        // shows the real ship exactly as it floats outside
        this.sailToggleButton = this.addRenderableWidget(Button.builder(Component.literal("O"), button -> {
            this.previewSailsOpen = !this.previewSailsOpen;
            this.applyPreviewSailState();
        }).bounds(this.x(PREVIEW_X + PREVIEW_W - 14), this.y(PREVIEW_Y + 1), 12, 12).build());

        this.buildButton = this.addRenderableWidget(Button.builder(Component.translatable("gui.smallships.dockyard.build"), button -> this.sendBuildPacket())
                .bounds(this.x(ACTION_X + 2), this.y(ACTION_Y + 12), ACTION_W - 32, 20).build());
        this.applyButton = this.addRenderableWidget(Button.builder(Component.translatable("gui.smallships.dockyard.apply"), button -> this.sendApplyPacket())
                .bounds(this.x(ACTION_X + 2), this.y(ACTION_Y + 12), ACTION_W - 4, 20).build());

        int repairWidth = (CENTER_W - 10) / 2;
        this.repairHullButton = this.addRenderableWidget(new RepairButton(this.x(CENTER_X + 3), this.y(CENTER_Y + 10),
                repairWidth, new ItemStack(Items.OAK_PLANKS),
                Component.translatable("gui.smallships.dockyard.repair_hull"),
                button -> this.sendRepairPacket(true, false)));
        this.repairSailsButton = this.addRenderableWidget(new RepairButton(this.x(CENTER_X + 7 + repairWidth), this.y(CENTER_Y + 10),
                repairWidth, new ItemStack(Items.WHITE_WOOL),
                Component.translatable("gui.smallships.dockyard.repair_sails"),
                button -> this.sendRepairPacket(false, true)));

        this.materialList = this.addRenderableWidget(new MaterialList(this.x(LIST_X - LIST_OVERHANG), this.y(LIST_Y),
                LIST_W + LIST_OVERHANG, LIST_H));
        this.upgradeList = this.addRenderableWidget(new UpgradeList(this.x(LIST_X - LIST_OVERHANG), this.y(LIST_Y),
                LIST_W + LIST_OVERHANG, LIST_H));

        this.nameField = this.addRenderableWidget(new NameField(this.x(PREVIEW_X + 4), this.y(PREVIEW_Y + 2), 104, 10));

        // the preview is a child (so it receives drag and scroll) but not
        // renderable: it is drawn in renderBg, below the arrow buttons sitting
        // on top of it
        this.preview = this.addWidget(new ShipPreview(this.x(PREVIEW_X), this.y(PREVIEW_Y), PREVIEW_W, PREVIEW_H));

        this.rebuildMaterialList();
        this.optionSignature = "";
        this.updateWidgetVisibility();
    }

    private void selectTab(boolean modify) {
        this.modifyTabSelected = modify;
        this.preview.reset();
        this.woodDropdown.close();
        this.selectedRows.clear();
    }

    /* ---------------- outgoing packets ---------------- */

    private void sendBuildPacket() {
        if (this.selectedShipType == null) return;
        ModPackets.clientSendPacket(new ServerboundDockyardBuildPacket(this.menu.getDockyardPos(),
                this.selectedShipType.getId(), this.woodType.ordinal()));
    }

    private void sendRepairPacket(boolean hull, boolean sails) {
        ModPackets.clientSendPacket(new ServerboundDockyardRepairPacket(this.menu.getDockyardPos(), hull, sails));
    }

    private void sendApplyPacket() {
        List<DockyardAction> actions = new ArrayList<>();
        for (UpgradeOption option : this.options) {
            if (this.selectedRows.contains(option.action.key())) actions.add(option.action);
        }
        if (actions.isEmpty()) return;
        ModPackets.clientSendPacket(new ServerboundDockyardApplyPacket(this.menu.getDockyardPos(), actions));
        this.selectedRows.clear();
    }

    private void sendRename() {
        if (this.getShip() == null) return;
        ModPackets.clientSendPacket(new ServerboundDockyardRenamePacket(this.menu.getDockyardPos(), this.nameField.getValue()));
    }

    /* ---------------- build tab ---------------- */

    /** Steps to the next / previous buildable ship type, wrapping around. */
    private void cycleShipType(int direction) {
        List<ShipType> buildable = ShipRegistry.getBuildable();
        if (buildable.isEmpty()) {
            this.selectedShipType = null;
            return;
        }
        int index = buildable.indexOf(this.selectedShipType);
        this.selectedShipType = buildable.get(Math.floorMod(index + direction, buildable.size()));
        // a different hull means a different size and a different material
        // list, so both the camera and the list start over
        this.preview.reset();
        this.rebuildMaterialList();
    }

    private void setWoodType(Boat.Type type) {
        if (this.woodType == type) return;
        this.woodType = type;
        this.rebuildMaterialList();
    }

    private void rebuildMaterialList() {
        if (this.materialList == null) return;
        this.materialList.rebuild(this.selectedShipType, this.woodType);
    }

    private boolean canAffordSelection() {
        Player player = this.menu.getPlayer();
        return player != null && this.selectedShipType != null
                && DockyardRecipeManager.get(this.selectedShipType).canAfford(player);
    }

    /* ---------------- modify tab ---------------- */

    @Nullable
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
        if (this.getShip() == null) return false;
        return this.modifyTabSelected == null || this.modifyTabSelected;
    }

    /**
     * One selectable row of the modify tab. Everything a row needs to draw
     * itself and to price itself is captured once when the list is built - the
     * server derives all of it again anyway, this is display only.
     */
    private static class UpgradeOption {
        /** what pressing apply would do with this row */
        private final DockyardAction action;
        private final ItemStack icon;
        private final Component name;
        /** what this row costs; EMPTY for a removal, which never costs anything */
        private final ItemStack cost;
        private final boolean installed;
        private final List<Component> tooltip;

        private UpgradeOption(DockyardAction action, ItemStack icon, Component name, ItemStack cost,
                              boolean installed, List<Component> tooltip) {
            this.action = action;
            this.icon = icon;
            this.name = name;
            this.cost = cost;
            this.installed = installed;
            this.tooltip = tooltip;
        }
    }

    /**
     * Rebuilds the modify rows. Beside the three stat upgrades this offers one
     * row per cannon carriage and one row per banner / dye found in the player
     * inventory - a ship carries exactly ONE banner and ONE sail color, so
     * those rows swap what is already there instead of stacking up.
     */
    private void rebuildOptions(Ship ship) {
        this.options.clear();
        Player player = this.menu.getPlayer();

        for (ShipUpgrade upgrade : ShipUpgrade.values()) {
            boolean installed = upgrade.isInstalled(ship);
            List<Component> tooltip = new ArrayList<>();
            tooltip.add(Component.translatable(upgrade.getTranslationKey()).withStyle(ChatFormatting.GOLD));
            tooltip.add(Component.translatable(upgrade.getDescriptionTranslationKey()).withStyle(ChatFormatting.GRAY));
            if (installed) {
                tooltip.add(Component.translatable("gui.smallships.dockyard.refund",
                        upgrade.getRefundAmount(), upgrade.getCost().getHoverName()).withStyle(ChatFormatting.GREEN));
            } else {
                tooltip.add(Component.translatable("gui.smallships.dockyard.cost",
                        upgrade.getCostAmount(), upgrade.getCost().getHoverName()).withStyle(ChatFormatting.YELLOW));
            }
            this.options.add(new UpgradeOption(
                    new DockyardAction(DockyardAction.Kind.UPGRADE, upgrade.ordinal(), -1, !installed),
                    upgrade.getCost(), Component.translatable(upgrade.getTranslationKey()),
                    installed ? ItemStack.EMPTY : upgrade.getCost(), installed, tooltip));
        }

        if (ship instanceof Cannonable cannonable) {
            for (int slot = 0; slot < cannonable.getTotalCannonSlots(); slot++) {
                boolean mounted = cannonable.isCannonInSlot(slot);
                Cannonable.CannonPosition position = cannonable.getCannonPosition(slot);
                boolean starboard = position != null && position.isRightSided;
                Component name = Component.translatable("gui.smallships.dockyard.cannon_slot", slot + 1,
                        Component.translatable(starboard ? "gui.smallships.dockyard.starboard" : "gui.smallships.dockyard.port"));
                ItemStack cannonStack = new ItemStack(ModItems.CANNON);
                List<Component> tooltip = new ArrayList<>();
                tooltip.add(name.copy().withStyle(ChatFormatting.GOLD));
                // a cannon is bolted on, never built in: it always comes back whole
                tooltip.add(mounted
                        ? Component.translatable("gui.smallships.dockyard.refund", 1, cannonStack.getHoverName()).withStyle(ChatFormatting.GREEN)
                        : Component.translatable("gui.smallships.dockyard.cost", 1, cannonStack.getHoverName()).withStyle(ChatFormatting.YELLOW));
                this.options.add(new UpgradeOption(
                        new DockyardAction(DockyardAction.Kind.CANNON, slot, -1, !mounted),
                        cannonStack, name, mounted ? ItemStack.EMPTY : cannonStack.copy(), mounted, tooltip));
            }
        }

        if (ship instanceof Bannerable) {
            ItemStack current = ship.getData(Ship.BANNER);
            if (!current.isEmpty()) {
                List<Component> tooltip = new ArrayList<>();
                tooltip.add(current.getHoverName().copy().withStyle(ChatFormatting.GOLD));
                tooltip.add(Component.translatable("gui.smallships.dockyard.banner_mounted").withStyle(ChatFormatting.GRAY));
                this.options.add(new UpgradeOption(
                        new DockyardAction(DockyardAction.Kind.BANNER, 0, -1, false),
                        current.copyWithCount(1), current.getHoverName(), ItemStack.EMPTY, true, tooltip));
            }
            if (player != null) {
                List<ItemStack> seen = new ArrayList<>();
                var items = player.getInventory().items;
                for (int slot = 0; slot < items.size() && seen.size() < 8; slot++) {
                    ItemStack stack = items.get(slot);
                    if (!(stack.getItem() instanceof BannerItem)) continue;
                    boolean duplicate = false;
                    for (ItemStack other : seen) {
                        if (ItemStack.isSameItemSameComponents(other, stack)) duplicate = true;
                    }
                    if (duplicate) continue;
                    seen.add(stack);
                    List<Component> tooltip = new ArrayList<>();
                    tooltip.add(stack.getHoverName().copy().withStyle(ChatFormatting.GOLD));
                    tooltip.add(Component.translatable("gui.smallships.dockyard.banner_hint").withStyle(ChatFormatting.GRAY));
                    this.options.add(new UpgradeOption(
                            new DockyardAction(DockyardAction.Kind.BANNER, 0, slot, true),
                            stack.copyWithCount(1), stack.getHoverName(), stack.copyWithCount(1), false, tooltip));
                }
            }
        }

        if (ship instanceof Sailable && player != null) {
            String currentColor = ship.getData(Ship.SAIL_COLOR);
            Set<String> seenColors = new LinkedHashSet<>();
            var items = player.getInventory().items;
            for (int slot = 0; slot < items.size() && seenColors.size() < 16; slot++) {
                ItemStack stack = items.get(slot);
                if (!(stack.getItem() instanceof DyeItem dyeItem)) continue;
                String color = dyeItem.getDyeColor().getName();
                if (color.equals(currentColor) || !seenColors.add(color)) continue;
                Component name = Component.translatable("gui.smallships.dockyard.sail_color",
                        Component.translatable("color.minecraft." + color));
                List<Component> tooltip = new ArrayList<>();
                tooltip.add(name.copy().withStyle(ChatFormatting.GOLD));
                tooltip.add(Component.translatable("gui.smallships.dockyard.cost", 1, stack.getHoverName()).withStyle(ChatFormatting.YELLOW));
                this.options.add(new UpgradeOption(
                        new DockyardAction(DockyardAction.Kind.SAIL_COLOR, 0, slot, true),
                        stack.copyWithCount(1), name, stack.copyWithCount(1), false, tooltip));
            }
        }

        // a row that vanished (item used up elsewhere) must not stay ticked
        this.selectedRows.removeIf(key -> {
            for (UpgradeOption option : this.options) {
                if (option.action.key().equals(key)) return false;
            }
            return true;
        });
        this.upgradeList.rebuild(this.options);
    }

    /**
     * @return a signature of everything the row list depends on. Rebuilding
     * only when this changes keeps the scroll position stable while the player
     * reads through a long list.
     */
    private String buildOptionSignature(Ship ship) {
        StringBuilder builder = new StringBuilder();
        builder.append(ship.getId());
        for (ShipUpgrade upgrade : ShipUpgrade.values()) builder.append(upgrade.isInstalled(ship) ? '1' : '0');
        if (ship instanceof Cannonable cannonable) {
            for (int slot = 0; slot < cannonable.getTotalCannonSlots(); slot++) builder.append(cannonable.isCannonInSlot(slot) ? '1' : '0');
        }
        builder.append(ship.getData(Ship.SAIL_COLOR));
        builder.append(ship.getData(Ship.BANNER).getHoverName().getString());
        Player player = this.menu.getPlayer();
        if (player != null) {
            for (ItemStack stack : player.getInventory().items) {
                if (stack.getItem() instanceof BannerItem || stack.getItem() instanceof DyeItem || stack.is(ModItems.CANNON)) {
                    builder.append(stack.getHoverName().getString()).append(stack.getCount()).append(',');
                }
            }
        }
        return builder.toString();
    }

    /** @return the total material bill of the ticked rows, one entry per stack. */
    private List<ItemStack> getSelectionCosts() {
        List<ItemStack> costs = new ArrayList<>();
        for (UpgradeOption option : this.options) {
            if (this.selectedRows.contains(option.action.key()) && !option.cost.isEmpty()) costs.add(option.cost);
        }
        return costs;
    }

    private boolean canAffordRowSelection() {
        Player player = this.menu.getPlayer();
        if (player == null || player.hasInfiniteMaterials()) return true;
        List<ItemStack> costs = this.getSelectionCosts();
        for (ItemStack cost : costs) {
            int required = 0;
            for (ItemStack other : costs) {
                if (ItemStack.isSameItemSameComponents(cost, other)) required += other.getCount();
            }
            int owned = 0;
            for (ItemStack stack : player.getInventory().items) {
                if (ItemStack.isSameItemSameComponents(stack, cost)) owned += stack.getCount();
            }
            if (owned < required) return false;
        }
        return true;
    }

    /* ---------------- preview ---------------- */

    /**
     * @return the ship the preview and the stat panel work on: the docked ship
     * in modify mode, the throwaway build dummy otherwise.
     */
    @Nullable
    private Ship getDisplayedShip() {
        if (this.isModifyMode()) return this.getShip();
        return this.getOrCreatePreviewShip();
    }

    /**
     * Build mode: a client only dummy of the selected type and wood, created
     * through the ship types' own summon factory and never added to the world.
     * It is rebuilt only when the selection actually changes.
     */
    @Nullable
    private Ship getOrCreatePreviewShip() {
        if (this.minecraft == null || this.minecraft.level == null || this.selectedShipType == null) {
            this.previewShip = null;
            this.previewShipType = null;
            return null;
        }
        if (this.previewShip == null || !this.selectedShipType.equals(this.previewShipType) || this.woodType != this.previewWoodType) {
            this.previewShip = this.selectedShipType.summon(this.minecraft.level, 0.0D, -100.0D, 0.0D);
            if (this.previewShip != null) this.previewShip.setVariant(this.woodType);
            this.previewShipType = this.selectedShipType;
            this.previewWoodType = this.woodType;
            this.applyPreviewSailState();
        }
        return this.previewShip;
    }

    private void applyPreviewSailState() {
        if (this.previewShip instanceof Sailable) {
            this.previewShip.setData(Ship.SAIL_STATE, (byte) (this.previewSailsOpen ? 4 : 0));
        }
    }

    /** @return the lang key of a ship types' flavour text, addon safe. */
    private static String aboutKey(ShipType shipType) {
        return "gui.smallships.dockyard.about." + shipType.getId().getNamespace() + "." + shipType.getId().getPath();
    }

    /* ---------------- tick ---------------- */

    @Override
    public void containerTick() {
        super.containerTick();

        this.updateWidgetVisibility();
    }

    private void updateWidgetVisibility() {
        boolean modify = this.isModifyMode();
        boolean busy = this.menu.isBusy();
        Ship ship = this.getShip();
        boolean shipPresent = ship != null;

        // a running job belongs to one tab: switching away mid task would
        // hide the progress bar the player is waiting on
        this.buildTab.active = !busy;
        this.modifyTab.active = shipPresent && !busy;
        this.modifyTab.selected = modify;
        this.buildTab.selected = !modify;
        this.modifyTab.setTooltip(shipPresent || busy ? null
                : net.minecraft.client.gui.components.Tooltip.create(Component.translatable("gui.smallships.dockyard.tab.no_ship")));

        boolean multipleTypes = ShipRegistry.getBuildable().size() > 1;
        this.prevShipButton.visible = !modify;
        this.nextShipButton.visible = !modify;
        this.prevShipButton.active = multipleTypes && !busy;
        this.nextShipButton.active = multipleTypes && !busy;

        this.sailToggleButton.visible = !modify && this.getOrCreatePreviewShip() instanceof Sailable;

        // while the dockyard works, nothing may be started on top of it
        this.buildButton.visible = !modify;
        this.buildButton.active = !busy && this.canAffordSelection();
        this.woodDropdown.visible = !modify;
        this.woodDropdown.active = !busy;
        if (modify || busy) this.woodDropdown.close();
        this.materialList.visible = !modify;

        this.upgradeList.visible = modify;
        this.applyButton.visible = modify;
        this.nameField.visible = modify;
        this.repairHullButton.visible = modify;
        this.repairSailsButton.visible = modify;

        if (!modify || ship == null) {
            this.applyButton.active = false;
            this.repairHullButton.active = false;
            this.repairSailsButton.active = false;
            this.ghostCannonSlot = -1;
            return;
        }

        String signature = this.buildOptionSignature(ship);
        if (!signature.equals(this.optionSignature)) {
            this.optionSignature = signature;
            this.rebuildOptions(ship);
        }
        if (!this.nameField.isFocused()) {
            String name = ship.hasCustomName() && ship.getCustomName() != null ? ship.getCustomName().getString() : "";
            if (!name.equals(this.nameField.getValue())) this.nameField.setValue(name);
        }
        this.nameField.setHint(ship.getType().getDescription());

        this.applyButton.active = !busy && !this.selectedRows.isEmpty() && this.canAffordRowSelection();
        this.applyButton.setTooltip(this.selectedRows.isEmpty() ? null
                : net.minecraft.client.gui.components.Tooltip.create(this.buildCostSummary()));

        this.repairHullButton.update(ship, true, false, busy, this.menu.getPlayer());
        this.repairSailsButton.update(ship, false, true, busy, this.menu.getPlayer());
    }

    private Component buildCostSummary() {
        net.minecraft.network.chat.MutableComponent summary = Component.translatable("gui.smallships.dockyard.total_cost");
        for (ItemStack cost : this.getSelectionCosts()) {
            summary.append(Component.literal("\n" + cost.getCount() + "x ")).append(cost.getHoverName());
        }
        return summary;
    }

    /* ---------------- input ---------------- */

    /**
     * The widget the left button went down on, kept for the whole drag.
     *
     * Focus alone is not enough to find it again: a list returns false from
     * mouseClicked when the press landed on its scrollbar rather than on a
     * row, so it never becomes the focused child - and the scrollbar could
     * then never be dragged.
     */
    @Nullable private GuiEventListener draggedChild;

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        boolean handled = super.mouseClicked(mouseX, mouseY, button);
        if (button == 0) {
            this.draggedChild = handled ? this.getFocused() : this.getChildAt(mouseX, mouseY).orElse(null);
        }
        return handled;
    }

    /**
     * AbstractContainerScreen swallows every drag for its quick craft logic and
     * never delegates to the widgets. This container has no item slots at all,
     * so the drag is handed to the widget the press started on - without it the
     * preview could not be turned and the scrollbars could not be dragged.
     */
    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
        return button == 0 && this.draggedChild != null
                && this.draggedChild.mouseDragged(mouseX, mouseY, button, dragX, dragY);
    }

    /** See mouseDragged: same reason, the slot release logic has nothing to do here. */
    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        GuiEventListener child = this.draggedChild;
        this.draggedChild = null;
        this.setDragging(false);
        return button == 0 && child != null && child.mouseReleased(mouseX, mouseY, button);
    }

    /**
     * While the name is being typed, the inventory key has to produce a letter
     * instead of closing the screen. Only ESC still gets through.
     */
    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (this.nameField != null && this.nameField.isFocused() && keyCode != 256) {
            return this.nameField.keyPressed(keyCode, scanCode, modifiers) || this.nameField.canConsumeInput();
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    /** A last chance to persist the name: the player may just close the screen while typing. */
    @Override
    public void onClose() {
        if (this.nameField != null && this.nameField.isFocused()) this.sendRename();
        super.onClose();
    }

    /* ---------------- rendering ---------------- */

    @Override
    protected void renderBg(@NotNull GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        GuiCompat.blitWindow(guiGraphics, BACKGROUND, this.leftPos, this.topPos, WINDOW_W, WINDOW_H, TEXTURE_SIZE);

        boolean modify = this.isModifyMode();
        Ship displayed = this.getDisplayedShip();

        // the model itself: drawn as part of the background so the arrow
        // buttons and the caption stay readable on top of it
        this.preview.renderPreview(guiGraphics, displayed, modify);

        this.renderPreviewCaption(guiGraphics, modify);
        ShipStatPanel.render(guiGraphics, this.font, this.x(STATS_X + 3), this.y(STATS_Y + 3), STATS_W - 6,
                modify ? this.getShip() : null, displayed);
        if (!modify) this.renderAboutText(guiGraphics);
        this.renderProgressBar(guiGraphics);
    }

    /** Ship type above the preview - in modify mode the name field sits to its left. */
    private void renderPreviewCaption(GuiGraphics guiGraphics, boolean modify) {
        Component typeName;
        if (modify) {
            Ship ship = this.getShip();
            typeName = ship != null ? ship.getType().getDescription() : Component.empty();
        } else {
            typeName = this.selectedShipType != null ? this.selectedShipType.getDisplayName()
                    : Component.translatable("gui.smallships.dockyard.no_ship_type");
        }
        // keep clear of the sail toggle button in the top right corner
        guiGraphics.drawString(this.font, typeName,
                this.x(PREVIEW_X + PREVIEW_W - 18) - this.font.width(typeName), this.y(PREVIEW_Y + 2), COLOR_TEXT, false);
    }

    /** Center panel below the preview: the ship types' flavour text in build mode. */
    private void renderAboutText(GuiGraphics guiGraphics) {
        if (this.selectedShipType == null) return;

        List<FormattedCharSequence> lines = this.font.split(
                Component.translatable(aboutKey(this.selectedShipType)), CENTER_W - 8);
        int line = this.y(CENTER_Y + 4);
        int limit = this.y(CENTER_Y + CENTER_H - 4);
        for (FormattedCharSequence sequence : lines) {
            if (line + 9 > limit) break;
            guiGraphics.drawString(this.font, sequence, this.x(CENTER_X + 4), line, COLOR_MUTED, false);
            line += 10;
        }
    }

    /**
     * The work indicator: it sits on the lower edge of the preview area, so
     * every task - build, modify, repair - reports in the same place.
     */
    private void renderProgressBar(GuiGraphics guiGraphics) {
        if (!this.menu.isBusy() || this.menu.getTotalTime() <= 0) return;

        int barX = this.x(PREVIEW_X + 2);
        int barY = this.y(PREVIEW_Y + PREVIEW_H - PROGRESS_H - 2);
        int barWidth = PREVIEW_W - 4;
        float progress = Mth.clamp((float) this.menu.getProgress() / (float) this.menu.getTotalTime(), 0.0F, 1.0F);

        guiGraphics.fill(barX, barY, barX + barWidth, barY + PROGRESS_H, 0xFF15151A);
        guiGraphics.fill(barX + 1, barY + 1, barX + 1 + (int) ((barWidth - 2) * progress), barY + PROGRESS_H - 1, FRAME_INSTALLED);
        Component working = Component.translatable("gui.smallships.dockyard.working");
        guiGraphics.drawString(this.font, working, barX + barWidth / 2 - this.font.width(working) / 2, barY + 1, 0xFFFFFFFF, false);
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        // reset before the lists render: they set it again while drawing the
        // hovered row, one frame late would make the ghost cannon flicker
        this.ghostCannonSlot = -1;
        super.render(guiGraphics, mouseX, mouseY, partialTick);

        // the dropdown popup overlaps the list and the button, so it is drawn
        // after every other widget - it is a child, not a renderable
        this.woodDropdown.renderDropdown(guiGraphics, mouseX, mouseY);

        List<Component> lines = this.upgradeList.visible ? this.upgradeList.getHoveredTooltip() : null;
        if (lines != null) {
            guiGraphics.renderComponentTooltip(this.font, lines, mouseX, mouseY);
            return;
        }
        ItemStack hovered = this.woodDropdown.getHoveredStack(mouseX, mouseY);
        if (hovered.isEmpty() && this.materialList.visible) hovered = this.materialList.getHoveredStack();
        if (!hovered.isEmpty()) {
            guiGraphics.renderTooltip(this.font, hovered, mouseX, mouseY);
        }
    }

    /**
     * The window draws its own captions from the background texture, and there
     * is no player inventory grid in this container - so the vanilla title and
     * "Inventory" labels would just print on top of it.
     */
    @Override
    protected void renderLabels(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY) {
    }

    /* ---------------- widgets ---------------- */

    /**
     * A header tab in the creative inventory position, drawn from the vanilla
     * button sprites: the selected tab uses the highlighted face, so it reads
     * as raised out of the strip without a single hand drawn pixel.
     */
    private static class TabButton extends Button {
        private boolean selected;

        protected TabButton(int x, int y, Component label, OnPress onPress) {
            super(x, y, TAB_W, TAB_STRIP_H, label, onPress, DEFAULT_NARRATION);
        }

        @Override
        protected void renderWidget(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
            GuiCompat.blitButton(guiGraphics, this.getX(), this.getY(), this.getWidth(), this.getHeight(),
                    this.active, this.selected || this.isHoveredOrFocused());
            int textColor = !this.active ? 0xFF6E6E6E : (this.selected ? 0xFFFFFFFF : 0xFFCCCCCC);
            guiGraphics.drawCenteredString(net.minecraft.client.Minecraft.getInstance().font, this.getMessage(),
                    this.getX() + this.getWidth() / 2, this.getY() + (this.getHeight() - 8) / 2, textColor);
        }
    }

    /**
     * The ship name, editable in place. Transparent: the frame around it is
     * already part of the preview panel, a second one would only add noise.
     * The rename is sent on focus loss, not on every keystroke.
     */
    private class NameField extends EditBox {
        protected NameField(int x, int y, int width, int height) {
            super(DockyardScreen.this.font, x, y, width, height, Component.translatable("gui.smallships.dockyard.ship_name"));
            this.setBordered(false);
            this.setMaxLength(ServerboundDockyardRenamePacket.MAX_NAME_LENGTH);
            this.setTextColor(0xFFAA33);
        }

        @Override
        public void setFocused(boolean focused) {
            boolean wasFocused = this.isFocused();
            super.setFocused(focused);
            if (wasFocused && !focused) DockyardScreen.this.sendRename();
        }
    }

    /**
     * One of the two repair buttons. It shows the material it needs as an icon
     * so the row reads at a glance; what it ACTUALLY costs depends on how badly
     * the ship is beaten up and only shows in the tooltip.
     */
    private class RepairButton extends Button {
        private final ItemStack icon;

        protected RepairButton(int x, int y, int width, ItemStack icon, Component label, OnPress onPress) {
            super(x, y, width, 20, label, onPress, DEFAULT_NARRATION);
            this.icon = icon;
        }

        /** Recomputes cost tooltip and enabled state from the current damage. */
        public void update(Ship ship, boolean hull, boolean sails, boolean busy, @Nullable Player player) {
            List<DockyardRecipe.Ingredient> costs = DockyardBlockEntity.getRepairCosts(ship, hull, sails);
            if (costs.isEmpty()) {
                // nothing damaged on this half - say so instead of greying out
                // a button with no explanation
                this.setTooltip(net.minecraft.client.gui.components.Tooltip.create(
                        Component.translatable("gui.smallships.dockyard.no_damage")));
                this.active = false;
                return;
            }
            net.minecraft.network.chat.MutableComponent costLine = Component.translatable("gui.smallships.dockyard.repair_cost");
            boolean afford = true;
            for (DockyardRecipe.Ingredient cost : costs) {
                ItemStack display = cost.getDisplayStack(Boat.Type.OAK);
                costLine.append(Component.literal("\n" + cost.amount() + "x ")).append(display.getHoverName());
                if (player != null && !player.hasInfiniteMaterials() && cost.countIn(player) < cost.amount()) afford = false;
            }
            this.setTooltip(net.minecraft.client.gui.components.Tooltip.create(costLine));
            this.active = !busy && afford;
        }

        @Override
        protected void renderWidget(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
            GuiCompat.blitButton(guiGraphics, this.getX(), this.getY(), this.getWidth(), this.getHeight(),
                    this.active, this.isHoveredOrFocused());
            guiGraphics.renderItem(this.icon, this.getX() + 3, this.getY() + 2);
            int textColor = this.active ? 0xFFFFFFFF : 0xFF9A9A9A;
            guiGraphics.drawString(DockyardScreen.this.font,
                    DockyardScreen.this.font.plainSubstrByWidth(this.getMessage().getString(), this.getWidth() - 26),
                    this.getX() + 22, this.getY() + 6, textColor, false);
        }
    }

    /**
     * The ship preview. The model does NOT rotate on its own - the player turns
     * it with left click + drag, zooms with the wheel and resets it with a
     * double click. Everything is clipped to the preview frame, so a long hull
     * or a tall mast can never bleed into the panels next to it.
     */
    private class ShipPreview extends AbstractWidget {
        /** degrees of rotation per pixel dragged */
        private static final float DRAG_SENSITIVITY = 1.5F;
        /** the model is never turned further than this, or it ends up upside down */
        private static final float PITCH_LIMIT = 80.0F;
        private static final float ZOOM_MIN = 0.4F;
        private static final float ZOOM_MAX = 3.0F;
        private static final float ZOOM_DEFAULT = 0.65F;
        private static final float DEFAULT_YAW = -150.0F;
        private static final float DEFAULT_PITCH = -12.0F;
        /**
         * Where the models' own origin sits inside the frame. A ship pivots
         * around its waterline, not around its centre of volume, so anchoring
         * it in the middle leaves the hull hanging in the upper half with all
         * the empty air below it. Three quarters down puts the deck where the
         * eye expects it and gives the masts the room they need.
         */
        private static final float PIVOT_Y_FRACTION = 0.75F;
        /** two clicks within this many milliseconds count as a double click */
        private static final long DOUBLE_CLICK_MS = 250L;

        private float yaw = DEFAULT_YAW;
        private float pitch = DEFAULT_PITCH;
        private float zoom = ZOOM_DEFAULT;
        private long lastClickTime;

        protected ShipPreview(int x, int y, int width, int height) {
            super(x, y, width, height, Component.empty());
        }

        public void reset() {
            this.yaw = DEFAULT_YAW;
            this.pitch = DEFAULT_PITCH;
            this.zoom = ZOOM_DEFAULT;
        }

        /** grabbing the model is not a button press, so it stays silent */
        @Override
        public void playDownSound(@NotNull net.minecraft.client.sounds.SoundManager soundManager) {
        }

        @Override
        public void onClick(double mouseX, double mouseY) {
            long now = net.minecraft.Util.getMillis();
            if (now - this.lastClickTime < DOUBLE_CLICK_MS) this.reset();
            this.lastClickTime = now;
        }

        @Override
        protected void onDrag(double mouseX, double mouseY, double dragX, double dragY) {
            // dragging down has to tip the bow towards the player, so the
            // vertical axis runs against the raw mouse delta
            this.yaw += (float) dragX * DRAG_SENSITIVITY;
            this.pitch = Mth.clamp(this.pitch - (float) dragY * DRAG_SENSITIVITY, -PITCH_LIMIT, PITCH_LIMIT);
        }

        @Override
        public boolean mouseScrolled(double mouseX, double mouseY, double scrollX, double scrollY) {
            if (!this.isMouseOver(mouseX, mouseY)) return false;
            this.zoom = Mth.clamp(this.zoom + (float) scrollY * 0.15F, ZOOM_MIN, ZOOM_MAX);
            return true;
        }

        /**
         * Draws the ship into the frame. Called from renderBg, not as a
         * renderable: the arrow buttons have to sit on top of the model.
         *
         * The hovered cannon is projected by flipping its slot on for the
         * duration of this ONE draw call and off again right after. The world
         * has already been rendered by the time the screen draws, so the ghost
         * exists inside the GUI frame only - and the shared ShipRenderer puts
         * it exactly where the real gun would sit, without a second copy of
         * that math living in the GUI.
         */
        public void renderPreview(GuiGraphics guiGraphics, @Nullable Ship ship, boolean modify) {
            if (ship == null || DockyardScreen.this.minecraft == null) return;

            int ghostSlot = modify ? DockyardScreen.this.ghostCannonSlot : -1;
            boolean ghosting = ghostSlot >= 0 && ship instanceof Cannonable cannonable && !cannonable.isCannonInSlot(ghostSlot);
            if (ghosting) ((Cannonable) ship).setCannonInSlot(ghostSlot, true);

            int centerX = this.getX() + this.getWidth() / 2;
            int centerY = this.getY() + (int) (this.getHeight() * PIVOT_Y_FRACTION);
            // fit the hull into the frame once, the player takes it from there
            float fit = this.getHeight() * 0.40F / Math.max(1.0F, ship.getBbWidth());
            float scale = fit * this.zoom;

            guiGraphics.enableScissor(this.getX(), this.getY(), this.getX() + this.getWidth(), this.getY() + this.getHeight());
            guiGraphics.pose().pushPose();
            guiGraphics.pose().translate(centerX, centerY, 100.0F);
            guiGraphics.pose().scale(scale, scale, -scale);
            guiGraphics.pose().mulPose(new Quaternionf()
                    .rotateZ((float) Math.PI)
                    .rotateX(this.pitch * Mth.DEG_TO_RAD)
                    .rotateY(this.yaw * Mth.DEG_TO_RAD));

            Lighting.setupForEntityInInventory();
            var dispatcher = DockyardScreen.this.minecraft.getEntityRenderDispatcher();
            dispatcher.setRenderShadow(false);
            MultiBufferSource.BufferSource bufferSource = DockyardScreen.this.minecraft.renderBuffers().bufferSource();
            dispatcher.render(ship, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F, guiGraphics.pose(), bufferSource, 15728880);
            bufferSource.endBatch();
            dispatcher.setRenderShadow(true);
            Lighting.setupFor3DItems();

            guiGraphics.pose().popPose();
            guiGraphics.disableScissor();

            if (ghosting) ((Cannonable) ship).setCannonInSlot(ghostSlot, false);
        }

        @Override
        protected void renderWidget(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        }

        @Override
        protected void updateWidgetNarration(@NotNull NarrationElementOutput narrationElementOutput) {
        }
    }

    /**
     * The material list of the selected ship. One row per ingredient with the
     * item icon, the amount and the name; the name turns green as soon as the
     * player carries enough of it. Hovering a row shows the full item tooltip.
     */
    private class MaterialList extends AbstractSelectionList<MaterialList.Entry> {
        private static final int ROW_HEIGHT = 20;
        /**
         * How much narrower a row is than the list. AbstractSelectionList hit
         * tests rows CENTERED on the list (getEntryAtPosition is final and
         * cannot be overridden), so the rows have to keep the same margin left
         * and right - half of this on each side. Anything else and the clicks
         * land next to what is drawn.
         */
        private static final int ROW_INSET = 12;
        /** the vanilla scrollbar is 6 wide and sits right of the rows */
        private static final int SCROLLBAR_LANE = 8;

        private ItemStack hoveredStack = ItemStack.EMPTY;

        protected MaterialList(int x, int y, int width, int height) {
            super(net.minecraft.client.Minecraft.getInstance(), width, height, y, ROW_HEIGHT);
            this.setX(x);
            this.centerListVertically = false;
        }

        /** The panel frame comes from the background texture, so the list draws none. */
        @Override
        protected void renderListBackground(@NotNull GuiGraphics guiGraphics) {
        }

        @Override
        protected void renderListSeparators(@NotNull GuiGraphics guiGraphics) {
        }

        @Override
        public int getRowWidth() {
            return this.getWidth() - ROW_INSET;
        }

        @Override
        protected int getScrollbarPosition() {
            return this.getX() + this.getWidth() - SCROLLBAR_LANE;
        }

        /**
         * AbstractSelectionList reports "mouse is over me" from its bounds
         * alone, without asking whether it is visible. Both lists share the
         * same rectangle, so the hidden one would otherwise swallow every
         * click and every wheel tick meant for the one on screen.
         *
         * The LIST_OVERHANG strip on the left is only there to shift the
         * centered rows; it is not part of the panel and must not react.
         */
        @Override
        public boolean isMouseOver(double mouseX, double mouseY) {
            return this.visible && mouseX >= this.getX() + LIST_OVERHANG && super.isMouseOver(mouseX, mouseY);
        }

        @Override
        protected void updateWidgetNarration(@NotNull NarrationElementOutput narrationElementOutput) {
        }

        public ItemStack getHoveredStack() {
            return this.hoveredStack;
        }

        public void rebuild(@Nullable ShipType shipType, Boat.Type wood) {
            this.clearEntries();
            this.setScrollAmount(0.0D);
            if (shipType == null) return;

            DockyardRecipe recipe = DockyardRecipeManager.get(shipType);
            for (DockyardRecipe.Ingredient ingredient : recipe.ingredients()) {
                this.addEntry(new Entry(ingredient, ingredient.getDisplayStack(wood)));
            }
        }

        @Override
        public void renderWidget(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
            this.hoveredStack = ItemStack.EMPTY;
            super.renderWidget(guiGraphics, mouseX, mouseY, partialTick);
        }

        private class Entry extends AbstractSelectionList.Entry<Entry> {
            private final DockyardRecipe.Ingredient ingredient;
            private final ItemStack displayStack;

            private Entry(DockyardRecipe.Ingredient ingredient, ItemStack displayStack) {
                this.ingredient = ingredient;
                this.displayStack = displayStack;
            }

            @Override
            public void render(@NotNull GuiGraphics guiGraphics, int index, int top, int left, int width, int height,
                               int mouseX, int mouseY, boolean hovering, float partialTick) {
                Player player = DockyardScreen.this.menu.getPlayer();
                boolean has = player == null || player.hasInfiniteMaterials()
                        || this.ingredient.countIn(player) >= this.ingredient.amount();

                guiGraphics.renderItem(this.displayStack, left, top + 1);
                // the name is clipped, never wrapped: a row stays one line high
                String label = this.ingredient.amount() + "x " + this.displayStack.getHoverName().getString();
                guiGraphics.drawString(DockyardScreen.this.font,
                        DockyardScreen.this.font.plainSubstrByWidth(label, width - 22),
                        left + 20, top + 5, has ? COLOR_HAS : COLOR_MISSING, false);

                if (hovering) MaterialList.this.hoveredStack = this.displayStack;
            }
        }
    }

    /**
     * The modify list: stat upgrades, cannon carriages, banners and sail dyes,
     * all in one scrollable column.
     *
     * The frame color says what the ship will look like AFTER the apply:
     * green = mounted, grey = not mounted, red = mounted but ticked for
     * removal. A ticked row also gets a lit background, so "installed" and
     * "about to be installed" stay distinguishable even though both are green.
     */
    private class UpgradeList extends AbstractSelectionList<UpgradeList.Entry> {
        private static final int ROW_HEIGHT = 22;
        /** see MaterialList.ROW_INSET - the rows are centered, not left aligned */
        private static final int ROW_INSET = 12;
        private static final int SCROLLBAR_LANE = 8;

        @Nullable private List<Component> hoveredTooltip;

        protected UpgradeList(int x, int y, int width, int height) {
            super(net.minecraft.client.Minecraft.getInstance(), width, height, y, ROW_HEIGHT);
            this.setX(x);
            this.centerListVertically = false;
        }

        @Override
        protected void renderListBackground(@NotNull GuiGraphics guiGraphics) {
        }

        @Override
        protected void renderListSeparators(@NotNull GuiGraphics guiGraphics) {
        }

        @Override
        public int getRowWidth() {
            return this.getWidth() - ROW_INSET;
        }

        @Override
        protected int getScrollbarPosition() {
            return this.getX() + this.getWidth() - SCROLLBAR_LANE;
        }

        /**
         * AbstractSelectionList reports "mouse is over me" from its bounds
         * alone, without asking whether it is visible. Both lists share the
         * same rectangle, so the hidden one would otherwise swallow every
         * click and every wheel tick meant for the one on screen.
         *
         * The LIST_OVERHANG strip on the left is only there to shift the
         * centered rows; it is not part of the panel and must not react.
         */
        @Override
        public boolean isMouseOver(double mouseX, double mouseY) {
            return this.visible && mouseX >= this.getX() + LIST_OVERHANG && super.isMouseOver(mouseX, mouseY);
        }

        @Override
        protected void updateWidgetNarration(@NotNull NarrationElementOutput narrationElementOutput) {
        }

        @Nullable
        public List<Component> getHoveredTooltip() {
            return this.hoveredTooltip;
        }

        /** Keeps the scroll position: the rows are rebuilt while the player reads them. */
        public void rebuild(List<UpgradeOption> options) {
            double scroll = this.getScrollAmount();
            this.clearEntries();
            for (UpgradeOption option : options) this.addEntry(new Entry(option));
            this.setScrollAmount(scroll);
        }

        @Override
        public void renderWidget(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
            this.hoveredTooltip = null;
            super.renderWidget(guiGraphics, mouseX, mouseY, partialTick);
        }

        private class Entry extends AbstractSelectionList.Entry<Entry> {
            private final UpgradeOption option;

            private Entry(UpgradeOption option) {
                this.option = option;
            }

            private boolean isSelected() {
                return DockyardScreen.this.selectedRows.contains(this.option.action.key());
            }

            @Override
            public boolean mouseClicked(double mouseX, double mouseY, int button) {
                if (button != 0 || DockyardScreen.this.menu.isBusy()) return false;
                String key = this.option.action.key();
                if (!DockyardScreen.this.selectedRows.remove(key)) DockyardScreen.this.selectedRows.add(key);
                net.minecraft.client.Minecraft.getInstance().getSoundManager().play(
                        net.minecraft.client.resources.sounds.SimpleSoundInstance.forUI(
                                net.minecraft.sounds.SoundEvents.UI_BUTTON_CLICK, 1.0F));
                return true;
            }

            @Override
            public void render(@NotNull GuiGraphics guiGraphics, int index, int top, int left, int width, int height,
                               int mouseX, int mouseY, boolean hovering, float partialTick) {
                boolean selected = this.isSelected();
                // the frame describes the state AFTER the apply, so a ticked
                // removal is the only thing that ever turns red
                int frame = this.option.installed
                        ? (selected ? FRAME_REMOVE : FRAME_INSTALLED)
                        : (selected ? FRAME_INSTALLED : FRAME_EMPTY);

                int rowHeight = height - 2;
                if (selected) guiGraphics.fill(left, top, left + width, top + rowHeight, 0x33FFFFFF);
                else if (hovering) guiGraphics.fill(left, top, left + width, top + rowHeight, 0x22FFFFFF);
                GuiCompat.frame(guiGraphics, left, top, width, rowHeight, frame);

                guiGraphics.renderItem(this.option.icon, left + 2, top + 2);
                guiGraphics.drawString(DockyardScreen.this.font,
                        DockyardScreen.this.font.plainSubstrByWidth(this.option.name.getString(), width - 24),
                        left + 22, top + 6, COLOR_TEXT, false);

                if (hovering) {
                    UpgradeList.this.hoveredTooltip = this.option.tooltip;
                    // the projected gun only exists inside the preview frame
                    if (this.option.action.kind() == DockyardAction.Kind.CANNON) {
                        DockyardScreen.this.ghostCannonSlot = this.option.action.index();
                    }
                }
            }
        }
    }

    /**
     * The wood type picker next to the build button: a narrow icon button that
     * opens a small grid of plank icons. Icons only - the names would make the
     * popup far wider than the panel it has to fit into.
     */
    private class WoodDropdown extends AbstractWidget {
        private static final int BUTTON_W = 24;
        private static final int BUTTON_H = 20;
        private static final int CELL = 20;
        private static final int COLUMNS = 3;

        private boolean open;

        protected WoodDropdown(int x, int y) {
            super(x, y, BUTTON_W, BUTTON_H, Component.empty());
        }

        public void close() {
            this.open = false;
        }

        private int rows() {
            return Mth.positiveCeilDiv(Boat.Type.values().length, COLUMNS);
        }

        private int popupWidth() {
            return COLUMNS * CELL + 2;
        }

        private int popupHeight() {
            return this.rows() * CELL + 2;
        }

        /** the popup opens upwards and is right aligned to the button */
        private int popupX() {
            return this.getX() + this.getWidth() - this.popupWidth();
        }

        private int popupY() {
            return this.getY() - this.popupHeight() - 1;
        }

        private boolean isOverPopup(double mouseX, double mouseY) {
            return this.open && mouseX >= this.popupX() && mouseX < this.popupX() + this.popupWidth()
                    && mouseY >= this.popupY() && mouseY < this.popupY() + this.popupHeight();
        }

        /** the open popup is part of the clickable area, otherwise it would close under the cursor */
        @Override
        protected boolean clicked(double mouseX, double mouseY) {
            return super.clicked(mouseX, mouseY) || this.isOverPopup(mouseX, mouseY);
        }

        @Override
        public boolean isMouseOver(double mouseX, double mouseY) {
            return super.isMouseOver(mouseX, mouseY) || this.isOverPopup(mouseX, mouseY);
        }

        @Override
        public void onClick(double mouseX, double mouseY) {
            if (this.isOverPopup(mouseX, mouseY)) {
                int column = (int) ((mouseX - this.popupX() - 1) / CELL);
                int row = (int) ((mouseY - this.popupY() - 1) / CELL);
                int index = row * COLUMNS + column;
                if (column >= 0 && column < COLUMNS && index >= 0 && index < Boat.Type.values().length) {
                    DockyardScreen.this.setWoodType(Boat.Type.values()[index]);
                }
                this.open = false;
                return;
            }
            this.open = !this.open;
        }

        @Override
        protected void renderWidget(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        }

        /** Drawn from the screen after every other widget so the popup is on top. */
        public void renderDropdown(GuiGraphics guiGraphics, int mouseX, int mouseY) {
            if (!this.visible) return;

            GuiCompat.blitButton(guiGraphics, this.getX(), this.getY(), this.getWidth(), this.getHeight(),
                    this.active, super.isMouseOver(mouseX, mouseY));
            guiGraphics.renderItem(new ItemStack(DockyardRecipe.plankItemOf(DockyardScreen.this.woodType)),
                    this.getX() + 4, this.getY() + 2);
            if (!this.open) return;

            int popupX = this.popupX();
            int popupY = this.popupY();
            GuiCompat.blitButton(guiGraphics, popupX, popupY, this.popupWidth(), this.popupHeight(), true, false);

            Boat.Type[] types = Boat.Type.values();
            for (int i = 0; i < types.length; i++) {
                int cellX = popupX + 1 + (i % COLUMNS) * CELL;
                int cellY = popupY + 1 + (i / COLUMNS) * CELL;
                if (types[i] == DockyardScreen.this.woodType) {
                    guiGraphics.fill(cellX, cellY, cellX + CELL, cellY + CELL, 0x8055B14C);
                } else if (mouseX >= cellX && mouseX < cellX + CELL && mouseY >= cellY && mouseY < cellY + CELL) {
                    guiGraphics.fill(cellX, cellY, cellX + CELL, cellY + CELL, 0x55FFFFFF);
                }
                guiGraphics.renderItem(new ItemStack(DockyardRecipe.plankItemOf(types[i])), cellX + 2, cellY + 2);
            }
        }

        /** @return the plank stack under the cursor, so the screen can show its tooltip. */
        public ItemStack getHoveredStack(int mouseX, int mouseY) {
            if (!this.visible) return ItemStack.EMPTY;
            if (!this.open) {
                return super.isMouseOver(mouseX, mouseY)
                        ? new ItemStack(DockyardRecipe.plankItemOf(DockyardScreen.this.woodType)) : ItemStack.EMPTY;
            }
            Boat.Type[] types = Boat.Type.values();
            for (int i = 0; i < types.length; i++) {
                int cellX = this.popupX() + 1 + (i % COLUMNS) * CELL;
                int cellY = this.popupY() + 1 + (i / COLUMNS) * CELL;
                if (mouseX >= cellX && mouseX < cellX + CELL && mouseY >= cellY && mouseY < cellY + CELL) {
                    return new ItemStack(DockyardRecipe.plankItemOf(types[i]));
                }
            }
            return ItemStack.EMPTY;
        }

        @Override
        protected void updateWidgetNarration(@NotNull NarrationElementOutput narrationElementOutput) {
        }
    }
}