package ru.mipt.bit.platformer.actions;

import java.util.LinkedList;
import java.util.Queue;

public class ActionQueue {
    private final Queue<Action> actionQueue = new LinkedList<>();

    public void addAction(Action action) {
        actionQueue.add(action);
    }

    public void executeAllActions() {
        int len = actionQueue.size();
        for(int i = 0; i < len; ++i) {
            actionQueue.poll().execute();
        }
    }
}
