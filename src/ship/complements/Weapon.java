package ship.complements;

import java.io.Serializable;

public class Weapon implements Serializable {
    private String name;
    private int power;

    public Weapon (String name, int power) {
        this.name = name;
        this.power = power;
    }
}
