package com.talhanation.smallships.client.model.sail;

import com.talhanation.smallships.SmallshipsMod;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.client.model.EntityModel;
import net.minecraft.resources.ResourceLocation;

import java.util.Arrays;

public abstract class SailModel extends EntityModel<Ship> {

    public static SailModel.Color getSailColor(String stringColor) {
        return Arrays.stream(Color.values()).filter(color -> color.toString().equals(stringColor)).findAny().orElse(Color.WHITE);
    }

    public enum Color {
        WHITE(new ResourceLocation(SmallshipsMod.MOD_ID,"textures/entity/sail/white_sail.png")),
        ORANGE(new ResourceLocation(SmallshipsMod.MOD_ID,"textures/entity/sail/orange_sail.png")),
        MAGENTA(new ResourceLocation(SmallshipsMod.MOD_ID,"textures/entity/sail/magenta_sail.png")),
        LIGHT_BLUE(new ResourceLocation(SmallshipsMod.MOD_ID,"textures/entity/sail/light_blue_sail.png")),
        YELLOW(new ResourceLocation(SmallshipsMod.MOD_ID,"textures/entity/sail/yellow_sail.png")),
        LIME(new ResourceLocation(SmallshipsMod.MOD_ID,"textures/entity/sail/lime_sail.png")),
        PINK(new ResourceLocation(SmallshipsMod.MOD_ID,"textures/entity/sail/pink_sail.png")),
        GRAY(new ResourceLocation(SmallshipsMod.MOD_ID,"textures/entity/sail/gray_sail.png")),
        LIGHT_GRAY(new ResourceLocation(SmallshipsMod.MOD_ID,"textures/entity/sail/light_gray_sail.png")),
        CYAN(new ResourceLocation(SmallshipsMod.MOD_ID,"textures/entity/sail/cyan_sail.png")),
        PURPLE(new ResourceLocation(SmallshipsMod.MOD_ID,"textures/entity/sail/purple_sail.png")),
        BLUE(new ResourceLocation(SmallshipsMod.MOD_ID,"textures/entity/sail/blue_sail.png")),
        BROWN(new ResourceLocation(SmallshipsMod.MOD_ID,"textures/entity/sail/brown_sail.png")),
        GREEN(new ResourceLocation(SmallshipsMod.MOD_ID,"textures/entity/sail/green_sail.png")),
        RED(new ResourceLocation(SmallshipsMod.MOD_ID,"textures/entity/sail/red_sail.png")),
        BLACK(new ResourceLocation(SmallshipsMod.MOD_ID,"textures/entity/sail/black_sail.png"));

        public final ResourceLocation location;

        Color(ResourceLocation location) {
            this.location = location;
        }

        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    }
}
