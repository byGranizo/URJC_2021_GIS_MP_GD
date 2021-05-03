package System;

import User.User;

import static org.junit.jupiter.api.Assertions.*;
import User.UserCreator;
import User.UserRole;
import User.Client;

class SystemsTest {




    @org.junit.jupiter.api.Test
    void login() {

        User user = new Client("12345", "Alvaro Pindado", "Alvaropin17", "alvaro17pc", UserRole.CLIENT, "123456");
        user.setFullName("Alvaro Pindado");
        user.setId("12345");
        user.setMail("alvaro17pc");
        user.setPassword("123456");
        user.setRole(UserRole.CLIENT);
        user.setUsername("Alvaropin17");
        Systems.getInstance().addUserToList(user);

        boolean xpresult = Systems.getInstance().login("Alvaropin17", "123456");
        assertTrue(xpresult);
    }

    @org.junit.jupiter.api.Test
    void getInstance() {
    }

    @org.junit.jupiter.api.Test
    void setInstance() {
    }

    @org.junit.jupiter.api.Test
    void testGetInstance() {
    }

    @org.junit.jupiter.api.Test
    void getUsers() {
    }

    @org.junit.jupiter.api.Test
    void setUsers() {
    }

    @org.junit.jupiter.api.Test
    void getOffers() {
    }

    @org.junit.jupiter.api.Test
    void setOffers() {
    }

    @org.junit.jupiter.api.Test
    void getSoldOffers() {
    }

    @org.junit.jupiter.api.Test
    void setSoldOffers() {
    }

    @org.junit.jupiter.api.Test
    void testLogin() {
    }

    @org.junit.jupiter.api.Test
    void addUserToList() {
    }

    @org.junit.jupiter.api.Test
    void addOfferToList() {
    }

    @org.junit.jupiter.api.Test
    void setUserAsPirate() {
    }

    @org.junit.jupiter.api.Test
    void incrementUserWarning() {
    }

    @org.junit.jupiter.api.Test
    void setUserAsFraud() {
    }

    @org.junit.jupiter.api.Test
    void approveOffer() {
    }

    @org.junit.jupiter.api.Test
    void rejectOffer() {
    }

    @org.junit.jupiter.api.Test
    void buyOffer() {
    }

    @org.junit.jupiter.api.Test
    void deleteShipsFromUser() {
    }

    @org.junit.jupiter.api.Test
    void addShipListToUser() {
    }

    @org.junit.jupiter.api.Test
    void getOfferToUser() {
    }

    @org.junit.jupiter.api.Test
    void getShipListToUser() {
    }

    @org.junit.jupiter.api.Test
    void addReviewToUser() {
    }

    @org.junit.jupiter.api.Test
    void getOfferOfshipType() {
    }
}