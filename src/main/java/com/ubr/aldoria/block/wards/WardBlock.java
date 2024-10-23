package com.ubr.aldoria.block.wards;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;

public class WardBlock extends Block {

        public WardBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        // Check if the entity is a LivingEntity (like mobs)
        if (entity instanceof LivingEntity) {
            // Calculate the distance to the ward block
            double distance = entity.distanceToSqr(pos.getX(), pos.getY(), pos.getZ());

            // Define a radius (for example, 5 blocks)
            if (distance < 5.0 * 5.0) { // 5.0 blocks radius
                // Move the entity away from the ward block
                entity.setDeltaMovement(entity.getDeltaMovement().add(
                        (pos.getX() - entity.getX()) * 0.1,
                        0,
                        (pos.getZ() - entity.getZ()) * 0.1
                ));
            }
        }
    }
}
