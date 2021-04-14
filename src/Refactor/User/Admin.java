package Refactor.User;

import java.io.Serializable;

public class Admin extends User implements Serializable {


    public Admin(String id, String fullName, String user, String mail, UserRole role, String password) {
        super(id, fullName, user, mail, role, password);
    }
}
