package com.ubr.aldoria.container;

import com.ubr.aldoria.blockEntities.AlchemyFurnaceBlockEntity;
import com.ubr.aldoria.init.ModBlocks;
import com.ubr.aldoria.init.ModContainers;
import com.ubr.aldoria.init.ModItems;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.FurnaceResultSlot;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.ContainerLevelAccess;

public class AlchemyFurnaceContainer extends AbstractContainerMenu {
    private final AlchemyFurnaceBlockEntity blockEntity;
    private final ContainerLevelAccess access;

    // Slot indexes for input, fuel, and output
    private static final int INPUT_SLOT = 0;
    private static final int FUEL_SLOT = 1;
    private static final int OUTPUT_SLOT = 2;

    public AlchemyFurnaceContainer(int id, Inventory playerInventory, AlchemyFurnaceBlockEntity blockEntity) {
        super(ModContainers.ALCHEMY_FURNACE_CONTAINER, id);
        this.blockEntity = blockEntity;
        this.access = ContainerLevelAccess.create(playerInventory.player.level(), blockEntity.getBlockPos());

        // Add Alchemy Furnace slots
        this.addSlot(new Slot((Container) blockEntity, INPUT_SLOT, 56, 17)); // Input Slot
        this.addSlot(new Slot((Container) blockEntity, FUEL_SLOT, 56, 53) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return stack.is(ModItems.ESSENCE_EXTRACTOR.get()); // Only allow Essence Extractor as fuel
            }
        });
        this.addSlot(new FurnaceResultSlot(playerInventory.player, (Container) blockEntity, OUTPUT_SLOT, 116, 35));

        // Add player inventory slots
        addPlayerInventory(playerInventory);
    }

    private void addPlayerInventory(Inventory playerInventory) {
        // Player inventory slots
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
        return access.evaluate((world, pos) -> world.getBlockState(pos).getBlock() == ModBlocks.ALCHEMY_FURNACE.get(), true);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot != null && slot.hasItem()) {
            ItemStack currentItem = slot.getItem();
            itemstack = currentItem.copy();

            if (index == OUTPUT_SLOT) {
                if (!this.moveItemStackTo(currentItem, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onQuickCraft(currentItem, itemstack);
            } else if (index != FUEL_SLOT) {
                if (currentItem.is(ModItems.ESSENCE_EXTRACTOR.get())) {
                    if (!this.moveItemStackTo(currentItem, FUEL_SLOT, FUEL_SLOT + 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (index < 30) {
                    if (!this.moveItemStackTo(currentItem, 30, 39, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (!this.moveItemStackTo(currentItem, 3, 30, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(currentItem, 3, 39, false)) {
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

    // Method to check if the furnace is crafting
    public boolean isCrafting() {
        return blockEntity.getCraftingTime() > 0; // Check if there's active crafting
    }

    // Method to get burn progress for the progress bar
    public int getBurnProgress() {
        int craftingTime = blockEntity.getCraftingTime();
        int maxCraftingTime = blockEntity.getMaxCraftingTime();
        return maxCraftingTime != 0 && craftingTime > 0 ? craftingTime * 24 / maxCraftingTime : 0;
    }

    // Method to check if the furnace is burning fuel
    public boolean isBurning() {
        return blockEntity.getBurnTime() > 0; // Checks if there's fuel currently burning
    }

    // Method to get the fuel progress for the fuel bar
    public int getFuelProgress() {
        int burnTime = blockEntity.getBurnTime();
        int maxBurnTime = blockEntity.getMaxBurnTime();
        return maxBurnTime != 0 && burnTime > 0 ? burnTime * 13 / maxBurnTime : 0;
    }
}
