package lab2.Behaviours;

import lejos.nxt.*;

public class AvoidObject extends BaseBehaviour {
	private final static int threshold = 800;

	@Override
	public boolean takeControl() {
        ultraSensor.continuous();
		return ultraSensor.getDistance() < threshold;
	}

	@Override
	public void action() {
		super.action();

	}
}
