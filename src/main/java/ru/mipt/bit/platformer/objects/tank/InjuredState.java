package ru.mipt.bit.platformer.objects.tank;

import ru.mipt.bit.platformer.util.GdxGameUtils;

public class InjuredState implements TankState {

    @Override
    public float move(Tank tank, float deltaTime) {
        float movementSpeed = 0.6f;
        return GdxGameUtils.continueProgress(tank.getMovementProgress(), deltaTime, movementSpeed);
    }

    @Override
    public boolean shoot(Tank tank) {
        return tank.tryToShoot();
    }
}
