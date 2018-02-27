package lab2;

import lab2.Behaviours.*;
import lejos.robotics.subsumption.Behavior;
import lejos.robotics.subsumption.Arbitrator;

public class Robot {
    private static Behavior[] behaviors = {
            new MoveForward(),
            new AdjustLine(),
            new TakeJunction(),
            new EndLine(),
    		new AvoidObject(),
    };


    public static void main(String args[]) {
        Arbitrator arbitrator = new Arbitrator(behaviors);

        arbitrator.start();
    }
}
