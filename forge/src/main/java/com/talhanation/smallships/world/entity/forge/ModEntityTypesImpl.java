package com.talhanation.smallships.world.entity.forge;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.entity.cannon.GroundCannonEntity;
import com.talhanation.smallships.world.entity.projectile.CannonBallEntity;
import com.talhanation.smallships.world.entity.ship.BriggEntity;
import com.talhanation.smallships.world.entity.ship.CogEntity;
import com.talhanation.smallships.world.entity.ship.DrakkarEntity;
import com.talhanation.smallships.world.entity.ship.GalleyEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModEntityTypesImpl {
    private static final Map<Class<? extends Entity>, RegistryObject<EntityType<? extends Entity>>> entries = new HashMap<>();

    @SuppressWarnings("unchecked")
    public static <T extends Entity> EntityType<T> getEntityType(Class<T> entityClass) {
        return (EntityType<T>) entries.get(entityClass).get();
    }
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SmallShipsMod.MOD_ID);

    private static RegistryObject<EntityType<? extends Entity>> register(String id, Supplier<EntityType.Builder<? extends Entity>> builder) {
        ResourceLocation rl = ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, id);
        return ENTITY_TYPES.register(id, () -> builder.get().build(ResourceKey.create(Registries.ENTITY_TYPE, rl)));
    }

    static {
        entries.put(CannonBallEntity.class, register(CannonBallEntity.ID,
                () -> EntityType.Builder.of(CannonBallEntity::factory, MobCategory.MISC)
                        .sized(0.25F, 0.25F)
                        .clientTrackingRange(20)
                        .setUpdateInterval(10)
                        .setShouldReceiveVelocityUpdates(true)));

        entries.put(GroundCannonEntity.class, register(GroundCannonEntity.ID,
                () -> EntityType.Builder.of(GroundCannonEntity::factory, MobCategory.MISC)
                        .sized(0.85F, 0.75F)
                        .clientTrackingRange(20)
                        .setUpdateInterval(10)
                        .setShouldReceiveVelocityUpdates(true)));

        entries.put(CogEntity.class, register(CogEntity.ID,
                () -> EntityType.Builder.of(CogEntity::new, MobCategory.MISC)
                        .sized(3.5F, 1.25F)
                        .clientTrackingRange(20)
                        .setUpdateInterval(10)
                        .setShouldReceiveVelocityUpdates(true)));

        entries.put(BriggEntity.class, register(BriggEntity.ID,
                () -> EntityType.Builder.of(BriggEntity::new, MobCategory.MISC)
                        .sized(3.5F, 1.25F)
                        .clientTrackingRange(20)
                        .setUpdateInterval(10)
                        .setShouldReceiveVelocityUpdates(true)));

        entries.put(GalleyEntity.class, register(GalleyEntity.ID,
                () -> EntityType.Builder.of(GalleyEntity::new, MobCategory.MISC)
                        .sized(3.5F, 1.25F)
                        .clientTrackingRange(20)
                        .setUpdateInterval(10)
                        .setShouldReceiveVelocityUpdates(true)));

        entries.put(DrakkarEntity.class, register(DrakkarEntity.ID,
                () -> EntityType.Builder.of(DrakkarEntity::new, MobCategory.MISC)
                        .sized(3.5F, 1.25F)
                        .clientTrackingRange(20)
                        .setUpdateInterval(10)
                        .setShouldReceiveVelocityUpdates(true)));
    }
}
