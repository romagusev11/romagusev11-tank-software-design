package ru.mipt.bit.platformer.AI;

import ru.mipt.bit.platformer.actions.Action;
import ru.mipt.bit.platformer.actions.Shoot;
import ru.mipt.bit.platformer.base.Level;
import ru.mipt.bit.platformer.engine.CollisionDetector;
import ru.mipt.bit.platformer.objects.tank.Tank;

public class AIShootAction implements Action {

    private final Shoot shoot;

    public AIShootAction(Tank tank, Level level, CollisionDetector detector) {
        this.shoot = new Shoot(tank, level, detector);
    }

    @Override
    public void execute() {
        shoot.execute();
    }
}
