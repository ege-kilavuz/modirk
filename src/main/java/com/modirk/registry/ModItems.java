package com.modirk.registry;

import com.modirk.Modirk;
import com.modirk.item.RaceSpiritItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * Mod eşyalarının kayıtları.
 *
 * <p>M0: üç ruh eşyası. M2: Ruh Kaidesi blok eşyası.</p>
 */
public final class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Modirk.MOD_ID);

    public static final DeferredItem<Item> REDSTONE_RUH =
            ITEMS.register("redstone_ruhu", () -> new RaceSpiritItem(
                    new Item.Properties().stacksTo(1), "tooltip.modirk.redstone_ruhu"));

    public static final DeferredItem<Item> BUILDER_RUH =
            ITEMS.register("builder_ruhu", () -> new RaceSpiritItem(
                    new Item.Properties().stacksTo(1), "tooltip.modirk.builder_ruhu"));

    public static final DeferredItem<Item> PVP_RUH =
            ITEMS.register("pvp_ruhu", () -> new RaceSpiritItem(
                    new Item.Properties().stacksTo(1), "tooltip.modirk.pvp_ruhu"));

    /** Ruh Kaidesi bloğunun eşyası. */
    public static final DeferredItem<BlockItem> RUH_KAIDESI =
            ITEMS.registerSimpleBlockItem(ModBlocks.RUH_KAIDESI);

    private ModItems() {
    }

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
