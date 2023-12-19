package ru.mipt.bit.platformer.objects;

import com.badlogic.gdx.math.GridPoint2;

public interface Movable extends GameObject {
    GridPoint2 getDestination();
    float getMovementProgress();
}
