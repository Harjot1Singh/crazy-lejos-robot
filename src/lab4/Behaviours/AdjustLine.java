package lab4.Behaviours;

import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.localization.PoseProvider;
import lejos.robotics.navigation.Pose;

/**
 * Behaviour to adjust the robot to stay on the line.
 * The robot is defined as being displaced if either light sensor is over the line.
 * The robot should rotate in the opposite direction until the light sensor is no longer over the line.
 */
public class AdjustLine extends BaseBehaviour {
    @Override
    public boolean takeControl() {
        LCD.drawString(poseProvider.getPose().getHeading() + "", 0, 1);
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
        // System.exit(0);
    }
}

