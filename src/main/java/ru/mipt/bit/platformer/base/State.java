package ru.mipt.bit.platformer.base;

import ru.mipt.bit.platformer.objects.Tank;
import ru.mipt.bit.platformer.objects.Tree;

public class State {
    private final Tank player;
    private final Tree tree;
    private final Map map;

    public State(Tank tank, Tree tree, Map map) {
        this.player = tank;
        this.tree = tree;
        this.map = map;
    }

    public Map getMap() {
        return map;
    }

    public Tank getPlayer() {
        return player;
    }

    public Tree getTree() {
        return tree;
    }
}
