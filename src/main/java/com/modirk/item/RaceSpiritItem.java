package com.modirk.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

/**
 * Bir ırkın ruhunu taşıyan eşya.
 *
 * <p>Şimdilik düz 2D item olarak görünür. İleride GeckoLib ile 3D animasyonlu
 * item modeline geçilecek; modelleme sonraki aşamada yapılacak.</p>
 */
public class RaceSpiritItem extends Item {
    private final String descriptionKey;

    public RaceSpiritItem(Properties properties, String descriptionKey) {
        super(properties);
        this.descriptionKey = descriptionKey;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents,
                                TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable(this.descriptionKey).withStyle(ChatFormatting.GRAY));
        tooltipComponents.add(Component.translatable("tooltip.modirk.race_spirit.hint")
                .withStyle(ChatFormatting.DARK_GRAY, ChatFormatting.ITALIC));
    }
}
