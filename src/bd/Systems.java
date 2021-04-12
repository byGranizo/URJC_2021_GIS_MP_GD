package bd;
import Offer.Offer;
import Ships.Ship;
import models.Admin;
import models.Customers;
import Offer.SoldOffer;
import models.User;
import java.util.ArrayList;

public class Systems {
    //create list
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

    public void LogIn(User username, String password) {


    }

    public void AddOffer(Offer offer) {
        listOffer.add(offer);

    }
    public void FindOffer(Ship ship){


    }
    public void ReviewOffer(Admin admin, Offer offer){

    }
    public void DesignateSuspects(Admin admin, Customers customer){

    }
    public void UploadComments(Customers customer){

    }
}




