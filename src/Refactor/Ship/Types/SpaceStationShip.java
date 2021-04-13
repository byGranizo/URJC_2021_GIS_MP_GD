package Refactor.Ship.Types;

import Refactor.Ship.Addons.Defense;
import Refactor.Ship.Addons.Engine;
import Refactor.Ship.Addons.Weapon;
import Refactor.Ship.Ship;

import java.util.ArrayList;

public class SpaceStationShip extends Ship {
    private int maxPassegers;
    private ArrayList<Ship> hangar;
    private Defense[] defense;

    public SpaceStationShip(String nRegister, Engine[] engines, int crewSize, int maxPassegers, ArrayList<Ship> hangar, Defense[] defense) {
        super(nRegister, engines, crewSize);
        this.maxPassegers = maxPassegers;
        this.hangar = hangar;
        this.defense = defense;
    }

    public int getMaxPassegers() {
        return maxPassegers;
    }

    public void setMaxPassegers(int maxPassegers) {
        this.maxPassegers = maxPassegers;
    }

    public ArrayList<Ship> getHangar() {
        return hangar;
    }

    public void setHangar(ArrayList<Ship> hangar) {
        this.hangar = hangar;
    }

    public Defense[] getDefense() {
        return defense;
    }

    public void setDefense(Defense[] defense) {
        this.defense = defense;
    }
}
