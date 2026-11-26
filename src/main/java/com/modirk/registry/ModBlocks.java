package com.modirk.registry;

import com.modirk.Modirk;
import com.modirk.block.RuhKaidesiBlock;
import com.modirk.block.SunakBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * Mod bloklarının kayıtları.
 *
 * <p>M2'nin ilk bloğu {@link #RUH_KAIDESI}: üstüne konan tek eşyayı havada
 * döndürerek sergileyen ritüel kaidesi.</p>
 */
public final class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Modirk.MOD_ID);

    public static final DeferredBlock<RuhKaidesiBlock> RUH_KAIDESI = BLOCKS.registerBlock(
            "ruh_kaidesi",
            RuhKaidesiBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.DEEPSLATE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(3.5F, 6.0F)
                    .sound(SoundType.STONE)
                    .noOcclusion());

    public static final DeferredBlock<SunakBlock> SUNAK = BLOCKS.registerBlock(
            "sunak",
            SunakBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.DEEPSLATE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(4.0F, 8.0F)
                    .sound(SoundType.STONE)
                    .lightLevel(state -> state.getValue(SunakBlock.STATE) == com.modirk.block.RitualState.READY ? 7 : 0)
                    .noOcclusion());

    private ModBlocks() {
    }

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}
