package com.talhanation.smallships.world.entity.fabric;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.entity.cannon.GroundCannonEntity;
import com.talhanation.smallships.world.entity.projectile.CannonBallEntity;
import com.talhanation.smallships.world.entity.ship.BriggEntity;
import com.talhanation.smallships.world.entity.ship.CogEntity;
import com.talhanation.smallships.world.entity.ship.DrakkarEntity;
import com.talhanation.smallships.world.entity.ship.GalleyEntity;
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
        entries.put(CannonBallEntity.class, register(CannonBallEntity.ID, EntityType.Builder.of(CannonBallEntity::factory, MobCategory.MISC)
                .sized(0.25F, 0.25F)
                .clientTrackingRange(20)
                .updateInterval(10)
                .build()));

        entries.put(GroundCannonEntity.class, register(GroundCannonEntity.ID, EntityType.Builder.of(GroundCannonEntity::factory, MobCategory.MISC)
                .sized(0.85F, 0.75F)
                .clientTrackingRange(20)
                .build()));

        entries.put(CogEntity.class, register(CogEntity.ID, EntityType.Builder.of(CogEntity::new, MobCategory.MISC)
                .sized(3.5F, 1.25F)
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

        entries.put(DrakkarEntity.class, register(DrakkarEntity.ID, EntityType.Builder.of(DrakkarEntity::new, MobCategory.MISC)
                .sized(3.5F, 1.25F)
                .clientTrackingRange(20)
                .updateInterval(10)
                .build()));
    }
}
