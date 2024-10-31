package com.ubr.aldoria.init;

import com.ubr.aldoria.AldoriaCM;
import com.ubr.aldoria.item.food.HerbalInfusion;
import com.ubr.aldoria.item.armor.MoonstoneArmor;
import com.ubr.aldoria.item.food.Stews;
import com.ubr.aldoria.item.misc.*;
import com.ubr.aldoria.item.nature.Candles;
import com.ubr.aldoria.item.pouches.PouchItem;
import net.minecraft.world.food.FoodProperties;
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

    // Root Stews
    public static final DeferredItem<Item> SUNCHOKE_STEW = ITEMS.register("sunchoke_stew",
            () -> new Stews(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.8f).build())));
    public static final DeferredItem<Item> MISO_PEA_STEW = ITEMS.register("miso_pea_stew",
            () -> new Stews(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().nutrition(7).saturationModifier(0.7f).build())));
    public static final DeferredItem<Item> SPICY_RADISH_STEW = ITEMS.register("spicy_radish_stew",
            () -> new Stews(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.6f).build())));
    public static final DeferredItem<Item> GOLDEN_CORN_CHOWDER = ITEMS.register("golden_corn_chowder",
            () -> new Stews(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().nutrition(10).saturationModifier(0.9f).build())));
    public static final DeferredItem<Item> CABBAGE_SOUP = ITEMS.register("cabbage_soup",
            () -> new Stews(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.6f).build())));

    // Herbal Infusions
    public static final DeferredItem<Item> CHAMOMILE_TEA = ITEMS.register("chamomile_tea",
            () -> new HerbalInfusion(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().saturationModifier(0.5f).build())));
    public static final DeferredItem<Item> GINGER_TEA = ITEMS.register("ginger_tea",
            () -> new HerbalInfusion(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().saturationModifier(0.4f).build())));
    public static final DeferredItem<Item> MINT_INFUSION = ITEMS.register("mint_infusion",
            () -> new HerbalInfusion(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().saturationModifier(0.4f).build())));
    public static final DeferredItem<Item> LAVENDER_BREW = ITEMS.register("lavender_brew",
            () -> new HerbalInfusion(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().saturationModifier(0.4f).build())));
    public static final DeferredItem<Item> ELDERFLOWER_CORDIAL = ITEMS.register("elderflower_cordial",
            () -> new HerbalInfusion(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().saturationModifier(0.4f).build())));
    public static final DeferredItem<Item> ROSEMARY_TONIC = ITEMS.register("rosemary_tonic",
            () -> new HerbalInfusion(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().saturationModifier(0.4f).build())));
    public static final DeferredItem<Item> THYME_INFUSION = ITEMS.register("thyme_infusion",
            () -> new HerbalInfusion(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().saturationModifier(0.4f).build())));
    public static final DeferredItem<Item> HIBISCUS_COOLER = ITEMS.register("hibiscus_cooler",
            () -> new HerbalInfusion(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().saturationModifier(0.4f).build())));
    public static final DeferredItem<Item> BASIL_BREW = ITEMS.register("basil_brew",
            () -> new HerbalInfusion(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().saturationModifier(0.4f).build())));
    public static final DeferredItem<Item> SAGE_SERUM = ITEMS.register("sage_serum",
            () -> new HerbalInfusion(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().saturationModifier(0.4f).build())));
    public static final DeferredItem<Item> CILANTRO_TINCTURE = ITEMS.register("cilantro_tincture",
            () -> new HerbalInfusion(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().saturationModifier(0.4f).build())));
    public static final DeferredItem<Item> LEMON_BALM_INFUSION = ITEMS.register("lemon_balm_infusion",
            () -> new HerbalInfusion(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().saturationModifier(0.4f).build())));
    public static final DeferredItem<Item> PARSLEY_POTION = ITEMS.register("parsley_potion",
            () -> new HerbalInfusion(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().saturationModifier(0.4f).build())));
    public static final DeferredItem<Item> DANDELION_ELIXIR = ITEMS.register("dandelion_elixir",
            () -> new HerbalInfusion(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().saturationModifier(0.4f).build())));

    // Crop Items
    public static final DeferredItem<Item> STARFRUIT = ITEMS.register("starfruit",
            () -> new Item(new Item.Properties().food(ModFoods.STARFRUIT)));
    public static final DeferredItem<Item> STARFRUIT_SEEDS = ITEMS.register("starfruit_seeds",
            () -> new BlockItem(ModBlocks.STARFRUIT_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> MYSTIC_BERRY_SEEDS = ITEMS.register("mystic_berry_seeds",
            () -> new ItemNameBlockItem(ModBlocks.MYSTIC_BERRY_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> MYSTIC_BERRY = ITEMS.register("mystic_berry",
            () -> new Item(new Item.Properties().food(ModFoods.MYSTIC_BERRY)));
    public static final DeferredItem<Item> PUMPKIN_PEPPER = ITEMS.register("pumpkin_pepper",
            () -> new Item(new Item.Properties().food(ModFoods.PUMPKIN_PEPPER)));
    public static final DeferredItem<Item> PUMPKIN_PEPPER_SEEDS = ITEMS.register("pumpkin_pepper_seeds",
            () -> new BlockItem(ModBlocks.PUMPKIN_PEPPER_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> HONEYDEW_MELON = ITEMS.register("honeydew_melon",
            () -> new Item(new Item.Properties().food(ModFoods.HONEYDEW_MELON)));
    public static final DeferredItem<Item> HONEYDEW_MELON_SEEDS = ITEMS.register("honeydew_melon_seeds",
            () -> new BlockItem(ModBlocks.HONEYDEW_MELON_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> RED_QUINOA = ITEMS.register("red_quinoa",
            () -> new Item(new Item.Properties().food(ModFoods.RED_QUINOA)));
    public static final DeferredItem<Item> RED_QUINOA_SEEDS = ITEMS.register("red_quinoa_seeds",
            () -> new BlockItem(ModBlocks.RED_QUINOA_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> GOLDEN_CORN = ITEMS.register("golden_corn",
            () -> new Item(new Item.Properties().food(ModFoods.GOLDEN_CORN)));
    public static final DeferredItem<Item> GOLDEN_CORN_SEEDS = ITEMS.register("golden_corn_seeds",
            () -> new BlockItem(ModBlocks.GOLDEN_CORN_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> SPICY_RADISH = ITEMS.register("spicy_radish",
            () -> new Item(new Item.Properties().food(ModFoods.SPICY_RADISH)));
    public static final DeferredItem<Item> SPICY_RADISH_SEEDS = ITEMS.register("spicy_radish_seeds",
            () -> new BlockItem(ModBlocks.SPICY_RADISH_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> CABBAGE = ITEMS.register("cabbage",
            () -> new Item(new Item.Properties().food(ModFoods.CABBAGE)));
    public static final DeferredItem<Item> CABBAGE_SEEDS = ITEMS.register("cabbage_seeds",
            () -> new BlockItem(ModBlocks.CABBAGE_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> SUNCHOKE = ITEMS.register("sunchokes",
            () -> new Item(new Item.Properties().food(ModFoods.SUNCHOKE)));
    public static final DeferredItem<Item> SUNCHOKE_SEEDS = ITEMS.register("sunchokes_seeds",
            () -> new BlockItem(ModBlocks.SUNCHOKE_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> CHILI_BEANS = ITEMS.register("chili_beans",
            () -> new Item(new Item.Properties().food(ModFoods.CHILI_BEANS)));
    public static final DeferredItem<Item> CHILI_BEANS_SEEDS = ITEMS.register("chili_beans_seeds",
            () -> new BlockItem(ModBlocks.CHILI_BEAN_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> MISO_PEAS = ITEMS.register("miso_peas",
            () -> new Item(new Item.Properties().food(ModFoods.MISO_PEAS)));
    public static final DeferredItem<Item> MISO_PEAS_SEEDS = ITEMS.register("miso_peas_seeds",
            () -> new BlockItem(ModBlocks.MISO_PEA_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> BLACKBERRIES = ITEMS.register("blackberries",
            () -> new Item(new Item.Properties().food(ModFoods.BLACKBERRIES)));
    public static final DeferredItem<Item> BLACKBERRIES_SEEDS = ITEMS.register("blackberries_seeds",
            () -> new BlockItem(ModBlocks.BLACKBERRY_CROP.get(), new Item.Properties()));

    // Herb Items
    public static final DeferredItem<Item> CHAMOMILE = ITEMS.register("chamomile", () -> new Item(new Item.Properties().stacksTo(64)));
    public static final DeferredItem<Item> BASIL = ITEMS.register("basil", () -> new Item(new Item.Properties().stacksTo(64)));
    public static final DeferredItem<Item> SAGE = ITEMS.register("sage", () -> new Item(new Item.Properties().stacksTo(64)));
    public static final DeferredItem<Item> CILANTRO = ITEMS.register("cilantro", () -> new Item(new Item.Properties().stacksTo(64)));
    public static final DeferredItem<Item> LEMON_BALM = ITEMS.register("lemon_balm", () -> new Item(new Item.Properties().stacksTo(64)));
    public static final DeferredItem<Item> PARSLEY = ITEMS.register("parsley", () -> new Item(new Item.Properties().stacksTo(64)));
    public static final DeferredItem<Item> ELDERFLOWER = ITEMS.register("parsley", () -> new Item(new Item.Properties().stacksTo(64)));
    public static final DeferredItem<Item> GINGER_ROOT = ITEMS.register("parsley", () -> new Item(new Item.Properties().stacksTo(64)));
    public static final DeferredItem<Item> HIBISCUS = ITEMS.register("parsley", () -> new Item(new Item.Properties().stacksTo(64)));
    public static final DeferredItem<Item> LAVENDER = ITEMS.register("parsley", () -> new Item(new Item.Properties().stacksTo(64)));
    public static final DeferredItem<Item> MINT = ITEMS.register("parsley", () -> new Item(new Item.Properties().stacksTo(64)));
    public static final DeferredItem<Item> ROSEMARY = ITEMS.register("parsley", () -> new Item(new Item.Properties().stacksTo(64)));
    public static final DeferredItem<Item> THYME = ITEMS.register("parsley", () -> new Item(new Item.Properties().stacksTo(64)));

    // Pouch Items
    public static final DeferredItem<Item> HERBAL_POUCH = ITEMS.register("herbal_pouch", () -> new PouchItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> SEED_POUCH = ITEMS.register("seed_pouch", () -> new PouchItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> FLOWER_POUCH = ITEMS.register("flower_pouch", () -> new PouchItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> ROOT_POUCH = ITEMS.register("root_pouch", () -> new PouchItem(new Item.Properties().stacksTo(1)));

    // Candles
    public static final DeferredItem<Item> LAVENDER_CANDLE = ITEMS.register("lavender_candle",
            () -> new Candles(new Item.Properties().stacksTo(16), Candles.NaturalCandleType.LAVENDER));
    public static final DeferredItem<Item> EUCALYPTUS_CANDLE = ITEMS.register("eucalyptus_candle",
            () -> new Candles(new Item.Properties().stacksTo(16), Candles.NaturalCandleType.EUCALYPTUS));
    public static final DeferredItem<Item> ROSE_CANDLE = ITEMS.register("rose_candle",
            () -> new Candles(new Item.Properties().stacksTo(16), Candles.NaturalCandleType.ROSE));


    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
