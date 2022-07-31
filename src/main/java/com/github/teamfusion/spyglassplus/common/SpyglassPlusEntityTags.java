package com.github.teamfusion.spyglassplus.common;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class SpyglassPlusEntityTags {
    public static final TagKey<EntityType<?>> SHOULD_NOT_TARGET         = create("should_not_target");
    public static final TagKey<EntityType<?>> SHOULD_NOT_TARGET_AQUATIC = create("should_not_target_aquatic");

    public static void setup() {}

    private static TagKey<EntityType<?>> create(String key) {
        return TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation(key));
    }
}