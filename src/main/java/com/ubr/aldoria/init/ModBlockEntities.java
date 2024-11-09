package com.ubr.aldoria.init;


import com.ubr.aldoria.AldoriaCM;
import com.ubr.aldoria.block.MortarAndPestleBlockEntity;
import com.ubr.aldoria.machines.*;
import com.ubr.aldoria.machines.ElectrumCapacitorBlockEntity;
import net.minecraft.core.Registry;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockEntities {
    private static Registry<BlockEntityType<?>> EntityBlock;
    // Create a DeferredRegister for BlockEntityTypes
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(EntityBlock, AldoriaCM.MODID);

    // Register the Solar Charger block entity
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SolarChargerBlockEntity>> SOLAR_CHARGER = BLOCK_ENTITIES.register("solar_charger",
            () -> BlockEntityType.Builder.of(SolarChargerBlockEntity::new, ModBlocks.SOLAR_CHARGER.get()).build(null));

    // Register the Electrum Furnace block entity
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ElectrumFurnaceBlockEntity>> ELECTRUM_FURNACE =
            BLOCK_ENTITIES.register("electrum_furnace",
                    () -> BlockEntityType.Builder.of(ElectrumFurnaceBlockEntity::new, ModBlocks.ELECTRUM_FURNACE.get()).build(null));

    // Register the Electrum Wiring block entity
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ElectrumWiringBlockEntity>> ELECTRUM_WIRING =
            BLOCK_ENTITIES.register("electrum_wiring",
                    () -> BlockEntityType.Builder.of(ElectrumWiringBlockEntity::new, ModBlocks.ELECTRUM_WIRING.get()).build(null));

    // Register the Electrum Capacitor block entity
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ElectrumCapacitorBlockEntity>> ELECTRUM_CAPACITOR =
            BLOCK_ENTITIES.register("electrum_capacitor",
                    () -> BlockEntityType.Builder.of(ElectrumCapacitorBlockEntity::new, ModBlocks.ELECTRUM_CAPACITOR.get()).build(null));

    // Register the Electrum Conductor block entity
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ElectrumConductorBlockEntity>> ELECTRUM_CONDUCTOR =
            BLOCK_ENTITIES.register("electrum_conductor",
                    () -> BlockEntityType.Builder.of(ElectrumConductorBlockEntity::new, ModBlocks.ELECTRUM_CONDUCTOR.get()).build(null));

    // Register the Mortal and Pestle block entity
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ElectrumConductorBlockEntity>> MORTAL_AND_PESTLE =
            BLOCK_ENTITIES.register("mortal_and_pestle",
                    () -> BlockEntityType.Builder.of(ElectrumConductorBlockEntity::new, ModBlocks.MORTAL_AND_PESTLE_BLOCK.get()).build(null));

}
