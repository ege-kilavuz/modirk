package com.modirk.registry;

import com.modirk.Modirk;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * Mod eşyalarının kayıtları.
 *
 * <p>M0 iskeleti: üç ruh eşyası. Ritüel ve ırk mantığı sonraki kilometre
 * taşlarında eklenecek.</p>
 */
public final class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Modirk.MOD_ID);

    public static final DeferredItem<Item> REDSTONE_RUH =
            ITEMS.registerSimpleItem("redstone_ruhu", new Item.Properties().stacksTo(1));

    public static final DeferredItem<Item> BUILDER_RUH =
            ITEMS.registerSimpleItem("builder_ruhu", new Item.Properties().stacksTo(1));

    public static final DeferredItem<Item> PVP_RUH =
            ITEMS.registerSimpleItem("pvp_ruhu", new Item.Properties().stacksTo(1));

    private ModItems() {
    }

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
