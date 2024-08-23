package net.bobo2020.timemachine.datagen;

import net.bobo2020.timemachine.TimeMachine;
import net.bobo2020.timemachine.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
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

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.ANTIMONY_ORE.get())
                .add(ModBlocks.ANTIMONY_BLOCK.get());
    }
}
