package net.bobo2020.timemachine.datagen;

import net.bobo2020.timemachine.TimeMachine;
import net.bobo2020.timemachine.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
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
        stairsBlock(((StairBlock) ModBlocks.LIGHT_COBBLESTONE_STAIRS.get()),
                blockTexture(ModBlocks.ANCIENT_LIGHT_COBBLESTONE.get()));

        slabBlock(((SlabBlock) ModBlocks.LIGHT_STONE_SLAB.get()),
                blockTexture(ModBlocks.ANCIENT_LIGHT_STONE.get()), blockTexture(ModBlocks.ANCIENT_LIGHT_STONE.get()));
        slabBlock(((SlabBlock) ModBlocks.LIGHT_COBBLESTONE_SLAB.get()),
                blockTexture(ModBlocks.ANCIENT_LIGHT_COBBLESTONE.get()), blockTexture(ModBlocks.ANCIENT_LIGHT_COBBLESTONE.get()));

        pressurePlateBlock(((PressurePlateBlock) ModBlocks.LIGHT_STONE_PRESSURE_PLATE.get()),
                blockTexture(ModBlocks.ANCIENT_LIGHT_STONE.get()));

        buttonBlock(((ButtonBlock) ModBlocks.LIGHT_STONE_BUTTON.get()),
                blockTexture(ModBlocks.ANCIENT_LIGHT_STONE.get()));

        blockItem(ModBlocks.LIGHT_STONE_STAIRS);
        blockItem(ModBlocks.LIGHT_STONE_SLAB);
        blockItem(ModBlocks.LIGHT_COBBLESTONE_STAIRS);
        blockItem(ModBlocks.LIGHT_COBBLESTONE_SLAB);
        blockItem(ModBlocks.LIGHT_STONE_PRESSURE_PLATE);
    }

    private void blockWithItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockItem(deferredBlock.get(),
                new ModelFile.UncheckedModelFile("time_machine:block/" + deferredBlock.getId().getPath()));
    }
}
