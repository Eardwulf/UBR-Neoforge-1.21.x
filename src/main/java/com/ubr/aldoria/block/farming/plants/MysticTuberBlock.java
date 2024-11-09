package com.ubr.aldoria.block.farming.plants;

import com.ubr.aldoria.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

import java.util.List;

public class MysticTuberBlock extends Block {
    public MysticTuberBlock(Properties properties) {
        super(properties); // Call the superclass constructor
    }

    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        return List.of(new ItemStack(ModItems.MYSTIC_TUBER.get())); // Drop Mystic Tuber item
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        // Implement logic to check if the block can survive in mystical biomes
        return true; // Replace with your biome condition as needed
    }

    public void onBlockUsed(Level level, BlockPos pos, Player player, ItemStack itemStack) {
        // Allow the player to eat the Mystic Tuber
        if (!level.isClientSide) {
            // Grant the player invisibility for 15 seconds (300 ticks)
            player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 300, 0));

            // Optionally, consume the food item
            player.getFoodData().eat(4, 0.5F); // Example: 4 nutrition and 0.5 saturation

            // Optionally, you can remove the block after eating
            level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3); // Remove the block
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
    }
}
