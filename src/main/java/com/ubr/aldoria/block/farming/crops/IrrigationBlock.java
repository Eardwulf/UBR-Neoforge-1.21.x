package com.ubr.aldoria.block.farming.crops;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.core.particles.ParticleTypes;

import java.util.Random;

public class IrrigationBlock extends Block {
    public static final BooleanProperty ACTIVE = BooleanProperty.create("active");
    private static final int RADIUS = 10; // Radius of effect

    public IrrigationBlock() {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(1.0F));
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        setActive(state, level, pos, true); // Activate and hydrate when placed
    }

    private void hydrateCrops(Level level, BlockPos pos) {
        for (int x = -RADIUS; x <= RADIUS; x++) {
            for (int z = -RADIUS; z <= RADIUS; z++) {
                if (x * x + z * z <= RADIUS * RADIUS) {
                    BlockPos neighborPos = pos.offset(x, 0, z);
                    BlockState neighborState = level.getBlockState(neighborPos);

                    // Hydrate farmland if within range
                    if (neighborState.getBlock() instanceof FarmBlock) {
                        if (neighborState.getValue(FarmBlock.MOISTURE) < 7) {
                            level.setBlock(neighborPos, neighborState.setValue(FarmBlock.MOISTURE, 7), 3);
                        }
                    }

                    // Optional: Additional crop hydration logic
                    if (neighborState.getBlock() instanceof CropBlock) {
                        // For example, increment crop growth stage if desired
                        // int currentAge = neighborState.getValue(CropBlock.AGE);
                        // if (currentAge < 7) {
                        //     level.setBlock(neighborPos, neighborState.setValue(CropBlock.AGE, currentAge + 1), 3);
                        // }
                    }
                }
            }
        }
    }

    public void setActive(BlockState state, Level level, BlockPos pos, boolean active) {
        level.setBlock(pos, state.setValue(ACTIVE, active), 3);
        if (active) {
            hydrateCrops(level, pos);
            spawnHaloEffect(level, pos); // Show halo effect above block when active
        }
    }

    private void spawnHaloEffect(Level level, BlockPos pos) {
        for (int i = 0; i < 5; i++) { // Number of particles to spawn for effect
            level.addParticle(ParticleTypes.HAPPY_VILLAGER,
                    pos.getX() + 0.5 + (level.random.nextDouble() - 0.5),
                    pos.getY() + 1.0,
                    pos.getZ() + 0.5 + (level.random.nextDouble() - 0.5),
                    0, 0, 0);
        }
    }

    public void tick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        if (state.getValue(ACTIVE)) {
            hydrateCrops(level, pos);
        }
    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true; // Redstone signal if needed
    }

    @Override
    public int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
        return state.getValue(ACTIVE) ? 15 : 0; // Full signal if active
    }
}
