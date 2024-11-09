package com.ubr.aldoria.item.misc;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class EssenceExtractorItem extends Item {

    private static final int BURN_TIME = 1600; // Burn time for Essence Extractor in ticks

    public EssenceExtractorItem(Properties properties, Supplier<CreativeModeTab> aldoriaEquipment) {
        super(properties);
    }

    // This method returns the burn time in ticks when used as fuel
    public int getBurnTime(ItemStack itemStack) {
        return BURN_TIME;
    }
}
