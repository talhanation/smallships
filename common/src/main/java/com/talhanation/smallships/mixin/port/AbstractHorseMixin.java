package com.talhanation.smallships.mixin.port;

import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import port.HasCustomInventoryScreen;

@Mixin(AbstractHorse.class)
public abstract class AbstractHorseMixin implements HasCustomInventoryScreen {
    @Shadow public abstract void openInventory(Player player);

    @Override
    public void openCustomInventoryScreen(Player player) {
        this.openInventory(player);
    }
}
