package ru.mipt.bit.platformer.base;

public enum Direction {
    UP(0, 1, 90),
    DOWN(0, -1, -90),
    LEFT(-1, 0, 180),
    RIGHT(1, 0, 0),

    NONE(0 , 0 ,0);

    public final int x;
    public final int y;
    public final float rotation;

    Direction(int x, int y, float rotation) {
        this.x = x;
        this.y = y;
        this.rotation = rotation;
    }

    public static Direction fromRotation(float rotation) {
        if (rotation == 0) {
            return RIGHT;
        } else if (rotation == -90) {
            return DOWN;
        } else if (rotation == 180) {
            return LEFT;
        } else {
            return UP;
        }
    }
}
