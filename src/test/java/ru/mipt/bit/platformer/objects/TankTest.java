package ru.mipt.bit.platformer.objects;

import com.badlogic.gdx.math.GridPoint2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.mipt.bit.platformer.base.Direction;
import ru.mipt.bit.platformer.engine.CollisionDetector;

class TankTest {

    @Test
    void updateMovementProgressTest() {
        Tank tank = new Tank(0, new GridPoint2(0, 0), 0.4f);

        Assertions.assertEquals(0, tank.getMovementProgress());

        tank.updateMovementProgress(0.4f);

        Assertions.assertEquals(1, tank.getMovementProgress());

        tank.updateMovementProgress(0.4f);

        Assertions.assertEquals(1, tank.getMovementProgress());
    }

    @Test
    void tryToMoveNoCollisionTest() {
        Tank tank = new Tank(0, new GridPoint2(0, 0), 0.4f);
        CollisionDetector detector = new CollisionDetector().addCollidable(tank);

        tank.tryToMove(Direction.UP, detector);

        Assertions.assertEquals(0, tank.getMovementProgress());
        Assertions.assertEquals(new GridPoint2(0, 0), tank.getDestination());
        Assertions.assertEquals(0, tank.getRotation());

        tank.updateMovementProgress(0.2f);
        tank.tryToMove(Direction.UP, detector);

        Assertions.assertEquals(0.5, tank.getMovementProgress());
        Assertions.assertEquals(new GridPoint2(0, 0), tank.getDestination());
        Assertions.assertEquals(0, tank.getRotation());

        tank.updateMovementProgress(0.2f);
        tank.tryToMove(Direction.UP, detector);

        Assertions.assertEquals(0, tank.getMovementProgress());
        Assertions.assertEquals(new GridPoint2(0, 1), tank.getDestination());
        Assertions.assertEquals(new GridPoint2(0, 0), tank.getCoordinates());
        Assertions.assertEquals(90, tank.getRotation());

        tank.updateMovementProgress(0.4f);
        Assertions.assertEquals(new GridPoint2(0, 1), tank.getCoordinates());
    }

    @Test
    void tryToMoveEncounterCollisionTest() {
        Tank tank = new Tank(0, new GridPoint2(0, 0), 0.4f);
        CollisionDetector detector = new CollisionDetector().addCollidable(tank)
                .addCollidable(new Tree(new GridPoint2(0, 1)));

        tank.tryToMove(Direction.UP, detector);

        Assertions.assertEquals(0, tank.getMovementProgress());
        Assertions.assertEquals(new GridPoint2(0, 0), tank.getDestination());
        Assertions.assertEquals(0, tank.getRotation());

        tank.updateMovementProgress(0.2f);
        tank.tryToMove(Direction.UP, detector);

        Assertions.assertEquals(0.5, tank.getMovementProgress());
        Assertions.assertEquals(new GridPoint2(0, 0), tank.getDestination());
        Assertions.assertEquals(0, tank.getRotation());

        tank.updateMovementProgress(0.2f);
        tank.tryToMove(Direction.UP, detector);

        Assertions.assertEquals(1, tank.getMovementProgress());
        Assertions.assertEquals(new GridPoint2(0, 0), tank.getDestination());
        Assertions.assertEquals(new GridPoint2(0, 0), tank.getCoordinates());
        Assertions.assertEquals(90, tank.getRotation());

        tank.updateMovementProgress(0.4f);
        Assertions.assertEquals(new GridPoint2(0, 0), tank.getCoordinates());
    }
}