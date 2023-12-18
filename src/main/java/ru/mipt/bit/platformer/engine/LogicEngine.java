package ru.mipt.bit.platformer.engine;

import com.badlogic.gdx.math.GridPoint2;
import static ru.mipt.bit.platformer.util.GdxGameUtils.*;

import ru.mipt.bit.platformer.base.Direction;
import ru.mipt.bit.platformer.base.State;
import ru.mipt.bit.platformer.objects.Tank;

public class LogicEngine {

    private final State state;

    public LogicEngine(State state) {
        this.state = state;
    }

    private boolean checkCollision(GridPoint2 from, GridPoint2 to, Direction direction) {
        return move(from, direction.x, direction.y).equals(to);
    }

    public void updatePlayerDestination(Direction direction) {
        Tank player = state.getPlayer();
        if (player.getMovementProgress() >= 1) {
            // check potential player destination for collision with obstacles
            if (!checkCollision(player.getCoordinates(), state.getTree().getCoordinates(), direction)) {
                player.move(direction);
            }
            player.rotate(direction);
        }
    }

    public void calculatePlayerCoordinates(float deltaTime) {
        Tank player = state.getPlayer();
        player.updateMovementProgress(deltaTime);
        if (player.getMovementProgress() >= 1) {
            // record that the player has reached his/her destination
            player.setCoordinates(player.getDestination());
        }
    }
}


