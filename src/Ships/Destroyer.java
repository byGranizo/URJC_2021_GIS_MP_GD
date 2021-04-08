package Ships;

import models.Customers;
import ship.complements.Defense;
import ship.complements.Propulsion;
import ship.complements.Weapon;

import java.util.ArrayList;

public class Destroyer extends Ship {

    private ArrayList<Weapon> ArrayWeapons;
    private Defense[] ArrayDefenses;

    public ArrayList<Weapon> getArrayWeapons() {
        return ArrayWeapons;
    }

    public void setArrayWeapons(ArrayList<Weapon> arrayWeapons) {
        ArrayWeapons = arrayWeapons;
    }

    public Defense[] getArrayDefenses() {
        return ArrayDefenses;
    }

    public void setArrayDefenses(Defense[] arrayDefenses) {
        ArrayDefenses = arrayDefenses;
    }

    public Destroyer(String regNum, Customers owner, Propulsion[] arrayPropellers, int crewNum, ArrayList<Weapon> arrayWeapons, Defense[] arrayDefenses) {
        super(regNum, owner, arrayPropellers, crewNum);
        ArrayWeapons = arrayWeapons;
        ArrayDefenses = arrayDefenses;
    }
}
