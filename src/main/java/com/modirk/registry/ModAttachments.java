package com.modirk.registry;

import com.modirk.Modirk;
import com.modirk.race.Race;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

/**
 * Modun veri ekleri (data attachments).
 *
 * <p>Irk, oyuncuya bağlı kalıcı bir veridir: diske yazılır, istemciye senkronlanır
 * ve ölümden sonra korunup korunmayacağı {@code ModConfig.KEEP_RACE_ON_DEATH} ile
 * belirlenir. Bu yüzden {@code copyOnDeath()} kullanılmıyor; kopyalama
 * {@code RaceEvents#onClone} içinde yapılıyor.</p>
 */
public final class ModAttachments {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES =
            DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, Modirk.MOD_ID);

    /** Oyuncunun ırkı; varsayılan {@link Race#NONE}. */
    public static final DeferredHolder<AttachmentType<?>, AttachmentType<Race>> RACE =
            ATTACHMENT_TYPES.register("race", () -> AttachmentType.builder(() -> Race.NONE)
                    .serialize(Race.CODEC)
                    .sync(Race.STREAM_CODEC)
                    .build());

    private ModAttachments() {
    }

    public static void register(IEventBus modEventBus) {
        ATTACHMENT_TYPES.register(modEventBus);
    }
}
