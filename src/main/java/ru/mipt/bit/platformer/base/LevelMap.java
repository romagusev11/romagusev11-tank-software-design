package ru.mipt.bit.platformer.base;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Interpolation;

import ru.mipt.bit.platformer.util.GdxGameUtils;
import ru.mipt.bit.platformer.util.TileMovement;


public class LevelMap {
    private final TiledMap level;
    private final TiledMapTileLayer groundLayer;
    private final TileMovement tileMovement;

    public LevelMap(String fileName) {
        level = new TmxMapLoader().load(fileName);
        groundLayer = GdxGameUtils.getSingleLayer(level);
        tileMovement = new TileMovement(groundLayer, Interpolation.smooth);
    }

    public TiledMap getLevel() {
        return level;
    }

    public TiledMapTileLayer getGroundLayer() {
        return groundLayer;
    }

    public TileMovement getTileMovement() {
        return tileMovement;
    }
}
