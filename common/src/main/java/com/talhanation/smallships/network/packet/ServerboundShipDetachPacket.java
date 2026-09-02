package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.dockyard.DockyardAction;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.entity.ship.abilities.Cannonable;
import com.talhanation.smallships.world.inventory.ShipContainerMenu;
import com.talhanation.smallships.world.item.ModItems;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * Takes a single cannon or banner off a ship straight from its inventory
 * screen, without sailing back to a dockyard for it.
 *
 * Only removal travels this way. Fitting something needs the material, the
 * price and the whole job queue of the dockyard - taking a gun back off is the
 * one direction that costs nothing and can be undone at sea.
 *
 * The client makes the player hold the button for the same time the dockyard
 * would need. That hold is comfort only: it stops a stray click from throwing
 * a cannon overboard. Everything that matters is checked again here.
 */
public record ServerboundShipDetachPacket(int shipId, int kind, int index) implements ModPacket {
    public static final Type<ServerboundShipDetachPacket> TYPE = new Type<>(ModPackets.id("server_ship_detach"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundShipDetachPacket> CODEC = StreamCodec.composite(
            ByteBufCodecs.VAR_INT, ServerboundShipDetachPacket::shipId,
            ByteBufCodecs.VAR_INT, ServerboundShipDetachPacket::kind,
            ByteBufCodecs.VAR_INT, ServerboundShipDetachPacket::index,
            ServerboundShipDetachPacket::new);

    @Override
    public @NotNull Type<ServerboundShipDetachPacket> type() {
        return TYPE;
    }

    @Override
    public void handler(Player player) {
        if (!(player instanceof ServerPlayer serverPlayer)) return;
        if (!(player.level().getEntity(this.shipId) instanceof Ship ship)) return;

        // the screen of THIS ship has to be open: the packet carries an entity
        // id, and without this check any id in the world would do
        if (!(player.containerMenu instanceof ShipContainerMenu menu) || menu.getContainerShip() != ship) return;
        if (player.distanceToSqr(ship) > 64.0D) return;
        // a ship on the stocks belongs to the dockyard, not to the crew
        if (ship.isInDockyardWork()) return;

        DockyardAction.Kind[] kinds = DockyardAction.Kind.values();
        if (this.kind < 0 || this.kind >= kinds.length) return;

        switch (kinds[this.kind]) {
            case CANNON -> {
                if (!(ship instanceof Cannonable cannonable)) return;
                if (this.index < 0 || this.index >= cannonable.getTotalCannonSlots()) return;
                if (!cannonable.isCannonInSlot(this.index)) return;
                cannonable.setCannonInSlot(this.index, false);
                giveBack(serverPlayer, new ItemStack(ModItems.CANNON));
            }
            case BANNER -> {
                ItemStack banner = ship.getData(Ship.BANNER);
                if (banner.isEmpty()) return;
                ship.setData(Ship.BANNER, ItemStack.EMPTY);
                giveBack(serverPlayer, banner.copy());
            }
            case SAIL_BANNER -> {
                ItemStack banner = ship.getData(Ship.SAIL_BANNER);
                if (banner.isEmpty()) return;
                ship.setData(Ship.SAIL_BANNER, ItemStack.EMPTY);
                giveBack(serverPlayer, banner.copy());
            }
            default -> {
            }
        }
    }

    /**
     * Straight into the players' inventory, not onto the deck: he is standing
     * on a ship, and a stack that misses the planks is gone in the water.
     * Whatever does not fit is dropped at his feet.
     */
    private static void giveBack(ServerPlayer player, ItemStack stack) {
        player.getInventory().placeItemBackInInventory(stack);
    }

    @Override
    public Side side() {
        return Side.SERVERBOUND;
    }
}