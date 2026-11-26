package com.modirk;

import com.modirk.command.RaceCommand;
import com.modirk.config.ModConfigs;
import com.modirk.race.RaceEvents;
import com.modirk.registry.ModAttachments;
import com.modirk.registry.ModCreativeTabs;
import com.modirk.registry.ModItems;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;

/**
 * Races (modirk) ana giriş noktası.
 *
 * <p>Nether kalelerini ele geçirmiş üç düşmüş muhafızı yen, düşen Ruh Taşı ve
 * kılıç parçalarıyla Nether'da kendi kurduğun ritüel alanında bir ırkla bağ kur.</p>
 */
@Mod(Modirk.MOD_ID)
public final class Modirk {
    public static final String MOD_ID = "modirk";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Modirk(IEventBus modEventBus, ModContainer modContainer) {
        // Kayıtlar (mod veri yolu)
        ModItems.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
        ModAttachments.register(modEventBus);

        // Ayarlar (sunucu, dünya başına)
        ModConfigs.register(modContainer);

        // Oyun olayları
        NeoForge.EVENT_BUS.addListener(RaceEvents::onPlayerClone);
        NeoForge.EVENT_BUS.addListener(RaceCommand::onRegisterCommands);

        LOGGER.info("Races (modirk) yüklendi.");
    }
}
