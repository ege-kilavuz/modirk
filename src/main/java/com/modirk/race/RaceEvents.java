package com.modirk.race;

import com.modirk.config.ModConfigs;
import com.modirk.registry.ModAttachments;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

/**
 * Irk verisinin yaşam döngüsü olayları.
 *
 * <p>Irk attachment'ı {@code copyOnDeath()} kullanmadığı için kopyalama burada,
 * config'e saygı duyarak yapılır. End'den dönüşte de aynı olay tetiklenir;
 * o durumda ırk her zaman korunur.</p>
 */
public final class RaceEvents {
    private RaceEvents() {
    }

    public static void onPlayerClone(PlayerEvent.Clone event) {
        Race previous = event.getOriginal().getData(ModAttachments.RACE.get());
        boolean keep = !event.isWasDeath() || keepRaceOnDeath();
        event.getEntity().setData(ModAttachments.RACE.get(), keep ? previous : Race.NONE);
    }

    private static boolean keepRaceOnDeath() {
        try {
            return ModConfigs.KEEP_RACE_ON_DEATH.get();
        } catch (IllegalStateException ignored) {
            // Config henüz yüklenmediyse güvenli varsayılan: ırkı koru.
            return true;
        }
    }
}
