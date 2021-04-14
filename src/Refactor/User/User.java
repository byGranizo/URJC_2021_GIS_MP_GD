package Refactor.User;

import java.io.Serializable;

public abstract class User implements Serializable {
    private String id;
    private String fullName;
    private String username;
    private String mail;
    private UserRole role;
    private String password;

    public User(String id, String fullName, String username, String mail, UserRole role, String password) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.mail = mail;
        this.role = role;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
