package lab2.Behaviours;


import lejos.robotics.objectdetection.Feature;
import lejos.robotics.objectdetection.FeatureDetector;
import lejos.robotics.objectdetection.FeatureListener;

public class AvoidObject extends BaseBehaviour {
    private boolean objectDetected = false;

    public AvoidObject() {
        // Add a listener to deal with objects
        detector.addListener(new FeatureListener() {
            @Override
            public void featureDetected(Feature feature, FeatureDetector detector) {
                objectDetected = true;
            }
        });
    }

    @Override
    public boolean takeControl() {
        return objectDetected;
    }

    @Override
    public void action() {
        super.action();
        pilot.rotate(180);
    }
}
