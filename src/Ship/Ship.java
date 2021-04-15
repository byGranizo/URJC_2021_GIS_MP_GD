package Ship;

import Ship.Addons.Defense;
import Ship.Addons.Engine;
import Ship.Addons.Weapon;

import java.io.Serializable;

public abstract class Ship implements Serializable {
    private String nRegister;
    private Engine[] engines;
    private int crewSize;
    private int totalPower;
    private int totalDefense;
    private ShipType type;

    public Ship(String nRegister, Engine[] engines, int crewSize, int totalPower, int totalDefense) {
        this.nRegister = nRegister;
        this.engines = engines;
        this.crewSize = crewSize;
        this.totalPower = totalPower;
        this.totalDefense = totalDefense;
    }

    public String getnRegister() {
        return nRegister;
    }

    public void setnRegister(String nRegister) {
        this.nRegister = nRegister;
    }

    public Engine[] getEngines() {
        return engines;
    }

    public void setEngines(Engine[] engines) {
        this.engines = engines;
    }

    public int getCrewSize() {
        return crewSize;
    }

    public void setCrewSize(int crewSize) {
        this.crewSize = crewSize;
    }

    public int getTotalPower() {
        return totalPower;
    }

    public void setTotalPower(int totalPower) {
        this.totalPower = totalPower;
    }

    public int getTotalDefense() {
        return totalDefense;
    }

    public void setTotalDefense(int totalDefense) {
        this.totalDefense = totalDefense;
    }

    public ShipType getType() {
        return type;
    }

    public void setType(ShipType type) {
        this.type = type;
    }
}
