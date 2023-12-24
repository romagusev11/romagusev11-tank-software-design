package ru.mipt.bit.platformer.objects.tank;

public interface TankState {
    float move(Tank tank, float deltaTime);
    boolean shoot(Tank tank);
}
