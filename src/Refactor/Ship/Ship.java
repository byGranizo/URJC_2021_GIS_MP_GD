package Refactor.Ship;

import Refactor.Ship.Addons.Engine;

public abstract class Ship {
    private String nRegister;
    private Engine[] engines;
    private int crewSize;

    public Ship(String nRegister, Engine[] engines, int crewSize) {
        this.nRegister = nRegister;
        this.engines = engines;
        this.crewSize = crewSize;
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
}
