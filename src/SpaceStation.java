import java.util.ArrayList;

public class SpaceStation extends Ship {

    private final static int MaxPassengers = 1000;
    //private SistemaDefensa (3);
    private ArrayList<Ship> list = new ArrayList<>();


    public static int getMaxPassengers() {
        return MaxPassengers;
    }

    public ArrayList<Ship> getShips() {
        return list;
    }

    public void setListShips(ArrayList<Ship> list) {
        this.list = list;
    }

    public void addShip (Ship S) {

        if (!list.contains(S)) {
            list.add(S);
        }
    }

    public void removeShip (Ship S) {
        list.remove(S);
    }

    public SpaceStation(ArrayList<Ship> list) {
        this.list = list;
    }
}
