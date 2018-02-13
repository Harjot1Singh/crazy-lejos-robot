package lab2.Behaviours;

/**
 * Behaviour for continually moving forwards.
 */
public class MoveForward extends BaseBehaviour {
    @Override
    public boolean takeControl() {
        return true;
    }

    @Override
    public void action() {
        super.action();

    	leftMotor.forward();
    	rightMotor.forward();

        while (!isSupressed()) {
            Thread.yield();
        }

        leftMotor.stop(true);
        rightMotor.stop(true);
    }
}
