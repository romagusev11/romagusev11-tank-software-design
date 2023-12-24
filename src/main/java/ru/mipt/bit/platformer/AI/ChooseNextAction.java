package ru.mipt.bit.platformer.AI;

import ru.mipt.bit.platformer.base.Action;
import ru.mipt.bit.platformer.base.Level;
import ru.mipt.bit.platformer.objects.tank.Tank;

public class ChooseNextAction implements Action {
    private final AITankController controller;
    private final Tank tank;
    private final Level level;

    private final float cooldown = 10;
    private float time = 0;

    public ChooseNextAction(AITankController controller, Tank tank, Level level) {
        this.controller = controller;
        this.tank = tank;
        this.level = level;
    }

    @Override
    public void execute() {
        if (time < cooldown) {
            time += 1;
        } else {
            time -= 10;
            Action action = controller.chooseNextAction(tank);
            if (action != null) {
                action.execute();
            }
        }
        level.addAction(this);
    }
}
