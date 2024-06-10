package com.talhanation.smallships.world.item;

import com.talhanation.smallships.world.entity.ship.BriggEntity;
import com.talhanation.smallships.world.entity.ship.CogEntity;
import com.talhanation.smallships.world.entity.ship.DrakkarEntity;
import com.talhanation.smallships.world.entity.ship.GalleyEntity;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class ModItems {
    public static final Item SAIL = getItem("sail");

    public static final Item CANNON = getItem("cannon");
    public static final Item CANNON_BALL = getItem("cannon_ball");

    public static final Map<Boat.Type, Item> COG_ITEMS = new HashMap<>(Boat.Type.values().length);
    public static final Map<Boat.Type, Item> BRIGG_ITEMS = new HashMap<>(Boat.Type.values().length);
    public static final Map<Boat.Type, Item> GALLEY_ITEMS = new HashMap<>(Boat.Type.values().length);
    public static final Map<Boat.Type, Item> DRAKKAR_ITEMS = new HashMap<>(Boat.Type.values().length);

    static {
        Boat.Type[] boatTypes = Boat.Type.values();
        for (Boat.Type type : boatTypes) {
            COG_ITEMS.put(type, getItem(type.getName() + "_" + CogEntity.ID));
            BRIGG_ITEMS.put(type, getItem(type.getName() + "_" + BriggEntity.ID));
            GALLEY_ITEMS.put(type, getItem(type.getName() + "_" + GalleyEntity.ID));
            DRAKKAR_ITEMS.put(type, getItem(type.getName() + "_" + DrakkarEntity.ID));
        }
    }

    @ExpectPlatform
    public static Item getItem(String id) {
        throw new AssertionError();
    }
}
