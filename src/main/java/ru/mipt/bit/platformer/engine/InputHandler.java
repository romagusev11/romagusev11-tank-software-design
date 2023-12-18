package ru.mipt.bit.platformer.engine;

import com.badlogic.gdx.Gdx;

import ru.mipt.bit.platformer.base.Direction;

import static com.badlogic.gdx.Input.Keys.*;

public class InputHandler {

    private final LogicEngine logicEngine;

    public InputHandler(LogicEngine logicEngine) {
        this.logicEngine = logicEngine;
    }

    public void handleInput() {
        if (Gdx.input.isKeyPressed(UP) || Gdx.input.isKeyPressed(W)) {
                logicEngine.updatePlayerDestination(Direction.UP);
            }
        if (Gdx.input.isKeyPressed(LEFT) || Gdx.input.isKeyPressed(A)) {
                logicEngine.updatePlayerDestination(Direction.LEFT);
            }
        if (Gdx.input.isKeyPressed(DOWN) || Gdx.input.isKeyPressed(S)) {
                logicEngine.updatePlayerDestination(Direction.DOWN);
            }
        if (Gdx.input.isKeyPressed(RIGHT) || Gdx.input.isKeyPressed(D)) {
            logicEngine.updatePlayerDestination(Direction.RIGHT);
        }
    }
}
