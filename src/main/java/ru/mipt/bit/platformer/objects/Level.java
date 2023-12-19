package ru.mipt.bit.platformer.objects;

import java.util.ArrayList;
import java.util.Collection;

public class Level {
    private final Collection<GameObject> objects = new ArrayList<GameObject>();

    public Level () {}

    public void addObject(GameObject object) {
        objects.add(object);
    }

    public Collection<Tree> getTrees() {
        Collection<Tree> trees = new ArrayList<>();
        for (GameObject o: objects) {
            if (o instanceof Tree) {
                trees.add((Tree) o);
            }
        }
        return trees;
    }

    public Collection<Tank> getTanks() {
        Collection<Tank> tanks = new ArrayList<>();
        for (GameObject o: objects) {
            if (o instanceof Tank) {
                tanks.add((Tank) o);
            }
        }
        return tanks;
    }
}
