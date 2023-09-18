package ru.mipt.bit.platformer.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Rectangle;

public class Tank {
    private float rotation;
    private Texture texture;
    private TextureRegion graphics;
    private Rectangle rectangle;
    private GridPoint2 coordinates;
    private GridPoint2 destination;
    
    protected Tank(float rotation, Texture texture, TextureRegion graphics, Rectangle borders, GridPoint2 coordinates, GridPoint2 destination) {
        this.rotation = rotation;
        this.texture = texture;
        this.graphics = graphics;
        this.rectangle = borders;
        this.coordinates = coordinates;
        this.destination = destination;
    }

    public void setDestination(GridPoint2 destination) {
        this.destination = destination;
    }

    public void setCoordinates(GridPoint2 coordinates) {
        this.coordinates = coordinates;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public GridPoint2 getCoordinates() {
        return coordinates;
    }

    public GridPoint2 getDestination() {
        return destination;
    }

    public TextureRegion getGraphics() {
        return graphics;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public float getRotation() {
        return rotation;
    }

    public Texture getTexture() {
        return texture;
    }
}
