package net.bobo2020.timemachine.item;

import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties PURSLANE = new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 50), 0.75f).build();
}
