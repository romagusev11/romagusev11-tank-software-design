package ru.mipt.bit.platformer;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.math.GridPoint2;

import ru.mipt.bit.platformer.objects.Tree;
import ru.mipt.bit.platformer.objects.Tank;
import ru.mipt.bit.platformer.base.Map;
import ru.mipt.bit.platformer.base.State;
import ru.mipt.bit.platformer.engine.InputHandler;
import ru.mipt.bit.platformer.engine.LogicEngine;
import ru.mipt.bit.platformer.engine.RenderEngine;

import static com.badlogic.gdx.graphics.GL20.GL_COLOR_BUFFER_BIT;

public class GameDesktopLauncher implements ApplicationListener {

    private State state;

    private RenderEngine renderEngine;
    private LogicEngine logicEngine;
    private InputHandler inputHandler;  

    @Override
    public void create() {
        Map map = new Map("level.tmx");
        Tank player = new Tank("images/tank_blue.png", new GridPoint2(1, 1), 0);
        Tree tree = new Tree("images/greenTree.png", new GridPoint2(1, 3));
        state = new State(player, tree, map);
        renderEngine = new RenderEngine(state);
        logicEngine = new LogicEngine(state);
        inputHandler = new InputHandler(logicEngine);
    }

    @Override
    public void render() {
        // clear the screen
        Gdx.gl.glClearColor(0f, 0f, 0.2f, 1f);
        Gdx.gl.glClear(GL_COLOR_BUFFER_BIT);

        // get time passed since the last render
        float deltaTime = Gdx.graphics.getDeltaTime();

        inputHandler.handleInput();

        // calculate interpolated player screen coordinates

        logicEngine.calculatePlayerCoordinates(deltaTime);

        renderEngine.render();
    }

    @Override
    public void resize(int width, int height) {
        // do not react to window resizing
    }

    @Override
    public void pause() {
        // game doesn't get paused
    }

    @Override
    public void resume() {
        // game doesn't get paused
    }

    @Override
    public void dispose() {
        // dispose of all the native resources (classes which implement com.badlogic.gdx.utils.Disposable)
        renderEngine.dispose();
    }

    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        // level width: 10 tiles x 128px, height: 8 tiles x 128px
        config.setWindowedMode(1280, 1024);
        new Lwjgl3Application(new GameDesktopLauncher(), config);
    }
}
