package lab2.Behaviours;

import lejos.nxt.Motor;
import lejos.robotics.RegulatedMotor;

import java.util.Arrays;

public class LineBehaviour extends BaseBehaviour {
    private RegulatedMotor[] motors = { Motor.B, Motor.C };

    @Override
    public boolean takeControl() {
        return true;
    }

    @Override
    public void action() {
    	Motor.B.forward();
    	Motor.C.forward();

        while (!isSupressed()) {
            Thread.yield();
        }

    }
}

