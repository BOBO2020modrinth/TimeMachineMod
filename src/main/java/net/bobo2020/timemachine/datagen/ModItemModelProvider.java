package net.bobo2020.timemachine.datagen;

import net.bobo2020.timemachine.TimeMachine;
import net.bobo2020.timemachine.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

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
    }
}
