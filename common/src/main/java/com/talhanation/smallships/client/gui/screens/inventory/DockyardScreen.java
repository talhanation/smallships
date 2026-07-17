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

    public DockyardScreen(DockyardMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
        this.imageWidth = 236;
        this.imageHeight = 200;
    }

    @Override
    protected void init() {
        super.init();
        this.upgradeButtons.clear();

        int left = this.leftPos;
        int top = this.topPos;

        this.shipTypeButton = this.addRenderableWidget(Button.builder(this.getShipTypeText(), button -> {
            this.selectedShipType = DockyardRecipe.ShipType.byId((this.selectedShipType.id + 1) % DockyardRecipe.ShipType.values().length);
            button.setMessage(this.getShipTypeText());
        }).bounds(left + 8, top + 18, 90, 20).build());

        this.woodTypeButton = this.addRenderableWidget(Button.builder(this.getWoodTypeText(), button -> {
            this.woodTypeIndex = (this.woodTypeIndex + 1) % Boat.Type.values().length;
            button.setMessage(this.getWoodTypeText());
        }).bounds(left + 8, top + 42, 90, 20).build());

        this.buildButton = this.addRenderableWidget(Button.builder(Component.translatable("gui.smallships.dockyard.build"), button ->
                ModPackets.clientSendPacket(new ServerboundDockyardBuildPacket(this.menu.getDockyardPos(), this.selectedShipType.id, this.woodTypeIndex))
        ).bounds(left + 8, top + this.imageHeight - 30, 90, 20).build());

        this.repairButton = this.addRenderableWidget(Button.builder(Component.translatable("gui.smallships.dockyard.repair"), button ->
                ModPackets.clientSendPacket(new ServerboundDockyardRepairPacket(this.menu.getDockyardPos()))
        ).bounds(left + 8, top + this.imageHeight - 30, 120, 20).build());

        // upgrade buttons (modify mode)
        ShipUpgrade[] upgrades = ShipUpgrade.values();
        for (int i = 0; i < upgrades.length; i++) {
            ShipUpgrade upgrade = upgrades[i];
            UpgradeButton upgradeButton = new UpgradeButton(left + 8 + i * 26, top + 70, upgrade, button ->
                    this.onUpgradeClicked(upgrade));
            this.upgradeButtons.add(this.addRenderableWidget(upgradeButton));
        }

        // cannon slot buttons (modify mode, dockyard-only cannon mounting)
        this.cannonSlotButtons.clear();
        for (int slot = 0; slot < 6; slot++) {
            final int s = slot;
            CannonSlotButton slotButton = new CannonSlotButton(left + 8 + slot * 24, top + 100, slot, button ->
                    this.onCannonSlotClicked(s));
            this.cannonSlotButtons.add(this.addRenderableWidget(slotButton));
        }

        // style bar: dyes and banners detected in the player inventory
        this.styleButtons.clear();
        for (int i = 0; i < 8; i++) {
            StyleButton styleButton = new StyleButton(left + 8 + i * 24, top + 124, button -> {
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

    private boolean isModifyMode() {
        return this.getShip() != null;
    }

    @Override
    public void containerTick() {
        super.containerTick();
        boolean modify = this.isModifyMode();
        boolean busy = this.menu.isBusy();

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

    @Override
    protected void renderBg(@NotNull GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        int left = this.leftPos;
        int top = this.topPos;

        // simple drawn background (no texture dependency)
        guiGraphics.fill(left, top, left + this.imageWidth, top + this.imageHeight, 0xEE2B2B2B);
        guiGraphics.fill(left + 1, top + 1, left + this.imageWidth - 1, top + this.imageHeight - 1, 0xEE3F3F3F);
        guiGraphics.drawString(this.font, this.title, left + 8, top + 6, 0xFFFFFF, false);

        Ship ship = this.getShip();
        if (ship != null) {
            // ship preview (modify mode)
            this.renderShipPreview(guiGraphics, ship, left + this.imageWidth - 66, top + 92, mouseX, mouseY);
            guiGraphics.drawString(this.font, ship.getDisplayName(), left + 8, top + 22, 0xFFFF88, false);
            guiGraphics.drawString(this.font, Component.translatable("gui.smallships.dockyard.modify_hint"), left + 8, top + 36, 0xAAAAAA, false);
        } else {
            // build mode: render a dummy ship of the selected type and wood
            this.renderBuildPreview(guiGraphics, left + this.imageWidth - 66, top + 92, mouseX, mouseY);
            // material list (build mode)
            List<ItemStack> materials = DockyardRecipe.getDisplayStacks(this.selectedShipType, Boat.Type.values()[this.woodTypeIndex]);
            List<DockyardRecipe.Ingredient> ingredients = DockyardRecipe.getIngredients(this.selectedShipType);
            int y = top + 70;
            for (int i = 0; i < materials.size(); i++) {
                ItemStack stack = materials.get(i);
                DockyardRecipe.Ingredient ingredient = ingredients.get(i);
                boolean has = this.menu.getPlayer() == null || ingredient.countIn(this.menu.getPlayer()) >= ingredient.amount() || this.menu.getPlayer().hasInfiniteMaterials();
                guiGraphics.renderItem(stack, left + 10, y);
                guiGraphics.drawString(this.font,
                        Component.literal(ingredient.amount() + "x ").append(stack.getHoverName()).withStyle(has ? ChatFormatting.GREEN : ChatFormatting.RED),
                        left + 30, y + 4, 0xFFFFFF, false);
                y += 20;
            }
        }

        // progress bar
        if (this.menu.isBusy() && this.menu.getTotalTime() > 0) {
            int barX = left + 8;
            int barY = top + this.imageHeight - 46;
            int barWidth = this.imageWidth - 16;
            float progress = (float) this.menu.getProgress() / (float) this.menu.getTotalTime();
            guiGraphics.fill(barX, barY, barX + barWidth, barY + 8, 0xFF1B1B1B);
            guiGraphics.fill(barX, barY, barX + (int) (barWidth * Math.min(1.0F, progress)), barY + 8, 0xFF55B14C);
            guiGraphics.drawCenteredString(this.font, Component.translatable("gui.smallships.dockyard.working"), left + this.imageWidth / 2, barY - 10, 0xFFFFFF);
        }
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