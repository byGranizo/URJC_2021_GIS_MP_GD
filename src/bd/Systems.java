package bd;

import Offer.Offer;
import models.Admin;
import models.Customers;

import java.util.ArrayList;
import java.util.List;

public class Systems {
    //creo listas
    private List<Customers> listCostumers = new ArrayList<Customers>();
    private List<Admin> ListAdmins = new ArrayList<Admin>();
    private List<Offer> ListOffer = new ArrayList<Offer>();


    public boolean LogIn(String username, String pasword) {
        boolean login = false;
        for (Customers customer: listCostumers) {
            if(customer.getNick().equals(username) && customer.getPassword().equals(pasword)){
                login = true;
                break;
            }
        }
        return login;
    }

    public void AddOffer(Object Offer) {

    }
    public void FindOffer(Object ship){

    }
    public void ReviewOffer(Object Admin, Object Offer){

    }
    public void DesignateSuspects(Object Admin, Object customer){

    }
    public void EditNotification(){

    }
    public void UploadComments(Object customer){

    }

    public List<Customers> getListCostumers() {
        return listCostumers;
    }

    public void setListCostumers(List<Customers> listCostumers) {
        this.listCostumers = listCostumers;
    }

    public List<Admin> getListAdmins() {
        return ListAdmins;
    }

    public void setListAdmins(List<Admin> listAdmins) {
        ListAdmins = listAdmins;
    }

    public List<Offer> getListOffer() {
        return ListOffer;
    }

    public void setListOffer(List<Offer> listOffer) {
        ListOffer = listOffer;
    }
}




