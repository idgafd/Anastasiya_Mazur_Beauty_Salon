package main.java.org.webproject.dao;

import main.java.org.webproject.models.Review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO {
    private Connection connection;

    public ReviewDAO(Connection connection) {
        this.connection = connection;
    }

    public void createReview(Review review) {
        String query = "INSERT INTO reviews (id, appointment_id, rating, comment) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, review.getId());
            statement.setLong(2, review.getAppointmentId());
            statement.setInt(3, review.getRating());
            statement.setString(4, review.getComment());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Review> getReviewsByAppointmentId(long appointmentId) {
        List<Review> reviews = new ArrayList<>();
        String query = "SELECT * FROM reviews WHERE appointment_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, appointmentId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    long reviewId = resultSet.getLong("review_id");
                    int rating = resultSet.getInt("rating");
                    String comment = resultSet.getString("comment");
                    Review review = new Review(reviewId, appointmentId, rating, comment);
                    reviews.add(review);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reviews;
    }

    public void updateReview(Review review) {
        String query = "UPDATE reviews SET rating = ?, comment = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, review.getRating());
            statement.setString(2, review.getComment());
            statement.setLong(3, review.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteReview(long reviewId) {
        String query = "DELETE FROM reviews WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, reviewId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}

