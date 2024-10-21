package com.ubr.aldoria.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.ubr.aldoria.init.ModRaces;
import com.ubr.aldoria.player.PlayerData;
import com.ubr.aldoria.player.PlayerDataManager;
import com.ubr.aldoria.races.RaceRegistry;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class ChooseRaceCommand {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("chooseRace")
                .then(Commands.argument("race", StringArgumentType.word())
                        .suggests((context, builder) -> {
                            return net.minecraft.commands.SharedSuggestionProvider.suggest(RaceRegistry.getAvailableRaces(), builder);
                        })
                        .executes(context -> {
                            return chooseRace(context.getSource(), StringArgumentType.getString(context, "race"));
                        })));
    }

    // Command logic for choosing a race
    private static int chooseRace(CommandSourceStack source, String raceName) throws CommandSyntaxException {
        ServerPlayer player = source.getPlayerOrException();
        PlayerData playerData = PlayerDataManager.getPlayerData(player);

        // Check if the race exists in the registry
        ModRaces race = RaceRegistry.getRace(raceName);
        if (race == null) {
            // Send an error message if the race doesn't exist
            player.sendSystemMessage(Component.literal("Invalid race. Please choose a valid race."));
            return 0;
        }

        // Set the player's race
        playerData.setRace(race);

        // Save the player's data
        CompoundTag playerDataTag = new CompoundTag();
        playerDataTag.putString("Race", raceName);
        player.getPersistentData().put("PlayerData", playerDataTag);

        // Confirm the race choice
        player.sendSystemMessage(Component.literal("You have chosen the " + raceName + " race!"));

        // Optionally apply stat effects
        playerData.applyStatEffects(player);

        return 1;  // Command executed successfully
    }
}
