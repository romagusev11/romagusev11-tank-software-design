package ru.mipt.bit.platformer.AI;

import ru.mipt.bit.platformer.actions.Action;
import ru.mipt.bit.platformer.base.Direction;
import ru.mipt.bit.platformer.objects.tank.Tank;

import static com.badlogic.gdx.math.MathUtils.random;

public class AIChooseDirectionAction implements Action {
    private final Tank tank;

    public AIChooseDirectionAction(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void execute() {
        Direction direction = randomDirection();
        tank.rotate(direction);
    }

    private Direction randomDirection() {
        int x = random.nextInt(Direction.class.getEnumConstants().length);
        return Direction.class.getEnumConstants()[x];
    }
}
