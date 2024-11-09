package com.ubr.aldoria.machines;

import com.ubr.aldoria.blockEntities.AlchemyFurnaceBlockEntity;
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

public class AlchemyFurnaceBlock extends Block {

    public AlchemyFurnaceBlock() {
        super(BlockBehaviour.Properties.ofFullCopy(Blocks.FURNACE));
    }

    public boolean hasBlockEntity(BlockState state) {
        return true;
    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new AlchemyFurnaceBlockEntity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, ModBlockEntities.ALCHEMY_FURNACE.get(), (BlockEntityTicker<? super T>) AlchemyFurnaceBlockEntity::tick);
    }

    // createTickerHelper method definition
    @Nullable
    protected static <T extends BlockEntity> BlockEntityTicker<T> createTickerHelper(BlockEntityType<T> providedType,
                                                                                     BlockEntityType<? extends BlockEntity> expectedType,
                                                                                     BlockEntityTicker<? super T> ticker) {
        return providedType == expectedType ? (BlockEntityTicker<T>) ticker : null;
    }
}
