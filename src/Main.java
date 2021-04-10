import Ships.Ship;
import bd.Database;
import bd.Systems;
import models.Customers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Systems system = new Systems();
        int option = 0;
        if(Database.existsData()){
            system = Database.loadData();
        }
        while(option != 3){
            option = init();
            switch (option){
                case 1 :
                    registerCustomer(system);
                    break;
                case 2 :
                    Boolean login = login(system);
                    if(login){
                        int optionSystem = 0;
                        while (optionSystem != 5){
                            optionSystem = menuSystem();
                        }

                    }
                    break;
                case 3 :
                    break;
                default:
                    System.out.println("invalid option");
            }
        }
    }

    private static boolean login(Systems system) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Username: ");
        String username = scan.nextLine();
        System.out.println("Password: ");
        String password = scan.nextLine();
        Boolean login = system.LogIn(username, password);
        return login;
    }

    private static void registerCustomer(Systems system) {
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
    }

    private static int menuSystem(){
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Register Client");
        System.out.println("1. Register Client");
        System.out.println("1. Register Client");
        System.out.println("1. Register Client");
        System.out.println("1. Register Client");
        return scan.nextInt();
    }

    private static int init(){
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Register Client");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        return scan.nextInt();
    }

}