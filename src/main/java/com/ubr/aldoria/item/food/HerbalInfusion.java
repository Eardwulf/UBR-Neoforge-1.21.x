package com.ubr.aldoria.item.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import com.ubr.aldoria.init.ModItems;

import java.util.function.Supplier;

public class HerbalInfusion extends Item {
    public HerbalInfusion(Properties properties, Supplier<CreativeModeTab> aldoriaApothecary) {
        super(properties);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        // Apply custom effects based on the type of herbal infusion consumed
        if (!level.isClientSide) {
            if (stack.is(ModItems.CHAMOMILE_TEA.get())) {
                entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0)); // 10 seconds regeneration
            } else if (stack.is(ModItems.GINGER_TEA.get())) {
                entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 0)); // 15 seconds speed
            } else if (stack.is(ModItems.MINT_INFUSION.get())) {
                entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300, 0)); // 15 seconds resistance
            } else if (stack.is(ModItems.LAVENDER_BREW.get())) {
                entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300, 0)); // 15 seconds strength
            } else if (stack.is(ModItems.ELDERFLOWER_CORDIAL.get())) {
                entity.addEffect(new MobEffectInstance(MobEffects.LUCK, 600, 0)); // 30 seconds luck
            } else if (stack.is(ModItems.ROSEMARY_TONIC.get())) {
                entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0)); // 20 seconds night vision
            } else if (stack.is(ModItems.THYME_INFUSION.get())) {
                entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 300, 0)); // 15 seconds slow falling
            } else if (stack.is(ModItems.HIBISCUS_COOLER.get())) {
                entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 400, 0)); // 20 seconds health boost
            } else if (stack.is(ModItems.BASIL_BREW.get())) {
                entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 300, 0)); // 15 seconds fire resistance
            } else if (stack.is(ModItems.SAGE_SERUM.get())) {
                entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 200, 0)); // 10 seconds invisibility
            } else if (stack.is(ModItems.CILANTRO_TINCTURE.get())) {
                entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 400, 0)); // 20 seconds water breathing
            } else if (stack.is(ModItems.LEMON_BALM_INFUSION.get())) {
                entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 300, 0)); // 15 seconds haste
            } else if (stack.is(ModItems.PARSLEY_POTION.get())) {
                entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 300, 1)); // 15 seconds absorption
            } else if (stack.is(ModItems.DANDELION_ELIXIR.get())) {
                entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 300, 1)); // 15 seconds jump boost
            }
        }
        return super.finishUsingItem(stack, level, entity);
    }

    public int getUseDuration(ItemStack stack) {
        return 32; // Duration of drinking animation
    }

    public ItemStack getContainerItem(ItemStack itemStack) {
        // Return an empty bottle after drinking the infusion
        return new ItemStack(net.minecraft.world.item.Items.GLASS_BOTTLE);
    }

    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }
}
