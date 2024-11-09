package com.ubr.aldoria.item.pouches;

import net.minecraft.network.protocol.game.ClientboundOpenScreenPacket;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.function.Supplier;

public class PouchItem extends Item {
    public PouchItem(Properties properties, Supplier<CreativeModeTab> aldoriaPouches) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (!level.isClientSide && player instanceof ServerPlayer serverPlayer) {
            openPouchGui(serverPlayer, itemStack);
        }
        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide);
    }

    private void openPouchGui(ServerPlayer player, ItemStack stack) {
        MenuProvider containerProvider = new SimpleMenuProvider(
                (id, inventory, p) -> new PouchContainer(id, inventory, ContainerLevelAccess.create(player.level(), player.blockPosition()), stack),
                Component.translatable("container.aldoria.pouch")
        );

        int containerId = player.getStingerCount();
        player.connection.send(new ClientboundOpenScreenPacket(containerId, MenuType.GENERIC_9x3, containerProvider.getDisplayName()));

        // Call player's openMenu method to bind the container to the player
        player.openMenu(containerProvider);
    }
}

