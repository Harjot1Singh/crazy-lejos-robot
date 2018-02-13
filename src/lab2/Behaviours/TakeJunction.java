package lab2.Behaviours;

import lejos.nxt.LightSensor;

/**
 * Behaviour for dealing with junctions.
 * A junction is defined as a line ending with another line non-parallel to it.
 * The robot should choose a direction randomly, and rotate till it reaches another line.
 */
public class TakeJunction extends BaseBehaviour {
    @Override
    public boolean takeControl() {
        // Check both sensors for a black line
        return isOverLine(leftSensor) && isOverLine(rightSensor);
    }

    @Override
    public void action() {
        super.action();

        // Select a direction randomly at the junction
        boolean turnRight = Math.random() > 0.5;
        LightSensor sensor = turnRight ? leftSensor : rightSensor;

        // Rotate away from the line, and then until another line is reached
        rotateAwayFromLine(turnRight, sensor);
        untilLine(sensor);

        // Finally, stop both the motors
        stop();
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

