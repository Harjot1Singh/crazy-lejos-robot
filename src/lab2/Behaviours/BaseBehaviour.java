package lab2.Behaviours;

import lejos.nxt.*;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.subsumption.Behavior;

public abstract class BaseBehaviour implements Behavior {
    final protected RegulatedMotor leftMotor = Motor.B;
    final protected RegulatedMotor rightMotor = Motor.C;

    final protected LightSensor leftSensor = new LightSensor(SensorPort.S1);
    final protected LightSensor rightSensor = new LightSensor(SensorPort.S2);
    final protected UltrasonicSensor soundSensor = new UltrasonicSensor(SensorPort.S3);

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
}
