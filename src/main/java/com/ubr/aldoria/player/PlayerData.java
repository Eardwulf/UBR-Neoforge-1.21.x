package com.ubr.aldoria.player;

import com.ubr.aldoria.init.ModRaces;
import com.ubr.aldoria.races.RaceRegistry;
import com.ubr.aldoria.util.Attribute;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.Attributes;

import java.util.HashMap;
import java.util.Map;

public class PlayerData {
    // Home coordinates
    private double homeX;
    private double homeY;
    private double homeZ;

    // Leveling and attributes
    private int level;
    private int experience;
    private Map<String, Attribute> attributes;
    private ModRaces race;

    // New PlayerStats instance
    private PlayerStats stats;  // This holds more detailed stats like levels, experience, and more

    public PlayerData(ModRaces race) {
        this.homeX = 0;
        this.homeY = 0;
        this.homeZ = 0;

        this.level = 1;
        this.experience = 0;
        this.race = (race != null) ? race : ModRaces.getDefaultRace();
        this.attributes = new HashMap<>();
        this.stats = new PlayerStats();  // Initialize PlayerStats

        initializeAttributes(); // Correctly placed after all required fields are initialized
    }

    // Getter for PlayerStats
    public PlayerStats getStats() {
        return stats;
    }

    // Set the player's race and reinitialize their attributes
    public void setRace(ModRaces newRace) {
        this.race = newRace;
        this.attributes.clear();  // Assuming that changing the race might affect attributes
        initializeAttributes();  // Reinitialize attributes based on the new race
    }

    private void initializeAttributes() {
        if (this.race == null || this.race.getAttributes() == null) {
            System.out.println("Race or race attributes are null at initialization.");
            return;
        }

        for (String attributeName : race.getAttributes().keySet()) {
            int attributeValue = race.getAttributes().get(attributeName);
            attributes.put(attributeName, new Attribute(attributeName, attributeValue));
        }

        ensureDefaultAttributes();
    }

    private void ensureDefaultAttributes() {
        String[] defaultAttributes = {"Mind", "Might", "Agility", "Will", "Vitality", "Presence", "Awareness"};
        for (String attribute : defaultAttributes) {
            attributes.putIfAbsent(attribute, new Attribute(attribute, 0));
        }
    }

    public void setHomePoint(double x, double y, double z) {
        this.homeX = x;
        this.homeY = y;
        this.homeZ = z;
    }

    public boolean hasHomePoint() {
        return homeX != 0 || homeY != 0 || homeZ != 0;
    }

    public double getHomeX() {
        return homeX;
    }

    public double getHomeY() {
        return homeY;
    }

    public double getHomeZ() {
        return homeZ;
    }

    public void gainExperience(int amount) {
        experience += amount;
        while (experience >= getExperienceToLevelUp()) {
            levelUp();
        }
    }

    public void applyStatEffects(ServerPlayer player) {
        // Get player's current attributes
        Map<String, Attribute> playerAttributes = this.getAttributes();

        // Apply effects for each stat, ensuring the attribute exists
        if (playerAttributes.containsKey("Vitality")) {
            applyVitalityEffect(player, playerAttributes.get("Vitality").getValue());
        }
        if (playerAttributes.containsKey("Might")) {
            applyMightEffect(player, playerAttributes.get("Might").getValue());
        }
        if (playerAttributes.containsKey("Agility")) {
            applyAgilityEffect(player, playerAttributes.get("Agility").getValue());
        }
        if (playerAttributes.containsKey("Mind")) {
            applyMindEffect(player, playerAttributes.get("Mind").getValue());
        }
        if (playerAttributes.containsKey("Will")) {
            applyWillEffect(player, playerAttributes.get("Will").getValue());
        }
        if (playerAttributes.containsKey("Presence")) {
            applyPresenceEffect(player, playerAttributes.get("Presence").getValue());
        }
        if (playerAttributes.containsKey("Awareness")) {
            applyAwarenessEffect(player, playerAttributes.get("Awareness").getValue());
        }
    }

    // Vitality: Affects player's maximum health
    public void applyVitalityEffect(ServerPlayer player, int vitality) {
        double baseHealth = 20.0;  // Base health is 20 (10 hearts)
        double healthBonus = vitality * 2.0;  // Each vitality point adds 2 health (1 heart)
        player.getAttribute(Attributes.MAX_HEALTH).setBaseValue(baseHealth + healthBonus);
    }

    // Might: Affects player's melee damage and knockback resistance
    public void applyMightEffect(ServerPlayer player, int might) {
        double baseDamage = 2.0;  // Base melee damage (fists)
        double damageBonus = might * 0.5;  // Each point of Might adds 0.5 damage
        player.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(baseDamage + damageBonus);

        // Knockback resistance
        player.getAttribute(Attributes.KNOCKBACK_RESISTANCE).setBaseValue(might * 0.01);  // 1% per Might point
    }

    // Agility: Affects player's movement speed and jump height
    public void applyAgilityEffect(ServerPlayer player, int agility) {
        double baseSpeed = 0.1;  // Base movement speed
        double speedBonus = agility * 0.02;  // Each point of Agility increases speed by 2%
        player.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(baseSpeed + speedBonus);

        // Jump boost (optional)
        if (agility >= 5) {
            player.addEffect(new MobEffectInstance(MobEffects.JUMP, 6000, agility / 5));
        }
    }

    // Mind: Reduces cooldowns and enhances magic or potion effects
    public void applyMindEffect(ServerPlayer player, int mind) {
        // Custom logic for reducing ability cooldowns by 2% per Mind point
        double cooldownReduction = mind * 0.02;

        // Increase potion duration or effectiveness
        if (mind >= 5) {
            player.getActiveEffects().forEach(effect -> {
                int newAmplifier = Math.min(effect.getAmplifier() + (mind / 5), 3);  // Max amplifier level is 3
                player.addEffect(new MobEffectInstance(effect.getEffect(), effect.getDuration(), newAmplifier));
            });
        }
    }

    // Will: Reduces hunger depletion and improves resistance to negative effects
    public void applyWillEffect(ServerPlayer player, int will) {
        // Custom logic for reducing hunger depletion (use custom stamina system or modify vanilla hunger)
        double hungerReduction = will * 0.01;  // Reduce hunger depletion by 1% per Will point

        // Resistance to negative effects
        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, will / 5));  // 1 level every 5 points
    }

    // Presence: Increases luck and improves interactions with NPCs (trading, bartering)
    public void applyPresenceEffect(ServerPlayer player, int presence) {
        player.getAttribute(Attributes.LUCK).setBaseValue(presence);  // Increase luck

        // Optional: Give better trades or discounts with NPCs
        if (presence >= 5) {
            player.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 6000, presence / 5));
        }
    }

    // Awareness: Improves perception and detection range for mobs/players
    public void applyAwarenessEffect(ServerPlayer player, int awareness) {
        // Custom logic for increasing detection radius for mobs and players
        double detectionRangeBonus = awareness * 1.0;  // 1 block increase per Awareness point
        // Implement detection logic in your custom mob/player detection system
    }

    private void levelUp() {
        experience -= getExperienceToLevelUp();
        level++;
        allocateStatPoints(3);  // Allocate 3 stat points on leveling up
        applyStatEffects(null);  // Fix: Ensure to pass in the ServerPlayer object
    }

    private int getExperienceToLevelUp() {
        return level * 100; // Example progression, adjust as needed
    }

    public void allocateStatPoints(int points) {
        if (!attributes.isEmpty()) {
            String firstAttribute = attributes.keySet().iterator().next();
            attributes.get(firstAttribute).allocatePoints(points);
        }
    }

    public Map<String, Attribute> getAttributes() {
        return attributes;
    }

    public ModRaces getRace() {
        return race;
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    // Saving PlayerData (including PlayerStats)
    public CompoundTag saveToNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putDouble("HomeX", homeX);
        tag.putDouble("HomeY", homeY);
        tag.putDouble("HomeZ", homeZ);
        tag.putInt("Level", level);
        tag.putInt("Experience", experience);
        tag.putString("ModRaces", race.getName());

        // Save attributes
        CompoundTag attributesTag = new CompoundTag();
        for (Map.Entry<String, Attribute> entry : attributes.entrySet()) {
            attributesTag.putInt(entry.getKey(), entry.getValue().getValue());
        }
        tag.put("Attributes", attributesTag);

        // Save PlayerStats
        CompoundTag statsTag = stats.saveToNBT();
        tag.put("PlayerStats", statsTag);

        return tag;
    }

    // Loading PlayerData (including PlayerStats)
    public void loadFromNBT(CompoundTag tag) {
        homeX = tag.getDouble("HomeX");
        homeY = tag.getDouble("HomeY");
        homeZ = tag.getDouble("HomeZ");
        level = tag.getInt("Level");
        experience = tag.getInt("Experience");
        race = RaceRegistry.getRace(tag.getString("ModRaces"));

        // Load attributes
        CompoundTag attributesTag = tag.getCompound("Attributes");
        for (String key : attributesTag.getAllKeys()) {
            if (attributes.containsKey(key)) {
                attributes.get(key).setValue(attributesTag.getInt(key));
            } else {
                attributes.put(key, new Attribute(key, attributesTag.getInt(key)));
            }
        }

        // Load PlayerStats
        if (tag.contains("PlayerStats")) {
            stats.loadFromNBT(tag.getCompound("PlayerStats"));
        }
    }
}
