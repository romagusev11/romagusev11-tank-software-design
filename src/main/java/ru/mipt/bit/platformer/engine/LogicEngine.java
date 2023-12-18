package ru.mipt.bit.platformer.engine;

import com.badlogic.gdx.math.GridPoint2;
import static ru.mipt.bit.platformer.util.GdxGameUtils.*;

import java.util.Collection;

import ru.mipt.bit.platformer.base.Direction;
import ru.mipt.bit.platformer.objects.Collidable;
import ru.mipt.bit.platformer.objects.Tank;

public class LogicEngine {

    private final Tank player;
    private final Collection<Collidable> collision;

    public LogicEngine(Tank player, Collection<Collidable> collision) {
        this.player = player;
        this.collision = collision;
    }

    private boolean checkCollision(Collidable from, Direction direction) {
        GridPoint2 destination = move(from.getCoordinates(), direction.x, direction.y);
        for (Collidable c : collision) {
            if (destination.equals(c.getCoordinates())) {
                return false;
            }
        }
        return true;
    }

    public void updatePlayerDestination(Direction direction) {
        if (player.getMovementProgress() >= 1) {
            // check potential player destination for collision with obstacles
            if (checkCollision(player, direction)) {
                player.move(direction);
            }
            player.rotate(direction);
        }
    }

    public void calculatePlayerCoordinates(float deltaTime) {
        player.updateMovementProgress(deltaTime);
    }
}


