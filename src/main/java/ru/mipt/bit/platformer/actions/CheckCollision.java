package ru.mipt.bit.platformer.actions;

import ru.mipt.bit.platformer.base.Action;
import ru.mipt.bit.platformer.base.Direction;
import ru.mipt.bit.platformer.base.Level;
import ru.mipt.bit.platformer.detector.CollisionDetector;
import ru.mipt.bit.platformer.objects.Bullet;
import ru.mipt.bit.platformer.objects.tank.Tank;
import ru.mipt.bit.platformer.base.GameObject;

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
            GameObject collision = detector.checkCollision(bullet, Direction.NONE);
            if (collision != null) {
                level.removeObject(bullet);
                if (collision instanceof Bullet) {
                    level.removeObject(collision);
                } else if (collision instanceof Tank) {
                    Tank tank = (Tank) collision;
                    tank.subtractHealthPoint();
                }
            } else {
                level.addAction(this);
            }
        }
    }
}
