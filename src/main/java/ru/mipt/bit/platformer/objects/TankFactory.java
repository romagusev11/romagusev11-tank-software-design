package ru.mipt.bit.platformer.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Rectangle;
import ru.mipt.bit.platformer.util.GdxGameUtils;

public class TankFactory {
    private float rotation = 0f;
    private Texture tankTexture;
    private int x = 0;
    private int y = 0;
    
    public TankFactory() {};

    public TankFactory setTankTexture(Texture tankTexture) {
        this.tankTexture = tankTexture;
        return this;
    }

    public TankFactory setTankCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public TankFactory setTankRotation(float rotation) {
        this.rotation = rotation;
        return this;
    }

    public Tank createTank() {
        TextureRegion graphics = new TextureRegion(tankTexture);
        Rectangle borders = GdxGameUtils.createBoundingRectangle(graphics);
        GridPoint2 coordinates = new GridPoint2(x, y);
        GridPoint2 destination = new GridPoint2(coordinates);
        return new Tank(rotation, tankTexture, graphics, borders, coordinates, destination);
    }

}