package Offer;

import Ship.Ship;
import User.Client;
import User.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class SoldOffer extends Offer implements Serializable {
    private String saleDate;
    private User buyer;


    public SoldOffer(Offer offer, String saleDate, User buyer) {
        super(offer.getId(), offer.getStatus(), offer.getShipsList(), offer.getPrice(), offer.getPower(), offer.getAbsortion(), offer.getDueDate(), offer.getSeller());
        this.saleDate = saleDate;
        this.buyer = buyer;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }


}
