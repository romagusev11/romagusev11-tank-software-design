package ru.mipt.bit.platformer.engine;

import com.badlogic.gdx.math.GridPoint2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.mipt.bit.platformer.base.Direction;
import ru.mipt.bit.platformer.objects.tank.Tank;
import ru.mipt.bit.platformer.objects.Tree;

public class CollisionDetectorTest {


    @Test
    public void onlyPlayerCollisionTest() {
        CollisionDetector detector = new CollisionDetector();
        Tank tank = new Tank(0, new GridPoint2(0, 0));

        detector.addCollidable(tank);

        Assertions.assertFalse(detector.checkCollision(tank, Direction.UP));
        Assertions.assertFalse(detector.checkCollision(tank, Direction.DOWN));
        Assertions.assertFalse(detector.checkCollision(tank, Direction.LEFT));
        Assertions.assertFalse(detector.checkCollision(tank, Direction.RIGHT));
    }

    @Test
    public void checkCloseCollisionTest() {
        CollisionDetector detector = new CollisionDetector();
        Tank tank = new Tank(0, new GridPoint2(0, 0));
        Tree tree = new Tree(new GridPoint2(0, 1));

        detector.addCollidable(tank).addCollidable(tree);

        Assertions.assertTrue(detector.checkCollision(tank, Direction.UP));
        Assertions.assertFalse(detector.checkCollision(tank, Direction.DOWN));
        Assertions.assertFalse(detector.checkCollision(tank, Direction.LEFT));
        Assertions.assertFalse(detector.checkCollision(tank, Direction.RIGHT));
    }

    @Test
    public void checkAwayCollisionTest() {
        CollisionDetector detector = new CollisionDetector();
        Tank tank = new Tank(0, new GridPoint2(0, 0));

        detector.addCollidable(tank)
                .addCollidable(new Tree(new GridPoint2(0, 2)))
                .addCollidable(new Tree(new GridPoint2(2, 0)))
                .addCollidable(new Tree(new GridPoint2(1, 1)))
                .addCollidable(new Tree(new GridPoint2(0, -2)))
                .addCollidable(new Tree(new GridPoint2(-2, 2)));

        Assertions.assertFalse(detector.checkCollision(tank, Direction.UP));
        Assertions.assertFalse(detector.checkCollision(tank, Direction.DOWN));
        Assertions.assertFalse(detector.checkCollision(tank, Direction.LEFT));
        Assertions.assertFalse(detector.checkCollision(tank, Direction.RIGHT));
    }
}