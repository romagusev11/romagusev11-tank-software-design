package ru.mipt.bit.platformer.objects;

import com.badlogic.gdx.math.GridPoint2;

import ru.mipt.bit.platformer.base.Direction;
import ru.mipt.bit.platformer.util.GdxGameUtils;

public class Tank extends TexturedObject {
    public final static float MOVEMENT_SPEED = 0.4f;
    private float rotation;
    private GridPoint2 destination;
    private float movementProgress;
    
    public Tank(String pathToTexture, GridPoint2 initialCoorditates, float initialRotation) {
        super(pathToTexture, initialCoorditates);
        rotation = initialRotation;
        destination = initialCoorditates;
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
    }

    public void move(Direction direction) {
        movementProgress -= 1;
        destination = GdxGameUtils.move(destination, direction.x, direction.y);
    }

    public void rotate(Direction direction) {
        rotation = direction.rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public GridPoint2 getDestination() {
        return destination;
    }

    public void setDestination(GridPoint2 destination) {
        this.destination = destination;
    }
}
