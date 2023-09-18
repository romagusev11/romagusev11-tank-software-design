package ru.mipt.bit.platformer.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Rectangle;

public class Tree {
    private final Texture texture;
    private final TextureRegion obstacleGraphics;
    private final GridPoint2 obstacleCoordinates;
    private final Rectangle obstacleRectangle;

    protected Tree(Texture texture, TextureRegion region, GridPoint2 coordinates, Rectangle bounds) {
        this.texture = texture;
        obstacleGraphics = region;
        obstacleCoordinates = coordinates;
        obstacleRectangle = bounds;
    }

    public Texture getTexture() {
        return texture;
    }

    public GridPoint2 getObstacleCoordinates() {
        return obstacleCoordinates;
    }

    public TextureRegion getObstacleGraphics() {
        return obstacleGraphics;
    }

    public Rectangle getObstacleRectangle() {
        return obstacleRectangle;
    }
}
