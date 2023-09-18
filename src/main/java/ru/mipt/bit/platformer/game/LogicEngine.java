package ru.mipt.bit.platformer.game;

import com.badlogic.gdx.math.GridPoint2;
import static ru.mipt.bit.platformer.util.GdxGameUtils.*;
import static com.badlogic.gdx.math.MathUtils.isEqual;

import ru.mipt.bit.platformer.objects.Tank;

public class LogicEngine {

    private final State state;

    public LogicEngine(State state) {
        this.state = state;
    }

    private boolean checkCollision(GridPoint2 from, GridPoint2 to, Direction direction) {
        switch (direction) {
            case UP:
                return to.equals(incrementedY(from));
            case DOWN:
                return to.equals(decrementedY(from));
            case LEFT:
                return to.equals(decrementedX(from));
            case RIGHT:
                return to.equals(incrementedX(from));
            default:
                return false;
        }
    }

    private void movePlayer(Direction direction) {
        Tank player = state.getPlayer();
        switch (direction) {
            case UP:
                player.setDestination(incrementedY(player.getDestination()));
                break;
            case DOWN:
                player.setDestination(decrementedY(player.getDestination()));
                break;
            case LEFT:
                player.setDestination(decrementedX(player.getDestination()));
                break;
            case RIGHT:
                player.setDestination(incrementedX(player.getDestination()));
                break;
        }
    }

    private void rotatePlayer(Direction direction) {
        Tank player = state.getPlayer();
        switch (direction) {
            case UP:
                player.setRotation(90f);
                break;
            case DOWN:
                player.setRotation(-90f);
                break;
            case LEFT:
                player.setRotation(-180f);
                break;
            case RIGHT:
                player.setRotation(0f);
                break;
        }
    }

    public void updatePlayerPosition(Direction direction) {
        if (isEqual(state.getPlayerMovementProgress(), 1f)) {
            // check potential player destination for collision with obstacles
            if (!checkCollision(state.getPlayer().getCoordinates(), state.getTree().getObstacleCoordinates(), direction)) {
                movePlayer(direction);
                state.setPlayerMovementProgress(0f);
            }
            rotatePlayer(direction);
        }
    }

    public void calculatePlayerCoordinates(float deltaTime) {
        Tank player = state.getPlayer();
        state.getMap().getTileMovement().moveRectangleBetweenTileCenters(player.getRectangle(), player.getCoordinates(), player.getDestination(), state.getPlayerMovementProgress());

        state.setPlayerMovementProgress(continueProgress(state.getPlayerMovementProgress(), deltaTime, state.MOVEMENT_SPEED));
        if (isEqual(state.getPlayerMovementProgress(), 1f)) {
            // record that the player has reached his/her destination
            player.setCoordinates(player.getDestination());
        }
    }
}


