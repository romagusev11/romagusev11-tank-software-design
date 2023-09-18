package ru.mipt.bit.platformer.game;

import com.badlogic.gdx.Gdx;
import static com.badlogic.gdx.Input.Keys.*;

public class InputHandler {

    private final LogicEngine logicEngine;

    public InputHandler(LogicEngine logicEngine) {
        this.logicEngine = logicEngine;
    }

    public void handleInput() {
        if (Gdx.input.isKeyPressed(UP) || Gdx.input.isKeyPressed(W)) {
                logicEngine.updatePlayerPosition(Direction.UP);
            }
        if (Gdx.input.isKeyPressed(LEFT) || Gdx.input.isKeyPressed(A)) {
                logicEngine.updatePlayerPosition(Direction.LEFT);
            }
        if (Gdx.input.isKeyPressed(DOWN) || Gdx.input.isKeyPressed(S)) {
                logicEngine.updatePlayerPosition(Direction.DOWN);
            }
        if (Gdx.input.isKeyPressed(RIGHT) || Gdx.input.isKeyPressed(D)) {
            logicEngine.updatePlayerPosition(Direction.RIGHT);
        }
    }
}
