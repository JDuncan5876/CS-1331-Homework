/**
 * This class represents reviews of restaurants.
 * @author Jared Duncan
 * @version 1.0
 */
public class Review {
    private int rating;
    private String date;
    private Restaurant restaurant;

    /**
     * Constructor for reviews
     * @param rating Rating the review gave to the restaurant
     * @param date Date the review was made
     * @param restaurant The restaurant being reviewed
     */
    public Review(int rating, String date, Restaurant restaurant) {
        this.rating = rating;
        this.date = date;
        this.restaurant = restaurant;
    }

    /**
     * Setter for the rating of the review
     * @param rating New rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Get the rating of the review
     * @return Rating of the review
     */
    public int getRating() {
        return rating;
    }

    /**
     * Set date of the review
     * @param date New date of the review
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Get the date of the review
     * @return Date of the review
     */
    public String getDate() {
        return date;
    }

    /**
     * Set the restaurant being reviewed
     * @param restaurant New restaurant being reviewed
     */
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    /**
     * Gets the restaurant being reviewed
     * @return Restaurant being reviewed
     */
    public Restaurant getRestaurant() {
        return restaurant;
    }

    /**
     * toString override
     * @return String representation of the review
     */
    public String toString() {
        return "Restaurant: " + restaurant.getName() + "\n"
            + "Date: " + date + "\n" + "Rating: " + rating;
    }

    /**
     * equals override
     * @param o Object to which this review is compared to determine equality
     * @return Whether or not the objects have the same instance data
     */
    public boolean equals(Object o) {
        if (o != null && o instanceof Review) {
            Review review = (Review) o;
            return this.rating == review.rating
                && this.date.equalsIgnoreCase(review.date)
                && this.restaurant.equals(review.restaurant);
        }
        return false;
    }

    /**
     * I have no idea what this does.
     * @return 0
     */
    public int hashCode() {
        return 0;
    }
}