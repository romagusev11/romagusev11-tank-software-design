package ru.mipt.bit.platformer.textures;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.GridPoint2;

import ru.mipt.bit.platformer.util.GdxGameUtils;


public class StaticTexturedObject extends TexturedObject {
    protected TiledMapTileLayer groundLayer;

    public StaticTexturedObject(String pathToTexture, GridPoint2 initialCoorditates, TiledMapTileLayer groundLayer) {
        super(pathToTexture, initialCoorditates);
        this.groundLayer = groundLayer;
    }

    @Override
    public void draw(Batch batch) {
        GdxGameUtils.moveRectangleAtTileCenter(groundLayer, rectangle, coordinates);
        GdxGameUtils.drawTextureRegionUnscaled(batch, graphics, rectangle, rotation);
    }
}