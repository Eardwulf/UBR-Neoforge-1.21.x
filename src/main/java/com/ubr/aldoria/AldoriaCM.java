package com.ubr.aldoria;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.ubr.aldoria.commands.ChooseRaceCommand;
import com.ubr.aldoria.init.*;
import com.ubr.aldoria.player.PlayerDataManager;
import com.ubr.aldoria.player.PlayerEventHandler;
import com.ubr.aldoria.player.PlayerStats;
import com.ubr.aldoria.races.RaceRegistry;
import com.ubr.aldoria.util.CustomTextComponent;
import com.ubr.aldoria.commands.StatsCommand;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import java.util.ArrayList;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(AldoriaCM.MODID)
public class AldoriaCM
{
    public static final String MODID = "aldoriacm";
    private static final Logger LOGGER = LogUtils.getLogger();

    public AldoriaCM(IEventBus modEventBus, ModContainer modContainer)
    {
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        ModBlockEntities.BLOCK_ENTITIES.register(modEventBus); // Register block entities
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        RaceRegistry.registerRaces();
        NeoForge.EVENT_BUS.register(PlayerEventHandler.class);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.HEARTHSTONE);
            //event.accept(ModItems.RAW_BISMUTH);
        }

        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
           event.accept(ModBlocks.ORICHALCUM_ORE);
           // event.accept(ModBlocks.BISMUTH_ORE);
        }
    }


    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }

    }

    @SubscribeEvent
    public void onRegisterCommands(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();
        StatsCommand.register(dispatcher); //Register the /stats command
        ChooseRaceCommand.register(dispatcher);// Register the /chooseRace command
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        event.getServer().getCommands().getDispatcher().register(
                Commands.literal("aldoria")
                        .then(Commands.literal("sethome")
                                .requires(source -> source.hasPermission(2))
                                .executes(context -> {
                                    CommandSourceStack source = context.getSource();
                                    ServerPlayer player = source.getPlayerOrException();
                                    PlayerDataManager.setHomePoint(player, player.getX(), player.getY(), player.getZ());
                                    source.sendSuccess(new CustomTextComponent("Home point set successfully.").build(), true);
                                    return 1;
                                }))
                        .then(Commands.literal("setrace")
                                .requires(source -> source.hasPermission(2))
                                .then(Commands.argument("race", StringArgumentType.word())
                                        .suggests((context, builder) -> {
                                            return net.minecraft.commands.SharedSuggestionProvider.suggest(new ArrayList<>(RaceRegistry.getAvailableRaces()), builder);
                                        })
                                        .executes(context -> {
                                            CommandSourceStack source = context.getSource();
                                            ServerPlayer player = source.getPlayerOrException();
                                            String raceName = StringArgumentType.getString(context, "race");
                                            ModRaces race = RaceRegistry.getRace(raceName);
                                            if (race == null) {
                                                source.sendFailure(Component.literal("Invalid race specified."));
                                                return 0;
                                            }
                                            PlayerDataManager.setPlayerRace(player, race);
                                            source.sendSuccess(new CustomTextComponent("Your race has been set to " + raceName + ".").build(), true);
                                            return 1;
                                        }))
                        )
                        .then(Commands.literal("getraces")
                                .executes(context -> {
                                    CommandSourceStack source = context.getSource();
                                    String races = String.join(", ", RaceRegistry.getAvailableRaces());
                                    // Create a Supplier<Component> for sendSuccess
                                    source.sendSuccess(() -> Component.literal("Available Races: " + races), false);
                                    return 1;
                                }))

                        .then(Commands.literal("stats")
                                .executes(context -> {
                                    ServerPlayer player = context.getSource().getPlayerOrException();
                                    PlayerStats stats = PlayerDataManager.getPlayerData(player).getStats();  // Access PlayerStats

                                    String message = String.format("Level: %d, Experience: %d, Attributes: %s",
                                            stats.getLevel(),
                                            stats.getExperience(),
                                            stats.getAttributes().toString());

                                    // Use a Supplier<Component> by providing a lambda expression
                                    context.getSource().sendSuccess(() -> Component.literal(message), true);

                                    return 1;
                                })
                        )
        );

    }


}
