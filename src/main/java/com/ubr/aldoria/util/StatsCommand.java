package com.ubr.aldoria.util;  // Ensure this package matches your structure

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.ubr.aldoria.player.PlayerData;
import com.ubr.aldoria.player.PlayerDataManager;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class StatsCommand {

    // Register the command
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("stats")
                .executes(StatsCommand::showPlayerStats));  // The command itself
    }

    private static int showPlayerStats(CommandContext<CommandSourceStack> context) {
        return 1;
    }

    // Command execution logic to show the player's stats
    private static int showPlayerStats(CommandSourceStack context) throws CommandSyntaxException {
        ServerPlayer player = context.getPlayerOrException();

        // Fetch player data
        PlayerData playerData = PlayerDataManager.getPlayerData(player);

        // Format stats into a readable format
        String playerStats = String.format(
                "Player: %s\nVitality: %d\nMight: %d\nAgility: %d\nMind: %d\nWill: %d\nPresence: %d\nAwareness: %d",
                player.getName().getString(),
                playerData.getAttributes().get("Vitality").getValue(),
                playerData.getAttributes().get("Might").getValue(),
                playerData.getAttributes().get("Agility").getValue(),
                playerData.getAttributes().get("Mind").getValue(),
                playerData.getAttributes().get("Will").getValue(),
                playerData.getAttributes().get("Presence").getValue(),
                playerData.getAttributes().get("Awareness").getValue()
        );

        // Send the stats to the player
        player.sendSystemMessage(Component.literal(playerStats));

        return 1;  // Command executed successfully
    }
}
