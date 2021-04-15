package Observer;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;
import System.Systems;

public class ObserverOffers implements Observer, Serializable {

    @Override
    @SuppressWarnings("unchecked")
    public void update(Observable observable, Object args) {
        if (args instanceof Systems.OfferEvent) {
            Systems.OfferEvent evento = (Systems.OfferEvent) args;
            System.out.println("observable funciona: "+evento.getType().size());
        }
    }
}
