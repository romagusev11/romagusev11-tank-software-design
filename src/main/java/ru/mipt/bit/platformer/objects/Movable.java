package ru.mipt.bit.platformer.objects;

import com.badlogic.gdx.math.GridPoint2;
import ru.mipt.bit.platformer.base.GameObject;

public interface Movable extends GameObject {
    GridPoint2 getDestination();
    float getMovementProgress();
}
