package com.ubr.aldoria.item.armor;

import com.ubr.aldoria.init.ModArmorMaterials;
import net.minecraft.world.entity.EntityType;
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
public class TitaniteArmor extends ArmorItem {

    public TitaniteArmor(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(ModArmorMaterials.TITANITE_ARMOR_MATERIAL, Type.HELMET, new Properties());
    }

    @SubscribeEvent
    public static void onLivingHurt(ArmorHurtEvent event) {
        if (event.getEntity() instanceof Player player) {
            ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);
            if (helmet.getItem() instanceof TitaniteArmor) {
                // Titanite Armor provides damage resistance from melee attacks
                float v = event.getNewDamage(EquipmentSlot.HEAD) * 0.75f;; // Reduce damage by 25%
            }
        }
    }
}
