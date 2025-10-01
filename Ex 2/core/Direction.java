package SatelliteSystem.core;

public enum Direction {
    NORTH, SOUTH, EAST, WEST;

    public static Direction fromString(String dir) {
        if (dir == null) return null;
        try {
            return Direction.valueOf(dir.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            // throw new IllegalArgumentException("Invalid direction. Allowed: NORTH, SOUTH, EAST, WEST, NORTHEAST, NORTHWEST, SOUTHEAST, SOUTHWEST");
            return null;
        }
    }

}
