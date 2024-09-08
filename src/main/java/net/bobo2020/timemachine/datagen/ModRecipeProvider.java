package net.bobo2020.timemachine.datagen;

import net.bobo2020.timemachine.TimeMachine;
import net.bobo2020.timemachine.block.ModBlocks;
import net.bobo2020.timemachine.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

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

        createPickaxe(ModItems.LIGHT_PICKAXE, ModItems.STONE_SHARD_LIGHT, ModItems.LIGHT_STICK,
                RecipeCategory.TOOLS, pRecipeOutput);
        createAxe(ModItems.LIGHT_AXE, ModItems.STONE_SHARD_LIGHT, ModItems.LIGHT_STICK,
                RecipeCategory.TOOLS, pRecipeOutput);
        createShovel(ModItems.LIGHT_SHOVEL, ModItems.STONE_SHARD_LIGHT, ModItems.LIGHT_STICK,
                RecipeCategory.TOOLS, pRecipeOutput);
        createHoe(ModItems.LIGHT_HOE, ModItems.STONE_SHARD_LIGHT, ModItems.LIGHT_STICK,
                RecipeCategory.TOOLS, pRecipeOutput);
        createSword(ModItems.LIGHT_SWORD, ModItems.STONE_SHARD_LIGHT, ModItems.LIGHT_STICK,
                RecipeCategory.COMBAT, pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LIGHT_STICK.get(), 4)
                .pattern("A")
                .pattern("A")
                .define('A', ModItems.STONE_SHARD_LIGHT.get())
                .unlockedBy("has_light_shard", has(ModItems.STONE_SHARD_LIGHT.get())).save(pRecipeOutput);

        brickRecipe(ModBlocks.LIGHT_STONE_BRICKS, ModBlocks.ANCIENT_LIGHT_STONE, pRecipeOutput,
                RecipeCategory.BUILDING_BLOCKS);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_STONE_TILE.get(), 4)
                .pattern("AB")
                .pattern("BA")
                .define('A', ModBlocks.ANCIENT_LIGHT_STONE.get())
                .define('B', ModBlocks.LIGHT_STONE_BRICKS.get())
                .unlockedBy("has_light_stone", has(ModBlocks.ANCIENT_LIGHT_STONE.get())).save(pRecipeOutput);

        itemToBlock(ModBlocks.ANCIENT_LIGHT_COBBLESTONE, ModItems.STONE_SHARD_LIGHT, pRecipeOutput,
                RecipeCategory.BUILDING_BLOCKS);
        itemToBlock(ModBlocks.ANTIMONY_BLOCK, ModItems.ANTIMONY_INGOT, pRecipeOutput, RecipeCategory.BUILDING_BLOCKS);

        blockToItem(ModItems.ANTIMONY_INGOT, ModBlocks.ANTIMONY_BLOCK, pRecipeOutput, RecipeCategory.MISC);

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

        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_STONE_WALL.get(),
                ModBlocks.ANCIENT_LIGHT_STONE.get());
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_COBBLESTONE_WALL.get(),
                ModBlocks.ANCIENT_LIGHT_COBBLESTONE.get());

        doorBuilder(ModBlocks.LIGHT_STONE_DOOR.get(), Ingredient.of(ModBlocks.ANCIENT_LIGHT_STONE.get()))
                .group("light_stone").unlockedBy("has_stone",
                        has(ModBlocks.ANCIENT_LIGHT_STONE.get())).save(pRecipeOutput);
        trapdoorBuilder(ModBlocks.LIGHT_STONE_TRAPDOOR.get(), Ingredient.of(ModBlocks.ANCIENT_LIGHT_STONE.get()))
                .group("light_stone").unlockedBy("has_stone",
                        has(ModBlocks.ANCIENT_LIGHT_STONE.get())).save(pRecipeOutput);


        pressurePlate(pRecipeOutput, ModBlocks.LIGHT_STONE_PRESSURE_PLATE.get(), ModBlocks.ANCIENT_LIGHT_STONE.get());
        buttonBuilder(ModBlocks.LIGHT_STONE_BUTTON.get(), Ingredient.of(ModBlocks.ANCIENT_LIGHT_STONE.get()))
                .group("light_stone").unlockedBy("has_light_stone", has(ModBlocks.ANCIENT_LIGHT_STONE.get()))
                .save(pRecipeOutput);

        createFenceAndGate(ModBlocks.LIGHT_STONE_FENCE, ModBlocks.LIGHT_STONE_FENCE_GATE,
                ModBlocks.ANCIENT_LIGHT_STONE, ModItems.LIGHT_STICK, pRecipeOutput);

        // Smelting
        oreSmelting(pRecipeOutput, LIGHT_STONE, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ANCIENT_LIGHT_STONE.get(),
                0f, 200, "light_stone");
        oreSmelting(pRecipeOutput, ANTIMONY_ORES, RecipeCategory.MISC, ModItems.ANTIMONY_INGOT.get(),
                0.5f, 200, "antimony");

        // Blasting
        oreBlasting(pRecipeOutput, ANTIMONY_ORES, RecipeCategory.MISC, ModItems.ANTIMONY_INGOT.get(),
                0.75f, 100, "antimony");
    }


    protected static void itemToBlock(DeferredBlock<Block> pResult, DeferredItem<Item> pIngredient,
                                      RecipeOutput pOutput, RecipeCategory pCategory) {
        ShapedRecipeBuilder.shaped(pCategory, pResult.get())
                .pattern("AAA").pattern("AAA").pattern("AAA")
                .define('A', pIngredient.get())
                .unlockedBy("has_" + pIngredient.getId().getPath(), has(pIngredient.get()))
                .save(pOutput);
    }

    protected static void blockToItem(DeferredItem<Item> pResult, DeferredBlock<Block> pIngredient,
                                      RecipeOutput pOutput, RecipeCategory pCategory) {
        ShapelessRecipeBuilder.shapeless(pCategory, pResult.get(), 9)
                .requires(pIngredient.get())
                .unlockedBy("has_" + pIngredient.getId().getPath(), has(pIngredient.get()))
                .save(pOutput);
    }

    protected static void createFenceAndGate(DeferredBlock<Block> pFence, DeferredBlock<Block> pGate,
                                             DeferredBlock<Block> pIngredient, DeferredItem<Item> pRod,
                                             RecipeOutput pOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, pFence.get())
                .pattern("ABA").pattern("ABA")
                .define('A', pIngredient.get()).define('B', pRod.get())
                .unlockedBy("has_" + pIngredient.get(), has(pIngredient.get()))
                .save(pOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, pGate.get())
                .pattern("BAB").pattern("BAB")
                .define('A', pIngredient.get()).define('B', pRod.get())
                .unlockedBy("has_" + pIngredient.get(), has(pIngredient.get()))
                .save(pOutput);
    }

    protected static void brickRecipe(DeferredBlock<Block> pResult, DeferredBlock<Block> pIngredient,
                                      RecipeOutput pOutput, RecipeCategory pCategory) {
        ShapedRecipeBuilder.shaped(pCategory, pResult.get())
                .pattern("AA").pattern("AA")
                .define('A', pIngredient.get())
                .unlockedBy("has_" + pIngredient.getId().getPath(), has(pIngredient.get()))
                .save(pOutput);
    }

    private static void createPickaxe(DeferredItem<Item> pResult, DeferredItem<Item> pIngredient,
                                      DeferredItem<Item> pRod, RecipeCategory pCategory, RecipeOutput pOutput) {
        ShapedRecipeBuilder.shaped(pCategory, pResult.get())
                .pattern("AAA").pattern(" B ").pattern(" B ")
                .define('A', pIngredient.get()).define('B', pRod.get())
                .unlockedBy("has_" + pIngredient.getId().getPath(), has(pIngredient.get()))
                .save(pOutput);
    }

    private static void createSword(DeferredItem<Item> pResult, DeferredItem<Item> pIngredient,
                                      DeferredItem<Item> pRod, RecipeCategory pCategory, RecipeOutput pOutput) {
        ShapedRecipeBuilder.shaped(pCategory, pResult.get())
                .pattern("A").pattern("A").pattern("B")
                .define('A', pIngredient.get()).define('B', pRod.get())
                .unlockedBy("has_" + pIngredient.getId().getPath(), has(pIngredient.get()))
                .save(pOutput);
    }

    private static void createShovel(DeferredItem<Item> pResult, DeferredItem<Item> pIngredient,
                                    DeferredItem<Item> pRod, RecipeCategory pCategory, RecipeOutput pOutput) {
        ShapedRecipeBuilder.shaped(pCategory, pResult.get())
                .pattern("A").pattern("B").pattern("B")
                .define('A', pIngredient.get()).define('B', pRod.get())
                .unlockedBy("has_" + pIngredient.getId().getPath(), has(pIngredient.get()))
                .save(pOutput);
    }

    private static void createAxe(DeferredItem<Item> pResult, DeferredItem<Item> pIngredient,
                                     DeferredItem<Item> pRod, RecipeCategory pCategory, RecipeOutput pOutput) {
        ShapedRecipeBuilder.shaped(pCategory, pResult.get())
                .pattern("AA").pattern("AB").pattern(" B")
                .define('A', pIngredient.get()).define('B', pRod.get())
                .unlockedBy("has_" + pIngredient.getId().getPath(), has(pIngredient.get()))
                .save(pOutput);
    }

    private static void createHoe(DeferredItem<Item> pResult, DeferredItem<Item> pIngredient,
                                  DeferredItem<Item> pRod, RecipeCategory pCategory, RecipeOutput pOutput) {
        ShapedRecipeBuilder.shaped(pCategory, pResult.get())
                .pattern("AA").pattern(" B").pattern(" B")
                .define('A', pIngredient.get()).define('B', pRod.get())
                .unlockedBy("has_" + pIngredient.getId().getPath(), has(pIngredient.get()))
                .save(pOutput);
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
