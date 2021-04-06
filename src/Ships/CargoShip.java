package Ships;

import ship.complements.Defense;

public class CargoShip extends Ship {

    private final static int CargoCapacity = 100000;
    private Defense[] ArrayDefenses = new Defense[1];

    public static int getCargoCapacity() {
        return CargoCapacity;
    }

    public Defense[] getArrayDefenses() {
        return ArrayDefenses;
    }

    public void setArrayDefenses(Defense[] arrayDefenses) {
        ArrayDefenses = arrayDefenses;
    }

    public CargoShip() {
    }
}
