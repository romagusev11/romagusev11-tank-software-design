package ru.mipt.bit.platformer.textures;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.GridPoint2;

import ru.mipt.bit.platformer.objects.Movable;
import ru.mipt.bit.platformer.util.GdxGameUtils;
import ru.mipt.bit.platformer.util.TileMovement;

public class MovableTexturedObject extends Texture {
    private final TileMovement tileMovement;
    protected final Movable object;

    public MovableTexturedObject(String pathToTexture, TileMovement tileMovement, Movable object) {
        super(pathToTexture);
        this.tileMovement = tileMovement;
        this.object = object;
    }

    @Override
    public void draw(Batch batch) {
        GridPoint2 coordinates = object.getCoordinates();
        float rotation = object.getRotation();
        GridPoint2 destination = object.getDestination();
        float movementProgress = object.getMovementProgress();
        tileMovement.moveRectangleBetweenTileCenters(rectangle, coordinates, destination, movementProgress);
        GdxGameUtils.drawTextureRegionUnscaled(batch, graphics, rectangle, rotation);
    }
}
