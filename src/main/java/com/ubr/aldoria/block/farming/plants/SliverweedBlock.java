package com.ubr.aldoria.block.farming.plants;

import com.ubr.aldoria.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.storage.loot.LootContext;

import java.util.List;

public class SliverweedBlock extends FlowerBlock {
    public SliverweedBlock(Properties properties) {

        super(MobEffects.HEAL, 100, properties); // Call the superclass constructor
    }

    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        return List.of(new ItemStack(ModItems.BASILISK_ROOT.get())); // Drop Basilisk Root item
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        // Grows in caves or dark areas
        return level.getMaxLocalRawBrightness(pos) < 8; // Allow growth in low light
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
    }
}
