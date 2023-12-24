package ru.mipt.bit.platformer.base;

import java.util.ArrayList;
import java.util.Collection;

public class Level {
    private final Collection<GameObject> objects = new ArrayList<GameObject>();
    private final Collection<LevelListener> listeners = new ArrayList<>();

    private final ActionQueue queue;

    public Level (ActionQueue queue) {
        this.queue = queue;
    }

    public void addAction(Action action) {
        queue.addAction(action);
    }

    public void addObject(GameObject object) {
        objects.add(object);
        for (LevelListener listener : listeners) {
            listener.onNewObject(object);
        }
    }

    public void executeAllActions() {
        queue.executeAllActions();
    }

    public void removeObject(GameObject object) {
        objects.remove(object);
        for (LevelListener listener : listeners) {
            listener.onObjectDeath(object);
        }
    }

    public Level addListener(LevelListener listener) {
        listeners.add(listener);
        return this;
    }
}
