package com.ubr.aldoria.init;

import com.ubr.aldoria.AldoriaCM;
import com.ubr.aldoria.Machines.SolarChargerBlockEntity;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredBlock;
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

    // Register the SunstonePanels block entity similarly if you have that defined
}
