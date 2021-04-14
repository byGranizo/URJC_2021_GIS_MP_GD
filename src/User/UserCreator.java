package User;

import java.io.Serializable;
import java.util.Scanner;

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

        System.out.println("Enter mail:");
        String mail = scan.nextLine();

        System.out.println("Enter password:");
        String password = scan.nextLine();

        if(role == UserRole.ADMIN){
            user = new Admin(id, fullName, username, mail, role, password);
        } else if (role == UserRole.CLIENT){
            System.out.println("Enter planet:");
            String planet = scan.nextLine();

            System.out.println("Enter race:");
            String race = scan.nextLine();

            System.out.println("Enter special license:");
            System.out.println("1. Si");
            System.out.println("2. No");

            int option = scan.nextInt();
            boolean specialLicense = false;
            switch (option) {
                case 1:
                    specialLicense = true;
                    break;
                case 2:
                    specialLicense = false;
                    break;
            }

            user = new Client(id, fullName, username, mail, role, password, planet, race, specialLicense);
        }

        return user;
    }
}
