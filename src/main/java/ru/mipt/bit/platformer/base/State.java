package ru.mipt.bit.platformer.base;

import java.util.ArrayList;
import java.util.Collection;

import ru.mipt.bit.platformer.objects.Collidable;
import ru.mipt.bit.platformer.objects.Drawable;
import ru.mipt.bit.platformer.objects.Tank;
import ru.mipt.bit.platformer.objects.Tree;

public class State {
    private final Tank player;
    private final Map map;
    private final Collection<Drawable> mesh = new ArrayList<Drawable>();;
    private final Collection<Collidable> collision = new ArrayList<Collidable>();;

    public State(Tank tank, Tree tree, Map map) {
        this.player = tank;
        this.map = map;
        collision.add(tree);
        collision.add(player);
        mesh.add(player);
        mesh.add(tree);
    }

    public Map getMap() {
        return map;
    }

    public Collection<Drawable> getMesh() {
        return mesh;
    }

    public Tank getPlayer() {
        return player;
    }

    public Collection<Collidable> getCollision() {
        return collision;
    }
}
