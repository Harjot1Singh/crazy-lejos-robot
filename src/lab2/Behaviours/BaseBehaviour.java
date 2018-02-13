package lab2.Behaviours;

import lejos.nxt.*;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.subsumption.Behavior;

public abstract class BaseBehaviour implements Behavior {
    final static private int lineThreshold = 35;

    final static RegulatedMotor leftMotor = Motor.B;
    final static RegulatedMotor rightMotor = Motor.C;

    final static LightSensor leftSensor = new LightSensor(SensorPort.S1);
    final static LightSensor rightSensor = new LightSensor(SensorPort.S2);
    final static UltrasonicSensor soundSensor = new UltrasonicSensor(SensorPort.S3);

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

    protected boolean isOverLine(LightSensor sensor) {
        return sensor.readValue() < lineThreshold;
    }
}
