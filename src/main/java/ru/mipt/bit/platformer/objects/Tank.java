package ru.mipt.bit.platformer.objects;

import com.badlogic.gdx.math.GridPoint2;

import ru.mipt.bit.platformer.base.Direction;
import ru.mipt.bit.platformer.textures.MovableTexturedObject;
import ru.mipt.bit.platformer.util.GdxGameUtils;
import ru.mipt.bit.platformer.util.TileMovement;

public class Tank extends MovableTexturedObject implements Collidable {
    private final static float MOVEMENT_SPEED = 0.4f;
    
    public Tank(String pathToTexture, GridPoint2 initialCoorditates, float initialRotation, TileMovement tileMovement) {
        super(pathToTexture, initialCoorditates, tileMovement);
        rotation = initialRotation;
        movementProgress = 0;
    }

    public float getRotation() {
        return rotation;
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

    public void rotate(Direction direction) {
        rotation = direction.rotation;
    }
}
