package com.ubr.aldoria.init;


import com.ubr.aldoria.AldoriaCM;
import com.ubr.aldoria.Machines.*;
import net.minecraft.core.Registry;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockEntities {
    private static Registry<BlockEntityType<?>> EntityBlock;
    // Create a DeferredRegister for BlockEntityTypes
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(EntityBlock, AldoriaCM.MODID);

    // Register the SolarCharger block entity
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SolarChargerBlockEntity>> SOLAR_CHARGER = BLOCK_ENTITIES.register("solar_charger",
            () -> BlockEntityType.Builder.of(SolarChargerBlockEntity::new, ModBlocks.SOLAR_CHARGER.get()).build(null));

    // Register the ElectrumFurnace block entity
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ElectrumFurnaceBlockEntity>> ELECTRUM_FURNACE =
            BLOCK_ENTITIES.register("electrum_furnace",
                    () -> BlockEntityType.Builder.of(ElectrumFurnaceBlockEntity::new, ModBlocks.ELECTRUM_FURNACE.get()).build(null));

    // Register the ElectrumWiring block entity
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ElectrumWiringBlockEntity>> ELECTRUM_WIRING =
            BLOCK_ENTITIES.register("electrum_wiring",
                    () -> BlockEntityType.Builder.of(ElectrumWiringBlockEntity::new, ModBlocks.ELECTRUM_WIRING.get()).build(null));

    // Register the ElectrumCapacitor block entity
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ElectrumCapacitorBlockEntity>> ELECTRUM_CAPACITOR =
            BLOCK_ENTITIES.register("electrum_capacitor",
                    () -> BlockEntityType.Builder.of(ElectrumCapacitorBlockEntity::new, ModBlocks.ELECTRUM_CAPACITOR.get()).build(null));

    // Register the ElectrumConductor block entity
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ElectrumConductorBlockEntity>> ELECTRUM_CONDUCTOR =
            BLOCK_ENTITIES.register("electrum_conductor",
                    () -> BlockEntityType.Builder.of(ElectrumConductorBlockEntity::new, ModBlocks.ELECTRUM_CONDUCTOR.get()).build(null));
}
