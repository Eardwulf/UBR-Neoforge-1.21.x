package com.ubr.aldoria.machines;

import com.ubr.aldoria.blockEntities.ElectrumConductorBlockEntity;
import com.ubr.aldoria.blockEntities.ElectrumFurnaceBlockEntity;
import com.ubr.aldoria.blockEntities.SolarChargerBlockEntity;
import com.ubr.aldoria.init.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

public class ElectrumConductor extends Block {
    private int storedEnergy; // Store energy in the conductor
    private static int maxEnergy = 550000; // Max energy storage capacity

    public ElectrumConductor(Properties properties) {
        super(properties.mapColor(MapColor.GOLD).strength(0.5F));
        this.maxEnergy = maxEnergy;
        this.storedEnergy = 0;
    }

    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ElectrumConductorBlockEntity(pos, state);
    }

    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, ModBlockEntities.ELECTRUM_CONDUCTOR.get(), (BlockEntityTicker<? super T>) ElectrumConductorBlockEntity::tick);
    }

    // Helper method to create the ticker
    private static <T extends BlockEntity> BlockEntityTicker<T> createTickerHelper(BlockEntityType<T> type, BlockEntityType<ElectrumConductorBlockEntity> typeFor, BlockEntityTicker<? super T> ticker) {
        return type == typeFor ? (BlockEntityTicker<T>) ticker : null;
    }

    public void transferEnergy(Level level, BlockPos pos) {
        // Logic to distribute energy to connected machines
        for (Direction direction : Direction.values()) {
            BlockPos neighborPos = pos.relative(direction);
            BlockEntity neighborEntity = level.getBlockEntity(neighborPos);

            if (neighborEntity instanceof SolarChargerBlockEntity solarCharger) {
                solarCharger.receiveEnergy(storedEnergy); // Transfer energy to SolarCharger
                storedEnergy = 0; // Optionally reset stored energy after transfer
            } else if (neighborEntity instanceof ElectrumFurnaceBlockEntity furnace) {
                furnace.receiveEnergy(storedEnergy); // Transfer energy to ElectrumFurnace
                storedEnergy = 0; // Optionally reset stored energy after transfer
            }
        }
    }

    public int extractEnergy(int amount) {
        // Logic to extract energy from the conductor
        if (storedEnergy >= amount) {
            storedEnergy -= amount;
            return amount;
        }
        return 0; // Not enough energy
    }

    public void receiveEnergy(int amount) {
        // Logic to add energy to the conductor
        if (storedEnergy + amount <= maxEnergy) {
            storedEnergy += amount;
        } else {
            storedEnergy = maxEnergy; // Cap at max energy
        }
    }
}
