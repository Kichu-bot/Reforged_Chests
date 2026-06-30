package com.reforged_chests.client.model;

import com.reforged_chests.item.ModChestItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ModChestItemModel extends GeoModel<ModChestItem> {
    @Override
    public ResourceLocation getModelResource(ModChestItem animatable) {
        String name = BuiltInRegistries.ITEM.getKey(animatable).getPath();
        return ResourceLocation.fromNamespaceAndPath("reforged_chests", "geo/" + name.replace("_chest_", "_reforged_chest_") + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ModChestItem animatable) {
        String name = BuiltInRegistries.ITEM.getKey(animatable).getPath();
        return ResourceLocation.fromNamespaceAndPath("reforged_chests", "textures/" + name.replace("_chest_", "_reforged_chest_") + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(ModChestItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("reforged_chests", "animations/reforged_chest_animation.json");
    }
}