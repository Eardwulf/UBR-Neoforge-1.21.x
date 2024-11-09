package com.ubr.aldoria.machines;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ElectrumCapacitor extends Block {
    public ElectrumCapacitor(Properties properties) {
        super(properties);
    }

    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ElectrumCapacitorBlockEntity(pos, state);
    }
}
