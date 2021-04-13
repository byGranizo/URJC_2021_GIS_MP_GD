package Refactor;

import Refactor.System.Systems;
import Refactor.User.User;
import Refactor.User.UserCreator;
import Refactor.User.UserRole;

import java.util.Scanner;

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

                    break;
                case 2:

                    break;
                case 3:

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
        while(option != 3){
            System.out.println("Choose and option:");

            System.out.println("1. Search");
            System.out.println("2. Create offer");
            System.out.println("3. Exit");

            option = scan.nextInt();

            switch (option) {
                case 1:

                    break;
                case 2:

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
        }

    }


}
