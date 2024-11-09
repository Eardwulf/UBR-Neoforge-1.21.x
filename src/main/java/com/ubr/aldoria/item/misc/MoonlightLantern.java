package com.ubr.aldoria.item.misc;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component; // Import for Component
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Blocks;

import static com.ubr.aldoria.machines.OrichalcumLamp.LIT;

public class MoonlightLantern extends Item {
    public MoonlightLantern(Properties properties) {
        super(properties.stacksTo(1).durability(100)); // Set properties
    }

    public ItemStack use(ItemStack stack, Level world, Player player) {
        // Check if it's nighttime or low light
        if (world.isNight() || world.getBrightness(LightLayer.BLOCK, player.blockPosition()) < 5) {
            // Provide light effect logic here
            provideLightEffect(world, player.blockPosition());

            // Decrease durability
            if (stack.getDamageValue() < stack.getMaxDamage() - 1) {
                stack.setDamageValue(stack.getDamageValue() + 1); // Increment damage value to simulate durability loss
            } else {
                // Handle item breaking logic if needed
            }
        } else {
            player.sendSystemMessage(Component.literal("The Moonlight Lantern only works at night or in low light."));
        }

        return stack; // Return the ItemStack for further use
    }

    private void provideLightEffect(Level world, BlockPos pos) {
        // Logic to create a bright light effect at the player's position
        world.setBlock(pos, Blocks.LANTERN.defaultBlockState().setValue(LIT, true), 3);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.NONE; // No specific animation
    }

    public int getUseDuration(ItemStack stack) {
        return 0; // Duration of the item use, adjust as needed
    }
}
