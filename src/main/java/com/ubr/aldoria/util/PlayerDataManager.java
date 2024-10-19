package com.ubr.aldoria.util;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerDataManager {
    private static final Map<UUID, PlayerData> playerDataMap = new HashMap<>();

    public static PlayerData getPlayerData(ServerPlayer player) {
        return playerDataMap.computeIfAbsent(player.getUUID(), uuid -> new PlayerData());
    }

    public static void setHomePoint(ServerPlayer player, double x, double y, double z) {
        PlayerData data = getPlayerData(player);
        data.setHomePoint(x, y, z);
        player.sendSystemMessage(Component.translatable("item.aldoriacm.home.set"));
    }

    @SubscribeEvent
    public void onPlayerLogout(net.neoforged.neoforge.event.entity.player.PlayerEvent.PlayerLoggedOutEvent event) {
        // Optional: Remove player data on logout, if necessary
        playerDataMap.remove(event.getEntity().getUUID());
    }
}
