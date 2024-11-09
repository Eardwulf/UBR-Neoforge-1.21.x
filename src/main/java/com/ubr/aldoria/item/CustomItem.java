package com.ubr.aldoria.item;

import net.minecraft.nbt.TextComponentTagVisitor;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class CustomItem extends Item {

    public CustomItem(Properties properties, Supplier<CreativeModeTab> aldoriaItems) {
        super(properties);
    }

    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add((Component) new TextComponentTagVisitor("This is a custom item with special properties!"));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        // Example functionality: print a message to the player when right-clicking the item
        if (!world.isClientSide) {
            player.displayClientMessage((Component) new TextComponentTagVisitor("You used the custom item!"), true);
        }

        return new InteractionResultHolder<>(InteractionResult.SUCCESS, stack);
    }
}
