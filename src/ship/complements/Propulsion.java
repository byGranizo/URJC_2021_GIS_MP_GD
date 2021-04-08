package ship.complements;

import java.util.ArrayList;
public class Propulsion {
    ArrayList<String> motors = new ArrayList<String> ();

    private final static int speed = 1000;

    public Propulsion (String name, int speed) {
        motors.add("curvature motor");
        motors.add("compresor de traza");
        motors.add("motor FTL");
        motors.add("velas solares");
        motors.add("motor ionico");
    }

}
