package ru.mipt.bit.platformer.AI;

import ru.mipt.bit.platformer.actions.Action;
import ru.mipt.bit.platformer.actions.CheckIsAlive;
import ru.mipt.bit.platformer.base.Level;
import ru.mipt.bit.platformer.base.LevelListener;
import ru.mipt.bit.platformer.engine.CollisionDetector;
import ru.mipt.bit.platformer.objects.GameObject;
import ru.mipt.bit.platformer.player.Player;
import ru.mipt.bit.platformer.objects.tank.Tank;

import java.util.ArrayList;
import java.util.Collection;

import static com.badlogic.gdx.math.MathUtils.random;

public class AITankController implements LevelListener {
    private final Collection<Tank> storage = new ArrayList<>();
    private final Level level;
    private final CollisionDetector detector;

    public AITankController(Level level, CollisionDetector detector) {
        this.level = level;
        this.detector = detector;
    }

    @Override
    public void onObjectDeath(GameObject object) {
        if (object instanceof Tank && ! (object instanceof Player)) {
            Tank aitank = (Tank) object;
            storage.remove(aitank);
        }
    }

    @Override
    public void onNewObject(GameObject object) {
        if (object instanceof Tank && ! (object instanceof Player)) {
            Tank aitank = (Tank) object;
            storage.add(aitank);
            level.addAction(new ChooseNextAction(this, aitank, level));
            level.addAction(new CheckIsAlive(aitank, level));
        }
    }

    public Action chooseNextAction(Tank tank) {
        if (tank.getMovementProgress() < 1) {
            //If tank is moving do nothing
            return null;
        }
        int actionID = random.nextInt(3);
        switch (actionID) {
            case 0:
                return new AIChooseDirectionAction(tank);
            case 1:
                return new AIShootAction(tank, level, detector);
            case 2:
                return new AIMoveAction(tank, detector);
        }
        return null;
    }
}
