package lab2.Behaviours;

/**
 * Behaviour to detect when the robot is no longer on the line.
 * The robot is defined as not being on the line when a certain timeout
 */
public class EndLine extends BaseBehaviour {
    private int timeout = 500;

    @Override
    public boolean takeControl() {
        timeout--;

        if (isOverLine(leftSensor) || isOverLine(rightSensor)) {
            resetTimeout();
        }

        return timeout <= 0;
    }

    private void resetTimeout() {
        timeout = 500;
    }

    @Override
    public void action() {
    	super.action();

    	stop();
    	System.exit(0);
    }
}

