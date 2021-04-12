package models;

import Ships.Ship;

import java.util.List;

public class Customers implements User, Notify{
    private String name;
    private String origin;
    private String species;
    private String numId;
    private List<Ship> ships;
    private String nick;
    private String password;
    private String email;
    private int numWarnings;
    private boolean license;
    private boolean fraud;
    private boolean pirate;

    public Customers(String name, String origin, String species, String numId, String nick, String password, String email, int numWarnings, boolean license, boolean fraud, boolean pirate) {
        this.name = name;
        this.origin = origin;
        this.species = species;
        this.numId = numId;
        this.nick = nick;
        this.password = password;
        this.email = email;
        this.numWarnings = numWarnings;
        this.license = license;
        this.fraud = fraud;
        this.pirate = pirate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getNumId() {
        return numId;
    }

    public void setNumId(String numId) {
        this.numId = numId;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumWarnings() {
        return numWarnings;
    }

    public void setNumWarnings(int numWarnings) {
        this.numWarnings = numWarnings;
    }

    public boolean isLicense() {
        return license;
    }

    public void setLicense(boolean license) {
        this.license = license;
    }

    public boolean isFraud() {
        return fraud;
    }

    public void setFraud(boolean fraud) {
        this.fraud = fraud;
    }

    public boolean isPirate() {
        return pirate;
    }

    public void setPirate(boolean pirate) {
        this.pirate = pirate;
    }

    public boolean isKromagg(){
        if(this.species == "Kromagg"){
            return true;
        }else{
            return false;
        }
    }

    public boolean maxWarnings(){
        if(this.numWarnings < 2){
            return true;
        }else{
            return false;
        }
    }

    public String getSpecies() {
        return species;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }

    public void update (String eventType, File file) {
        //System.out.println ("Tienes una novedad acerca de naves");
    }
}