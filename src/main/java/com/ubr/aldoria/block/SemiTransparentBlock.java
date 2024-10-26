package com.ubr.aldoria.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class SemiTransparentBlock extends Block {
    public SemiTransparentBlock(Properties strength) {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ) // Use GLASS for transparency
                .strength(0.3F)
                .lightLevel(state -> 5)); // Optional: set a light level
    }
}
