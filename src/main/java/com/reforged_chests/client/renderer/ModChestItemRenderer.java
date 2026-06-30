package com.reforged_chests.client.renderer;

import com.reforged_chests.client.model.ModChestItemModel;
import com.reforged_chests.item.ModChestItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class ModChestItemRenderer extends GeoItemRenderer<ModChestItem> {
    public ModChestItemRenderer() {
        super(new ModChestItemModel());
    }
}