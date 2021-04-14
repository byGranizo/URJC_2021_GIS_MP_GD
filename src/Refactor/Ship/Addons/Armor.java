package Refactor.Ship.Addons;

import java.io.Serializable;

public class Armor extends Defense implements Serializable {
    private String material;
    private int overWeight;

    public Armor(int absorption, String material, int overWeight) {
        super(absorption);
        this.material = material;
        this.overWeight = overWeight;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getOverWeight() {
        return overWeight;
    }

    public void setOverWeight(int overWeight) {
        this.overWeight = overWeight;
    }
}
