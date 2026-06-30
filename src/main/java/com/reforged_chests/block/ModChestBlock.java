package com.reforged_chests.block;

import com.mojang.serialization.MapCodec;
import com.reforged_chests.block.entity.ModChestBlockEntity;
import com.reforged_chests.registration.ModRegistration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class ModChestBlock extends BaseEntityBlock {

    public static final MapCodec<ModChestBlock> CODEC = simpleCodec(properties -> new ModChestBlock(ModRegistration.ChestTier.TIER1));
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    private final ModRegistration.ChestTier tier;
    private static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 14.0D, 15.0D);

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    public ModChestBlock(ModRegistration.ChestTier tier) {
        super(Properties.of().strength(2.5F).requiresCorrectToolForDrops().noOcclusion());
        this.tier = tier;
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    public ModRegistration.ChestTier getTier() {
        return this.tier;
    }

    public static SoundType getSoundForTier(ModRegistration.ChestTier tier) {
        return switch (tier) {
            case TIER1 -> SoundType.COPPER;
            case TIER2, TIER3 -> SoundType.METAL;
            case TIER4 -> SoundType.STONE;
            case TIER5 -> SoundType.NETHERITE_BLOCK;
        };
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ModChestBlockEntity(pos, state);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (!level.isClientSide) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof ModChestBlockEntity chestBE) {
                player.openMenu(chestBE, pos);
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof ModChestBlockEntity chestBE) {
                chestBE.drops();
            }
            super.onRemove(state, level, pos, newState, isMoving);
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        //maybe
    }

    @Override
    public net.minecraft.world.level.block.SoundType getSoundType(net.minecraft.world.level.block.state.BlockState state, net.minecraft.world.level.LevelReader level, net.minecraft.core.BlockPos pos, net.minecraft.world.entity.Entity entity) {
        return switch (this.tier) {
            case TIER1 -> net.minecraft.world.level.block.SoundType.COPPER;
            case TIER2, TIER3 -> net.minecraft.world.level.block.SoundType.METAL;
            case TIER4 -> net.minecraft.world.level.block.SoundType.STONE;
            case TIER5 -> net.minecraft.world.level.block.SoundType.NETHERITE_BLOCK;
            default -> net.minecraft.world.level.block.SoundType.WOOD;
        };
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player) {
        return new ItemStack(this);
    }

}