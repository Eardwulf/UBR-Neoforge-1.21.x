package com.ubr.aldoria.item.armor;

import com.ubr.aldoria.init.ModArmorMaterials;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.ArmorHurtEvent;

@EventBusSubscriber
public class CryoliteArmor extends ArmorItem {

    public CryoliteArmor(ArmorMaterial material, EquipmentSlot slot) {
        super(ModArmorMaterials.CRYOLITE_ARMOR_MATERIAL, Type.HELMET, new Properties());
    }

    @SubscribeEvent
    public static void onLivingHurt(ArmorHurtEvent event) {
        if (event.getEntity() instanceof Player player) {
            ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);
            if (helmet.getItem() instanceof CryoliteArmor) {
                // Cryolite Armor provides a temporary speed boost on damage
                player.setSprinting(true);
                player.getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).setBaseValue(0.1f); // Adjust speed as needed
            }
        }
    }
}
