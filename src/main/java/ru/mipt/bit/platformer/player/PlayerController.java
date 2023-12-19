package ru.mipt.bit.platformer.player;

import ru.mipt.bit.platformer.actions.CheckIsAlive;
import ru.mipt.bit.platformer.base.Level;
import ru.mipt.bit.platformer.base.LevelListener;
import ru.mipt.bit.platformer.objects.GameObject;

public class PlayerController implements LevelListener {
    private final Level level;

    public PlayerController(Level level) {
        this.level = level;
    }

    @Override
    public void onObjectDeath(GameObject object) {
        if (object instanceof Player) {
            throw new RuntimeException("DEAD");
        }
    }

    @Override
    public void onNewObject(GameObject object) {
        if (object instanceof Player) {
            Player player = (Player) object;
            level.addAction(new CheckIsAlive(player, level));
        }
    }
}
