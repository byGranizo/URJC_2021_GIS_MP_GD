package Offer;

import Ship.Ship;
import User.Client;
import User.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class SoldOffer extends Offer implements Serializable {
    private Date saleDate;
    private User buyer;


    public SoldOffer(Offer offer, Date saleDate, User buyer) {
        super(offer.getId(), offer.getStatus(), offer.getShipsList(), offer.getPrice(), offer.getPower(), offer.getAbsortion(), offer.getDueDate(), offer.getSeller());
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
