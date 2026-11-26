package com.modirk.registry;

import com.modirk.Modirk;
import com.modirk.item.RaceSpiritItem;
import com.modirk.item.SpiritStoneItem;
import com.modirk.race.Race;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
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

    public static final DeferredItem<Item> RUH_TASI_REDSTONE = ITEMS.register("ruh_tasi_redstone",
            () -> new SpiritStoneItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE), Race.REDSTONE));

    public static final DeferredItem<Item> RUH_TASI_BUILDER = ITEMS.register("ruh_tasi_builder",
            () -> new SpiritStoneItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE), Race.BUILDER));

    public static final DeferredItem<Item> RUH_TASI_PVP = ITEMS.register("ruh_tasi_pvp",
            () -> new SpiritStoneItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE), Race.PVP));

    /** Sunak bloğunun eşyası. */
    public static final DeferredItem<BlockItem> SUNAK =
            ITEMS.registerSimpleBlockItem(ModBlocks.SUNAK);

    private ModItems() {
    }

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
