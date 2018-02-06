package lab2;

import java.util.ArrayList;
import lejos.robotics.subsumption.Behavior;
import lejos.robotics.subsumption.Arbitrator;

import lab2.Behaviours.MoveForward;

public class Robot {

    private static Behavior[] setupBehaviours() {
        ArrayList<Behavior> behaviours = new ArrayList<>();

        // Add Behaviours
        behaviours.add(new MoveForward());

        return behaviours.toArray(new Behavior[behaviours.size()]);
    }

    public static void main(String args[]) {
        Arbitrator arbitrator = new Arbitrator(setupBehaviours());

        arbitrator.start();
    }
}
