package com.ubr.aldoria.machines;

import com.ubr.aldoria.blockEntities.EssenceCollectorBlockEntity;
import com.ubr.aldoria.init.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class EssenceCollectorBlock extends Block {

    public EssenceCollectorBlock() {
        super(BlockBehaviour.Properties.ofFullCopy(Blocks.ENCHANTING_TABLE));
    }

    public boolean hasBlockEntity(BlockState state) {
        return true;
    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new EssenceCollectorBlockEntity(pos, state);
    }

    @Nullable
    @SuppressWarnings("unchecked")
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        // Check if the type matches the EssenceCollectorBlockEntity's type
        if (type == ModBlockEntities.ESSENCE_COLLECTOR.get()) {
            return (BlockEntityTicker<T>) (BlockEntityTicker<EssenceCollectorBlockEntity>) EssenceCollectorBlockEntity::tick;
        }
        return null;
    }
}
