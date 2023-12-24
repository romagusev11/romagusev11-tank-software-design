package ru.mipt.bit.platformer.textures;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.GridPoint2;

import ru.mipt.bit.platformer.base.GameObject;
import ru.mipt.bit.platformer.util.GdxGameUtils;


public class StaticTexturedObject extends Texture {
    protected final TiledMapTileLayer groundLayer;
    protected final GameObject object;

    public StaticTexturedObject(String pathToTexture, TiledMapTileLayer groundLayer, GameObject object) {
        super(pathToTexture);
        this.groundLayer = groundLayer;
        this.object = object;
    }

    @Override
    public void draw(Batch batch) {
        GridPoint2 coordinates = object.getCoordinates();
        float rotation = object.getRotation();
        GdxGameUtils.moveRectangleAtTileCenter(groundLayer, rectangle, coordinates);
        GdxGameUtils.drawTextureRegionUnscaled(batch, graphics, rectangle, rotation);
    }
}