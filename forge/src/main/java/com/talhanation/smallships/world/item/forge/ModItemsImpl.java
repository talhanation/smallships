package com.talhanation.smallships.world.item.forge;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.client.renderer.item.DockyardItemRenderer;
import com.talhanation.smallships.world.block.ModBlocks;
import com.talhanation.smallships.world.item.*;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ModItemsImpl {
    private static final Map<String, RegistryObject<Item>> entries = new HashMap<>();

    public static Item getItem(String id) {
        return entries.get(id).get();
    }

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SmallShipsMod.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SmallShipsMod.MOD_ID);
    public static final RegistryObject<CreativeModeTab> customCreativeModeTab = CREATIVE_MODE_TABS.register(new ResourceLocation(SmallShipsMod.MOD_ID, "creative_mode_tab").toString().replace(":", "."), () -> CreativeModeTab.builder()
            .title(Component.translatable(new ResourceLocation(SmallShipsMod.MOD_ID, "creative_mode_tab").toString().replace(":", ".")))
            .icon(() -> new ItemStack(ModItems.CANNON))
            .build());

    static {
        register("cannon", () -> new CannonItem((new Item.Properties()).stacksTo(1)));
        register("cannon_ball", () -> new CannonBallItem((new Item.Properties()).stacksTo(16)));
        register("chained_shot", () -> new CannonBallItem(CannonBallItem.Type.CHAINED, (new Item.Properties()).stacksTo(16)));
        register("grape_shot", () -> new CannonBallItem(CannonBallItem.Type.GRAPE, (new Item.Properties()).stacksTo(16)));
        register("fine_grain_powder", () -> new Item(new Item.Properties()));

        // forge has no BuiltinItemRendererRegistry - the dockyard item renderer is
        // handed over through the item itself, the anonymous IClientItemExtensions
        // stays unloaded on a dedicated server
        register("dockyard", () -> new BlockItem(ModBlocks.DOCKYARD, new Item.Properties()) {
            @Override
            public void initializeClient(Consumer<IClientItemExtensions> consumer) {
                consumer.accept(new IClientItemExtensions() {
                    @Override
                    public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                        return DockyardItemRenderer.getInstance();
                    }
                });
            }
        });

        register("copper_plating", () -> new Item(new Item.Properties().stacksTo(1)));
        register("cotton_sails", () -> new Item(new Item.Properties().stacksTo(1)));
        register("iron_scantlings", () -> new Item(new Item.Properties().stacksTo(1)));

        // the ship items are not registered here: they go through ShipItems
        // like every addon ship does, see ModShipItems
    }

    private static void register(String id, Supplier<Item> itemSupplier) {
        entries.put(id, ITEMS.register(id, itemSupplier));
    }
}