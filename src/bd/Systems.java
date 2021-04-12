package bd;
import Offer.Offer;
import models.Admin;
import models.Customers;

import java.io.Serializable;
import java.util.ArrayList;

public class Systems implements Serializable {
    //creo listas
    private List<Customers> listCostumers = new ArrayList<Customers>();
    private List<Admin> ListAdmins = new ArrayList<Admin>();
    private List<Offer> ListOffer = new ArrayList<Offer>();

    public ArrayList<Customers> getCustomer(){
        return listCustomers;
    }
    public void setlistCustomers(ArrayList<Customers> listCustomers){
        this.listCustomers= listCustomers;
    }

    public Customers LogIn(String username, String pasword) {
        Customers login = null;
        for (Customers customer: listCostumers) {
            if(customer.getNick().equals(username) && customer.getPassword().equals(pasword)){
                login = customer;
                break;
            }
        }
        return login;
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

    public void modifyCustomer(Customers customer){
        for (Customers custom: listCostumers) {
            if(customer.getNick().equals(custom.getNick())){
                custom = customer;
            }
        }
    }

    public void modifyOffer(Offer offer){
        for (Offer off: ListOffer) {
            if(off.getId() == offer.getId()){
                off = offer;
            }
        }
    }
}




