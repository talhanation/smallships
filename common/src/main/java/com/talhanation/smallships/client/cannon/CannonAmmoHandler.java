package com.talhanation.smallships.client.cannon;

import com.mojang.blaze3d.systems.RenderSystem;
import com.talhanation.smallships.client.gui.GuiCompat;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.network.packet.ServerboundSetCannonAmmoTypePacket;
import com.talhanation.smallships.world.entity.cannon.GroundCannonEntity;
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

    /** @return true if the local player is aiming and can therefore cycle ammo. */
    public static boolean canSelectAmmo(Player player) {
        if (player.getVehicle() instanceof GroundCannonEntity cannon) return cannon.isAiming();
        return CannonAimHandler.isAiming();
    }

    /** Cycles the selection by one step (sign of scrollDeltaY) and syncs it to the server. */
    public static void handleScroll(Player player, double scrollDeltaY) {
        if (scrollDeltaY == 0.0D) return;
        int direction = scrollDeltaY > 0 ? 1 : -1;

        CannonBallItem.Type current = CannonAmmoSelection.get(player);
        CannonBallItem.Type next = TYPES[Math.floorMod(current.ordinal() + direction, TYPES.length)];

        CannonAmmoSelection.set(player, next);
        ModPackets.clientSendPacket(new ServerboundSetCannonAmmoTypePacket(next.id));
    }

    public static void render(GuiGraphics guiGraphics) {
        Minecraft minecraft = Minecraft.getInstance();
        Player player = minecraft.player;
        if (player == null || minecraft.screen != null) return;
        if (!canSelectAmmo(player)) return;

        CannonBallItem.Type selected = CannonAmmoSelection.get(player);

        // a row to the RIGHT of the crosshair, vertically centered on it, so the
        // picker sits where the eye already is while aiming instead of down at
        // the hotbar - which the aim camera often pushes out of view anyway
        int startX = minecraft.getWindow().getGuiScaledWidth() / 2 + CROSSHAIR_GAP;
        int y = (minecraft.getWindow().getGuiScaledHeight() - ICON_SIZE) / 2;

        for (int i = 0; i < TYPES.length; i++) {
            CannonBallItem.Type type = TYPES[i];
            int x = startX + i * (ICON_SIZE + ICON_GAP);
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
        }
    }
}