package net.bobo2020.timemachine.datagen;

import net.bobo2020.timemachine.TimeMachine;
import net.bobo2020.timemachine.block.ModBlocks;
import net.bobo2020.timemachine.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> LIGHT_STONE = List.of(ModBlocks.ANCIENT_LIGHT_COBBLESTONE);
        List<ItemLike> ANTIMONY_ORES = List.of(ModBlocks.ANTIMONY_ORE, ModItems.RAW_ANTIMONY);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_STONE_BRICKS.get(), 4)
                .pattern("AA")
                .pattern("AA")
                .define('A', ModBlocks.ANCIENT_LIGHT_STONE.get())
                .unlockedBy("has_light_stone", has(ModBlocks.ANCIENT_LIGHT_STONE.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_STONE_TILE.get(), 4)
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

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ANTIMONY_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ANTIMONY_INGOT.get())
                .unlockedBy("has_light_stone", has(ModItems.ANTIMONY_INGOT.get())).save(pRecipeOutput);

        stairBuilder(ModBlocks.LIGHT_STONE_STAIRS.get(), Ingredient.of(ModBlocks.ANCIENT_LIGHT_STONE.get()))
                .group("light_stone").unlockedBy("has_light_stone", has(ModBlocks.ANCIENT_LIGHT_STONE.get()))
                .save(pRecipeOutput);
        stairBuilder(ModBlocks.LIGHT_COBBLESTONE_STAIRS.get(), Ingredient.of(ModBlocks.ANCIENT_LIGHT_COBBLESTONE.get()))
                .group("light_cobblestone").unlockedBy("has_light_cobblestone",
                        has(ModBlocks.ANCIENT_LIGHT_COBBLESTONE.get())).save(pRecipeOutput);

        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_STONE_SLAB.get(),
                ModBlocks.ANCIENT_LIGHT_STONE.get());
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_COBBLESTONE_SLAB.get(),
                ModBlocks.ANCIENT_LIGHT_COBBLESTONE.get());

        pressurePlate(pRecipeOutput, ModBlocks.LIGHT_STONE_PRESSURE_PLATE.get(), ModBlocks.ANCIENT_LIGHT_STONE.get());
        buttonBuilder(ModBlocks.LIGHT_STONE_BUTTON.get(), Ingredient.of(ModBlocks.ANCIENT_LIGHT_STONE.get()))
                .group("light_stone").unlockedBy("has_light_stone", has(ModBlocks.ANCIENT_LIGHT_STONE.get()))
                .save(pRecipeOutput);

        // Smelting
        oreSmelting(pRecipeOutput, LIGHT_STONE, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ANCIENT_LIGHT_STONE.get(),
                0f, 200, "light_stone");
        oreSmelting(pRecipeOutput, ANTIMONY_ORES, RecipeCategory.MISC, ModItems.ANTIMONY_INGOT.get(),
                0.5f, 200, "antimony");

        // Blasting
        oreBlasting(pRecipeOutput, ANTIMONY_ORES, RecipeCategory.MISC, ModItems.ANTIMONY_INGOT.get(),
                0.75f, 100, "antimony");
    }


    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, TimeMachine.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
