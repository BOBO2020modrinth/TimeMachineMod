package net.bobo2020.timemachine.datagen;

import net.bobo2020.timemachine.TimeMachine;
import net.bobo2020.timemachine.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TimeMachine.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ANCIENT_LIGHT_STONE);
        blockWithItem(ModBlocks.ANCIENT_LIGHT_COBBLESTONE);
        blockWithItem(ModBlocks.LIGHT_STONE_BRICKS);
        blockWithItem(ModBlocks.LIGHT_STONE_TILE);
        blockWithItem(ModBlocks.ANTIMONY_ORE);
        blockWithItem(ModBlocks.ANTIMONY_BLOCK);

        stairsBlock(((StairBlock) ModBlocks.LIGHT_STONE_STAIRS.get()),
                blockTexture(ModBlocks.ANCIENT_LIGHT_STONE.get()));

        slabBlock(((SlabBlock) ModBlocks.LIGHT_STONE_SLAB.get()),
                blockTexture(ModBlocks.ANCIENT_LIGHT_STONE.get()), blockTexture(ModBlocks.ANCIENT_LIGHT_STONE.get()));

        blockItem(ModBlocks.LIGHT_STONE_STAIRS);
        blockItem(ModBlocks.LIGHT_STONE_SLAB);
    }

    private void blockWithItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockItem(deferredBlock.get(),
                new ModelFile.UncheckedModelFile("time_machine:block/" + deferredBlock.getId().getPath()));
    }
}
