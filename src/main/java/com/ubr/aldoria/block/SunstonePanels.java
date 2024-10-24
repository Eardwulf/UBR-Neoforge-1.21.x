package com.ubr.aldoria.block;

import com.ubr.aldoria.Machines.SolarCharger;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class SunstonePanels extends Block {
    public SunstonePanels(BlockBehaviour.Properties strength) {
        super(strength);
    }

    public void tick() {
        if (level != null && !level.isClientSide) {
            // Collect sunlight and charge connected solar chargers
            if (level.isDay()) {
                // Assuming the SolarCharger is directly below the panel
                BlockPos solarChargerPos = this.getBlockPos().below();
                BlockEntity solarCharger = level.getBlockEntity(solarChargerPos);

                if (solarCharger instanceof SolarCharger charger) {
                    // Charge the solar charger
                    charger.tick(); // Call tick to generate energy if not already done
                }
            }
        }
    }
}
