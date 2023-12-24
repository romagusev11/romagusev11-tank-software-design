package ru.mipt.bit.platformer.engine;

import com.badlogic.gdx.Gdx;

import ru.mipt.bit.platformer.actions.Move;
import ru.mipt.bit.platformer.actions.Shoot;
import ru.mipt.bit.platformer.base.Direction;
import ru.mipt.bit.platformer.base.Level;
import ru.mipt.bit.platformer.detector.CollisionDetector;
import ru.mipt.bit.platformer.player.Player;

import static com.badlogic.gdx.Input.Keys.*;

public class InputHandler {
    private final Level level;
    private final Player player;
    private final CollisionDetector detector;

    public InputHandler(Player player, Level level, CollisionDetector detector) {
        this.level = level;
        this.player = player;
        this.detector = detector;
    }

    public void handleInput() {
        if (Gdx.input.isKeyPressed(UP) || Gdx.input.isKeyPressed(W)) {
            level.addAction(new Move(player, detector, Direction.UP));
            }
        if (Gdx.input.isKeyPressed(LEFT) || Gdx.input.isKeyPressed(A)) {
            level.addAction(new Move(player, detector, Direction.LEFT));
            }
        if (Gdx.input.isKeyPressed(DOWN) || Gdx.input.isKeyPressed(S)) {
            level.addAction(new Move(player, detector, Direction.DOWN));
            }
        if (Gdx.input.isKeyPressed(RIGHT) || Gdx.input.isKeyPressed(D)) {
            level.addAction(new Move(player, detector, Direction.RIGHT));
        }
        if (Gdx.input.isKeyPressed(SPACE)) {
            level.addAction(new Shoot(player, level, detector));
        }
    }
}
