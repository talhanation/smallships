package com.talhanation.smallships.neoforge.common;

import com.talhanation.smallships.world.entity.ship.ModBoatTypes;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;

import java.util.function.Supplier;

/**
 * Constructor arguments of the boat types SmallShips adds, read by NeoForge
 * through META-INF/enumextensions.json. See {@link ModBoatTypes}.
 *
 * Kept in a class of its own on purpose: NeoForge loads it while it builds the
 * enum, so nothing else of the mod may come with it. The names from
 * ModBoatTypes are compile time constants and get inlined.
 *
 * Arguments as the NeoForge Boat.Type constructor wants them: planks, name,
 * boat item, chest boat item, stick item, raft. There is no vanilla boat of
 * these woods, so no boat item - only the ships use them, and those drop
 * their own items.
 */
public class ModBoatTypeProxies {

    public static final EnumProxy<Boat.Type> WARPED = new EnumProxy<>(Boat.Type.class,
            (Supplier<Block>) () -> Blocks.WARPED_PLANKS,
            ModBoatTypes.WARPED,
            (Supplier<Item>) () -> Items.AIR,
            (Supplier<Item>) () -> Items.AIR,
            (Supplier<Item>) () -> Items.STICK,
            false);

    public static final EnumProxy<Boat.Type> CRIMSON = new EnumProxy<>(Boat.Type.class,
            (Supplier<Block>) () -> Blocks.CRIMSON_PLANKS,
            ModBoatTypes.CRIMSON,
            (Supplier<Item>) () -> Items.AIR,
            (Supplier<Item>) () -> Items.AIR,
            (Supplier<Item>) () -> Items.STICK,
            false);
}
