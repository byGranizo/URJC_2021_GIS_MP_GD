package ship.complements;

import java.io.Serializable;
public class Propulsion implements Serializable {
    private  PropulsionType name;
    private int speed;

    public Propulsion(PropulsionType name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public PropulsionType getName() {
        return name;
    }

    public void setName(PropulsionType name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}

