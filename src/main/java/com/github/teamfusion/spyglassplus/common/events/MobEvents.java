package com.github.teamfusion.spyglassplus.common.events;

import com.github.teamfusion.spyglassplus.SpyglassPlus;
import com.github.teamfusion.spyglassplus.core.Targetable;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SpyglassPlus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MobEvents {
    @SubscribeEvent
    public static void onTargetEntity(LivingSetAttackTargetEvent event) {
        Targetable target = (Targetable)event.getTarget();
        if (event.getTarget() != null) {
            target.setTargeted(true);
        }
    }
}