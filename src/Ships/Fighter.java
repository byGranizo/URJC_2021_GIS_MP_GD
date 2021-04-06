package Ships;
import ship.complements.Defense;
import ship.complements.Weapon;

import java.util.ArrayList;


public class Fighter extends Ship {

    private Weapon[] ArrayWeapons = new Weapon[2];
    private Defense[] ArrayDefenses = new Defense[1];

    public Weapon[] getArrayWeapons() {
        return ArrayWeapons;
    }

    public void setArrayWeapons(Weapon[] arrayWeapons) {
        ArrayWeapons = arrayWeapons;
    }

    public Defense[] getArrayDefenses() {
        return ArrayDefenses;
    }

    public void setArrayDefenses(Defense[] arrayDefenses) {
        ArrayDefenses = arrayDefenses;
    }

    public Fighter() {
    }
}

