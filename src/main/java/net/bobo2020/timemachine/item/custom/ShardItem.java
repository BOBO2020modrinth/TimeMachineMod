package net.bobo2020.timemachine.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class ShardItem extends Item {
    private String toolTip;

    public ShardItem(Properties properties, String toolTip) {
        super(properties);
        this.toolTip = toolTip;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.time_machine." + toolTip + "_shard"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
