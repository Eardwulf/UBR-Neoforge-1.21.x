package com.ubr.aldoria.machines;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.MapColor;

public class ElectrumWiring extends Block {
    public static final BooleanProperty POWERED = BooleanProperty.create("powered");
    private int energy; // Variable to store the energy

    public ElectrumWiring(Item.Properties properties) {
        super(BlockBehaviour.Properties.of()
                .mapColor(MapColor.GOLD) // Set the color of the wiring
                .strength(0.1F) // Weak strength like redstone
                .lightLevel(state -> state.getValue(POWERED) ? 15 : 0)); // Light emitted when powered
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        // Check if any neighbor has changed to update wiring state
        if (!level.isClientSide) {
            boolean isPowered = false;
            for (Direction direction : Direction.values()) {
                BlockPos neighborPos = pos.relative(direction);
                isPowered |= level.hasNeighborSignal(neighborPos); // Check for power from neighboring blocks
            }
            if (isPowered != state.getValue(POWERED)) {
                level.setBlock(pos, state.setValue(POWERED, isPowered), 3); // Update wiring state
                if (isPowered) {
                    transferEnergy(level, pos); // Transfer energy if powered
                }
            }
        }
    }

    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand) {
        // Add any interaction logic if needed
        return InteractionResult.PASS; // Let other interactions happen
    }

    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return null; // No block entity needed for wiring
    }

    public void transferEnergy(Level level, BlockPos pos) {
        // Logic to transfer energy to connected machines
        int energyTransferAmount = 100; // Amount of energy to transfer

        for (Direction direction : Direction.values()) {
            BlockPos neighborPos = pos.relative(direction);
            BlockEntity neighborEntity = level.getBlockEntity(neighborPos);

            // Ensure you're checking if the entity is a BlockEntity and not a Block
            if (neighborEntity instanceof SolarChargerBlockEntity solarCharger) {
                // Transfer energy to SolarCharger
                solarCharger.receiveEnergy(energyTransferAmount); // Ensure this method exists in SolarChargerBlockEntity
            } else if (neighborEntity instanceof ElectrumFurnaceBlockEntity furnace) {
                // Transfer energy to ElectrumFurnace
                furnace.receiveEnergy(energyTransferAmount); // Ensure this method exists in ElectrumFurnaceBlockEntity
            }
        }
    }
}
