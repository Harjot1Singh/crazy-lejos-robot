package lab4.Behaviours;

import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.util.Delay;

/**
 * Behaviour for dealing with junctions.
 * A junction is defined as a line ending with another line non-parallel to it.
 * The robot should choose a direction randomly, and rotate till it reaches another line.
 */
public class TakeJunction extends BaseBehaviour {
	private boolean isTurning = false;

    @Override
    public boolean takeControl() {
        // Check both sensors for a black line
        return isTurning || (isOverLine(leftSensor) && isOverLine(rightSensor));
    }

    @Override
    public void action() {
        super.action();
        isTurning = true;

        LCD.drawString("TakeJunction", 0, 0);
        // Select a direction randomly at the junction
        boolean turnRight = Math.random() > 0.5;
        LightSensor sensor = turnRight ? leftSensor : rightSensor;

        // Move forward until the junction disappears
        pilot.setTravelSpeed(5);
        pilot.forward();
        //leftMotor.forward();
        //rightMotor.forward();
        untilNothing();
        Delay.msDelay(100);
        pilot.stop();
        //leftMotor.stop(true);
        //rightMotor.stop(true);

        // Rotate away from the line, and then until another line is reached
        rotateAwayFromLine(turnRight, sensor);
        untilLine(sensor);

        isTurning = false;
        // Finally, stop both the motors
    }

    /**
     * Rotates the robot away from the line that the given sensor is on.
     *
     * @param turnRight The direction of rotation. Rotates right if true, left if false.
     * @param sensor  The light sensor that will be rotated away the line.
     */
    private void rotateAwayFromLine(boolean turnRight, LightSensor sensor) {
        // Set the motors in the correct rotation direction
        rotate(turnRight);

        while (!isSupressed() && isOverLine(sensor)) {
            Thread.yield();
        }
    }

    /**
     * Blocks until the robot is not on the line for any sensor.
     */
    private void untilNothing() {
        while (!isSupressed() && !isOverLine(leftSensor) && !isOverLine(rightSensor)) {
            Thread.yield();
        }
    }

    /**
     * Blocks until the robot is on a line for the given sensor.
     *
     * @param sensor The light sensor that will be looking for a line.
     */
    private void untilLine(LightSensor sensor) {
        while (!isSupressed() && !isOverLine(sensor)) {
            Thread.yield();
        }
    }
}

