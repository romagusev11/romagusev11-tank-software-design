package ru.mipt.bit.platformer.IO;

import com.badlogic.gdx.math.GridPoint2;
import ru.mipt.bit.platformer.actions.CheckIsAlive;
import ru.mipt.bit.platformer.player.Player;
import ru.mipt.bit.platformer.base.Level;
import ru.mipt.bit.platformer.objects.Tree;
import ru.mipt.bit.platformer.objects.tank.Tank;

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
    public void loadLevel(Level level) {
        GridPoint2 playerCoordinates = new GridPoint2(ThreadLocalRandom.current().nextInt(1, sizeX),
                                                      ThreadLocalRandom.current().nextInt(1, sizeY));
        Player player = new Player(0, playerCoordinates);
        level.addObject(player);
        level.addAction(new CheckIsAlive(player, level));

        for (int x = 0; x < sizeX + 1; ++x) {
            for (int y = 0; y < sizeY + 1; ++y) {
                if (x == 0 || x == sizeX || y == 0 || y == sizeY) {
                    GridPoint2 tree = new GridPoint2(x, y);
                    if (!tree.equals(playerCoordinates)) {
                        level.addObject(new Tree(tree));
                    }
                    continue;
                }
                int randomNum = ThreadLocalRandom.current().nextInt(0, BOUND * 2);
                if (randomNum < density * BOUND) {
                    GridPoint2 tree = new GridPoint2(x, y);
                    if (!tree.equals(playerCoordinates)) {
                        level.addObject(new Tree(tree));
                    }
                } else if (randomNum < density * BOUND * 2) {
                    GridPoint2 tankCoordinates = new GridPoint2(x, y);
                    if (!tankCoordinates.equals(playerCoordinates)) {
                        Tank tank = new Tank(0, tankCoordinates);
                        level.addObject(tank);
                    }
                }
            }
        }
    }
}
