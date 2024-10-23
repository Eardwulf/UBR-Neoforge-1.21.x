package com.ubr.aldoria.init;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModTiers {
    // Orichalcum Tier (better than Netherite)
    public static final Tier ORICHALCUM = new SimpleTier(
            ModTags.Blocks.INCORRECT_FOR_ORICHALCUM_TOOL,
            2500,  // Durability
            10.0f, // Mining speed
            4.0f,  // Attack damage
            20,    // Enchantment value
            () -> Ingredient.of(ModItems.ORICHALCUM_INGOT)  // Repair ingredient
    );

    // Titanite Tier (more damage)
    public static final Tier TITANITE = new SimpleTier(
            ModTags.Blocks.INCORRECT_FOR_TITANITE_TOOL,
            1800,  // Durability
            7.0f,  // Mining speed
            5.0f,  // Attack damage (higher than Diamond)
            12,    // Enchantment value
            () -> Ingredient.of(ModItems.TITANITE_SHARD)  // Repair ingredient
    );

    // Moonstone Tier
    public static final Tier MOONSTONE = new SimpleTier(
            ModTags.Blocks.INCORRECT_FOR_MOONSTONE_TOOL,
            1600,  // Durability
            6.0f,  // Mining speed
            2.5f,  // Attack damage
            10,    // Enchantment value
            () -> Ingredient.of(ModItems.MOONSTONE_DUST)  // Repair ingredient
    );

    // Sunstone Tier
    public static final Tier SUNSTONE = new SimpleTier(
            ModTags.Blocks.INCORRECT_FOR_SUNSTONE_TOOL,
            1700,  // Durability
            5.5f,  // Mining speed
            2.0f,  // Attack damage
            11,    // Enchantment value
            () -> Ingredient.of(ModItems.SUNSTONE_INGOT)  // Repair ingredient
    );

    // Cryolite Tier
    public static final Tier CRYOLITE = new SimpleTier(
            ModTags.Blocks.INCORRECT_FOR_CRYOLITE_TOOL,
            1500,  // Durability
            6.5f,  // Mining speed
            3.0f,  // Attack damage
            9,     // Enchantment value
            () -> Ingredient.of(ModItems.CRYOLITE_INGOT)  // Repair ingredient
    );

    // Electrum Tier (high enchantment value)
    public static final Tier ELECTRUM = new SimpleTier(
            ModTags.Blocks.INCORRECT_FOR_ELECTRUM_TOOL,
            1400,  // Durability
            6.0f,  // Mining speed
            3.0f,  // Attack damage
            25,    // High enchantment value
            () -> Ingredient.of(ModItems.ELECTRUM_INGOT)  // Repair ingredient
    );
}
