package Ship.Addons;

import java.io.Serializable;

public abstract class Defense implements Serializable {
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
