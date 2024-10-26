package com.ubr.aldoria.init;

import com.ubr.aldoria.AldoriaCM;
import com.ubr.aldoria.item.SunstoneAmulet;
import com.ubr.aldoria.item.armor.MoonstoneArmor;
import com.ubr.aldoria.item.misc.*;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModItems
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AldoriaCM.MODID);

    //Misc
    public static final DeferredItem<Item> HEARTHSTONE = ITEMS.register("hearthstone", () -> new Hearthstone(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> LUNAR_COMPASS = ITEMS.register("lunar_compass", () -> new LunarCompass(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> MOONLIGHT_LANTERN = ITEMS.register("moonlight_lantern", () -> new MoonlightLantern(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> MOONSTONE_AMULET = ITEMS.register("moonstone_dust", () -> new MoonstoneAmulet(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> LUNAR_CHARM = ITEMS.register("moonstone_dust", () -> new LunarCharm(new Item.Properties().stacksTo(5)));
    public static final DeferredItem<Item> SUNSTONE_AMULET = ITEMS.register("sunstone_amulet", () -> new SunstoneAmulet(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> SUN_STONE = ITEMS.register("sun_stone", () -> new SunStone(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> AETHERIAL_QUARTZ_AMULET = ITEMS.register("aetherial_quartz_amulet", () -> new AtherialQuartzAmulet(new Item.Properties().stacksTo(1)));


    //Ingots
    public static final DeferredItem<Item> ORICHALCUM_INGOT = ITEMS.register("orichalcum_ingot", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SUNSTONE_INGOT = ITEMS.register("sunstone_ingot", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CRYOLITE_INGOT = ITEMS.register("cryolite_ingot", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ELECTRUM_INGOT = ITEMS.register("electrum_ingot", () -> new Item(new Item.Properties()));


    //Orichalcum Tools
    public static final DeferredItem<SwordItem> ORICHALCUM_SWORD = ITEMS.register("orichalcum_sword",
            () -> new SwordItem(ModTiers.ORICHALCUM, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.ORICHALCUM, 5, -2.4f))));
    public static final DeferredItem<PickaxeItem> ORICHALCUM_PICKAXE = ITEMS.register("orichalcum_pickaxe",
            () -> new PickaxeItem(ModTiers.ORICHALCUM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModTiers.ORICHALCUM, 1.0F, -2.8f))));
    public static final DeferredItem<ShovelItem> ORICHALCUM_SHOVEL = ITEMS.register("orichalcum_shovel",
            () -> new ShovelItem(ModTiers.ORICHALCUM, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModTiers.ORICHALCUM, 1.5F, -3.0f))));
    public static final DeferredItem<AxeItem> ORICHALCUM_AXE = ITEMS.register("orichalcum_axe",
            () -> new AxeItem(ModTiers.ORICHALCUM, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModTiers.ORICHALCUM, 6.0F, -3.2f))));
    public static final DeferredItem<HoeItem> ORICHALCUM_HOE = ITEMS.register("orichalcum_hoe",
            () -> new HoeItem(ModTiers.ORICHALCUM, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModTiers.ORICHALCUM, 0F, -3.0f))));
    //Titanite Tools
    public static final DeferredItem<SwordItem> TITANITE_SWORD = ITEMS.register("titanite_sword",
            () -> new SwordItem(ModTiers.TITANITE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.TITANITE, 5, -2.4f))));
    public static final DeferredItem<PickaxeItem> TITANITE_PICKAXE = ITEMS.register("titanite_pickaxe",
            () -> new PickaxeItem(ModTiers.TITANITE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModTiers.TITANITE, 1.0F, -2.8f))));
    public static final DeferredItem<ShovelItem> TITANITE_SHOVEL = ITEMS.register("titanite_shovel",
            () -> new ShovelItem(ModTiers.TITANITE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModTiers.TITANITE, 1.5F, -3.0f))));
    public static final DeferredItem<AxeItem> TITANITE_AXE = ITEMS.register("titanite_axe",
            () -> new AxeItem(ModTiers.TITANITE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModTiers.TITANITE, 6.0F, -3.2f))));
    public static final DeferredItem<HoeItem> TITANITE_HOE = ITEMS.register("titanite_hoe",
            () -> new HoeItem(ModTiers.TITANITE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModTiers.TITANITE, 0F, -3.0f))));
    //Moonstone Tools
    public static final DeferredItem<SwordItem> MOONSTONE_SWORD = ITEMS.register("moonstone_sword",
            () -> new SwordItem(ModTiers.MOONSTONE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.MOONSTONE, 5, -2.4f))));
    public static final DeferredItem<PickaxeItem> MOONSTONE_PICKAXE = ITEMS.register("moonstone_pickaxe",
            () -> new PickaxeItem(ModTiers.MOONSTONE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModTiers.MOONSTONE, 1.0F, -2.8f))));
    public static final DeferredItem<ShovelItem> MOONSTONE_SHOVEL = ITEMS.register("moonstone_shovel",
            () -> new ShovelItem(ModTiers.MOONSTONE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModTiers.MOONSTONE, 1.5F, -3.0f))));
    public static final DeferredItem<AxeItem> MOONSTONE_AXE = ITEMS.register("moonstone_axe",
            () -> new AxeItem(ModTiers.MOONSTONE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModTiers.MOONSTONE, 6.0F, -3.2f))));
    public static final DeferredItem<HoeItem> MOONSTONE_HOE = ITEMS.register("moonstone_hoe",
            () -> new HoeItem(ModTiers.MOONSTONE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModTiers.MOONSTONE, 0F, -3.0f))));
    //Sunstone Tools
    public static final DeferredItem<SwordItem> SUNSTONE_SWORD = ITEMS.register("sunstone_sword",
            () -> new SwordItem(ModTiers.SUNSTONE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.SUNSTONE, 5, -2.4f))));
    public static final DeferredItem<PickaxeItem> SUNSTONE_PICKAXE = ITEMS.register("sunstone_pickaxe",
            () -> new PickaxeItem(ModTiers.SUNSTONE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModTiers.SUNSTONE, 1.0F, -2.8f))));
    public static final DeferredItem<ShovelItem> SUNSTONE_SHOVEL = ITEMS.register("sunstone_shovel",
            () -> new ShovelItem(ModTiers.SUNSTONE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModTiers.SUNSTONE, 1.5F, -3.0f))));
    public static final DeferredItem<AxeItem> SUNSTONE_AXE = ITEMS.register("sunstone_axe",
            () -> new AxeItem(ModTiers.SUNSTONE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModTiers.SUNSTONE, 6.0F, -3.2f))));
    public static final DeferredItem<HoeItem> SUNSTONE_HOE = ITEMS.register("sunstone_hoe",
            () -> new HoeItem(ModTiers.SUNSTONE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModTiers.SUNSTONE, 0F, -3.0f))));
    //Cryolite Tools
    public static final DeferredItem<SwordItem> CRYOLITE_SWORD = ITEMS.register("cryolite_sword",
            () -> new SwordItem(ModTiers.CRYOLITE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.CRYOLITE, 5, -2.4f))));
    public static final DeferredItem<PickaxeItem> CRYOLITE_PICKAXE = ITEMS.register("cryolite_pickaxe",
            () -> new PickaxeItem(ModTiers.CRYOLITE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModTiers.CRYOLITE, 1.0F, -2.8f))));
    public static final DeferredItem<ShovelItem> CRYOLITE_SHOVEL = ITEMS.register("cryolite_shovel",
            () -> new ShovelItem(ModTiers.CRYOLITE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModTiers.CRYOLITE, 1.5F, -3.0f))));
    public static final DeferredItem<AxeItem> CRYOLITE_AXE = ITEMS.register("cryolite_axe",
            () -> new AxeItem(ModTiers.CRYOLITE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModTiers.CRYOLITE, 6.0F, -3.2f))));
    public static final DeferredItem<HoeItem> CRYOLITE_HOE = ITEMS.register("cryolite_hoe",
            () -> new HoeItem(ModTiers.CRYOLITE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModTiers.CRYOLITE, 0F, -3.0f))));
    //Electrum Tools
    public static final DeferredItem<SwordItem> ELECTRUM_SWORD = ITEMS.register("cryolite_sword",
            () -> new SwordItem(ModTiers.ELECTRUM, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.ELECTRUM, 5, -2.4f))));
    public static final DeferredItem<PickaxeItem> ELECTRUM_PICKAXE = ITEMS.register("cryolite_pickaxe",
            () -> new PickaxeItem(ModTiers.ELECTRUM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModTiers.ELECTRUM, 1.0F, -2.8f))));
    public static final DeferredItem<ShovelItem> ELECTRUM_SHOVEL = ITEMS.register("cryolite_shovel",
            () -> new ShovelItem(ModTiers.ELECTRUM, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModTiers.ELECTRUM, 1.5F, -3.0f))));
    public static final DeferredItem<AxeItem> ELECTRUM_AXE = ITEMS.register("cryolite_axe",
            () -> new AxeItem(ModTiers.ELECTRUM, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModTiers.ELECTRUM, 6.0F, -3.2f))));
    public static final DeferredItem<HoeItem> ELECTRUM_HOE = ITEMS.register("cryolite_hoe",
            () -> new HoeItem(ModTiers.ELECTRUM, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModTiers.ELECTRUM, 0F, -3.0f))));

    //Orichalcum Armor
    public static final DeferredItem<ArmorItem> ORICHALCUM_HELMET = ITEMS.register("orichalcum_helmet",
            () -> new ArmorItem(ModArmorMaterials.ORICHALCUM_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(19))));
    public static final DeferredItem<ArmorItem> ORICHALCUM_CHESTPLATE = ITEMS.register("orichalcum_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ORICHALCUM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(19))));
    public static final DeferredItem<ArmorItem> ORICHALCUM_LEGGINGS = ITEMS.register("orichalcum_leggings",
            () -> new ArmorItem(ModArmorMaterials.ORICHALCUM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(19))));
    public static final DeferredItem<ArmorItem> ORICHALCUM_BOOTS = ITEMS.register("orichalcum_boots",
            () -> new ArmorItem(ModArmorMaterials.ORICHALCUM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(19))));
    //Titanite Armor
    public static final DeferredItem<ArmorItem> TITANITE_HELMET = ITEMS.register("titanite_helmet",
            () -> new ArmorItem(ModArmorMaterials.TITANITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(19))));
    public static final DeferredItem<ArmorItem> TITANITE_CHESTPLATE = ITEMS.register("titanite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.TITANITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(19))));
    public static final DeferredItem<ArmorItem> TITANITE_LEGGINGS = ITEMS.register("titanite_leggings",
            () -> new ArmorItem(ModArmorMaterials.TITANITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(19))));
    public static final DeferredItem<ArmorItem> TITANITE_BOOTS = ITEMS.register("titanite_boots",
            () -> new ArmorItem(ModArmorMaterials.TITANITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(19))));
    //Moonstone Armor
    public static final DeferredItem<ArmorItem> MOONSTONE_HELMET = ITEMS.register("moonstone_helmet",
            () -> new MoonstoneArmor(ModArmorMaterials.MOONSTONE_ARMOR_MATERIAL.value(), ArmorItem.Type.HELMET.getSlot()));
    public static final DeferredItem<ArmorItem> MOONSTONE_CHESTPLATE = ITEMS.register("moonstone_chestplate",
            () -> new MoonstoneArmor(ModArmorMaterials.MOONSTONE_ARMOR_MATERIAL.value(), ArmorItem.Type.CHESTPLATE.getSlot()));
    public static final DeferredItem<ArmorItem> MOONSTONE_LEGGINGS = ITEMS.register("moonstone_leggings",
            () -> new MoonstoneArmor(ModArmorMaterials.MOONSTONE_ARMOR_MATERIAL.value(), ArmorItem.Type.LEGGINGS.getSlot()));
    public static final DeferredItem<ArmorItem> MOONSTONE_BOOTS = ITEMS.register("moonstone_boots",
            () -> new MoonstoneArmor(ModArmorMaterials.MOONSTONE_ARMOR_MATERIAL.value(), ArmorItem.Type.BOOTS.getSlot()));
    //Sunstone Armor
    public static final DeferredItem<ArmorItem> SUNSTONE_HELMET = ITEMS.register("sunstone_helmet",
            () -> new MoonstoneArmor(ModArmorMaterials.SUNSTONE_ARMOR_MATERIAL.value(), ArmorItem.Type.HELMET.getSlot()));
    public static final DeferredItem<ArmorItem> SUNSTONE_CHESTPLATE = ITEMS.register("sunstone_chestplate",
            () -> new MoonstoneArmor(ModArmorMaterials.SUNSTONE_ARMOR_MATERIAL.value(), ArmorItem.Type.CHESTPLATE.getSlot()));
    public static final DeferredItem<ArmorItem> SUNSTONE_LEGGINGS = ITEMS.register("sunstone_leggings",
            () -> new MoonstoneArmor(ModArmorMaterials.SUNSTONE_ARMOR_MATERIAL.value(), ArmorItem.Type.LEGGINGS.getSlot()));
    public static final DeferredItem<ArmorItem> SUNSTONE_BOOTS = ITEMS.register("sunstone_boots",
            () -> new MoonstoneArmor(ModArmorMaterials.SUNSTONE_ARMOR_MATERIAL.value(), ArmorItem.Type.BOOTS.getSlot()));
    //Cryolite Armor
    public static final DeferredItem<ArmorItem> CRYOLITE_HELMET = ITEMS.register("cryolite_helmet",
            () -> new MoonstoneArmor(ModArmorMaterials.CRYOLITE_ARMOR_MATERIAL.value(), ArmorItem.Type.HELMET.getSlot()));
    public static final DeferredItem<ArmorItem> CRYOLITE_CHESTPLATE = ITEMS.register("cryolite_chestplate",
            () -> new MoonstoneArmor(ModArmorMaterials.CRYOLITE_ARMOR_MATERIAL.value(), ArmorItem.Type.CHESTPLATE.getSlot()));
    public static final DeferredItem<ArmorItem> CRYOLITE_LEGGINGS = ITEMS.register("cryolite_leggings",
            () -> new MoonstoneArmor(ModArmorMaterials.CRYOLITE_ARMOR_MATERIAL.value(), ArmorItem.Type.LEGGINGS.getSlot()));
    public static final DeferredItem<ArmorItem> CRYOLITE_BOOTS = ITEMS.register("cryolite_boots",
            () -> new MoonstoneArmor(ModArmorMaterials.CRYOLITE_ARMOR_MATERIAL.value(), ArmorItem.Type.BOOTS.getSlot()));

    //Misc
    public static final DeferredItem<Item> TITANITE_SHARD = ITEMS.register("titanite_shard", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TITANITE_DUST = ITEMS.register("titanite_dust", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TITANITE_ROD = ITEMS.register("titanite_rod", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TITANITE_CORE = ITEMS.register("titanite_core", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MOONSTONE_DUST = ITEMS.register("moonstone_dust", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MOON_SHARD = ITEMS.register("moon_shard", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> AETHERIAL_CRYSTAL = ITEMS.register("aetherial_crystal", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CRYOLITE_SHARD = ITEMS.register("cryolite_shard", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ELECTRUM_COIL = ITEMS.register("electrum_coil", () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
