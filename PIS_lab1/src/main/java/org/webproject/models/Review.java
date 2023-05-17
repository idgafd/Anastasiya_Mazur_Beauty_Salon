package main.java.org.webproject.models;

public class Review {
    private long reviewId;
    private long appointmentId;
    private int rating;
    private String comment;

    public Review(long reviewId, long appointmentId, int rating, String comment) {
        this.reviewId = reviewId;
        this.appointmentId = appointmentId;
        this.rating = rating;
        this.comment = comment;
    }

    public long getId() {
        return reviewId;
    }

    public void setId(long reviewId) {
        this.reviewId = reviewId;
    }

    public long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}


