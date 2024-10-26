package com.ubr.aldoria.item.misc;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.Nullable;

public class ElectrumLamp extends Block {
    public ElectrumLamp() {
        super(BlockBehaviour.Properties.of()
                .mapColor(MapColor.GOLD) // Set the color of the lamp
                .lightLevel(state -> 15) // Light emitted by the lamp
                .strength(1.0F)); // Strength of the block
    }

    public InteractionResult use(BlockState state, Level level, BlockPos pos, LivingEntity entity, InteractionHand hand) {
        // Any interaction logic if needed
        return InteractionResult.SUCCESS; // Indicate that the interaction was successful
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onPlace(state, level, pos, oldState, isMoving);
        repelMonsters(level, pos); // Repel monsters when placed
    }

    public void repelMonsters(Level level, BlockPos pos) {
        // Define the radius for repelling monsters
        int radius = 5;

        // Check for nearby entities
        for (LivingEntity livingEntity : level.getEntitiesOfClass(LivingEntity.class,
                new net.minecraft.world.phys.AABB(pos).inflate(radius))) {
            // Logic to repel hostile mobs only
            if (livingEntity instanceof Mob && !livingEntity.isInvulnerable()) {
                double deltaX = livingEntity.getX() - pos.getX();
                double deltaZ = livingEntity.getZ() - pos.getZ();
                double distance = Math.sqrt(deltaX * deltaX + deltaZ * deltaZ);

                // Move the entity away from the lamp
                if (distance < radius) {
                    livingEntity.setPos(livingEntity.getX() + (deltaX / distance) * 2,
                            livingEntity.getY(),
                            livingEntity.getZ() + (deltaZ / distance) * 2);
                }
            }
        }
    }
}
