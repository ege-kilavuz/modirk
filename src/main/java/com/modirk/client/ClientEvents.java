package com.modirk.client;

import com.modirk.Modirk;
import com.modirk.registry.ModBlockEntities;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

/**
 * İstemci tarafı kayıtları.
 */
@SuppressWarnings("removal")
@EventBusSubscriber(modid = Modirk.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientEvents {
    private ClientEvents() {
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.RUH_KAIDESI.get(), RuhKaidesiRenderer::new);
    }
}
