package com.ubr.aldoria.Machines;

import com.ubr.aldoria.init.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.server.level.ServerLevel;

public class ElectrumCapacitorBlockEntity extends BlockEntity {
    private int storedEnergy = 0; // Current stored energy
    private final int maxEnergy = 100000; // Max energy capacity

    public ElectrumCapacitorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ELECTRUM_CAPACITOR.get(), pos, state);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, ElectrumCapacitorBlockEntity entity) {
        if (!level.isClientSide) {
            // Logic for charging from nearby solar sources
            chargeFromNearbySources(level, pos, entity);

            // Logic to distribute energy to nearby machines
            distributeEnergy(level, pos, entity);
        }
    }

    private static void chargeFromNearbySources(Level level, BlockPos pos, ElectrumCapacitorBlockEntity entity) {
        // Check adjacent blocks for energy sources
        for (Direction direction : Direction.values()) {
            BlockPos neighborPos = pos.relative(direction);
            BlockEntity neighborEntity = level.getBlockEntity(neighborPos);

            if (neighborEntity instanceof SolarChargerBlockEntity solarCharger) {
                // Charge the capacitor from the solar charger
                int energyToTransfer = solarCharger.getStoredEnergy(); // Get energy from the solar charger
                if (energyToTransfer > 0) {
                    entity.receiveEnergy(energyToTransfer);
                    solarCharger.extractEnergy(energyToTransfer); // Remove energy from solar charger
                }
            }
        }
    }

    private static void distributeEnergy(Level level, BlockPos pos, ElectrumCapacitorBlockEntity entity) {
        // Logic to distribute energy to connected machines
        int energyTransferAmount = 100; // Amount of energy to transfer

        for (Direction direction : Direction.values()) {
            BlockPos neighborPos = pos.relative(direction);
            BlockEntity neighborEntity = level.getBlockEntity(neighborPos);

            if (neighborEntity instanceof ElectrumFurnaceBlockEntity furnace) {
                // Transfer energy to ElectrumFurnace
                furnace.receiveEnergy(energyTransferAmount);
                entity.extractEnergy(energyTransferAmount); // Reduce energy in capacitor
            }
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
}
