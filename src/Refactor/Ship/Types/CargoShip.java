package Refactor.Ship.Types;

import Refactor.Ship.Addons.Defense;
import Refactor.Ship.Addons.Engine;
import Refactor.Ship.Ship;

public class CargoShip extends Ship {
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
