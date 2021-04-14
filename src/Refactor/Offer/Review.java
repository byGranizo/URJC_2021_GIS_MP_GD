package Refactor.Offer;

public class Review {
    private String comment;
    private int rate;

    public Review(String comment, int rate) {
        this.comment = comment;
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
