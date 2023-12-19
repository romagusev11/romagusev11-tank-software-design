package ru.mipt.bit.platformer.objects.tank;

import com.badlogic.gdx.math.GridPoint2;

import ru.mipt.bit.platformer.base.Direction;
import ru.mipt.bit.platformer.objects.Movable;
import ru.mipt.bit.platformer.util.GdxGameUtils;

public class Tank implements Movable {
    private float reload = 0f;
    private float rotation;
    private float movementProgress;
    private GridPoint2 coordinates;
    private GridPoint2 destination;
    private TankState state;
    private int health;

    public Tank(float initialRotation, GridPoint2 coordinates) {
        rotation = initialRotation;
        movementProgress = 0;
        this.coordinates = coordinates;
        destination = coordinates;
        state = new HealthyState();
        health = 10;
    }

    @Override
    public GridPoint2 getDestination() {
        return destination;
    }

    public float getMovementProgress() {
        return movementProgress;
    }

    public void updateMovementProgress(float deltaTime) {
        movementProgress = state.move(this, deltaTime);
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

    public boolean shoot() {
        return state.shoot(this);
    }

    public void subtractHealthPoint() {
        health -= 1;
    }

    protected boolean tryToShoot() {
        if (onReload()) {
            return false;
        } else {
            reload += 1;
            return true;
        }
    }

    public GridPoint2 getCoordinates() {
        return coordinates;
    }

    @Override
    public float getRotation() {
        return rotation;
    }

    private void updateState() {
        if (health >= 8) {
            state = new HealthyState();
        } else if (health > 2) {
            state = new InjuredState();
        } else {
            state = new AlmostDeadState();
        }
    }

    @Override
    public void live(float deltaTime) {
        updateState();
        reload = Math.max(0, reload - deltaTime);
        updateMovementProgress(deltaTime);
    }

    public void rotate(Direction direction) {
        rotation = direction.rotation;
    }

    public boolean isDead() {
        return health <= 0;
    }
}
