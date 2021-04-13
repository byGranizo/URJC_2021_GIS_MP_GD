package Refactor.System;

import Refactor.Offer.Offer;
import Refactor.Offer.SoldOffer;
import Refactor.User.User;

import java.util.ArrayList;

public final class System {
    private static System instance;

    private ArrayList<User> users;
    private ArrayList<Offer> offers;
    private ArrayList<SoldOffer> soldOffers;

    private System(ArrayList<User> users, ArrayList<Offer> offers, ArrayList<SoldOffer> soldOffers) {
        this.users = users;
        this.offers = offers;
        this.soldOffers = soldOffers;
    }

    public static System getInstance(ArrayList<User> users, ArrayList<Offer> offers, ArrayList<SoldOffer> soldOffers){
        if(instance == null){
            instance = new System(users, offers, soldOffers);
        }
        return instance;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Offer> getOffers() {
        return offers;
    }

    public void setOffers(ArrayList<Offer> offers) {
        this.offers = offers;
    }

    public ArrayList<SoldOffer> getSoldOffers() {
        return soldOffers;
    }

    public void setSoldOffers(ArrayList<SoldOffer> soldOffers) {
        this.soldOffers = soldOffers;
    }
}
