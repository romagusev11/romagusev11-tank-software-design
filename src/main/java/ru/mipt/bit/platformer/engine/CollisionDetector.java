package ru.mipt.bit.platformer.engine;

import static ru.mipt.bit.platformer.util.GdxGameUtils.move;

import java.util.ArrayList;
import java.util.Collection;

import com.badlogic.gdx.math.GridPoint2;

import ru.mipt.bit.platformer.base.Direction;
import ru.mipt.bit.platformer.objects.GameObject;
import ru.mipt.bit.platformer.base.LevelListener;

public class CollisionDetector implements LevelListener {

    private final Collection<GameObject> collision = new ArrayList<GameObject>();

    public CollisionDetector() {}

    public CollisionDetector addCollidable(GameObject object) {
        collision.add(object);
        return this;
    }

    public boolean checkCollision(GameObject from, Direction direction) {
        GridPoint2 destination = move(from.getCoordinates(), direction.x, direction.y);
        for (GameObject c : collision) {
            if (!c.equals(from) && destination.equals(c.getCoordinates())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void onObjectDeath(GameObject object) {
        collision.remove(object);
    }

    @Override
    public void onNewObject(GameObject object) {
        this.addCollidable(object);
    }
}
