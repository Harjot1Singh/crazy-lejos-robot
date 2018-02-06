package lab2.Behaviours;

import lejos.robotics.subsumption.Behavior;

public abstract class BaseBehaviour implements Behavior {
    private boolean supressed = false;

    public boolean isSupressed() {
        return supressed;
    }

    @Override
    public void suppress() {
        supressed = true;
    }
}
