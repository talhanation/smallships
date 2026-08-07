package com.talhanation.smallships.world.entity;

import com.talhanation.smallships.world.entity.cannon.GroundCannonEntity;
import com.talhanation.smallships.world.entity.projectile.CannonBallEntity;
import com.talhanation.smallships.world.entity.projectile.ChainShotEntity;
import com.talhanation.smallships.world.entity.projectile.GrapeShotEntity;
import com.talhanation.smallships.world.entity.ship.*;
import com.talhanation.smallships.world.entity.ship.hitbox.ShipPartEntity;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

public class ModEntityTypes {
    public static final EntityType<CannonBallEntity> CANNON_BALL = getEntityType(CannonBallEntity.class);
    public static final EntityType<ChainShotEntity> CHAIN_SHOT = getEntityType(ChainShotEntity.class);
    public static final EntityType<GrapeShotEntity> GRAPE_SHOT = getEntityType(GrapeShotEntity.class);
    public static final EntityType<CogEntity> COG = getEntityType(CogEntity.class);
    public static final EntityType<BriggEntity> BRIGG = getEntityType(BriggEntity.class);
    public static final EntityType<GalleyEntity> GALLEY = getEntityType(GalleyEntity.class);
    public static final EntityType<DhowEntity> DHOW = getEntityType(DhowEntity.class);
    public static final EntityType<DrakkarEntity> DRAKKAR = getEntityType(DrakkarEntity.class);
    public static final EntityType<GalleonEntity> GALLEON = getEntityType(GalleonEntity.class);
    public static final EntityType<CaravelEntity> CARAVEL = getEntityType(CaravelEntity.class);
    public static final EntityType<GroundCannonEntity> GROUND_CANNON = getEntityType(GroundCannonEntity.class);
    public static final EntityType<ShipPartEntity> SHIP_PART = getEntityType(ShipPartEntity.class);

    @ExpectPlatform
    public static <T extends Entity> EntityType<T> getEntityType(Class<T> entityClass) {
        throw new AssertionError();
    }
}