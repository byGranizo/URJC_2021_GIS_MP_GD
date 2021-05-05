package Observer;

import Offer.Offer;
import Offer.OfferStatus;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import System.Systems;
import User.Client;
import User.Admin;
import User.UserRole;
import User.User;
import Offer.Review;
import java.util.ArrayList;
import java.util.Observer;

import Ship.Ship;
import Ship.ShipType;
import Ship.ShipCreator;
import Offer.OfferStatus;
import Ship.Types.FighterShip;

class ObserverOffersTest {

    @org.junit.jupiter.api.Test
    void testUpdate() {
        Observer observer = new ObserverOffers();
        Systems.getObservable().addObserver(observer);
        ArrayList<String> notifications = new ArrayList<String>();
        int antes, despues;

        ArrayList<Ship> ships = new ArrayList<Ship>();
        ArrayList<Review> reviews = new ArrayList<Review>();
        User user = new Client("12345", "Alvaro Pindado", "Alvaropin17", "alvaro17pc", UserRole.CLIENT, "123456", "Tierra", "Humano", ships, 0, false, false, false, reviews);
        Systems.getInstance().addUserToList(user);

         User user2 = new Admin("123", "Ana", "Ana1", "acc", UserRole.ADMIN, "holi");
         Systems.getInstance().addUserToList(user2);

         Systems.getInstance().login("Alvaropin17", "123456"); //me loggeo


        ArrayList<Ship> ships2 = new ArrayList<Ship>();
        Ship ship = new FighterShip("546436", null, 5, 3, null, null);  //aquí añado la lista de naves al user
        ships2.add(ship);
        Systems.getInstance().addShipListToUser(ships2);

        Client client = (Client) Systems.getInstance().getCurrentUser();
        Offer offer = new Offer("54321", OfferStatus.NOT_REVIEWED, ships2, 1, 5, 5, "12/12/2020", client); //aquí creo una oferta


        Systems.getInstance().addOfferToList(offer); //aquí se añade la oferta a la lista de ofertas del sistema

        client = (Client) Systems.getInstance().getCurrentUser();
        notifications = client.getNotificaciones();
        antes = notifications.size();
        Systems.getInstance().approveOffer("54321");
        client = (Client) Systems.getInstance().getCurrentUser();
        notifications = client.getNotificaciones();
        despues = notifications.size();
        assertTrue(despues>antes);
    }
}