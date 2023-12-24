package ru.mipt.bit.platformer.player;

import com.badlogic.gdx.math.GridPoint2;
import ru.mipt.bit.platformer.objects.tank.Tank;

public class Player extends Tank {

    public Player(float initialRotation, GridPoint2 coordinates) {
        super(initialRotation, coordinates);
    }

}
