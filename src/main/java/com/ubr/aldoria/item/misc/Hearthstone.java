package com.ubr.aldoria.item.misc;

import com.ubr.aldoria.util.PlayerData;
import com.ubr.aldoria.util.PlayerDataManager;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class Hearthstone extends Item {

    private static final int COOLDOWN_TIME = 20 * 60; // 1 hour in ticks (20 ticks = 1 second)
    private long lastTeleportTime;

    public Hearthstone(Properties properties) {
        super(properties);
        this.lastTeleportTime = 0; // Set initial cooldown time
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand); // Get the current item stack

        if (!level.isClientSide) {
            long currentTime = level.getGameTime();
            if (currentTime - lastTeleportTime >= COOLDOWN_TIME) {
                if (player instanceof ServerPlayer) {
                    PlayerData data = PlayerDataManager.getPlayerData((ServerPlayer) player);
                    if (data.hasHomePoint()) {
                        player.teleportTo(data.getHomeX(), data.getHomeY(), data.getHomeZ());
                        lastTeleportTime = currentTime; // Reset cooldown
                        player.sendSystemMessage(Component.translatable("item.aldoriacm.hearthstone.teleport"));
                        return InteractionResultHolder.success(itemStack); // Return the item stack after successful teleport
                    } else {
                        player.sendSystemMessage(Component.translatable("item.aldoriacm.hearthstone.no_home"));
                    }
                }
            } else {
                player.sendSystemMessage(Component.translatable("item.aldoriacm.hearthstone.cooldown"));
            }
        }
        return InteractionResultHolder.pass(itemStack); // Pass if no action taken
    }

}

