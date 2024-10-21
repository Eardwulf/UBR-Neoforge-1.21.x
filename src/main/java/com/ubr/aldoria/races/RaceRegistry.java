package com.ubr.aldoria.races;

import com.ubr.aldoria.init.ModRaces;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RaceRegistry {
    private static final Map<String, ModRaces> races = new HashMap<>();

    public static void registerRaces() {
        races.put("Skyborn", new Skyborn());
        races.put("Stonekin", new Stonekin());
        races.put("Forest Walkers", new ForestWalkers());
        races.put("Deep Dwellers", new DeepDwellers());
        races.put("Tinkerers", new Tinkerers());
        races.put("Aquaticans", new Aquaticans());
        races.put("Golemkind", new Golemkind());
        races.put("Nomads", new Nomads());
    }

    public static ModRaces getRace(String name) {
        return races.get(name);
    }

    public static Map<String, ModRaces> getAllRaces() {
        return races;
    }

    // Method to get a list (actually a Set) of all available race names
    public static Set<String> getAvailableRaces() {
        return Collections.unmodifiableSet(races.keySet());
    }
}
