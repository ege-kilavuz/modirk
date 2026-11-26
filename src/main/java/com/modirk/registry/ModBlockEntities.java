package com.modirk.registry;

import com.modirk.Modirk;
import com.modirk.block.entity.RuhKaidesiBlockEntity;
import com.modirk.block.entity.SunakBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * Blok varlıklarının (block entity) kayıtları.
 */
public final class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Modirk.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<RuhKaidesiBlockEntity>> RUH_KAIDESI =
            BLOCK_ENTITIES.register("ruh_kaidesi", () -> BlockEntityType.Builder
                    .of(RuhKaidesiBlockEntity::new, ModBlocks.RUH_KAIDESI.get())
                    .build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SunakBlockEntity>> SUNAK =
            BLOCK_ENTITIES.register("sunak", () -> BlockEntityType.Builder
                    .of(SunakBlockEntity::new, ModBlocks.SUNAK.get())
                    .build(null));

    private ModBlockEntities() {
    }

    public static void register(IEventBus modEventBus) {
        BLOCK_ENTITIES.register(modEventBus);
    }
}
