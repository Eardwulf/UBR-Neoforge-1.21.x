package com.ubr.aldoria.item.equipment;


import com.ubr.aldoria.init.ModArmorMaterials;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.ArmorHurtEvent;

import java.util.function.Supplier;

@EventBusSubscriber()
public class MoonstoneArmor extends ArmorItem {
    public MoonstoneArmor(ArmorMaterial material, EquipmentSlot slot, Supplier<CreativeModeTab> aldoriaItems) {
        super(ModArmorMaterials.MOONSTONE_ARMOR_MATERIAL, Type.HELMET, new Properties());
    }

    public void onArmorTick(ItemStack stack, Level world, Player player) {
        // Method can be kept if you need to run specific logic every tick
    }

    @SubscribeEvent
    public static void onLivingHurt(ArmorHurtEvent event) {
        if (event.getEntity() instanceof Player player) {
            ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);
            if (helmet.getItem() instanceof MoonstoneArmor) {
                // Check if the source of damage is from an undead mob
                if (isUndead(((Player) event.getEntity()).getLastAttacker())) {
                    // Reduce damage by 50%
                    event.getNewDamage(EquipmentSlot.HEAD);
                }
            }
        }
    }

    private static boolean isUndead(LivingEntity entity) {
        return entity != null && (entity.getType() == EntityType.ZOMBIE ||
                entity.getType() == EntityType.SKELETON ||
                entity.getType() == EntityType.PHANTOM); // Add other undead types as needed
    }
}
