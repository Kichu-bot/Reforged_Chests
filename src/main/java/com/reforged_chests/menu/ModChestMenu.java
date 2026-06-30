package com.reforged_chests.menu;

import com.reforged_chests.block.entity.ModChestBlockEntity;
import com.reforged_chests.registration.ModRegistration;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.items.SlotItemHandler;
import net.minecraft.world.inventory.ContainerLevelAccess;

public class ModChestMenu extends AbstractContainerMenu {
    private final ModChestBlockEntity blockEntity;
    private final ContainerLevelAccess access;
    private final int columns;
    private final int rows;

    public ModChestMenu(int containerId, Inventory playerInventory, FriendlyByteBuf extraData) {
        this(containerId, playerInventory, playerInventory.player.level().getBlockEntity(extraData.readBlockPos()));
    }

    public ModChestMenu(int containerId, Inventory playerInventory, BlockEntity entity) {
        super(ModRegistration.MOD_CHEST_MENU.get(), containerId);
        this.blockEntity = (ModChestBlockEntity) entity;
        this.access = ContainerLevelAccess.create(entity.getLevel(), entity.getBlockPos());

        ModRegistration.ChestTier tier = this.blockEntity.getTier();
        this.columns = tier.getColumns();
        this.rows = tier.getRows();

        for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.columns; col++) {
                this.addSlot(new SlotItemHandler(blockEntity.getItemHandler(), col + row * this.columns, 8 + col * 18, 18 + row * 18));
            }
        }

        int cofreWidthInPixels = this.columns * 18 + 16;
        int playerInvX = Math.max(0, (cofreWidthInPixels - 176) / 2);

        int playerInvY = 32 + (this.rows * 18);
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, playerInvX + 8 + col * 18, playerInvY + row * 18));
            }
        }

        int hotbarY = playerInvY + 58;
        for (int col = 0; col < 9; col++) {
            this.addSlot(new Slot(playerInventory, col, playerInvX + 8 + col * 18, hotbarY));
        }

        this.blockEntity.startOpen();
    }

    public int getColumnsCount() { return this.columns; }
    public int getRowsCount() { return this.rows; }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            int chestSlots = this.columns * this.rows;

            if (index < chestSlots) {
                if (!this.moveItemStackTo(itemstack1, chestSlots, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 0, chestSlots, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }
        return itemstack;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(this.access, player, blockEntity.getBlockState().getBlock());
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        this.blockEntity.stopOpen();
    }
}