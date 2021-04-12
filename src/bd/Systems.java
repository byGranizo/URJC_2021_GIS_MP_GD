package bd;
import java.util.ArrayList;
import Offer.Offer;
import models.Admin;
import models.Customers;
import Offer.SoldOffer;
import models.Notify;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;

public class Systems {
    //crew list
    private Object List;
    private ArrayList<Customers> listCustomers = new ArrayList<>();
    private ArrayList<Admin> listAdmins = new ArrayList<>();
    private ArrayList<Offer> listOffer = new ArrayList<>();
    private ArrayList<SoldOffer> listSoldOffer = new ArrayList<>();


    Map<String, List<Notify>> listeners = new HashMap<>();
    public Systems (String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }
    public void subscribe(String eventType, Notify listener) {
        List<Notify> users = listeners.get(eventType);
        users.add(listener);
    }
    public void unsubscribe(String eventType, Notify listener) {
        List<Notify> users = listeners.get(eventType);
        users.remove(listener);
    }
    public void notify(String eventType, File file) {
        List<Notify> users = listeners.get(eventType);
        for (Notify listener : users) {
            listener.update(eventType, file);
        }
    }


    public ArrayList<Customers> getCustomer(){
        return listCustomers;
    }
    public void setlistCustomers(ArrayList<Customers> listCustomers){
        this.listCustomers= listCustomers;
    }

    public ArrayList<Admin> getAdmin(){
        return listAdmins;
    }
    public void setlistAdmins(ArrayList<Admin> listAdmins){
        this.listAdmins= listAdmins;
    }

    public ArrayList<Offer> getOffer(){
        return listOffer;
    }

    public ArrayList<SoldOffer> getOfferSold(){
        return listSoldOffer;
    }

    public void LogIn(String username, String password) {


    }

    public void AddOffer(Offer offer) {
        listOffer.add(offer);

    }
    public void FindOffer(Object ship){

    }
    public void ReviewOffer(Object admin, Object offer){

    }
    public void DesignateSuspects(Object admin, Object customer){

    }
    public void UploadComments(Object customer){

    }


}




