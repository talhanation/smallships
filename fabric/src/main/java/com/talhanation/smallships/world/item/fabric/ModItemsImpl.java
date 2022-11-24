package com.talhanation.smallships.world.item.fabric;

import com.talhanation.smallships.SmallshipsMod;
import com.talhanation.smallships.world.entity.ship.BriggEntity;
import com.talhanation.smallships.world.entity.ship.CogEntity;
import com.talhanation.smallships.world.item.*;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

import java.util.HashMap;
import java.util.Map;

public class ModItemsImpl {
    private static final Map<String, Item> entries = new HashMap<>();

    public static Item getItem(String id) {
        return entries.get(id);
    }

    static {
        register("sail", new SailItem((new Item.Properties()).stacksTo(16).tab(CreativeModeTab.TAB_MISC)));

        register("cannon", new CannonItem((new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_COMBAT)));
        register("cannon_ball", new CannonBallItem((new Item.Properties()).stacksTo(16).tab(CreativeModeTab.TAB_COMBAT)));

        for (Boat.Type type: Boat.Type.values()) {
            register(new ResourceLocation(type.getName()).getPath() + "_" + CogEntity.ID,  new CogItem(type, new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_TRANSPORTATION)));
            register(new ResourceLocation(type.getName()).getPath() + "_" + BriggEntity.ID,  new BriggItem(type, new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_TRANSPORTATION)));
        }
    }

    private static void register(String id, Item item) {
        entries.put(id, register(new ResourceLocation(SmallshipsMod.MOD_ID, id), item));
    }

    private static Item register(ResourceLocation id, Item item) {
        if (item instanceof BlockItem blockItem) {
            blockItem.registerBlocks(Item.BY_BLOCK, blockItem);
        }

        return Registry.register(Registry.ITEM, id, item);
    }
}
