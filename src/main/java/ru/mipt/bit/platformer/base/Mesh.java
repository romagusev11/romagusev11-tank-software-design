package ru.mipt.bit.platformer.base;

import java.util.ArrayList;
import java.util.Collection;

import ru.mipt.bit.platformer.textures.Drawable;

public class Mesh {
    private final Collection<Drawable> mesh = new ArrayList<Drawable>();;

    public Mesh() {}

    public Mesh addDrawable(Drawable drawable) {
        mesh.add(drawable);
        return this;
    }
    public Collection<Drawable> getMesh() {
        return mesh;
    }

}
