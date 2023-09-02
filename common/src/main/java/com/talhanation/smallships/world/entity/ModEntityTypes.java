package com.talhanation.smallships.world.entity;

import com.talhanation.smallships.world.entity.projectile.CannonBallEntity;
import com.talhanation.smallships.world.entity.ship.BriggEntity;
import com.talhanation.smallships.world.entity.ship.CogEntity;
import com.talhanation.smallships.world.entity.ship.GalleyEntity;
import com.talhanation.smallships.world.entity.shipyard.ShipyardShip;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModEntityTypes {
    public static final EntityType<CannonBallEntity> CANNON_BALL = getEntityType(CannonBallEntity.class);
    public static final EntityType<CogEntity> COG = getEntityType(CogEntity.class);
    public static final EntityType<BriggEntity> BRIGG = getEntityType(BriggEntity.class);
    public static final EntityType<GalleyEntity> GALLEY = getEntityType(GalleyEntity.class);

    public static final BlockEntityType<ShipyardShip> SHIPYARD_SHIP = getBlockEntityType(ShipyardShip.class);

    @ExpectPlatform
    public static <T extends Entity> EntityType<T> getEntityType(Class<T> entityClass) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <T extends BlockEntity> BlockEntityType<T> getBlockEntityType(Class<T> entityClass) {
        throw new AssertionError();
    }
}
