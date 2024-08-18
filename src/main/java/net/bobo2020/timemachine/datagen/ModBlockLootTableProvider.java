package net.bobo2020.timemachine.datagen;

import net.bobo2020.timemachine.block.ModBlocks;
import net.bobo2020.timemachine.item.ModItems;
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
import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
        protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
            super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
        }

    protected static final LootItemCondition.Builder HAS_PICKAXE;

    @Override
    protected void generate() {
        dropSelf(ModBlocks.LIGHT_STONE_BRICKS.get());
        dropSelf(ModBlocks.LIGHT_STONE_TILE.get());
        dropSelf(ModBlocks.ANTIMONY_BLOCK.get());

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
                .of(new ItemLike[]{Items.WOODEN_PICKAXE}));
    }
}
