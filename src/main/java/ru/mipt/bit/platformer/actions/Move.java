package ru.mipt.bit.platformer.actions;

import ru.mipt.bit.platformer.base.Direction;
import ru.mipt.bit.platformer.engine.CollisionDetector;
import ru.mipt.bit.platformer.objects.Bullet;
import ru.mipt.bit.platformer.objects.Movable;
import ru.mipt.bit.platformer.objects.Tank;
import ru.mipt.bit.platformer.util.GdxGameUtils;

public class Move implements Action {

    private final Movable object;
    private final CollisionDetector detector;
    private final Direction direction;

    public Move(Movable object, CollisionDetector detector, Direction direction) {
        this.object = object;
        this.detector = detector;
        this.direction = direction;
    }

    @Override
    public void execute() {
        if (object instanceof Tank) {
            Tank tank = (Tank) object;
            if (tank.getMovementProgress() >= 1) {
                // check potential  destination for collision with obstacles
                if (!detector.checkCollision(tank, direction)) {
                    tank.move(direction);
                }
                tank.rotate(direction);
            }
        }
    }
}
