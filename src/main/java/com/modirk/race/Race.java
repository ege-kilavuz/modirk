package com.modirk.race;

import com.mojang.serialization.Codec;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Oyuncunun bağ kurabileceği ırklar.
 *
 * <p>{@link #NONE} "henüz ırk yok" durumudur; oyuncuya atanabilir bir ırk değildir.
 * Sıralama kayda yazılmaz: diskte ve ağda {@link #getSerializedName()} kullanılır,
 * böylece enum sırası değişse bile eski dünyalar bozulmaz.</p>
 */
public enum Race implements StringRepresentable {
    /** Henüz ritüel tamamlanmadı. */
    NONE("none", 0x8A8178),
    /** Sinyal Efendisi'nin mirası: Ruh Cebi. */
    REDSTONE("redstone", 0xD63031),
    /** Mimar-ı Azam'ın mirası: doğal blok ödülü. */
    BUILDER("builder", 0xE08A3C),
    /** Kanlı Muhafız'ın mirası: adrenalin. */
    PVP("pvp", 0xB3122E);

    /** Oyuncuya atanabilen ırklar (NONE hariç). */
    public static final List<Race> PLAYABLE = List.of(REDSTONE, BUILDER, PVP);

    private static final Race[] VALUES = values();

    /** Disk kaydı ve veri paketleri için isim tabanlı kodek. */
    public static final Codec<Race> CODEC = StringRepresentable.fromEnum(Race::values);

    /** Ağ senkronizasyonu için tek baytlık kodek. */
    public static final StreamCodec<FriendlyByteBuf, Race> STREAM_CODEC = StreamCodec.of(
            (buf, race) -> buf.writeByte(race.ordinal()),
            buf -> VALUES[buf.readByte() & 0xFF]);

    private final String id;
    private final int color;

    Race(String id, int color) {
        this.id = id;
        this.color = color;
    }

    @Override
    public @NotNull String getSerializedName() {
        return this.id;
    }

    /** Komutlarda ve kayıtta kullanılan kimlik. */
    public String getId() {
        return this.id;
    }

    /** Sohbet/HUD rengi (0xRRGGBB). */
    public int getColor() {
        return this.color;
    }

    /** Bir ırkın oyuncuya atanabilir olup olmadığı. */
    public boolean isPlayable() {
        return this != NONE;
    }

    /** Çeviri anahtarı: {@code race.modirk.<id>}. */
    public String getTranslationKey() {
        return "race.modirk." + this.id;
    }

    /** Renkli görünen ad. */
    public Component getDisplayName() {
        return Component.translatable(this.getTranslationKey()).withStyle(style -> style.withColor(this.color));
    }

    /** Komut çıktısı için sade (renksiz) ad. */
    public Component getPlainName() {
        return Component.translatable(this.getTranslationKey());
    }

    /** Bilinmeyen kimliklerde {@code null} döner. */
    @Nullable
    public static Race byId(@Nullable String id) {
        if (id == null) {
            return null;
        }
        String normalized = id.toLowerCase(Locale.ROOT);
        for (Race race : VALUES) {
            if (race.id.equals(normalized)) {
                return race;
            }
        }
        return null;
    }

    public static Optional<Race> optionalById(@Nullable String id) {
        return Optional.ofNullable(byId(id));
    }

    public static List<String> playableIds() {
        return PLAYABLE.stream().map(Race::getId).toList();
    }

    /** {@code /race list} çıktısı: {@code redstone, builder, pvp}. */
    public static String playableIdList() {
        return String.join(", ", playableIds());
    }

    @Override
    public String toString() {
        return this.id;
    }

    /** Test/teşhis için tüm değerler. */
    public static List<Race> all() {
        return Arrays.asList(VALUES);
    }
}
