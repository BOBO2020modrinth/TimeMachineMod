package net.bobo2020.timemachine.component;

import net.bobo2020.timemachine.TimeMachine;
import net.minecraft.core.component.DataComponentType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPE =
            DeferredRegister.createDataComponents(TimeMachine.MOD_ID);

    private static <T>DeferredHolder<DataComponentType<?>,
            DataComponentType<T>> register(String name, UnaryOperator<DataComponentType.Builder<T>> buildOperator) {
        return DATA_COMPONENT_TYPE.register(name, () -> buildOperator.apply(DataComponentType.builder()).build());
    }

    public static void register(IEventBus eventBus) {
        DATA_COMPONENT_TYPE.register(eventBus);
    }
}
