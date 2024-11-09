package com.ubr.aldoria.init;

import com.ubr.aldoria.AldoriaCM;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.function.Supplier;

public class ModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AldoriaCM.MODID);

    public static final Supplier<CreativeModeTab> ALDORIA_ITEMS = CREATIVE_MODE_TAB.register("aldoria_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.HEARTHSTONE.get()))
                    .title(Component.translatable("creativetab.tutorialmod.aldoria_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.HEARTHSTONE);
                        output.accept(ModItems.ORICHALCUM_INGOT);
                    }).build());

    public static final Supplier<CreativeModeTab> ALDORIA_BLOCKS = CREATIVE_MODE_TAB.register("aldoria_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.ORICHALCUM_BLOCK))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(AldoriaCM.MODID, "aldoria_blocks_tab"))
                    .title(Component.translatable("creativetab.tutorialmod.aldoria_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.ORICHALCUM_BLOCK);
                        output.accept(ModBlocks.ORICHALCUM_BRICK);
                        output.accept(ModBlocks.ORICHALCUM_PILLAR);
                        output.accept(ModBlocks.ORICHALCUM_TILES);
                        output.accept(ModBlocks.ORICHALCUM_WARD);
                        output.accept(ModBlocks.ORICHALCUM_ORE);

                    }).build());

    public static final Supplier<CreativeModeTab> ALDORIA_POTIONS = CREATIVE_MODE_TAB.register("aldoria_potions_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.ORICHALCUM_BLOCK))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(AldoriaCM.MODID, "aldoria_potions_tab"))
                    .title(Component.translatable("creativetab.tutorialmod.aldoria_potions"))
                    .displayItems((itemDisplayParameters, output) -> {
                       // output.accept(ModBlocks.ORICHALCUM_BLOCK);

                    }).build());

    public static final Supplier<CreativeModeTab> ALDORIA_FOODS = CREATIVE_MODE_TAB.register("aldoria_foods_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.ORICHALCUM_BLOCK))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(AldoriaCM.MODID, "aldoria_foods_tab"))
                    .title(Component.translatable("creativetab.tutorialmod.aldoria_foods"))
                    .displayItems((itemDisplayParameters, output) -> {
                        // output.accept(ModBlocks.ORICHALCUM_BLOCK);

                    }).build());

    public static final Supplier<CreativeModeTab> ALDORIA_SEEDS = CREATIVE_MODE_TAB.register("aldoria_seeds_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.ORICHALCUM_BLOCK))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(AldoriaCM.MODID, "aldoria_seeds_tab"))
                    .title(Component.translatable("creativetab.tutorialmod.aldoria_seeds"))
                    .displayItems((itemDisplayParameters, output) -> {
                        // output.accept(ModBlocks.ORICHALCUM_BLOCK);

                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
