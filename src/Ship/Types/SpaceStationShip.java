package Ship.Types;

import Ship.Addons.Defense;
import Ship.Addons.Engine;
import Ship.Ship;

import java.io.Serializable;
import java.util.ArrayList;

public class SpaceStationShip extends Ship implements Serializable {
    private int maxPassegers;
    private ArrayList<Ship> hangar;
    private Defense[] defense;

    public SpaceStationShip(String nRegister, Engine[] engines, int crewSize, int maxPassegers, Defense[] defense) {
        super(nRegister, engines, crewSize);
        this.hangar = new ArrayList<Ship>();
        this.maxPassegers = maxPassegers;
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


    public void addShipToHangar(Ship ship){
        hangar.add(ship);
    }
}
