package com.talhanation.smallships.world.item;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.api.ShipItems;
import com.talhanation.smallships.world.entity.ship.BriggEntity;
import com.talhanation.smallships.world.entity.ship.CaravelEntity;
import com.talhanation.smallships.world.entity.ship.CogEntity;
import com.talhanation.smallships.world.entity.ship.DhowEntity;
import com.talhanation.smallships.world.entity.ship.DrakkarEntity;
import com.talhanation.smallships.world.entity.ship.GalleonEntity;
import com.talhanation.smallships.world.entity.ship.GalleyEntity;

/**
 * The main mods' ship items, registered through {@link ShipItems} exactly the
 * way an addon registers its own - the main mod is its first user, not a
 * special case.
 *
 * Kept apart from ModItems on purpose: ModItems looks its items up while the
 * class loads, which on Forge only works after the register event. This has
 * to run BEFORE it - in the mod constructor on Forge, in onInitialize on
 * Fabric.
 */
public class ModShipItems {

    public static void register() {
        ShipItems.register(SmallShipsMod.MOD_ID, CogEntity.ID, CogEntity::summon);
        ShipItems.register(SmallShipsMod.MOD_ID, BriggEntity.ID, BriggEntity::summon);
        ShipItems.register(SmallShipsMod.MOD_ID, GalleyEntity.ID, GalleyEntity::summon);
        ShipItems.register(SmallShipsMod.MOD_ID, DhowEntity.ID, DhowEntity::summon);
        ShipItems.register(SmallShipsMod.MOD_ID, DrakkarEntity.ID, DrakkarEntity::summon);
        ShipItems.register(SmallShipsMod.MOD_ID, GalleonEntity.ID, GalleonEntity::summon);
        ShipItems.register(SmallShipsMod.MOD_ID, CaravelEntity.ID, CaravelEntity::summon);
    }
}
