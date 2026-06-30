package com.reforged_chests.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import com.reforged_chests.menu.ModChestMenu;

public class ModChestScreen extends AbstractContainerScreen<ModChestMenu> {

    private static final ResourceLocation CONTAINER_BACKGROUND = ResourceLocation.withDefaultNamespace("textures/gui/container/generic_54.png");

    private final int columns;
    private final int rows;

    public ModChestScreen(ModChestMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);

        this.columns = menu.getColumnsCount();
        this.rows = menu.getRowsCount();

        this.imageWidth = this.columns * 18 + 16;
        this.imageHeight = 114 + this.rows * 18;

        this.titleLabelX = 8;
        this.inventoryLabelX = Math.max(8, (this.imageWidth - 176) / 2 + 8);
        this.inventoryLabelY = this.imageHeight - 94;
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        int x = (this.width - this.imageWidth) / 2;
        int y = (this.height - this.imageHeight) / 2;

        guiGraphics.fill(x, y, x + this.imageWidth, y + this.imageHeight, 0xFFC6C6C6);
        guiGraphics.fill(x, y, x + this.imageWidth, y + 1, 0xFFFFFFFF);
        guiGraphics.fill(x, y, x + 1, y + this.imageHeight, 0xFFFFFFFF);
        guiGraphics.fill(x + this.imageWidth - 1, y, x + this.imageWidth, y + this.imageHeight, 0xFF555555);
        guiGraphics.fill(x, y + this.imageHeight - 1, x + this.imageWidth, y + this.imageHeight, 0xFF555555);

        for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.columns; col++) {
                guiGraphics.blit(CONTAINER_BACKGROUND, x + 7 + (col * 18), y + 17 + (row * 18), 7, 17, 18, 18);
            }
        }

        int playerInvX = Math.max(0, (this.imageWidth - 176) / 2);
        int playerInvY = 31 + (this.rows * 18);

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                guiGraphics.blit(CONTAINER_BACKGROUND, x + playerInvX + 7 + (col * 18), y + playerInvY + 1 + (row * 18), 7, 17, 18, 18);
            }
        }

        for (int col = 0; col < 9; col++) {
            guiGraphics.blit(CONTAINER_BACKGROUND, x + playerInvX + 7 + (col * 18), y + playerInvY + 59, 7, 17, 18, 18);
        }
    }
}