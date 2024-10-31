package com.ubr.aldoria.item.pouches;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class PouchContainer extends ChestMenu {

    public static final MenuType<ChestMenu> POUCH_CONTAINER_TYPE = MenuType.GENERIC_9x3;

    public PouchContainer(int id, Inventory playerInventory) {
        super(POUCH_CONTAINER_TYPE, id, playerInventory, new SimpleContainer(27), 3); // Simple container with 27 slots
        customizeSlots();
    }

    public PouchContainer(int id, Inventory playerInventory, FriendlyByteBuf data) {
        this(id, playerInventory);
    }

    public PouchContainer(int id, Inventory playerInventory, ContainerLevelAccess containerLevelAccess, ItemStack stack) {
        super(POUCH_CONTAINER_TYPE, id, playerInventory, new SimpleContainer(27), 3);
        customizeSlots();
    }

    private void customizeSlots() {
        // Replace default slots with custom slots to enforce max stack size of 1000
        for (int i = 0; i < this.slots.size(); i++) {
            Slot oldSlot = this.slots.get(i);
            this.slots.set(i, new CustomSlot(oldSlot.container, oldSlot.getContainerSlot(), oldSlot.x, oldSlot.y));
        }
    }

    public boolean stillValid(Inventory playerInventory) {
        // Define if the container is still valid for interaction
        return true; // Modify as needed, currently always allows access
    }

    public ItemStack quickMoveStack(Inventory playerInventory, int index) {
        // Define logic for shift-clicking items into or out of the container
        ItemStack itemstack = ItemStack.EMPTY;
        ItemStack slotItemStack = this.slots.get(index).getItem();

        if (!slotItemStack.isEmpty()) {
            itemstack = slotItemStack.copy();
            if (index < this.slots.size()) {
                // Move item to the player's inventory if it's currently in the pouch
                if (!this.moveItemStackTo(slotItemStack, this.slots.size(), this.slots.size() + 36, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(slotItemStack, 0, this.slots.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (slotItemStack.isEmpty()) {
                this.slots.get(index).set(ItemStack.EMPTY);
            } else {
                this.slots.get(index).setChanged();
            }
        }

        return itemstack;
    }

    // Custom Slot class to allow maximum stack size of 1000 items
    public static class CustomSlot extends Slot {
        public CustomSlot(net.minecraft.world.Container container, int index, int x, int y) {
            super(container, index, x, y);
        }

        @Override
        public int getMaxStackSize() {
            return 1000; // Allow stack size up to 1000 items
        }
    }
}
