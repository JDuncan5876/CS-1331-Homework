
/**
 * I worked on this assignment alone, using only course materials.
 * @author Thomas Lilly
 * @author Jared Duncan
 * GTID: 903124464, Username: jduncan45
 */

import java.util.Random;
public class MarketSim {

    /* Please use this array to test your classes.
     * Feel free to add data to test resizing
     */
    private static String[][] businessData = {
        {"Amazon"},
        {"Fitbit ChargeHR", "129.89", "40"},
        {"Amazon Echo", "179.99" , "34"},
        {"Roses", "139.99", "100"},
        {"Lindt Chocolate", "30.40", "57"},
        {"Jaybird X2", "128.50", "20"},
        {"Football", "28.44", "176"},
        {"Shawl", "12.99", "230"},
        {"CLRS", "66.32", "281"},
        {"USB Micro-USB to USB Cable", "4.96", "132"},
        {"Stationery", "9.89", "75"}
    };


    public static void main(String[] args) {
        double startTime = System.nanoTime();
        if (args.length % 2 != 0 || args.length > 4) {
            System.out.println("\nUsage: java MarketSim [-p <numberOfPeople>] "
                + "[-d <numberOfDays>]");
            return;
        }
        int numPeople = 5;
        int numDays = 31;
        for (int i = 0; i < args.length; i += 2) {
            String input = args[i + 1];
            boolean isProper = true;
            for (int j = 0; j < input.length(); j++) {
                char character = input.charAt(j);
                isProper = isProper && character >= '0' && character <= '9';
            }

            if (isProper && args[i].equals("-p")) {
                numPeople = Integer.parseInt(input);
            } else if (isProper && args[i].equals("-d")) {
                numDays = Integer.parseInt(input);
            } else {
                System.out.println("\nUsage: java MarketSim "
                    + "[-p <numberOfPeople>] [-d <numberOfDays>]");
                return;
            }
        }

        System.out.printf("%nRunning simulation with %d people "
            + "over %d days...%n%n", numPeople, numDays);

        Random rand = new Random();
        Person[] people = new Person[numPeople];
        for (int i = 0; i < people.length; i++) {
            String name = "Person" + i;
            double balance = rand.nextInt(49999) + 50001;
            people[i] = new Person(name, balance);
        }

        Business business = new Business(businessData);
        Item[] inventory = business.getInventory();
        for (int i = 0; i < numDays; i++) {
            for (Person person : people) {
                if (rand.nextDouble() < 0.75) {
                    Item item;
                    do {
                        int itemIndex = rand.nextInt(inventory.length);
                        item = inventory[itemIndex];
                    } while (item == null);
                    int quantity = rand.nextInt(5) + 1;
                    business.sell(person, item, quantity);
                }
            }
        }

        double time = System.nanoTime() - startTime;
        System.out.println(business.getReport(numDays, time));
    }
}