package com.talhanation.smallships.world.item;

import net.minecraft.world.item.Item;

public class CannonBallItem extends Item {

    /**
     * The type of a cannonball, defining its ballistic and damage behavior.
     */
    public enum Type {
        /** default cannonball */
        BALL((byte) 0, 1.0F, 1.0F, 1.0F, 1),
        /** chained shot: 25% less range and damage, high sail damage transfer */
        CHAINED((byte) 1, 0.75F, 0.75F, 0.75F, 1),
        /** grape shot: 50% less damage, less range, +150% damage on living entities, spawns pellets */
        GRAPE((byte) 2, 0.6F, 0.5F, 2.5F, 6);

        public final byte id;
        /** multiplier for projectile speed → range */
        public final float speedMultiplier;
        /** multiplier for damage against ships and blocks */
        public final float damageMultiplier;
        /** multiplier for damage against living entities */
        public final float livingDamageMultiplier;
        /** how many projectiles a single shot spawns */
        public final int projectileCount;

        Type(byte id, float speedMultiplier, float damageMultiplier, float livingDamageMultiplier, int projectileCount) {
            this.id = id;
            this.speedMultiplier = speedMultiplier;
            this.damageMultiplier = damageMultiplier;
            this.livingDamageMultiplier = livingDamageMultiplier;
            this.projectileCount = projectileCount;
        }

        public static Type byId(byte id) {
            for (Type type : values()) if (type.id == id) return type;
            return BALL;
        }
    }

    private final Type type;

    public CannonBallItem(Properties properties) {
        this(Type.BALL, properties);
    }

    public CannonBallItem(Type type, Properties properties) {
        super(properties);
        this.type = type;
    }

    public Type getType() {
        return this.type;
    }
}
