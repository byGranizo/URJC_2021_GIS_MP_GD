package Refactor.Ship.Addons;

import java.io.Serializable;

public class Shield extends Defense implements Serializable {
    private int energyCapacity;

    public Shield(int absorption, int energyCapacity) {
        super(absorption);
        this.energyCapacity = energyCapacity;
    }

    public int getEnergyCapacity() {
        return energyCapacity;
    }

    public void setEnergyCapacity(int energyCapacity) {
        this.energyCapacity = energyCapacity;
    }
}
