package ru.mipt.bit.platformer.objects;

import com.badlogic.gdx.graphics.g2d.Batch;

public interface Drawable {
    void dispose();
    void draw(Batch batch);
}
