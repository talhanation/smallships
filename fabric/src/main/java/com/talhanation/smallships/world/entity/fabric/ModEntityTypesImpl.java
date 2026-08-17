package com.talhanation.smallships.world.entity.fabric;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.entity.cannon.GroundCannonEntity;
import com.talhanation.smallships.world.entity.projectile.CannonBallEntity;
import com.talhanation.smallships.world.entity.projectile.ChainShotEntity;
import com.talhanation.smallships.world.entity.projectile.GrapeShotEntity;
import com.talhanation.smallships.world.entity.ship.*;
import com.talhanation.smallships.world.entity.ship.hitbox.ShipPartEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import java.util.HashMap;
import java.util.Map;

public class ModEntityTypesImpl {
    private static final Map<Class<? extends Entity>, EntityType<? extends Entity>> entries = new HashMap<>();

    @SuppressWarnings("unchecked")
    public static <T extends Entity> EntityType<T> getEntityType(Class<T> entityClass) {
        return (EntityType<T>) entries.get(entityClass);
    }

    private static <T extends Entity> EntityType<T> register(String id, EntityType<T> type) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, id), type);
    }

    static {
        // The size here is only the placeholder until the synched data arrives -
        // every part overrides getDimensions from its own width and height.
        // updateInterval is deliberately high: a part recomputes its position
        // from its ship on both sides every tick, so position packets are pure
        // overhead, and a Brigg alone carries five of these.
        // noSummon keeps players from spawning a parentless part by command.
        entries.put(ShipPartEntity.class, register(ShipPartEntity.ID, EntityType.Builder.of(ShipPartEntity::factory, MobCategory.MISC)
                .sized(1.0F, 1.0F)
                .noSummon()
                .clientTrackingRange(20)
                .updateInterval(Integer.MAX_VALUE)
                .build()));

        entries.put(CannonBallEntity.class, register(CannonBallEntity.ID, EntityType.Builder.of(CannonBallEntity::factory, MobCategory.MISC)
                .sized(0.25F, 0.25F)
                .clientTrackingRange(20)
                .updateInterval(10)
                .build()));

        entries.put(ChainShotEntity.class, register(ChainShotEntity.ID, EntityType.Builder.of(ChainShotEntity::factory, MobCategory.MISC)
                .sized(1.00F, 0.25F)
                .clientTrackingRange(20)
                .updateInterval(10)
                .build()));

        entries.put(GrapeShotEntity.class, register(GrapeShotEntity.ID, EntityType.Builder.of(GrapeShotEntity::factory, MobCategory.MISC)
                .sized(0.25F, 0.25F)
                .clientTrackingRange(20)
                .updateInterval(10)
                .build()));

        entries.put(GroundCannonEntity.class, register(GroundCannonEntity.ID, EntityType.Builder.of(GroundCannonEntity::factory, MobCategory.MISC)
                .sized(0.85F, 0.75F)
                .clientTrackingRange(20)
                .build()));

        entries.put(CogEntity.class, register(CogEntity.ID, EntityType.Builder.of(CogEntity::new, MobCategory.MISC)
                .sized(1.0F, 1.25F)
                .clientTrackingRange(20)
                .updateInterval(10)
                .build()));

        entries.put(BriggEntity.class, register(BriggEntity.ID, EntityType.Builder.of(BriggEntity::new, MobCategory.MISC)
                .sized(3.5F, 1.25F)
                .clientTrackingRange(20)
                .updateInterval(10)
                .build()));

        entries.put(GalleyEntity.class, register(GalleyEntity.ID, EntityType.Builder.of(GalleyEntity::new, MobCategory.MISC)
                .sized(3.5F, 1.25F)
                .clientTrackingRange(20)
                .updateInterval(10)
                .build()));

        entries.put(DhowEntity.class, register(DhowEntity.ID, EntityType.Builder.of(DhowEntity::new, MobCategory.MISC)
                .sized(3.5F, 1.25F)
                .clientTrackingRange(20)
                .updateInterval(10)
                .build()));

        entries.put(DrakkarEntity.class, register(DrakkarEntity.ID, EntityType.Builder.of(DrakkarEntity::new, MobCategory.MISC)
                .sized(3.5F, 1.25F)
                .clientTrackingRange(20)
                .updateInterval(10)
                .build()));

        entries.put(GalleonEntity.class, register(GalleonEntity.ID, EntityType.Builder.of(GalleonEntity::new, MobCategory.MISC)
                .sized(3.5F, 1.25F)
                .clientTrackingRange(20)
                .updateInterval(10)
                .build()));

        entries.put(CaravelEntity.class, register(CaravelEntity.ID, EntityType.Builder.of(CaravelEntity::new, MobCategory.MISC)
                .sized(3.5F, 1.25F)
                .clientTrackingRange(20)
                .updateInterval(10)
                .build()));
    }
}