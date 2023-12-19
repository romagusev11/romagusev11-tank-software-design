package ru.mipt.bit.platformer.engine;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapRenderer;

import ru.mipt.bit.platformer.base.LevelMap;
import ru.mipt.bit.platformer.objects.Bullet;
import ru.mipt.bit.platformer.objects.GameObject;
import ru.mipt.bit.platformer.base.LevelListener;
import ru.mipt.bit.platformer.objects.Tank;
import ru.mipt.bit.platformer.objects.Tree;
import ru.mipt.bit.platformer.textures.Drawable;
import ru.mipt.bit.platformer.textures.MovableTexturedObject;
import ru.mipt.bit.platformer.textures.StaticTexturedObject;
import ru.mipt.bit.platformer.util.GdxGameUtils;

import java.util.HashMap;
import java.util.Map;

public class RenderEngine implements LevelListener {
    private final Batch batch;
    private final MapRenderer levelRenderer;
    private final Map<GameObject, Drawable> mesh = new HashMap<>();
    private final LevelMap levelMap;

    public RenderEngine(LevelMap map) {
        batch = new SpriteBatch();
        this.levelMap = map;

        // load level tiles
        levelRenderer = GdxGameUtils.createSingleLayerMapRenderer(map.getLevel(), batch);
    }

    public void render() {
        levelRenderer.render();

        // start recording all drawing commands
        batch.begin();

        // render everything
        for (Drawable d : mesh.values()) {
            d.draw(batch);
        }

        // submit all drawing requests
        batch.end();
    }

    public void dispose() {
        for (Drawable d : mesh.values()) {
            d.dispose();
        }
        levelMap.getLevel().dispose();
        batch.dispose();
    }

    @Override
    public void onObjectDeath(GameObject object) {
        mesh.remove(object);
    }

    @Override
    public void onNewObject(GameObject object) {
        if (object instanceof Tank) {
            Tank tank = (Tank) object;
            mesh.put(tank, new MovableTexturedObject("images/tank_blue.png", levelMap.getTileMovement(), tank));
        } else if (object instanceof Tree) {
            Tree tree = (Tree) object;
            mesh.put(tree, new StaticTexturedObject("images/greenTree.png", levelMap.getGroundLayer(), tree));
        } else if (object instanceof Bullet) {
            Bullet bullet = (Bullet) object;
            mesh.put(bullet, new MovableTexturedObject("images/bullet.png", levelMap.getTileMovement(), bullet));
        }
    }
}
