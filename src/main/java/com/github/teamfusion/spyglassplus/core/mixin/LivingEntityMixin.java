package com.github.teamfusion.spyglassplus.core.mixin;

import com.github.teamfusion.spyglassplus.core.Targetable;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(LivingEntity.class)
public class LivingEntityMixin implements Targetable {
    private boolean targeted;

    @Override
    public void setTargeted(boolean targeted) {
        this.targeted = targeted;
    }

    @Override
    public boolean isTargeted() {
        return this.targeted;
    }
}