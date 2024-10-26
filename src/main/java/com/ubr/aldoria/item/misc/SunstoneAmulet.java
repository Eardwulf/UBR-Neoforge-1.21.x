package com.ubr.aldoria.item;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

public class SunstoneAmulet extends Item {
    public SunstoneAmulet(Properties properties) {
        super(properties);
    }

    public void onWearTick(ItemStack stack, Level level, LivingEntity entity) {
        if (entity instanceof Player player) {
            // Check if it's daytime
            if (level.isDay()) {
                // Apply fire resistance effect
                player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0, true, false));

                // Increase blast damage (this may depend on how your mod handles damage)
                // You might want to create a custom method or apply this effect in a different way
                applyBlastDamageBoost(player);
            } else {
                // Remove effects if it's not daytime
                player.removeEffect(MobEffects.FIRE_RESISTANCE);
            }
        }
    }

    private void applyBlastDamageBoost(Player player) {
        // Logic to increase player's blast damage
        // This might involve modifying attack damage or applying a custom effect
        // For example, you could add an effect that modifies damage values:
        player.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(player.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue() + 2.0);
    }
}
