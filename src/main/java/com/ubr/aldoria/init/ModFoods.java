package com.ubr.aldoria.init;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {

    public static final FoodProperties STARFRUIT = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(0.3f)
            .alwaysEdible()
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0f)
            .build();

    public static final FoodProperties MYSTIC_BERRY = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.2F)
            .build();

    public static final FoodProperties PUMPKIN_PEPPER = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(0.3F)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 0), 1.0F)
            .build();

    public static final FoodProperties HONEYDEW_MELON = new FoodProperties.Builder()
            .nutrition(5)
            .saturationModifier(0.4F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 0), 1.0F)
            .build();

    public static final FoodProperties RED_QUINOA = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.2F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 0), 1.0F)
            .build();

    public static final FoodProperties GOLDEN_CORN = new FoodProperties.Builder()
            .nutrition(6)
            .saturationModifier(0.5F)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 200, 0), 1.0F)
            .build();

    public static final FoodProperties SPICY_RADISH = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.4F)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0), 1.0F)
            .build();

    public static final FoodProperties CABBAGE = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.2F)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 200, 0), 1.0F)
            .build();

    public static final FoodProperties SUNCHOKE = new FoodProperties.Builder()
            .nutrition(5)
            .saturationModifier(0.4F)
            .effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 200, 0), 1.0F)
            .build();

    public static final FoodProperties CHILI_BEANS = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(0.3F)
            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 200, 0), 1.0F)
            .build();

    public static final FoodProperties MISO_PEAS = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(0.3F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 0), 1.0F)
            .build();

    public static final FoodProperties BLACKBERRIES = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.3F)
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 200, 0), 1.0F)
            .build();

    // New crop food items
    public static final FoodProperties AETHERIAL_RICE = new FoodProperties.Builder()
            .nutrition(2) // Adjust nutrition as needed
            .saturationModifier(0.1F) // Adjust saturation as needed
            .build();

    public static final FoodProperties DRAGONFRUIT = new FoodProperties.Builder()
            .nutrition(5)
            .saturationModifier(0.4F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 0), 1.0F) // Regeneration effect for 5 seconds
            .build();

    public static final FoodProperties SILVER_MILLET = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.3F)
            .build();

    public static final FoodProperties BLOOD_BERRIES = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.2F)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 200, 0), 1.0F) // Health Boost for 10 seconds
            .build();

    public static final FoodProperties FROST_BERRY = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.2F)
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 200, 0), 1.0F) // Slow Falling for 10 seconds
            .build();

    public static final FoodProperties LUMINOUS_LEEK = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.3F)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 200, 0), 1.0F) // Night Vision for 10 seconds
            .build();

    public static final FoodProperties MOON_TURNIP = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(0.3F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200, 0), 1.0F) // Regeneration for 10 seconds
            .build();

    public static final FoodProperties GHOST_CHILI_PEPPER = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.3F)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0), 1.0F) // Fire Resistance for 10 seconds
            .build();

    public static final FoodProperties TWILIGHT_GOURD = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(0.4F)
            .build();

    public static final FoodProperties DEWDROP_CUCUMBER = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.2F)
            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 200, 0), 1.0F) // Water Breathing for 10 seconds
            .build();

    public static final FoodProperties GOLDEN_QUINOA = new FoodProperties.Builder()
            .nutrition(5)
            .saturationModifier(0.4F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 0), 1.0F) // Strength for 10 seconds
            .build();

    public static final FoodProperties RAINBOW_BELL_PEPPER = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(0.3F)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 0), 1.0F) // Speed for 10 seconds
            .build();

    public static final FoodProperties CRYSTAL_TOMATO = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.3F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200, 0), 1.0F) // Regeneration for 10 seconds
            .build();

    public static final FoodProperties CHILLING_GARLIC = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.2F)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0), 1.0F) // Fire Resistance for 10 seconds
            .build();

    public static final FoodProperties WHIMSICAL_ONION = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.2F)
            .build();

    // Add more custom food items here as needed
}
