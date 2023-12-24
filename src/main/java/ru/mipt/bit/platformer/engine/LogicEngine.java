package ru.mipt.bit.platformer.engine;

import ru.mipt.bit.platformer.base.GameObject;
import ru.mipt.bit.platformer.base.Level;
import ru.mipt.bit.platformer.base.LevelListener;

import java.util.*;

public class LogicEngine implements LevelListener {
    private final Collection<GameObject> objects = new ArrayList<>();

    private final Level level;

    public LogicEngine(Level level) {
        this.level = level;
    }

    public void tick(float deltaTime) {
        level.executeAllActions();
        for (GameObject object : objects) {
            object.live(deltaTime);
        }
    }
    @Override
    public void onObjectDeath(GameObject object) { objects.remove(object); }

    @Override
    public void onNewObject(GameObject object) {
        objects.add(object);
    }
}


