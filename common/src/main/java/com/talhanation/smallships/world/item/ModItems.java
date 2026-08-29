package com.talhanation.smallships.world.item;

import com.talhanation.smallships.world.entity.ship.*;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;

import java.util.HashMap;
import java.util.Map;

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

    public static final Map<Boat.Type, Item> COG_ITEMS = new HashMap<>(Boat.Type.values().length);
    public static final Map<Boat.Type, Item> BRIGG_ITEMS = new HashMap<>(Boat.Type.values().length);
    public static final Map<Boat.Type, Item> GALLEY_ITEMS = new HashMap<>(Boat.Type.values().length);
    public static final Map<Boat.Type, Item> DHOW_ITEMS = new HashMap<>(Boat.Type.values().length);
    public static final Map<Boat.Type, Item> DRAKKAR_ITEMS = new HashMap<>(Boat.Type.values().length);
    public static final Map<Boat.Type, Item> GALLEON_ITEMS = new HashMap<>(Boat.Type.values().length);
    public static final Map<Boat.Type, Item> CARAVEL_ITEMS = new HashMap<>(Boat.Type.values().length);
    static {
        Boat.Type[] boatTypes = Boat.Type.values();
        for (Boat.Type type : boatTypes) {
            String name = type.getName().replaceAll("[^a-z0-9_.-]", "_");
            COG_ITEMS.put(type, getItem(name + "_" + CogEntity.ID));
            BRIGG_ITEMS.put(type, getItem(name + "_" + BriggEntity.ID));
            GALLEY_ITEMS.put(type, getItem(name + "_" + GalleyEntity.ID));
            DHOW_ITEMS.put(type, getItem(name + "_" + DhowEntity.ID));
            DRAKKAR_ITEMS.put(type, getItem(name + "_" + DrakkarEntity.ID));
            GALLEON_ITEMS.put(type, getItem(name + "_" + GalleonEntity.ID));
            CARAVEL_ITEMS.put(type, getItem(name + "_" + CaravelEntity.ID));
        }
    }

    @ExpectPlatform
    public static Item getItem(String id) {
        throw new AssertionError();
    }
}