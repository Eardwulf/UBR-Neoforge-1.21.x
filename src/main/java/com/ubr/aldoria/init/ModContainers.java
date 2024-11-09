package com.ubr.aldoria.init;

import com.ubr.aldoria.AldoriaCM;
import com.ubr.aldoria.blockEntities.MortarAndPestleBlockEntity;
import com.ubr.aldoria.blockEntities.AlchemyFurnaceBlockEntity;
import com.ubr.aldoria.container.MortarAndPestleContainer;
import com.ubr.aldoria.container.ApothecaryTableContainer;
import com.ubr.aldoria.container.AlchemyFurnaceContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModContainers {

    // Register containers with the MENU registry and mod ID
    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(Registries.MENU, AldoriaCM.MODID);

    // Define the Apothecary Table Container
    public static final MenuType<ApothecaryTableContainer> APOTHECARY_TABLE_CONTAINER = new MenuType<>(new ApothecaryTableMenuSupplier(), FeatureFlagSet.of());

    // Define the Mortar and Pestle Container
    public static final MenuType<MortarAndPestleContainer> MORTAR_AND_PESTLE_CONTAINER = new MenuType<>(new MortarAndPestleMenuSupplier(), FeatureFlagSet.of());

    // Define the Alchemy Furnace Container
    public static final MenuType<AlchemyFurnaceContainer> ALCHEMY_FURNACE_CONTAINER = new MenuType<>(new AlchemyFurnaceMenuSupplier(), FeatureFlagSet.of());

    static {
        // Register the Apothecary Table Container with the DeferredRegister
        CONTAINERS.register("apothecary_table_container", () -> APOTHECARY_TABLE_CONTAINER);

        // Register the Mortar and Pestle Container with the DeferredRegister
        CONTAINERS.register("mortar_and_pestle_container", () -> MORTAR_AND_PESTLE_CONTAINER);

        // Register the Alchemy Furnace Container with the DeferredRegister
        CONTAINERS.register("alchemy_furnace_container", () -> ALCHEMY_FURNACE_CONTAINER);
    }

    // Method to register the DeferredRegister on the event bus
    public static void register(IEventBus eventBus) {
        CONTAINERS.register(eventBus);
    }

    // Inner class implementing MenuSupplier for ApothecaryTableContainer
    private static class ApothecaryTableMenuSupplier implements MenuType.MenuSupplier<ApothecaryTableContainer> {
        public ApothecaryTableContainer create(int windowId, Inventory inv, FriendlyByteBuf buffer) {
            BlockPos pos = buffer.readBlockPos();
            ContainerLevelAccess access = ContainerLevelAccess.create(inv.player.level(), pos);
            return new ApothecaryTableContainer(windowId, inv, access);
        }

        @Override
        public ApothecaryTableContainer create(int i, Inventory inventory) {
            return null;
        }
    }

    // Inner class implementing MenuSupplier for MortarAndPestleContainer
    private static class MortarAndPestleMenuSupplier implements MenuType.MenuSupplier<MortarAndPestleContainer> {
        public MortarAndPestleContainer create(int windowId, Inventory inv, FriendlyByteBuf buffer) {
            BlockPos pos = buffer.readBlockPos();
            ContainerLevelAccess access = ContainerLevelAccess.create(inv.player.level(), pos);
            return new MortarAndPestleContainer(windowId, inv, (MortarAndPestleBlockEntity) access);
        }

        @Override
        public MortarAndPestleContainer create(int i, Inventory inventory) {
            return null;
        }
    }

    // Inner class implementing MenuSupplier for AlchemyFurnaceContainer
    private static class AlchemyFurnaceMenuSupplier implements MenuType.MenuSupplier<AlchemyFurnaceContainer> {
        public AlchemyFurnaceContainer create(int windowId, Inventory inv, FriendlyByteBuf buffer) {
            BlockPos pos = buffer.readBlockPos();
            ContainerLevelAccess access = ContainerLevelAccess.create(inv.player.level(), pos);
            return new AlchemyFurnaceContainer(windowId, inv, (AlchemyFurnaceBlockEntity) access);
        }

        @Override
        public AlchemyFurnaceContainer create(int i, Inventory inventory) {
            return null;
        }
    }
}
