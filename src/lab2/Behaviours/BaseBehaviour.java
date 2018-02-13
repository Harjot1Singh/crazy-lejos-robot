package lab2.Behaviours;

import lejos.nxt.*;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.subsumption.Behavior;

public abstract class BaseBehaviour implements Behavior {
    final static private int lineThreshold = 45;

    final static RegulatedMotor leftMotor = Motor.C;
    final static RegulatedMotor rightMotor = Motor.A;

    final static LightSensor leftSensor = new LightSensor(SensorPort.S3);
    final static LightSensor rightSensor = new LightSensor(SensorPort.S2);
    final static UltrasonicSensor soundSensor = new UltrasonicSensor(SensorPort.S1);

    private boolean supressed = false;

    boolean isSupressed() {
        return supressed;
    }

    @Override
    public void suppress() {
        supressed = true;
    }

    @Override
    public void action() {
        supressed = false;
    }

    /**
     * Returns true if the sensor is on top of a line.
     * @param sensor The sensor to check.
     * @return True if on top of a line.
     */
    boolean isOverLine(LightSensor sensor) {
        return sensor.readValue() < lineThreshold;
    }


    /**
     * Rotates the robot on the spot.
     * @param turnRight If true, rotates right, else left.
     */
    void rotate(boolean turnRight) {
        if (turnRight) {
            rightMotor.backward();
            leftMotor.forward();
        } else {
            rightMotor.forward();
            leftMotor.backward();
        }
    }

    /**
     * Immediately stops any motor movement.
     */
    void stop() {
        leftMotor.stop(true);
        rightMotor.stop(true);
    }
}
