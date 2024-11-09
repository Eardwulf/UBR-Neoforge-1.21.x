package com.ubr.aldoria.block.lamps;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;  // Import for Level
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.server.level.ServerLevel; // Import for ServerLevel
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.Random;

public class OrichalcumLamp extends Block {
    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    public OrichalcumLamp(Properties strength) {
        super(BlockBehaviour.Properties.of().lightLevel((state) -> state.getValue(LIT) ? 15 : 0));
    }

    @Override
    public void setPlacedBy(Level worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        if (!stack.getDisplayName().getString().isEmpty()) { // Check if the ItemStack has a custom name
            worldIn.setBlock(pos, state.setValue(LIT, true), 3); // Set to lit when placed
        }
    }

    @Override
    public void onPlace(BlockState state, Level worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (state.getValue(LIT)) {
            worldIn.scheduleTick(pos, this, 1);
        }
    }

    public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, Random random) {
        if (state.getValue(LIT)) {
            worldIn.setBlock(pos, state.setValue(LIT, false), 3); // Turn off after a tick
        }
    }

    @Override
    public void neighborChanged(BlockState state, Level worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        // Check if the lamp should be lit based on the redstone signal
        if (worldIn.getBestNeighborSignal(pos) > 0) {
            worldIn.setBlock(pos, state.setValue(LIT, true), 3); // Turn on the lamp
        } else {
            worldIn.setBlock(pos, state.setValue(LIT, false), 3); // Turn off the lamp
        }
    }

    @Override
    public boolean isSignalSource(BlockState state) {
        return true; // Make the lamp a signal source if needed
    }
}
