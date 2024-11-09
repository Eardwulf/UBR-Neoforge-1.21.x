package com.ubr.aldoria.block.farming.crops;

import com.ubr.aldoria.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.LevelReader;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class AetherialRiceCropBlock extends CropBlock {
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 2); // Maximum age of 2
    public static final Random RANDOM = new Random();

    public AetherialRiceCropBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }

    @Override
    protected Item getBaseSeedId() {
        return ModItems.AETHEREAL_RICE_SEEDS.get(); // Define seeds in ModItems
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return 2; // Maximum age for the crop
    }

    @Override
    public int getAge(BlockState state) {
        return state.getValue(AGE);
    }

    @Override
    public BlockState getStateForAge(int age) {
        return this.defaultBlockState().setValue(this.getAgeProperty(), age);
    }

    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        int age = state.getValue(this.getAgeProperty());
        if (age >= this.getMaxAge()) {
            return List.of(new ItemStack(ModItems.AETHEREAL_RICE.get(), 2 + RANDOM.nextInt(4))); // Drop Aetherial Rice
        }
        return Collections.emptyList(); // No drop if not mature
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        // Check if there is water adjacent to the block and dirt below it
        BlockPos belowPos = pos.below();
        BlockState belowState = level.getBlockState(belowPos);
        BlockState waterState = level.getBlockState(pos.above());

        return (belowState.is(Blocks.DIRT) || belowState.is(Blocks.GRASS_BLOCK)) && waterState.is(Blocks.WATER);
    }
}
