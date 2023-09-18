package ru.mipt.bit.platformer.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Rectangle;
import ru.mipt.bit.platformer.util.GdxGameUtils;

public final class TreeFactory {
    private Texture treeTexture;
    private int x = 0;
    private int y = 0;

    public TreeFactory() {}

    public TreeFactory setTreeTexture(Texture treeTexture) {
        this.treeTexture = treeTexture;
        return this;
    }

    public TreeFactory setTreeCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public Tree createTree(TiledMapTileLayer groundLayer) {
        TextureRegion treeObstacleGraphics = new TextureRegion(treeTexture);
        GridPoint2 treeObstacleCoordinates = new GridPoint2(x, y);
        Rectangle treeObstacleRectangle = GdxGameUtils.createBoundingRectangle(treeObstacleGraphics);
        GdxGameUtils.moveRectangleAtTileCenter(groundLayer, treeObstacleRectangle, treeObstacleCoordinates);
        return new Tree(treeTexture, treeObstacleGraphics, treeObstacleCoordinates, treeObstacleRectangle);
    }
}
