package Refactor.User;

public abstract class User {
    private String id;
    private String fullName;
    private String user;
    private String mail;
    private UserRole role;
    private String password;

    public User(String id, String fullName, String user, String mail, UserRole role, String password) {
        this.id = id;
        this.fullName = fullName;
        this.user = user;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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
