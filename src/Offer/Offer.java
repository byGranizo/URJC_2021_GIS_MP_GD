package Offer;

import Ship.Ship;
import User.Client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Offer implements Serializable {
    private String id;
    private OfferStatus status;
    private ArrayList<Ship> shipsList;
    private int price;
    private int power;
    private Date dueDate;
    private Client seller;

    public Offer(String id, OfferStatus status, ArrayList<Ship> shipsList, int price, int power, Date dueDate, Client seller) {
        this.id = id;
        this.status = status;
        this.shipsList = shipsList;
        this.price = price;
        this.power = power;
        this.dueDate = dueDate;
        this.seller = seller;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OfferStatus getStatus() {
        return status;
    }

    public void setStatus(OfferStatus status) {
        this.status = status;
    }

    public ArrayList<Ship> getShipsList() {
        return shipsList;
    }

    public void setShipsList(ArrayList<Ship> shipsList) {
        this.shipsList = shipsList;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Client getSeller() {
        return seller;
    }

    public void setSeller(Client seller) {
        this.seller = seller;
    }
}
