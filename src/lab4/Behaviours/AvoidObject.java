package lab4.Behaviours;

import lejos.nxt.LCD;
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
		LCD.drawString("AvoidObject", 0, 0);

		rotate(true);

        // Until the sensor is no over the line
        while (!isOverLine(rightSensor)) {
            Thread.yield();
        }

        while (isOverLine(rightSensor)) {
            Thread.yield();
        }

		objectDetected = false;
	}
}
