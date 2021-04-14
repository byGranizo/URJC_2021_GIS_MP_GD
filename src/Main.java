import Database.Database;
import MenuViews.MenuFlow;

public class Main {

    public static void main(String[] args) {
        if(Database.existsData()){
            Database.loadData();
        }
        MenuFlow.executeLoginMenu();
    }
}