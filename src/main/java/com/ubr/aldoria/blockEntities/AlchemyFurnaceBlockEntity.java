package com.ubr.aldoria.blockEntities;

import com.ubr.aldoria.init.ModBlockEntities;
import com.ubr.aldoria.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.nbt.CompoundTag;

public class AlchemyFurnaceBlockEntity extends BlockEntity {

    private int craftingTime;      // Current crafting time
    private static final int MAX_CRAFTING_TIME = 200; // Maximum crafting time for one process

    private int burnTime;          // Remaining burn time of the current fuel
    private int maxBurnTime;       // Maximum burn time of the current fuel item

    public AlchemyFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ALCHEMY_FURNACE.get(), pos, state);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, AlchemyFurnaceBlockEntity entity) {
        boolean isBurning = entity.isBurning();

        // Check if the furnace is burning or needs fuel
        if (isBurning || !entity.getItemInSlot(1).isEmpty()) { // Slot 1 assumed for fuel
            if (!isBurning && entity.canStartBurning()) {
                entity.burnFuel();
            }

            if (entity.isBurning() && entity.canCraft()) {
                entity.craftingTime++;
                if (entity.craftingTime >= MAX_CRAFTING_TIME) {
                    entity.finishCrafting();
                }
            } else {
                entity.craftingTime = 0; // Reset crafting time if conditions aren't met
            }
        }

        // Decrement burn time if the furnace is burning
        if (entity.isBurning()) {
            entity.burnTime--;
        }
    }

    // Check if there’s an item to be crafted in the input slot and an empty output slot
    private boolean canCraft() {
        // Implement crafting conditions based on input and output slots
        return true;
    }

    // Finish crafting an item, consuming resources and moving results to the output slot
    private void finishCrafting() {
        // Implement crafting result logic here
        this.craftingTime = 0;
    }

    // Burn fuel if available and set `burnTime` and `maxBurnTime`
    private void burnFuel() {
        ItemStack fuel = this.getItemInSlot(1); // Assumes Slot 1 is the fuel slot
        if (fuel.is(ModItems.ESSENCE_EXTRACTOR.get())) {
            this.burnTime = 1600;  // Set burn time for Essence Extractor, adjust as needed
            this.maxBurnTime = this.burnTime;
            fuel.shrink(1);  // Consume one fuel item
        }
    }

    // Check if the furnace is currently burning
    public boolean isBurning() {
        return this.burnTime > 0;
    }

    // Check if there's enough fuel to start burning
    private boolean canStartBurning() {
        ItemStack fuel = this.getItemInSlot(1); // Assumes Slot 1 is the fuel slot
        return fuel.is(ModItems.ESSENCE_EXTRACTOR.get());
    }

    // Get the current crafting time
    public int getCraftingTime() {
        return this.craftingTime;
    }

    // Get the maximum crafting time for one process
    public int getMaxCraftingTime() {
        return MAX_CRAFTING_TIME;
    }

    // Get the remaining burn time for the current fuel
    public int getBurnTime() {
        return this.burnTime;
    }

    // Get the maximum burn time for the current fuel item
    public int getMaxBurnTime() {
        return this.maxBurnTime;
    }

    // Placeholder method for getting items from specific slots
    private ItemStack getItemInSlot(int slot) {
        // Implement this to return the item in the specified slot
        return ItemStack.EMPTY;
    }

    // Save entity data to NBT with SaveType
    protected void saveAdditional(CompoundTag tag, BlockEntityType saveType) {
        super.saveAdditional(tag, (HolderLookup.Provider) saveType);
        tag.putInt("CraftingTime", this.craftingTime);
        tag.putInt("BurnTime", this.burnTime);
        tag.putInt("MaxBurnTime", this.maxBurnTime);
    }

    // Load entity data from NBT
    public void load(CompoundTag tag) {
        super.onLoad();
        this.craftingTime = tag.getInt("CraftingTime");
        this.burnTime = tag.getInt("BurnTime");
        this.maxBurnTime = tag.getInt("MaxBurnTime");
    }
}
