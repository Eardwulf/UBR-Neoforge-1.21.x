package com.ubr.aldoria.player;

import com.ubr.aldoria.init.ModRaces;
import com.ubr.aldoria.races.RaceRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerDataManager {
    private static final Map<UUID, PlayerData> playerDataMap = new HashMap<>();

    public static void setPlayerRace(ServerPlayer player, ModRaces newRace) {
        PlayerData data = getPlayerData(player);
        data.setRace(newRace);
        // Send a message to the player about the race update
        player.sendSystemMessage(Component.translatable("message.aldoriacm.race.set", newRace.getName()));
    }

    public static PlayerData getPlayerData(ServerPlayer player) {
        return playerDataMap.computeIfAbsent(player.getUUID(), uuid -> new PlayerData(RaceRegistry.getRace("Nomads")));
    }

    public static PlayerStats getPlayerStats(ServerPlayer player) {
        return getPlayerData(player).getStats();
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
