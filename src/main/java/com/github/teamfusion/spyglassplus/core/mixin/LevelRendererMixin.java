package com.github.teamfusion.spyglassplus.core.mixin;

import com.github.teamfusion.spyglassplus.core.Targetable;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
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

    @Shadow @Final private Minecraft minecraft;

    @Shadow @Final private RenderBuffers renderBuffers;

    @Inject(method = "renderEntity", at = @At("HEAD"))
    private void onRenderEntity(Entity entity, double p_109519_, double p_109520_, double p_109521_, float p_109522_, PoseStack p_109523_, MultiBufferSource bufferSource, CallbackInfo ci) {
        if (this.shouldShowEntityOutlines() && this.minecraft.shouldEntityAppearGlowing(entity)) {
            OutlineBufferSource outline = this.renderBuffers.outlineBufferSource();
            bufferSource = outline;
            if (entity instanceof LivingEntity living && ((Targetable)living).isTargeted()) {
                outline.setColor(255, 0, 0, 255);
            } else {
                outline.setColor(255, 255, 255, 255);
            }
        } else {
            bufferSource = this.renderBuffers.bufferSource();
        }
    }
}