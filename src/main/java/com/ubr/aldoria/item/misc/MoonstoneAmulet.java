package com.ubr.aldoria.item.misc;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.network.chat.Component; // Import for Component

import java.util.function.Supplier;

public class MoonstoneAmulet extends Item {
    public MoonstoneAmulet(Properties properties, Supplier<CreativeModeTab> aldoriaItems) {
        super(properties.stacksTo(1)); // Limit to 1 item per stack
    }

    public ItemStack use(ItemStack stack, Level world, Player player) {
        // Logic for activating the amulet can be implemented here if needed
        return stack;
    }

    public void inventoryTick(ItemStack stack, Level world, LivingEntity entity, int slotId, boolean isSelected) {
        // Check if the entity is a player and it's nighttime
        if (entity instanceof Player player && world.isNight()) {
            // Logic to make undead mobs avoid the player
            for (LivingEntity nearbyEntity : world.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(10))) {
                if (isUndead(nearbyEntity)) {
                    // Logic to make undead mobs move away from the player
                    moveAwayFromPlayer(nearbyEntity, player);
                }
            }
        }
    }

    private boolean isUndead(LivingEntity entity) {
        // Check if the entity is an undead type
        return entity instanceof Skeleton ||
                entity instanceof Zombie ||
                entity instanceof Phantom; // Add other undead types as needed
    }

    private void moveAwayFromPlayer(LivingEntity undead, Player player) {
        if (undead instanceof Mob mob) { // Ensure the entity is a Mob
            // Calculate direction away from the player
            double deltaX = undead.getX() - player.getX();
            double deltaZ = undead.getZ() - player.getZ();
            double distance = Math.sqrt(deltaX * deltaX + deltaZ * deltaZ);

            // Move away from the player
            if (distance > 0) {
                mob.getNavigation().moveTo(undead.getX() + (deltaX / distance) * 5, undead.getY(), undead.getZ() + (deltaZ / distance) * 5, 1.0D);
            }
        }
    }

    @Override
    public void onCraftedBy(ItemStack stack, Level world, Player player) {
        player.sendSystemMessage(Component.literal("You feel the protective aura of the Moonstone Amulet.")); // Optional feedback
    }
}
