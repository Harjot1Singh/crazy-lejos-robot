package lab2.Behaviours;

import lejos.nxt.LightSensor;


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
        boolean isRight = Math.random() > 0.5;
        LightSensor sensor = isRight ? leftSensor : rightSensor;

        // Rotate away from the line, and then until another line is reached
        rotateAwayFromLine(isRight, sensor);
        untilLine(sensor);

        // Finally, stop both the motors
        leftMotor.stop(true);
        rightMotor.stop(true);
    }

    /**
     * Rotates the robot away from the line that the given sensor is on.
     *
     * @param isRight The direction of rotation. Rotates right if true, left if false.
     * @param sensor  The light sensor that will be rotated away the line.
     */
    private void rotateAwayFromLine(boolean isRight, LightSensor sensor) {
        // Set the motors in the correct rotation direction
        if (isRight) {
            leftMotor.forward();
            rightMotor.backward();
        } else {
            leftMotor.backward();
            rightMotor.forward();
        }

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

