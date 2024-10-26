package com.ubr.aldoria.Machines;

import com.ubr.aldoria.init.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ElectrumConductorBlockEntity extends BlockEntity {
    private int storedEnergy; // Energy storage
    private final int maxEnergy; // Maximum energy capacity

    public ElectrumConductorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ELECTRUM_CONDUCTOR.get(), pos, state);
        this.maxEnergy = 5000; // Define your maximum energy capacity here
        this.storedEnergy = 0; // Initialize stored energy to 0
    }

    public static void tick(Level level, BlockPos pos, BlockState state, ElectrumConductorBlockEntity entity) {
        if (level instanceof ServerLevel serverLevel) {
            // Call the instance method to transfer energy to connected machines
            entity.transferEnergy(serverLevel);
        }
    }

    public void transferEnergy(ServerLevel level) {
        // Logic to transfer energy to connected machines
        for (Direction direction : Direction.values()) {
            BlockPos neighborPos = worldPosition.relative(direction);
            BlockEntity neighborEntity = level.getBlockEntity(neighborPos);

            if (neighborEntity instanceof SolarChargerBlockEntity solarCharger) {
                int energyToTransfer = Math.min(storedEnergy, solarCharger.getMaxEnergy() - solarCharger.getStoredEnergy());
                if (energyToTransfer > 0) {
                    solarCharger.receiveEnergy(energyToTransfer);
                    storedEnergy -= energyToTransfer; // Deduct the transferred energy
                }
            } else if (neighborEntity instanceof ElectrumFurnaceBlockEntity furnace) {
                int energyToTransfer = Math.min(storedEnergy, furnace.getMaxEnergy() - furnace.getStoredEnergy());
                if (energyToTransfer > 0) {
                    furnace.receiveEnergy(energyToTransfer);
                    storedEnergy -= energyToTransfer; // Deduct the transferred energy
                }
            }
        }
    }

    public int getStoredEnergy() {
        return storedEnergy;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public void receiveEnergy(int amount) {
        if (storedEnergy + amount <= maxEnergy) {
            storedEnergy += amount; // Add energy
        } else {
            storedEnergy = maxEnergy; // Cap at max energy
        }
    }

    public int extractEnergy(int amount) {
        if (storedEnergy >= amount) {
            storedEnergy -= amount; // Deduct energy
            return amount; // Return extracted energy
        }
        return 0; // Not enough energy to extract
    }

    public static <T extends BlockEntity> void tick(Level level, BlockPos blockPos, BlockState blockState, T t) {
    }
}
