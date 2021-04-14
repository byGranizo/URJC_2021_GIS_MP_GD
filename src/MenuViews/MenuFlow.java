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

            }
        }

    }

    public static void executeAdminMenu(){
        Scanner scan = new Scanner(System.in);
        int option = -1;
        while(option != 4){
            System.out.println("Choose and option:");

            System.out.println("1. Register as pirate");
            System.out.println("2. Register as fraud");
            System.out.println("3. Verify offers");
            System.out.println("4. Exit");

            option = scan.nextInt();

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
                    offerVerificacionMenu();
                    break;
                case 4:
                    System.out.println("Bye");
                    break;

            }
        }

    }

    public static void executeClientMenu(){
        Scanner scan = new Scanner(System.in);
        int option = -1;
        while(option != 6){
            System.out.println("Choose and option:");

            System.out.println("1. Search and buy");
            System.out.println("2. Create offer");
            System.out.println("3. Create Ship");
            System.out.println("4. View my Ships");
            System.out.println("5. View my Ships");
            System.out.println("6. Exit");

            option = scan.nextInt();

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
                case 5:
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
                case 6:
                    System.out.println("Bye");
                    break;
            }
        }

    }

    private static  void registerShip(){
        Scanner scan = new Scanner(System.in);
        ArrayList<Ship> ships = new ArrayList<Ship>();
        System.out.println("Choose and option:");
        System.out.println("1. FIGHTER");
        System.out.println("2. DESTROYER");
        System.out.println("3. CARGO");
        System.out.println("4. SPACE_STATION");
        switch (scan.nextInt()){
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

            switch (option) {
                case 1:

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

        System.out.println("1. Admin");
        System.out.println("2. Client");
        System.out.println("3. Abort");

        int option = scan.nextInt();
        UserRole role = null;

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

        }

        if(role != null){
            User user = UserCreator.createUser(role);
            Systems.getInstance().addUserToList(user);
            Database.saveData();
        }

    }

    public static void createOffer() {
        try {
            Scanner scan = new Scanner(System.in);
            Client user = (Client) Systems.getInstance().getCurrentUser();

            System.out.println("Offer Id:");
            String offerId = scan.nextLine();

            System.out.println("Number of ships in the offer:");
            int numberShips = scan.nextInt();

            String shipId;
            ArrayList<Ship> shipsList = new ArrayList<>();
            for(int i=0; i<numberShips; i++){
                System.out.println("Id of ship to add:");
                shipId = scan.nextLine();

                for (Ship ship : user.getShips()){
                    if (ship.getnRegister() == shipId){
                        shipsList.add(ship);
                    }
                }
            }

            System.out.println("Total power:");
            int power = scan.nextInt();

            System.out.println("Price:");
            int price = scan.nextInt();


            System.out.println("Due date (dd/MM/yyyy):");
            String dateStr = scan.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dueDate = null;
            dueDate = sdf.parse(dateStr);


            Offer offer = new Offer(offerId, OfferStatus.NOT_REVIEWED, shipsList, price, power, dueDate, user);

            Systems.getInstance().addOfferToList(offer);
            Database.saveData();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public static void reviewUser(String sellerUsername){
        Scanner scan = new Scanner(System.in);

        System.out.println("Rate and review de seller");

        System.out.println("Comment:");
        String comment = scan.nextLine();

        System.out.println("Punctuation out of 10:");
        int points = scan.nextInt();

        Review review = new Review(comment, points);

        Systems.getInstance().addReviewToUser(sellerUsername, review);
        Database.saveData();
    }



}
