package com.talhanation.smallships.world.item;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.item.Item;

/**
 * The main mods' items. The ship items are not in here any more - they come
 * from ShipItems, see ModShipItems.
 */
@SuppressWarnings("unused")
public class ModItems {

    public static final Item CANNON = getItem("cannon");
    public static final CannonBallItem CANNON_BALL = (CannonBallItem) getItem("cannon_ball");
    public static final CannonBallItem CHAINED_SHOT = (CannonBallItem) getItem("chained_shot");
    public static final CannonBallItem GRAPE_SHOT = (CannonBallItem) getItem("grape_shot");
    public static final Item FINE_GRAIN_POWDER = getItem("fine_grain_powder");
    public static final Item DOCKYARD = getItem("dockyard");

    // materials consumed by the dockyard when a ship upgrade is installed
    public static final Item IRON_SCANTLINGS = getItem("iron_scantlings");
    public static final Item COPPER_PLATING = getItem("copper_plating");
    public static final Item COTTON_SAILS = getItem("cotton_sails");

    @ExpectPlatform
    public static Item getItem(String id) {
        throw new AssertionError();
    }
}
