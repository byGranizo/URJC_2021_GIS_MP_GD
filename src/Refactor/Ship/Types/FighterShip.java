package Refactor.Ship.Types;

import Refactor.Ship.Addons.Defense;
import Refactor.Ship.Addons.Engine;
import Refactor.Ship.Addons.Weapon;
import Refactor.Ship.Ship;

public class FighterShip extends Ship {
    private static final int CREW_SIZE = 1;

    private Weapon[] weapons;
    private Defense defense;

    public FighterShip(String nRegister, Engine[] engines, Weapon[] weapons, Defense defense) {
        super(nRegister, engines, CREW_SIZE);
        this.weapons = weapons;
        this.defense = defense;
    }

    public Weapon[] getWeapons() {
        return weapons;
    }

    public void setWeapons(Weapon[] weapons) {
        this.weapons = weapons;
    }

    public Defense getDefense() {
        return defense;
    }

    public void setDefense(Defense defense) {
        this.defense = defense;
    }
}
