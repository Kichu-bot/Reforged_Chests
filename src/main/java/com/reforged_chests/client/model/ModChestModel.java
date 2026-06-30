package com.reforged_chests.client.model;

import com.reforged_chests.block.entity.ModChestBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ModChestModel extends GeoModel<ModChestBlockEntity> {

    private String getFileName(ModChestBlockEntity animatable) {
        String registryName = BuiltInRegistries.BLOCK.getKey(animatable.getBlockState().getBlock()).getPath();
        return registryName.replace("_chest_", "_reforged_chest_");
    }

    @Override
    public ResourceLocation getModelResource(ModChestBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath("reforged_chests", "geo/" + getFileName(animatable) + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ModChestBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath("reforged_chests", "textures/" + getFileName(animatable) + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(ModChestBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath("reforged_chests", "animations/reforged_chest_animation.json");
    }
}