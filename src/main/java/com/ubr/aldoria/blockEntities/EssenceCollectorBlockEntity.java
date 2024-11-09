package com.ubr.aldoria.blockEntities;

import com.ubr.aldoria.init.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.particles.ParticleTypes;

public class EssenceCollectorBlockEntity extends BlockEntity {

    private int essence = 0; // Track collected essence
    private static final int MAX_ESSENCE = 1000; // Maximum essence storage

    public EssenceCollectorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ESSENCE_COLLECTOR.get(), pos, state);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, EssenceCollectorBlockEntity entity) {
        if (!level.isClientSide) {
            // Collect essence each tick, but cap it at the maximum value
            entity.collectEssence();

            // Emit particles for visual feedback
            if (level instanceof ServerLevel) {
                emitParticles((ServerLevel) level, pos);
            }
        }
    }

    private void collectEssence() {
        if (essence < MAX_ESSENCE) {
            essence += 1; // Increment essence; you can customize this rate
        }
    }

    private static void emitParticles(ServerLevel level, BlockPos pos) {
        for (int i = 0; i < 2; i++) { // Number of particles per tick
            level.sendParticles(ParticleTypes.ENCHANT,
                    pos.getX() + 0.5 + (level.random.nextDouble() - 0.5),
                    pos.getY() + 1.0,
                    pos.getZ() + 0.5 + (level.random.nextDouble() - 0.5),
                    1, 0, 0, 0, 0);
        }
    }

    // Getter for essence level (optional, if you need it for other classes)
    public int getEssence() {
        return essence;
    }

    // Optional method to drain essence (e.g., for other machines to consume it)
    public int drainEssence(int amount) {
        int drained = Math.min(amount, essence);
        essence -= drained;
        return drained;
    }
}
