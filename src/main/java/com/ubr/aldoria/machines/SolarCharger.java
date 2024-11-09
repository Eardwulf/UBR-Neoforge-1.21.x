package com.ubr.aldoria.machines;

import com.ubr.aldoria.blockEntities.SolarChargerBlockEntity;
import com.ubr.aldoria.init.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class SolarCharger extends Block {
    public SolarCharger(Properties properties) {
        super(properties);
    }

    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new SolarChargerBlockEntity(pos, state);
    }

    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        // Check if the block entity type matches the SolarChargerBlockEntity type
        if (blockEntityType == ModBlockEntities.SOLAR_CHARGER.get()) {
            return (BlockEntityTicker<T>) (BlockEntityTicker<SolarChargerBlockEntity>) SolarChargerBlockEntity::tick;
        }
        return null; // Return null for other types
    }

    // Helper method to create the ticker
    private static <T extends BlockEntity> BlockEntityTicker<T> createTickerHelper(BlockEntityType<T> type, BlockEntityType<? extends T> typeFor, BlockEntityTicker<? super T> ticker) {
        return type == typeFor ? (BlockEntityTicker<T>) ticker : null;
    }
}
