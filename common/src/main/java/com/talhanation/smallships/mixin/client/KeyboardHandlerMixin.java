package com.talhanation.smallships.mixin.client;

import com.talhanation.smallships.client.option.KeyEvent;
import net.minecraft.client.KeyboardHandler;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(KeyboardHandler.class)
public class KeyboardHandlerMixin {
    @Shadow
    private Minecraft minecraft;

    @Inject(method = "keyPress", at=@At("TAIL"))
    public void keyPress(long l, int i, int j, int k, int m, CallbackInfo ci) {
        if (l == this.minecraft.getWindow().getWindow()) {
            KeyEvent.onKeyInput(i, j, k, m);
        }
    }
}
