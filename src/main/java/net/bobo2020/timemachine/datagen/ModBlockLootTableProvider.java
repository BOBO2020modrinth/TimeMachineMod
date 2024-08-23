package net.bobo2020.timemachine.datagen;

import net.bobo2020.timemachine.block.ModBlocks;
import net.bobo2020.timemachine.item.ModItems;
import net.bobo2020.timemachine.util.ModTags;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.List;
import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
        protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
            super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
        }

        protected static final LootItemCondition.Builder HAS_PICKAXE;

        static List<ItemLike> PICKAXE = List.of(Items.WOODEN_PICKAXE, Items.STONE_PICKAXE, Items.IRON_PICKAXE,
                Items.GOLDEN_PICKAXE, Items.DIAMOND_PICKAXE, Items.NETHERITE_PICKAXE);

    @Override
    protected void generate() {
        dropSelf(ModBlocks.LIGHT_STONE_BRICKS.get());
        dropSelf(ModBlocks.LIGHT_STONE_TILE.get());
        dropSelf(ModBlocks.ANTIMONY_BLOCK.get());

        dropSelf(ModBlocks.LIGHT_STONE_STAIRS.get());
        dropSelf(ModBlocks.LIGHT_COBBLESTONE_STAIRS.get());

        this.add(ModBlocks.LIGHT_STONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LIGHT_STONE_SLAB.get()));
        this.add(ModBlocks.LIGHT_COBBLESTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LIGHT_COBBLESTONE_SLAB.get()));

        dropSelf(ModBlocks.LIGHT_STONE_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.LIGHT_STONE_BUTTON.get());

        this.add(ModBlocks.ANCIENT_LIGHT_STONE.get(),
                block -> createShardDrop(ModBlocks.ANCIENT_LIGHT_COBBLESTONE.get(), ModItems.STONE_SHARD_LIGHT.get()));
        this.add(ModBlocks.ANCIENT_LIGHT_COBBLESTONE.get(),
                block -> createShardDrop(ModBlocks.ANCIENT_LIGHT_COBBLESTONE.get(), ModItems.STONE_SHARD_LIGHT.get()));

        this.add(ModBlocks.ANTIMONY_ORE.get(),
                block -> createOreDrop(ModBlocks.ANTIMONY_ORE.get(), ModItems.RAW_ANTIMONY.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }

    protected LootTable.Builder createPickaxeDispatchTable(Block block, LootPoolEntryContainer.Builder<?> builder) {
        return createSelfDropDispatchTable(block, HAS_PICKAXE, builder);
    }

        protected LootTable.Builder createShardDrop(Block block, Item item) {
            return this.createPickaxeDispatchTable(block, (LootPoolEntryContainer.Builder)
                    this.applyExplosionDecay(block, LootItem.lootTableItem(item))
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0f, 5.0f))));
        }

    static {
        HAS_PICKAXE = MatchTool.toolMatches(ItemPredicate.Builder.item()
                .of(ModTags.Items.PICKAXES));
    }
}
