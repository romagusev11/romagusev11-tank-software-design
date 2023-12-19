package ru.mipt.bit.platformer.actions;

import ru.mipt.bit.platformer.base.Direction;
import ru.mipt.bit.platformer.base.Level;
import ru.mipt.bit.platformer.engine.CollisionDetector;
import ru.mipt.bit.platformer.objects.Bullet;
import ru.mipt.bit.platformer.objects.GameObject;

public class CheckCollision implements Action {

    private final GameObject object;
    private final CollisionDetector detector;
    private final Level level;

    public CheckCollision(GameObject object, CollisionDetector detector, Level level) {
        this.object = object;
        this.detector = detector;
        this.level = level;
    }

    @Override
    public void execute() {
        if (object instanceof Bullet) {
            Bullet bullet = (Bullet) object;
            if (detector.checkCollision(bullet, Direction.NONE)) {
                level.removeObject(bullet);
            } else {
                level.addAction(new CheckCollision(object, detector, level));
            }
        }
    }
}
