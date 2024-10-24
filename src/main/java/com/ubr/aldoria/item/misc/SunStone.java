package com.ubr.aldoria.item.misc;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class SunStone extends Item {
    public SunStone(Properties properties) {
        super(properties.stacksTo(16)); // Limit to 16 items per stack
    }

    public ItemStack use(ItemStack stack, Level world, Player player) {
        // Optionally, you can implement special use logic if desired
        player.sendSystemMessage(Component.literal("The Lunar Charm glows softly in your hand.")); // Optional feedback
        return stack;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.NONE; // No specific animation
    }

    public int getUseDuration(ItemStack stack) {
        return 0; // Duration of the item use, adjust as needed
    }
}
