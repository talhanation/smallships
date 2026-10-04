package com.talhanation.smallships.client.model.sail;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;

import java.util.Arrays;

public abstract class SailModel extends EntityModel<Ship> {

    /**
     * Shows the parts of ONE sail that belong to the given sail state. Every
     * sail of every ship is cut the same way, so the rule lives here once:
     *
     * - the furled sail is there at state 0 and only then
     * - the set sail is built from four strips, top down. Strip n hangs from
     *   state n on and stays, the next state only adds the strip below it
     * - the lowest strip of the states 1 to 3 gets its own edge, shown in that
     *   one state only. At state 4 the last strip is the edge itself.
     *
     * The ropes are not part of this: which rope belongs to which state is a
     * plain "state == n" in the model that owns them.
     *
     * @param state the sail state, 0 = furled up to 4 = fully set
     */
    protected static void showSail(int state, ModelPart furled,
                                   ModelPart strip1, ModelPart strip2, ModelPart strip3, ModelPart strip4,
                                   ModelPart edge1, ModelPart edge2, ModelPart edge3) {
        furled.visible = state == 0;

        strip1.visible = state >= 1;
        strip2.visible = state >= 2;
        strip3.visible = state >= 3;
        strip4.visible = state >= 4;

        edge1.visible = state == 1;
        edge2.visible = state == 2;
        edge3.visible = state == 3;
    }

    public static SailModel.Color getSailColor(String stringColor) {
        return Arrays.stream(Color.values()).filter(color -> color.toString().equals(stringColor)).findAny().orElse(Color.WHITE);
    }

    public enum Color {
        WHITE(new ResourceLocation(SmallShipsMod.MOD_ID,"textures/entity/sail/white_sail.png")),
        ORANGE(new ResourceLocation(SmallShipsMod.MOD_ID,"textures/entity/sail/orange_sail.png")),
        MAGENTA(new ResourceLocation(SmallShipsMod.MOD_ID,"textures/entity/sail/magenta_sail.png")),
        LIGHT_BLUE(new ResourceLocation(SmallShipsMod.MOD_ID,"textures/entity/sail/light_blue_sail.png")),
        YELLOW(new ResourceLocation(SmallShipsMod.MOD_ID,"textures/entity/sail/yellow_sail.png")),
        LIME(new ResourceLocation(SmallShipsMod.MOD_ID,"textures/entity/sail/lime_sail.png")),
        PINK(new ResourceLocation(SmallShipsMod.MOD_ID,"textures/entity/sail/pink_sail.png")),
        GRAY(new ResourceLocation(SmallShipsMod.MOD_ID,"textures/entity/sail/gray_sail.png")),
        LIGHT_GRAY(new ResourceLocation(SmallShipsMod.MOD_ID,"textures/entity/sail/light_gray_sail.png")),
        CYAN(new ResourceLocation(SmallShipsMod.MOD_ID,"textures/entity/sail/cyan_sail.png")),
        PURPLE(new ResourceLocation(SmallShipsMod.MOD_ID,"textures/entity/sail/purple_sail.png")),
        BLUE(new ResourceLocation(SmallShipsMod.MOD_ID,"textures/entity/sail/blue_sail.png")),
        BROWN(new ResourceLocation(SmallShipsMod.MOD_ID,"textures/entity/sail/brown_sail.png")),
        GREEN(new ResourceLocation(SmallShipsMod.MOD_ID,"textures/entity/sail/green_sail.png")),
        RED(new ResourceLocation(SmallShipsMod.MOD_ID,"textures/entity/sail/red_sail.png")),
        BLACK(new ResourceLocation(SmallShipsMod.MOD_ID,"textures/entity/sail/black_sail.png"));

        public final ResourceLocation location;
        /** torn variant of the sail texture, used at 50 sail HP or below */
        public final ResourceLocation damagedLocation;

        Color(ResourceLocation location) {
            this.location = location;
            this.damagedLocation = new ResourceLocation(location.getNamespace(), location.getPath().replace("_sail.png", "_sail_damaged.png"));
        }

        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    }
}
