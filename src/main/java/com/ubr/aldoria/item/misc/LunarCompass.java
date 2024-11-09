package com.ubr.aldoria.item.misc;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component; // Import for Component

import java.util.function.Supplier;


public class LunarCompass extends Item {
    public LunarCompass(Properties properties, Supplier<CreativeModeTab> aldoriaItems) {
        super(new Item.Properties()
                .stacksTo(1) // Limit to 1 item per slot
                .durability(100)); // Set durability, adjust as needed
    }

    public ItemStack use(ItemStack stack, Level world, Player player) {
        // Check if it's nighttime
        if (world.isNight()) {
            // Get the player's bed position
            BlockPos bedPos = player.getSleepingPos().orElse(null);
            if (bedPos != null) {
                // Get the position of the bed
                Component bedLocation = Component.literal("The Lunar Compass points to your bed at " + bedPos);
                player.sendSystemMessage(bedLocation); // Use Component instead of String
            } else {
                player.sendSystemMessage(Component.literal("You have not slept in a bed!")); // Use Component instead of String
            }
        } else {
            player.sendSystemMessage(Component.literal("The Lunar Compass only works at night.")); // Use Component instead of String
        }

        return stack; // Returning the ItemStack for further use
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.NONE; // No specific animation
    }

    public int getUseDuration(ItemStack stack) {
        return 0; // Duration of the item use, adjust as needed
    }
}
