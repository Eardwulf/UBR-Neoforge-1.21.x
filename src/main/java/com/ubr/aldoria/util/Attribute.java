package com.ubr.aldoria.util;

public class Attribute {
    private String name;
    private int value;
    private int pointsAllocated; // Track allocated points for leveling

    public Attribute(String name, int initialValue) {
        this.name = name;
        this.value = initialValue;
        this.pointsAllocated = 0; // No points allocated initially
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value + pointsAllocated; // Return total value including allocated points
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getPointsAllocated() {
        return pointsAllocated;
    }

    public void allocatePoints(int points) {
        pointsAllocated += points; // Add points to the allocated total
    }

    public void resetPoints() {
        pointsAllocated = 0; // Reset allocated points if needed
    }
}
