package ru.mipt.bit.platformer.engine;

import static ru.mipt.bit.platformer.util.GdxGameUtils.move;

import java.util.Collection;

import com.badlogic.gdx.math.GridPoint2;

import ru.mipt.bit.platformer.base.Direction;
import ru.mipt.bit.platformer.objects.Collidable;

public class CollisionDetector {

    private final Collection<Collidable> collision;

    public CollisionDetector(Collection<Collidable> collision) {
        this.collision = collision;
    }

    public boolean checkCollision(Collidable from, Direction direction) {
        GridPoint2 destination = move(from.getCoordinates(), direction.x, direction.y);
        for (Collidable c : collision) {
            if (destination.equals(c.getCoordinates())) {
                return false;
            }
        }
        return true;
    }
}
