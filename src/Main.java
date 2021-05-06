import Database.Database;
import MenuViews.MenuFlow;

import java.util.Observer;
import Observer.ObserverOffers;
import System.Systems;
import org.junit.jupiter.api.Test;


public class Main {
@Test
    public static void main(String[] args) {
        if(Database.existsData()){
            Database.loadData();
        }
        Observer observer = new ObserverOffers();
        Systems.getObservable().addObserver(observer);
        MenuFlow.executeLoginMenu();
    }
}