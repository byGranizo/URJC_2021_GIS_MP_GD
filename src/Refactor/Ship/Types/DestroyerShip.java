package Refactor.Ship.Types;

import Refactor.Ship.Addons.Defense;
import Refactor.Ship.Addons.Engine;
import Refactor.Ship.Addons.Weapon;
import Refactor.Ship.Ship;

import java.io.Serializable;
import java.util.ArrayList;

public class DestroyerShip extends Ship implements Serializable {
    private Weapon[] weapons;
    private Defense[] defense;

    public DestroyerShip(String nRegister, Engine[] engines, int crewSize, Weapon[] weapons, Defense[] defense) {
        super(nRegister, engines, crewSize);
        this.weapons = weapons;
        this.defense = defense;
    }

    public Weapon[] getWeapons() {
        return weapons;
    }

    public void setWeapons(Weapon[] weapons) {
        this.weapons = weapons;
    }

    public Defense[] getDefense() {
        return defense;
    }

    public void setDefense(Defense[] defense) {
        this.defense = defense;
    }
}
