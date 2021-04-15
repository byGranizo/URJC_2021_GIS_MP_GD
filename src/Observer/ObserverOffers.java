package Observer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import Ship.Ship;
import System.Systems;
import User.Client;
import User.User;
import User.UserRole;

public class ObserverOffers implements Observer, Serializable {

    @Override
    @SuppressWarnings("unchecked")
    public void update(Observable observable, Object args) {
        if (args instanceof Systems.OfferEvent) {
            Systems.OfferEvent evento = (Systems.OfferEvent) args;
            String notify = "ID: "+evento.getOffer().getId()+", Power: "+evento.getOffer().getPower()+", Defense: "+evento.getOffer().getAbsortion()+", Price: "+evento.getOffer().getPrice();
            List<String> types = new ArrayList<String>();
            for ( Ship ship : evento.getShipsList()) {
                types.add(ship.getType().toString());
            }
            for(User s : Systems.getInstance().getUsers()){
                if(s.getRole() == UserRole.CLIENT){
                    Client client = (Client) s;
                    if(client.getInterestedIn() != null) {
                        if (types.contains(client.getInterestedIn().toString())) {
                            client.getNotificaciones().add(notify);
                        }
                    }
                }
            }

        }
    }

    public static class OfferObservable extends Observable {
        @Override
        public synchronized void setChanged() {
            super.setChanged();
        }
    }
}
