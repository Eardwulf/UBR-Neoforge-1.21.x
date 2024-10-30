package com.ubr.aldoria.block.farming;

import com.ubr.aldoria.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.MapColor;

import java.util.Random;

public class MysticBerryCropBlock extends CropBlock {
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 7);

    public MysticBerryCropBlock() {
        super(Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak());
        this.registerDefaultState(this.stateDefinition.any().setValue(this.getAgeProperty(), 0));
    }

    @Override
    protected Item getBaseSeedId() {
        return ModItems.MYSTIC_BERRY_SEEDS.get();
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return 7; // Maximum age for the crop
    }

    @Override
    public int getAge(BlockState state) {
        return state.getValue(AGE);
    }


    @Override
    public BlockState getStateForAge(int age) {
        return this.defaultBlockState().setValue(this.getAgeProperty(), age);
    }

    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
        if (!world.isAreaLoaded(pos, 1)) return; // Avoid loading unloaded chunks
        if (world.getRawBrightness(pos, 0) >= 9 && random.nextInt(5) == 0) { // Growth chance
            this.growCrops(world, pos, state);
        }
    }
}
