package ru.mipt.bit.platformer.base;

public interface LevelListener {
    void onObjectDeath(GameObject object);
    void onNewObject(GameObject object);
}
