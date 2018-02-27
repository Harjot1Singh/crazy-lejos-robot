package lab4.Behaviours;

import lejos.nxt.LCD;

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
		LCD.drawString("AvoidObject", 0, 0);

		pilot.rotate(180);
	}
}
