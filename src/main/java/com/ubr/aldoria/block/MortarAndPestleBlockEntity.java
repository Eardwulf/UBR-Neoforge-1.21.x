package com.ubr.aldoria.block;

import com.ubr.aldoria.init.ModBlockEntities;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;

public class MortarAndPestleBlockEntity extends BlockEntity {
    private ItemStack inputItem = ItemStack.EMPTY;
    private ItemStack outputItem = ItemStack.EMPTY;

    public MortarAndPestleBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.MORTAL_AND_PESTLE.get(), pos, state);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, MortarAndPestleBlockEntity entity) {
        // Add logic for grinding items, transforming inputItem to outputItem
    }

    public boolean stillValid(Player player) {
        return false;
    }

    // Methods for handling input and output, etc.
}
