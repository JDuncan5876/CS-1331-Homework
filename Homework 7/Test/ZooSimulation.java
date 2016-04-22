import java.util.Scanner;
import java.util.Random;
/**
 * Main driver class for zoo simulation.
 * I worked on this assignment alone, using only course materials.
 * @author Jared Duncan
 * @version 1.0
 */
public class ZooSimulation {
    private Animal[] zooAnimals;
    private Random rand;

    /**
     * Constructor for ZooSimulation
     */
    public ZooSimulation() {
        rand = new Random();
        zooAnimals = new Animal[6];

        zooAnimals[0] = new Sheep();
        zooAnimals[1] = new Pony();
        zooAnimals[2] = new KoiFish();
        zooAnimals[3] = new Bear();
        zooAnimals[4] = new Tiger();
        zooAnimals[5] = new Penguin();
    }

    /**
     * Main method, prompts user for input and calls appropriate methods.
     * @param args String array of arguments from the command line (unused)
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ZooSimulation zoo = new ZooSimulation();

        System.out.println("Welcome to The Atlanta Zoo!");

        int input = 0;
        while (input != 6) {
            System.out.println("\n\nWould you like to:");
            System.out.println("1. List all of the animals");
            System.out.println("2. See an output of all animals"
                                + " and their actions");
            System.out.println("3. Pet an animal");
            System.out.println("4. Feed an animal");
            System.out.println("5. Watch an animal");
            System.out.println("6. Quit");
            System.out.println("Please enter one of the options above:");

            input = scan.nextInt();
            while (input < 1 || input > 6) {
                System.out.println("Please enter a number 1-6");
                input = scan.nextInt();
            }

            if (input == 1) {
                zoo.printAnimals();
            } else if (input == 2) {
                zoo.makeAnimalSounds();
            } else if (input == 3) {
                zoo.petAnimals();
            } else if (input == 4) {
                zoo.feedAnimals();
            } else if (input == 5) {
                zoo.viewAnimals();
            }
        }
    }

    /**
     * Prints the number of animals in the zoo and all of their names.
     */
    private void printAnimals() {
        System.out.println();
        System.out.printf("There are %d animals in this zoo.%n",
            Animal.getCount());
        System.out.println("The animals in this zoo are:");

        // DONT CHANGE THE REST OF THIS METHOD
        for (Animal a : zooAnimals) {
            System.out.println(a);
        }
    }

    /**
     * Lists the animals and their sounds and movements.
     */
    private void makeAnimalSounds() {
        System.out.println(); // This line is for cleaner formatting
        for (Animal a : zooAnimals) {
            System.out.println(a);
            System.out.printf("Sound: %s%n", a.makeNoise());
            System.out.printf("Movement: %s%n%n", a.move());
        }
    }

    /**
     * Performs a pet operation on a random Pettable animal
     */
    private void petAnimals() {
        System.out.println();  // This line is for cleaner formatting
        Animal a;
        do {
            a = zooAnimals[rand.nextInt(zooAnimals.length)];
        } while (!(a instanceof Pettable));
        System.out.println(((Pettable) a).pet());
    }

    /**
     * Performs a feed operation on a random Feedable animal
     */
    private void feedAnimals() {
        System.out.println();  // This line is for cleaner formatting
        Animal a;
        do {
            a = zooAnimals[rand.nextInt(zooAnimals.length)];
        } while (!(a instanceof Feedable));
        System.out.println(((Feedable) a).feed());
    }

    /**
     * Performs a view operation on a random Viewable animal
     */
    private void viewAnimals() {
        System.out.println();  // This line is for cleaner formatting
        Animal a;
        do {
            a = zooAnimals[rand.nextInt(zooAnimals.length)];
        } while (!(a instanceof Viewable));
        System.out.println(((Viewable) a).view());
    }

}