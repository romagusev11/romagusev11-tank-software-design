package ru.mipt.bit.platformer.textures;

import com.badlogic.gdx.graphics.g2d.Batch;

public interface Drawable {
    void dispose();
    void draw(Batch batch);
}
