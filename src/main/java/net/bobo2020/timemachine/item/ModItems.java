package net.bobo2020.timemachine.item;

import net.bobo2020.timemachine.TimeMachine;
import net.bobo2020.timemachine.item.custom.FuelItem;
import net.bobo2020.timemachine.item.custom.ShardItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TimeMachine.MOD_ID);

    // Ancient Era (Items)
        // Default Items
    public static final DeferredItem<Item> STONE_SHARD_LIGHT =
            ITEMS.registerItem("stone_shard_light", properties -> new ShardItem(properties, "light"),
                    new Item.Properties());

    public static final DeferredItem<Item> RAW_ANTIMONY = ITEMS.registerSimpleItem("raw_antimony");
    public static final DeferredItem<Item> ANTIMONY_INGOT = ITEMS.registerSimpleItem("antimony_ingot");

    public static final DeferredItem<Item> PURSLANE =
            ITEMS.registerItem("purslane", Item::new, new Item.Properties().food(ModFoodProperties.PURSLANE));

    public static final DeferredItem<Item> MOSSY_PEAT =
            ITEMS.registerItem("mossy_peat", properties -> new FuelItem(properties, 400),
                    new Item.Properties());

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
