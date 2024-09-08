package net.bobo2020.timemachine.item;

import net.bobo2020.timemachine.TimeMachine;
import net.bobo2020.timemachine.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TimeMachine.MOD_ID);

    public static final Supplier<CreativeModeTab> ANCIENT_ERA_ITEM =
            CREATIVE_MODE_TABS.register("ancient_era_item", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.time_machine.ancient_era_item"))
                    .icon(() -> new ItemStack(ModItems.STONE_SHARD_LIGHT.get()))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.RAW_ANTIMONY);
                        pOutput.accept(ModItems.ANTIMONY_INGOT);
                        pOutput.accept(ModItems.STONE_SHARD_LIGHT);
                        pOutput.accept(ModItems.PURSLANE);
                        pOutput.accept(ModItems.MOSSY_PEAT);

                        pOutput.accept(ModItems.LIGHT_STICK);
                        pOutput.accept(ModItems.LIGHT_SWORD);
                        pOutput.accept(ModItems.LIGHT_HAMMER);
                        pOutput.accept(ModItems.LIGHT_COMPLEX_HAMMER);
                        pOutput.accept(ModItems.LIGHT_AXE);
                        pOutput.accept(ModItems.LIGHT_SHOVEL);
                        pOutput.accept(ModItems.LIGHT_PICKAXE);
                        pOutput.accept(ModItems.LIGHT_HOE);
                        pOutput.accept(ModItems.LIGHT_PAXEL);
                    }).build());

    public static final Supplier<CreativeModeTab> ANCIENT_ERA_BLOCK =
            CREATIVE_MODE_TABS.register("ancient_era_block", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.time_machine.ancient_era_block"))
                    .icon(() -> new ItemStack(ModBlocks.ANCIENT_LIGHT_STONE.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TimeMachine.MOD_ID, "ancient_era_item"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.ANCIENT_LIGHT_STONE);
                        pOutput.accept(ModBlocks.LIGHT_STONE_STAIRS);
                        pOutput.accept(ModBlocks.LIGHT_STONE_SLAB);
                        pOutput.accept(ModBlocks.LIGHT_STONE_PRESSURE_PLATE);
                        pOutput.accept(ModBlocks.LIGHT_STONE_TRAPDOOR);
                        pOutput.accept(ModBlocks.LIGHT_STONE_DOOR);
                        pOutput.accept(ModBlocks.LIGHT_STONE_WALL);
                        pOutput.accept(ModBlocks.LIGHT_STONE_FENCE);
                        pOutput.accept(ModBlocks.LIGHT_STONE_FENCE_GATE);
                        pOutput.accept(ModBlocks.LIGHT_STONE_BUTTON);

                        pOutput.accept(ModBlocks.ANCIENT_LIGHT_COBBLESTONE);
                        pOutput.accept(ModBlocks.LIGHT_COBBLESTONE_STAIRS);
                        pOutput.accept(ModBlocks.LIGHT_COBBLESTONE_SLAB);
                        pOutput.accept(ModBlocks.LIGHT_COBBLESTONE_WALL);

                        pOutput.accept(ModBlocks.LIGHT_STONE_BRICKS);
                        pOutput.accept(ModBlocks.LIGHT_STONE_TILE);

                        pOutput.accept(ModBlocks.ANTIMONY_ORE);
                        pOutput.accept(ModBlocks.ANTIMONY_BLOCK);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
