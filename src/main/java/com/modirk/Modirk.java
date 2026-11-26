package com.modirk;

import com.modirk.registry.ModCreativeTabs;
import com.modirk.registry.ModItems;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

/**
 * Races (modirk) ana giriş noktası.
 *
 * <p>Nether kalelerini ele geçirmiş üç bossu yen, Ruh Taşı'nı topla ve
 * kendi ritüel alanında bir ırkla bağ kur.</p>
 */
@Mod(Modirk.MOD_ID)
public final class Modirk {
    public static final String MOD_ID = "modirk";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Modirk(IEventBus modEventBus, ModContainer modContainer) {
        ModItems.register(modEventBus);
        ModCreativeTabs.register(modEventBus);

        LOGGER.info("Races (modirk) yüklendi.");
    }
}
