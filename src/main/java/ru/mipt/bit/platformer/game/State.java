package ru.mipt.bit.platformer.game;

import ru.mipt.bit.platformer.map.Map;
import ru.mipt.bit.platformer.objects.Tank;
import ru.mipt.bit.platformer.objects.Tree;

public class State {
    protected final float MOVEMENT_SPEED = 0.4f;

    private final Tank player;
    private final Tree tree;
    private final Map map;

    private float playerMovementProgress = 1f;

    public State(Tank tank, Tree tree, Map map, float playerMovementProgress) {
        this.player = tank;
        this.tree = tree;
        this.map = map;
        this.playerMovementProgress = playerMovementProgress;
    }

    protected Map getMap() {
        return map;
    }

    protected Tank getPlayer() {
        return player;
    }

    protected Tree getTree() {
        return tree;
    }

    protected float getPlayerMovementProgress() {
        return playerMovementProgress;
    }

    protected void setPlayerMovementProgress(float playerMovementProgress) {
        this.playerMovementProgress = playerMovementProgress;
    }
}
