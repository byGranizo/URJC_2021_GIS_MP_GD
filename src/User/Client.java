package User;

import Offer.Review;
import Ship.Ship;
import Ship.ShipType;
import java.io.Serializable;
import java.util.ArrayList;

public class Client extends User implements Serializable,Subscriber {
    private String originPlanet;
    private String race;
    private ArrayList<Ship> ships;
    private int nWarnings;
    private boolean piracySuspect;
    private boolean fraudSuspect;
    private boolean specialLicense;
    private ArrayList<Review> reviews;

    private ShipType interestedIn;
    private ArrayList<String> notificaciones;

    public Client(String id, String fullName, String user, String mail, UserRole role, String password, String originPlanet, String race, ArrayList<Ship> ships, int nWarnings, boolean piracySuspect, boolean fraudSuspect, boolean specialLicense, ArrayList<Review> reviews) {
        super(id, fullName, user, mail, role, password);
        this.originPlanet = originPlanet;
        this.race = race;
        this.ships = ships;
        this.nWarnings = nWarnings;
        this.piracySuspect = piracySuspect;
        this.fraudSuspect = fraudSuspect;
        this.specialLicense = specialLicense;
        this.reviews = reviews;
    }

    public Client(String id, String fullName, String user, String mail, UserRole role, String password, String originPlanet, String race, boolean specialLicense) {
        super(id, fullName, user, mail, role, password);
        this.originPlanet = originPlanet;
        this.race = race;
        this.ships =  new ArrayList<>();
        this.nWarnings = 0;
        this.piracySuspect = false;
        this.fraudSuspect = false;
        this.specialLicense = specialLicense;
        this.reviews = new ArrayList<>();
    }

    public String getOriginPlanet() {
        return originPlanet;
    }

    public void setOriginPlanet(String originPlanet) {
        this.originPlanet = originPlanet;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public void setShips(ArrayList<Ship> ships) {
        this.ships = ships;
    }

    public int getnWarnings() {
        return nWarnings;
    }

    public void setnWarnings(int nWarnings) {
        this.nWarnings = nWarnings;
    }

    public boolean isPiracySuspect() {
        return piracySuspect;
    }

    public void setPiracySuspect(boolean piracySuspect) {
        this.piracySuspect = piracySuspect;
    }

    public boolean getFraudSuspect() {
        return fraudSuspect;
    }

    public void setFraudSuspect(boolean fraudSuspect) {
        this.fraudSuspect = fraudSuspect;
    }

    public boolean isSpecialLicense() {
        return specialLicense;
    }

    public void setSpecialLicense(boolean specialLicense) {
        this.specialLicense = specialLicense;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    public ShipType getInterestedIn() {
        return interestedIn;
    }

    public void setInterestedIn(ShipType interestedIn) {
        this.interestedIn = interestedIn;
    }

    public ArrayList<String> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(ArrayList<String> notificaciones) {
        this.notificaciones = notificaciones;
    }

    @Override
    public void update(String notification) {
        this.notificaciones.add(notification);
    }
}
