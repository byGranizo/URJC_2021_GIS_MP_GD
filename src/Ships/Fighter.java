package Ships;
import models.Customers;
import ship.complements.Defense;
import ship.complements.Propulsion;
import ship.complements.Weapon;

import java.util.ArrayList;


public class Fighter extends Ship {

    private Weapon[] ArrayWeapons;
    private Defense[] ArrayDefenses;

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

    public Fighter(String regNum, Customers owner, Propulsion[] arrayPropellers, int crewNum, Weapon[] arrayWeapons, Defense[] arrayDefenses) {

        super(regNum, owner, arrayPropellers, crewNum);
        ArrayWeapons = arrayWeapons;
        ArrayDefenses = arrayDefenses;
    }
}

