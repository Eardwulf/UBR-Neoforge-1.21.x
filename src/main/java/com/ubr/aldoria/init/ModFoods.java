package com.ubr.aldoria.init;

import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {

    public static final FoodProperties STARFRUIT = new FoodProperties.Builder()
            .nutrition(4)          // Amount of hunger restored
            .saturationModifier(0.3f)   // Saturation modifier
            .alwaysEdible()           // Allows the player to eat even when not hungry
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0f) // Example effect
            .build();

    public static final FoodProperties MYSTIC_BERRY = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.2F)
            .build();

    public static final FoodProperties PUMPKIN_PEPPER = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(0.3F)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 0), 1.0F) // Speed effect for 10 seconds
            .build();

    public static final FoodProperties HONEYDEW_MELON = new FoodProperties.Builder()
            .nutrition(5)
            .saturationModifier(0.4F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 0), 1.0F) // Regeneration effect for 5 seconds
            .build();

    public static final FoodProperties RED_QUINOA = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.2F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 0), 1.0F) // Damage Resistance for 10 seconds
            .build();

    public static final FoodProperties GOLDEN_CORN = new FoodProperties.Builder()
            .nutrition(6)
            .saturationModifier(0.5F)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 200, 0), 1.0F) // Health Boost for 10 seconds
            .build();

    public static final FoodProperties SPICY_RADISH = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.4F)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0), 1.0F) // Fire Resistance for 10 seconds
            .build();

    public static final FoodProperties CABBAGE = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.2F)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 200, 0), 1.0F) // Night Vision for 10 seconds
            .build();

    public static final FoodProperties SUNCHOKE = new FoodProperties.Builder()
            .nutrition(5)
            .saturationModifier(0.4F)
            .effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 200, 0), 1.0F) // Invisibility for 10 seconds
            .build();

    public static final FoodProperties CHILI_BEANS = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(0.3F)
            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 200, 0), 1.0F) // Jump Boost for 10 seconds
            .build();

    public static final FoodProperties MISO_PEAS = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(0.3F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 0), 1.0F) // Strength for 10 seconds
            .build();

    public static final FoodProperties BLACKBERRIES = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.3F)
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 200, 0), 1.0F) // Slow Falling for 10 seconds
            .build();


    // Add more custom food items here as needed
}
