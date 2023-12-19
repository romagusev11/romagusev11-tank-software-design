package ru.mipt.bit.platformer;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

import ru.mipt.bit.platformer.AI.AITankController;
import ru.mipt.bit.platformer.IO.RandomLevelLoader;
import ru.mipt.bit.platformer.actions.ActionQueue;
import ru.mipt.bit.platformer.base.Level;
import ru.mipt.bit.platformer.base.LevelMap;
import ru.mipt.bit.platformer.engine.CollisionDetector;
import ru.mipt.bit.platformer.engine.InputHandler;
import ru.mipt.bit.platformer.engine.LogicEngine;
import ru.mipt.bit.platformer.engine.RenderEngine;

import static com.badlogic.gdx.graphics.GL20.GL_COLOR_BUFFER_BIT;

public class GameDesktopLauncher implements ApplicationListener {

    private RenderEngine renderEngine;
    private LogicEngine logicEngine;
    private InputHandler inputHandler;  

    @Override
    public void create() {
        LevelMap map = new LevelMap("level.tmx");
        //Level level = new FileLevelLoader("level.txt").loadLevel();
        CollisionDetector detector = new CollisionDetector();
        ActionQueue queue = new ActionQueue();
        logicEngine = new LogicEngine(detector, queue);
        renderEngine = new RenderEngine(map);
        Level level = new Level(queue);
        AITankController controller = new AITankController(level, detector);
        level.addListener(renderEngine).addListener(detector).addListener(logicEngine).addListener(controller);
        new RandomLevelLoader(10, 10, 0.1f).loadLevel(level);

        inputHandler = new InputHandler(logicEngine, level);
    }

    @Override
    public void render() {
        // clear the screen
        Gdx.gl.glClearColor(0f, 0f, 0.2f, 1f);
        Gdx.gl.glClear(GL_COLOR_BUFFER_BIT);

        // get time passed since the last render
        float deltaTime = Gdx.graphics.getDeltaTime();

        inputHandler.handleInput();

        logicEngine.tick(deltaTime);

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
