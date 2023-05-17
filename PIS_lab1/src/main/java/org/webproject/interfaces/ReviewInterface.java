package main.java.org.webproject.interfaces;

import main.java.org.webproject.models.Review;

import java.util.List;

public interface ReviewInterface {
    void createReview(Review review);
    List<Review> getReviewsByAppointmentId(long appointmentId);
    void updateReview(Review review);
    void deleteReview(long reviewId);
    void closeConnection();
}

