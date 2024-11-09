package com.ubr.aldoria.init;

import com.ubr.aldoria.AldoriaCM;
import com.ubr.aldoria.item.CustomBlockItem;
import com.ubr.aldoria.item.CustomItem;
import com.ubr.aldoria.item.equipment.*;
import com.ubr.aldoria.item.food.HerbalInfusion;
import com.ubr.aldoria.item.food.Stews;
import com.ubr.aldoria.item.misc.*;
import com.ubr.aldoria.item.pouches.PouchItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AldoriaCM.MODID);

    // Items
    public static final DeferredItem<Item> HEARTHSTONE = ITEMS.register("hearthstone", () -> new Hearthstone(new Item.Properties().stacksTo(1), ModTabs.ALDORIA_ITEMS));
    public static final DeferredItem<Item> LUNAR_COMPASS = ITEMS.register("lunar_compass", () -> new LunarCompass(new Item.Properties().stacksTo(1), ModTabs.ALDORIA_ITEMS));
    public static final DeferredItem<Item> MOONLIGHT_LANTERN = ITEMS.register("moonlight_lantern", () -> new MoonlightLantern(new Item.Properties().stacksTo(1), ModTabs.ALDORIA_ITEMS));
    public static final DeferredItem<Item> MOONSTONE_AMULET = ITEMS.register("moonstone_amulet", () -> new MoonstoneAmulet(new Item.Properties().stacksTo(1), ModTabs.ALDORIA_ITEMS));
    public static final DeferredItem<Item> LUNAR_CHARM = ITEMS.register("lunar_charm", () -> new LunarCharm(new Item.Properties().stacksTo(5), ModTabs.ALDORIA_ITEMS));
    public static final DeferredItem<Item> SUNSTONE_AMULET = ITEMS.register("sunstone_amulet", () -> new SunstoneAmulet(new Item.Properties().stacksTo(1), ModTabs.ALDORIA_ITEMS));
    public static final DeferredItem<Item> SUN_STONE = ITEMS.register("sun_stone", () -> new SunStone(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> AETHERIAL_QUARTZ_AMULET = ITEMS.register("aetherial_quartz_amulet", () -> new AtherialQuartzAmulet(new Item.Properties().stacksTo(1), ModTabs.ALDORIA_ITEMS));
    public static final DeferredItem<Item> CRYSTALLIZED_ESSENCE = ITEMS.register("crystallized_essence", () -> new CrystallizedEssenceItem(new Item.Properties(), ModTabs.ALDORIA_ITEMS));
    public static final DeferredItem<Item> PURIFIED_STONE = ITEMS.register("purified_stone", () -> new PurifiedStoneItem(new Item.Properties(), ModTabs.ALDORIA_ITEMS));
    public static final DeferredItem<Item> ETHEREAL_SHARD = ITEMS.register("ethereal_shard", () -> new EtherealShardItem(new Item.Properties(), ModTabs.ALDORIA_ITEMS));

    // Ingots
    public static final DeferredItem<Item> ORICHALCUM_INGOT = ITEMS.register("orichalcum_ingot",
            () -> new CustomItem(new Item.Properties(), ModTabs.ALDORIA_ITEMS));
    public static final DeferredItem<Item> SUNSTONE_INGOT = ITEMS.register("sunstone_ingot",
            () -> new CustomItem(new Item.Properties(), ModTabs.ALDORIA_ITEMS));
    public static final DeferredItem<Item> CRYOLITE_INGOT = ITEMS.register("cryolite_ingot",
            () -> new CustomItem(new Item.Properties(), ModTabs.ALDORIA_ITEMS));
    public static final DeferredItem<Item> ELECTRUM_INGOT = ITEMS.register("electrum_ingot",
            () -> new CustomItem(new Item.Properties(), ModTabs.ALDORIA_ITEMS));

    // Orichalcum Tools
    public static final DeferredItem<SwordItem> ORICHALCUM_SWORD = ITEMS.register("orichalcum_sword",
            () -> new CustomSwordItem(ModTiers.ORICHALCUM, 3, -2.4F, new Item.Properties(), ModTabs.ALDORIA_EQUIPMENT));
    public static final DeferredItem<PickaxeItem> ORICHALCUM_PICKAXE = ITEMS.register("orichalcum_pickaxe",
            () -> new CustomPickaxeItem(ModTiers.ORICHALCUM, 1, -2.8f, new Item.Properties(), ModTabs.ALDORIA_EQUIPMENT));
    public static final DeferredItem<ShovelItem> ORICHALCUM_SHOVEL = ITEMS.register("orichalcum_shovel",
            () -> new CustomShovelItem(ModTiers.ORICHALCUM, 1.5F, -3.0f, new Item.Properties(), ModTabs.ALDORIA_EQUIPMENT));
    public static final DeferredItem<AxeItem> ORICHALCUM_AXE = ITEMS.register("orichalcum_axe",
            () -> new CustomAxeItem(ModTiers.ORICHALCUM, 6.0F, -3.2f, new Item.Properties(), ModTabs.ALDORIA_EQUIPMENT));
    public static final DeferredItem<HoeItem> ORICHALCUM_HOE = ITEMS.register("orichalcum_hoe",
            () -> new CustomHoeItem(ModTiers.ORICHALCUM, 0, -3.0f, new Item.Properties(), ModTabs.ALDORIA_EQUIPMENT));

    // Titanite Tools
    public static final DeferredItem<SwordItem> TITANITE_SWORD = ITEMS.register("titanite_sword",
            () -> new CustomSwordItem(ModTiers.TITANITE, 5, -2.4f, new Item.Properties(), ModTabs.ALDORIA_EQUIPMENT));
    public static final DeferredItem<PickaxeItem> TITANITE_PICKAXE = ITEMS.register("titanite_pickaxe",
            () -> new CustomPickaxeItem(ModTiers.TITANITE, 1, -2.8f, new Item.Properties(), ModTabs.ALDORIA_EQUIPMENT));
    public static final DeferredItem<ShovelItem> TITANITE_SHOVEL = ITEMS.register("titanite_shovel",
            () -> new CustomShovelItem(ModTiers.TITANITE, 1.5F, -3.0f, new Item.Properties(), ModTabs.ALDORIA_EQUIPMENT));
    public static final DeferredItem<AxeItem> TITANITE_AXE = ITEMS.register("titanite_axe",
            () -> new CustomAxeItem(ModTiers.TITANITE, 6.0F, -3.2f, new Item.Properties(), ModTabs.ALDORIA_EQUIPMENT));
    public static final DeferredItem<HoeItem> TITANITE_HOE = ITEMS.register("titanite_hoe",
            () -> new CustomHoeItem(ModTiers.TITANITE, 0, -3.0f, new Item.Properties(), ModTabs.ALDORIA_EQUIPMENT));

    // Moonstone Tools
    public static final DeferredItem<SwordItem> MOONSTONE_SWORD = ITEMS.register("moonstone_sword",
            () -> new CustomSwordItem(ModTiers.MOONSTONE, 5, -2.4f, new Item.Properties(), ModTabs.ALDORIA_EQUIPMENT));
    public static final DeferredItem<PickaxeItem> MOONSTONE_PICKAXE = ITEMS.register("moonstone_pickaxe",
            () -> new CustomPickaxeItem(ModTiers.MOONSTONE, 1, -2.8f, new Item.Properties(), ModTabs.ALDORIA_EQUIPMENT));
    public static final DeferredItem<ShovelItem> MOONSTONE_SHOVEL = ITEMS.register("moonstone_shovel",
            () -> new CustomShovelItem(ModTiers.MOONSTONE, 1.5F, -3.0f, new Item.Properties(), ModTabs.ALDORIA_EQUIPMENT));
    public static final DeferredItem<AxeItem> MOONSTONE_AXE = ITEMS.register("moonstone_axe",
            () -> new CustomAxeItem(ModTiers.MOONSTONE,6.0F, -3.2f, new Item.Properties(), ModTabs.ALDORIA_EQUIPMENT));
    public static final DeferredItem<HoeItem> MOONSTONE_HOE = ITEMS.register("moonstone_hoe",
            () -> new CustomHoeItem(ModTiers.MOONSTONE, 0, -3.0f, new Item.Properties(), ModTabs.ALDORIA_EQUIPMENT));
    // Sunstone Tools
    public static final DeferredItem<SwordItem> SUNSTONE_SWORD = ITEMS.register("sunstone_sword",
            () -> new CustomSwordItem(ModTiers.SUNSTONE, 5, -2.4f, new Item.Properties(), ModTabs.ALDORIA_EQUIPMENT));
    public static final DeferredItem<PickaxeItem> SUNSTONE_PICKAXE = ITEMS.register("sunstone_pickaxe",
            () -> new CustomPickaxeItem(ModTiers.SUNSTONE, 1, -2.8f, new Item.Properties(), ModTabs.ALDORIA_EQUIPMENT));
    public static final DeferredItem<ShovelItem> SUNSTONE_SHOVEL = ITEMS.register("sunstone_shovel",
            () -> new CustomShovelItem(ModTiers.SUNSTONE, 1.5F, -3.0f, new Item.Properties(), ModTabs.ALDORIA_EQUIPMENT));
    public static final DeferredItem<AxeItem> SUNSTONE_AXE = ITEMS.register("sunstone_axe",
            () -> new CustomAxeItem(ModTiers.SUNSTONE, 6.0F, -3.2f, new Item.Properties(), ModTabs.ALDORIA_EQUIPMENT));
    public static final DeferredItem<HoeItem> SUNSTONE_HOE = ITEMS.register("sunstone_hoe",
            () -> new CustomHoeItem(ModTiers.SUNSTONE, 0, -3.0f, new Item.Properties(), ModTabs.ALDORIA_EQUIPMENT));

    // Cryolite Tools
    public static final DeferredItem<SwordItem> CRYOLITE_SWORD = ITEMS.register("cryolite_sword",
            () -> new CustomSwordItem(ModTiers.CRYOLITE, 5, -2.4f, new Item.Properties(), ModTabs.ALDORIA_EQUIPMENT));
    public static final DeferredItem<PickaxeItem> CRYOLITE_PICKAXE = ITEMS.register("cryolite_pickaxe",
            () -> new CustomPickaxeItem(ModTiers.CRYOLITE, 1, -2.8f, new Item.Properties(), ModTabs.ALDORIA_EQUIPMENT));
    public static final DeferredItem<ShovelItem> CRYOLITE_SHOVEL = ITEMS.register("cryolite_shovel",
            () -> new CustomShovelItem(ModTiers.CRYOLITE, 1.5F, -3.0f, new Item.Properties(), ModTabs.ALDORIA_EQUIPMENT));
    public static final DeferredItem<AxeItem> CRYOLITE_AXE = ITEMS.register("cryolite_axe",
            () -> new CustomAxeItem(ModTiers.CRYOLITE, 6.0F, -3.2f, new Item.Properties(), ModTabs.ALDORIA_EQUIPMENT));
    public static final DeferredItem<HoeItem> CRYOLITE_HOE = ITEMS.register("cryolite_hoe",
            () -> new CustomHoeItem(ModTiers.CRYOLITE, 0, -3.0f, new Item.Properties(), ModTabs.ALDORIA_EQUIPMENT));

    // Electrum Tools
    public static final DeferredItem<SwordItem> ELECTRUM_SWORD = ITEMS.register("electrum_sword",
            () -> new CustomSwordItem(ModTiers.ELECTRUM, 5, -2.4f, new Item.Properties(), ModTabs.ALDORIA_EQUIPMENT));
    public static final DeferredItem<PickaxeItem> ELECTRUM_PICKAXE = ITEMS.register("electrum_pickaxe",
            () -> new CustomPickaxeItem(ModTiers.ELECTRUM, 1, -2.8f, new Item.Properties(), ModTabs.ALDORIA_EQUIPMENT));
    public static final DeferredItem<ShovelItem> ELECTRUM_SHOVEL = ITEMS.register("electrum_shovel",
            () -> new CustomShovelItem(ModTiers.ELECTRUM, 1.5F, -3.0f, new Item.Properties(), ModTabs.ALDORIA_EQUIPMENT));
    public static final DeferredItem<AxeItem> ELECTRUM_AXE = ITEMS.register("electrum_axe",
            () -> new CustomAxeItem(ModTiers.ELECTRUM, 6, -3.2f, new Item.Properties(), ModTabs.ALDORIA_EQUIPMENT));
    public static final DeferredItem<HoeItem> ELECTRUM_HOE = ITEMS.register("electrum_hoe",
            () -> new CustomHoeItem(ModTiers.ELECTRUM, 0, -3.0f, new Item.Properties(), ModTabs.ALDORIA_EQUIPMENT));

    // Orichalcum Armor
    public static final DeferredItem<ArmorItem> ORICHALCUM_HELMET = ITEMS.register("orichalcum_helmet",
            () -> new TitaniteArmor(ModArmorMaterials.ORICHALCUM_ARMOR_MATERIAL.value(), ArmorItem.Type.HELMET.getSlot(),
                    ModTabs.ALDORIA_EQUIPMENT, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(19))));
    public static final DeferredItem<ArmorItem> ORICHALCUM_CHESTPLATE = ITEMS.register("orichalcum_chestplate",
            () -> new TitaniteArmor(ModArmorMaterials.ORICHALCUM_ARMOR_MATERIAL.value(), ArmorItem.Type.CHESTPLATE.getSlot(),
                    ModTabs.ALDORIA_EQUIPMENT, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(19))));
    public static final DeferredItem<ArmorItem> ORICHALCUM_LEGGINGS = ITEMS.register("orichalcum_leggings",
            () -> new TitaniteArmor(ModArmorMaterials.ORICHALCUM_ARMOR_MATERIAL.value(), ArmorItem.Type.LEGGINGS.getSlot(),
                    ModTabs.ALDORIA_EQUIPMENT, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(19))));
    public static final DeferredItem<ArmorItem> ORICHALCUM_BOOTS = ITEMS.register("orichalcum_boots",
            () -> new TitaniteArmor(ModArmorMaterials.ORICHALCUM_ARMOR_MATERIAL.value(), ArmorItem.Type.BOOTS.getSlot(),
                    ModTabs.ALDORIA_EQUIPMENT, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(19))));
    // Titanite Armor
    public static final DeferredItem<ArmorItem> TITANITE_HELMET = ITEMS.register("titanite_helmet",
            () -> new TitaniteArmor(ModArmorMaterials.TITANITE_ARMOR_MATERIAL.value(), ArmorItem.Type.HELMET.getSlot(),
                    ModTabs.ALDORIA_EQUIPMENT, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(19))));
    public static final DeferredItem<ArmorItem> TITANITE_CHESTPLATE = ITEMS.register("titanite_chestplate",
            () -> new TitaniteArmor(ModArmorMaterials.TITANITE_ARMOR_MATERIAL.value(), ArmorItem.Type.CHESTPLATE.getSlot(),
                    ModTabs.ALDORIA_EQUIPMENT, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(19))));
    public static final DeferredItem<ArmorItem> TITANITE_LEGGINGS = ITEMS.register("titanite_leggings",
            () -> new TitaniteArmor(ModArmorMaterials.TITANITE_ARMOR_MATERIAL.value(), ArmorItem.Type.LEGGINGS.getSlot(),
                    ModTabs.ALDORIA_EQUIPMENT, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(19))));
    public static final DeferredItem<ArmorItem> TITANITE_BOOTS = ITEMS.register("titanite_boots",
            () -> new TitaniteArmor(ModArmorMaterials.TITANITE_ARMOR_MATERIAL.value(), ArmorItem.Type.BOOTS.getSlot(),
                    ModTabs.ALDORIA_EQUIPMENT, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(19))));

    // Moonstone Armor
    public static final DeferredItem<ArmorItem> MOONSTONE_HELMET = ITEMS.register("moonstone_helmet",
            () -> new MoonstoneArmor(ModArmorMaterials.MOONSTONE_ARMOR_MATERIAL.value(), ArmorItem.Type.HELMET.getSlot(), ModTabs.ALDORIA_EQUIPMENT));
    public static final DeferredItem<ArmorItem> MOONSTONE_CHESTPLATE = ITEMS.register("moonstone_chestplate",
            () -> new MoonstoneArmor(ModArmorMaterials.MOONSTONE_ARMOR_MATERIAL.value(), ArmorItem.Type.CHESTPLATE.getSlot(), ModTabs.ALDORIA_EQUIPMENT));
    public static final DeferredItem<ArmorItem> MOONSTONE_LEGGINGS = ITEMS.register("moonstone_leggings",
            () -> new MoonstoneArmor(ModArmorMaterials.MOONSTONE_ARMOR_MATERIAL.value(), ArmorItem.Type.LEGGINGS.getSlot(), ModTabs.ALDORIA_EQUIPMENT));
    public static final DeferredItem<ArmorItem> MOONSTONE_BOOTS = ITEMS.register("moonstone_boots",
            () -> new MoonstoneArmor(ModArmorMaterials.MOONSTONE_ARMOR_MATERIAL.value(), ArmorItem.Type.BOOTS.getSlot(), ModTabs.ALDORIA_EQUIPMENT));

    // Sunstone Armor
    public static final DeferredItem<ArmorItem> SUNSTONE_HELMET = ITEMS.register("sunstone_helmet",
            () -> new SunstoneArmor(ModArmorMaterials.SUNSTONE_ARMOR_MATERIAL.value(), ArmorItem.Type.HELMET.getSlot(), ModTabs.ALDORIA_EQUIPMENT));
    public static final DeferredItem<ArmorItem> SUNSTONE_CHESTPLATE = ITEMS.register("sunstone_chestplate",
            () -> new SunstoneArmor(ModArmorMaterials.SUNSTONE_ARMOR_MATERIAL.value(), ArmorItem.Type.CHESTPLATE.getSlot(), ModTabs.ALDORIA_EQUIPMENT));
    public static final DeferredItem<ArmorItem> SUNSTONE_LEGGINGS = ITEMS.register("sunstone_leggings",
            () -> new SunstoneArmor(ModArmorMaterials.SUNSTONE_ARMOR_MATERIAL.value(), ArmorItem.Type.LEGGINGS.getSlot(), ModTabs.ALDORIA_EQUIPMENT));
    public static final DeferredItem<ArmorItem> SUNSTONE_BOOTS = ITEMS.register("sunstone_boots",
            () -> new SunstoneArmor(ModArmorMaterials.SUNSTONE_ARMOR_MATERIAL.value(), ArmorItem.Type.BOOTS.getSlot(), ModTabs.ALDORIA_EQUIPMENT));

    // Cryolite Armor
    public static final DeferredItem<ArmorItem> CRYOLITE_HELMET = ITEMS.register("cryolite_helmet",
            () -> new CryoliteArmor(ModArmorMaterials.CRYOLITE_ARMOR_MATERIAL.value(), ArmorItem.Type.HELMET.getSlot(), ModTabs.ALDORIA_EQUIPMENT));
    public static final DeferredItem<ArmorItem> CRYOLITE_CHESTPLATE = ITEMS.register("cryolite_chestplate",
            () -> new CryoliteArmor(ModArmorMaterials.CRYOLITE_ARMOR_MATERIAL.value(), ArmorItem.Type.CHESTPLATE.getSlot(), ModTabs.ALDORIA_EQUIPMENT));
    public static final DeferredItem<ArmorItem> CRYOLITE_LEGGINGS = ITEMS.register("cryolite_leggings",
            () -> new CryoliteArmor(ModArmorMaterials.CRYOLITE_ARMOR_MATERIAL.value(), ArmorItem.Type.LEGGINGS.getSlot(), ModTabs.ALDORIA_EQUIPMENT));
    public static final DeferredItem<ArmorItem> CRYOLITE_BOOTS = ITEMS.register("cryolite_boots",
            () -> new CryoliteArmor(ModArmorMaterials.CRYOLITE_ARMOR_MATERIAL.value(), ArmorItem.Type.BOOTS.getSlot(), ModTabs.ALDORIA_EQUIPMENT));

    // Misc Items
    public static final DeferredItem<Item> TITANITE_SHARD = ITEMS.register("titanite_shard", () -> new CustomItem(new Item.Properties(), ModTabs.ALDORIA_ITEMS));
    public static final DeferredItem<Item> TITANITE_DUST = ITEMS.register("titanite_dust", () -> new CustomItem(new Item.Properties(), ModTabs.ALDORIA_ITEMS));
    public static final DeferredItem<Item> TITANITE_ROD = ITEMS.register("titanite_rod", () -> new CustomItem(new Item.Properties(), ModTabs.ALDORIA_ITEMS));
    public static final DeferredItem<Item> TITANITE_CORE = ITEMS.register("titanite_core", () -> new CustomItem(new Item.Properties(), ModTabs.ALDORIA_ITEMS));
    public static final DeferredItem<Item> MOONSTONE_DUST = ITEMS.register("moonstone_dust", () -> new CustomItem(new Item.Properties(), ModTabs.ALDORIA_ITEMS));
    public static final DeferredItem<Item> MOON_SHARD = ITEMS.register("moon_shard", () -> new CustomItem(new Item.Properties(), ModTabs.ALDORIA_ITEMS));
    public static final DeferredItem<Item> AETHERIAL_CRYSTAL = ITEMS.register("aetherial_crystal", () -> new CustomItem(new Item.Properties(), ModTabs.ALDORIA_ITEMS));
    public static final DeferredItem<Item> CRYOLITE_SHARD = ITEMS.register("cryolite_shard", () -> new CustomItem(new Item.Properties(), ModTabs.ALDORIA_ITEMS));
    public static final DeferredItem<Item> ELECTRUM_COIL = ITEMS.register("electrum_coil", () -> new CustomItem(new Item.Properties(), ModTabs.ALDORIA_ITEMS));


    //Apothecary Items
    public static final DeferredItem<Item> ESSENCE_EXTRACTOR = ITEMS.register("essence_extractor",
            () -> new EssenceExtractorItem(new Item.Properties(), ModTabs.ALDORIA_APOTHECARY));

    // Pouch Items
    public static final DeferredItem<Item> HERBAL_POUCH = ITEMS.register("herbal_pouch",
            () -> new PouchItem(new Item.Properties().stacksTo(1), ModTabs.ALDORIA_POUCHES));
    public static final DeferredItem<Item> SEED_POUCH = ITEMS.register("seed_pouch",
            () -> new PouchItem(new Item.Properties().stacksTo(1), ModTabs.ALDORIA_POUCHES));
    public static final DeferredItem<Item> FLOWER_POUCH = ITEMS.register("flower_pouch",
            () -> new PouchItem(new Item.Properties().stacksTo(1), ModTabs.ALDORIA_POUCHES));
    public static final DeferredItem<Item> ROOT_POUCH = ITEMS.register("root_pouch",
            () -> new PouchItem(new Item.Properties().stacksTo(1), ModTabs.ALDORIA_POUCHES));

    // Root Stews
    public static final DeferredItem<Item> SUNCHOKE_STEW = ITEMS.register("sunchoke_stew",
            () -> new Stews(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.8f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> MISO_PEA_STEW = ITEMS.register("miso_pea_stew",
            () -> new Stews(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().nutrition(7).saturationModifier(0.7f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> SPICY_RADISH_STEW = ITEMS.register("spicy_radish_stew",
            () -> new Stews(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.6f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> GOLDEN_CORN_CHOWDER = ITEMS.register("golden_corn_chowder",
            () -> new Stews(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().nutrition(10).saturationModifier(0.9f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> CABBAGE_SOUP = ITEMS.register("cabbage_soup",
            () -> new Stews(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.6f).build()), ModTabs.ALDORIA_FOODS));

    // Herbal Infusions
    public static final DeferredItem<Item> CHAMOMILE_TEA = ITEMS.register("chamomile_tea",
            () -> new HerbalInfusion(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().saturationModifier(0.5f).build()), ModTabs.ALDORIA_APOTHECARY));
    public static final DeferredItem<Item> GINGER_TEA = ITEMS.register("ginger_tea",
            () -> new HerbalInfusion(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().saturationModifier(0.4f).build()), ModTabs.ALDORIA_APOTHECARY));
    public static final DeferredItem<Item> MINT_INFUSION = ITEMS.register("mint_infusion",
            () -> new HerbalInfusion(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().saturationModifier(0.4f).build()), ModTabs.ALDORIA_APOTHECARY));
    public static final DeferredItem<Item> LAVENDER_BREW = ITEMS.register("lavender_brew",
            () -> new HerbalInfusion(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().saturationModifier(0.4f).build()), ModTabs.ALDORIA_APOTHECARY));
    public static final DeferredItem<Item> ELDERFLOWER_CORDIAL = ITEMS.register("elderflower_cordial",
            () -> new HerbalInfusion(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().saturationModifier(0.4f).build()), ModTabs.ALDORIA_APOTHECARY));
    public static final DeferredItem<Item> ROSEMARY_TONIC = ITEMS.register("rosemary_tonic",
            () -> new HerbalInfusion(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().saturationModifier(0.4f).build()), ModTabs.ALDORIA_APOTHECARY));
    public static final DeferredItem<Item> THYME_INFUSION = ITEMS.register("thyme_infusion",
            () -> new HerbalInfusion(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().saturationModifier(0.4f).build()), ModTabs.ALDORIA_APOTHECARY));
    public static final DeferredItem<Item> HIBISCUS_COOLER = ITEMS.register("hibiscus_cooler",
            () -> new HerbalInfusion(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().saturationModifier(0.4f).build()), ModTabs.ALDORIA_APOTHECARY));
    public static final DeferredItem<Item> BASIL_BREW = ITEMS.register("basil_brew",
            () -> new HerbalInfusion(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().saturationModifier(0.4f).build()), ModTabs.ALDORIA_APOTHECARY));
    public static final DeferredItem<Item> SAGE_SERUM = ITEMS.register("sage_serum",
            () -> new HerbalInfusion(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().saturationModifier(0.4f).build()), ModTabs.ALDORIA_APOTHECARY));
    public static final DeferredItem<Item> CILANTRO_TINCTURE = ITEMS.register("cilantro_tincture",
            () -> new HerbalInfusion(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().saturationModifier(0.4f).build()), ModTabs.ALDORIA_APOTHECARY));
    public static final DeferredItem<Item> LEMON_BALM_INFUSION = ITEMS.register("lemon_balm_infusion",
            () -> new HerbalInfusion(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().saturationModifier(0.4f).build()), ModTabs.ALDORIA_APOTHECARY));
    public static final DeferredItem<Item> PARSLEY_POTION = ITEMS.register("parsley_potion",
            () -> new HerbalInfusion(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().saturationModifier(0.4f).build()), ModTabs.ALDORIA_APOTHECARY));
    public static final DeferredItem<Item> DANDELION_ELIXIR = ITEMS.register("dandelion_elixir",
            () -> new HerbalInfusion(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().saturationModifier(0.4f).build()), ModTabs.ALDORIA_APOTHECARY));

    // Crop Items and Seeds
    public static final DeferredItem<Item> MYSTIC_TUBER = ITEMS.register("mystic_tuber",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.2f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> MYSTIC_TUBER_SEEDS = ITEMS.register("mystic_tuber_seeds",
            () -> new CustomBlockItem(ModBlocks.MYSTIC_TUBER_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> NIGHTSHADE_BERRY = ITEMS.register("nightshade_berry",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> NIGHTSHADE_BERRY_SEEDS = ITEMS.register("nightshade_berry_seeds",
            () -> new CustomBlockItem(ModBlocks.NIGHTSHADE_BERRY_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> BASILISK_ROOT = ITEMS.register("basilisk_root",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.2f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> BASILISK_ROOT_SEEDS = ITEMS.register("basilisk_root_seeds",
            () -> new CustomBlockItem(ModBlocks.BASILISK_ROOT_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> BASIL = ITEMS.register("basilisk_root",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.2f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> BASIL_SEEDS = ITEMS.register("basilisk_root_seeds",
            () -> new CustomBlockItem(ModBlocks.BASILISK_ROOT_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> SILVERWEED = ITEMS.register("silverweed",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> SILVERWEED_SEEDS = ITEMS.register("silverweed_seeds",
            () -> new CustomBlockItem(ModBlocks.SILVERWEED_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> GINGER_ROOT = ITEMS.register("ginger_root",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> GINGER_ROOT_SEEDS = ITEMS.register("ginger_root_seeds",
            () -> new CustomBlockItem(ModBlocks.GINGER_ROOT_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> ALOE_VERA = ITEMS.register("aloe_vera",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> ALOE_VERA_SEEDS = ITEMS.register("aloe_vera_seeds",
            () -> new CustomBlockItem(ModBlocks.ALOE_VERA_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> TURMERIC = ITEMS.register("turmeric",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> TURMERIC_SEEDS = ITEMS.register("turmeric_seeds",
            () -> new CustomBlockItem(ModBlocks.TURMERIC_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> HOLY_BASIL = ITEMS.register("holy_basil",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> HOLY_BASIL_SEEDS = ITEMS.register("holy_basil_seeds",
            () -> new CustomBlockItem(ModBlocks.HOLY_BASIL_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> DANDELION = ITEMS.register("dandelion",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> DANDELION_SEEDS = ITEMS.register("dandelion_seeds",
            () -> new CustomBlockItem(ModBlocks.DANDELION_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> VALERIAN_ROOT = ITEMS.register("valerian_root",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> VALERIAN_ROOT_SEEDS = ITEMS.register("valerian_root_seeds",
            () -> new CustomBlockItem(ModBlocks.VALERIAN_ROOT_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> GARLIC = ITEMS.register("garlic",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> GARLIC_SEEDS = ITEMS.register("garlic_seeds",
            () -> new CustomBlockItem(ModBlocks.GARLIC_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> NETTLE = ITEMS.register("nettle",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> NETTLE_SEEDS = ITEMS.register("nettle_seeds",
            () -> new CustomBlockItem(ModBlocks.NETTLE_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> LICORICE_ROOT = ITEMS.register("licorice_root",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> LICORICE_ROOT_SEEDS = ITEMS.register("licorice_root_seeds",
            () -> new CustomBlockItem(ModBlocks.LICORICE_ROOT_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> COMFREY = ITEMS.register("comfrey",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> COMFREY_SEEDS = ITEMS.register("comfrey_seeds",
            () -> new CustomBlockItem(ModBlocks.COMFREY_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> CATNIP = ITEMS.register("catnip",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> CATNIP_SEEDS = ITEMS.register("catnip_seeds",
            () -> new CustomBlockItem(ModBlocks.CATNIP_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> GINSENG = ITEMS.register("ginseng",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> GINSENG_SEEDS = ITEMS.register("ginseng_seeds",
            () -> new CustomBlockItem(ModBlocks.GINSENG_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> YARROW = ITEMS.register("yarrow",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> YARROW_SEEDS = ITEMS.register("yarrow_seeds",
            () -> new CustomBlockItem(ModBlocks.YARROW_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> ASHWAGANDHA = ITEMS.register("ashwagandha",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> ASHWAGANDHA_SEEDS = ITEMS.register("ashwagandha_seeds",
            () -> new CustomBlockItem(ModBlocks.ASHWAGANDHA_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> FEVERFEW = ITEMS.register("feverfew",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> FEVERFEW_SEEDS = ITEMS.register("feverfew_seeds",
            () -> new CustomBlockItem(ModBlocks.FEVERFEW_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> MILK_THISTLE = ITEMS.register("milk_thistle",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> MILK_THISTLE_SEEDS = ITEMS.register("milk_thistle_seeds",
            () -> new CustomBlockItem(ModBlocks.MILK_THISTLE_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> STARFRUIT = ITEMS.register("starfruit",
            () -> new CustomItem(new Item.Properties().food(ModFoods.STARFRUIT), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> STARFRUIT_SEEDS = ITEMS.register("starfruit_seeds",
            () -> new CustomBlockItem(ModBlocks.STARFRUIT_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> MYSTIC_BERRY_SEEDS = ITEMS.register("mystic_berry_seeds",
            () -> new ItemNameBlockItem(ModBlocks.MYSTIC_BERRY_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> MYSTIC_BERRY = ITEMS.register("mystic_berry",
            () -> new CustomItem(new Item.Properties().food(ModFoods.MYSTIC_BERRY), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> PUMPKIN_PEPPER = ITEMS.register("pumpkin_pepper",
            () -> new CustomItem(new Item.Properties().food(ModFoods.PUMPKIN_PEPPER), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> PUMPKIN_PEPPER_SEEDS = ITEMS.register("pumpkin_pepper_seeds",
            () -> new CustomBlockItem(ModBlocks.PUMPKIN_PEPPER_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> HONEYDEW_MELON = ITEMS.register("honeydew_melon",
            () -> new CustomItem(new Item.Properties().food(ModFoods.HONEYDEW_MELON), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> HONEYDEW_MELON_SEEDS = ITEMS.register("honeydew_melon_seeds",
            () -> new CustomBlockItem(ModBlocks.HONEYDEW_MELON_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> RED_QUINOA = ITEMS.register("red_quinoa",
            () -> new CustomItem(new Item.Properties().food(ModFoods.RED_QUINOA), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> RED_QUINOA_SEEDS = ITEMS.register("red_quinoa_seeds",
            () -> new CustomBlockItem(ModBlocks.RED_QUINOA_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> GOLDEN_CORN = ITEMS.register("golden_corn",
            () -> new CustomItem(new Item.Properties().food(ModFoods.GOLDEN_CORN), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> GOLDEN_CORN_SEEDS = ITEMS.register("golden_corn_seeds",
            () -> new CustomBlockItem(ModBlocks.GOLDEN_CORN_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> SPICY_RADISH = ITEMS.register("spicy_radish",
            () -> new CustomItem(new Item.Properties().food(ModFoods.SPICY_RADISH), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> SPICY_RADISH_SEEDS = ITEMS.register("spicy_radish_seeds",
            () -> new CustomBlockItem(ModBlocks.SPICY_RADISH_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> CABBAGE = ITEMS.register("cabbage",
            () -> new CustomItem(new Item.Properties().food(ModFoods.CABBAGE), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> CABBAGE_SEEDS = ITEMS.register("cabbage_seeds",
            () -> new CustomBlockItem(ModBlocks.CABBAGE_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> SUNCHOKE = ITEMS.register("sunchokes",
            () -> new CustomItem(new Item.Properties().food(ModFoods.SUNCHOKE), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> SUNCHOKE_SEEDS = ITEMS.register("sunchokes_seeds",
            () -> new CustomBlockItem(ModBlocks.SUNCHOKE_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> CHILI_BEANS = ITEMS.register("chili_beans",
            () -> new CustomItem(new Item.Properties().food(ModFoods.CHILI_BEANS), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> CHILI_BEANS_SEEDS = ITEMS.register("chili_beans_seeds",
            () -> new CustomBlockItem(ModBlocks.CHILI_BEAN_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> MISO_PEAS = ITEMS.register("miso_peas",
            () -> new CustomItem(new Item.Properties().food(ModFoods.MISO_PEAS), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> MISO_PEAS_SEEDS = ITEMS.register("miso_peas_seeds",
            () -> new CustomBlockItem(ModBlocks.MISO_PEA_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> BLACKBERRIES = ITEMS.register("blackberries",
            () -> new CustomItem(new Item.Properties().food(ModFoods.BLACKBERRIES), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> BLACKBERRIES_SEEDS = ITEMS.register("blackberries_seeds",
            () -> new CustomBlockItem(ModBlocks.BLACKBERRY_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> DRAGONFRUIT = ITEMS.register("blackberries",
            () -> new CustomItem(new Item.Properties().food(ModFoods.DRAGONFRUIT), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> DRAGONFRUIT_SEEDS = ITEMS.register("blackberries_seeds",
            () -> new CustomBlockItem(ModBlocks.DRAGONFRUIT_VINE_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> SILVER_MILLET = ITEMS.register("silver_millet",
            () -> new CustomItem(new Item.Properties().food(ModFoods.SILVER_MILLET), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> SILVER_MILLET_SEEDS = ITEMS.register("silver_millet_seeds",
            () -> new CustomBlockItem(ModBlocks.SILVER_MILLET_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> BLOOD_BERRIES = ITEMS.register("blood_berries",
            () -> new CustomItem(new Item.Properties().food(ModFoods.BLOOD_BERRIES), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> BLOOD_BERRY_SEEDS = ITEMS.register("blood_berry_seeds",
            () -> new CustomBlockItem(ModBlocks.BLOOD_BERRY_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> FROST_BERRY = ITEMS.register("frost_berry",
            () -> new CustomItem(new Item.Properties().food(ModFoods.FROST_BERRY), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> FROST_BERRY_SEEDS = ITEMS.register("frost_berry_seeds",
            () -> new CustomBlockItem(ModBlocks.FROST_BERRY_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> LUMINOUS_LEEK = ITEMS.register("luminous_leek",
            () -> new CustomItem(new Item.Properties().food(ModFoods.LUMINOUS_LEEK), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> LUMINOUS_LEEK_SEEDS = ITEMS.register("luminous_leek_seeds",
            () -> new CustomBlockItem(ModBlocks.LUMINOUS_LEEK_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> MOON_TURNIP = ITEMS.register("moon_turnip",
            () -> new CustomItem(new Item.Properties().food(ModFoods.MOON_TURNIP), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> MOON_TURNIP_SEEDS = ITEMS.register("moon_turnip_seeds",
            () -> new CustomBlockItem(ModBlocks.MOON_TURNIP_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> GHOST_CHILI_PEPPER = ITEMS.register("ghost_chili_pepper",
            () -> new CustomItem(new Item.Properties().food(ModFoods.GHOST_CHILI_PEPPER), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> GHOST_CHILI_PEPPER_SEEDS = ITEMS.register("ghost_chili_pepper_seeds",
            () -> new CustomBlockItem(ModBlocks.GHOST_CHILI_PEPPER_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> TWILIGHT_GOURD = ITEMS.register("twilight_gourd",
            () -> new CustomItem(new Item.Properties().food(ModFoods.TWILIGHT_GOURD), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> TWILIGHT_GOURD_SEEDS = ITEMS.register("twilight_gourd_seeds",
            () -> new CustomBlockItem(ModBlocks.TWILIGHT_GOURD_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> DEWDROP_CUCUMBER = ITEMS.register("dewdrop_cucumber",
            () -> new CustomItem(new Item.Properties().food(ModFoods.DEWDROP_CUCUMBER), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> DEWDROP_CUCUMBER_SEEDS = ITEMS.register("dewdrop_cucumber_seeds",
            () -> new CustomBlockItem(ModBlocks.DEWDROP_CUCUMBER_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> GOLDEN_QUINOA = ITEMS.register("golden_quinoa",
            () -> new CustomItem(new Item.Properties().food(ModFoods.GOLDEN_QUINOA), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> GOLDEN_QUINOA_SEEDS = ITEMS.register("golden_quinoa_seeds",
            () -> new CustomBlockItem(ModBlocks.GOLDEN_QUINOA_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> AETHEREAL_RICE = ITEMS.register("aethereal_rice",
            () -> new CustomItem(new Item.Properties().food(ModFoods.AETHERIAL_RICE), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> AETHEREAL_RICE_SEEDS = ITEMS.register("aethereal_rice",
            () -> new CustomBlockItem(ModBlocks.AETHERIAL_RICE_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> RAINBOW_BELL_PEPPERS = ITEMS.register("rainbow_bell_peppers",
            () -> new CustomItem(new Item.Properties().food(ModFoods.RAINBOW_BELL_PEPPER), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> RAINBOW_BELL_PEPPER_SEEDS = ITEMS.register("rainbow_bell_pepper_seeds",
            () -> new CustomBlockItem(ModBlocks.RAINBOW_BELL_PEPPER_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> CRYSTAL_TOMATOES = ITEMS.register("aethereal_rice",
            () -> new CustomItem(new Item.Properties().food(ModFoods.CRYSTAL_TOMATO), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> CRYSTAL_TOMATO_SEEDS = ITEMS.register("aethereal_rice",
            () -> new CustomBlockItem(ModBlocks.CRYSTAL_TOMATO_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> CHILLING_GARLIC = ITEMS.register("aethereal_rice",
            () -> new CustomItem(new Item.Properties().food(ModFoods.CHILLING_GARLIC), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> CHILLING_GARLIC_SEEDS = ITEMS.register("aethereal_rice",
            () -> new CustomBlockItem(ModBlocks.CHILLING_GARLIC_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));
    public static final DeferredItem<Item> WHIMSICAL_ONIONS = ITEMS.register("aethereal_rice",
            () -> new CustomItem(new Item.Properties().food(ModFoods.WHIMSICAL_ONION), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> WHIMSICAL_ONION_SEEDS = ITEMS.register("aethereal_rice",
            () -> new CustomBlockItem(ModBlocks.WHIMSICAL_ONION_CROP.get(), new Item.Properties(), ModTabs.ALDORIA_SEEDS));

    // Plants and Flowers
    public static final DeferredItem<Item> BLUE_LOTUS = ITEMS.register("blue_lotus",
            () -> new CustomItem(new Item.Properties().stacksTo(64).food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).build()), ModTabs.ALDORIA_NATURE));
    public static final DeferredItem<Item> STARFLOWER = ITEMS.register("starflower",
            () -> new CustomItem(new Item.Properties().stacksTo(64).food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.2f).build()), ModTabs.ALDORIA_NATURE));
    public static final DeferredItem<Item> ETHER_DEWDROP_LILLY = ITEMS.register("ether_dewdrop_lilly",
            () -> new CustomItem(new Item.Properties().stacksTo(64).food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.2f).build()), ModTabs.ALDORIA_NATURE));
    public static final DeferredItem<Item> CORALWEED = ITEMS.register("coralweed",
            () -> new CustomItem(new Item.Properties().stacksTo(64).food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.2f).build()), ModTabs.ALDORIA_NATURE));
    public static final DeferredItem<Item> PIXIE_BLOOM = ITEMS.register("pixie_bloom",
            () -> new CustomItem(new Item.Properties().stacksTo(64).food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).build()), ModTabs.ALDORIA_NATURE));
    public static final DeferredItem<Item> CHAMOMILE = ITEMS.register("chamomile",
            () -> new CustomItem(new Item.Properties().stacksTo(64).food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).build()), ModTabs.ALDORIA_NATURE));
    public static final DeferredItem<Item> SAGE = ITEMS.register("sage",
            () -> new CustomItem(new Item.Properties().stacksTo(64).food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).build()), ModTabs.ALDORIA_NATURE));
    public static final DeferredItem<Item> ELDERFLOWER = ITEMS.register("elderflower",
            () -> new CustomItem(new Item.Properties().stacksTo(64).food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).build()), ModTabs.ALDORIA_NATURE));
    public static final DeferredItem<Item> HIBISCUS = ITEMS.register("hibiscus",
            () -> new CustomItem(new Item.Properties().stacksTo(64).food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).build()), ModTabs.ALDORIA_NATURE));
    public static final DeferredItem<Item> LAVENDER = ITEMS.register("lavender",
            () -> new CustomItem(new Item.Properties().stacksTo(64).food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).build()), ModTabs.ALDORIA_NATURE));
    public static final DeferredItem<Item> MINT = ITEMS.register("mint",
            () -> new CustomItem(new Item.Properties().stacksTo(64).food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).build()), ModTabs.ALDORIA_NATURE));
    public static final DeferredItem<Item> ROSEMARY = ITEMS.register("rosemary",
            () -> new CustomItem(new Item.Properties().stacksTo(64).food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).build()), ModTabs.ALDORIA_NATURE));
    public static final DeferredItem<Item> THYME = ITEMS.register("thyme",
            () -> new CustomItem(new Item.Properties().stacksTo(64).food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).build()), ModTabs.ALDORIA_NATURE));

    // New food items
    public static final DeferredItem<Item> DRAGONFRUIT_SALAD = ITEMS.register("dragonfruit_salad",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.6f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> SILVER_MILLET_PORRIDGE = ITEMS.register("silver_millet_porridge",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.7f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> BLOOD_BERRY_PIE = ITEMS.register("blood_berry_pie",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.5f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> FROST_BERRY_JAM = ITEMS.register("frost_berry_jam",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.4f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> LUMINOUS_LEEK_STIR_FRY = ITEMS.register("luminous_leek_stir_fry",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(7).saturationModifier(0.8f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> MOON_TURNIP_MASH = ITEMS.register("moon_turnip_mash",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.9f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> GHOST_CHILI_PEPPER_SAUCE = ITEMS.register("ghost_chili_pepper_sauce",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.3f).effect(() 
                    -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0), 1.0F).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> TWILIGHT_GOURD_SOUP = ITEMS.register("twilight_gourd_soup",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.6f).effect(() 
                    -> new MobEffectInstance(MobEffects.NIGHT_VISION, 200, 0), 1.0F).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> DEWDROP_CUCUMBER_SALAD = ITEMS.register("dewdrop_cucumber_salad",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.5f).effect(() 
                    -> new MobEffectInstance(MobEffects.WATER_BREATHING, 200, 0), 1.0F).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> GOLDEN_QUINOA_BOWL = ITEMS.register("golden_quinoa_bowl",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(7).saturationModifier(0.8f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> RAINBOW_BELL_PEPPER_STIR_FRY = ITEMS.register("rainbow_bell_pepper_stir_fry",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.6f).effect(() 
                    -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 0), 1.0F).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> CHILI_BEAN_CHILI = ITEMS.register("chili_bean_chili",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.7f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> MYSTIC_BERRY_SMOOTHIE = ITEMS.register("mystic_berry_smoothie",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.5f).effect(() 
                    -> new MobEffectInstance(MobEffects.REGENERATION, 100, 0), 1.0F).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> HIBISCUS_SALAD = ITEMS.register("hibiscus_salad",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.4f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> SUNCHOKE_AND_CABBAGE_SOUP = ITEMS.register("sunchoke_and_cabbage_soup",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.6f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> HONEYDEW_MELON_SORBET = ITEMS.register("honeydew_melon_sorbet",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.5f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> SPICY_RADISH_RELISH = ITEMS.register("spicy_radish_relish",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.3f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> PUMPKIN_PEPPER_MEDLEY = ITEMS.register("pumpkin_pepper_medley",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.7f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> DANDELION_GREENS_SALAD = ITEMS.register("dandelion_greens_salad",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.4f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> WHIMSICAL_ONION_TART = ITEMS.register("whimsical_onion_tart",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.6f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> FROST_BERRY_MUFFIN = ITEMS.register("frost_berry_muffin",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.5f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> THYME_ROASTED_VEGETABLES = ITEMS.register("thyme_roasted_vegetables",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.6f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> CILANTRO_AND_LIME_RICE = ITEMS.register("cilantro_and_lime_rice",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.5f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> ELDERFLOWER_LEMONADE = ITEMS.register("elderflower_lemonade",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f).effect(() 
                    -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 200, 0), 1.0F).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> MOONLIGHT_BREW = ITEMS.register("moonlight_brew",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.4f).effect(() 
                    -> new MobEffectInstance(MobEffects.INVISIBILITY, 100, 0), 1.0F).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> ROASTED_GOLDEN_CORN = ITEMS.register("roasted_golden_corn",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.6f).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> SPICY_GARLIC_WINGS = ITEMS.register("spicy_garlic_wings",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.9f).effect(() 
                    -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0), 1.0F).build()), ModTabs.ALDORIA_FOODS));
    public static final DeferredItem<Item> CRYSTAL_TOMATO_SALSA = ITEMS.register("crystal_tomato_salsa",
            () -> new CustomItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.5f).effect(() 
                    -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 0), 1.0F).build()), ModTabs.ALDORIA_FOODS));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
