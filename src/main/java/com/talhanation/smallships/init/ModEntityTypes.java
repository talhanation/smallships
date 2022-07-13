package com.talhanation.smallships.init;

import com.talhanation.smallships.Main;
import com.talhanation.smallships.entities.BriggEntity;
import com.talhanation.smallships.entities.CogEntity;
import com.talhanation.smallships.entities.projectile.CannonBallEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Main.MOD_ID);

    public static final RegistryObject<EntityType<CogEntity>> COG = ENTITY_TYPES.register("cog",
            () -> EntityType.Builder.<CogEntity>of(CogEntity::new, MobCategory.MISC)
                    .sized(3.5F, 1.25F)
                    .clientTrackingRange(20)
                    .setUpdateInterval(10)
                    .setShouldReceiveVelocityUpdates(true)
                    .build(ResLocation.COG.toString()));

    public static final RegistryObject<EntityType<BriggEntity>> BRIGG = ENTITY_TYPES.register("brigg",
            () -> EntityType.Builder.<BriggEntity>of(BriggEntity::new, MobCategory.MISC)
                    .clientTrackingRange(20)
                    .setUpdateInterval(10)
                    .setShouldReceiveVelocityUpdates(true)
                    .build(ResLocation.BRIGG.toString()));

/*
    public static final RegistryObject<EntityType<SailShipPart>> SHIP_PART = ENTITY_TYPES.register("ship_part",
            () -> EntityType.Builder.<SailShipPart>of(SailShipPart::new, EntityClassification.MISC)
                    .sized(3.5F, 1.25F)
                    .clientTrackingRange(20)
                    .setUpdateInterval(10)
                    .setShouldReceiveVelocityUpdates(true)
                    .build(new ResourceLocation(Main.MOD_ID, "ship_part").toString()));
    */
    public static final RegistryObject<EntityType<CannonBallEntity>> CANNON_BALL = ENTITY_TYPES.register("cannon_ball",
            () -> EntityType.Builder.<CannonBallEntity>of(CannonBallEntity::new, MobCategory.MISC)
                    .sized(0.25F, 0.25F)
                    .clientTrackingRange(20)
                    .setUpdateInterval(10)
                    .setShouldReceiveVelocityUpdates(true)
                    .build(ResLocation.CANNON_BALL.toString()));

    public static class ResLocation {
        public static final ResourceLocation COG = new ResourceLocation(Main.MOD_ID, "cog");
        public static final ResourceLocation BRIGG = new ResourceLocation(Main.MOD_ID, "brigg");
        public static final ResourceLocation CANNON_BALL = new ResourceLocation(Main.MOD_ID, "cannon_ball");
    }
}