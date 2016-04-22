import java.util.Scanner;

/**
 * This class is the driver for the Westeros Nobility Catalog Homework
 * @author Yash Punjabi
 * @version 1.0
 **/
public class Westeros {

    /**
     * The main method that is designed to help test all of the functionality
     * of the Nobility Catalogue homework.
     * @param args - the command line arguments of which there should be none
     **/
    public static void main(String[] args) {
        NobilityList list = new NobilityList(10);

        DragonLord blackfyre = new DragonLord("Blackfyre", false, 0);
        House martell = new House("Baratheon", "Ours is the fury",
            10000);
        WesterlandHouse lannister = new WesterlandHouse("Lannister",
            "Hear me roar", 20000, 1000000);
        NorthHouse mormont = new NorthHouse("Mormont", "Here we stand", 2000,
            ColdResistance.MEDIUM, false);

        list.add(blackfyre);
        list.add(martell);
        list.add(lannister);
        list.add(mormont);

        menu(list);
    }

    private static void menu(NobilityList list) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to the Westeros!\n");
            System.out.println("Which option would you like?");
            System.out.println("0. List the nobilities");
            System.out.println("1. Add a nobility");
            System.out.println("2. Exit\n");

            int userInput = input.nextInt();
            input.nextLine();
            System.out.println();

            if (userInput == 0) {
                list.listNobilities();
                System.out.println();
            } else if (userInput == 1) {
                System.out.println("Which type of nobility would"
                        + " you like to add?");
                System.out.println("0. DragonLord");
                System.out.println("1. House");
                System.out.println("2. NorthHouse");
                System.out.println("3. WesterlandHouse");
                System.out.println();
                userInput = input.nextInt();
                input.nextLine();
                System.out.println();
                if (userInput == 0) {
                    System.out.println("Please enter their name.");
                    String name = input.nextLine();
                    System.out.println();
                    System.out.println("Please enter whether they"
                        + " are fire resistant (y/n).");
                    boolean isFireResistent =
                        input.nextLine().trim().charAt(0) == 'y' ? true : false;
                    System.out.println();
                    System.out.println("Please enter the "
                            + "number of dragons they have.");
                    int dragonCount = input.nextInt();
                    input.nextLine();
                    System.out.println();
                    list.add(new DragonLord(name, isFireResistent,
                            dragonCount));
                } else if (userInput == 1) {
                    System.out.println("Please enter their name.");
                    String name = input.nextLine();
                    System.out.println();
                    System.out.println("Please enter their words.");
                    String words = input.nextLine();
                    System.out.println();
                    System.out.println("Please enter the number of "
                        + "knights they have.");
                    int knightCount = input.nextInt();
                    input.nextLine();
                    System.out.println();
                    list.add(new House(name, words, knightCount));
                } else if (userInput == 2) {
                    System.out.println("Please enter their name.");
                    String name = input.nextLine();
                    System.out.println();
                    System.out.println("Please enter their words.");
                    String words = input.nextLine();
                    System.out.println();
                    System.out.println("Please enter the number of "
                        + "knights they have.");
                    int knightCount = input.nextInt();
                    input.nextLine();
                    System.out.println();
                    System.out.println("Please enter their cold resistence"
                        + " (l/m/h)");
                    char coldResisChar = input.nextLine()
                        .trim()
                        .toLowerCase()
                        .charAt(0);
                    ColdResistance coldResistance;
                    switch (coldResisChar) {
                    case 'l':
                        coldResistance = ColdResistance.LOW;
                        break;
                    case 'm':
                        coldResistance = ColdResistance.MEDIUM;
                        break;
                    case 'h':
                        coldResistance = ColdResistance.HIGH;
                        break;
                    default:
                        coldResistance = ColdResistance.LOW;
                        break;
                    }
                    System.out.println();
                    System.out.println("Please enter whether they"
                        + " can warg (y/n).");
                    boolean wargAbility =
                        input.nextLine().trim().charAt(0) == 'y' ? true : false;
                    System.out.println();
                    list.add(new NorthHouse(name, words, knightCount,
                            coldResistance, wargAbility));
                } else if (userInput == 3) {
                    System.out.println("Please enter their name.");
                    String name = input.nextLine();
                    System.out.println();
                    System.out.println("Please enter their words.");
                    String words = input.nextLine();
                    System.out.println();
                    System.out.println("Please enter the number of "
                        + "knights they have.");
                    int knightCount = input.nextInt();
                    input.nextLine();
                    System.out.println();
                    System.out.println("Please enter the number of "
                        + "gold coins they have.");
                    int goldCount = input.nextInt();
                    input.nextLine();
                    System.out.println();
                    list.add(new WesterlandHouse(name, words, knightCount,
                        goldCount));
                }
            } else if (userInput == 2) {
                System.exit(0);
            }
        }
    }
}
