package com.modirk.item;

import com.modirk.race.Race;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

/**
 * Bir muhafızın taşan ruh parçası: ritüelin anahtarı.
 *
 * <p>Hangi ırka ait olduğu {@link #getRace()} ile bilinir; ritüel motoru
 * taşın ırkı ile Lanetli Taş'ın malzemesini eşleştirecek.</p>
 */
public class SpiritStoneItem extends Item {
    private final Race race;

    public SpiritStoneItem(Properties properties, Race race) {
        super(properties);
        this.race = race;
    }

    public Race getRace() {
        return this.race;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents,
                                TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.modirk.ruh_tasi." + this.race.getId())
                .withStyle(ChatFormatting.GRAY));
        tooltipComponents.add(Component.translatable("tooltip.modirk.ruh_tasi.hint")
                .withStyle(ChatFormatting.DARK_GRAY, ChatFormatting.ITALIC));
    }
}
