package com.talhanation.smallships.world.item;

import net.minecraft.world.item.Item;

public class CannonBallItem extends Item {

    /**
     * The type of a cannonball, defining its ballistic and damage behavior.
     */
    public enum Type {
        /** default cannonball: solid shot, made for timbers */
        BALL((byte) 0, 1.0F, 1.0F, 1.0F, 1, 1.0F, 0.33F),
        /** chained shot: two balls on a chain, made for rigging */
        CHAINED((byte) 1, 0.75F, 0.75F, 0.75F, 1, 0.33F, 1.0F),
        /** grape shot: a cloud of pellets, made for the crew */
        GRAPE((byte) 2, 0.6F, 0.5F, 2.5F, 6, 0.25F, 0.5F);

        public final byte id;
        /** multiplier for projectile speed → range */
        public final float speedMultiplier;
        /** multiplier for damage against ships and blocks */
        public final float damageMultiplier;
        /** multiplier for damage against living entities */
        public final float livingDamageMultiplier;
        /** how many projectiles a single shot spawns */
        public final int projectileCount;
        /**
         * Share of the damage that lands when the HULL is hit. Together with
         * sailFactor this is what makes a shot type mean something: a solid ball
         * is made for timbers, a chain is made for rigging, and neither is any
         * good at the other job.
         */
        public final float hullFactor;
        /** the same for a hit on the MASTS, which is the sails' hit box */
        public final float sailFactor;

        Type(byte id, float speedMultiplier, float damageMultiplier, float livingDamageMultiplier, int projectileCount, float hullFactor, float sailFactor) {
            this.id = id;
            this.speedMultiplier = speedMultiplier;
            this.damageMultiplier = damageMultiplier;
            this.livingDamageMultiplier = livingDamageMultiplier;
            this.projectileCount = projectileCount;
            this.hullFactor = hullFactor;
            this.sailFactor = sailFactor;
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