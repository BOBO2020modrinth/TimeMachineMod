package net.bobo2020.timemachine.datagen;

import net.bobo2020.timemachine.TimeMachine;
import net.bobo2020.timemachine.block.ModBlocks;
import net.bobo2020.timemachine.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TimeMachine.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ANCIENT_LIGHT_STONE.get())
                .add(ModBlocks.LIGHT_STONE_STAIRS.get())
                .add(ModBlocks.LIGHT_STONE_SLAB.get())
                .add(ModBlocks.ANCIENT_LIGHT_COBBLESTONE.get())
                .add(ModBlocks.LIGHT_STONE_BRICKS.get())
                .add(ModBlocks.LIGHT_STONE_TILE.get())
                .add(ModBlocks.ANTIMONY_ORE.get())
                .add(ModBlocks.ANTIMONY_BLOCK.get());

        tag(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.LIGHT_STONE_FENCE.get());

        tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.LIGHT_STONE_FENCE_GATE.get());

        tag(BlockTags.WALLS)
                .add(ModBlocks.LIGHT_STONE_WALL.get())
                .add(ModBlocks.LIGHT_COBBLESTONE_WALL.get());

        this.tag(ModTags.Blocks.PAXEL_MINEABLE)
                .addTag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.MINEABLE_WITH_SHOVEL)
                .addTag(BlockTags.MINEABLE_WITH_HOE);

        this.tag(ModTags.Blocks.NEEDS_LIGHT_STONE_TOOL)
                .addTag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.ANTIMONY_BLOCK.get())
                .add(ModBlocks.ANTIMONY_ORE.get());

        this.tag(ModTags.Blocks.INCORRECT_FOR_LIGHT_STONE_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .remove(ModTags.Blocks.NEEDS_LIGHT_STONE_TOOL);

        this.tag(BlockTags.INCORRECT_FOR_WOODEN_TOOL)
                .addTag(ModTags.Blocks.NEEDS_LIGHT_STONE_TOOL);

        this.tag(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .addTag(ModTags.Blocks.NEEDS_LIGHT_STONE_TOOL);

        this.tag(BlockTags.INCORRECT_FOR_IRON_TOOL);

        this.tag(BlockTags.INCORRECT_FOR_GOLD_TOOL)
                .addTag(ModTags.Blocks.NEEDS_LIGHT_STONE_TOOL);

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL);
    }
}
