package Refactor.Offer;

import Refactor.Ship.Ship;
import Refactor.User.Client;
import Refactor.User.User;

import java.util.ArrayList;
import java.util.Date;

public class SoldOffer extends Offer {
    private Date saleDate;
    private User buyer;

    public SoldOffer(OfferStatus status, ArrayList<Ship> shipsList, int price, int power, Date dueDate, Client seller, Date saleDate, User buyer) {
        super(status, shipsList, price, power, dueDate, seller);
        this.saleDate = saleDate;
        this.buyer = buyer;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }


}
