package Ships;

import models.Customers;
import ship.complements.Defense;
import ship.complements.Propulsion;

public class CargoShip extends Ship {

    private final static int CargoCapacity = 100000;
    private Defense[] ArrayDefenses;

    public static int getCargoCapacity() {
        return CargoCapacity;
    }

    public Defense[] getArrayDefenses() {
        return ArrayDefenses;
    }

    public void setArrayDefenses(Defense[] arrayDefenses) {
        ArrayDefenses = arrayDefenses;
    }

    public CargoShip(String regNum, Customers owner, Propulsion[] arrayPropellers, int crewNum, Defense[] arrayDefenses) {
        super(regNum, owner, arrayPropellers, crewNum);
        ArrayDefenses = arrayDefenses;
    }
}
