package com.talhanation.smallships.mixin.entity;

import com.talhanation.smallships.world.IMixinEntity;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(Entity.class)
public class EntityMixin implements IMixinEntity {
    private float prevXRot;
    private float prevYRot;
    @Shadow
    private float xRot;
    @Shadow
    private float yRot;

    @Inject(method = "turn", at = @At("HEAD"))
    public void turn(double x, double y, CallbackInfo ci) {
        this.prevXRot = this.xRot;
        this.prevYRot = this.yRot;
    }

    @Override
    public float getPrevXRot() {
        return this.prevXRot;
    }

    @Override
    public float getPrevYRot() {
        return this.prevYRot;
    }
}
