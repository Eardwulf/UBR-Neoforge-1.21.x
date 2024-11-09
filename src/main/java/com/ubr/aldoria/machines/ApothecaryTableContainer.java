package com.ubr.aldoria.machines;

import com.ubr.aldoria.init.ModContainers;
import com.ubr.aldoria.util.CustomResultSlot;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.SimpleContainer;

import java.util.ArrayList;
import java.util.List;

public class ApothecaryTableContainer extends AbstractContainerMenu {

    private final SimpleContainer craftSlots = new SimpleContainer(9); // 3x3 crafting grid
    private final ResultContainer resultSlots = new ResultContainer();
    private final ContainerLevelAccess access;
    private final Player player;

    // Primary constructor with ContainerLevelAccess
    public ApothecaryTableContainer(int windowId, Inventory inventory, ContainerLevelAccess access) {
        super(ModContainers.APOTHECARY_TABLE_CONTAINER, windowId);
        this.access = access; // Use ContainerLevelAccess to track and validate access
        this.player = inventory.player;

        // Add the custom result slot
        this.addSlot(new CustomResultSlot(resultSlots, 0, 124, 35));

        // Setup crafting grid slots (3x3 grid)
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 3; ++col) {
                this.addSlot(new Slot(craftSlots, col + row * 3, 30 + col * 18, 17 + row * 18));
            }
        }

        // Player inventory slots (3 rows)
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(inventory, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }

        // Hotbar slots (1 row of 9 slots)
        for (int col = 0; col < 9; ++col) {
            this.addSlot(new Slot(inventory, col, 8 + col * 18, 142));
        }
    }

    // Factory method for creating the container from network data
    public static ApothecaryTableContainer fromNetwork(int windowId, Inventory playerInventory, FriendlyByteBuf buffer) {
        BlockPos pos = buffer.readBlockPos();
        ContainerLevelAccess access = ContainerLevelAccess.create(playerInventory.player.level(), pos);
        return new ApothecaryTableContainer(windowId, playerInventory, access);
    }

    @Override
    public boolean stillValid(Player player) {
        return access.evaluate((level, pos) -> player.distanceToSqr(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5) <= 64.0, true);
    }

    // Stack contents management for shift-click behavior
    public void fillStackedContents(StackedContents stackedContents) {
        for (int i = 0; i < craftSlots.getContainerSize(); i++) {
            stackedContents.accountSimpleStack(craftSlots.getItem(i));
        }
    }

    // Clear the container contents
    public void clearContent() {
        craftSlots.clearContent();
    }

    // Various inventory management methods
    public int getContainerSize() {
        return craftSlots.getContainerSize();
    }

    public boolean isEmpty() {
        return craftSlots.isEmpty();
    }

    public ItemStack getItem(int index) {
        return craftSlots.getItem(index);
    }

    public ItemStack removeItem(int index, int count) {
        return craftSlots.removeItem(index, count);
    }

    public ItemStack removeItemNoUpdate(int index) {
        return craftSlots.removeItemNoUpdate(index);
    }

    public void setItem(int index, ItemStack stack) {
        craftSlots.setItem(index, stack);
    }

    public void setChanged() {
        craftSlots.setChanged();
    }

    // Crafting grid dimensions
    public int getWidth() {
        return 3; // 3x3 crafting grid width
    }

    public int getHeight() {
        return 3; // 3x3 crafting grid height
    }

    // Retrieve items from the crafting grid
    public List<ItemStack> getCraftingGridItems() {
        List<ItemStack> items = new ArrayList<>();
        for (int i = 0; i < craftSlots.getContainerSize(); i++) {
            items.add(craftSlots.getItem(i));
        }
        return items;
    }

    // Handle shift-click item transfer between slots
    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (index == 0) {
                this.access.execute((level, pos) -> itemstack1.getItem().onCraftedBy(itemstack1, level, playerIn));
                if (!this.moveItemStackTo(itemstack1, 10, 46, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onQuickCraft(itemstack1, itemstack);
            } else if (index >= 10 && index < 46) {
                if (!this.moveItemStackTo(itemstack1, 1, 10, false)) {
                    if (index < 37) {
                        if (!this.moveItemStackTo(itemstack1, 37, 46, false)) {
                            return ItemStack.EMPTY;
                        }
                    } else if (!this.moveItemStackTo(itemstack1, 10, 37, false)) {
                        return ItemStack.EMPTY;
                    }
                }
            } else if (!this.moveItemStackTo(itemstack1, 10, 46, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(playerIn, itemstack1);
            if (index == 0) {
                playerIn.drop(itemstack1, false);
            }
        }

        return itemstack;
    }

    @Override
    public void removed(Player playerIn) {
        super.removed(playerIn);
        this.access.execute((level, pos) -> {
            this.clearContainer(playerIn, this.craftSlots);
        });
    }
}
