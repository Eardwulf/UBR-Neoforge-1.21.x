package com.ubr.aldoria.init;

import com.ubr.aldoria.AldoriaCM;
import com.ubr.aldoria.item.misc.Hearthstone;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModItems
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AldoriaCM.MODID);

    public static final DeferredItem<Item> HEARTHSTONE = ITEMS.register("hearthstone",
            () -> new Hearthstone(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> ORICHALCUM_INGOT = ITEMS.register("orichalcum_ingot",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
