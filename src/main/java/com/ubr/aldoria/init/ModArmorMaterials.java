package com.ubr.aldoria.init;

import com.ubr.aldoria.AldoriaCM;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {
    public static final Holder<ArmorMaterial> ORICHALCUM_ARMOR_MATERIAL = register("orichalcum",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 6);
                attribute.put(ArmorItem.Type.LEGGINGS, 8);
                attribute.put(ArmorItem.Type.CHESTPLATE, 10);
                attribute.put(ArmorItem.Type.HELMET, 6);
                attribute.put(ArmorItem.Type.BODY, 12);
            }), 20, 3f, 0.2f, ModItems.ORICHALCUM_HELMET::get); // Higher values for enchantability, toughness, and knockback

    // Define Titanite Armor Material
    public static final Holder<ArmorMaterial> TITANITE_ARMOR_MATERIAL = register("titanite",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 5);
                attribute.put(ArmorItem.Type.LEGGINGS, 6);
                attribute.put(ArmorItem.Type.CHESTPLATE, 8);
                attribute.put(ArmorItem.Type.HELMET, 5);
                attribute.put(ArmorItem.Type.BODY, 10);
            }), 15, 2.5f, 0.15f, ModItems.TITANITE_HELMET::get); // Use appropriate item for ingredient

    // Define Moonstone Armor Material
    public static final Holder<ArmorMaterial> MOONSTONE_ARMOR_MATERIAL = register("moonstone",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 4);
                attribute.put(ArmorItem.Type.LEGGINGS, 5);
                attribute.put(ArmorItem.Type.CHESTPLATE, 7);
                attribute.put(ArmorItem.Type.HELMET, 4);
                attribute.put(ArmorItem.Type.BODY, 9);
            }), 12, 2.0f, 0.1f, ModItems.MOONSTONE_HELMET::get);

    // Define Sunstone Armor Material
    public static final Holder<ArmorMaterial> SUNSTONE_ARMOR_MATERIAL = register("sunstone",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 5);
                attribute.put(ArmorItem.Type.LEGGINGS, 6);
                attribute.put(ArmorItem.Type.CHESTPLATE, 8);
                attribute.put(ArmorItem.Type.HELMET, 5);
                attribute.put(ArmorItem.Type.BODY, 10);
            }), 15, 2.5f, 0.15f, ModItems.SUNSTONE_HELMET::get);

    // Define Cryolite Armor Material
    public static final Holder<ArmorMaterial> CRYOLITE_ARMOR_MATERIAL = register("cryolite",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 5);
                attribute.put(ArmorItem.Type.LEGGINGS, 6);
                attribute.put(ArmorItem.Type.CHESTPLATE, 8);
                attribute.put(ArmorItem.Type.HELMET, 5);
                attribute.put(ArmorItem.Type.BODY, 10);
            }), 14, 2.5f, 0.1f, ModItems.CRYOLITE_HELMET::get);

    // Define Electrum Armor Material (higher enchantability)
    public static final Holder<ArmorMaterial> ELECTRUM_ARMOR_MATERIAL = register("electrum",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 4);
                attribute.put(ArmorItem.Type.LEGGINGS, 5);
                attribute.put(ArmorItem.Type.CHESTPLATE, 7);
                attribute.put(ArmorItem.Type.HELMET, 4);
                attribute.put(ArmorItem.Type.BODY, 8);
            }), 25, 2.0f, 0.05f, ModItems.ELECTRUM_HELMET::get);


    private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> typeProtection,
                                                  int enchantability, float toughness, float knockbackResistance,
                                                  Supplier<Item> ingredientItem) {
        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(AldoriaCM.MODID, name);
        Holder<SoundEvent> equipSound = SoundEvents.ARMOR_EQUIP_NETHERITE;
        Supplier<Ingredient> ingredient = () -> Ingredient.of(ingredientItem.get());
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(location));

        EnumMap<ArmorItem.Type, Integer> typeMap = new EnumMap<>(ArmorItem.Type.class);
        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            typeMap.put(type, typeProtection.get(type));
        }

        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, location,
                new ArmorMaterial(typeProtection, enchantability, equipSound, ingredient, layers, toughness, knockbackResistance));
    }
}