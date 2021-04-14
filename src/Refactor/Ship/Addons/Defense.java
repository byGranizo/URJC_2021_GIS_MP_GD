package Refactor.Ship.Addons;

public abstract class Defense {
    private int absorption;

    public Defense(int absorption) {
        this.absorption = absorption;
    }

    public int getAbsorption() {
        return absorption;
    }

    public void setAbsorption(int absorption) {
        this.absorption = absorption;
    }
}
