package net.bobo2020.timemachine.item;

import net.bobo2020.timemachine.TimeMachine;
import net.bobo2020.timemachine.item.custom.*;
import net.minecraft.world.item.*;
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
    public static final DeferredItem<Item> LIGHT_STICK =
            ITEMS.registerItem("light_stick", Item::new, new Item.Properties());

    public static final DeferredItem<Item> LIGHT_PICKAXE = ITEMS.register("light_pickaxe",
            () -> new PickaxeItem(ModToolTiers.LIGHT_STONE,
                    new Item.Properties().attributes(PickaxeItem
                            .createAttributes(ModToolTiers.LIGHT_STONE, 1.25f, -2.0f))));
    public static final DeferredItem<Item> LIGHT_AXE = ITEMS.register("light_axe",
            () -> new AxeItem(ModToolTiers.LIGHT_STONE,
                    new Item.Properties().attributes(AxeItem
                            .createAttributes(ModToolTiers.LIGHT_STONE, 6.0f, -2.2f))));
    public static final DeferredItem<Item> LIGHT_SHOVEL = ITEMS.register("light_shovel",
            () -> new ShovelItem(ModToolTiers.LIGHT_STONE,
                    new Item.Properties().attributes(ShovelItem
                            .createAttributes(ModToolTiers.LIGHT_STONE, 1.75f, -2.0f))));
    public static final DeferredItem<Item> LIGHT_HOE = ITEMS.register("light_hoe",
            () -> new HoeItem(ModToolTiers.LIGHT_STONE,
                    new Item.Properties().attributes(HoeItem
                            .createAttributes(ModToolTiers.LIGHT_STONE, 0.75f, -2.0f))));
    public static final DeferredItem<Item> LIGHT_SWORD = ITEMS.register("light_sword",
            () -> new SwordItem(ModToolTiers.LIGHT_STONE,
                    new Item.Properties().attributes(SwordItem
                            .createAttributes(ModToolTiers.LIGHT_STONE, 3, -2.0f))));

    public static final DeferredItem<Item> LIGHT_PAXEL = ITEMS.register("light_paxel",
            () -> new PaxelItem(ModToolTiers.LIGHT_STONE,
                    new Item.Properties().attributes(PickaxeItem
                            .createAttributes(ModToolTiers.LIGHT_STONE, 2.75f, -2.0f))));
    public static final DeferredItem<Item> LIGHT_HAMMER = ITEMS.register("light_hammer",
            () -> new SwitchableHammerItem(ModToolTiers.LIGHT_STONE,
                    new Item.Properties().attributes(PickaxeItem
                            .createAttributes(ModToolTiers.LIGHT_STONE, 4.5f, -2.2f))
                            .durability(360)));
    public static final DeferredItem<Item> LIGHT_COMPLEX_HAMMER = ITEMS.register("light_complex_hammer",
            () -> new ComplexHammerItem(ModToolTiers.LIGHT_STONE,
                    new Item.Properties().attributes(PickaxeItem
                                    .createAttributes(ModToolTiers.LIGHT_STONE, 8.0f, -2.6f))
                            .durability(1080)));


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
