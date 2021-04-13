package ship.complements;

import java.io.Serializable;

public class Weapon implements Serializable {
    private WeaponType name;
    private int power;

    public Weapon (WeaponType name, int power) {
        this.name = name;
        this.power = power;
    }

    public WeaponType getName() {
        return name;
    }

    public void setName(WeaponType name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}

