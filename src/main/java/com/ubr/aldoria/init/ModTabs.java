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
                        //output.accept(ModItems.ORICHALCUM_INGOT);
                    }).build());

    public static final Supplier<CreativeModeTab> ALDORIA_BLOCKS = CREATIVE_MODE_TAB.register("aldoria_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.ORICHALCUM_BLOCK))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(AldoriaCM.MODID, "aldoria_blocks_tab"))
                    .title(Component.translatable("creativetab.tutorialmod.aldoria_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                    }).build());

    public static final Supplier<CreativeModeTab> ALDORIA_POTIONS = CREATIVE_MODE_TAB.register("aldoria_potions_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CHAMOMILE_TEA.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(AldoriaCM.MODID, "aldoria_potions_tab"))
                    .title(Component.translatable("creativetab.tutorialmod.aldoria_potions"))
                    .displayItems((itemDisplayParameters, output) -> {
                    }).build());

    public static final Supplier<CreativeModeTab> ALDORIA_FOODS = CREATIVE_MODE_TAB.register("aldoria_foods_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.DRAGONFRUIT_SALAD.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(AldoriaCM.MODID, "aldoria_foods_tab"))
                    .title(Component.translatable("creativetab.tutorialmod.aldoria_foods"))
                    .displayItems((itemDisplayParameters, output) -> {
                    }).build());

    public static final Supplier<CreativeModeTab> ALDORIA_SEEDS = CREATIVE_MODE_TAB.register("aldoria_seeds_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BLOOD_BERRY_SEEDS.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(AldoriaCM.MODID, "aldoria_seeds_tab"))
                    .title(Component.translatable("creativetab.tutorialmod.aldoria_seeds"))
                    .displayItems((itemDisplayParameters, output) -> {
                    }).build());

    public static final Supplier<CreativeModeTab> ALDORIA_EQUIPMENT= CREATIVE_MODE_TAB.register("aldoria_equipment_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ORICHALCUM_AXE.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(AldoriaCM.MODID, "aldoria_equipment_tab"))
                    .title(Component.translatable("creativetab.tutorialmod.aldoria_equpment"))
                    .displayItems((itemDisplayParameters, output) -> {
                    }).build());

    public static final Supplier<CreativeModeTab> ALDORIA_POUCHES = CREATIVE_MODE_TAB.register("aldoria_pouches_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.HERBAL_POUCH.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(AldoriaCM.MODID, "aldoria_pouches_tab"))
                    .title(Component.translatable("creativetab.tutorialmod.aldoria_pouches"))
                    .displayItems((itemDisplayParameters, output) -> {
                    }).build());

    public static final Supplier<CreativeModeTab> ALDORIA_APOTHECARY = CREATIVE_MODE_TAB.register("aldoria_apothecary_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ESSENCE_EXTRACTOR.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(AldoriaCM.MODID, "aldoria_apothecary_tab"))
                    .title(Component.translatable("creativetab.tutorialmod.aldoria_apothecary"))
                    .displayItems((itemDisplayParameters, output) -> {
                    }).build());

    public static final Supplier<CreativeModeTab> ALDORIA_NATURE = CREATIVE_MODE_TAB.register("aldoria_nature_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BASILISK_ROOT.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(AldoriaCM.MODID, "aldoria_nature_tab"))
                    .title(Component.translatable("creativetab.tutorialmod.aldoria_nature"))
                    .displayItems((itemDisplayParameters, output) -> {
                    }).build());

    public static final Supplier<CreativeModeTab> ALDORIA_MACHINES = CREATIVE_MODE_TAB.register("aldoria_machines_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.APOTHECARY_TABLE_BLOCK))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(AldoriaCM.MODID, "aldoria_machines_tab"))
                    .title(Component.translatable("creativetab.tutorialmod.aldoria_machines"))
                    .displayItems((itemDisplayParameters, output) -> {
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
