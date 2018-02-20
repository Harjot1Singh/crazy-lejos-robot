package lab2.Behaviours;

import lejos.nxt.LCD;

/**
 * Behaviour for continually moving forwards.
 */
public class MoveForward extends BaseBehaviour {
    @Override
    public boolean takeControl() {
        return true;
    }

    @Override
    public void action() {
        super.action();
        LCD.drawString("MoveForward", 0, 0);
        
        pilot.setTravelSpeed(5);
        pilot.forward();

        while (!isSupressed()) {
            Thread.yield();
        }
    }
}
