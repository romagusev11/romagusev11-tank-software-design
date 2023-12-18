package ru.mipt.bit.platformer.base;

public enum Direction {
    UP(0, 1, 90),
    DOWN(0, -1, -90),
    LEFT(-1, 0, 180),
    RIGHT(1, 0, 0);

    public final int x;
    public final int y;
    public final float rotation;

    Direction(int x, int y, float rotation) {
        this.x = x;
        this.y = y;
        this.rotation = rotation;
    }
}
