package Offer;
import java.io.Serializable;
import java.util.Date;

public class Offer implements Serializable {
    private int id;
    private OfferStatus status;
    private int totalPower;
    private int totalAbsorption;
    private int price;
    //private User owner;  NO TIENE GETTERS AUN
    private Date endDate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OfferStatus getStatus() {
        return status;
    }

    public void setStatus(OfferStatus status) {
        this.status = status;
    }

    public int getTotalPower() {
        return totalPower;
    }

    public void setTotalPower(int totalPower) {
        this.totalPower = totalPower;
    }

    public int getTotalAbsorption() {
        return totalAbsorption;
    }

    public void setTotalAbsorption(int totalAbsorption) {
        this.totalAbsorption = totalAbsorption;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
