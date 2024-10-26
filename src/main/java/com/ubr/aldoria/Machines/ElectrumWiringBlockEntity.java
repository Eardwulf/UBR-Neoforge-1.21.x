package com.ubr.aldoria.Machines;

import com.ubr.aldoria.init.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ElectrumWiringBlockEntity extends BlockEntity {
    private int energy; // Energy stored in the wiring
    private final int maxEnergy = 1000; // Max energy capacity for the wiring

    public ElectrumWiringBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ELECTRUM_WIRING.get(), pos, state);
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = Math.min(energy, maxEnergy); // Cap energy at maxEnergy
    }

    public void addEnergy(int amount) {
        setEnergy(this.energy + amount);
    }

    public int extractEnergy(int amount) {
        if (energy >= amount) {
            energy -= amount;
            return amount; // Return the energy extracted
        }
        return 0; // Not enough energy
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    // You can add additional methods for functionality, such as energy transfer or connection checks
}
