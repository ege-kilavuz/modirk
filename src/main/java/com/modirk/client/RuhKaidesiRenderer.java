package com.modirk.client;

import com.modirk.block.entity.RuhKaidesiBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

/**
 * Ruh Kaidesi üstündeki eşyayı havada, yavaşça dönerken çizer.
 */
public class RuhKaidesiRenderer implements BlockEntityRenderer<RuhKaidesiBlockEntity> {
    public RuhKaidesiRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(@NotNull RuhKaidesiBlockEntity pedestal, float partialTick, @NotNull PoseStack pose,
                       @NotNull MultiBufferSource buffers, int packedLight, int packedOverlay) {
        ItemStack stack = pedestal.getDisplayStack();
        if (stack.isEmpty()) {
            return;
        }

        Level level = pedestal.getLevel();
        float time = (level != null ? level.getGameTime() : 0L) + partialTick;
        float bob = (float) Math.sin(time * 0.08F) * 0.04F;

        pose.pushPose();
        pose.translate(0.5D, 1.28D + bob, 0.5D);
        pose.mulPose(Axis.YP.rotationDegrees(time * 1.6F));
        pose.scale(0.72F, 0.72F, 0.72F);

        Minecraft.getInstance().getItemRenderer().renderStatic(
                stack,
                ItemDisplayContext.FIXED,
                packedLight,
                OverlayTexture.NO_OVERLAY,
                pose,
                buffers,
                level,
                0);

        pose.popPose();
    }

    @Override
    public AABB getRenderBoundingBox(RuhKaidesiBlockEntity pedestal) {
        return new AABB(pedestal.getBlockPos()).inflate(0.75D).expandTowards(0.0D, 1.5D, 0.0D);
    }
}
