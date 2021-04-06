package Ships;

import ship.complements.Defense;
import ship.complements.Weapon;

import java.util.ArrayList;

public class Destroyer extends Ship {

    private ArrayList<Weapon> ArrayWeapons;
    private Defense[] ArrayDefenses = new Defense[2];

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

    public Destroyer() {
    }
}
