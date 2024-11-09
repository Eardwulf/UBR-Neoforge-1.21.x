package com.ubr.aldoria.blockEntities;

import com.ubr.aldoria.init.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ElectrumFurnaceBlockEntity extends BlockEntity {
    private int storedEnergy = 0; // Energy storage
    private final int maxEnergy = 10000; // Max energy capacity

    public ElectrumFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ELECTRUM_FURNACE.get(), pos, state);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, ElectrumFurnaceBlockEntity entity) {
        if (!level.isClientSide) {
            // You can add logic to consume energy or perform tasks here
        }
    }

    public void receiveEnergy(int amount) {
        if (storedEnergy + amount <= maxEnergy) {
            storedEnergy += amount; // Add the received energy
        } else {
            storedEnergy = maxEnergy; // Cap at max energy
        }
    }

    public int extractEnergy(int amount) {
        if (storedEnergy >= amount) {
            storedEnergy -= amount;
            return amount; // Return the energy extracted
        }
        return 0; // Not enough energy
    }

    public int getStoredEnergy() {
        return storedEnergy;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public static <T extends BlockEntity> void tick(Level level, BlockPos blockPos, BlockState blockState, T t) {
        if (t instanceof ElectrumFurnaceBlockEntity furnace) {
            // Implement your ticking logic for the ElectrumFurnace here
            // For example, you might want to check if it has enough energy, or if it should process an item

            if (level instanceof ServerLevel serverLevel) {
                // Check if there's enough energy to perform an operation
                // Example logic (this needs to be customized to your needs):
                if (furnace.storedEnergy > 0) {
                    // Perform actions, like processing items, etc.
                    // Decrease energy as needed
                    furnace.storedEnergy--; // Example of consuming energy
                }
            }
        }
    }
}
