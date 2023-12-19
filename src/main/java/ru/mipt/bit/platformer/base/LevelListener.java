package ru.mipt.bit.platformer.base;

import ru.mipt.bit.platformer.objects.GameObject;

public interface LevelListener {
    void onObjectDeath(GameObject object);
    void onNewObject(GameObject object);
}
