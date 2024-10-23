package com.ubr.aldoria.block.wards;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.server.level.ServerLevel;

import java.util.List;

public class MoonstoneWard extends Block {
    public MoonstoneWard() {
        super(BlockBehaviour.Properties.of() // Adjust material if needed
                .strength(2.0F, 6.0F)
                .lightLevel(state -> 15)); // Optional: make it emit light
    }

    public void repelUndead(Level world, BlockPos pos) {
        // Define the radius within which undead mobs are repelled
        int radius = 5;

        // Get all living entities within the radius
        List<LivingEntity> nearbyEntities = world.getEntitiesOfClass(LivingEntity.class,
                new net.minecraft.world.phys.AABB(pos).inflate(radius));

        for (LivingEntity entity : nearbyEntities) {
            if (isUndead(entity)) {
                // Logic to make undead mobs move away from the ward
                moveAwayFromWard(entity, pos);
            }
        }
    }

    private boolean isUndead(LivingEntity entity) {
        // Check if the entity is an undead type
        return entity.getType() == EntityType.ZOMBIE ||
                entity.getType() == EntityType.SKELETON ||
                entity.getType() == EntityType.PHANTOM; // Add other undead types as needed
    }

    private void moveAwayFromWard(LivingEntity undead, BlockPos pos) {
        if (undead instanceof Mob mob) { // Ensure the entity is a Mob
            // Calculate direction away from the ward
            double deltaX = undead.getX() - pos.getX();
            double deltaZ = undead.getZ() - pos.getZ();
            double distance = Math.sqrt(deltaX * deltaX + deltaZ * deltaZ);

            // Move away from the ward
            if (distance > 0) {
                mob.getNavigation().moveTo(undead.getX() + (deltaX / distance) * 5, undead.getY(), undead.getZ() + (deltaZ / distance) * 5, 1.0D);
            }
        }
    }
}
