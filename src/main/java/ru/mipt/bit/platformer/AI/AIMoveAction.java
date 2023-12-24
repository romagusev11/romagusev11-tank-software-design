package ru.mipt.bit.platformer.AI;

import ru.mipt.bit.platformer.base.Action;
import ru.mipt.bit.platformer.actions.Move;
import ru.mipt.bit.platformer.base.Direction;
import ru.mipt.bit.platformer.detector.CollisionDetector;
import ru.mipt.bit.platformer.objects.tank.Tank;

public class AIMoveAction implements Action {
    private final Move move;

    public AIMoveAction(Tank tank, CollisionDetector detector) {
        move = new Move(tank, detector, Direction.fromRotation(tank.getRotation()));
    }

    @Override
    public void execute() {
        move.execute();
    }
}
