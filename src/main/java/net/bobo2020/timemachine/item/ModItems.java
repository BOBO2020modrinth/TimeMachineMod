package net.bobo2020.timemachine.item;

import net.bobo2020.timemachine.TimeMachine;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TimeMachine.MOD_ID);

    // Ancient Era (Items)
        // Default Items
    public static final DeferredItem<Item> STONE_SHARD_LIGHT = ITEMS.registerSimpleItem("stone_shard_light");

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
