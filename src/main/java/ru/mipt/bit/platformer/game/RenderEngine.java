package ru.mipt.bit.platformer.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapRenderer;

import ru.mipt.bit.platformer.util.GdxGameUtils;

public class RenderEngine {
    private final Batch batch;
    private final MapRenderer levelRenderer;

    private final State state;

    public RenderEngine(State state) {
        this.state = state;
        batch = new SpriteBatch();

        // load level tiles
        levelRenderer = GdxGameUtils.createSingleLayerMapRenderer(state.getMap().getLevel(), batch);
    }

    public void render() {
        levelRenderer.render();

        // start recording all drawing commands
        batch.begin();

        // render player
        GdxGameUtils.drawTextureRegionUnscaled(batch, state.getPlayer().getGraphics(), state.getPlayer().getRectangle(), state.getPlayer().getRotation());

        // render tree obstacle
        GdxGameUtils.drawTextureRegionUnscaled(batch, state.getTree().getObstacleGraphics(), state.getTree().getObstacleRectangle(), 0f);

        // submit all drawing requests
        batch.end();
    }

    public void dispose() {
        state.getTree().getTexture().dispose();
        state.getPlayer().getTexture().dispose();
        state.getMap().getLevel().dispose();
        batch.dispose();
    }
}
