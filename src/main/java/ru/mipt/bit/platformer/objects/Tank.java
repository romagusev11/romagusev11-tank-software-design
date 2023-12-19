package ru.mipt.bit.platformer.objects;

import com.badlogic.gdx.math.GridPoint2;

import ru.mipt.bit.platformer.base.Direction;
import ru.mipt.bit.platformer.engine.CollisionDetector;
import ru.mipt.bit.platformer.util.GdxGameUtils;

public class Tank implements Movable {
    private float movementSpeed = 0.4f;
    private float rotation;
    private float movementProgress;
    private GridPoint2 coordinates;
    private GridPoint2 destination;

    public Tank(float initialRotation, GridPoint2 coordinates, float movementSpeed) {
        rotation = initialRotation;
        movementProgress = 0;
        this.coordinates = coordinates;
        destination = coordinates;
        this.movementSpeed = movementSpeed;
    }

    public Tank(float initialRotation, GridPoint2 coordinates) {
        rotation = initialRotation;
        movementProgress = 0;
        this.coordinates = coordinates;
        destination = coordinates;
    }

    @Override
    public GridPoint2 getDestination() {
        return destination;
    }

    public float getMovementProgress() {
        return movementProgress;
    }

    public void updateMovementProgress(float deltaTime) {
        movementProgress = GdxGameUtils.continueProgress(movementProgress, deltaTime, movementSpeed);
        if (movementProgress >= 1) {
            // record that tank has reached destination
            coordinates = destination;
        }
    }

    public void tryToMove(Direction direction, CollisionDetector detector) {
        if (movementProgress >= 1) {
            // check potential  destination for collision with obstacles
            if (!detector.checkCollision(this, direction)) {
                movementProgress -= 1;
                destination = GdxGameUtils.move(destination, direction.x, direction.y);
            }
            rotate(direction);
        }
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
