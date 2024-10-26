package com.ubr.aldoria.item.misc;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class AtherialQuartzAmulet extends Item {
    private boolean canSurvive = true; // Flag to check if the amulet can prevent death
    private long lastResetTime = 0; // Last reset time in milliseconds

    public AtherialQuartzAmulet(Properties properties) {
        super(properties);
    }

    public void inventoryTick(ItemStack stack, Level world, LivingEntity entity, int slotId, boolean isSelected) {
        // Check if a day has passed
        if (world.getGameTime() % 24000 == 0) { // 24000 ticks = 1 day
            resetImmunity();
        }

        // If the player is about to die, use the amulet's effect
        if (entity instanceof Player player) {
            if (!canSurvive) {
                // Implement the logic to allow the player to survive once
                player.setHealth(1.0F); // Set health to 1 instead of 0
                canSurvive = true; // Reset the immunity flag
                player.sendSystemMessage(Component.translatable("message.aldoria.atherial_quartz_amulet_used"));
            }
        }
    }

    public void resetImmunity() {
        canSurvive = true; // Allow the player to use the amulet again
        lastResetTime = System.currentTimeMillis(); // Update the reset time
        // Notify the player about the reset
        if (lastResetTime != 0) {
            // Logic to notify the player, possibly using player.sendSystemMessage
            // For example:
            System.out.println("Atherial Quartz Amulet has reset!"); // Replace with your notification logic
        }
    }

    public void useAmulet() {
        if (canSurvive) {
            canSurvive = false; // Use the amulet
            // Optionally, you can give the player a temporary effect
            // For example: player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 1));
        } else {
            // Notify the player that the amulet is not available yet
            System.out.println("The Atherial Quartz Amulet is still on cooldown!");
        }
    }
}
