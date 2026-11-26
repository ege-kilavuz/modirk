package com.modirk.race;

import com.modirk.registry.ModAttachments;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Irk verisine erişim için kısa yardımcılar.
 *
 * <p>Sunucu ve istemci aynı API'yi kullanır; istemcide değer, attachment
 * senkronizasyonu ile dolar. Bir değer henüz gelmediyse {@link Race#NONE} döner.</p>
 */
public final class RaceData {
    private RaceData() {
    }

    /** Oyuncunun ırkı; hiç atanmadıysa {@link Race#NONE}. */
    public static @NotNull Race get(Player player) {
        return player.getData(ModAttachments.RACE.get());
    }

    public static @NotNull Race get(Entity entity) {
        return entity.getData(ModAttachments.RACE.get());
    }

    /** Irkı yazar; senkronizasyon attachment tarafından otomatik yapılır. */
    public static void set(Player player, @NotNull Race race) {
        player.setData(ModAttachments.RACE.get(), race);
    }

    public static void set(Entity entity, @NotNull Race race) {
        entity.setData(ModAttachments.RACE.get(), race);
    }

    /** Oyuncunun atanmış (NONE dışı) bir ırkı var mı? */
    public static boolean hasRace(Player player) {
        return get(player).isPlayable();
    }

    /** Irkı temizler. */
    public static void clear(Player player) {
        set(player, Race.NONE);
    }
}
