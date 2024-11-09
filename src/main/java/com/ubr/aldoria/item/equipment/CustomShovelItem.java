package com.ubr.aldoria.item.equipment;

import net.minecraft.nbt.TextComponentTagVisitor;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;
import java.util.function.Supplier;

public class CustomShovelItem extends ShovelItem {

    public CustomShovelItem(Tier tier, float attackDamage, float attackSpeed, Properties properties, Supplier<CreativeModeTab> aldoriaEquipment) {
        super(tier, properties);
    }

    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add((Component) new TextComponentTagVisitor("This is a custom shovel with enhanced digging abilities!"));
    }
}