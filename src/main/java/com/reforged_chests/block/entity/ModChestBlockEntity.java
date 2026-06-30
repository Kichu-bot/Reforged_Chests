package com.reforged_chests.block.entity;

import com.reforged_chests.block.ModChestBlock;
import com.reforged_chests.menu.ModChestMenu;
import com.reforged_chests.registration.ModRegistration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;

public class ModChestBlockEntity extends BlockEntity implements MenuProvider, GeoBlockEntity {

    private final ItemStackHandler itemHandler;
    private final ModRegistration.ChestTier tier;
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    private int openCount = 0;
    public boolean isOpened = false;
    private boolean wasOpened = false;

    private static final RawAnimation OPEN_ANIM = RawAnimation.begin().thenPlayAndHold("open");
    private static final RawAnimation CLOSE_ANIM = RawAnimation.begin().thenPlay("close").thenLoop("idle");
    private static final RawAnimation IDLE_ANIM = RawAnimation.begin().thenLoop("idle");

    public ModChestBlockEntity(BlockPos pos, BlockState state) {
        super(ModRegistration.MOD_CHEST_BE.get(), pos, state);

        this.tier = (state.getBlock() instanceof ModChestBlock chestBlock) ? chestBlock.getTier() : ModRegistration.ChestTier.TIER1;

        this.itemHandler = new ItemStackHandler(this.tier.getSlots()) {
            @Override
            protected void onContentsChanged(int slot) {
                setChanged();
            }
        };
    }

    public void startOpen() {
        this.openCount++;
        if (this.level != null && this.openCount == 1) {
            this.level.blockEvent(this.worldPosition, this.getBlockState().getBlock(), 1, 1);
            this.level.playSound(null, this.worldPosition, SoundEvents.CHEST_OPEN, SoundSource.BLOCKS, 0.5F, this.level.random.nextFloat() * 0.1F + 0.9F);
        }
    }

    public void stopOpen() {
        this.openCount--;
        if (this.level != null && this.openCount <= 0) {
            this.openCount = 0;
            this.level.blockEvent(this.worldPosition, this.getBlockState().getBlock(), 1, 0);
            this.level.playSound(null, this.worldPosition, SoundEvents.CHEST_CLOSE, SoundSource.BLOCKS, 0.5F, this.level.random.nextFloat() * 0.1F + 0.9F);
        }
    }

    public ItemStackHandler getItemHandler() {
        return itemHandler;
    }

    public ModRegistration.ChestTier getTier() {
        return tier;
    }

    @Override
    public Component getDisplayName() {
        return this.getBlockState().getBlock().getName();
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory playerInventory, Player player) {
        return new ModChestMenu(containerId, playerInventory, this);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        tag.put("Inventory", itemHandler.serializeNBT(registries));
        super.saveAdditional(tag, registries);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        if (tag.contains("Inventory")) {
            itemHandler.deserializeNBT(registries, tag.getCompound("Inventory"));
        }
    }

    public void drops() {
        SimpleContainer container = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            container.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, container);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public boolean triggerEvent(int id, int type) {
        if (id == 1) {
            this.isOpened = type > 0;
            return true;
        }
        return super.triggerEvent(id, type);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 0, state -> {

            if (this.isOpened) {
                this.wasOpened = true;
                return state.setAndContinue(OPEN_ANIM);
            } else {
                if (this.wasOpened) {
                    return state.setAndContinue(CLOSE_ANIM);
                } else {
                    return state.setAndContinue(IDLE_ANIM);
                }
            }
        }));
    }
}