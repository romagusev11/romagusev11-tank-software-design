package ru.mipt.bit.platformer.objects;

import com.badlogic.gdx.math.GridPoint2;

public class Player extends Tank {

    public Player(float initialRotation, GridPoint2 coordinates, float movementSpeed) {
        super(initialRotation, coordinates, movementSpeed);
    }

    public Player(float initialRotation, GridPoint2 coordinates) {
        super(initialRotation, coordinates);
    }
}
