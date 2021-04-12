package ship.complements;

import java.io.Serializable;
import java.util.ArrayList;
public class Propulsion implements Serializable {
    ArrayList<String> motors = new ArrayList<String> ();

    private final static int speed = 1000;

    public Propulsion (String name, int speed) {
        motors.add("curvature motor");
        motors.add("trace compressor");
        motors.add("motor FTL");
        motors.add("solar sails");
        motors.add("ionic engine");
    }

}

public enum PropulsionType{
    CURVATURE_MOTOR,
    TRACE_COMPRESSOR,
    MOTOR_FTL,
    SOLAR_SAILS,
    IONIC_ENGINE
}
