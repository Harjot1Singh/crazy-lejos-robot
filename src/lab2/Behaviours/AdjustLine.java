package lab2.Behaviours;

public class AdjustLine extends BaseBehaviour {

    @Override
    public boolean takeControl() {
        return true;
    }

    @Override
    public void action() {
        // While more than threshold, keep turning

        while (!isSupressed()) {
            Thread.yield();
        }

        // If 360 has been done, the line has ended??
        System.exit(0);
    }
}

