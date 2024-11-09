package com.ubr.aldoria.block.lamps;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LightLayer;
import net.minecraft.server.level.ServerLevel;

import static com.ubr.aldoria.block.lamps.OrichalcumLamp.LIT;

public class MoonstoneLamp extends LanternBlock {
    public MoonstoneLamp() {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(1.0F).lightLevel(state -> 15)); // 15 is the maximum light level
    }

    public void onPlace(BlockState state, ServerLevel world, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onPlace(state, world, pos, oldState, isMoving);
        updateLanternLighting(state, world, pos); // Update lighting when placed
    }

    private void updateLanternLighting(BlockState state, ServerLevel world, BlockPos pos) {
        // Check if it's night or if the light level is low
        if (world.isNight() || world.getBrightness(LightLayer.BLOCK, pos) < 5) {
            world.setBlock(pos, state.setValue(LIT, true), 3); // Set lantern to lit state
        } else {
            world.setBlock(pos, state.setValue(LIT, false), 3); // Set lantern to unlit state
        }
    }

    public void neighborChanged(BlockState state, ServerLevel world, BlockPos pos, Block neighborBlock, BlockPos neighborPos, boolean isMoving) {
        super.neighborChanged(state, world, pos, neighborBlock, neighborPos, isMoving);
        updateLanternLighting(state, world, pos); // Update lighting when neighbors change
    }
}
