package Refactor.Offer;

import Refactor.Ship.Ship;
import Refactor.User.Client;
import Refactor.User.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class SoldOffer extends Offer implements Serializable {
    private Date saleDate;
    private User buyer;

    public SoldOffer(String id, OfferStatus status, ArrayList<Ship> shipsList, int price, int power, Date dueDate, Client seller, Date saleDate, User buyer) {
        super(id, status, shipsList, price, power, dueDate, seller);
        this.saleDate = saleDate;
        this.buyer = buyer;
    }

    public SoldOffer(Offer offer, Date saleDate, User buyer) {
        super(offer.getId(), offer.getStatus(), offer.getShipsList(), offer.getPrice(), offer.getPower(), offer.getDueDate(), offer.getSeller());
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
