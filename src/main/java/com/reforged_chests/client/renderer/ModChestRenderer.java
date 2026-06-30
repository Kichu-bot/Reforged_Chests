package com.reforged_chests.client.renderer;

import com.reforged_chests.block.entity.ModChestBlockEntity;
import com.reforged_chests.client.model.ModChestModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class ModChestRenderer extends GeoBlockRenderer<ModChestBlockEntity> {
    public ModChestRenderer(BlockEntityRendererProvider.Context context) {
        super(new ModChestModel());
    }
}