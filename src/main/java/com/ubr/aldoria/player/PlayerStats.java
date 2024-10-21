package com.ubr.aldoria.player;

import net.minecraft.nbt.CompoundTag;
import java.util.HashMap;
import java.util.Map;

public class PlayerStats {
    private int level;
    private int experience;
    private Map<String, Integer> attributes;

    // Predefined XP requirements per level
    private static final int[] LEVEL_XP_REQUIREMENTS = {0, 300, 900, 2700, 6500, 13000, 21500, 35000, 60000};

    public PlayerStats() {
        this.level = 1;
        this.experience = 0;
        this.attributes = new HashMap<>();
        // Initialize default attributes
        attributes.put("Mind", 0);
        attributes.put("Might", 0);
        attributes.put("Agility", 0);
        attributes.put("Will", 0);
        attributes.put("Vitality", 0);
        attributes.put("Presence", 0);
        attributes.put("Awareness", 0);
    }

    // Adds experience points and handles level-up
    public void addExperience(int xp) {
        experience += xp;
        while (level < LEVEL_XP_REQUIREMENTS.length && experience >= LEVEL_XP_REQUIREMENTS[level]) {
            levelUp();
        }
    }

    // Levels up the player and allocates attribute points
    private void levelUp() {
        level++;
        allocateAttributePoints(5); // Example: 5 points per level-up
        // Notify player about level-up, if necessary
    }

    // Allocates points to attributes (could be automated or player-controlled)
    private void allocateAttributePoints(int points) {
        // Simple example of automatic allocation to "Mind"
        attributes.put("Mind", attributes.get("Mind") + points);
        // You can implement more complex allocation here or involve the player
    }

    // Get XP required for the next level
    public int getXpToNextLevel() {
        if (level < LEVEL_XP_REQUIREMENTS.length) {
            return LEVEL_XP_REQUIREMENTS[level];
        } else {
            // Beyond the predefined levels, use a scaling formula (e.g., exponential growth)
            return (int) (1000 * Math.pow(level, 2.5));
        }
    }

    // Returns the player's current level
    public int getLevel() {
        return level;
    }

    // Returns the player's current experience
    public int getExperience() {
        return experience;
    }

    // Returns the map of player attributes
    public Map<String, Integer> getAttributes() {
        return attributes;
    }

    // Saves stats and attributes to NBT for persistence
    public CompoundTag saveToNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putInt("Level", level);
        tag.putInt("Experience", experience);

        // Save attributes
        CompoundTag attributesTag = new CompoundTag();
        for (Map.Entry<String, Integer> entry : attributes.entrySet()) {
            attributesTag.putInt(entry.getKey(), entry.getValue());
        }
        tag.put("Attributes", attributesTag);

        return tag;
    }

    // Loads stats and attributes from NBT
    public void loadFromNBT(CompoundTag tag) {
        this.level = tag.getInt("Level");
        this.experience = tag.getInt("Experience");

        // Load attributes
        CompoundTag attributesTag = tag.getCompound("Attributes");
        for (String key : attributesTag.getAllKeys()) {
            attributes.put(key, attributesTag.getInt(key));
        }
    }
}
