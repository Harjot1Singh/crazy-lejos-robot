package lab4.Behaviours;

import lejos.nxt.*;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;

public abstract class BaseBehaviour implements Behavior {
    final static private int lineThreshold = 45;

    private final static RegulatedMotor leftMotor = Motor.B;
    private final static RegulatedMotor rightMotor = Motor.A;

    final static LightSensor leftSensor = new LightSensor(SensorPort.S2);
    final static LightSensor rightSensor = new LightSensor(SensorPort.S3);
    final static UltrasonicSensor ultraSensor = new UltrasonicSensor(SensorPort.S1);

    static DifferentialPilot pilot = new DifferentialPilot(2.1f, 4.4f, leftMotor, rightMotor, false);

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
    	pilot.setRotateSpeed(90);
        if (turnRight) {
        	pilot.rotateRight();
        } else {
        	pilot.rotateLeft();
        }
    }
}
