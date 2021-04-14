package Refactor.Ship.Addons;

public class Armor extends Defense{
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
