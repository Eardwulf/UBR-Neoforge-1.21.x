package com.ubr.aldoria.item.equipment;

import com.ubr.aldoria.init.ModArmorMaterials;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.ArmorHurtEvent;

import java.util.function.Supplier;

@EventBusSubscriber
public class OrichalcumArmor extends ArmorItem {

    public OrichalcumArmor(ArmorMaterial material, EquipmentSlot slot, Supplier<CreativeModeTab> aldoriaItems, Properties properties) {
        super(ModArmorMaterials.ORICHALCUM_ARMOR_MATERIAL, Type.HELMET, new Properties());
    }

    @SubscribeEvent
    public static void onLivingHurt(ArmorHurtEvent event) {
        if (event.getEntity() instanceof Player player) {
            ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);
            if (helmet.getItem() instanceof OrichalcumArmor) {
                // Titanite Armor provides damage resistance from melee attacks
                float v = event.getNewDamage(EquipmentSlot.HEAD) * 0.75f;; // Reduce damage by 25%
            }
        }
    }
}