import Database.Database;
import MenuViews.MenuFlow;

import java.util.Observer;
import Observer.ObserverOffers;
import System.Systems;

public class Main {

    public static void main(String[] args) {
        if(Database.existsData()){
            Database.loadData();
        }
        Observer o1 = new ObserverOffers();
        Systems.getObservable().addObserver(o1);
        MenuFlow.executeLoginMenu();
    }
}