package net.bobo2020.timemachine.util;

import net.bobo2020.timemachine.TimeMachine;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> INCORRECT_FOR_LIGHT_STONE_TOOL =
                createTag("incorrect_for_light_stone_tool");
        public static final TagKey<Block> NEEDS_LIGHT_STONE_TOOL =
                createTag("needs_light_stone_tool");
        public static final TagKey<Block> PAXEL_MINEABLE =
                createTag("mineable/paxel");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(TimeMachine.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> PICKAXES = createTag("pickaxes");
        public static final TagKey<Item> HAMMERS = createTag("hammers");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(TimeMachine.MOD_ID, name));
        }
    }
}
