package com.ubr.aldoria.Machines;

import com.ubr.aldoria.Machines.ElectrumCapacitorBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class ElectrumCapacitor extends Block {
    public ElectrumCapacitor(Properties properties) {
        super(properties);
    }

    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ElectrumCapacitorBlockEntity(pos, state);
    }
}
