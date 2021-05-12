package MenuViews;

import Database.Database;
import Offer.Offer;
import Offer.OfferStatus;
import Offer.Review;
import Ship.Ship;
import Ship.ShipCreator;
import System.Systems;
import User.Client;
import User.User;
import User.UserCreator;
import User.UserRole;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import Ship.ShipType;

public class MenuFlow {
    public static void executeLoginMenu(){
        Scanner scan = new Scanner(System.in);
        int option = -1;
        while(option != 3){
            System.out.println("Choose and option:");

            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");

            option = scan.nextInt();
            scan.nextLine();

            switch (option) {
                case 1:
                    if(login()){
                        UserRole userRole = Systems.getInstance().getCurrentUser().getRole();
                        if(userRole == UserRole.ADMIN){
                            executeAdminMenu();
                        }else if (userRole == UserRole.CLIENT){
                            executeClientMenu();
                        }
                    }
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("Incorrect option");
            }
        }

    }

    public static void executeAdminMenu(){
        Scanner scan = new Scanner(System.in);
        int option = -1;
        while(option != 5){
            System.out.println("Choose and option:");

            System.out.println("1. Register as pirate");
            System.out.println("2. Register as fraud");
            System.out.println("3. View Offers");
            System.out.println("4. Verify offers");
            System.out.println("5. Exit");

            option = scan.nextInt();
            scan.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Write the username:");
                    Systems.getInstance().setUserAsPirate(scan.nextLine());
                    break;
                case 2:
                    System.out.println("Write the username:");
                    Systems.getInstance().setUserAsFraud(scan.nextLine());
                    break;
                case 3:
                    if(Systems.getInstance().getOffers() != null){
                        for ( Offer offer : Systems.getInstance().getOffers() ) {
                            System.out.println("-----"+" "+offer.getId()+" -----");
                            System.out.println("Seller: "+offer.getSeller().getUsername());
                            System.out.println("Absorption: "+offer.getAbsortion());
                            System.out.println("Power: "+offer.getPower());
                            System.out.println("Price: "+offer.getPrice());
                            System.out.println("Status: "+offer.getStatus());
                            System.out.println();
                        }
                    }
                    break;
                case 4:
                    offerVerificacionMenu();
                    break;
                case 5:
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("Incorrect option");


            }
            Database.saveData();
        }
    }

    public static void executeClientMenu(){
        Scanner scan = new Scanner(System.in);
        int option = -1;
        while(option != 8){
            System.out.println("Choose and option:");

            System.out.println("1. Search and buy");
            System.out.println("2. Create offer");
            System.out.println("3. Create Ship");
            System.out.println("4. Subscriptions");
            System.out.println("5. View my Ships");
            System.out.println("6. View my Offers");
            System.out.println("7. View my Notifications");
            System.out.println("8. Exit");

            option = scan.nextInt();
            scan.nextLine();

            switch (option) {
                case 1:
                    Client user = (Client) Systems.getInstance().getCurrentUser();
                    if(user.getRace() == "Kromagg"){
                        if(user.isSpecialLicense()){
                            searchMenu();
                        }else {
                            System.out.println("You don´t have license");
                        }
                    }else {
                        searchMenu();
                    }
                    break;
                case 2:
                    createOffer();
                    break;
                case 3:
                    registerShip();
                    break;
                case 4:
                    int option4 = 1;
                    Client userCurrent = (Client) Systems.getInstance().getCurrentUser();
                    while(option4 < 1 || option4 > 5){

                        System.out.println("Choose an option subscriptions: ");
                        System.out.println("1. FIGHTER");
                        System.out.println("2. DESTROYER");
                        System.out.println("3. CARGO");
                        System.out.println("4. SPACE_STATION");
                        System.out.println("5. Delete my subscription");

                        option4 = scan.nextInt();
                        scan.nextLine();
                        switch (option4){
                            case 1:
                                userCurrent.setInterestedIn(ShipType.FIGHTER);
                                break;
                            case 2:
                                userCurrent.setInterestedIn(ShipType.DESTROYER);
                                break;
                            case 3:
                                userCurrent.setInterestedIn(ShipType.CARGO);
                                break;
                            case 4:
                                userCurrent.setInterestedIn(ShipType.SPACE_STATION);
                                break;
                            case 5:
                                userCurrent.setInterestedIn(null);
                                break;
                            default:
                                System.out.println("Invalid Option");
                        }
                    }
                    break;
                case 5:
                    ArrayList<Ship> ships = Systems.getInstance().getShipListToUser();
                    if(ships != null){
                        for (Ship ship : ships ) {
                            System.out.println("Id: "+ship.getnRegister());
                            System.out.println("Crew size: "+ship.getCrewSize());
                            System.out.println("Engines: "+ship.getEngines().length);
                            System.out.println("Type: "+ship.getClass().getSimpleName());
                            System.out.println();
                        }
                    }
                    break;
                case 6:
                    ArrayList<Offer> offerlist = Systems.getInstance().getOfferToUser();
                    if(offerlist != null){
                        for (Offer offe : offerlist ) {
                            System.out.println("Id: "+offe.getId());
                            System.out.println("Status: "+offe.getStatus());
                            System.out.println("Price: "+offe.getPrice());
                            System.out.println("Date: "+offe.getDueDate());
                            System.out.println("Power: "+offe.getPower());
                            System.out.println("Ship List:");
                            if( offe.getShipsList() != null) {
                                for (Ship ship : offe.getShipsList()) {
                                    System.out.println("Id: " + ship.getnRegister());
                                    System.out.println("Crew size: " + ship.getCrewSize());
                                    System.out.println("Engines: " + ship.getEngines().length);
                                    System.out.println("Type: " + ship.getClass().getSimpleName());
                                    System.out.println();
                                }
                            }
                            System.out.println();
                        }
                    }
                    break;
                case 7:
                    Client userCurrent2 = (Client) Systems.getInstance().getCurrentUser();
                    ArrayList<String> notifications = userCurrent2.getNotificaciones();
                    if(notifications != null){
                        for ( String notify : notifications) {
                            System.out.println(notify);
                            System.out.println();
                        }
                    }
                    break;
                case 8:
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("Incorrect option");
            }
            Database.saveData();
        }

    }

    private static  void registerShip(){
        Scanner scan = new Scanner(System.in);
        ArrayList<Ship> ships = new ArrayList<Ship>();
        int option = -1;
        while(option < 1 || option > 4){
            System.out.println("Choose and option:");
            System.out.println("1. FIGHTER");
            System.out.println("2. DESTROYER");
            System.out.println("3. CARGO");
            System.out.println("4. SPACE_STATION");

            option = scan.nextInt();
            scan.nextLine();
            switch (option){
                case 1:
                    ships.add(ShipCreator.createShip(ShipType.FIGHTER));
                    Systems.getInstance().addShipListToUser(ships);
                    break;
                case 2:
                    ships.add(ShipCreator.createShip(ShipType.DESTROYER));
                    Systems.getInstance().addShipListToUser(ships);
                    break;
                case 3:
                    ships.add(ShipCreator.createShip(ShipType.CARGO));
                    Systems.getInstance().addShipListToUser(ships);
                    break;
                case 4:
                    ships.add(ShipCreator.createShip(ShipType.SPACE_STATION));
                    Systems.getInstance().addShipListToUser(ships);
                    break;
                default:
                    System.out.println("Invalid Option");
            }
        }

        Database.saveData();
    }

    public static void searchMenu(){
        Scanner scan = new Scanner(System.in);
        int option = -1;
        while(option != 4){
            System.out.println("Choose and option:");

            System.out.println("1. Search by ship type");
            System.out.println("2. Notifications");
            System.out.println("3. Buy");
            System.out.println("4. Exit");

            option = scan.nextInt();
            scan.nextLine();

            switch (option) {
                case 1:
                    searOfferByType();
                    break;
                case 2:

                    break;
                case 3:
                    System.out.println("Offer Id:");
                    String offerId = scan.nextLine();

                    String sellerUsername = Systems.getInstance().buyOffer(offerId);

                    reviewUser(sellerUsername);
                    break;
                case 4:
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("Invalid Option");

            }
        }

    }


    public static void offerVerificacionMenu(){
        Scanner scan = new Scanner(System.in);
        int option = -1;
        while(option != 3){
            System.out.println("Choose and option:");

            System.out.println("1. Approve");
            System.out.println("2. Reject");
            System.out.println("3. Exit");

            option = scan.nextInt();
            scan.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Write the offer id:");
                    Systems.getInstance().approveOffer(scan.nextLine());
                    break;
                case 2:
                    System.out.println("Write the offer id:");
                    Systems.getInstance().rejectOffer(scan.nextLine());
                    break;
                case 3:
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("Invalid Option");

            }
        }

    }

    public static boolean login(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter username:");
        String username = scan.nextLine();

        System.out.println("Enter password:");
        String password = scan.nextLine();

        return Systems.getInstance().login(username, password);
    }

    public static void register(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose user type:");

        int option = 0;
        UserRole role = null;
        while(option < 1 || option > 3){

            System.out.println("1. Admin");
            System.out.println("2. Client");
            System.out.println("3. Abort");

            option = scan.nextInt();
            scan.nextLine();
            switch (option) {
                case 1:
                    role = UserRole.ADMIN;
                    break;
                case 2:
                    role = UserRole.CLIENT;
                    break;
                case 3:
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("Invalid Option");

            }
        }


        if(role != null){
            User user = UserCreator.createUser(role);
            Systems.getInstance().addUserToList(user);
            Database.saveData();
        }

    }

    public static void createOffer() {
        Scanner scan = new Scanner(System.in);
        Client user = (Client) Systems.getInstance().getCurrentUser();

        System.out.println("Offer Id:");
        String offerId = scan.nextLine();

        int numberShips = -1;
        while (numberShips < 0){
            System.out.println("Number of ships in the offer:");
            numberShips = scan.nextInt();
            scan.nextLine();
            if(numberShips < 0){
                System.out.println("Invalid input");
            }
        }

        String shipId;
        ArrayList<Ship> shipsList = new ArrayList<>();
        for(int i=0; i<numberShips; i++){
            System.out.println("Id of ship to add:");
            shipId = scan.nextLine();
            for (Ship ship : Systems.getInstance().getShipListToUser()){
                if( shipId.equals(ship.getnRegister()) ){
                    shipsList.add(ship);
                }
            }
        }

        int power = 0;
        int absortion = 0;
        for (Ship s : shipsList) {
            power = power + s.getTotalPower();
            absortion = absortion + s.getTotalDefense();
        }

        int price = -1;
        while (price < 0){
            System.out.println("Price:");
            price = scan.nextInt();
            scan.nextLine();
            if(price < 0){
                System.out.println("Invalid input");
            }
        }


        System.out.println("Due date (dd/MM/yyyy):");
        String dateStr = scan.nextLine();

        Offer offer = new Offer(offerId, OfferStatus.NOT_REVIEWED, shipsList, price, power, absortion, dateStr, user);

        Systems.getInstance().addOfferToList(offer);

    }

    public static void reviewUser(String sellerUsername){
        Scanner scan = new Scanner(System.in);

        System.out.println("Rate and review de seller");

        System.out.println("Comment:");
        String comment = scan.nextLine();
        int points = -1;
        while(points < 0 || points > 10){
            System.out.println("Punctuation out of 10:");
            points = scan.nextInt();
            scan.nextLine();
            if(points < 0 || points > 10){
                System.out.println("Invalid input");
            }
            Review review = new Review(comment, points);

            Systems.getInstance().addReviewToUser(sellerUsername, review);
            Database.saveData();
        }
    }

    public static void searOfferByType(){
        Scanner scan = new Scanner(System.in);
        int typeInt = -1;
        String type = "";
        while(typeInt < 1 || typeInt > 4){
            System.out.println("Choose an type:");

            System.out.println("1. Fighter");
            System.out.println("2. Cargo");
            System.out.println("3. Destroyer");
            System.out.println("4. Space Station");

            typeInt = scan.nextInt();
            scan.nextLine();
            switch (typeInt){
                case 1:
                    type = "FighterShip";
                    break;
                case 2:
                    type = "CargoShip";
                    break;
                case 3:
                    type = "DestroyerShip";
                    break;
                case 4:
                    type = "SpaceStationShip";
                    break;

            }
        }







        ArrayList<Offer> offers = Systems.getInstance().getOfferOfshipType(type);

        for (Offer offer : offers){
            System.out.println(offer.getId() + " - " + offer.getPrice());
        }

    }

}
