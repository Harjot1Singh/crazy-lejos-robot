package lab2.Behaviours;

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
		pilot.rotate(180);
	}
}
