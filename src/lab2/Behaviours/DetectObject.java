package lab2.Behaviours;

import lejos.nxt.*;

public class DetectObject extends BaseBehaviour {
	
	@Override
	public boolean takeControl() {
		return true;
	}
	
	@Override
	public void action() {
		super.action();
		ultraSensor.continuous();
		int distance = ultraSensor.getDistance();
		LCD.drawString("DetectObject", 0, 0);
		LCD.drawInt(distance, 0, 1);
		// Distance of 800
	}
}
