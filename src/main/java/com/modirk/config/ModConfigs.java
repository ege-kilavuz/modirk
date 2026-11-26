package com.modirk.config;

import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.common.ModConfigSpec;

/**
 * Sunucu tarafı ayarlar.
 *
 * <p>Irk verisi oyuncuya bağlı ve sunucu otoritesinde olduğu için ayarlar
 * {@code net.neoforged.fml.config.ModConfig.Type#SERVER} olarak kaydedilir
 * (dünya başına).</p>
 */
public final class ModConfigs {
    public static final ModConfigSpec SPEC;

    public static final ModConfigSpec.BooleanValue KEEP_RACE_ON_DEATH;
    public static final ModConfigSpec.BooleanValue ANNOUNCE_RACE_CHANGE;
    public static final ModConfigSpec.IntValue COMMAND_PERMISSION_LEVEL;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        builder.comment("Oyuncu irkı davranışı").push("race");
        KEEP_RACE_ON_DEATH = builder
                .comment("Oyuncu öldüğünde ırkı korunsun mu?",
                        "true: ırk ölümden sonra da kalır (varsayılan).",
                        "false: her ölümde ırk sıfırlanır; oyuncu yeniden ritüel yapmalıdır.")
                .define("keepRaceOnDeath", true);
        ANNOUNCE_RACE_CHANGE = builder
                .comment("Irk değişiklikleri sohbette duyurulsun mu?")
                .define("announceRaceChange", true);
        builder.pop();

        builder.comment("Komutlar").push("commands");
        COMMAND_PERMISSION_LEVEL = builder
                .comment("/race set ve /race clear için gereken yetki seviyesi (0-4).")
                .defineInRange("permissionLevel", 2, 0, 4);
        builder.pop();

        SPEC = builder.build();
    }

    private ModConfigs() {
    }

    public static void register(ModContainer modContainer) {
        modContainer.registerConfig(net.neoforged.fml.config.ModConfig.Type.SERVER, SPEC);
    }
}
