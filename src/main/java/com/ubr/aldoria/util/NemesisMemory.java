package com.ubr.aldoria.util;


import net.minecraft.world.entity.LivingEntity;

import java.util.HashMap;
import java.util.Map;

public class NemesisMemory {
    private Map<LivingEntity, Integer> memory = new HashMap<>();

    // Increment memory for a player
    public void rememberPlayer(LivingEntity entity) {
        memory.put(entity, memory.getOrDefault(entity, 0) + 1);
    }

    // Get memory level for a player
    public int getMemoryLevel(LivingEntity entity) {
        return memory.getOrDefault(entity, 0);
    }

    // Optionally, remove memory after certain conditions
    public void forgetPlayer(LivingEntity entity) {
        memory.remove(entity);
    }
    // Pseudo code for saving and loading nemesis data
    public void saveNemesisData() {
        // Save memory to a file or NBT
    }

    public void loadNemesisData() {
        // Load memory from a file or NBT
    }

}
