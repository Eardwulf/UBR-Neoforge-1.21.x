package com.ubr.aldoria.block.farming.crops;

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

public class WhimsicalOnionCropBlock extends CropBlock {
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 2); // 0-2 for growth stages

    public WhimsicalOnionCropBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }

    @Override
    protected Item getBaseSeedId() {
        return ModItems.WHIMSICAL_ONION_SEEDS.get(); // Define seeds in ModItems
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return 2; // Maximum age for the crop
    }
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        int age = state.getValue(this.getAgeProperty());
        if (age >= this.getMaxAge()) {
            return List.of(new ItemStack(ModItems.WHIMSICAL_ONIONS.get(), 1)); // Drop Whimsical Onion
        }
        return Collections.emptyList(); // No drop if not mature
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}