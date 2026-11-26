package com.modirk.block.entity;

import com.modirk.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/**
 * Ruh Kaidesi'nin taşıdığı tek eşya.
 *
 * <p>Eşya diske yazılır ve blok güncelleme paketiyle istemciye gönderilir;
 * böylece kaide üstündeki sergileme her iki tarafta aynı görünür.</p>
 */
public class RuhKaidesiBlockEntity extends BlockEntity {
    private static final String ITEM_TAG = "DisplayItem";

    private ItemStack displayStack = ItemStack.EMPTY;

    public RuhKaidesiBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.RUH_KAIDESI.get(), pos, state);
    }

    public ItemStack getDisplayStack() {
        return this.displayStack;
    }

    public boolean isEmpty() {
        return this.displayStack.isEmpty();
    }

    /** Eşyayı değiştirir; kaydı ve istemci senkronizasyonunu tetikler. */
    public void setDisplayStack(ItemStack stack) {
        this.displayStack = stack.isEmpty() ? ItemStack.EMPTY : stack.copyWithCount(1);
        this.setChanged();
        Level level = this.getLevel();
        if (level != null && !level.isClientSide) {
            BlockState state = this.getBlockState();
            level.sendBlockUpdated(this.worldPosition, state, state, Block.UPDATE_ALL);
        }
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag, @NotNull HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        if (!this.displayStack.isEmpty()) {
            tag.put(ITEM_TAG, this.displayStack.save(registries));
        }
    }

    @Override
    protected void loadAdditional(@NotNull CompoundTag tag, @NotNull HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        this.displayStack = tag.contains(ITEM_TAG)
                ? ItemStack.parse(registries, tag.get(ITEM_TAG)).orElse(ItemStack.EMPTY)
                : ItemStack.EMPTY;
    }

    @Override
    public @NotNull CompoundTag getUpdateTag(@NotNull HolderLookup.Provider registries) {
        return this.saveWithoutMetadata(registries);
    }

    /**
     * NeoForge'un varsayılan {@code onDataPacket} uygulaması <b>boş</b> NBT etiketlerini
     * yok sayar. Kaide boşaltıldığında etiket boş olduğu için istemci eski eşyayı
     * göstermeye devam ederdi; burada etiket boş olsa bile her zaman uyguluyoruz.
     */
    @Override
    public void onDataPacket(net.minecraft.network.Connection connection,
                             ClientboundBlockEntityDataPacket packet,
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

