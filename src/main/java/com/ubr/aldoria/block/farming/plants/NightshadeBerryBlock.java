package com.ubr.aldoria.block.farming.plants;

import com.ubr.aldoria.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.LevelReader;

import java.util.List;

public class NightshadeBerryBlock extends FlowerBlock {
    public NightshadeBerryBlock(Properties properties) {
        super(MobEffects.WEAKNESS, 100, properties); // Call the superclass constructor
    }

    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        return List.of(new ItemStack(ModItems.NIGHTSHADE_BERRY.get())); // Drop Nightshade Berry item
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        // Grows in dark areas
        return level.getMaxLightLevel() < 8; // Allow growth in low light
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
    }
}
