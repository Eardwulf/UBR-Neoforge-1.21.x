package com.ubr.aldoria.block;

import com.ubr.aldoria.init.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Supplier;

public class TitaniteOre extends Block {
    public TitaniteOre(Properties strength, Supplier<CreativeModeTab> aldoriaBlocks) {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F));
    }

    public void playerWillDestroy(ServerLevel world, BlockPos pos, BlockState state, Player player) {
        super.playerWillDestroy(world, pos, state, player);

        // Get random source for generating random drops
        RandomSource rand = world.getRandom();

        // Drop 1-3 Titanite Shards
        int shardCount = rand.nextInt(3) + 1; // Drop 1 to 3 Titanite Dust
        for (int i = 0; i < shardCount; i++) {
            popResource(world, pos, new ItemStack(ModItems.TITANITE_DUST.get()));
        }

        // 50% chance to drop Shards
        if (rand.nextFloat() < 0.5f) {
            popResource(world, pos, new ItemStack(ModItems.TITANITE_SHARD.get()));
        }
    }
}
