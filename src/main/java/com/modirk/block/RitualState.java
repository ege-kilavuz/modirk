package com.modirk.block;

import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.state.properties.EnumProperty;

/**
 * Sunağın görsel/ritüel durumu.
 *
 * <ul>
 *   <li>{@link #IDLE} — taş yok, çanak sönük.</li>
 *   <li>{@link #READY} — Ruh Taşı yerleşti, ritüel başlatılabilir.</li>
 *   <li>{@link #EXHAUSTED} — ritüel tükendi; yeni Ruh Taşı bekler.</li>
 * </ul>
 */
public enum RitualState implements StringRepresentable {
    IDLE("idle"),
    READY("ready"),
    EXHAUSTED("exhausted");

    public static final EnumProperty<RitualState> PROPERTY =
            EnumProperty.create("state", RitualState.class);

    private final String id;

    RitualState(String id) {
        this.id = id;
    }

    @Override
    public String getSerializedName() {
        return this.id;
    }
}
