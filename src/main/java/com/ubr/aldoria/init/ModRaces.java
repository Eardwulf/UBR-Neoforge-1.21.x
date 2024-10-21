package com.ubr.aldoria.init;

import com.ubr.aldoria.races.Nomads;

import java.util.HashMap;
import java.util.Map;

public abstract class ModRaces {
    private static final Map<String, ModRaces> RACES = new HashMap<>();
    private String name;
    private Map<String, Integer> attributes; // Map of attribute name to value
    private String ability; // Unique ability

    public ModRaces(String name, String ability) {
        this.name = name;
        this.ability = ability;
        this.attributes = new HashMap<>();
        initializeAttributes();
    }

    static {
        // Initialize races here
        RACES.put("Nomads", new Nomads());  // Assuming Nomads is a concrete class extending ModRaces
        // Additional races can be added similarly
    }

    private void initializeAttributes() {
        // Initialize default attribute values
        attributes.put("Mind", 0);
        attributes.put("Might", 0);
        attributes.put("Agility", 0);
        attributes.put("Will", 0);
        attributes.put("Vitality", 0);
        attributes.put("Presence", 0);
        attributes.put("Awareness", 0);
    }

    public static ModRaces getRace(String raceName) {
        return RACES.getOrDefault(raceName, getDefaultRace());
    }

    public static ModRaces getDefaultRace() {
        // Default race handling, returning Nomads as a fallback
        return RACES.get("Nomads");
    }

    public String getName() {
        return name;
    }

    public String getAbility() {
        return ability;
    }

    public Map<String, Integer> getAttributes() {
        return attributes;
    }

    public void setAttribute(String attribute, int value) {
        attributes.put(attribute, value);
    }
}
