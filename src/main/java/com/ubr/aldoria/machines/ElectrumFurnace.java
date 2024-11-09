package com.ubr.aldoria.machines;

import com.ubr.aldoria.blockEntities.ElectrumFurnaceBlockEntity;
import com.ubr.aldoria.blockEntities.ElectrumWiringBlockEntity;
import com.ubr.aldoria.init.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;

public class ElectrumFurnace extends Block {
    public ElectrumFurnace(Properties properties) {
        super(properties);
    }

    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ElectrumFurnaceBlockEntity(pos, state);
    }

    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        // Ensure the ticker is only assigned when the type matches ElectrumFurnaceBlockEntity
        return createTickerHelper(blockEntityType, (BlockEntityType<? extends T>) ModBlockEntities.ELECTRUM_FURNACE.get(), (BlockEntityTicker<T>) ElectrumFurnaceBlockEntity::tick);
    }

    // Helper method to create the ticker
    private static <T extends BlockEntity> BlockEntityTicker<T> createTickerHelper(BlockEntityType<T> type, BlockEntityType<? extends T> typeFor, BlockEntityTicker<? super T> ticker) {
        return type == typeFor ? (BlockEntityTicker<T>) ticker : null;
    }

    public void transferEnergy(Level level, BlockPos pos) {
        // Check for adjacent blocks in different directions
        for (Direction direction : Direction.values()) {
            BlockPos adjacentPos = pos.relative(direction);
            BlockEntity entity = level.getBlockEntity(adjacentPos);
            if (entity instanceof ElectrumWiringBlockEntity wiring) {
                int energyToTransfer = wiring.getEnergy(); // Get energy from wiring

                // Get the current block entity (ElectrumFurnace)
                BlockEntity furnace = level.getBlockEntity(pos);
                if (furnace instanceof ElectrumFurnaceBlockEntity electrumFurnace) {
                    electrumFurnace.receiveEnergy(energyToTransfer); // Transfer energy
                }
                break; // Exit loop after finding the first connected entity
            }
        }
    }
}
