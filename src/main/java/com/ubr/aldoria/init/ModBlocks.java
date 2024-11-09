package com.ubr.aldoria.init;

import com.ubr.aldoria.AldoriaCM;
import com.ubr.aldoria.block.lamps.AetherialLamp;
import com.ubr.aldoria.block.lamps.OrichalcumLamp;
import com.ubr.aldoria.machines.*;
import com.ubr.aldoria.machines.ElectrumCapacitor;
import com.ubr.aldoria.block.*;
import com.ubr.aldoria.block.farming.crops.*;
import com.ubr.aldoria.block.wards.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(AldoriaCM.MODID);

    //Ores
    public static final DeferredBlock<Block> ORICHALCUM_ORE = registerBlock("orichalcum_ore",
            () -> new CustomBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().sound(SoundType.METAL).mapColor(MapColor.METAL).strength(10.0F, 10.0F), ModTabs.ALDORIA_BLOCKS));
    public static final DeferredBlock<Block> TITANITE_ORE = registerBlock("titanite_ore",
            () -> new TitaniteOre(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().sound(SoundType.STONE).mapColor(MapColor.STONE).strength(10.0F, 10.0F), ModTabs.ALDORIA_BLOCKS));
    public static final DeferredBlock<Block> CRYOLITE_ORE = registerBlock("cryolite_ore",
            () -> new CustomBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().sound(SoundType.STONE).mapColor(MapColor.STONE).strength(10.0F, 10.0F), ModTabs.ALDORIA_BLOCKS));
    public static final DeferredBlock<Block> ELECTRUM_ORE = registerBlock("electrum_ore",
            () -> new CustomBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().sound(SoundType.STONE).mapColor(MapColor.STONE).strength(10.0F, 10.0F), ModTabs.ALDORIA_BLOCKS));

    //Machines
    public static final DeferredBlock<Block> ORICHALCUM_LAMP = BLOCKS.register("orichalcum_lamp",
            () -> new OrichalcumLamp((BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(60.0F, 2000.0F))));
    public static final DeferredBlock<Block> SOLAR_CHARGER = BLOCKS.register("solar_charger",
            () -> new SolarCharger((BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(60.0F, 2000.0F))));
    public static final DeferredBlock<Block> SUNSTONE_PANELS = BLOCKS.register("sunstone_panels",
            () -> new SunstonePanels((BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(60.0F, 2000.0F))));
    public static final DeferredBlock<Block> AETHERIAL_LAMP = BLOCKS.register("orichalcum_lamp",
            () -> new AetherialLamp((BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(60.0F, 2000.0F))));
    public static final DeferredBlock<Block> MYSTIC_PROJECTOR = BLOCKS.register("mystic_projector",
            () -> new MysticProjector((BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(60.0F, 2000.0F))));
    public static final DeferredBlock<Block> ELECTRUM_CAPACITOR = BLOCKS.register("mystic_projector",
            () -> new ElectrumCapacitor((BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(60.0F, 2000.0F))));
    public static final DeferredBlock<Block> ELECTRUM_CONDUCTOR = BLOCKS.register("mystic_projector",
            () -> new ElectrumConductor((BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(60.0F, 2000.0F))));
    public static final DeferredHolder<Block, ElectrumFurnace> ELECTRUM_FURNACE = BLOCKS.register("electrum_furnace",
            () -> new ElectrumFurnace(Block.Properties.of().mapColor(MapColor.STONE).strength(3.0F)));
    public static final DeferredBlock<SemiTransparentBlock> SEMI_TRANSPARENT_BLOCK = BLOCKS.register("semi_transparent_block",
            () -> new SemiTransparentBlock(Block.Properties.of().mapColor(MapColor.STONE).strength(3.0F)));
    public static final DeferredBlock<ElectrumWiring> ELECTRUM_WIRING = BLOCKS.register("electrum_wiring", () -> new ElectrumWiring(new Item.Properties().stacksTo(64)));
    public static final DeferredBlock<Block> ELECTRUM_LAMP = BLOCKS.register("electrum_lamp",
            () -> new AetherialLamp((BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(60.0F, 2000.0F))));

    //Farming
    public static final DeferredBlock<Block> STARFRUIT_CROP = BLOCKS.register("starfruit_crop",
            () -> new StarfruitCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> MYSTIC_BERRY_CROP = BLOCKS.register("mystic_berry_crop.json",
            () -> new MysticBerryCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> PUMPKIN_PEPPER_CROP  = BLOCKS.register("starfruit_crop",
            () -> new PumpkinPeppersCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> HONEYDEW_MELON_CROP  = BLOCKS.register("starfruit_crop",
            () -> new HoneydewMelonCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> RED_QUINOA_CROP  = BLOCKS.register("starfruit_crop",
            () -> new RedQuinoaCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> GOLDEN_CORN_CROP  = BLOCKS.register("starfruit_crop",
            () -> new GoldenCornCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> SPICY_RADISH_CROP  = BLOCKS.register("starfruit_crop",
            () -> new SpicyRadishesCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> CABBAGE_CROP  = BLOCKS.register("starfruit_crop",
            () -> new CabbageCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> SUNCHOKE_CROP  = BLOCKS.register("starfruit_crop",
            () -> new SunchokesCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> CHILI_BEAN_CROP  = BLOCKS.register("starfruit_crop",
            () -> new ChiliBeansCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> MISO_PEA_CROP  = BLOCKS.register("starfruit_crop",
            () -> new MisoPeasCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> BLACKBERRY_CROP  = BLOCKS.register("starfruit_crop",
            () -> new BlackberriesCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> DRAGONFRUIT_VINE_CROP = BLOCKS.register("dragonfruit_vine_crop",
            () -> new DragonfruitVineBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> SILVER_MILLET_CROP = BLOCKS.register("silver_millet_crop",
            () -> new SilverMilletCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> BLOOD_BERRY_CROP = BLOCKS.register("blood_berry_crop",
            () -> new BloodBerryCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> FROST_BERRY_CROP = BLOCKS.register("frost_berry_crop",
            () -> new FrostBerryCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> LUMINOUS_LEEK_CROP = BLOCKS.register("luminous_leek_crop",
            () -> new LuminousLeekCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> MOON_TURNIP_CROP = BLOCKS.register("moon_turnip_crop",
            () -> new MoonTurnipCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> GHOST_CHILI_PEPPER_CROP = BLOCKS.register("ghost_chili_pepper_crop",
            () -> new GhostChiliPepperCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> TWILIGHT_GOURD_CROP = BLOCKS.register("twilight_gourd_crop",
            () -> new TwilightGourdCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> DEWDROP_CUCUMBER_CROP = BLOCKS.register("dewdrop_cucumber_crop",
            () -> new DewdropCucumberCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> GOLDEN_QUINOA_CROP = BLOCKS.register("golden_quinoa_crop",
            () -> new GoldenQuinoaCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> AETHERIAL_RICE_CROP = BLOCKS.register("aethereal_rice_crop",
            () -> new AetherialRiceCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> RAINBOW_BELL_PEPPER_CROP = BLOCKS.register("rainbow_bell_pepper_crop",
            () -> new RainbowBellPepperCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> CRYSTAL_TOMATO_CROP = BLOCKS.register("crystal_tomato_crop",
            () -> new CrystalTomatoCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> CHILLING_GARLIC_CROP = BLOCKS.register("chilling_garlic_crop",
            () -> new ChillingGarlicCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> WHIMSICAL_ONION_CROP = BLOCKS.register("whimsical_onion_crop",
            () -> new WhimsicalOnionCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> MYSTIC_TUBER_CROP = BLOCKS.register("mystic_tuber_crop",
            () -> new MysticTuberCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> NIGHTSHADE_BERRY_CROP = BLOCKS.register("nightshade_berry_crop",
            () -> new NightshadeBerryCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> BASILISK_ROOT_CROP = BLOCKS.register("basilisk_root_crop",
            () -> new BasiliskRootCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> SILVERWEED_CROP = BLOCKS.register("silverweed_crop",
            () -> new SilverweedCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> BASIL_CROP = BLOCKS.register("basil_crop",
            () -> new BasilCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> CILANTRO_CROP = BLOCKS.register("cilantro_crop",
            () -> new CilantroCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> LEMON_BALM_CROP = BLOCKS.register("lemon_balm_crop",
            () -> new LemonBalmCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> PARSLEY_CROP = BLOCKS.register("parsley_crop",
            () -> new ParsleyCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> GINGER_ROOT_CROP = BLOCKS.register("ginger_root_crop",
            () -> new GingerRootCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> ALOE_VERA_CROP = BLOCKS.register("aloe_vera_crop",
            () -> new AloeVeraCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> GINGER_CROP = BLOCKS.register("ginger_crop",
            () -> new GingerCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> TURMERIC_CROP = BLOCKS.register("turmeric_crop",
            () -> new TurmericCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> HOLY_BASIL_CROP = BLOCKS.register("holy_basil_crop",
            () -> new HolyBasilCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> DANDELION_CROP = BLOCKS.register("dandelion_crop",
            () -> new DandelionCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> VALERIAN_ROOT_CROP = BLOCKS.register("valerian_root_crop",
            () -> new ValerianRootCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> GARLIC_CROP = BLOCKS.register("garlic_crop",
            () -> new GarlicCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> NETTLE_CROP = BLOCKS.register("nettle_crop",
            () -> new NettleCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> LICORICE_ROOT_CROP = BLOCKS.register("licorice_root_crop",
            () -> new LicoriceRootCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> COMFREY_CROP = BLOCKS.register("comfrey_crop",
            () -> new ComfreyCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> CATNIP_CROP = BLOCKS.register("catnip_crop",
            () -> new CatnipCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> GINSENG_CROP = BLOCKS.register("ginseng_crop",
            () -> new GinsengCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> YARROW_CROP = BLOCKS.register("yarrow_crop",
            () -> new YarrowCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> ASHWAGANDHA_CROP = BLOCKS.register("ashwagandha_crop",
            () -> new AshwagandhaCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> FEVERFEW_CROP = BLOCKS.register("feverfew_crop",
            () -> new FeverfewCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));
    public static final DeferredBlock<Block> MILK_THISTLE_CROP = BLOCKS.register("milk_thistle_crop",
            () -> new MilkThistleCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak()));



    // Blocks
    public static final DeferredBlock<Block> ORICHALCUM_BLOCK = BLOCKS.register("orichalcum_block",
            () -> new CustomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(60.0F, 2000.0F), ModTabs.ALDORIA_BLOCKS));
    public static final DeferredBlock<Block> ORICHALCUM_PILLAR = BLOCKS.register("orichalcum_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(60.0F, 2000.0F)));
    public static final DeferredBlock<Block> ORICHALCUM_BRICK = BLOCKS.register("orichalcum_brick",
            () -> new CustomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(60.0F, 2000.0F), ModTabs.ALDORIA_BLOCKS));
    public static final DeferredBlock<Block> ORICHALCUM_TILES = BLOCKS.register("orichalcum_tiles",
            () -> new CustomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(60.0F, 2000.0F), ModTabs.ALDORIA_BLOCKS));
    public static final DeferredBlock<Block> TITANITE_BLOCK = BLOCKS.register("titanite_block",
            () -> new CustomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).sound(SoundType.AMETHYST).strength(60.0F, 2000.0F), ModTabs.ALDORIA_BLOCKS));
    public static final DeferredBlock<Block> MOONSTONE_BLOCK = BLOCKS.register("moonstone_block",
            () -> new CustomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.STONE).strength(60.0F, 2000.0F), ModTabs.ALDORIA_BLOCKS));
    public static final DeferredBlock<Block> SUNSTONE_BLOCK = BLOCKS.register("sunstone_block",
            () -> new CustomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).sound(SoundType.AMETHYST).strength(60.0F, 2000.0F), ModTabs.ALDORIA_BLOCKS));
    public static final DeferredBlock<Block> SUNSTONE_BRICK = BLOCKS.register("sunstone_brick",
            () -> new CustomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).sound(SoundType.AMETHYST).strength(60.0F, 2000.0F), ModTabs.ALDORIA_BLOCKS));
    public static final DeferredBlock<Block> CRYOLITE_BRICK = BLOCKS.register("cryolite_brick",
            () -> new CustomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).sound(SoundType.AMETHYST).strength(60.0F, 2000.0F), ModTabs.ALDORIA_BLOCKS));
    public static final DeferredBlock<Block> CRYOLITE_BLOCK = BLOCKS.register("cryolite_block",
            () -> new CustomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).sound(SoundType.AMETHYST).strength(60.0F, 2000.0F), ModTabs.ALDORIA_BLOCKS));


    //Glass
    public static final DeferredBlock<Block> TITANITE_GLASS = BLOCKS.register("titanite_glass",
            () -> new CustomBlock(BlockBehaviour.Properties.of().strength(0.3F).sound(SoundType.GLASS).noOcclusion(), ModTabs.ALDORIA_BLOCKS));
    public static final DeferredBlock<Block> CRYOLITE_GLASS = BLOCKS.register("cryolite_glass",
            () -> new CustomBlock(BlockBehaviour.Properties.of().strength(0.3F).sound(SoundType.GLASS).noOcclusion(), ModTabs.ALDORIA_BLOCKS));


    //Wards
    public static final DeferredBlock<Block> ORICHALCUM_WARD = BLOCKS.register("orichalcum_ward",
            () -> new OrichalcumWard(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(60.0F, 2000.0F)));
    public static final DeferredBlock<Block> MOONSTONE_WARD = BLOCKS.register("moonstone_ward",
            () -> new MoonstoneWard(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(60.0F, 2000.0F)));
    public static final DeferredBlock<Block> SUNSTONE_WARD = BLOCKS.register("sunstone_ward",
            () -> new SunstoneWard(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(60.0F, 2000.0F)));
    public static final DeferredBlock<Block> AETHERIAL_WARD = BLOCKS.register("aetherial_ward",
            () -> new AetherialWard(BlockBehaviour.Properties.of().mapColor(MapColor.GLOW_LICHEN).sound(SoundType.POINTED_DRIPSTONE).strength(60.0F, 2000.0F)));
    public static final DeferredBlock<Block> CRYOLITE_WARD = BLOCKS.register("cryolite_ward",
            () -> new CryoliteWard(BlockBehaviour.Properties.of().mapColor(MapColor.ICE).sound(SoundType.SNOW).strength(60.0F, 2000.0F)));

    //Apothecary
    public  static final DeferredBlock<Block> APOTHECARY_TABLE_BLOCK = BLOCKS.register("apothecary_table_block",
            ApothecaryTableBlock::new);
    public  static final DeferredBlock<Block> MORTAL_AND_PESTLE_BLOCK = BLOCKS.register("apothecary_table_block",
            ApothecaryTableBlock::new);
    public static final DeferredBlock<Block> ALCHEMY_FURNACE = BLOCKS.register("alchemy_furnace",
            AlchemyFurnaceBlock::new);
    public static final DeferredBlock<Block> DISTILLER = BLOCKS.register("distiller", DistillerBlock::new);
    public static final DeferredBlock<Block> ESSENCE_COLLECTOR = BLOCKS.register("essence_collector",
            EssenceCollectorBlock::new);


    //Util//
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}