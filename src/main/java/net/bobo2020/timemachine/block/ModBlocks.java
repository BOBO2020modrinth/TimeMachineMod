package net.bobo2020.timemachine.block;

import net.bobo2020.timemachine.TimeMachine;
import net.bobo2020.timemachine.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
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

    public static final DeferredBlock<Block> ANTIMONY_ORE = registerBlock("antimony_ore",
            () -> new Block(BlockBehaviour.Properties.of().strength(1.4f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
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
