package net.bobo2020.timemachine.item;

import net.bobo2020.timemachine.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier LIGHT_STONE = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_LIGHT_STONE_TOOL, 180,
            4.5f, 1.25f, 15, () -> Ingredient.of(ModItems.STONE_SHARD_LIGHT.get()));
}
