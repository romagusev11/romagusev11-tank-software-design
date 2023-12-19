package ru.mipt.bit.platformer.textures;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import static ru.mipt.bit.platformer.util.GdxGameUtils.createBoundingRectangle;

public abstract class Texture implements Drawable {
    protected final com.badlogic.gdx.graphics.Texture texture;
    protected final TextureRegion graphics;
    protected final Rectangle rectangle;

    public Texture(String pathToTexture) {
        texture = new com.badlogic.gdx.graphics.Texture(pathToTexture);
        graphics = new TextureRegion(texture);
        rectangle = createBoundingRectangle(graphics);
    }
    @Override
    public void dispose() {
        texture.dispose();
    }
}
