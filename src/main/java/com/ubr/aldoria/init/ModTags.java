package com.ubr.aldoria.init;

import com.ubr.aldoria.AldoriaCM;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        // Tags for Orichalcum
        public static final TagKey<Block> NEEDS_ORICHALCUM_TOOL = createTag("needs_orichalcum_tool");
        public static final TagKey<Block> INCORRECT_FOR_ORICHALCUM_TOOL = createTag("incorrect_for_orichalcum_tool");

        // Tags for Titanite
        public static final TagKey<Block> NEEDS_TITANITE_TOOL = createTag("needs_titanite_tool");
        public static final TagKey<Block> INCORRECT_FOR_TITANITE_TOOL = createTag("incorrect_for_titanite_tool");

        // Tags for Moonstone
        public static final TagKey<Block> NEEDS_MOONSTONE_TOOL = createTag("needs_moonstone_tool");
        public static final TagKey<Block> INCORRECT_FOR_MOONSTONE_TOOL = createTag("incorrect_for_moonstone_tool");

        // Tags for Sunstone
        public static final TagKey<Block> NEEDS_SUNSTONE_TOOL = createTag("needs_sunstone_tool");
        public static final TagKey<Block> INCORRECT_FOR_SUNSTONE_TOOL = createTag("incorrect_for_sunstone_tool");

        // Tags for Cryolite
        public static final TagKey<Block> NEEDS_CRYOLITE_TOOL = createTag("needs_cryolite_tool");
        public static final TagKey<Block> INCORRECT_FOR_CRYOLITE_TOOL = createTag("incorrect_for_cryolite_tool");

        // Tags for Electrum
        public static final TagKey<Block> NEEDS_ELECTRUM_TOOL = createTag("needs_electrum_tool");
        public static final TagKey<Block> INCORRECT_FOR_ELECTRUM_TOOL = createTag("incorrect_for_electrum_tool");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(AldoriaCM.MODID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(AldoriaCM.MODID, name));
        }
    }
}
