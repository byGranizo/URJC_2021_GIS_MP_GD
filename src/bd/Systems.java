package bd;
import Offer.Offer;
import models.Admin;
import models.Customers;
import Offer.SoldOffer;
import java.util.ArrayList;

public class Systems {
    //create list
    private Object List;
    private ArrayList<Customers> listCustomers = new ArrayList<>();
    private ArrayList<Admin> listAdmins = new ArrayList<>();
    private ArrayList<Offer> listOffer = new ArrayList<>();
    private ArrayList<SoldOffer> listSoldOffer = new ArrayList<>();

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


