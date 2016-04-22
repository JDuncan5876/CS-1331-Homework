/**
 * Class which represents restaurants, including properties such as name,
 * cuisine, reviews, price range, and average rating.
 *
 * @author Jared Duncan
 * @version 1.0
 */
public class Restaurant {
    private String name;
    private String cuisine;
    private Review[] reviews;
    private String priceRange;
    private double averageRating;
    private int numReviews;

    /**
     * Restaurant constructor - creates review array, initializes data.
     * @param name Name of the restaurant
     * @param cuisine Cuisine of the restaurant
     * @param priceRange Price range of the restaurant (in $s)
     */
    public Restaurant(String name, String cuisine, String priceRange) {
        this.name = name;
        this.cuisine = cuisine;
        this.priceRange = priceRange;

        reviews = new Review[10];
        averageRating = 0;
        numReviews = 0;
    }

    /**
     * Gets the name of the restaurant
     * @return Name of the restaurant
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the cuisine of the restaurant
     * @return Cuisine of the restaurant
     */
    public String getCuisine() {
        return cuisine;
    }

    /**
     * Gets the reviews of the restaurant
     * @return Review array of reviews of the restaurant
     */
    public Review[] getReviews() {
        return reviews;
    }

    /**
     * Gets the price range of the restaurant
     * @return Price range of the restaurant
     */
    public String getPriceRange() {
        return priceRange;
    }

    /**
     * Gets the average rating of the restaurant
     * @return Average rating of the restaurant
     */
    public double getAverageRating() {
        return averageRating;
    }

    /**
     * Adds a review to the array of reviews
     * @param review Review to be added
     */
    public void addReview(Review review) {
        if (numReviews == reviews.length) {
            doubleReviewsSize();
        }
        reviews[numReviews] = review;
        numReviews++;
        setAverageRating();
    }

    /**
     * Deletes the specified review from the restaurant
     * @param review Review to be deleted
     */
    public void deleteReview(Review review) {
        int reviewIndex = -1;
        for (int i = 0; i < reviews.length; i++) {
            if (reviews[i] != null && reviews[i].equals(review)) {
                reviewIndex = i;
            }
        }

        if (reviewIndex == -1) {
            return;
        }

        for (int i = reviewIndex; i < reviews.length - 1; i++) {
            reviews[i] = reviews[i + 1];
        }

        numReviews--;
        setAverageRating();
    }

    /**
     * toString override
     * @return String representation of the restaurant
     */
    public String toString() {
        return String.format("||%s|| |%s|%1.2f stars|%s|", name, cuisine,
            averageRating, priceRange) + getReviewsString();
    }

    /**
     * equals override
     * @param restaurant Object to be compared with this to determine equality
     * @return Whether or not the object is equivalent to this (same name)
     */
    public boolean equals(Object restaurant) {
        return restaurant != null
            && restaurant instanceof Restaurant
            && this.name.equalsIgnoreCase(((Restaurant) restaurant).name);
    }

    /**
     * I have no idea what this does.
     * @return 0
     */
    public int hashCode() {
        return 0;
    }

    private String getReviewsString() {
        String output = "\n";
        for (Review review : reviews) {
            if (review != null) {
                output += review.getDate() + ": " + review.getRating() + "\n";
            }
        }
        return output;
    }

    private void doubleReviewsSize() {
        Review[] oldReviews = reviews;
        reviews = new Review[oldReviews.length];
        for (int i = 0; i < oldReviews.length; i++) {
            reviews[i] = oldReviews[i];
        }
    }

    private void setAverageRating() {
        if (numReviews > 0) {
            int sum = 0;
            for (Review review : reviews) {
                if (review != null) {
                    sum += review.getRating();
                }
            }
            averageRating = (double) sum / numReviews;
        } else {
            averageRating = 0.0;
        }
    }
}