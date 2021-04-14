package System;

import Offer.Offer;
import Offer.OfferStatus;
import Offer.Review;
import Offer.SoldOffer;
import Ship.Ship;
import User.Client;
import User.User;
import User.UserRole;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public final class Systems implements Serializable {
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

    private Systems(){
        this.users = new ArrayList<User>();
        this.offers = new ArrayList<Offer>();
        this.soldOffers = new ArrayList<SoldOffer>();
    }

    public static Systems getInstance(ArrayList<User> users, ArrayList<Offer> offers, ArrayList<SoldOffer> soldOffers){
        if(instance == null){
            instance = new Systems(users, offers, soldOffers);
        }
        return instance;
    }

    public static void setInstance(Systems systems){
        instance = systems;
    }

    public static Systems getInstance(){
        if(instance == null){
            instance = new Systems();
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

    public void addOfferToList(Offer offer){
        offers.add(offer);
    }

    public void setUserAsPirate(String username){
        User user;
        Client client;
        for(int i=0;i<users.size();i++){
            user = users.get(i);
            if (user.getUsername().equals(username) && user.getRole() == UserRole.CLIENT){
                client = (Client) user;
                client.setPiracySuspect(true);
                users.set(i, client);
                return;
            }
        }
    }

    public void incrementUserWarning(String username){
        User user;
        Client client;
        for(int i=0;i<users.size();i++){
            user = users.get(i);
            if (user.getUsername().equals(username) && user.getRole() == UserRole.CLIENT){
                client = (Client) user;
                client.setnWarnings(client.getnWarnings() + 1);
                users.set(i, client);
                return;
            }
        }
    }

    public void setUserAsFraud(String username){
        User user;
        Client client;
        for(int i=0;i<users.size();i++){
            user = users.get(i);
            if (user.getUsername().equals(username) && user.getRole() == UserRole.CLIENT){
                client = (Client) user;
                client.setFraudSuspect(true);
                users.set(i, client);
                return;
            }
        }
    }

    public void approveOffer(String id){
        Offer offer;
        for(int i=0;i<offers.size();i++){
            offer = offers.get(i);
            if (offer.getId().equals(id)){
                offer.setStatus(OfferStatus.APPROVED);
                offers.set(i, offer);
                return;
            }
        }
    }

    public void rejectOffer(String id){
        Offer offer;
        for(int i=0;i<offers.size();i++){
            offer = offers.get(i);
            if (offer.getId().equals(id)){
                incrementUserWarning(offer.getSeller().getUsername());
                offers.remove(i);
                return;
            }
        }
    }

    public String buyOffer(String offerId){
        ArrayList<Ship> shipList;

        Offer offer;
        for(int i=0;i<offers.size();i++){
            offer = offers.get(i);
            if (offer.getId().equals(offerId)){
                offers.remove(i);
                offer.setStatus(OfferStatus.SOLD);

                SoldOffer soldOffer = new SoldOffer(offer, new Date(), getCurrentUser());
                soldOffers.add(soldOffer);

                shipList = offer.getShipsList();

                addShipListToUser(shipList);

                return offer.getSeller().getUsername();
            }
        }

        return null;

    }

    public void addShipListToUser(ArrayList<Ship> shipList){
        User user;
        Client client;
        for(int i=0;i<users.size();i++){
            user = users.get(i);
            if (user.getUsername().equals(currentUser.getUsername()) && user.getRole() == UserRole.CLIENT){
                client = (Client) user;

                ArrayList<Ship> clientShipList = client.getShips();
                clientShipList.addAll(shipList);
                client.setShips(clientShipList);

                users.set(i, client);
                return;
            }
        }
    }

    public void addReviewToUser(String username, Review review){
        User user;
        Client client;
        for(int i=0;i<users.size();i++){
            user = users.get(i);
            if (user.getUsername().equals(username) && user.getRole() == UserRole.CLIENT){
                client = (Client) user;

                ArrayList<Review> clientReviews = client.getReviews();
                clientReviews.add(review);
                client.setReviews(clientReviews);

                users.set(i, client);
                return;
            }
        }
    }
}
