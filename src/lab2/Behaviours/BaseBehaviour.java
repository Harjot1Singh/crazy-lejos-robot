package lab2.Behaviours;

import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.SoundSensor;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.subsumption.Behavior;

public abstract class BaseBehaviour implements Behavior {
    final protected RegulatedMotor leftMotor = Motor.B;
    final protected RegulatedMotor rightMotor = Motor.C;

    final protected LightSensor leftSensor = new LightSensor(SensorPort.S1);
    final protected LightSensor rightSensor = new LightSensor(SensorPort.S2);
    final protected SoundSensor soundSensor = new SoundSensor(SensorPort.S3);

    private boolean supressed = false;

    boolean isSupressed() {
        return supressed;
    }

    @Override
    public void suppress() {
        supressed = true;
    }
}
