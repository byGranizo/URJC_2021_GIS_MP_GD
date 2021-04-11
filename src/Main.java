import Offer.Offer;
import Ships.Ship;
import bd.Database;
import bd.Systems;
import models.Customers;
import ship.complements.Propulsion;
import ship.complements.Weapon;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

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

    private static int init(){
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Register Client");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        return scan.nextInt();
    }

    private static Customers login(Systems system) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Username: ");
        String username = scan.nextLine();
        System.out.println("Password: ");
        String password = scan.nextLine();
        Customers login = system.LogIn(username, password);
        return login;
    }

    private static Customers registerCustomer(Systems system) {
        Scanner scan = new Scanner(System.in);
        List<Ship> ships = new ArrayList<>();
        System.out.println("Nick: ");
        String nick = scan.nextLine();
        System.out.println("Password: ");
        String pass = scan.nextLine();
        System.out.println("Name: ");
        String name = scan.nextLine();
        System.out.println("Email: ");
        String email = scan.nextLine();
        System.out.println("Origin: ");
        String origin = scan.nextLine();
        System.out.println("Spices: ");
        String spices = scan.nextLine();
        String id = (""+system.getListCostumers().size());
        Customers customers = new Customers(name,origin,spices,id,nick,pass,email,0,false,false,false);
        system.getListCostumers().add(customers);
        Database.saveData(system);
        return customers;
    }

    private static int menuSystem(){
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Register Ship");
        System.out.println("2. Register Offer");
        System.out.println("3. View Ships");
        System.out.println("4. View Offers");
        System.out.println("5. Back");
        return scan.nextInt();
    }

    private static void createShip(Customers customer){
        Scanner scan = new Scanner(System.in);
        List<Propulsion> propellers = new ArrayList<>();
        List<Weapon> weapons = new ArrayList<>();
        List<Ship> ships = null;
        boolean nextPropeller = true;
        boolean valido = true;
        String propeller = null;
        String weapon = null;
        while (nextPropeller) {
            System.out.println("Speed Propeller:");
            int speed = scan.nextInt();
            System.out.println("Propeller type:");
            System.out.println("1. curvature motor");
            System.out.println("2. trace compressor");
            System.out.println("3. motor FTL");
            System.out.println("4. solar sails");
            System.out.println("5. ionic engine");
            int optionPropeller = scan.nextInt();
            switch (optionPropeller) {
                case 1:
                    propeller = "curvature motor";
                    break;
                case 2:
                    propeller = "trace compressor";
                    break;
                case 3:
                    propeller = "motor FTL";
                    break;
                case 4:
                    propeller = "solar sails";
                    break;
                case 5:
                    propeller = "ionic engine";
                    break;
                default:
                    valido = false;
                    System.out.println("Invalid Option");
            }
            Propulsion propellernew = new Propulsion(propeller,speed);
            propellers.add(propellernew);
            System.out.println("More Propeller?");
            System.out.println("1. yes");
            System.out.println("2. no");
            int optionMorePropeller = scan.nextInt();
            if(optionMorePropeller == 2){
                nextPropeller = false;
            }
        }
        if(valido){
            System.out.println("Number of crew: ");
            int crew = scan.nextInt();
            boolean validWeapons = true;
            boolean nextWeapon = true;
            while (nextWeapon) {
                System.out.println("Power of Weapon: ");
                int power = scan.nextInt();
                System.out.println("Weapons");
                System.out.println("1. Plasma cannons");
                System.out.println("2. Thermonuclear missiles");
                System.out.println("3. Laser rays");
                System.out.println("4. PEM");
                int optionWeapons = scan.nextInt();
                switch (optionWeapons) {
                    case 1:
                        weapon = "Plasma cannons";
                        break;
                    case 2:
                        weapon = "Thermonuclear missiles";
                        break;
                    case 3:
                        weapon = "Laser rays";
                        break;
                    case 4:
                        weapon = "PEM";
                        break;
                    default:
                        validWeapons = false;
                        System.out.println("Invalid Option");
                }
                Weapon weaponew = new Weapon(weapon,power);
                weapons.add(weaponew);
                System.out.println("More Weapons?");
                System.out.println("1. yes");
                System.out.println("2. no");
                int optionMoreWeapon = scan.nextInt();
                if(optionMoreWeapon == 2){
                    nextWeapon = false;
                }
            }
            if(validWeapons) {
                System.out.println("Contains Ships?:");
                System.out.println("1. yes");
                System.out.println("2. no");
                int optionShips = scan.nextInt();
                if(optionShips == 1){
                    ships = new ArrayList<>();
                }
                /* Implementar crear defensas*/
            }
        }
    }

    private static void registerOffer(Systems systems){
        Scanner scan = new Scanner(System.in);
        System.out.println("TotalPower:");
        int totalPower = scan.nextInt();
        System.out.println("TotalAbsorption:");
        int totalAbsorption = scan.nextInt();
        System.out.println("Price:");
        int price = scan.nextInt();
        Offer newOffer = new Offer();
        newOffer.setTotalPower(totalPower);
        newOffer.setTotalAbsorption(totalAbsorption);
        newOffer.setPrice(price);
        newOffer.setEndDate(new Date());
        System.out.println("OfferStatus: ");
        System.out.println("1. APPROVED");
        System.out.println("2. SOLD");
        System.out.println("3. REJECTED");
        System.out.println("4. NOT_REVIEWED");
        /* No se usar los Enum*/
        /*switch (scan.nextInt()){
            case 1:
                newOffer.setStatus(OfferStatus.APPROVED);
                break;
            case 2:
                newOffer.setStatus(OfferStatus.SOLD);
                break;
            case 3:
                newOffer.setStatus(OfferStatus.REJECTED);
                break;
            case 4:
                newOffer.setStatus(OfferStatus.NOT_REVIEWED);
                break;
            default:
                System.out.println("Invalid Option");
        }*/
        systems.getListOffer().add(newOffer);
    }

    private static Ship selectShips(Customers client){
        Scanner scan = new Scanner(System.in);
        int limit = client.getShips().size();
        int option = 1;
        Ship shipselected = null;
        for (Ship ship : client.getShips()) {
            System.out.println(option+". "+ship.getRegNum());
        }
        int selectShip = scan.nextInt();
        if(selectShip > 0 && selectShip <= limit){
            shipselected = client.getShips().get((selectShip-1));
        }
        return shipselected;
    }
}