package com.ubr.aldoria.init;

import com.ubr.aldoria.AldoriaCM;
import com.ubr.aldoria.block.MortarAndPestleBlockEntity;
import com.ubr.aldoria.block.MortarAndPestleContainer;
import com.ubr.aldoria.machines.ApothecaryTableContainer;
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

    static {
        // Register the Apothecary Table Container with the DeferredRegister
        CONTAINERS.register("apothecary_table_container", () -> APOTHECARY_TABLE_CONTAINER);

        // Register the Mortar and Pestle Container with the DeferredRegister
        CONTAINERS.register("mortar_and_pestle_container", () -> MORTAR_AND_PESTLE_CONTAINER);
    }

    // Method to register the DeferredRegister on the event bus
    public static void register(IEventBus eventBus) {
        CONTAINERS.register(eventBus);
    }

    // Inner class implementing MenuSupplier for ApothecaryTableContainer
    private static class ApothecaryTableMenuSupplier implements MenuType.MenuSupplier<ApothecaryTableContainer> {
        public ApothecaryTableContainer create(int windowId, Inventory inv, FriendlyByteBuf buffer) {
            int x = buffer.readByte() & 0xFF |
                    (buffer.readByte() & 0xFF) << 8 |
                    (buffer.readByte() & 0xFF) << 16 |
                    (buffer.readByte() & 0xFF) << 24;
            int y = buffer.readByte() & 0xFF |
                    (buffer.readByte() & 0xFF) << 8 |
                    (buffer.readByte() & 0xFF) << 16 |
                    (buffer.readByte() & 0xFF) << 24;
            int z = buffer.readByte() & 0xFF |
                    (buffer.readByte() & 0xFF) << 8 |
                    (buffer.readByte() & 0xFF) << 16 |
                    (buffer.readByte() & 0xFF) << 24;

            BlockPos pos = new BlockPos(x, y, z);
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
            int x = buffer.readByte() & 0xFF |
                    (buffer.readByte() & 0xFF) << 8 |
                    (buffer.readByte() & 0xFF) << 16 |
                    (buffer.readByte() & 0xFF) << 24;
            int y = buffer.readByte() & 0xFF |
                    (buffer.readByte() & 0xFF) << 8 |
                    (buffer.readByte() & 0xFF) << 16 |
                    (buffer.readByte() & 0xFF) << 24;
            int z = buffer.readByte() & 0xFF |
                    (buffer.readByte() & 0xFF) << 8 |
                    (buffer.readByte() & 0xFF) << 16 |
                    (buffer.readByte() & 0xFF) << 24;

            BlockPos pos = new BlockPos(x, y, z);
            ContainerLevelAccess access = ContainerLevelAccess.create(inv.player.level(), pos);
            return new MortarAndPestleContainer(windowId, inv, (MortarAndPestleBlockEntity) access);
        }

        @Override
        public MortarAndPestleContainer create(int i, Inventory inventory) {
            return null;
        }
    }
}
