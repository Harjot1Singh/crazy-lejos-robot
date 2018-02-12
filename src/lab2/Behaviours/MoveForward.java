package lab2.Behaviours;

import lejos.nxt.Motor;
import lejos.robotics.RegulatedMotor;

import java.util.Arrays;

public class MoveForward extends BaseBehaviour {
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

        Motor.B.stop();
        Motor.C.stop();
    }
}
