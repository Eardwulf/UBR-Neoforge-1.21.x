package com.ubr.aldoria.blockEntities;

import com.ubr.aldoria.init.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class DistillerBlockEntity extends BlockEntity {

    public DistillerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.DISTILLER.get(), pos, state);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, DistillerBlockEntity entity) {
        // Define ingredient refinement logic here
    }
}
