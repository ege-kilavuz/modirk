package com.modirk.registry;

import com.modirk.Modirk;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * Races için özel yaratıcı mod sekmesi.
 */
public final class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Modirk.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN = TABS.register("main",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.modirk"))
                    .icon(() -> ModItems.REDSTONE_RUH.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.REDSTONE_RUH.get());
                        output.accept(ModItems.BUILDER_RUH.get());
                        output.accept(ModItems.PVP_RUH.get());
                        output.accept(ModItems.RUH_KAIDESI.get());
                    })
                    .build());

    private ModCreativeTabs() {
    }

    public static void register(IEventBus modEventBus) {
        TABS.register(modEventBus);
    }
}
