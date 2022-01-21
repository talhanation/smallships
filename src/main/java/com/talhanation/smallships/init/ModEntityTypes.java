package com.talhanation.smallships.init;

import com.talhanation.smallships.Main;
import net.minecraft.entity.EntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class ModEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Main.MOD_ID);
/*
    public static final RegistryObject<EntityType<CogEntity>> COG_ENTITY = ENTITY_TYPES.register("cog",
            () -> EntityType.Builder.<CogEntity>of(CogEntity::new, EntityClassification.MISC)
                    .sized(3.5F, 1.25F)
                    .clientTrackingRange(20)
                    .setUpdateInterval(10)
                    .setShouldReceiveVelocityUpdates(true)
                    .build(new ResourceLocation(Main.MOD_ID, "cog").toString()));
*/
}