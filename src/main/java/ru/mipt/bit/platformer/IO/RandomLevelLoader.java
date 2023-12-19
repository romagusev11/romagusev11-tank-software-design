package ru.mipt.bit.platformer.IO;

import com.badlogic.gdx.math.GridPoint2;
import ru.mipt.bit.platformer.objects.Level;
import ru.mipt.bit.platformer.objects.Tank;
import ru.mipt.bit.platformer.objects.Tree;

import java.util.concurrent.ThreadLocalRandom;

public class RandomLevelLoader implements LevelLoader {
    private final int sizeX;
    private final int sizeY;
    private final float density;

    private final static int BOUND = 1000;

    public RandomLevelLoader(int sizeX, int sizeY, float density) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.density = density;
    }

    @Override
    public Level loadLevel() {
        Level level = new Level();

        GridPoint2 tankCoordinates = new GridPoint2(ThreadLocalRandom.current().nextInt(0, sizeX),
                                                    ThreadLocalRandom.current().nextInt(0, sizeY));
        level.addObject(new Tank(0, tankCoordinates));
        for (int x = 0; x < sizeX; ++x) {
            for (int y = 0; y < sizeY; ++y) {
                int randomNum = ThreadLocalRandom.current().nextInt(0, BOUND);
                if (randomNum < density * BOUND) {
                    GridPoint2 tree = new GridPoint2(x, y);
                    if (!tree.equals(tankCoordinates)) {
                        level.addObject(new Tree(tree));
                    }
                }
            }
        }
        return level;
    }
}
