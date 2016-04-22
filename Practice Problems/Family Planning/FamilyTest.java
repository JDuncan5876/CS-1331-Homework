import java.util.Scanner;
public class FamilyTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean another = true;
        do {
            System.out.println("\nReady to run a family simulation."
                + " Enter the number of families:");
            int numFamilies = scan.nextInt();
            scan.nextLine();

            if (numFamilies > 0) {
                runSimulation(numFamilies);
                boolean invalid = false;
                do {
                    System.out.println("\nWould you like to run another "
                        + "simulation? (y/n)");
                    String response = scan.nextLine();
                    if (response.equalsIgnoreCase("y")) {
                        another = true;
                        invalid = false;
                    } else if (response.equalsIgnoreCase("n")) {
                        another = false;
                        invalid = false;
                    } else {
                        invalid = true;
                        System.out.println("Sorry, I didn't understand that.");
                    }
                } while(invalid);
            } else {
                System.out.println("Invalid input.");
            }
        } while(another);
    }

    private static void runSimulation(int numFamilies) {
        System.out.println("\nSimulating Families");
        Neighborhood neighborhood = new Neighborhood(numFamilies);
        neighborhood.haveChildren();
        System.out.println(neighborhood);
        System.out.printf("The average number of children was %1.2f and "
            + "maxiumum was %d.%n", neighborhood.getAverage(),
            neighborhood.getMaxNumChildren());
        System.out.printf("A total of %d boys and %d girls were born.%n",
            neighborhood.getNumBoys(), neighborhood.getNumGirls());
    }
}