package Refactor.System;

import Refactor.Offer.Offer;
import Refactor.Offer.SoldOffer;
import Refactor.User.User;

import java.util.ArrayList;

public final class Systems {
    private static Systems instance;

    private User currentUser;

    private ArrayList<User> users;
    private ArrayList<Offer> offers;
    private ArrayList<SoldOffer> soldOffers;

    private Systems(ArrayList<User> users, ArrayList<Offer> offers, ArrayList<SoldOffer> soldOffers) {
        this.users = users;
        this.offers = offers;
        this.soldOffers = soldOffers;
    }

    public static Systems getInstance(ArrayList<User> users, ArrayList<Offer> offers, ArrayList<SoldOffer> soldOffers){
        if(instance == null){
            instance = new Systems(users, offers, soldOffers);
        }
        return instance;
    }

    public static Systems getInstance(){
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

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public boolean login(String username, String pass){
        for (User user : users){
            if (user.getUsername().equals(username) && user.getPassword().equals(pass)){
                setCurrentUser(user);
                return true;
            }
        }
        return false;
    }

    public void addUserToList(User user){
        users.add(user);
    }
}
