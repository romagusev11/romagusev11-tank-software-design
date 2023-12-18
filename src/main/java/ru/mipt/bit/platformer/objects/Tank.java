package ru.mipt.bit.platformer.objects;

import com.badlogic.gdx.math.GridPoint2;

import ru.mipt.bit.platformer.base.Direction;
import ru.mipt.bit.platformer.util.GdxGameUtils;

public class Tank implements Movable {
    private final static float MOVEMENT_SPEED = 0.4f;
    private float rotation;
    private float movementProgress;
    private GridPoint2 coordinates;
    private GridPoint2 destination;

    public Tank(float initialRotation, GridPoint2 coordinates) {
        rotation = initialRotation;
        movementProgress = 0;
        this.coordinates = coordinates;
    }

    @Override
    public GridPoint2 getDestination() {
        return destination;
    }

    public float getMovementProgress() {
        return movementProgress;
    }

    public void updateMovementProgress(float deltaTime) {
        movementProgress = GdxGameUtils.continueProgress(movementProgress, deltaTime, Tank.MOVEMENT_SPEED);
        if (movementProgress >= 1) {
            // record that tank has reached destination
            coordinates = destination;
        }
    }

    public void move(Direction direction) {
        movementProgress -= 1;
        destination = GdxGameUtils.move(destination, direction.x, direction.y);
    }

    public GridPoint2 getCoordinates() {
        return coordinates;
    }

    @Override
    public float getRotation() {
        return rotation;
    }

    public void rotate(Direction direction) {
        rotation = direction.rotation;
    }
}
