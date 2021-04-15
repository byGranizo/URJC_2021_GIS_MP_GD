package Observer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import Offer.Offer;
import Ship.Ship;
import System.Systems;
import User.Client;
import User.User;
import User.UserRole;

public class ObserverOffers extends  Observable implements Observer, Serializable {

    @Override
    @SuppressWarnings("unchecked")
    public void update(Observable observable, Object args) {
        if (args instanceof Offer) {
            Offer evento = (Offer) args;
            String notify = "ID: "+evento.getId()+", Power: "+evento.getPower()+", Defense: "+evento.getAbsortion()+", Price: "+evento.getPrice();
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

    @Override
    public synchronized void setChanged() {
        super.setChanged();
    }
}
