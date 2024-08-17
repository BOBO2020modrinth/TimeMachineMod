package net.bobo2020.timemachine.datagen;

import net.bobo2020.timemachine.block.ModBlocks;
import net.bobo2020.timemachine.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_STONE_BRICKS.get())
                .pattern("AA")
                .pattern("AA")
                .define('A', ModBlocks.ANCIENT_LIGHT_STONE.get())
                .unlockedBy("has_light_stone", has(ModBlocks.ANCIENT_LIGHT_STONE.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_STONE_TILE.get())
                .pattern("AB")
                .pattern("BA")
                .define('A', ModBlocks.ANCIENT_LIGHT_STONE.get())
                .define('B', ModBlocks.LIGHT_STONE_BRICKS.get())
                .unlockedBy("has_light_stone", has(ModBlocks.ANCIENT_LIGHT_STONE.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ANCIENT_LIGHT_COBBLESTONE.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.STONE_SHARD_LIGHT.get())
                .unlockedBy("has_light_stone", has(ModBlocks.ANCIENT_LIGHT_STONE.get())).save(pRecipeOutput);
    }
}
