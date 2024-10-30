package com.ubr.aldoria.item.nature;


import com.ubr.aldoria.init.ModFoods;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MysticBerry extends Item {
    private static final List<Holder<MobEffect>> EFFECTS = Arrays.asList(
            MobEffects.MOVEMENT_SPEED,
            MobEffects.REGENERATION,
            MobEffects.DAMAGE_RESISTANCE,
            MobEffects.HEALTH_BOOST,
            MobEffects.FIRE_RESISTANCE
    );

    public MysticBerry() {
        super(new Item.Properties().food(ModFoods.MYSTIC_BERRY));
    }

    public ItemStack finishUsingItem(ItemStack stack, Level world, ServerPlayer player) {
        super.finishUsingItem(stack, world, player);
        applyRandomEffect(player);
        return stack;
    }

    private void applyRandomEffect(ServerPlayer player) {
        Random random = new Random();
        MobEffect randomEffect = (MobEffect) EFFECTS.get(random.nextInt(EFFECTS.size()));
        int duration = 100; // 5 seconds in ticks
        int amplifier = 0; // First level of effect

        // Apply the random effect to the player
        player.addEffect(new MobEffectInstance((Holder<MobEffect>) randomEffect, duration, amplifier));
    }
}
