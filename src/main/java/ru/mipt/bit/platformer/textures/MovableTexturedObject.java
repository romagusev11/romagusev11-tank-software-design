package ru.mipt.bit.platformer.textures;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.GridPoint2;

import ru.mipt.bit.platformer.util.GdxGameUtils;
import ru.mipt.bit.platformer.util.TileMovement;

public class MovableTexturedObject extends TexturedObject {
    private final TileMovement tileMovement;
    protected GridPoint2 destination;
    protected float movementProgress;

    public MovableTexturedObject(String pathToTexture, GridPoint2 initialCoorditates, TileMovement tileMovement) {
        super(pathToTexture, initialCoorditates);
        this.tileMovement = tileMovement;
        destination = initialCoorditates;
        movementProgress = 0;
    }

    @Override
    public void draw(Batch batch) {
        tileMovement.moveRectangleBetweenTileCenters(rectangle, coordinates, destination, movementProgress);
        GdxGameUtils.drawTextureRegionUnscaled(batch, graphics, rectangle, rotation);
    }
}
