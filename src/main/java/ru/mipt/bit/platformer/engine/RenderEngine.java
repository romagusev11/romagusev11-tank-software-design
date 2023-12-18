package ru.mipt.bit.platformer.engine;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapRenderer;

import ru.mipt.bit.platformer.base.Map;
import ru.mipt.bit.platformer.base.Mesh;
import ru.mipt.bit.platformer.textures.Drawable;
import ru.mipt.bit.platformer.util.GdxGameUtils;

public class RenderEngine {
    private final Batch batch;
    private final MapRenderer levelRenderer;
    private final Mesh mesh;
    private final Map map;

    public RenderEngine(Map map, Mesh mesh) {
        batch = new SpriteBatch();
        this.mesh = mesh;
        this.map = map;

        // load level tiles
        levelRenderer = GdxGameUtils.createSingleLayerMapRenderer(map.getLevel(), batch);
    }

    public void render() {
        levelRenderer.render();

        // start recording all drawing commands
        batch.begin();

        // render everything
        for (Drawable d : mesh.getMesh()) {
            d.draw(batch);
        }

        // submit all drawing requests
        batch.end();
    }

    public void dispose() {
        for (Drawable d : mesh.getMesh()) {
            d.dispose();
        }
        map.getLevel().dispose();
        batch.dispose();
    }
}
