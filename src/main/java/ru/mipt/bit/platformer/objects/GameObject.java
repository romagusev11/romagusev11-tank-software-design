package ru.mipt.bit.platformer.objects;

import com.badlogic.gdx.math.GridPoint2;

public interface GameObject {
    GridPoint2 getCoordinates();
    float getRotation();
}
