package ru.mipt.bit.platformer.actions;

import ru.mipt.bit.platformer.base.Level;
import ru.mipt.bit.platformer.objects.tank.Tank;

public class CheckIsAlive implements Action {
    private final Tank tank;
    private final Level level;

    public CheckIsAlive(Tank tank, Level level) {
        this.tank = tank;
        this.level = level;
    }

    @Override
    public void execute() {
        if (tank.isDead()) {
            level.removeObject(tank);
        } else {
            level.addAction(this);
        }
     }
}
