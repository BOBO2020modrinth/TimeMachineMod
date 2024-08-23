package net.bobo2020.timemachine.block;

import net.bobo2020.timemachine.TimeMachine;
import net.bobo2020.timemachine.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(TimeMachine.MOD_ID);

    // Add Blocks here...

    public static final DeferredBlock<Block> ANCIENT_LIGHT_STONE = registerBlock("ancient_light_stone",
            () -> new Block(BlockBehaviour.Properties.of().strength(0.75f).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ANCIENT_LIGHT_COBBLESTONE = registerBlock("ancient_light_cobblestone",
            () -> new Block(BlockBehaviour.Properties.of().strength(0.75f).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> LIGHT_STONE_BRICKS = registerBlock("light_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.of().strength(0.8f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> LIGHT_STONE_TILE = registerBlock("light_stone_tile",
            () -> new Block(BlockBehaviour.Properties.of().strength(0.8f).sound(SoundType.STONE).requiresCorrectToolForDrops()));

    // Non-Blocks Block
    public static final DeferredBlock<Block> LIGHT_STONE_STAIRS = registerBlock("light_stone_stairs",
            () -> new StairBlock(ModBlocks.ANCIENT_LIGHT_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(0.75f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> LIGHT_STONE_SLAB = registerBlock("light_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(0.75f).sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> LIGHT_COBBLESTONE_STAIRS = registerBlock("light_cobblestone_stairs",
            () -> new StairBlock(ModBlocks.ANCIENT_LIGHT_COBBLESTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(0.75f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> LIGHT_COBBLESTONE_SLAB = registerBlock("light_cobblestone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(0.75f).sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> LIGHT_STONE_PRESSURE_PLATE = registerBlock("light_stone_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.of().strength(0.75f)
                    .sound(SoundType.STONE).requiresCorrectToolForDrops().noCollission()));
    public static final DeferredBlock<Block> LIGHT_STONE_BUTTON = registerBlock("light_stone_button",
            () -> new ButtonBlock(BlockSetType.STONE, 15, BlockBehaviour.Properties.of().strength(0.75f)
                    .sound(SoundType.STONE).requiresCorrectToolForDrops().noCollission()));

    public static final DeferredBlock<Block> ANTIMONY_ORE = registerBlock("antimony_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 6),BlockBehaviour.Properties.of()
                    .strength(1.4f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> ANTIMONY_BLOCK = registerBlock("antimony_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(1.5f).sound(SoundType.METAL).requiresCorrectToolForDrops()));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
