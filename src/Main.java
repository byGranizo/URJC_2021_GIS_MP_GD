import Offer.Offer;
import Database.Database;

public class Main {

    public static void main(String[] args) {
        Systems system = new Systems();
        int option = 0;
        Customers client = null;
        if(Database.existsData()){
            system = Database.loadData();
        }
        while(option != 3){
            option = init();
            switch (option){
                case 1 :
                    client = registerCustomer(system);
                    break;
                case 2 :
                    client = login(system);
                    if(client != null){
                        int optionSystem = 0;
                        while (optionSystem != 5){
                            optionSystem = menuSystem();
                            switch (optionSystem){
                                case 1:
                                    createShip(client);
                                    system.modifyCustomer(client);
                                    break;
                                case 2:
                                    registerOffer(system);
                                    break;
                                case 3:
                                    if(client.getShips() != null) {
                                        for (Ship ship : client.getShips()) {
                                            System.out.println(ship.getCrewNum());
                                            System.out.println();
                                        }
                                    }else {
                                        System.out.println("Empty");
                                    }
                                    break;
                                case 4:
                                    if(system.getListOffer() != null) {
                                        for (Offer offer : system.getListOffer()) {
                                            System.out.println(offer.getStatus());
                                            System.out.println();
                                        }
                                    }else {
                                        System.out.println("Empty");
                                    }
                                    break;
                                case 5:
                                    break;
                                default:
                                    System.out.println("invalid option");
                            }
                        }
                    }

                case 3 :
                    break;
                default:
                    System.out.println("invalid option");
            }
        }
    }
}