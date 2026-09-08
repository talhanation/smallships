package com.talhanation.smallships.world.item;

import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Predicate;

/**
 * Places a ship instead of a boat.
 *
 * 1.20.1 BoatItem has no getBoat hook - it builds the Boat inline in use, and
 * the overridable factory only arrived with 1.20.2. Overriding getBoat here
 * therefore did nothing at all and every ship item placed a plain vanilla boat
 * of the right wood. So use is taken over as a whole: same order of checks as
 * vanilla, only the entity in the middle is ours.
 *
 * BoatItem keeps its type and hasChest private, hence the own variant field.
 */
public abstract class ShipItem extends BoatItem {
    private static final Predicate<Entity> ENTITY_PREDICATE = EntitySelector.NO_SPECTATORS.and(Entity::isPickable);
    /** how far ahead of the eyes a ship may be placed */
    private static final double PLACE_REACH = 5.0D;

    private final Boat.Type variant;

    public ShipItem(Boat.Type type, Properties properties) {
        super(false, type, properties);
        this.variant = type;
    }

    protected abstract @NotNull Ship getShip(@NotNull Level level, double x, double y, double z);

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        HitResult hitResult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.ANY);
        if (hitResult.getType() != HitResult.Type.BLOCK) {
            return InteractionResultHolder.pass(itemStack);
        }

        // an entity between the eyes and the aimed spot blocks the placement,
        // otherwise a ship could be dropped straight through a mob
        Vec3 view = player.getViewVector(1.0F);
        List<Entity> inTheWay = level.getEntities(player,
                player.getBoundingBox().expandTowards(view.scale(PLACE_REACH)).inflate(1.0D), ENTITY_PREDICATE);
        if (!inTheWay.isEmpty()) {
            Vec3 eyes = player.getEyePosition();
            for (Entity entity : inTheWay) {
                AABB box = entity.getBoundingBox().inflate(entity.getPickRadius());
                if (box.contains(eyes)) return InteractionResultHolder.pass(itemStack);
            }
        }

        Vec3 location = hitResult.getLocation();
        Ship ship = this.getShip(level, location.x, location.y, location.z);
        ship.setVariant(this.variant);
        ship.setYRot(player.getYRot());
        if (level instanceof ServerLevel serverLevel) {
            EntityType.<Ship>createDefaultStackConfig(serverLevel, itemStack, player).accept(ship);
        }

        // a ship is far bigger than a boat, so this refuses far more often -
        // that is the point, it would otherwise be placed inside the quay
        if (!level.noCollision(ship, ship.getBoundingBox())) {
            return InteractionResultHolder.fail(itemStack);
        }

        if (!level.isClientSide()) {
            level.addFreshEntity(ship);
            level.gameEvent(player, GameEvent.ENTITY_PLACE, location);
            level.playSound(null, ship.getX(), ship.getY(), ship.getZ(),
                    SoundEvents.BOAT_PADDLE_WATER, SoundSource.BLOCKS, 1.0F, 0.8F);
            if (!player.getAbilities().instabuild) itemStack.shrink(1);
        }

        player.awardStat(Stats.ITEM_USED.get(this));
        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }
}