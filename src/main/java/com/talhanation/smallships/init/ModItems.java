package com.talhanation.smallships.init;

import com.talhanation.smallships.Main;
import com.talhanation.smallships.entities.AbstractSailShip;
import com.talhanation.smallships.entities.CogEntity;
import com.talhanation.smallships.items.CogItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {



    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MOD_ID);
    //public static final RegistryObject<Item> SHIP_ITEM = ITEMS.register("ship_item", ShipItem::new);
    public static final RegistryObject<Item> SAIL_ITEM = ITEMS.register("sail_item", () -> new Item((new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_TRANSPORTATION))));
    public static final RegistryObject<Item> CANNON_ITEM = ITEMS.register("cannon_item", () -> new Item((new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_TRANSPORTATION))));
    public static final RegistryObject<Item> CANNONBALL = ITEMS.register("cannonball_item", () -> new Item((new Item.Properties().stacksTo(16).tab(CreativeModeTab.TAB_TRANSPORTATION))));
    public static final RegistryObject<Item> OAK_COG_ITEM = ITEMS.register("oak_cog", () -> new CogItem(CogEntity.Type.OAK, (new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_TRANSPORTATION)));
    public static final RegistryObject<Item> SPRUCE_COG_ITEM = ITEMS.register("spruce_cog", () -> new CogItem(CogEntity.Type.SPRUCE, (new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_TRANSPORTATION)));
    public static final RegistryObject<Item> BIRCH_COG_ITEM = ITEMS.register("birch_cog", () -> new CogItem(CogEntity.Type.BIRCH, (new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_TRANSPORTATION)));
    public static final RegistryObject<Item> JUNGLE_COG_ITEM = ITEMS.register("jungle_cog", () -> new CogItem(CogEntity.Type.JUNGLE, (new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_TRANSPORTATION)));
    public static final RegistryObject<Item> ACACIA_COG_ITEM = ITEMS.register("acacia_cog", () -> new CogItem(CogEntity.Type.ACACIA, (new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_TRANSPORTATION)));
    public static final RegistryObject<Item> DARK_OAK_COG_ITEM = ITEMS.register("dark_oak_cog", () -> new CogItem(CogEntity.Type.DARK_OAK, (new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_TRANSPORTATION)));

    /*
    public static final RegistryObject<Item> OAK_ROWBOAT_ITEM =         createRowBoat("oak", AbstractRowBoatEntity.Type.OAK, true);
    public static final RegistryObject<Item> SPRUCE_ROWBOAT_ITEM =      createRowBoat("spruce", AbstractRowBoatEntity.Type.SPRUCE, true);
    public static final RegistryObject<Item> BIRCH_ROWBOAT_ITEM =       createRowBoat("birch", AbstractRowBoatEntity.Type.BIRCH, true);
    public static final RegistryObject<Item> JUNGLE_ROWBOAT_ITEM =      createRowBoat("jungle", AbstractRowBoatEntity.Type.JUNGLE, true);
    public static final RegistryObject<Item> ACACIA_ROWBOAT_ITEM =      createRowBoat("acacia", AbstractRowBoatEntity.Type.ACACIA, true);
    public static final RegistryObject<Item> DARK_OAK_ROWBOAT_ITEM =    createRowBoat("dark_oak", AbstractRowBoatEntity.Type.DARK_OAK, true);
*/
    //public static final RegistryObject<Item> OAK_COG_ITEM = createCog("oak", CogEntity.Type.OAK, true);
    //public static final RegistryObject<Item> SPRUCE_COG_ITEM =          createCog("spruce", CogEntity.Type.SPRUCE, true);
    //public static final RegistryObject<Item> BIRCH_COG_ITEM =           createCog("birch", CogEntity.Type.BIRCH, true);
    //public static final RegistryObject<Item> JUNGLE_COG_ITEM =          createCog("jungle", CogEntity.Type.JUNGLE, true);
    //public static final RegistryObject<Item> ACACIA_COG_ITEM =          createCog("acacia", CogEntity.Type.ACACIA, true);
    //public static final RegistryObject<Item> DARK_OAK_COG_ITEM =        createCog("dark_oak", CogEntity.Type.DARK_OAK, true);
/*
    public static final RegistryObject<Item> OAK_GALLEY_ITEM =          createGalley("oak", AbstractGalleyEntity.Type.OAK, true);
    public static final RegistryObject<Item> SPRUCE_GALLEY_ITEM =       createGalley("spruce", AbstractGalleyEntity.Type.SPRUCE, true);
    public static final RegistryObject<Item> BIRCH_GALLEY_ITEM =        createGalley("birch", AbstractGalleyEntity.Type.BIRCH, true);
    public static final RegistryObject<Item> JUNGLE_GALLEY_ITEM =       createGalley("jungle", AbstractGalleyEntity.Type.JUNGLE, true);
    public static final RegistryObject<Item> ACACIA_GALLEY_ITEM =       createGalley("acacia", AbstractGalleyEntity.Type.ACACIA, true);
    public static final RegistryObject<Item> DARK_OAK_GALLEY_ITEM =     createGalley("dark_oak", AbstractGalleyEntity.Type.DARK_OAK, true);

    public static final RegistryObject<Item> OAK_WAR_GALLEY_ITEM =      createWarGalley("oak", AbstractWarGalleyEntity.Type.OAK, true);
    public static final RegistryObject<Item> SPRUCE_WAR_GALLEY_ITEM =   createWarGalley("spruce", AbstractWarGalleyEntity.Type.SPRUCE, true);
    public static final RegistryObject<Item> BIRCH_WAR_GALLEY_ITEM =    createWarGalley("birch", AbstractWarGalleyEntity.Type.BIRCH, true);
    public static final RegistryObject<Item> JUNGLE_WAR_GALLEY_ITEM =   createWarGalley("jungle", AbstractWarGalleyEntity.Type.JUNGLE, true);
    public static final RegistryObject<Item> ACACIA_WAR_GALLEY_ITEM =   createWarGalley("acacia", AbstractWarGalleyEntity.Type.ACACIA, true);
    public static final RegistryObject<Item> DARK_OAK_WAR_GALLEY_ITEM = createWarGalley("dark_oak", AbstractWarGalleyEntity.Type.DARK_OAK, true);

    public static final RegistryObject<Item> OAK_DRAKKAR_ITEM =         createDrakkar("oak", AbstractDrakkarEntity.Type.OAK, true);
    public static final RegistryObject<Item> SPRUCE_DRAKKAR_ITEM =      createDrakkar("spruce", AbstractDrakkarEntity.Type.SPRUCE, true);
    public static final RegistryObject<Item> BIRCH_DRAKKAR_ITEM =       createDrakkar("birch", AbstractDrakkarEntity.Type.BIRCH, true);
    public static final RegistryObject<Item> JUNGLE_DRAKKAR_ITEM =      createDrakkar("jungle", AbstractDrakkarEntity.Type.JUNGLE, true);
    public static final RegistryObject<Item> ACACIA_DRAKKAR_ITEM =      createDrakkar("acacia", AbstractDrakkarEntity.Type.ACACIA, true);
    public static final RegistryObject<Item> DARK_OAK_DRAKKAR_ITEM =    createDrakkar("dark_oak", AbstractDrakkarEntity.Type.DARK_OAK, true);

    public static final RegistryObject<Item> OAK_BRIGG_ITEM =         createBrigg("oak", AbstractBriggEntity.Type.OAK, true);
    public static final RegistryObject<Item> SPRUCE_BRIGG_ITEM =      createBrigg("spruce", AbstractBriggEntity.Type.SPRUCE, true);
    public static final RegistryObject<Item> BIRCH_BRIGG_ITEM =       createBrigg("birch", AbstractBriggEntity.Type.BIRCH, true);
    public static final RegistryObject<Item> JUNGLE_BRIGG_ITEM =      createBrigg("jungle", AbstractBriggEntity.Type.JUNGLE, true);
    public static final RegistryObject<Item> ACACIA_BRIGG_ITEM =      createBrigg("acacia", AbstractBriggEntity.Type.ACACIA, true);
    public static final RegistryObject<Item> DARK_OAK_BRIGG_ITEM =    createBrigg("dark_oak", AbstractBriggEntity.Type.DARK_OAK, true);

    public static final RegistryObject<Item> OAK_DHOW_ITEM =         createDhow("oak", AbstractDhowEntity.Type.OAK, true);
    public static final RegistryObject<Item> SPRUCE_DHOW_ITEM =      createDhow("spruce", AbstractDhowEntity.Type.SPRUCE, true);
    public static final RegistryObject<Item> BIRCH_DHOW_ITEM =       createDhow("birch", AbstractDhowEntity.Type.BIRCH, true);
    public static final RegistryObject<Item> JUNGLE_DHOW_ITEM =      createDhow("jungle", AbstractDhowEntity.Type.JUNGLE, true);
    public static final RegistryObject<Item> ACACIA_DHOW_ITEM =      createDhow("acacia", AbstractDhowEntity.Type.ACACIA, true);
    public static final RegistryObject<Item> DARK_OAK_DHOW_ITEM =    createDhow("dark_oak", AbstractDhowEntity.Type.DARK_OAK, true);


            //BOP
    public static final RegistryObject<Item> BOP_CHERRY_COG_ITEM =      createCog("bop_cherry", AbstractCogEntity.Type.BOP_CHERRY, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_CHERRY_GALLEY_ITEM =      createGalley("bop_cherry", AbstractGalleyEntity.Type.BOP_CHERRY, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_CHERRY_WAR_GALLEY_ITEM =      createWarGalley("bop_cherry", AbstractWarGalleyEntity.Type.BOP_CHERRY, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_CHERRY_DRAKKAR_ITEM =      createDrakkar("bop_cherry", AbstractDrakkarEntity.Type.BOP_CHERRY, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_CHERRY_ROWBOAT_ITEM =      createRowBoat("bop_cherry", AbstractRowBoatEntity.Type.BOP_CHERRY, BiomesOPlenty.isInstalled());

    public static final RegistryObject<Item> BOP_DEAD_COG_ITEM =      createCog("bop_dead", AbstractCogEntity.Type.BOP_DEAD, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_DEAD_GALLEY_ITEM =      createGalley("bop_dead", AbstractGalleyEntity.Type.BOP_DEAD, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_DEAD_WAR_GALLEY_ITEM =      createWarGalley("bop_dead", AbstractWarGalleyEntity.Type.BOP_DEAD, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_DEAD_DRAKKAR_ITEM =      createDrakkar("bop_dead", AbstractDrakkarEntity.Type.BOP_DEAD, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_DEAD_ROWBOAT_ITEM =      createRowBoat("bop_dead", AbstractRowBoatEntity.Type.BOP_DEAD, BiomesOPlenty.isInstalled());

    public static final RegistryObject<Item> BOP_FIR_COG_ITEM =      createCog("bop_fir", AbstractCogEntity.Type.BOP_FIR, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_FIR_GALLEY_ITEM =      createGalley("bop_fir", AbstractGalleyEntity.Type.BOP_FIR, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_FIR_WAR_GALLEY_ITEM =      createWarGalley("bop_fir", AbstractWarGalleyEntity.Type.BOP_FIR, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_FIR_DRAKKAR_ITEM =      createDrakkar("bop_fir", AbstractDrakkarEntity.Type.BOP_FIR, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_FIR_ROWBOAT_ITEM =      createRowBoat("bop_fir", AbstractRowBoatEntity.Type.BOP_FIR, BiomesOPlenty.isInstalled());

    public static final RegistryObject<Item> BOP_HELLBARK_COG_ITEM =      createCog("bop_hellbark", AbstractCogEntity.Type.BOP_HELLBARK, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_HELLBARK_GALLEY_ITEM =      createGalley("bop_hellbark", AbstractGalleyEntity.Type.BOP_HELLBARK, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_HELLBARK_WAR_GALLEY_ITEM =      createWarGalley("bop_hellbark", AbstractWarGalleyEntity.Type.BOP_HELLBARK, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_HELLBARK_DRAKKAR_ITEM =      createDrakkar("bop_hellbark", AbstractDrakkarEntity.Type.BOP_HELLBARK, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_HELLBARK_ROWBOAT_ITEM =      createRowBoat("bop_hellbark", AbstractRowBoatEntity.Type.BOP_HELLBARK, BiomesOPlenty.isInstalled());

    public static final RegistryObject<Item> BOP_JACARANDA_COG_ITEM =      createCog("bop_jacaranda", AbstractCogEntity.Type.BOP_JACARANDA, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_JACARANDA_GALLEY_ITEM =      createGalley("bop_jacaranda", AbstractGalleyEntity.Type.BOP_JACARANDA, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_JACARANDA_WAR_GALLEY_ITEM =      createWarGalley("bop_jacaranda", AbstractWarGalleyEntity.Type.BOP_JACARANDA, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_JACARANDA_DRAKKAR_ITEM =      createDrakkar("bop_jacaranda", AbstractDrakkarEntity.Type.BOP_JACARANDA, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_JACARANDA_ROWBOAT_ITEM =      createRowBoat("bop_jacaranda", AbstractRowBoatEntity.Type.BOP_JACARANDA, BiomesOPlenty.isInstalled());

    public static final RegistryObject<Item> BOP_MAGIC_COG_ITEM =      createCog("bop_magic", AbstractCogEntity.Type.BOP_MAGIC, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_MAGIC_GALLEY_ITEM =      createGalley("bop_magic", AbstractGalleyEntity.Type.BOP_MAGIC, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_MAGIC_WAR_GALLEY_ITEM =      createWarGalley("bop_magic", AbstractWarGalleyEntity.Type.BOP_MAGIC, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_MAGIC_DRAKKAR_ITEM =      createDrakkar("bop_magic", AbstractDrakkarEntity.Type.BOP_MAGIC, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_MAGIC_ROWBOAT_ITEM =      createRowBoat("bop_magic", AbstractRowBoatEntity.Type.BOP_MAGIC, BiomesOPlenty.isInstalled());

    public static final RegistryObject<Item> BOP_MAHOGANY_COG_ITEM =      createCog("bop_mahogany", AbstractCogEntity.Type.BOP_MAHOGANY, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_MAHOGANY_GALLEY_ITEM =      createGalley("bop_mahogany", AbstractGalleyEntity.Type.BOP_MAHOGANY, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_MAHOGANY_WAR_GALLEY_ITEM =      createWarGalley("bop_mahogany", AbstractWarGalleyEntity.Type.BOP_MAHOGANY, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_MAHOGANY_DRAKKAR_ITEM =      createDrakkar("bop_mahogany", AbstractDrakkarEntity.Type.BOP_MAHOGANY, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_MAHOGANY_ROWBOAT_ITEM =      createRowBoat("bop_mahogany", AbstractRowBoatEntity.Type.BOP_MAHOGANY, BiomesOPlenty.isInstalled());

    public static final RegistryObject<Item> BOP_PALM_COG_ITEM =      createCog("bop_palm", AbstractCogEntity.Type.BOP_PALM, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_PALM_GALLEY_ITEM =      createGalley("bop_palm", AbstractGalleyEntity.Type.BOP_PALM, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_PALM_WAR_GALLEY_ITEM =      createWarGalley("bop_palm", AbstractWarGalleyEntity.Type.BOP_PALM, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_PALM_DRAKKAR_ITEM =      createDrakkar("bop_palm", AbstractDrakkarEntity.Type.BOP_PALM, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_PALM_ROWBOAT_ITEM =      createRowBoat("bop_palm", AbstractRowBoatEntity.Type.BOP_PALM, BiomesOPlenty.isInstalled());

    public static final RegistryObject<Item> BOP_REDWOOD_COG_ITEM =      createCog("bop_redwood", AbstractCogEntity.Type.BOP_REDWOOD, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_REDWOOD_GALLEY_ITEM =      createGalley("bop_redwood", AbstractGalleyEntity.Type.BOP_REDWOOD, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_REDWOOD_WAR_GALLEY_ITEM =      createWarGalley("bop_redwood", AbstractWarGalleyEntity.Type.BOP_REDWOOD, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_REDWOOD_DRAKKAR_ITEM =      createDrakkar("bop_redwood", AbstractDrakkarEntity.Type.BOP_REDWOOD, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_REDWOOD_ROWBOAT_ITEM =      createRowBoat("bop_redwood", AbstractRowBoatEntity.Type.BOP_REDWOOD, BiomesOPlenty.isInstalled());

    public static final RegistryObject<Item> BOP_UMBRAN_COG_ITEM =      createCog("bop_umbran", AbstractCogEntity.Type.BOP_UMBRAN, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_UMBRAN_GALLEY_ITEM =      createGalley("bop_umbran", AbstractGalleyEntity.Type.BOP_UMBRAN, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_UMBRAN_WAR_GALLEY_ITEM =      createWarGalley("bop_umbran", AbstractWarGalleyEntity.Type.BOP_UMBRAN, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_UMBRAN_DRAKKAR_ITEM =      createDrakkar("bop_umbran", AbstractDrakkarEntity.Type.BOP_UMBRAN, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_UMBRAN_ROWBOAT_ITEM =      createRowBoat("bop_umbran", AbstractRowBoatEntity.Type.BOP_UMBRAN, BiomesOPlenty.isInstalled());

    public static final RegistryObject<Item> BOP_WILLOW_COG_ITEM =      createCog("bop_willow", AbstractCogEntity.Type.BOP_WILLOW, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_WILLOW_GALLEY_ITEM =      createGalley("bop_willow", AbstractGalleyEntity.Type.BOP_WILLOW, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_WILLOW_WAR_GALLEY_ITEM =      createWarGalley("bop_willow", AbstractWarGalleyEntity.Type.BOP_WILLOW, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_WILLOW_DRAKKAR_ITEM =      createDrakkar("bop_willow", AbstractDrakkarEntity.Type.BOP_WILLOW, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_WILLOW_ROWBOAT_ITEM =      createRowBoat("bop_willow", AbstractRowBoatEntity.Type.BOP_WILLOW, BiomesOPlenty.isInstalled());

        //LOTR
    public static final RegistryObject<Item> LOTR_APPLE_COG_ITEM =      createCog("lotr_apple", AbstractCogEntity.Type.LOTR_APPLE, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_APPLE_GALLEY_ITEM =      createGalley("lotr_apple", AbstractGalleyEntity.Type.LOTR_APPLE, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_APPLE_WAR_GALLEY_ITEM =      createWarGalley("lotr_apple", AbstractWarGalleyEntity.Type.LOTR_APPLE, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_APPLE_DRAKKAR_ITEM =      createDrakkar("lotr_apple", AbstractDrakkarEntity.Type.LOTR_APPLE, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_APPLE_ROWBOAT_ITEM =      createRowBoat("lotr_apple", AbstractRowBoatEntity.Type.LOTR_APPLE, LordOfTheRingsMod.isInstalled());

    public static final RegistryObject<Item> LOTR_ASPEN_COG_ITEM =      createCog("lotr_aspen", AbstractCogEntity.Type.LOTR_ASPEN, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_ASPEN_GALLEY_ITEM =      createGalley("lotr_aspen", AbstractGalleyEntity.Type.LOTR_ASPEN, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_ASPEN_WAR_GALLEY_ITEM =      createWarGalley("lotr_aspen", AbstractWarGalleyEntity.Type.LOTR_ASPEN, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_ASPEN_DRAKKAR_ITEM =      createDrakkar("lotr_aspen", AbstractDrakkarEntity.Type.LOTR_ASPEN, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_ASPEN_ROWBOAT_ITEM =      createRowBoat("lotr_aspen", AbstractRowBoatEntity.Type.LOTR_ASPEN, LordOfTheRingsMod.isInstalled());

    public static final RegistryObject<Item> LOTR_BEECH_COG_ITEM =      createCog("lotr_beech", AbstractCogEntity.Type.LOTR_BEECH, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_BEECH_GALLEY_ITEM =      createGalley("lotr_beech", AbstractGalleyEntity.Type.LOTR_BEECH, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_BEECH_WAR_GALLEY_ITEM =      createWarGalley("lotr_beech", AbstractWarGalleyEntity.Type.LOTR_BEECH, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_BEECH_DRAKKAR_ITEM =      createDrakkar("lotr_beech", AbstractDrakkarEntity.Type.LOTR_BEECH, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_BEECH_ROWBOAT_ITEM =      createRowBoat("lotr_beech", AbstractRowBoatEntity.Type.LOTR_BEECH, LordOfTheRingsMod.isInstalled());

    public static final RegistryObject<Item> LOTR_CEDAR_COG_ITEM =      createCog("lotr_cedar", AbstractCogEntity.Type.LOTR_CEDAR, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_CEDAR_GALLEY_ITEM =      createGalley("lotr_cedar", AbstractGalleyEntity.Type.LOTR_CEDAR, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_CEDAR_WAR_GALLEY_ITEM =      createWarGalley("lotr_cedar", AbstractWarGalleyEntity.Type.LOTR_CEDAR, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_CEDAR_DRAKKAR_ITEM =      createDrakkar("lotr_cedar", AbstractDrakkarEntity.Type.LOTR_CEDAR, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_CEDAR_ROWBOAT_ITEM =      createRowBoat("lotr_cedar", AbstractRowBoatEntity.Type.LOTR_CEDAR, LordOfTheRingsMod.isInstalled());

    public static final RegistryObject<Item> LOTR_CHARRED_COG_ITEM =      createCog("lotr_charred", AbstractCogEntity.Type.LOTR_CHARRED, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_CHARRED_GALLEY_ITEM =      createGalley("lotr_charred", AbstractGalleyEntity.Type.LOTR_CHARRED, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_CHARRED_WAR_GALLEY_ITEM =      createWarGalley("lotr_charred", AbstractWarGalleyEntity.Type.LOTR_CHARRED, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_CHARRED_DRAKKAR_ITEM =      createDrakkar("lotr_charred", AbstractDrakkarEntity.Type.LOTR_CHARRED, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_CHARRED_ROWBOAT_ITEM =      createRowBoat("lotr_charred", AbstractRowBoatEntity.Type.LOTR_CHARRED, LordOfTheRingsMod.isInstalled());

    public static final RegistryObject<Item> LOTR_CHERRY_COG_ITEM =      createCog("lotr_cherry", AbstractCogEntity.Type.LOTR_CHERRY, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_CHERRY_GALLEY_ITEM =      createGalley("lotr_cherry", AbstractGalleyEntity.Type.LOTR_CHERRY, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_CHERRY_WAR_GALLEY_ITEM =      createWarGalley("lotr_cherry", AbstractWarGalleyEntity.Type.LOTR_CHERRY, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_CHERRY_DRAKKAR_ITEM =      createDrakkar("lotr_cherry", AbstractDrakkarEntity.Type.LOTR_CHERRY, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_CHERRY_ROWBOAT_ITEM =      createRowBoat("lotr_cherry", AbstractRowBoatEntity.Type.LOTR_CHERRY, LordOfTheRingsMod.isInstalled());

    public static final RegistryObject<Item> LOTR_CYPRESS_COG_ITEM =      createCog("lotr_cypress", AbstractCogEntity.Type.LOTR_CYPRESS, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_CYPRESS_GALLEY_ITEM =      createGalley("lotr_cypress", AbstractGalleyEntity.Type.LOTR_CYPRESS, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_CYPRESS_WAR_GALLEY_ITEM =      createWarGalley("lotr_cypress", AbstractWarGalleyEntity.Type.LOTR_CYPRESS, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_CYPRESS_DRAKKAR_ITEM =      createDrakkar("lotr_cypress", AbstractDrakkarEntity.Type.LOTR_CYPRESS, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_CYPRESS_ROWBOAT_ITEM =      createRowBoat("lotr_cypress", AbstractRowBoatEntity.Type.LOTR_CYPRESS, LordOfTheRingsMod.isInstalled());

    public static final RegistryObject<Item> LOTR_FIR_COG_ITEM =      createCog("lotr_fir", AbstractCogEntity.Type.LOTR_FIR, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_FIR_GALLEY_ITEM =      createGalley("lotr_fir", AbstractGalleyEntity.Type.LOTR_FIR, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_FIR_WAR_GALLEY_ITEM =      createWarGalley("lotr_fir", AbstractWarGalleyEntity.Type.LOTR_FIR, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_FIR_DRAKKAR_ITEM =      createDrakkar("lotr_fir", AbstractDrakkarEntity.Type.LOTR_FIR, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_FIR_ROWBOAT_ITEM =      createRowBoat("lotr_fir", AbstractRowBoatEntity.Type.LOTR_FIR, LordOfTheRingsMod.isInstalled());

    public static final RegistryObject<Item> LOTR_GREEN_OAK_COG_ITEM =      createCog("lotr_green_oak", AbstractCogEntity.Type.LOTR_GREEN_OAK, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_GREEN_OAK_GALLEY_ITEM =      createGalley("lotr_green_oak", AbstractGalleyEntity.Type.LOTR_GREEN_OAK, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_GREEN_OAK_WAR_GALLEY_ITEM =      createWarGalley("lotr_green_oak", AbstractWarGalleyEntity.Type.LOTR_GREEN_OAK, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_GREEN_OAK_DRAKKAR_ITEM =      createDrakkar("lotr_green_oak", AbstractDrakkarEntity.Type.LOTR_GREEN_OAK, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_GREEN_OAK_ROWBOAT_ITEM =      createRowBoat("lotr_green_oak", AbstractRowBoatEntity.Type.LOTR_GREEN_OAK, LordOfTheRingsMod.isInstalled());

    public static final RegistryObject<Item> LOTR_HOLLY_COG_ITEM =      createCog("lotr_holly", AbstractCogEntity.Type.LOTR_HOLLY, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_HOLLY_GALLEY_ITEM =      createGalley("lotr_holly", AbstractGalleyEntity.Type.LOTR_HOLLY, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_HOLLY_WAR_GALLEY_ITEM =      createWarGalley("lotr_holly", AbstractWarGalleyEntity.Type.LOTR_HOLLY, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_HOLLY_DRAKKAR_ITEM =      createDrakkar("lotr_holly", AbstractDrakkarEntity.Type.LOTR_HOLLY, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_HOLLY_ROWBOAT_ITEM =      createRowBoat("lotr_holly", AbstractRowBoatEntity.Type.LOTR_HOLLY, LordOfTheRingsMod.isInstalled());

    public static final RegistryObject<Item> LOTR_LAIRELOSSE_COG_ITEM =      createCog("lotr_lairelosse", AbstractCogEntity.Type.LOTR_LAIRELOSSE, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_LAIRELOSSE_GALLEY_ITEM =      createGalley("lotr_lairelosse", AbstractGalleyEntity.Type.LOTR_LAIRELOSSE, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_LAIRELOSSE_WAR_GALLEY_ITEM =      createWarGalley("lotr_lairelosse", AbstractWarGalleyEntity.Type.LOTR_LAIRELOSSE, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_LAIRELOSSE_DRAKKAR_ITEM =      createDrakkar("lotr_lairelosse", AbstractDrakkarEntity.Type.LOTR_LAIRELOSSE, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_LAIRELOSSE_ROWBOAT_ITEM =      createRowBoat("lotr_lairelosse", AbstractRowBoatEntity.Type.LOTR_LAIRELOSSE, LordOfTheRingsMod.isInstalled());

    public static final RegistryObject<Item> LOTR_LARCH_COG_ITEM =      createCog("lotr_larch", AbstractCogEntity.Type.LOTR_LARCH, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_LARCH_GALLEY_ITEM =      createGalley("lotr_larch", AbstractGalleyEntity.Type.LOTR_LARCH, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_LARCH_WAR_GALLEY_ITEM =      createWarGalley("lotr_larch", AbstractWarGalleyEntity.Type.LOTR_LARCH, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_LARCH_DRAKKAR_ITEM =      createDrakkar("lotr_larch", AbstractDrakkarEntity.Type.LOTR_LARCH, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_LARCH_ROWBOAT_ITEM =      createRowBoat("lotr_larch", AbstractRowBoatEntity.Type.LOTR_LARCH, LordOfTheRingsMod.isInstalled());

    public static final RegistryObject<Item> LOTR_LEBETHRON_COG_ITEM =      createCog("lotr_lebethron", AbstractCogEntity.Type.LOTR_LEBETHRON, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_LEBETHRON_GALLEY_ITEM =      createGalley("lotr_lebethron", AbstractGalleyEntity.Type.LOTR_LEBETHRON, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_LEBETHRON_WAR_GALLEY_ITEM =      createWarGalley("lotr_lebethron", AbstractWarGalleyEntity.Type.LOTR_LEBETHRON, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_LEBETHRON_DRAKKAR_ITEM =      createDrakkar("lotr_lebethron", AbstractDrakkarEntity.Type.LOTR_LEBETHRON, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_LEBETHRON_ROWBOAT_ITEM =      createRowBoat("lotr_lebethron", AbstractRowBoatEntity.Type.LOTR_LEBETHRON, LordOfTheRingsMod.isInstalled());

    public static final RegistryObject<Item> LOTR_MALLORN_COG_ITEM =      createCog("lotr_mallorn", AbstractCogEntity.Type.LOTR_MALLORN, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_MALLORN_GALLEY_ITEM =      createGalley("lotr_mallorn", AbstractGalleyEntity.Type.LOTR_MALLORN, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_MALLORN_WAR_GALLEY_ITEM =      createWarGalley("lotr_mallorn", AbstractWarGalleyEntity.Type.LOTR_MALLORN, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_MALLORN_DRAKKAR_ITEM =      createDrakkar("lotr_mallorn", AbstractDrakkarEntity.Type.LOTR_MALLORN, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_MALLORN_ROWBOAT_ITEM =      createRowBoat("lotr_mallorn", AbstractRowBoatEntity.Type.LOTR_MALLORN, LordOfTheRingsMod.isInstalled());

    public static final RegistryObject<Item> LOTR_MAPLE_COG_ITEM =      createCog("lotr_maple", AbstractCogEntity.Type.LOTR_MAPLE, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_MAPLE_GALLEY_ITEM =      createGalley("lotr_maple", AbstractGalleyEntity.Type.LOTR_MAPLE, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_MAPLE_WAR_GALLEY_ITEM =      createWarGalley("lotr_maple", AbstractWarGalleyEntity.Type.LOTR_MAPLE, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_MAPLE_DRAKKAR_ITEM =      createDrakkar("lotr_maple", AbstractDrakkarEntity.Type.LOTR_MAPLE, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_MAPLE_ROWBOAT_ITEM =      createRowBoat("lotr_maple", AbstractRowBoatEntity.Type.LOTR_MAPLE, LordOfTheRingsMod.isInstalled());

    public static final RegistryObject<Item> LOTR_MIRK_OAK_COG_ITEM =      createCog("lotr_mirk_oak", AbstractCogEntity.Type.LOTR_MIRK_OAK, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_MIRK_OAK_GALLEY_ITEM =      createGalley("lotr_mirk_oak", AbstractGalleyEntity.Type.LOTR_MIRK_OAK, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_MIRK_OAK_WAR_GALLEY_ITEM =      createWarGalley("lotr_mirk_oak", AbstractWarGalleyEntity.Type.LOTR_MIRK_OAK, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_MIRK_OAK_DRAKKAR_ITEM =      createDrakkar("lotr_mirk_oak", AbstractDrakkarEntity.Type.LOTR_MIRK_OAK, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_MIRK_OAK_ROWBOAT_ITEM =      createRowBoat("lotr_mirk_oak", AbstractRowBoatEntity.Type.LOTR_MIRK_OAK, LordOfTheRingsMod.isInstalled());

    public static final RegistryObject<Item> LOTR_PEAR_COG_ITEM =      createCog("lotr_pear", AbstractCogEntity.Type.LOTR_PEAR, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_PEAR_GALLEY_ITEM =      createGalley("lotr_pear", AbstractGalleyEntity.Type.LOTR_PEAR, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_PEAR_WAR_GALLEY_ITEM =      createWarGalley("lotr_pear", AbstractWarGalleyEntity.Type.LOTR_PEAR, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_PEAR_DRAKKAR_ITEM =      createDrakkar("lotr_pear", AbstractDrakkarEntity.Type.LOTR_PEAR, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_PEAR_ROWBOAT_ITEM =      createRowBoat("lotr_pear", AbstractRowBoatEntity.Type.LOTR_PEAR, LordOfTheRingsMod.isInstalled());

    public static final RegistryObject<Item> LOTR_PINE_COG_ITEM =      createCog("lotr_pine", AbstractCogEntity.Type.LOTR_PINE, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_PINE_GALLEY_ITEM =      createGalley("lotr_pine", AbstractGalleyEntity.Type.LOTR_PINE, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_PINE_WAR_GALLEY_ITEM =      createWarGalley("lotr_pine", AbstractWarGalleyEntity.Type.LOTR_PINE, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_PINE_DRAKKAR_ITEM =      createDrakkar("lotr_pine", AbstractDrakkarEntity.Type.LOTR_PINE, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_PINE_ROWBOAT_ITEM =      createRowBoat("lotr_pine", AbstractRowBoatEntity.Type.LOTR_PINE, LordOfTheRingsMod.isInstalled());

    public static final RegistryObject<Item> LOTR_ROTTEN_COG_ITEM =      createCog("lotr_rotten", AbstractCogEntity.Type.LOTR_ROTTEN, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_ROTTEN_GALLEY_ITEM =      createGalley("lotr_rotten", AbstractGalleyEntity.Type.LOTR_ROTTEN, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_ROTTEN_WAR_GALLEY_ITEM =      createWarGalley("lotr_rotten", AbstractWarGalleyEntity.Type.LOTR_ROTTEN, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_ROTTEN_DRAKKAR_ITEM =      createDrakkar("lotr_rotten", AbstractDrakkarEntity.Type.LOTR_ROTTEN, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_ROTTEN_ROWBOAT_ITEM =      createRowBoat("lotr_rotten", AbstractRowBoatEntity.Type.LOTR_ROTTEN, LordOfTheRingsMod.isInstalled());

    public static final RegistryObject<Item> BOP_CHERRY_BRIGG_ITEM =      createBrigg("bop_cherry", AbstractBriggEntity.Type.BOP_CHERRY, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_DEAD_BRIGG_ITEM =      createBrigg("bop_dead", AbstractBriggEntity.Type.BOP_DEAD, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_FIR_BRIGG_ITEM =      createBrigg("bop_fir", AbstractBriggEntity.Type.BOP_FIR, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_HELLBARK_BRIGG_ITEM =      createBrigg("bop_hellbark", AbstractBriggEntity.Type.BOP_HELLBARK, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_JACARANDA_BRIGG_ITEM =      createBrigg("bop_jacaranda", AbstractBriggEntity.Type.BOP_JACARANDA, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_MAGIC_BRIGG_ITEM =      createBrigg("bop_magic", AbstractBriggEntity.Type.BOP_MAGIC, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_MAHOGANY_BRIGG_ITEM =      createBrigg("bop_mahogany", AbstractBriggEntity.Type.BOP_MAHOGANY, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_PALM_BRIGG_ITEM =      createBrigg("bop_palm", AbstractBriggEntity.Type.BOP_PALM, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_REDWOOD_BRIGG_ITEM =      createBrigg("bop_redwood", AbstractBriggEntity.Type.BOP_REDWOOD, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_UMBRAN_BRIGG_ITEM =      createBrigg("bop_umbran", AbstractBriggEntity.Type.BOP_UMBRAN, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_WILLOW_BRIGG_ITEM =      createBrigg("bop_willow", AbstractBriggEntity.Type.BOP_WILLOW, BiomesOPlenty.isInstalled());

    public static final RegistryObject<Item> BOP_CHERRY_DHOW_ITEM =      createDhow("bop_cherry", AbstractDhowEntity.Type.BOP_CHERRY, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_DEAD_DHOW_ITEM =      createDhow("bop_dead", AbstractDhowEntity.Type.BOP_DEAD, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_FIR_DHOW_ITEM =      createDhow("bop_fir", AbstractDhowEntity.Type.BOP_FIR, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_HELLBARK_DHOW_ITEM =      createDhow("bop_hellbark", AbstractDhowEntity.Type.BOP_HELLBARK, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_JACARANDA_DHOW_ITEM =      createDhow("bop_jacaranda", AbstractDhowEntity.Type.BOP_JACARANDA, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_MAGIC_DHOW_ITEM =      createDhow("bop_magic", AbstractDhowEntity.Type.BOP_MAGIC, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_MAHOGANY_DHOW_ITEM =      createDhow("bop_mahogany", AbstractDhowEntity.Type.BOP_MAHOGANY, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_PALM_DHOW_ITEM =      createDhow("bop_palm", AbstractDhowEntity.Type.BOP_PALM, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_REDWOOD_DHOW_ITEM =      createDhow("bop_redwood", AbstractDhowEntity.Type.BOP_REDWOOD, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_UMBRAN_DHOW_ITEM =      createDhow("bop_umbran", AbstractDhowEntity.Type.BOP_UMBRAN, BiomesOPlenty.isInstalled());
    public static final RegistryObject<Item> BOP_WILLOW_DHOW_ITEM =      createDhow("bop_willow", AbstractDhowEntity.Type.BOP_WILLOW, BiomesOPlenty.isInstalled());

    public static final RegistryObject<Item> LOTR_APPLE_BRIGG_ITEM =      createBrigg("lotr_apple", AbstractBriggEntity.Type.LOTR_APPLE, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_ASPEN_BRIGG_ITEM =      createBrigg("lotr_aspen", AbstractBriggEntity.Type.LOTR_ASPEN, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_BEECH_BRIGG_ITEM =      createBrigg("lotr_beech", AbstractBriggEntity.Type.LOTR_BEECH, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_CEDAR_BRIGG_ITEM =      createBrigg("lotr_cedar", AbstractBriggEntity.Type.LOTR_CEDAR, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_CHARRED_BRIGG_ITEM =      createBrigg("lotr_charred", AbstractBriggEntity.Type.LOTR_CHARRED, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_CHERRY_BRIGG_ITEM =      createBrigg("lotr_cherry", AbstractBriggEntity.Type.LOTR_CHERRY, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_CYPRESS_BRIGG_ITEM =      createBrigg("lotr_cypress", AbstractBriggEntity.Type.LOTR_CYPRESS, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_FIR_BRIGG_ITEM =      createBrigg("lotr_fir", AbstractBriggEntity.Type.LOTR_FIR, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_GREEN_OAK_BRIGG_ITEM =      createBrigg("lotr_green_oak", AbstractBriggEntity.Type.LOTR_GREEN_OAK, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_HOLLY_BRIGG_ITEM =      createBrigg("lotr_holly", AbstractBriggEntity.Type.LOTR_HOLLY, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_LAIRELOSSE_BRIGG_ITEM =      createBrigg("lotr_lairelosse", AbstractBriggEntity.Type.LOTR_LAIRELOSSE, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_LARCH_BRIGG_ITEM =      createBrigg("lotr_larch", AbstractBriggEntity.Type.LOTR_LARCH, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_LEBETHRON_BRIGG_ITEM =      createBrigg("lotr_lebethron", AbstractBriggEntity.Type.LOTR_LEBETHRON, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_MALLORN_BRIGG_ITEM =      createBrigg("lotr_mallorn", AbstractBriggEntity.Type.LOTR_MALLORN, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_MAPLE_BRIGG_ITEM =      createBrigg("lotr_maple", AbstractBriggEntity.Type.LOTR_MAPLE, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_MIRK_OAK_BRIGG_ITEM =      createBrigg("lotr_mirk_oak", AbstractBriggEntity.Type.LOTR_MIRK_OAK, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_PEAR_BRIGG_ITEM =      createBrigg("lotr_pear", AbstractBriggEntity.Type.LOTR_PEAR, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_PINE_BRIGG_ITEM =      createBrigg("lotr_pine", AbstractBriggEntity.Type.LOTR_PINE, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_ROTTEN_BRIGG_ITEM =      createBrigg("lotr_rotten", AbstractBriggEntity.Type.LOTR_ROTTEN, LordOfTheRingsMod.isInstalled());

    public static final RegistryObject<Item> LOTR_APPLE_DHOW_ITEM =      createDhow("lotr_apple", AbstractDhowEntity.Type.LOTR_APPLE, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_ASPEN_DHOW_ITEM =      createDhow("lotr_aspen", AbstractDhowEntity.Type.LOTR_ASPEN, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_BEECH_DHOW_ITEM =      createDhow("lotr_beech", AbstractDhowEntity.Type.LOTR_BEECH, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_CEDAR_DHOW_ITEM =      createDhow("lotr_cedar", AbstractDhowEntity.Type.LOTR_CEDAR, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_CHARRED_DHOW_ITEM =      createDhow("lotr_charred", AbstractDhowEntity.Type.LOTR_CHARRED, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_CHERRY_DHOW_ITEM =      createDhow("lotr_cherry", AbstractDhowEntity.Type.LOTR_CHERRY, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_CYPRESS_DHOW_ITEM =      createDhow("lotr_cypress", AbstractDhowEntity.Type.LOTR_CYPRESS, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_FIR_DHOW_ITEM =      createDhow("lotr_fir", AbstractDhowEntity.Type.LOTR_FIR, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_GREEN_OAK_DHOW_ITEM =      createDhow("lotr_green_oak", AbstractDhowEntity.Type.LOTR_GREEN_OAK, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_HOLLY_DHOW_ITEM =      createDhow("lotr_holly", AbstractDhowEntity.Type.LOTR_HOLLY, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_LAIRELOSSE_DHOW_ITEM =      createDhow("lotr_lairelosse", AbstractDhowEntity.Type.LOTR_LAIRELOSSE, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_LARCH_DHOW_ITEM =      createDhow("lotr_larch", AbstractDhowEntity.Type.LOTR_LARCH, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_LEBETHRON_DHOW_ITEM =      createDhow("lotr_lebethron", AbstractDhowEntity.Type.LOTR_LEBETHRON, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_MALLORN_DHOW_ITEM =      createDhow("lotr_mallorn", AbstractDhowEntity.Type.LOTR_MALLORN, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_MAPLE_DHOW_ITEM =      createDhow("lotr_maple", AbstractDhowEntity.Type.LOTR_MAPLE, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_MIRK_OAK_DHOW_ITEM =      createDhow("lotr_mirk_oak", AbstractDhowEntity.Type.LOTR_MIRK_OAK, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_PEAR_DHOW_ITEM =      createDhow("lotr_pear", AbstractDhowEntity.Type.LOTR_PEAR, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_PINE_DHOW_ITEM =      createDhow("lotr_pine", AbstractDhowEntity.Type.LOTR_PINE, LordOfTheRingsMod.isInstalled());
    public static final RegistryObject<Item> LOTR_ROTTEN_DHOW_ITEM =      createDhow("lotr_rotten", AbstractDhowEntity.Type.LOTR_ROTTEN, LordOfTheRingsMod.isInstalled());

    public static final RegistryObject<Item> ENVI_CHERRY_COG_ITEM =      createCog("envi_cherry", AbstractCogEntity.Type.ENVI_CHERRY, Environmental.isInstalled());
    public static final RegistryObject<Item> ENVI_WISTERIA_COG_ITEM =      createCog("envi_wisteria", AbstractCogEntity.Type.ENVI_WISTERIA, Environmental.isInstalled());
    public static final RegistryObject<Item> ENVI_WILLOW_COG_ITEM =      createCog("envi_willow", AbstractCogEntity.Type.ENVI_WILLOW, Environmental.isInstalled());
    public static final RegistryObject<Item> ENVI_CHERRY_GALLEY_ITEM =      createGalley("envi_cherry", AbstractGalleyEntity.Type.ENVI_CHERRY, Environmental.isInstalled());
    public static final RegistryObject<Item> ENVI_WISTERIA_GALLEY_ITEM =      createGalley("envi_wisteria", AbstractGalleyEntity.Type.ENVI_WISTERIA, Environmental.isInstalled());
    public static final RegistryObject<Item> ENVI_WILLOW_GALLEY_ITEM =      createGalley("envi_willow", AbstractGalleyEntity.Type.ENVI_WILLOW, Environmental.isInstalled());
    public static final RegistryObject<Item> ENVI_CHERRY_WAR_GALLEY_ITEM =      createWarGalley("envi_cherry", AbstractWarGalleyEntity.Type.ENVI_CHERRY, Environmental.isInstalled());
    public static final RegistryObject<Item> ENVI_WISTERIA_WAR_GALLEY_ITEM =      createWarGalley("envi_wisteria", AbstractWarGalleyEntity.Type.ENVI_WISTERIA, Environmental.isInstalled());
    public static final RegistryObject<Item> ENVI_WILLOW_WAR_GALLEY_ITEM =      createWarGalley("envi_willow", AbstractWarGalleyEntity.Type.ENVI_WILLOW, Environmental.isInstalled());
    public static final RegistryObject<Item> ENVI_CHERRY_DRAKKAR_ITEM =      createDrakkar("envi_cherry", AbstractDrakkarEntity.Type.ENVI_CHERRY, Environmental.isInstalled());
    public static final RegistryObject<Item> ENVI_WISTERIA_DRAKKAR_ITEM =      createDrakkar("envi_wisteria", AbstractDrakkarEntity.Type.ENVI_WISTERIA, Environmental.isInstalled());
    public static final RegistryObject<Item> ENVI_WILLOW_DRAKKAR_ITEM =      createDrakkar("envi_willow", AbstractDrakkarEntity.Type.ENVI_WILLOW, Environmental.isInstalled());
    public static final RegistryObject<Item> ENVI_CHERRY_ROWBOAT_ITEM =      createRowBoat("envi_cherry", AbstractRowBoatEntity.Type.ENVI_CHERRY, Environmental.isInstalled());
    public static final RegistryObject<Item> ENVI_WISTERIA_ROWBOAT_ITEM =      createRowBoat("envi_wisteria", AbstractRowBoatEntity.Type.ENVI_WISTERIA, Environmental.isInstalled());
    public static final RegistryObject<Item> ENVI_WILLOW_ROWBOAT_ITEM =      createRowBoat("envi_willow", AbstractRowBoatEntity.Type.ENVI_WILLOW, Environmental.isInstalled());
    public static final RegistryObject<Item> ENVI_CHERRY_BRIGG_ITEM =      createBrigg("envi_cherry", AbstractBriggEntity.Type.ENVI_CHERRY, Environmental.isInstalled());
    public static final RegistryObject<Item> ENVI_WISTERIA_BRIGG_ITEM =      createBrigg("envi_wisteria", AbstractBriggEntity.Type.ENVI_WISTERIA, Environmental.isInstalled());
    public static final RegistryObject<Item> ENVI_WILLOW_BRIGG_ITEM =      createBrigg("envi_willow", AbstractBriggEntity.Type.ENVI_WILLOW, Environmental.isInstalled());
    public static final RegistryObject<Item> ENVI_CHERRY_DHOW_ITEM =      createDhow("envi_cherry", AbstractDhowEntity.Type.ENVI_CHERRY, Environmental.isInstalled());
    public static final RegistryObject<Item> ENVI_WISTERIA_DHOW_ITEM =      createDhow("envi_wisteria", AbstractDhowEntity.Type.ENVI_WISTERIA, Environmental.isInstalled());
    public static final RegistryObject<Item> ENVI_WILLOW_DHOW_ITEM =      createDhow("envi_willow", AbstractDhowEntity.Type.ENVI_WILLOW, Environmental.isInstalled());


 */
    private static RegistryObject<Item> createCog(String name, AbstractSailShip.Type type, boolean compatiblity ){
        return ITEMS.register(name + "_cog", () -> new CogItem(type, (new Item.Properties()).stacksTo(1).tab(compatiblity ? CreativeModeTab.TAB_TRANSPORTATION : null)));
    }
/*
    private static RegistryObject<Item> createGalley(String name, AbstractSailShip.Type type, boolean compatiblity ){
        return ITEMS.register(name + "_galley", () -> new GalleyItem(type, (new Item.Properties()).stacksTo(1).tab(compatiblity ? ItemGroup.TAB_TRANSPORTATION : null)));
    }

    private static RegistryObject<Item> createWarGalley(String name, AbstractSailShip.Type type, boolean compatiblity ){
        return ITEMS.register(name + "_war_galley", () -> new WarGalleyItem(type, (new Item.Properties()).stacksTo(1).tab(compatiblity ? ItemGroup.TAB_TRANSPORTATION : null)));
    }

    private static RegistryObject<Item> createDrakkar(String name, AbstractSailShip.Type type, boolean compatiblity ){
        return ITEMS.register(name + "_drakkar", () -> new DrakkarItem(type, (new Item.Properties()).stacksTo(1).tab(compatiblity ? ItemGroup.TAB_TRANSPORTATION : null)));
    }

    private static RegistryObject<Item> createRowBoat(String name, AbstractSailShip.Type type, boolean compatiblity ){
        return ITEMS.register(name + "_rowboat", () -> new RowBoatItem(type, (new Item.Properties()).stacksTo(1).tab(compatiblity ? ItemGroup.TAB_TRANSPORTATION : null)));
    }

    private static RegistryObject<Item> createBrigg(String name, AbstractSailShip.Type type, boolean compatiblity ){
        return ITEMS.register(name + "_brigg", () -> new BriggItem(type, (new Item.Properties()).stacksTo(1).tab(compatiblity ? ItemGroup.TAB_TRANSPORTATION : null)));
    }

    private static RegistryObject<Item> createDhow(String name, AbstractSailShip.Type type, boolean compatiblity ){
        return ITEMS.register(name + "_dhow", () -> new DhowItem(type, (new Item.Properties()).stacksTo(1).tab(compatiblity ? ItemGroup.TAB_TRANSPORTATION : null)));
    }

 */
}

