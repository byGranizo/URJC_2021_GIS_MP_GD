package System;

import Offer.Offer;
import Offer.OfferStatus;
import Offer.Review;
import Ship.Ship;
import Ship.Types.DestroyerShip;
import Ship.Types.FighterShip;
import User.User;
import Ship.ShipType;
import Offer.SoldOffer;
import static org.junit.jupiter.api.Assertions.*;
import User.UserRole;
import User.Client;
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

        boolean xpresult = Systems.getInstance().login("Alvaropin17", "1237786");
        assertFalse(xpresult);
    }


    @org.junit.jupiter.api.Test
    void testAddOfferToList() {
        Systems.getInstance().login("Alvaropin17", "123456");
        User user = Systems.getInstance().getCurrentUser();
        ArrayList<Ship> ships = new ArrayList<Ship>();
        Ship ship = new FighterShip("546436", null, 5, 3, null, null);
        ships.add(ship);
        Systems.getInstance().addShipListToUser(ships);
        Client client = (Client) user;
        Offer offer = new Offer("54321", OfferStatus.NOT_REVIEWED, ships, 1, 5, 5, "12/12/2020", client);
        Systems.getInstance().addOfferToList(offer);
        ArrayList<Offer> offerlist = Systems.getInstance().getOffers();
        int numero = offerlist.size();
        assertTrue(numero==1);

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
<<<<<<< HEAD
    void login() {
=======
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
        Systems.getInstance().login("Alvaropin17", "123456");
        User user = Systems.getInstance().getCurrentUser();
        ArrayList<Ship> ships = new ArrayList<Ship>();
        Ship ship = new FighterShip("546436", null, 5, 3, null, null);
        Ship ship2 = new DestroyerShip("54231", null, 5, 3, 7, null, null);
        ships.add(ship);
        ships.add(ship2);
        Client client = (Client) user;
        Systems.getInstance().addShipListToUser(ships);
        Systems.getInstance().deleteShipsFromUser(ships,client);
        ArrayList<Ship> ships2 = client.getShips();
        assertTrue(ships2.size()==0);

>>>>>>> feature/SystemTests

    }

    @org.junit.jupiter.api.Test
    void testAddShipListToUser() {
        Systems.getInstance().login("Alvaropin17", "123456");
        User user = Systems.getInstance().getCurrentUser();
        ArrayList<Ship> ships = new ArrayList<Ship>();
        Ship ship = new FighterShip("546436", null, 5, 3, null, null);
        ships.add(ship);
        Systems.getInstance().addShipListToUser(ships);
        ArrayList<Ship> ships2 = Systems.getInstance().getShipListToUser();
       int antes = ships.size();
       int despues = ships2.size();
       boolean coincide = antes == despues;

       Ship barco1 = ships.get(0);
       Ship barco2 = ships2.get(0);
       boolean coincide2 = (barco1==barco2);
       assertTrue(coincide2==coincide);
    }

    @org.junit.jupiter.api.Test
    void testAddReviewToUser() {
        Systems.getInstance().login("Alvaropin17", "123456");
        User user = Systems.getInstance().getCurrentUser();
        Client client = (Client) user;
        ArrayList<Review> listareviews = client.getReviews();
        int antes = listareviews.size();
        Review review = new Review("Comentario de prueba", 5);
        Systems.getInstance().addReviewToUser("Alvaropin17", review);

        ArrayList<Review> listareviews2 = client.getReviews();
        int despues = listareviews2.size();

        assertTrue(despues-antes==1);

    }

}