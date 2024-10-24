package com.ubr.aldoria.init;

import com.ubr.aldoria.AldoriaCM;
import com.ubr.aldoria.Machines.*;
import com.ubr.aldoria.block.*;
import com.ubr.aldoria.block.wards.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(AldoriaCM.MODID);

    //Ores
    public static final DeferredBlock<Block> ORICHALCUM_ORE = registerBlock("orichalcum_ore",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().sound(SoundType.METAL).mapColor(MapColor.METAL).strength(10.0F, 10.0F)));
    public static final DeferredBlock<Block> TITANITE_ORE = registerBlock("titanite_ore",
            () -> new TitaniteOre(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().sound(SoundType.STONE).mapColor(MapColor.STONE).strength(10.0F, 10.0F)));
    public static final DeferredBlock<Block> CRYOLITE_ORE = registerBlock("cryolite_ore",
            () -> new TitaniteOre(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().sound(SoundType.STONE).mapColor(MapColor.STONE).strength(10.0F, 10.0F)));
    public static final DeferredBlock<Block> ELECTRUM_ORE = registerBlock("electrum_ore",
            () -> new TitaniteOre(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().sound(SoundType.STONE).mapColor(MapColor.STONE).strength(10.0F, 10.0F)));

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
    public static final DeferredBlock<Block> ELECTRUM_FURNACE = BLOCKS.register("mystic_projector",
            () -> new ElectrumFurnace((BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(60.0F, 2000.0F))));

    // Blocks
    public static final DeferredBlock<Block> ORICHALCUM_BLOCK = BLOCKS.register("orichalcum_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(60.0F, 2000.0F)));
    public static final DeferredBlock<Block> ORICHALCUM_PILLAR = BLOCKS.register("orichalcum_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(60.0F, 2000.0F)));
    public static final DeferredBlock<Block> ORICHALCUM_BRICK = BLOCKS.register("orichalcum_brick",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(60.0F, 2000.0F)));
    public static final DeferredBlock<Block> ORICHALCUM_TILES = BLOCKS.register("orichalcum_tiles",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(60.0F, 2000.0F)));
    public static final DeferredBlock<Block> TITANITE_BLOCK = BLOCKS.register("titanite_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).sound(SoundType.AMETHYST).strength(60.0F, 2000.0F)));
    public static final DeferredBlock<Block> MOONSTONE_BLOCK = BLOCKS.register("moonstone_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.STONE).strength(60.0F, 2000.0F)));
    public static final DeferredBlock<Block> SUNSTONE_BLOCK = BLOCKS.register("sunstone_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).sound(SoundType.AMETHYST).strength(60.0F, 2000.0F)));
    public static final DeferredBlock<Block> SUNSTONE_BRICK = BLOCKS.register("sunstone_brick",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).sound(SoundType.AMETHYST).strength(60.0F, 2000.0F)));
    public static final DeferredBlock<Block> CRYOLITE_BRICK = BLOCKS.register("cryolite_brick",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).sound(SoundType.AMETHYST).strength(60.0F, 2000.0F)));
    public static final DeferredBlock<Block> CRYOLITE_BLOCK = BLOCKS.register("cryolite_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).sound(SoundType.AMETHYST).strength(60.0F, 2000.0F)));


    //Glass
    public static final DeferredBlock<Block> TITANITE_GLASS = BLOCKS.register("titanite_glass",
            () -> new Block(BlockBehaviour.Properties.of().strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> CRYOLITE_GLASS = BLOCKS.register("cryolite_glass",
            () -> new Block(BlockBehaviour.Properties.of().strength(0.3F).sound(SoundType.GLASS).noOcclusion()));



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
