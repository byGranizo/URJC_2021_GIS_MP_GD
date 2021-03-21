package Offer;
import java.util.Date;

public class SoldOffer extends Offer {
    private Date soldDate;
    //private User buyer;
    private String comment;

    public Date getSoldDate() {
        return soldDate;
    }

    public void setSoldDate(Date soldDate) {
        this.soldDate = soldDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
