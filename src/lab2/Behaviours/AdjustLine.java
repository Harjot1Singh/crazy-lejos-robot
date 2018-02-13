package lab2.Behaviours;

import lejos.nxt.LCD;
import lejos.nxt.LightSensor;

/**
 * Behaviour to adjust the robot to stay on the line.
 * The robot is defined as being displaced if either light sensor is over the line.
 * The robot should rotate in the opposite direction until the light sensor is no longer over the line.
 */
public class AdjustLine extends BaseBehaviour {

    @Override
    public boolean takeControl() {
    	
        return isOverLine(leftSensor) || isOverLine(rightSensor);
    }

    @Override
    public void action() {
    	super.action();
    	LCD.drawString("AdjustLine", 0, 0);
        boolean turnRight = isOverLine(rightSensor);
        LightSensor sensor = turnRight ? rightSensor : leftSensor;

        // Start rotating in the correctional direction
        rotate(turnRight);

        // Until the sensor is no longer over the line
        while (!isSupressed() && isOverLine(sensor)) {
            Thread.yield();
        }

        stop();
        // If 360 has been done, the line has ended??
        // System.exit(0);
    }
}

