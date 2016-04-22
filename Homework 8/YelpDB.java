import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;

/**
 * Yelp database class - database of restaurants, interacts with a .txt file
 * @author Jared Duncan
 * @version 1.0
 */
public class YelpDB {
    private Restaurant[] restaurants;
    private int arrayPosition;
    private String fileName;

    /**
     * Yelp database constructor. Sets default file as "YelpDB.txt".
     */
    public YelpDB() {
        restaurants = new Restaurant[20];
        arrayPosition = 0;
        fileName = "YelpDB.txt";
    }

    /**
     * Gets the restaurants in the database
     * @return Restaurant array of restaurants in the database
     */
    public Restaurant[] getRestaurants() {
        return restaurants;
    }

    /**
     * Loads the specified file
     * @param fileName Name of the file to be loaded
     */
    public void load(String fileName)
        throws FileNotFoundException, CorruptDatabaseException {

        this.fileName = fileName;
        try {
            Scanner inFile = new Scanner(new File(fileName));
            if (!inFile.hasNext()) {
                throw new CorruptDatabaseException("File is empty.");
            }

            int numRestaurants = inFile.nextInt();
            inFile.nextLine();

            for (int i = 0; i < numRestaurants; i++) {
                String name = inFile.nextLine();
                String cuisine = inFile.nextLine();
                inFile.nextLine(); // average rating is calculated already
                String priceRange = inFile.nextLine();
                int numReviews = inFile.nextInt();
                inFile.nextLine();
                Restaurant restaurant =
                    new Restaurant(name, cuisine, priceRange);

                for (int j = 0; j < numReviews; j++) {
                    int rating = inFile.nextInt();
                    inFile.nextLine();
                    String date = inFile.nextLine();
                    Review review = new Review(rating, date, restaurant);
                    restaurant.addReview(review);
                }

                addToDatabase(restaurant);
            }
        } catch (DuplicateRestaurantException d) {
            throw new CorruptDatabaseException(d.getMessage());
        } catch (InputMismatchException i) {
            throw new CorruptDatabaseException("Database is corrupted.");
        }
    }

    /**
     * Saves the database to a text file
     */
    public void save() throws FileNotFoundException {
        PrintWriter outFile = new PrintWriter(fileName);
        outFile.println(arrayPosition);

        for (Restaurant restaurant : restaurants) {
            if (restaurant == null) {
                outFile.close();
                return;
            }

            outFile.println(restaurant.getName());
            outFile.println(restaurant.getCuisine());
            outFile.println(restaurant.getAverageRating());
            outFile.println(restaurant.getPriceRange());

            Review[] reviews = restaurant.getReviews();
            int numReviews = 0;
            while (numReviews < reviews.length
                && reviews[numReviews] != null) {

                numReviews++;
            }

            outFile.println(numReviews);
            for (Review review : reviews) {
                if (review != null) {
                    outFile.println(review.getRating());
                    outFile.println(review.getDate());
                }
            }
        }
        outFile.close();
    }

    /**
     * Adds a restaurant to the database
     * @param restaurant Restaurant to be added to the database
     */
    public void addToDatabase(Restaurant restaurant)
        throws DuplicateRestaurantException {

        for (Restaurant arrRestaurant : restaurants) {
            if (restaurant.equals(arrRestaurant)) {
                throw new DuplicateRestaurantException();
            }
        }

        if (arrayPosition >= restaurants.length) {
            doubleRestaurantsSize();
        }

        restaurants[arrayPosition] = restaurant;
        arrayPosition++;
    }

    /**
     * Searches the database by name
     * @param name Name of the desired restaurant
     */
    public void search(String name) {
        boolean found = false;
        for (Restaurant restaurant : restaurants) {
            if (restaurant != null
                && restaurant.getName().equalsIgnoreCase(name)) {

                System.out.println(restaurant);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No restaurants matched your search criteria.");
        }
    }

    /**
     * Searches the database by cuisine and price range
     * @param cuisine Cuisine to search for
     * @param priceRange Price range to search for
     */
    public void search(String cuisine, String priceRange) {
        boolean found = false;
        for (Restaurant restaurant : restaurants) {
            if (restaurant != null
                && restaurant.getCuisine().equalsIgnoreCase(cuisine)
                && restaurant.getPriceRange().equalsIgnoreCase(priceRange)) {

                System.out.println(restaurant);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No restaurants matched your search criteria.");
        }
    }

    /**
     * Search by highest rating
     */
    public void search() {
        if (restaurants[0] == null) {
            System.out.println("There are no restaurants in the database.");
            return;
        }

        double maxAverageRating = Double.MIN_VALUE;
        for (Restaurant restaurant : restaurants) {
            if (restaurant != null
                && restaurant.getAverageRating() > maxAverageRating) {

                maxAverageRating = restaurant.getAverageRating();
            }
        }

        for (Restaurant restaurant : restaurants) {
            if (restaurant != null && Math.abs(restaurant.getAverageRating()
                - maxAverageRating) < 0.00001) {

                System.out.println(restaurant);
            }
        }
    }

    private void doubleRestaurantsSize() {
        Restaurant[] oldRestaurants = restaurants;
        restaurants = new Restaurant[oldRestaurants.length * 2];
        for (int i = 0; i < oldRestaurants.length; i++) {
            restaurants[i] = oldRestaurants[i];
        }
    }
}