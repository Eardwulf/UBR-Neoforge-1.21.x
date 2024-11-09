package com.ubr.aldoria.block.farming.plants;

import com.ubr.aldoria.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.LevelReader;

import java.util.List;

public class CoralrootBlock extends FlowerBlock {
    public CoralrootBlock(Properties properties) {
        super(MobEffects.DOLPHINS_GRACE, 200, properties); // Call the superclass constructor
    }

    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        return List.of(new ItemStack(ModItems.CORALROOT.get())); // Drop Coralroot item
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        // Ensure this grows underwater
        BlockPos belowPos = pos.below();
        return level.getBlockState(belowPos).is(Blocks.WATER); // Only allow growth underwater
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
    }
}
