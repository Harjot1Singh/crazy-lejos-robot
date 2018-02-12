package lab2.Behaviours;

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

        leftMotor.stop();
        rightMotor.stop();
    }
}
