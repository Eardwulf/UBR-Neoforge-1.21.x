package com.ubr.aldoria.block;

import com.ubr.aldoria.init.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.MapColor;
import javax.annotation.Nullable;

public class MortarAndPestleBlock extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public MortarAndPestleBlock() {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(2.0f));
    }

    public boolean hasBlockEntity(BlockState state) {
        return true;
    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new MortarAndPestleBlockEntity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, ModBlockEntities.MORTAL_AND_PESTLE.get(), (BlockEntityTicker<? super T>) MortarAndPestleBlockEntity::tick);
    }

    // createTickerHelper method definition
    @Nullable
    protected static <T extends BlockEntity> BlockEntityTicker<T> createTickerHelper(BlockEntityType<T> providedType,
                                                                                     BlockEntityType<? extends BlockEntity> expectedType,
                                                                                     BlockEntityTicker<? super T> ticker) {
        return providedType == expectedType ? (BlockEntityTicker<T>) ticker : null;
    }
}
