package com.ubr.aldoria.player;

import com.ubr.aldoria.races.RaceRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

@EventBusSubscriber
public class PlayerEventHandler {

    @SubscribeEvent
    public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        ServerPlayer player = (ServerPlayer) event.getEntity();

        // Load player data when they log in
        CompoundTag playerDataTag = player.getPersistentData().getCompound("PlayerData");
        PlayerData playerData = PlayerDataManager.getPlayerData(player);  // Fetch PlayerData using PlayerDataManager
        if (!playerDataTag.isEmpty()) {
            playerData.loadFromNBT(playerDataTag);  // Load existing player data from NBT
        }

        // Optionally apply stat effects when the player logs in
        playerData.applyStatEffects(player);

        // Optionally send a message to the player
        player.sendSystemMessage(Component.translatable("Welcome back, " + player.getName().getString() + "!"));
    }

    @SubscribeEvent
    public static void onPlayerLogout(PlayerEvent.PlayerLoggedOutEvent event) {
        ServerPlayer player = (ServerPlayer) event.getEntity();

        // Get PlayerData instance for this player
        PlayerData playerData = PlayerDataManager.getPlayerData(player);

        // Apply stat effects before logging out (if needed)
        playerData.applyStatEffects(player);

        // Save player data to NBT
        CompoundTag persistentData = player.getPersistentData();
        CompoundTag playerDataTag = new CompoundTag();
        playerDataTag = playerData.saveToNBT();  // Save PlayerData to NBT
        persistentData.put("PlayerData", playerDataTag);  // Store it in the player's persistent data
    }

    @SubscribeEvent
    public static void onPlayerChangeDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
        ServerPlayer player = (ServerPlayer) event.getEntity();

        // Handle any necessary logic when a player changes dimensions
        player.sendSystemMessage(Component.translatable("You have changed dimensions!"));

        // Optionally, reapply stat effects when a player changes dimension
        PlayerData playerData = PlayerDataManager.getPlayerData(player);
        playerData.applyStatEffects(player);
    }

    @SubscribeEvent
    public static void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        ServerPlayer player = (ServerPlayer) event.getEntity();

        // Reapply stat effects on respawn
        PlayerData playerData = PlayerDataManager.getPlayerData(player);
        playerData.applyStatEffects(player);

        // Optionally send a message to the player
        player.sendSystemMessage(Component.translatable("You have respawned. Your stats have been reapplied!"));
    }
}
