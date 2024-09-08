package net.bobo2020.timemachine.datagen;

import net.bobo2020.timemachine.TimeMachine;
import net.bobo2020.timemachine.item.ModItems;
import net.bobo2020.timemachine.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, TimeMachine.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Items.PICKAXES)
                .addTag(ModTags.Items.HAMMERS)
                .add(Items.WOODEN_PICKAXE)
                .add(Items.STONE_PICKAXE)
                .add(Items.IRON_PICKAXE)
                .add(Items.GOLDEN_PICKAXE)
                .add(Items.DIAMOND_PICKAXE)
                .add(Items.NETHERITE_PICKAXE)
                .add(ModItems.LIGHT_PICKAXE.get());

        this.tag(ModTags.Items.HAMMERS)
                .add(ModItems.LIGHT_HAMMER.get());
    }
}
