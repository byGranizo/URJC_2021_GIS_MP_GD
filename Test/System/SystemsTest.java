package System;

import Offer.Review;
import Ship.Ship;
import User.User;

import static org.junit.jupiter.api.Assertions.*;
import User.UserCreator;
import User.UserRole;
import User.Client;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

class SystemsTest {



    @BeforeEach
    void CrearUsuario() {

        ArrayList<Ship> ships = new ArrayList<Ship>();
        ArrayList<Review> reviews = new ArrayList<Review>();
        User user = new Client("12345", "Alvaro Pindado", "Alvaropin17", "alvaro17pc", UserRole.CLIENT, "123456", "Tierra", "Humano", ships, 0, false, false, false, reviews);
        Systems.getInstance().addUserToList(user);

    }


    @org.junit.jupiter.api.Test
    void testLogin1() {

        boolean xpresult = Systems.getInstance().login("Alvaropin17", "123456");
        assertTrue(xpresult);
    }

    @org.junit.jupiter.api.Test
    void testLogin2() {

        boolean xpresult = Systems.getInstance().login("Alvaropin98", "123456");
        assertFalse(xpresult);
    }


    @org.junit.jupiter.api.Test
    void addOfferToList() {

    }

    @org.junit.jupiter.api.Test
    void incrementUserWarning() {
        int antes = 0, despues = 0;
        Systems.getInstance().login("Alvaropin17", "123456");
        User user = Systems.getInstance().getCurrentUser();
        Client client = (Client) user;
        antes = client.getnWarnings();
        Systems.getInstance().incrementUserWarning("Alvaropin17");
        despues = client.getnWarnings();
        assertTrue(despues > antes);

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
    void addReviewToUser() {
    }

}