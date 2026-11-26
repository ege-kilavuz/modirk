package com.modirk.block;

import com.modirk.block.entity.RuhKaidesiBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

/**
 * Ruh Kaidesi: üstüne konan tek eşyayı havada döndürerek sergileyen ritüel bloğu.
 *
 * <p>Kullanım: eşya ile sağ tık yerleştirir, eli boş sağ tık geri alır.
 * Kırıldığında üstündeki eşya düşer.</p>
 */
public class RuhKaidesiBlock extends BaseEntityBlock {
    public static final MapCodec<RuhKaidesiBlock> CODEC = simpleCodec(RuhKaidesiBlock::new);

    private static final VoxelShape SHAPE = Shapes.or(
            Block.box(1.0D, 0.0D, 1.0D, 15.0D, 2.0D, 15.0D),
            Block.box(4.0D, 2.0D, 4.0D, 12.0D, 12.0D, 12.0D),
            Block.box(2.0D, 12.0D, 2.0D, 14.0D, 14.0D, 14.0D));

    public RuhKaidesiBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    protected @NotNull MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    protected @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level,
                                           @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new RuhKaidesiBlockEntity(pos, state);
    }

    @Override
    protected @NotNull ItemInteractionResult useItemOn(@NotNull ItemStack stack, @NotNull BlockState state,
                                                   @NotNull Level level, @NotNull BlockPos pos,
                                                   @NotNull Player player, @NotNull InteractionHand hand,
                                                   @NotNull BlockHitResult hitResult) {
        return this.interactWithPedestal(stack, level, pos, player);
    }

    @Override
    protected @NotNull InteractionResult useWithoutItem(@NotNull BlockState state, @NotNull Level level,
                                                        @NotNull BlockPos pos, @NotNull Player player,
                                                        @NotNull BlockHitResult hitResult) {
        return this.interactWithPedestal(ItemStack.EMPTY, level, pos, player).result();
    }

    private ItemInteractionResult interactWithPedestal(ItemStack held, Level level, BlockPos pos, Player player) {
        if (!(level.getBlockEntity(pos) instanceof RuhKaidesiBlockEntity pedestal)) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }
        if (level.isClientSide) {
            return ItemInteractionResult.SUCCESS;
        }

        ItemStack displayed = pedestal.getDisplayStack();
        if (!displayed.isEmpty()) {
            ItemStack taken = displayed.copy();
            pedestal.setDisplayStack(ItemStack.EMPTY);
            if (!player.getInventory().add(taken)) {
                player.drop(taken, false);
            }
            level.playSound(null, pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 0.7F, 1.4F);
            return ItemInteractionResult.SUCCESS;
        }

        if (held.isEmpty()) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }

        pedestal.setDisplayStack(held);
        if (!player.getAbilities().instabuild) {
            held.shrink(1);
        }
        level.playSound(null, pos, SoundEvents.STONE_PLACE, SoundSource.BLOCKS, 0.8F, 1.2F);
        return ItemInteractionResult.SUCCESS;
    }

    @Override
    protected void onRemove(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos,
                            @NotNull BlockState newState, boolean movedByPiston) {
        if (!state.is(newState.getBlock())
                && level.getBlockEntity(pos) instanceof RuhKaidesiBlockEntity pedestal
                && !pedestal.isEmpty()) {
            Containers.dropItemStack(level, pos.getX() + 0.5D, pos.getY() + 1.0D, pos.getZ() + 0.5D,
                    pedestal.getDisplayStack());
        }
        super.onRemove(state, level, pos, newState, movedByPiston);
    }
}

