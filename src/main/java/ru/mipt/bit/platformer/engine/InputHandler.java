package ru.mipt.bit.platformer.engine;

import com.badlogic.gdx.Gdx;

import ru.mipt.bit.platformer.actions.Move;
import ru.mipt.bit.platformer.actions.Shoot;
import ru.mipt.bit.platformer.base.Direction;
import ru.mipt.bit.platformer.base.Level;
import ru.mipt.bit.platformer.objects.Player;

import static com.badlogic.gdx.Input.Keys.*;

public class InputHandler {

    private final LogicEngine logicEngine;
    private final Player player;
    private final Level level;

    public InputHandler(LogicEngine logicEngine, Level level) {
        this.logicEngine = logicEngine;
        this.player = logicEngine.fetchPlayer();
        this.level = level;
    }

    public void handleInput() {
        if (Gdx.input.isKeyPressed(UP) || Gdx.input.isKeyPressed(W)) {
            logicEngine.addAction(new Move(player, logicEngine.getDetector(), Direction.UP));
            }
        if (Gdx.input.isKeyPressed(LEFT) || Gdx.input.isKeyPressed(A)) {
            logicEngine.addAction(new Move(player, logicEngine.getDetector(), Direction.LEFT));
            }
        if (Gdx.input.isKeyPressed(DOWN) || Gdx.input.isKeyPressed(S)) {
            logicEngine.addAction(new Move(player, logicEngine.getDetector(), Direction.DOWN));
            }
        if (Gdx.input.isKeyPressed(RIGHT) || Gdx.input.isKeyPressed(D)) {
            logicEngine.addAction(new Move(player, logicEngine.getDetector(), Direction.RIGHT));
        }
        if (Gdx.input.isKeyPressed(SPACE)) {
            logicEngine.addAction(new Shoot(player, level, logicEngine.getDetector()));
        }
    }
}
