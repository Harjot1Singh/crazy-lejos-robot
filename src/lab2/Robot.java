package lab2;

import lab2.Behaviours.AdjustLine;
import lab2.Behaviours.DetectObject;
import lab2.Behaviours.EndLine;
import lab2.Behaviours.TakeJunction;
import lejos.robotics.subsumption.Behavior;
import lejos.robotics.subsumption.Arbitrator;

import lab2.Behaviours.MoveForward;

public class Robot {
    private static Behavior[] behaviors = {
    		new DetectObject(),
            //new MoveForward(),
            //new AdjustLine(),
            //new TakeJunction(),
            //new EndLine(),
    };


    public static void main(String args[]) {
        Arbitrator arbitrator = new Arbitrator(behaviors);

        arbitrator.start();
    }
}
