package com.ubr.aldoria.item.equipment;

import net.minecraft.nbt.TextComponentTagVisitor;
import net.minecraft.world.item.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class CustomSwordItem extends SwordItem {

    public CustomSwordItem(Tier tier, int attackDamage, float attackSpeed, Properties properties, Supplier<CreativeModeTab> aldoriaEquipment) {
        super(tier, properties);
    }

    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add((Component) new TextComponentTagVisitor("This is a custom sword with special properties!"));
    }

    public boolean hurtEnemy(ItemStack stack, Player target, Player attacker) {
        // Custom behavior on hitting an enemy
        if (!attacker.level().isClientSide) {
            attacker.displayClientMessage((Component) new TextComponentTagVisitor("You struck an enemy with a custom sword!"), true);
        }
        return super.hurtEnemy(stack, target, attacker);
    }
}
