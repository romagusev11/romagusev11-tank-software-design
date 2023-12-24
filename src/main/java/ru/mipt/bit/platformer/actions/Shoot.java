package ru.mipt.bit.platformer.actions;

import ru.mipt.bit.platformer.base.Action;
import ru.mipt.bit.platformer.base.Direction;
import ru.mipt.bit.platformer.base.Level;
import ru.mipt.bit.platformer.detector.CollisionDetector;
import ru.mipt.bit.platformer.objects.Bullet;
import ru.mipt.bit.platformer.objects.tank.Tank;
import ru.mipt.bit.platformer.util.GdxGameUtils;

public class Shoot implements Action {
    private final Tank tank;
    private final Level level;
    private final CollisionDetector detector;
    public Shoot(Tank tank, Level level, CollisionDetector detector) {
        this.tank = tank;
        this.level = level;
        this.detector = detector;
    }

    @Override
    public void execute() {
        if (!tank.shoot()) {
            return;
        }

        float rotation = tank.getRotation();

        Direction direction = Direction.fromRotation(rotation);
        Bullet bullet = new Bullet(rotation, GdxGameUtils.move(tank.getCoordinates(), direction.x, direction.y), direction);
        level.addObject(bullet);
        level.addAction(new CheckCollision(bullet, detector, level));
    }
}
