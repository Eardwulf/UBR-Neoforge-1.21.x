package com.ubr.aldoria.block.farming;

import com.ubr.aldoria.init.ModItems;
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

public class MysticBerryCropBlock extends CropBlock {
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 7); // 8 growth stages
    public static final Random RANDOM = new Random();

    public MysticBerryCropBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }

    @Override
    protected Item getBaseSeedId() {
        return ModItems.MYSTIC_BERRY_SEEDS.get(); // Define seeds in ModItems
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

    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        int age = state.getValue(this.getAgeProperty());
        if (age >= this.getMaxAge()) {
            return List.of(new ItemStack(ModItems.MYSTIC_BERRY.get(), 1 + RANDOM.nextInt(2))); // Drop Starfruit
        }
        return Collections.emptyList(); // No drop if not mature
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
