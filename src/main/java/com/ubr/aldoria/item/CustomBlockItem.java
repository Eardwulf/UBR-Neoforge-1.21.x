package com.ubr.aldoria.item;

import net.minecraft.nbt.TextComponentTagVisitor;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.TooltipFlag;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class CustomBlockItem extends BlockItem {

    public CustomBlockItem(Block block, Properties properties, Supplier<CreativeModeTab> aldoriaSeeds) {
        super(block, properties);
    }

    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add((Component) new TextComponentTagVisitor("Place this custom block for special effects!"));
    }

    public InteractionResult place(BlockPlaceContext context) {
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();

        // Custom behavior before placing the block
        if (player != null && !world.isClientSide) {
            player.displayClientMessage((Component) new TextComponentTagVisitor("You placed a custom block!"), true);
        }

        // Calls the default place behavior
        return super.place(context);
    }
}
