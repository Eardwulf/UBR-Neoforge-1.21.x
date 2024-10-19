package com.ubr.aldoria.util;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;

public class PlayerData {
    private double homeX;
    private double homeY;
    private double homeZ;

    public PlayerData() {
        // Default home point can be set to some initial value if needed
        this.homeX = 0;
        this.homeY = 0;
        this.homeZ = 0;
    }

    public void setHomePoint(double x, double y, double z) {
        this.homeX = x;
        this.homeY = y;
        this.homeZ = z;
    }

    public boolean hasHomePoint() {
        return homeX != 0 || homeY != 0 || homeZ != 0; // Adjust condition as needed
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
}
