package Ship.Addons;

import java.io.Serializable;

public class Weapon implements Serializable {
    private WeaponType type;
    private int power;

    public Weapon(WeaponType type, int power) {
        this.type = type;
        this.power = power;
    }

    public WeaponType getType() {
        return type;
    }

    public void setType(WeaponType type) {
        this.type = type;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
