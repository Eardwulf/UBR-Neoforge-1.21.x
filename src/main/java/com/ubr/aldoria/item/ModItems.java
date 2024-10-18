package com.ubr.aldoria.item;

import com.ubr.aldoria.AldoriaCoreMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AldoriaCoreMod.MODID);

    public static final DeferredItem<Item> HEARTHSTONE = ITEMS.register("hearthstone",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
