package Ship.Types;

import Ship.Addons.Defense;
import Ship.Addons.Engine;
import Ship.Ship;

import java.io.Serializable;

public class CargoShip extends Ship implements Serializable {
    private int maxLoad;
    private Defense defense;

    public CargoShip(String nRegister, Engine[] engines, int crewSize, int maxLoad, Defense defense) {
        super(nRegister, engines, crewSize);
        this.maxLoad = maxLoad;
        this.defense = defense;
    }

    public int getMaxLoad() {
        return maxLoad;
    }

    public void setMaxLoad(int maxLoad) {
        this.maxLoad = maxLoad;
    }

    public Defense getDefense() {
        return defense;
    }

    public void setDefense(Defense defense) {
        this.defense = defense;
    }
}
