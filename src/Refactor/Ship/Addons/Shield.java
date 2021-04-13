package Refactor.Ship.Addons;

public class Shield extends Defense{
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
