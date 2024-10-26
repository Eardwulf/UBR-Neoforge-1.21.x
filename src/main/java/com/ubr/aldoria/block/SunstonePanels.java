package com.ubr.aldoria.block;

import com.ubr.aldoria.Machines.SolarChargerBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;

public class SunstonePanels extends Block {
    public SunstonePanels(Properties properties) {
        super(properties);
    }

    public void tick(Level level, BlockPos pos) {
        if (!level.isClientSide) {
            // Assuming the SolarCharger is directly below the panel
            BlockPos solarChargerPos = pos.below();
            BlockEntity solarChargerEntity = level.getBlockEntity(solarChargerPos);

            if (solarChargerEntity instanceof SolarChargerBlockEntity charger) {
                // Call the tick method with required parameters
                SolarChargerBlockEntity.tick(level, solarChargerPos, charger.getBlockState(), charger);
            }
        }
    }
}
