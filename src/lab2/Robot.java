package lab2;

import lejos.robotics.subsumption.Arbitrator;

import lab2.Behaviours.BaseBehaviour;
import lejos.robotics.subsumption.Behavior;

import java.util.ArrayList;

public class Robot {

    private static Behavior[] setupBehaviours() {
        ArrayList<Behavior> behaviours = new ArrayList<>();

        // Add Behaviours
//        behaviours.add(new BaseBehaviour());

        return behaviours.toArray(new Behavior[behaviours.size()]);
    }

    public static void main(String args[]) {
        Arbitrator arbitrator = new Arbitrator(setupBehaviours());

        arbitrator.start();
    }
}
