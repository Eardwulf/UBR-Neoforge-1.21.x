package com.ubr.aldoria.block;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.TextComponentTagVisitor;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.core.particles.ParticleTypes;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class CustomBlock extends Block {

    public CustomBlock(Properties properties, Supplier<CreativeModeTab> aldoriaBlocks) {
        super(properties);
    }

    // Custom Tooltip
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add((Component) new TextComponentTagVisitor("This is a custom block with unique behavior!"));
    }

    // Custom right-click behavior
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!world.isClientSide) {
            player.displayClientMessage((Component) new TextComponentTagVisitor("You interacted with a custom block!"), true);
        }

        // Trigger custom particles when right-clicked
        if (world.isClientSide) {
            Random random = (Random) world.random;
            for (int i = 0; i < 5; i++) {
                double offsetX = random.nextDouble() - 0.5;
                double offsetY = random.nextDouble() - 0.5;
                double offsetZ = random.nextDouble() - 0.5;
                world.addParticle(ParticleTypes.ENCHANT, pos.getX() + 0.5 + offsetX, pos.getY() + 1.0 + offsetY, pos.getZ() + 0.5 + offsetZ, 0, 0.1, 0);
            }
        }

        return InteractionResult.SUCCESS;
    }

    // Custom shape (optional)
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Shapes.box(0.2, 0.0, 0.2, 0.8, 0.8, 0.8); // Customize the shape here
    }

    // Custom behavior on block break (optional)
    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!world.isClientSide && !state.is(newState.getBlock())) {
            world.levelEvent(2001, pos, Block.getId(state)); // Trigger a block break effect
        }
        super.onRemove(state, world, pos, newState, isMoving);
    }
}
