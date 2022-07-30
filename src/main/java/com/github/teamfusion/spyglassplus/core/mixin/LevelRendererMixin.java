package com.github.teamfusion.spyglassplus.core.mixin;

import com.github.teamfusion.spyglassplus.core.Targetable;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.OutlineBufferSource;
import net.minecraft.client.renderer.RenderBuffers;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LevelRenderer.class)
public abstract class LevelRendererMixin {
    @Shadow protected abstract boolean shouldShowEntityOutlines();
    @Shadow @Final private RenderBuffers renderBuffers;

    @Inject(method = "renderEntity", at = @At("HEAD"))
    private void onRenderEntity(Entity entity, double p_109519_, double p_109520_, double p_109521_, float p_109522_, PoseStack p_109523_, MultiBufferSource bufferSource, CallbackInfo ci) {
        if (this.shouldShowEntityOutlines() && entity instanceof LivingEntity living) {
            boolean flag = ((Targetable)living).isTargeted();
            OutlineBufferSource outline = this.renderBuffers.outlineBufferSource();

            outline.setColor(flag ? 255 : 0, 0, !flag ? 255 : 0, 255);

            bufferSource = outline;
        }
    }
}