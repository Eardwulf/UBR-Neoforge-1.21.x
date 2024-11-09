package com.ubr.aldoria.blockEntities;

import com.ubr.aldoria.init.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SolarChargerBlockEntity extends BlockEntity {
    private int storedEnergy = 0; // Energy storage
    private final int maxEnergy = 10000; // Max energy capacity

    public SolarChargerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SOLAR_CHARGER.get(), pos, state);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, SolarChargerBlockEntity entity) {
        if (!level.isClientSide) {
            // Check for daylight to generate energy
            if (level.isDay() && entity.storedEnergy < entity.maxEnergy) {
                entity.storedEnergy += 100; // Generate energy
                if (entity.storedEnergy > entity.maxEnergy) {
                    entity.storedEnergy = entity.maxEnergy; // Cap energy
                }
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
