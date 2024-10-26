package com.ubr.aldoria.Machines;

import com.ubr.aldoria.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class MysticProjector extends ButtonBlock {
    public static final BooleanProperty POWERED = BooleanProperty.create("powered");

    public MysticProjector(Properties strength) {
        super(BlockSetType.STONE, // Sound when pressed
                        30, // Duration the button stays pressed
                Properties.of()
                                .mapColor(MapColor.STONE) // Set properties for the button
                                .strength(2.0F)
                                .sound(SoundType.STONE)); // Set the block type
    }

    public InteractionResult use(Level level, BlockPos pos, Player player, InteractionHand hand) {
        if (!level.isClientSide) {
            spawnBridge(level, player.blockPosition().below()); // Spawn the bridge below the player
        }
        return InteractionResult.SUCCESS;
    }

    private void spawnBridge(Level level, BlockPos startPos) {
        // Check for a valid starting point (the position below the player)
        BlockPos pos = startPos;
        int width = 3; // Width of the bridge

        for (int i = 0; i < width; i++) {
            BlockPos bridgePos = pos.offset(i, 0, 0); // Extend to the right
            while (level.isEmptyBlock(bridgePos.below())) {
                // Set the semi-transparent block here
                level.setBlock(bridgePos.below(), ModBlocks.SEMI_TRANSPARENT_BLOCK.get().defaultBlockState(), 3);
                bridgePos = bridgePos.below(); // Move downwards
            }
        }
    }
}
