import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * I worked on this assignment alone, using only course materials.
 * @author Sylvia Necula
 * @author Jared Duncan - jduncan45
 * @version 1.0
 */
public class Driver {
    private static Scanner scan = new Scanner(System.in);

    /**
     * The main method that runs the yelp simulated program.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Driver driver = new Driver();
        YelpDB database = new YelpDB();

        String fileName;
        if (args.length > 0) {
            fileName = args[0];
        } else {
            fileName = "YelpDB.txt";
        }

        try {
            database.load(fileName);
        } catch (FileNotFoundException f) {
            System.out.printf("Couldn't load file \"%s\".%n", fileName);
            return;
        } catch (CorruptDatabaseException c) {
            System.out.println(c.getMessage());
            return;
        }

        boolean cont = true;
        while (cont) {
            System.out.println("Welcome to Yelp! What would you like to do?");
            System.out.println("1. View all Restaurants in database");
            System.out.println("2. Search for a Restaurant");
            System.out.println("3. Add a Restaurant to the Database");
            System.out.println("4. Exit");
            String select = scan.nextLine();

            if (select.equals("1")) {
                driver.viewRestaurants(database);
            } else if (select.equals("2")) {
                driver.search(database);
            } else if (select.equals("3")) {
                driver.addRestaurant(database);
            } else if (select.equals("4")) {
                System.out.println("Goodbye!");
                cont = false;
            } else {
                System.out.println("That's not really an option,"
                    + " try again.");
            }
            System.out.println();
        }

        try {
            database.save();
        } catch (FileNotFoundException f) {
            System.out.printf("Couldn't save file \"%s\".%n", fileName);
        }

    }

    /**
     * viewRestaurants allows a user to select a restaurant to add a review to
     *
     * @param db the database being used
     */
    public void viewRestaurants(YelpDB db) {
        System.out.println("============================================");
        System.out.println("Restaurants currently in Database");
        System.out.println("============================================");
        boolean go = true;
        while (go) {
            int i = 0;

            for (Restaurant r : db.getRestaurants()) {
                if (r != null) {
                    System.out.println(++i + ". " + r);
                }
            }
            System.out.println(++i + ". Go back\n");
            System.out.println("If you would like to add a review, type the"
                + " number of the restaurant you would like to add a review to."
                + " Otherwise type " + i +  " to quit.\n");
            System.out.print("What would you like to do? ");
            int select = scan.nextInt();
            scan.nextLine();
            if (select == i) {
                go = false;
            } else if (select < i
                && db.getRestaurants()[select - 1] != null) {

                Restaurant r = db.getRestaurants()[select - 1];
                System.out.println("You are editing: " + r);

                boolean keepGoing;
                do {
                    System.out.println("What would you like to do?");
                    System.out.println("1. Add a review");
                    System.out.println("2. Delete a review");
                    keepGoing = false;
                    String sel = scan.nextLine();
                    System.out.println();

                    if (sel.equals("1")) {
                        addReview(r);
                    } else if (sel.equals("2")) {
                        deleteReview(r);
                    } else {
                        System.out.println("Invalid input.");
                        keepGoing = true;
                        System.out.println();
                    }
                } while (keepGoing);
            } else {
                System.out.println("Invalid input.");
                System.out.println();
            }
        }
    }

    /**
     * Allows a user to add a restaurant to the database
     *
     * @param db the database being used
     */
    public void addRestaurant(YelpDB db) {
        System.out.println("=============================================");
        System.out.println("Adding a Restaurant");
        System.out.println("=============================================");

        System.out.println("What is the Restaurant's name?");
        String name = scan.nextLine();
        System.out.println("What is the type of cuisine served at " + name
            + "?");
        String cuisine = scan.nextLine();
        System.out.println("What is the price range?");
        String priceRange = scan.nextLine();
        Restaurant restaurant = new Restaurant(name, cuisine, priceRange);

        try {
            db.addToDatabase(restaurant);
        } catch (DuplicateRestaurantException d) {
            System.out.println("That restaurant already exists!");
        }
        System.out.println();
    }

    /**
     * Allows a user to search for a restaurant in the database
     *
     * @param db the database being used
     */
    public void search(YelpDB db) {
        System.out.println("==============================================");
        System.out.println("Searching");
        System.out.println("==============================================");

        boolean go = true;
        while (go) {
            System.out.println("What search option would you like to use?");
            System.out.println("1. Search by name");
            System.out.println("2. Search by cuisine and price range");
            System.out.println("3. Give me your best option");
            System.out.println("4. Go back");

            String opt = scan.nextLine();

            if (opt.equals("1")) {
                System.out.println("What restaurant would you like to"
                    + " search for?");
                String searchParameter = scan.nextLine();
                System.out.println();
                db.search(searchParameter);
            } else if (opt.equals("2")) {
                System.out.println("What cuisine would you like to search"
                    + " for?");
                String cuisine = scan.nextLine();
                System.out.println("What price range?");
                db.search(cuisine, scan.nextLine());
            } else if (opt.equals("3")) {
                System.out.println("Our highest rated restaurant is ");
                db.search();
            } else if (opt.equals("4")) {
                go = false;
            } else {
                System.out.println("That's not an option, try again.");
            }
            System.out.println();
        }
    }

    private void addReview(Restaurant r) {
        System.out.printf("What rating would you like to give %s?%n",
            r.getName());

        int rating = scan.nextInt();
        scan.nextLine();

        System.out.println("What is the date?");
        String date = scan.nextLine();
        r.addReview(new Review(rating, date, r));
        System.out.println();
    }

    private void deleteReview(Restaurant r) {
        Review[] reviews = r.getReviews();
        int i;
        for (i = 1; i <= reviews.length && reviews[i - 1] != null; i++) {
            System.out.println(i + ". " + reviews[i - 1].getDate()
                + ": " + reviews[i - 1].getRating());
        }

        System.out.println("Which review would you like to delete?");
        int selection = scan.nextInt();
        if (selection >= 1 && selection < i) {
            r.deleteReview(reviews[selection - 1]);
        } else {
            System.out.println("Invalid input.");
        }
    }
}