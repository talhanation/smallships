package com.talhanation.smallships.client.cannon;

import com.mojang.blaze3d.systems.RenderSystem;
import com.talhanation.smallships.client.gui.GuiCompat;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.network.packet.ServerboundSetCannonAmmoTypePacket;
import com.talhanation.smallships.world.entity.cannon.GroundCannonEntity;
import com.talhanation.smallships.world.entity.ship.ContainerShip;
import com.talhanation.smallships.world.item.CannonAmmoSelection;
import com.talhanation.smallships.world.item.CannonBallItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/**
 * The mouse wheel ammo picker: while aiming (ship broadside, gunner, or ground
 * cannon) the wheel cycles the cannonball type instead of the hotbar, and the
 * three types are drawn in a row beside the crosshair, the unselected ones
 * dimmed, each with the number of rounds left.
 *
 * Input and drawing live together because they are the same widget - the wheel
 * hook in MouseHandlerMixin feeds handleScroll, the platform GUI event feeds
 * render.
 *
 * Only types that can actually be fired are shown and cycled through, so the
 * wheel never stops on an empty icon. With nothing at all to fire, the plain
 * cannonball is shown with a red zero instead, so an empty locker reads as
 * empty rather than as a picker that failed to show up. The count is the one
 * the SHOT uses: the
 * player's own inventory plus the ship's hold. The hold is read from the ship's
 * synched ammo counts rather than from its stacks, since the client only ever
 * holds the open page of a multi page hold - that is what lets a gunner see the
 * rounds he is about to fire even though they are nowhere in his own inventory.
 *
 * The selection is only a PREFERENCE, stored in {@link CannonAmmoSelection}.
 * It never interrupts a gun that is already fuzing or cooling down, it only
 * changes what the NEXT trigger pulls out of the locker - which is what makes
 * "takes effect on the next reload" fall out for free, with no loaded state to
 * track.
 *
 * Hooked from the platform's own GUI render event, the same split as
 * ClientTickHandler and the platform tick events:
 * - Forge/NeoForge: RenderGuiEvent.Post, call render(event.getGuiGraphics())
 * - Fabric: HudRenderCallback.EVENT.register((guiGraphics, tickDelta) -> render(guiGraphics))
 */
public class CannonAmmoHandler {
    private static final CannonBallItem.Type[] TYPES = CannonBallItem.Type.values();
    private static final int ICON_SIZE = 16;
    private static final int ICON_GAP = 4;
    /** how dim an unselected icon is drawn - 30% opacity */
    private static final float UNSELECTED_ALPHA = 0.30F;
    /** horizontal gap between the crosshair and the first icon */
    private static final int CROSSHAIR_GAP = 12;
    private static final int COUNT_COLOR = 0xFFFFFFFF;
    /** the count of the empty default icon, see render */
    private static final int EMPTY_COUNT_COLOR = 0xFFFF5555;

    private CannonAmmoHandler() {
    }

    /**
     * @return true if the local player is aiming AND has something to
     * choose between. With nothing to pick from, the wheel is left alone so it
     * keeps doing its normal job.
     */
    public static boolean canSelectAmmo(Player player) {
        return isAiming(player) && anyAvailable(player);
    }

    private static boolean isAiming(Player player) {
        return player.getVehicle() instanceof GroundCannonEntity cannon
                ? cannon.isAiming()
                : CannonAimHandler.isAiming();
    }

    /** Cycles to the next available type and syncs it to the server. */
    public static void handleScroll(Player player, double scrollDeltaY) {
        if (scrollDeltaY == 0.0D) return;
        int direction = scrollDeltaY > 0 ? 1 : -1;

        CannonBallItem.Type next = displayed(player);
        // step over types he is out of, so the wheel never parks on an empty icon
        for (int i = 0; i < TYPES.length; i++) {
            next = TYPES[Math.floorMod(next.ordinal() + direction, TYPES.length)];
            if (available(player, next)) break;
        }
        if (!available(player, next)) return;

        CannonAmmoSelection.set(player, next);
        ModPackets.clientSendPacket(new ServerboundSetCannonAmmoTypePacket(next.id));
    }

    /**
     * @return the type to highlight: the selected one, or - if he has since run
     * out of it - the first still available. Read only, so the stored
     * selection stays put and comes back once he restocks.
     */
    private static CannonBallItem.Type displayed(Player player) {
        CannonBallItem.Type selected = CannonAmmoSelection.get(player);
        if (available(player, selected)) return selected;
        for (CannonBallItem.Type type : TYPES) {
            if (available(player, type)) return type;
        }
        return selected;
    }

    /**
     * @return how many rounds of this type can actually be fired - what the
     * player carries plus what the hold carries, the same two places the shot
     * itself draws from. Anything else would print a number the gun does not
     * agree with.
     */
    private static int count(Player player, CannonBallItem.Type type) {
        int count = 0;
        for (ItemStack itemStack : player.getInventory().items) {
            if (itemStack.getItem() instanceof CannonBallItem cannonBallItem && cannonBallItem.getType() == type) {
                count += itemStack.getCount();
            }
        }
        if (player.getVehicle() instanceof ContainerShip containerShip) {
            count += containerShip.getAmmoInHold(type);
        }
        return count;
    }

    private static boolean available(Player player, CannonBallItem.Type type) {
        return count(player, type) > 0;
    }

    private static boolean anyAvailable(Player player) {
        for (CannonBallItem.Type type : TYPES) {
            if (available(player, type)) return true;
        }
        return false;
    }

    public static void render(GuiGraphics guiGraphics) {
        Minecraft minecraft = Minecraft.getInstance();
        Player player = minecraft.player;
        if (player == null || minecraft.screen != null) return;
        if (!isAiming(player)) return;

        // a row to the RIGHT of the crosshair, vertically centered on it, so the
        // picker sits where the eye already is while aiming instead of down at
        // the hotbar - which the aim camera often pushes out of view anyway
        int x = minecraft.getWindow().getGuiScaledWidth() / 2 + CROSSHAIR_GAP;
        int y = (minecraft.getWindow().getGuiScaledHeight() - ICON_SIZE) / 2;

        // out of everything: the default shot with a red zero, and nothing to
        // pick - canSelectAmmo stays false, so the wheel keeps its normal job
        if (!anyAvailable(player)) {
            guiGraphics.renderFakeItem(new ItemStack(CannonBallItem.Type.BALL.getItem()), x, y);
            renderCount(guiGraphics, minecraft.font, 0, x, y, EMPTY_COUNT_COLOR);
            return;
        }

        CannonBallItem.Type selected = displayed(player);

        for (CannonBallItem.Type type : TYPES) {
            // types that are out are left out entirely rather than dimmed
            // further - a slot he cannot pick is just noise beside the crosshair
            int rounds = count(player, type);
            if (rounds <= 0) continue;
            ItemStack icon = new ItemStack(type.getItem());

            if (type == selected) {
                guiGraphics.renderFakeItem(icon, x, y);
                GuiCompat.frame(guiGraphics, x - 2, y - 2, ICON_SIZE + 4, ICON_SIZE + 4, 0xFFFFFFFF);
            } else {
                // ghost item style dimming, the same technique vanilla uses for
                // recipe book preview slots: scale the shader color alpha around
                // the item render, since renderFakeItem takes no alpha of its own
                RenderSystem.enableBlend();
                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, UNSELECTED_ALPHA);
                guiGraphics.renderFakeItem(icon, x, y);
                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                RenderSystem.disableBlend();
            }
            renderCount(guiGraphics, minecraft.font, rounds, x, y, type == selected ? COUNT_COLOR : dimmed(COUNT_COLOR));
            x += ICON_SIZE + ICON_GAP;
        }
    }

    /**
     * The round count, bottom right of the icon exactly where vanilla puts a
     * stack size.
     *
     * Not renderItemDecorations: that one reads the count off the ItemStack, and
     * ours is a display icon whose count would have to be faked - and it would
     * be capped at 99 by the stack size on top of that. A hold can easily carry
     * more rounds than that, and a gun crew wants to see it.
     *
     * The shader colour does not reach text, so an unselected icons' number is
     * dimmed through the alpha byte of the colour instead, see dimmed.
     */
    private static void renderCount(GuiGraphics guiGraphics, Font font, int rounds, int x, int y, int color) {
        String text = String.valueOf(rounds);

        guiGraphics.pose().pushPose();
        // in front of the item, which is drawn at a depth of its own
        guiGraphics.pose().translate(0.0F, 0.0F, 200.0F);
        guiGraphics.drawString(font, text, x + ICON_SIZE + 1 - font.width(text), y + ICON_SIZE - 7, color, true);
        guiGraphics.pose().popPose();
    }

    /** @return the colour with its alpha byte set to UNSELECTED_ALPHA */
    private static int dimmed(int color) {
        return (((int) (UNSELECTED_ALPHA * 255.0F)) << 24) | (color & 0x00FFFFFF);
    }
}