package Ship.Types;

import Ship.Addons.Defense;
import Ship.Addons.Engine;
import Ship.Addons.Weapon;
import Ship.Ship;

import java.io.Serializable;

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
