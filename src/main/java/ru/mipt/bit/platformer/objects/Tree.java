package ru.mipt.bit.platformer.objects;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.GridPoint2;

import ru.mipt.bit.platformer.textures.StaticTexturedObject;

public class Tree extends StaticTexturedObject implements Collidable {

    public Tree(String pathToTexture, GridPoint2 coordinates, TiledMapTileLayer groundLayer) {
        super(pathToTexture, coordinates, groundLayer);
    }

    public GridPoint2 getCoordinates() {
        return coordinates;
    }
}
