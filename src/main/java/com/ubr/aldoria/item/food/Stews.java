package com.ubr.aldoria.item.food;

import com.ubr.aldoria.init.ModItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.function.Supplier;

public class Stews extends Item {
    public Stews(Properties properties, Supplier<CreativeModeTab> aldoriaFoods) {
        super(properties);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.EAT;
    }

    public ItemStack finishUsingItem(ItemStack stack, Level level, Player player) {
        // Apply custom effects based on the type of herbal infusion consumed
        if (!level.isClientSide) {
            if (stack.getItem() == ModItems.SUNCHOKE_STEW.get()) {
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0));
            } else if (stack.getItem() == ModItems.MISO_PEA_STEW.get()) {
                player.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 200, 0));
            } else if (stack.getItem() == ModItems.SPICY_RADISH_STEW.get()) {
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 0));
            } else if (stack.getItem() == ModItems.GOLDEN_CORN_CHOWDER.get()) {
                player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0));
            } else if (stack.getItem() == ModItems.CABBAGE_SOUP.get()) {
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 0));
            }
        }
        return super.finishUsingItem(stack, level, player);
    }

    public int getUseDuration(ItemStack stack) {
        return 32; // Duration of drinking animation
    }

    public ItemStack getContainerItem(ItemStack itemStack) {
        // Return an empty bottle after drinking the infusion
        return new ItemStack(Items.BOWL);
    }

    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }
}
