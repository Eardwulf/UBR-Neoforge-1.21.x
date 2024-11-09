package com.ubr.aldoria.block;

import com.ubr.aldoria.init.ModContainers;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class MortarAndPestleContainer extends AbstractContainerMenu {
    private final MortarAndPestleBlockEntity blockEntity;
    private final ContainerLevelAccess access;

    // Container Slot IDs for referencing
    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;
    private static final int PLAYER_INVENTORY_START = 2;
    private static final int PLAYER_INVENTORY_END = PLAYER_INVENTORY_START + 27;
    private static final int PLAYER_HOTBAR_START = PLAYER_INVENTORY_END;
    private static final int PLAYER_HOTBAR_END = PLAYER_HOTBAR_START + 9;

    public MortarAndPestleContainer(int id, Inventory playerInventory, MortarAndPestleBlockEntity blockEntity) {
        super(ModContainers.MORTAR_AND_PESTLE_CONTAINER, id);
        this.blockEntity = blockEntity;
        this.access = ContainerLevelAccess.create(playerInventory.player.level(), BlockPos.ZERO); // Adjust BlockPos as needed

        // Add block slots (Input and Output)
        this.addSlot(new Slot((Container) blockEntity, INPUT_SLOT, 56, 35)); // Input slot position
        this.addSlot(new Slot((Container) blockEntity, OUTPUT_SLOT, 116, 35) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return false; // Output slot does not accept items for input
            }
        });

        // Add player inventory slots
        addPlayerInventory(playerInventory);
    }

    // Method to add player inventory slots
    private void addPlayerInventory(Inventory playerInventory) {
        // Player inventory
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }
        // Hotbar slots
        for (int col = 0; col < 9; ++col) {
            this.addSlot(new Slot(playerInventory, col, 8 + col * 18, 142));
        }
    }

    @Override
    public boolean stillValid(Player player) {
        return this.blockEntity != null && this.blockEntity.stillValid(player);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot != null && slot.hasItem()) {
            ItemStack currentItem = slot.getItem();
            itemstack = currentItem.copy();

            if (index == OUTPUT_SLOT) {  // Move item from output slot to player inventory
                if (!this.moveItemStackTo(currentItem, PLAYER_INVENTORY_START, PLAYER_HOTBAR_END, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onQuickCraft(currentItem, itemstack);
            } else if (index != INPUT_SLOT) {  // Move item from player inventory to input slot
                if (!this.moveItemStackTo(currentItem, INPUT_SLOT, OUTPUT_SLOT + 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(currentItem, PLAYER_INVENTORY_START, PLAYER_HOTBAR_END, false)) {
                return ItemStack.EMPTY;
            }

            if (currentItem.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemstack;
    }
}
