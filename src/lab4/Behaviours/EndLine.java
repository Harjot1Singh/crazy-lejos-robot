package lab4.Behaviours;

import lejos.nxt.LCD;

/**
 * Behaviour to detect when the robot is no longer on the line.
 * The robot is defined as not being on the line when a certain timeout
 */
public class EndLine extends BaseBehaviour {
    private int timeout = 1000;

    @Override
    public boolean takeControl() {
        timeout--;

        if (isOverLine(leftSensor) || isOverLine(rightSensor)) {
            resetTimeout();
        }

        return timeout <= 0;
    }

    private void resetTimeout() {
        timeout = 1000;
    }

    @Override
    public void action() {
    	super.action();
    	 LCD.drawString("EndLine", 0, 0);
    	System.exit(0);
    }
}

