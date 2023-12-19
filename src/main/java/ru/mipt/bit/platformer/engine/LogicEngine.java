package ru.mipt.bit.platformer.engine;

import ru.mipt.bit.platformer.base.Direction;
import ru.mipt.bit.platformer.objects.Tank;

public class LogicEngine {

    private final Tank player;
    private final CollisionDetector detector;

    public LogicEngine(Tank player, CollisionDetector detector) {
        this.player = player;
        this.detector = detector;
    }

    public void updatePlayerDestination(Direction direction) {
        player.tryToMove(direction, detector);
    }

    public void calculatePlayerCoordinates(float deltaTime) {
        player.updateMovementProgress(deltaTime);
    }
}


