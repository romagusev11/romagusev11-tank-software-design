package ru.mipt.bit.platformer.objects;

import com.badlogic.gdx.math.GridPoint2;

import ru.mipt.bit.platformer.base.Direction;
import ru.mipt.bit.platformer.base.Level;
import ru.mipt.bit.platformer.util.GdxGameUtils;

public class Tank implements Movable {
    private float movementSpeed = 0.4f;
    private float reload = 0f;
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

    public void move(Direction direction) {
        movementProgress -= 1;
        destination = GdxGameUtils.move(destination, direction.x, direction.y);
    }

    public boolean onReload() {
        return reload != 0;
    }

    public void shoot() {
        reload += 1;
    }

    public GridPoint2 getCoordinates() {
        return coordinates;
    }

    @Override
    public float getRotation() {
        return rotation;
    }

    @Override
    public void live(float deltaTime) {
        reload = Math.max(0, reload - deltaTime);
        updateMovementProgress(deltaTime);
    }

    public void rotate(Direction direction) {
        rotation = direction.rotation;
    }
}
