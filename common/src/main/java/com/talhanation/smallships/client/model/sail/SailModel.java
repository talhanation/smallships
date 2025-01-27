package com.talhanation.smallships.client.model.sail;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.client.renderer.entity.state.ShipRenderState;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;

import java.util.Arrays;

public abstract class SailModel extends EntityModel<ShipRenderState> {
    protected ModelPart[] sailParts;

    protected SailModel(ModelPart modelPart) {
        super(modelPart);

        ModelPart sail = modelPart.getChild("Sail");
        sailParts = new ModelPart[] { sail.getChild("Sail_0"), sail.getChild("Sail_1"), sail.getChild("Sail_2"), sail.getChild("Sail_3"), sail.getChild("Sail_4") };
    }

    public static SailModel.Color getSailColor(String stringColor) {
        return Arrays.stream(Color.values()).filter(color -> color.toString().equals(stringColor)).findAny().orElse(Color.WHITE);
    }

    @Override
    public void setupAnim(ShipRenderState state) {
        byte sailState = state.sailable.getSailState();
        Arrays.stream(sailParts).forEach(sailPart -> sailPart.visible = false);
        sailParts[sailState].visible = true;

        super.setupAnim(state);
    }

    public enum Color {
        WHITE(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID,"textures/entity/sail/white_sail.png")),
        ORANGE(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID,"textures/entity/sail/orange_sail.png")),
        MAGENTA(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID,"textures/entity/sail/magenta_sail.png")),
        LIGHT_BLUE(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID,"textures/entity/sail/light_blue_sail.png")),
        YELLOW(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID,"textures/entity/sail/yellow_sail.png")),
        LIME(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID,"textures/entity/sail/lime_sail.png")),
        PINK(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID,"textures/entity/sail/pink_sail.png")),
        GRAY(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID,"textures/entity/sail/gray_sail.png")),
        LIGHT_GRAY(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID,"textures/entity/sail/light_gray_sail.png")),
        CYAN(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID,"textures/entity/sail/cyan_sail.png")),
        PURPLE(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID,"textures/entity/sail/purple_sail.png")),
        BLUE(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID,"textures/entity/sail/blue_sail.png")),
        BROWN(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID,"textures/entity/sail/brown_sail.png")),
        GREEN(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID,"textures/entity/sail/green_sail.png")),
        RED(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID,"textures/entity/sail/red_sail.png")),
        BLACK(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID,"textures/entity/sail/black_sail.png"));

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
