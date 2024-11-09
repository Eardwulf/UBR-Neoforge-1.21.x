package com.ubr.aldoria.block.farming.crops;

import com.ubr.aldoria.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootContext;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DragonfruitVineBlock extends CropBlock {
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 2); // Maximum age of 2
    public static final Random RANDOM = new Random();

    public DragonfruitVineBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }

    @Override
    protected Item getBaseSeedId() {
        return ModItems.DRAGONFRUIT_SEEDS.get(); // Define seeds in ModItems
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
            return List.of(new ItemStack(ModItems.DRAGONFRUIT.get(), 2 + RANDOM.nextInt(6))); // Drop dragonfruit
        }
        return Collections.emptyList(); // No drop if not mature
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        if (state.getValue(AGE) < getMaxAge()) {
            // Add your growth logic here (e.g., chance to grow)
            int growthChance = random.nextInt(10); // 10% chance to grow
            if (growthChance < 1) { // Adjust the chance as needed
                level.setBlock(pos, state.setValue(AGE, state.getValue(AGE) + 1), 2);
            }
        }
    }
}
