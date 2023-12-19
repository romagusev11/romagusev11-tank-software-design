package ru.mipt.bit.platformer.objects;

import com.badlogic.gdx.math.GridPoint2;
import ru.mipt.bit.platformer.actions.CheckCollision;
import ru.mipt.bit.platformer.base.Direction;
import ru.mipt.bit.platformer.base.Level;
import ru.mipt.bit.platformer.util.GdxGameUtils;

public class Bullet implements Movable{
    private final float movementSpeed = 0.25f;
    private final float rotation;
    private float movementProgress;
    private GridPoint2 coordinates;
    private GridPoint2 destination;

    private final Direction direction;

    private final Level level;

    public Bullet(float initialRotation, GridPoint2 coordinates, Direction direction, Level level) {
        rotation = initialRotation;
        this.direction = direction;
        this.level = level;
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

    @Override
    public GridPoint2 getCoordinates() {
        return coordinates;
    }

    @Override
    public float getRotation() {
        return rotation;
    }

    @Override
    public void live(float deltaTime) {
        updateMovementProgress(deltaTime);
        if (coordinates == destination) {
            destination = GdxGameUtils.move(destination, direction.x, direction.y);
        }
    }

    public void updateMovementProgress(float deltaTime) {
        movementProgress = GdxGameUtils.continueProgress(movementProgress, deltaTime, movementSpeed);
        if (movementProgress >= 1) {
            // record that tank has reached destination
            movementProgress -= 1;
            coordinates = destination;
        }
    }
}
