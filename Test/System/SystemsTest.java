package System;

import Offer.Offer;
import Offer.OfferStatus;
import Offer.Review;
import Ship.Ship;
import Ship.Types.FighterShip;
import User.User;
import Ship.ShipType;
import Offer.SoldOffer;
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
    void testAddOfferToList() {

    }

    @org.junit.jupiter.api.Test
    void testIncrementUserWarning() {
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
    void testApproveOffer() {

        Systems.getInstance().login("Alvaropin17", "123456");
        User user = Systems.getInstance().getCurrentUser();
        ArrayList<Ship> ships = new ArrayList<Ship>();
        Ship ship = new FighterShip("546436", null, 5, 3, null, null);
        ships.add(ship);
        Systems.getInstance().addShipListToUser(ships);
        Client client = (Client) user;
        Offer offer = new Offer("54321", OfferStatus.NOT_REVIEWED, ships, 1, 5, 5, "12/12/2020", client); //aquí creo una oferta
        client.setInterestedIn(ShipType.FIGHTER);
        Systems.getInstance().addOfferToList(offer);
        Systems.getInstance().approveOffer("54321");
        ArrayList<Offer> offerlist = Systems.getInstance().getOffers();
        offer = offerlist.get(0);
        assertTrue(offer.getStatus()==OfferStatus.APPROVED);

    }

    @org.junit.jupiter.api.Test
    void testRejectOffer() {
        Systems.getInstance().login("Alvaropin17", "123456");
        User user = Systems.getInstance().getCurrentUser();
        ArrayList<Ship> ships = new ArrayList<Ship>();
        Ship ship = new FighterShip("546436", null, 5, 3, null, null);
        ships.add(ship);
        Systems.getInstance().addShipListToUser(ships);
        Client client = (Client) user;
        Offer offer = new Offer("54321", OfferStatus.NOT_REVIEWED, ships, 1, 5, 5, "12/12/2020", client); //aquí creo una oferta
        client.setInterestedIn(ShipType.FIGHTER);
        Systems.getInstance().addOfferToList(offer);
        Systems.getInstance().rejectOffer("54321");
        ArrayList<Offer> offerlist = Systems.getInstance().getOffers();
        int tamaño = offerlist.size();
        assertTrue(tamaño == 0);
    }

    @org.junit.jupiter.api.Test
    void testBuyOffer() {
        Systems.getInstance().login("Alvaropin17", "123456");
        User user = Systems.getInstance().getCurrentUser();
        ArrayList<Ship> ships = new ArrayList<Ship>();
        Ship ship = new FighterShip("546436", null, 5, 3, null, null);
        ships.add(ship);
        Systems.getInstance().addShipListToUser(ships);
        Client client = (Client) user;
        Offer offer = new Offer("54321", OfferStatus.NOT_REVIEWED, ships, 1, 5, 5, "12/12/2020", client);
        client.setInterestedIn(ShipType.FIGHTER);
        Systems.getInstance().addOfferToList(offer);
        Systems.getInstance().approveOffer("54321");

        Systems.getInstance().buyOffer("54321");
        ArrayList<SoldOffer> offerlist = Systems.getInstance().getSoldOffers();
        int tamaño = offerlist.size();
        assertTrue(tamaño == 1);

    }

    @org.junit.jupiter.api.Test
    void testDeleteShipsFromUser() {
    }

    @org.junit.jupiter.api.Test
    void testAddShipListToUser() {
    }

    @org.junit.jupiter.api.Test
    void addReviewToUser() {
    }

}