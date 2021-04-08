package Ships;

import models.Customers;
import ship.complements.Defense;
import ship.complements.Propulsion;

import java.util.ArrayList;

public class SpaceStation extends Ship {

    private final static int MaxPassengers = 1000;
    private Defense[] ArrayDefenses;
    private ArrayList<Ship> ShipList;

    public static int getMaxPassengers() {
        return MaxPassengers;
    }

    public Defense[] getArrayDefenses() {
        return ArrayDefenses;
    }

    public void setArrayDefenses(Defense[] arrayDefenses) {
        ArrayDefenses = arrayDefenses;
    }

    public ArrayList<Ship> getShipList() {
        return ShipList;
    }

    public void setShipList(ArrayList<Ship> shipList) {
        ShipList = shipList;
    }

    public void addShip (Ship S) {
        if (!ShipList.contains(S)) {
            ShipList.add(S);
        }
    }

    public void removeShip (Ship S) {
        ShipList.remove(S);
    }

    public SpaceStation(String regNum, Customers owner, Propulsion[] arrayPropellers, int crewNum, Defense[] arrayDefenses, ArrayList<Ship> shipList) {
        super(regNum, owner, arrayPropellers, crewNum);
        ArrayDefenses = arrayDefenses;
        ShipList = shipList;
    }
}
