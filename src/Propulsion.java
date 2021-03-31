import java.util.ArrayList;
public class Propulsion extends Ship {
    ArrayList <String> motors = new ArrayList <String> ();
    motors.add ("curvature motor");
    motors.add ("compresor de traza");
    motors.add ("motor FTL");
    motors.add ("velas solares");
    motors.add ("motor ionico");

    private final static int speed = 1000;

    public Propulsion (String name, int speed) {
    }

}
