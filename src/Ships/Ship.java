package Ships;
import ship.complements.Propulsion;
import models.Customers;

public abstract class Ship {

    private String RegNum;
    private Customers Owner;
    private Propulsion[] ArrayPropellers = new Propulsion[2];
    private int CrewNum;

    public String getRegNum() {
        return RegNum;
    }

    public void setRegNum(String regNum) {
        RegNum = regNum;
    }

    public Customers getOwner() {
        return Owner;
    }

    public void setOwner(Customers owner) {
        Owner = owner;
    }

    public Propulsion[] getArrayPropellers() {
        return ArrayPropellers;
    }

    public void setArrayPropellers(Propulsion[] arrayPropellers) {
        ArrayPropellers = arrayPropellers;
    }

    public int getCrewNum() {
        return CrewNum;
    }

    public void setCrewNum(int crewNum) {
        CrewNum = crewNum;
    }
}
