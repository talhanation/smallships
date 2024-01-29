package com.talhanation.smallships.world.entity.fabric;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.entity.projectile.CannonBallEntity;
import com.talhanation.smallships.world.entity.ship.BriggEntity;
import com.talhanation.smallships.world.entity.ship.CogEntity;
import com.talhanation.smallships.world.entity.ship.DrakkarEntity;
import com.talhanation.smallships.world.entity.ship.GalleyEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
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
        return Registry.register(Registry.ENTITY_TYPE, new ResourceLocation(SmallShipsMod.MOD_ID, id), type);
    }

    static {
        entries.put(CannonBallEntity.class, register(CannonBallEntity.ID, FabricEntityTypeBuilder
                .create(MobCategory.MISC, CannonBallEntity::factory)
                .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                .trackedUpdateRate(10)
                .forceTrackedVelocityUpdates(true)
                .build()));

        entries.put(CogEntity.class, register(CogEntity.ID, FabricEntityTypeBuilder
                .create(MobCategory.MISC, CogEntity::new)
                .dimensions(EntityDimensions.fixed(3.5F, 1.25F))
                .trackedUpdateRate(10)
                .forceTrackedVelocityUpdates(true)
                .build()));

        entries.put(BriggEntity.class, register(BriggEntity.ID, FabricEntityTypeBuilder
                .create(MobCategory.MISC, BriggEntity::new)
                .dimensions(EntityDimensions.fixed(3.5F, 1.25F))
                .trackedUpdateRate(10)
                .forceTrackedVelocityUpdates(true)
                .build()));

        entries.put(GalleyEntity.class, register(GalleyEntity.ID, FabricEntityTypeBuilder
                .create(MobCategory.MISC, GalleyEntity::new)
                .dimensions(EntityDimensions.fixed(3.5F, 1.25F))
                .trackedUpdateRate(10)
                .forceTrackedVelocityUpdates(true)
                .build()));

        entries.put(DrakkarEntity.class, register(DrakkarEntity.ID, FabricEntityTypeBuilder
                .create(MobCategory.MISC, DrakkarEntity::new)
                .dimensions(EntityDimensions.fixed(3.5F, 1.25F))
                .trackedUpdateRate(10)
                .forceTrackedVelocityUpdates(true)
                .build()));
    }
}
