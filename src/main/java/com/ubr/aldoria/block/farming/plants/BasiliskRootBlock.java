package com.ubr.aldoria.block.farming.plants;

import com.ubr.aldoria.init.ModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;


import java.util.List;

public class BasiliskRootBlock extends Block {
    public BasiliskRootBlock(Properties properties) {
        super(properties);
    }

    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        return List.of(new ItemStack(ModItems.BASILISK_ROOT.get(), 1));
    }
}
