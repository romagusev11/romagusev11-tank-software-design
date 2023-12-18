package ru.mipt.bit.platformer.textures;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Rectangle;

import ru.mipt.bit.platformer.objects.Drawable;

import static ru.mipt.bit.platformer.util.GdxGameUtils.createBoundingRectangle;

public abstract class TexturedObject implements Drawable {
    protected Texture texture;
    protected TextureRegion graphics;
    protected Rectangle rectangle;
    protected GridPoint2 coordinates;
    protected float rotation;

    public TexturedObject(String pathToTexture, GridPoint2 initialCoordinates) {
        texture = new Texture(pathToTexture);
        graphics = new TextureRegion(texture);
        rectangle = createBoundingRectangle(graphics);
        coordinates = initialCoordinates;
        rotation = 0;
    }
    @Override
    public void dispose() {
        texture.dispose();
    }
}
