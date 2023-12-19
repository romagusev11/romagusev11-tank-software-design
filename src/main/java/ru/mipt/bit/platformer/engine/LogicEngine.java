package ru.mipt.bit.platformer.engine;

import ru.mipt.bit.platformer.actions.Action;
import ru.mipt.bit.platformer.actions.ActionQueue;
import ru.mipt.bit.platformer.objects.GameObject;
import ru.mipt.bit.platformer.base.LevelListener;
import ru.mipt.bit.platformer.player.Player;

import java.util.*;

public class LogicEngine implements LevelListener {
    private final CollisionDetector detector;
    private final Collection<GameObject> objects = new ArrayList<>();
    private final ActionQueue queue;


    public Player fetchPlayer() {
        for (GameObject object: objects) {
            if (object instanceof Player) {
                return (Player) object;
            }
        }
        return null;
    }

    public LogicEngine(CollisionDetector detector, ActionQueue queue) {
        this.queue = queue;
        this.detector = detector;
    }

    public CollisionDetector getDetector() {
        return detector;
    }

    public void tick(float deltaTime) {
        queue.executeAllActions();
        for (GameObject object : objects) {
            object.live(deltaTime);
        }
    }

    public void addAction(Action action) {
        queue.addAction(action);
    }

    @Override
    public void onObjectDeath(GameObject object) { objects.remove(object); }

    @Override
    public void onNewObject(GameObject object) {
        objects.add(object);
    }
}


