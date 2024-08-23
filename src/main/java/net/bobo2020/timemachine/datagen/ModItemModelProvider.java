package net.bobo2020.timemachine.datagen;

import net.bobo2020.timemachine.TimeMachine;
import net.bobo2020.timemachine.block.ModBlocks;
import net.bobo2020.timemachine.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TimeMachine.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.STONE_SHARD_LIGHT.get());
        basicItem(ModItems.RAW_ANTIMONY.get());
        basicItem(ModItems.ANTIMONY_INGOT.get());
        basicItem(ModItems.PURSLANE.get());
        basicItem(ModItems.MOSSY_PEAT.get());

        fenceItem(ModBlocks.LIGHT_STONE_FENCE, ModBlocks.ANCIENT_LIGHT_STONE);
        wallItem(ModBlocks.LIGHT_STONE_WALL, ModBlocks.ANCIENT_LIGHT_STONE);
        wallItem(ModBlocks.LIGHT_COBBLESTONE_WALL, ModBlocks.ANCIENT_LIGHT_COBBLESTONE);

        basicItem(ModBlocks.LIGHT_STONE_DOOR.asItem());

        buttonItem(ModBlocks.LIGHT_STONE_BUTTON, ModBlocks.ANCIENT_LIGHT_STONE);
    }

    public void buttonItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(TimeMachine.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(TimeMachine.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", ResourceLocation.fromNamespaceAndPath(TimeMachine.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }
}
