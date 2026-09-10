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
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/**
 * The mouse wheel ammo picker: while aiming (ship broadside, gunner, or ground
 * cannon) the wheel cycles the cannonball type instead of the hotbar, and the
 * three types are drawn in a row beside the crosshair, the unselected ones
 * dimmed.
 *
 * Input and drawing live together because they are the same widget - the wheel
 * hook in MouseHandlerMixin feeds handleScroll, the platform GUI event feeds
 * render.
 *
 * Only types that can actually be fired are shown and cycled through, so the
 * wheel never stops on an empty icon. That means the player's own inventory
 * plus the ship's hold, the latter read from ContainerShip's synched ammo
 * flags - the hold's stacks themselves are not on the client, which is why a
 * flag per type is synched instead.
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

    private CannonAmmoHandler() {
    }

    /**
     * @return true if the local player is aiming AND has something to
     * choose between. With nothing to pick from, the wheel is left alone so it
     * keeps doing its normal job.
     */
    public static boolean canSelectAmmo(Player player) {
        boolean aiming = player.getVehicle() instanceof GroundCannonEntity cannon
                ? cannon.isAiming()
                : CannonAimHandler.isAiming();
        return aiming && anyAvailable(player);
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
     * @return whether this type can actually be fired: the player carries it,
     * or the ship's hold does. The hold is read from the ship's synched flags
     * rather than its stacks, since the client only ever holds the open page
     * of a multi page hold - that is what lets a gunner see the shot he is
     * about to fire even though it is nowhere in his own inventory.
     */
    private static boolean available(Player player, CannonBallItem.Type type) {
        for (ItemStack itemStack : player.getInventory().items) {
            if (itemStack.getItem() instanceof CannonBallItem cannonBallItem && cannonBallItem.getType() == type) {
                return true;
            }
        }
        return player.getVehicle() instanceof ContainerShip containerShip && containerShip.hasAmmoInHold(type);
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
        if (!canSelectAmmo(player)) return;

        CannonBallItem.Type selected = displayed(player);

        // a row to the RIGHT of the crosshair, vertically centered on it, so the
        // picker sits where the eye already is while aiming instead of down at
        // the hotbar - which the aim camera often pushes out of view anyway
        int x = minecraft.getWindow().getGuiScaledWidth() / 2 + CROSSHAIR_GAP;
        int y = (minecraft.getWindow().getGuiScaledHeight() - ICON_SIZE) / 2;

        for (CannonBallItem.Type type : TYPES) {
            // types that are out are left out entirely rather than dimmed
            // further - a slot he cannot pick is just noise beside the crosshair
            if (!available(player, type)) continue;
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
            x += ICON_SIZE + ICON_GAP;
        }
    }
}