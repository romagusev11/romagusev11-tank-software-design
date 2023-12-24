package ru.mipt.bit.platformer.base;

import com.badlogic.gdx.math.GridPoint2;

public interface GameObject {
    GridPoint2 getCoordinates();
    float getRotation();
    void live(float deltaTime);
}
