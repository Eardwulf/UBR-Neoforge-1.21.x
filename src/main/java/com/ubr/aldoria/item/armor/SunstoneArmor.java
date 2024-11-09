package com.ubr.aldoria.item.armor;


import com.ubr.aldoria.init.ModArmorMaterials;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.ArmorHurtEvent;

@EventBusSubscriber
public class SunstoneArmor extends ArmorItem {

    public SunstoneArmor(ArmorMaterial material, EquipmentSlot slot) {
        super(ModArmorMaterials.TITANITE_ARMOR_MATERIAL, Type.HELMET, new Properties());
    }

    @SubscribeEvent
    public static void onLivingHurt(ArmorHurtEvent event) {
        if (event.getEntity() instanceof Player player) {
            ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);
            if (helmet.getItem() instanceof SunstoneArmor) {
                // Sunstone Armor provides health regeneration while in sunlight
                if (player.level().isDay()) {
                    player.heal(1.0f); // Heal 1 heart every tick in sunlight
                }
            }
        }
    }
}
