package com.reforged_chests.registration;

import com.reforged_chests.ReforgedChests;
import com.reforged_chests.block.ModChestBlock;
import com.reforged_chests.block.entity.ModChestBlockEntity;
import com.reforged_chests.menu.ModChestMenu;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModRegistration {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(BuiltInRegistries.BLOCK, ReforgedChests.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, ReforgedChests.MODID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, ReforgedChests.MODID);
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(BuiltInRegistries.MENU, ReforgedChests.MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ReforgedChests.MODID);

    public enum ChestTier {
        TIER1(9, 4),    // 36 slots
        TIER2(9, 6),    // 54 slots
        TIER3(9, 9),    // 81 slots
        TIER4(12, 9),   // 108 slots
        TIER5(15, 9);   // 135 slots

        private final int columns;
        private final int rows;

        ChestTier(int columns, int rows) {
            this.columns = columns;
            this.rows = rows;
        }

        public int getColumns() { return columns; }
        public int getRows() { return rows; }
        public int getSlots() { return columns * rows; }
    }

    // --- TIER 1 ---
    public static final Supplier<Block> OAK_CHEST_TIER1 = registerBlock("oak_chest_tier1", () -> new ModChestBlock(ChestTier.TIER1));
    public static final Supplier<Block> SPRUCE_CHEST_TIER1 = registerBlock("spruce_chest_tier1", () -> new ModChestBlock(ChestTier.TIER1));
    public static final Supplier<Block> BIRCH_CHEST_TIER1 = registerBlock("birch_chest_tier1", () -> new ModChestBlock(ChestTier.TIER1));
    public static final Supplier<Block> JUNGLE_CHEST_TIER1 = registerBlock("jungle_chest_tier1", () -> new ModChestBlock(ChestTier.TIER1));
    public static final Supplier<Block> ACACIA_CHEST_TIER1 = registerBlock("acacia_chest_tier1", () -> new ModChestBlock(ChestTier.TIER1));
    public static final Supplier<Block> DARK_OAK_CHEST_TIER1 = registerBlock("dark_oak_chest_tier1", () -> new ModChestBlock(ChestTier.TIER1));
    public static final Supplier<Block> MANGROVE_CHEST_TIER1 = registerBlock("mangrove_chest_tier1", () -> new ModChestBlock(ChestTier.TIER1));
    public static final Supplier<Block> CHERRY_CHEST_TIER1 = registerBlock("cherry_chest_tier1", () -> new ModChestBlock(ChestTier.TIER1));
    public static final Supplier<Block> BAMBOO_CHEST_TIER1 = registerBlock("bamboo_chest_tier1", () -> new ModChestBlock(ChestTier.TIER1));
    public static final Supplier<Block> CRIMSON_CHEST_TIER1 = registerBlock("crimson_chest_tier1", () -> new ModChestBlock(ChestTier.TIER1));
    public static final Supplier<Block> WARPED_CHEST_TIER1 = registerBlock("warped_chest_tier1", () -> new ModChestBlock(ChestTier.TIER1));

    // --- TIER 2 ---
    public static final Supplier<Block> OAK_CHEST_TIER2 = registerBlock("oak_chest_tier2", () -> new ModChestBlock(ChestTier.TIER2));
    public static final Supplier<Block> SPRUCE_CHEST_TIER2 = registerBlock("spruce_chest_tier2", () -> new ModChestBlock(ChestTier.TIER2));
    public static final Supplier<Block> BIRCH_CHEST_TIER2 = registerBlock("birch_chest_tier2", () -> new ModChestBlock(ChestTier.TIER2));
    public static final Supplier<Block> JUNGLE_CHEST_TIER2 = registerBlock("jungle_chest_tier2", () -> new ModChestBlock(ChestTier.TIER2));
    public static final Supplier<Block> ACACIA_CHEST_TIER2 = registerBlock("acacia_chest_tier2", () -> new ModChestBlock(ChestTier.TIER2));
    public static final Supplier<Block> DARK_OAK_CHEST_TIER2 = registerBlock("dark_oak_chest_tier2", () -> new ModChestBlock(ChestTier.TIER2));
    public static final Supplier<Block> MANGROVE_CHEST_TIER2 = registerBlock("mangrove_chest_tier2", () -> new ModChestBlock(ChestTier.TIER2));
    public static final Supplier<Block> CHERRY_CHEST_TIER2 = registerBlock("cherry_chest_tier2", () -> new ModChestBlock(ChestTier.TIER2));
    public static final Supplier<Block> BAMBOO_CHEST_TIER2 = registerBlock("bamboo_chest_tier2", () -> new ModChestBlock(ChestTier.TIER2));
    public static final Supplier<Block> CRIMSON_CHEST_TIER2 = registerBlock("crimson_chest_tier2", () -> new ModChestBlock(ChestTier.TIER2));
    public static final Supplier<Block> WARPED_CHEST_TIER2 = registerBlock("warped_chest_tier2", () -> new ModChestBlock(ChestTier.TIER2));

    // --- TIER 3 ---
    public static final Supplier<Block> OAK_CHEST_TIER3 = registerBlock("oak_chest_tier3", () -> new ModChestBlock(ChestTier.TIER3));
    public static final Supplier<Block> SPRUCE_CHEST_TIER3 = registerBlock("spruce_chest_tier3", () -> new ModChestBlock(ChestTier.TIER3));
    public static final Supplier<Block> BIRCH_CHEST_TIER3 = registerBlock("birch_chest_tier3", () -> new ModChestBlock(ChestTier.TIER3));
    public static final Supplier<Block> JUNGLE_CHEST_TIER3 = registerBlock("jungle_chest_tier3", () -> new ModChestBlock(ChestTier.TIER3));
    public static final Supplier<Block> ACACIA_CHEST_TIER3 = registerBlock("acacia_chest_tier3", () -> new ModChestBlock(ChestTier.TIER3));
    public static final Supplier<Block> DARK_OAK_CHEST_TIER3 = registerBlock("dark_oak_chest_tier3", () -> new ModChestBlock(ChestTier.TIER3));
    public static final Supplier<Block> MANGROVE_CHEST_TIER3 = registerBlock("mangrove_chest_tier3", () -> new ModChestBlock(ChestTier.TIER3));
    public static final Supplier<Block> CHERRY_CHEST_TIER3 = registerBlock("cherry_chest_tier3", () -> new ModChestBlock(ChestTier.TIER3));
    public static final Supplier<Block> BAMBOO_CHEST_TIER3 = registerBlock("bamboo_chest_tier3", () -> new ModChestBlock(ChestTier.TIER3));
    public static final Supplier<Block> CRIMSON_CHEST_TIER3 = registerBlock("crimson_chest_tier3", () -> new ModChestBlock(ChestTier.TIER3));
    public static final Supplier<Block> WARPED_CHEST_TIER3 = registerBlock("warped_chest_tier3", () -> new ModChestBlock(ChestTier.TIER3));

    // --- TIER 4 ---
    public static final Supplier<Block> OAK_CHEST_TIER4 = registerBlock("oak_chest_tier4", () -> new ModChestBlock(ChestTier.TIER4));
    public static final Supplier<Block> SPRUCE_CHEST_TIER4 = registerBlock("spruce_chest_tier4", () -> new ModChestBlock(ChestTier.TIER4));
    public static final Supplier<Block> BIRCH_CHEST_TIER4 = registerBlock("birch_chest_tier4", () -> new ModChestBlock(ChestTier.TIER4));
    public static final Supplier<Block> JUNGLE_CHEST_TIER4 = registerBlock("jungle_chest_tier4", () -> new ModChestBlock(ChestTier.TIER4));
    public static final Supplier<Block> ACACIA_CHEST_TIER4 = registerBlock("acacia_chest_tier4", () -> new ModChestBlock(ChestTier.TIER4));
    public static final Supplier<Block> DARK_OAK_CHEST_TIER4 = registerBlock("dark_oak_chest_tier4", () -> new ModChestBlock(ChestTier.TIER4));
    public static final Supplier<Block> MANGROVE_CHEST_TIER4 = registerBlock("mangrove_chest_tier4", () -> new ModChestBlock(ChestTier.TIER4));
    public static final Supplier<Block> CHERRY_CHEST_TIER4 = registerBlock("cherry_chest_tier4", () -> new ModChestBlock(ChestTier.TIER4));
    public static final Supplier<Block> BAMBOO_CHEST_TIER4 = registerBlock("bamboo_chest_tier4", () -> new ModChestBlock(ChestTier.TIER4));
    public static final Supplier<Block> CRIMSON_CHEST_TIER4 = registerBlock("crimson_chest_tier4", () -> new ModChestBlock(ChestTier.TIER4));
    public static final Supplier<Block> WARPED_CHEST_TIER4 = registerBlock("warped_chest_tier4", () -> new ModChestBlock(ChestTier.TIER4));

    // --- TIER 5 ---
    public static final Supplier<Block> OAK_CHEST_TIER5 = registerBlock("oak_chest_tier5", () -> new ModChestBlock(ChestTier.TIER5));
    public static final Supplier<Block> SPRUCE_CHEST_TIER5 = registerBlock("spruce_chest_tier5", () -> new ModChestBlock(ChestTier.TIER5));
    public static final Supplier<Block> BIRCH_CHEST_TIER5 = registerBlock("birch_chest_tier5", () -> new ModChestBlock(ChestTier.TIER5));
    public static final Supplier<Block> JUNGLE_CHEST_TIER5 = registerBlock("jungle_chest_tier5", () -> new ModChestBlock(ChestTier.TIER5));
    public static final Supplier<Block> ACACIA_CHEST_TIER5 = registerBlock("acacia_chest_tier5", () -> new ModChestBlock(ChestTier.TIER5));
    public static final Supplier<Block> DARK_OAK_CHEST_TIER5 = registerBlock("dark_oak_chest_tier5", () -> new ModChestBlock(ChestTier.TIER5));
    public static final Supplier<Block> MANGROVE_CHEST_TIER5 = registerBlock("mangrove_chest_tier5", () -> new ModChestBlock(ChestTier.TIER5));
    public static final Supplier<Block> CHERRY_CHEST_TIER5 = registerBlock("cherry_chest_tier5", () -> new ModChestBlock(ChestTier.TIER5));
    public static final Supplier<Block> BAMBOO_CHEST_TIER5 = registerBlock("bamboo_chest_tier5", () -> new ModChestBlock(ChestTier.TIER5));
    public static final Supplier<Block> CRIMSON_CHEST_TIER5 = registerBlock("crimson_chest_tier5", () -> new ModChestBlock(ChestTier.TIER5));
    public static final Supplier<Block> WARPED_CHEST_TIER5 = registerBlock("warped_chest_tier5", () -> new ModChestBlock(ChestTier.TIER5));

    public static final Supplier<BlockEntityType<ModChestBlockEntity>> MOD_CHEST_BE = BLOCK_ENTITIES.register("mod_chest_be",
            () -> BlockEntityType.Builder.of(ModChestBlockEntity::new,
                    OAK_CHEST_TIER1.get(), SPRUCE_CHEST_TIER1.get(), BIRCH_CHEST_TIER1.get(), JUNGLE_CHEST_TIER1.get(), ACACIA_CHEST_TIER1.get(), DARK_OAK_CHEST_TIER1.get(), MANGROVE_CHEST_TIER1.get(), CHERRY_CHEST_TIER1.get(), BAMBOO_CHEST_TIER1.get(), CRIMSON_CHEST_TIER1.get(), WARPED_CHEST_TIER1.get(),
                    OAK_CHEST_TIER2.get(), SPRUCE_CHEST_TIER2.get(), BIRCH_CHEST_TIER2.get(), JUNGLE_CHEST_TIER2.get(), ACACIA_CHEST_TIER2.get(), DARK_OAK_CHEST_TIER2.get(), MANGROVE_CHEST_TIER2.get(), CHERRY_CHEST_TIER2.get(), BAMBOO_CHEST_TIER2.get(), CRIMSON_CHEST_TIER2.get(), WARPED_CHEST_TIER2.get(),
                    OAK_CHEST_TIER3.get(), SPRUCE_CHEST_TIER3.get(), BIRCH_CHEST_TIER3.get(), JUNGLE_CHEST_TIER3.get(), ACACIA_CHEST_TIER3.get(), DARK_OAK_CHEST_TIER3.get(), MANGROVE_CHEST_TIER3.get(), CHERRY_CHEST_TIER3.get(), BAMBOO_CHEST_TIER3.get(), CRIMSON_CHEST_TIER3.get(), WARPED_CHEST_TIER3.get(),
                    OAK_CHEST_TIER4.get(), SPRUCE_CHEST_TIER4.get(), BIRCH_CHEST_TIER4.get(), JUNGLE_CHEST_TIER4.get(), ACACIA_CHEST_TIER4.get(), DARK_OAK_CHEST_TIER4.get(), MANGROVE_CHEST_TIER4.get(), CHERRY_CHEST_TIER4.get(), BAMBOO_CHEST_TIER4.get(), CRIMSON_CHEST_TIER4.get(), WARPED_CHEST_TIER4.get(),
                    OAK_CHEST_TIER5.get(), SPRUCE_CHEST_TIER5.get(), BIRCH_CHEST_TIER5.get(), JUNGLE_CHEST_TIER5.get(), ACACIA_CHEST_TIER5.get(), DARK_OAK_CHEST_TIER5.get(), MANGROVE_CHEST_TIER5.get(), CHERRY_CHEST_TIER5.get(), BAMBOO_CHEST_TIER5.get(), CRIMSON_CHEST_TIER5.get(), WARPED_CHEST_TIER5.get()
            ).build(null));

    public static final Supplier<MenuType<ModChestMenu>> MOD_CHEST_MENU = MENUS.register("mod_chest_menu",
            () -> IMenuTypeExtension.create(ModChestMenu::new));


    public static final Supplier<CreativeModeTab> REFORGED_CHESTS_TAB = CREATIVE_MODE_TABS.register("reforged_chests_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.reforged_chests"))
            .icon(() -> new ItemStack(OAK_CHEST_TIER5.get()))
            .displayItems((parameters, output) -> {
                // --- TIER 1 ---
                output.accept(OAK_CHEST_TIER1.get());
                output.accept(SPRUCE_CHEST_TIER1.get());
                output.accept(BIRCH_CHEST_TIER1.get());
                output.accept(JUNGLE_CHEST_TIER1.get());
                output.accept(ACACIA_CHEST_TIER1.get());
                output.accept(DARK_OAK_CHEST_TIER1.get());
                output.accept(MANGROVE_CHEST_TIER1.get());
                output.accept(CHERRY_CHEST_TIER1.get());
                output.accept(BAMBOO_CHEST_TIER1.get());
                output.accept(CRIMSON_CHEST_TIER1.get());
                output.accept(WARPED_CHEST_TIER1.get());

                // --- TIER 2 ---
                output.accept(OAK_CHEST_TIER2.get());
                output.accept(SPRUCE_CHEST_TIER2.get());
                output.accept(BIRCH_CHEST_TIER2.get());
                output.accept(JUNGLE_CHEST_TIER2.get());
                output.accept(ACACIA_CHEST_TIER2.get());
                output.accept(DARK_OAK_CHEST_TIER2.get());
                output.accept(MANGROVE_CHEST_TIER2.get());
                output.accept(CHERRY_CHEST_TIER2.get());
                output.accept(BAMBOO_CHEST_TIER2.get());
                output.accept(CRIMSON_CHEST_TIER2.get());
                output.accept(WARPED_CHEST_TIER2.get());

                // --- TIER 3 ---
                output.accept(OAK_CHEST_TIER3.get());
                output.accept(SPRUCE_CHEST_TIER3.get());
                output.accept(BIRCH_CHEST_TIER3.get());
                output.accept(JUNGLE_CHEST_TIER3.get());
                output.accept(ACACIA_CHEST_TIER3.get());
                output.accept(DARK_OAK_CHEST_TIER3.get());
                output.accept(MANGROVE_CHEST_TIER3.get());
                output.accept(CHERRY_CHEST_TIER3.get());
                output.accept(BAMBOO_CHEST_TIER3.get());
                output.accept(CRIMSON_CHEST_TIER3.get());
                output.accept(WARPED_CHEST_TIER3.get());

                // --- TIER 4 ---
                output.accept(OAK_CHEST_TIER4.get());
                output.accept(SPRUCE_CHEST_TIER4.get());
                output.accept(BIRCH_CHEST_TIER4.get());
                output.accept(JUNGLE_CHEST_TIER4.get());
                output.accept(ACACIA_CHEST_TIER4.get());
                output.accept(DARK_OAK_CHEST_TIER4.get());
                output.accept(MANGROVE_CHEST_TIER4.get());
                output.accept(CHERRY_CHEST_TIER4.get());
                output.accept(BAMBOO_CHEST_TIER4.get());
                output.accept(CRIMSON_CHEST_TIER4.get());
                output.accept(WARPED_CHEST_TIER4.get());

                // --- TIER 5 ---
                output.accept(OAK_CHEST_TIER5.get());
                output.accept(SPRUCE_CHEST_TIER5.get());
                output.accept(BIRCH_CHEST_TIER5.get());
                output.accept(JUNGLE_CHEST_TIER5.get());
                output.accept(ACACIA_CHEST_TIER5.get());
                output.accept(DARK_OAK_CHEST_TIER5.get());
                output.accept(MANGROVE_CHEST_TIER5.get());
                output.accept(CHERRY_CHEST_TIER5.get());
                output.accept(BAMBOO_CHEST_TIER5.get());
                output.accept(CRIMSON_CHEST_TIER5.get());
                output.accept(WARPED_CHEST_TIER5.get());
            }).build());

    // Helper
    private static <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block) {
        Supplier<T> toReturn = BLOCKS.register(name, block);
        ITEMS.register(name, () -> new com.reforged_chests.item.ModChestItem(toReturn.get(), new Item.Properties()));
        return toReturn;
    }

    public static SoundType getSoundForTier(ChestTier tier) {
        return switch (tier) {
            case TIER1 -> SoundType.COPPER;
            case TIER2, TIER3 -> SoundType.METAL;
            case TIER4 -> SoundType.STONE;
            case TIER5 -> SoundType.NETHERITE_BLOCK;
        };
    }

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        BLOCK_ENTITIES.register(modEventBus);
        MENUS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
    }
}