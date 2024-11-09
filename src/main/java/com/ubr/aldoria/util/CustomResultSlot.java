package com.ubr.aldoria.util;


import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class CustomResultSlot extends Slot {

    public CustomResultSlot(Container inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return false; // Prevents items from being placed in the result slot
    }

    @Override
    public void onTake(Player player, ItemStack stack) {
        // Optional: Define what happens when the player takes the item from the slot
        super.onTake(player, stack);
    }
}
