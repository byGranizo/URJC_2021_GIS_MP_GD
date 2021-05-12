package User;

import java.io.Serializable;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserCreator implements Serializable {
    public static User createUser(UserRole role){
        Scanner scan = new Scanner(System.in);

        User user = null;

        System.out.println("Enter id:");
        String id = scan.nextLine();


        System.out.println("Enter full name:");
        String fullName = scan.nextLine();

        System.out.println("Enter username:");
        String username = scan.nextLine();

        String mail = "";
        while(!mail.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")){
            System.out.println("Enter mail:");
            mail = scan.nextLine();

            if(!mail.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")){
                System.out.println("Wrong input");
            }
        }


        System.out.println("Enter password:");
        String password = scan.nextLine();

        if(role == UserRole.ADMIN){
            user = new Admin(id, fullName, username, mail, role, password);
        } else if (role == UserRole.CLIENT){
            System.out.println("Enter planet:");
            String planet = scan.nextLine();

            System.out.println("Enter race:");
            String race = scan.nextLine();

            int option = -1;
            boolean specialLicense = false;
            while(option < 1 || option > 2){
                System.out.println("Enter special license:");
                System.out.println("1. Si");
                System.out.println("2. No");

                option = scan.nextInt();
                scan.nextLine();

                switch (option) {
                    case 1:
                        specialLicense = true;
                        break;
                    case 2:
                        specialLicense = false;
                        break;
                    default:
                        System.out.println("Wrong input");
                }
            }


            user = new Client(id, fullName, username, mail, role, password, planet, race, specialLicense);
        }

        return user;
    }
}
