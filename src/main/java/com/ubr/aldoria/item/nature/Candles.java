package com.ubr.aldoria.item.nature;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class Candles extends Item {
    private final NaturalCandleType candleType;

    public Candles(Properties properties, NaturalCandleType type) {
        super(properties);
        this.candleType = type;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        // Place candle logic - this can be enhanced to define where the candle can be placed.
        if (!context.getLevel().isClientSide()) {
            Level level = context.getLevel();
            if (level.getBlockState(context.getClickedPos()).getBlock() == Blocks.CANDLE) {
                Player player = context.getPlayer();
                if (player != null) {
                    level.setBlock(context.getClickedPos().above(), Blocks.CANDLE.defaultBlockState(), 3);
                    context.getItemInHand().shrink(1);
                    level.playSound(null, context.getClickedPos(), SoundEvents.CANDLE_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
                }
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide && candleType == NaturalCandleType.EUCALYPTUS) {
            player.displayClientMessage(Component.translatable("message.aldoriacm.candle_activated"), true);
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0)); // Health regeneration for 10 seconds
        }
        return InteractionResultHolder.sidedSuccess(player.getItemInHand(hand), level.isClientSide());
    }

    public void applyEffects(Level level, Player player) {
        switch (candleType) {
            case LAVENDER:
                // Reduce mob spawning in a certain range around the player
                if (!level.isClientSide()) {
                    level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(10.0D), entity -> entity.isAlive() && !(entity instanceof Player))
                            .forEach(entity -> {
                                if (entity instanceof LivingEntity livingEntity) {
                                    livingEntity.setDeltaMovement(livingEntity.getDeltaMovement().multiply(0.5, 1.0, 0.5));
                                }
                            });
                }
                break;
            case EUCALYPTUS:
                // Health regeneration effect is given when near the candle
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0)); // Lasts for 10 seconds
                break;
            case ROSE:
                // Attract bees
                level.getEntitiesOfClass(Bee.class, player.getBoundingBox().inflate(15.0D)).forEach(bee -> {
                    bee.setTarget(player);
                });
                break;
        }
    }

    // Enum to differentiate candle types
    public enum NaturalCandleType {
        LAVENDER,
        EUCALYPTUS,
        ROSE
    }
}
