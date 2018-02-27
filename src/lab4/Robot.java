package lab4;

import lab2.Behaviours.MoveForward;
import lab4.Behaviours.*;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class Robot {
    private static Behavior[] behaviors = {
            new MoveForward(),
            new AdjustLine(),
//            new TakeJunction(),
//            new EndLine(),
//    		new AvoidObject(),
    };


    public static void main(String args[]) {
        Arbitrator arbitrator = new Arbitrator(behaviors);

        arbitrator.start();
    }
}
