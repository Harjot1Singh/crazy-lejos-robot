package lab2.Behaviours;

import lejos.nxt.Motor;
import lejos.robotics.RegulatedMotor;

import java.util.Arrays;

public class MoveForward extends BaseBehaviour {
    private RegulatedMotor[] motors = { Motor.B, Motor.C };

    @Override
    public boolean takeControl() {
        return true;
    }

    @Override
    public void action() {
        Arrays.stream(motors).forEach(motor -> motor.forward());

        while (!isSupressed()) {
            Thread.yield();
        }

        Arrays.stream(motors).forEach(motor -> motor.stop());
    }
}
