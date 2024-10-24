package com.ubr.aldoria.util;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class SmartMonster extends Monster {
    private final NemesisMemory nemesisMemory = new NemesisMemory();

    public SmartMonster(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }

    @Override
    public void tick() {
        super.tick();
        LivingEntity lastAttacker = this.getLastHurtByMob();

        if (lastAttacker instanceof LivingEntity) {
            nemesisMemory.rememberPlayer(lastAttacker);
            int memoryLevel = nemesisMemory.getMemoryLevel(lastAttacker);

            // Adjust behavior based on memory level
            if (memoryLevel > 3) {
                // Example: Increase damage or change strategy
                this.setCustomDamage(memoryLevel); // Custom method to adjust damage based on memory
                this.getNavigation().moveTo(lastAttacker, 1.0D); // Move towards the player faster
            }
        }
    }

    private void setCustomDamage(int memoryLevel) {
        // Define how the attack damage is adjusted based on memory level
        float baseDamage = 5.0F; // Base damage value
        float damageMultiplier = 1.0F + (memoryLevel * 0.1F); // Increase damage per memory level
        this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(baseDamage * damageMultiplier);
    }

    // Attribute registration for the mob
    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.ATTACK_DAMAGE, 5.0D) // Base attack damage
                .add(Attributes.MOVEMENT_SPEED, 0.25D); // Movement speed
    }
}
