package com.modirk.block.entity;

import com.modirk.block.RitualState;
import com.modirk.block.SunakBlock;
import com.modirk.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/**
 * Sunağın taşıdığı Ruh Taşı ve (ileride) Lanetli Taş.
 *
 * <p>İçerik değişince blok durumu ({@link RitualState}) güncellenir ve istemciye
 * senkronlanır. NeoForge'un varsayılan {@code onDataPacket} davranışı boş NBT
 * etiketini yok saydığı için burada etiket koşulsuz uygulanır.</p>
 */
public class SunakBlockEntity extends BlockEntity {
    private static final String SPIRIT_TAG = "SpiritStone";
    private static final String CURSED_TAG = "CursedStone";

    private ItemStack spiritStone = ItemStack.EMPTY;
    private ItemStack cursedStone = ItemStack.EMPTY;

    public SunakBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SUNAK.get(), pos, state);
    }

    public ItemStack getSpiritStone() {
        return this.spiritStone;
    }

    public ItemStack getCursedStone() {
        return this.cursedStone;
    }

    public boolean hasSpiritStone() {
        return !this.spiritStone.isEmpty();
    }

    public boolean hasCursedStone() {
        return !this.cursedStone.isEmpty();
    }

    public boolean isEmpty() {
        return this.spiritStone.isEmpty() && this.cursedStone.isEmpty();
    }

    public void setSpiritStone(ItemStack stack) {
        this.spiritStone = stack.isEmpty() ? ItemStack.EMPTY : stack.copyWithCount(1);
        this.onContentChanged();
    }

    public void setCursedStone(ItemStack stack) {
        this.cursedStone = stack.isEmpty() ? ItemStack.EMPTY : stack.copyWithCount(1);
        this.onContentChanged();
    }

    private void onContentChanged() {
        this.setChanged();
        this.refreshBlockState();
        this.syncToClients();
    }

    private void refreshBlockState() {
        if (!(this.level instanceof ServerLevel serverLevel)) {
            return;
        }
        BlockState state = this.getBlockState();
        RitualState target = this.spiritStone.isEmpty() ? RitualState.IDLE : RitualState.READY;
        if (state.getValue(SunakBlock.STATE) != target) {
            serverLevel.setBlock(this.worldPosition, state.setValue(SunakBlock.STATE, target), Block.UPDATE_ALL);
        }
    }

    private void syncToClients() {
        Level level = this.getLevel();
        if (level != null && !level.isClientSide) {
            BlockState state = this.getBlockState();
            level.sendBlockUpdated(this.worldPosition, state, state, Block.UPDATE_ALL);
        }
    }

    /** Ritüel motoru tükendi durumunu buradan ayarlayacak. */
    public void setExhausted(boolean exhausted) {
        if (this.level == null || this.level.isClientSide) {
            return;
        }
        BlockState state = this.getBlockState();
        RitualState target = exhausted ? RitualState.EXHAUSTED : RitualState.IDLE;
        this.level.setBlock(this.worldPosition, state.setValue(SunakBlock.STATE, target), Block.UPDATE_ALL);
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag, @NotNull HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        if (!this.spiritStone.isEmpty()) {
            tag.put(SPIRIT_TAG, this.spiritStone.save(registries));
        }
        if (!this.cursedStone.isEmpty()) {
            tag.put(CURSED_TAG, this.cursedStone.save(registries));
        }
    }

    @Override
    protected void loadAdditional(@NotNull CompoundTag tag, @NotNull HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        this.spiritStone = tag.contains(SPIRIT_TAG)
                ? ItemStack.parse(registries, tag.get(SPIRIT_TAG)).orElse(ItemStack.EMPTY)
                : ItemStack.EMPTY;
        this.cursedStone = tag.contains(CURSED_TAG)
                ? ItemStack.parse(registries, tag.get(CURSED_TAG)).orElse(ItemStack.EMPTY)
                : ItemStack.EMPTY;
    }

    @Override
    public @NotNull CompoundTag getUpdateTag(@NotNull HolderLookup.Provider registries) {
        return this.saveWithoutMetadata(registries);
    }

    @Override
    public void onDataPacket(@NotNull Connection connection, @NotNull ClientboundBlockEntityDataPacket packet,
                             @NotNull HolderLookup.Provider registries) {
        CompoundTag tag = packet.getTag();
        if (tag != null) {
            this.loadWithComponents(tag, registries);
        }
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}
