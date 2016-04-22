import java.util.Random;

/**
 * Class which represents penguins
 * @author Jared Duncan
 * @version 1.0
 */
public class Penguin extends Animal implements Pettable, Feedable, Viewable {
    /**
     * Constructor for penguins
     */
    public Penguin() {
        super("Penguin");
    }

    /**
     * Makes the penguin make noise
     * @return "NOOT NOOT"
     */
    public String makeNoise() {
        return "NOOT NOOT";
    }

    /**
     * Makes the penguin move
     * @return "waddle"
     */
    public String move() {
        return "waddle";
    }

    /**
     * The penguin is pet for a random amount of time
     * @return String representation of how the penguin is pet
     */
    public String pet() {
        Random rand = new Random();
        double timePet = rand.nextDouble() * MAX_TIME_PETTABLE * 3;
        int minutes = (int) timePet;
        int seconds = (int) (timePet % 1 * 60);

        String action = "You pay $60 for a penguin encounter.\n";
        action += String.format("You pet the penguin for %d minutes"
            + " and %d seconds.%n", minutes, seconds);
        action += makeNoise() + "\n";
        action += String.format("The penguin %ss closer to you.%n", move());

        return action;
    }

    /**
     * The penguin is fed a random amount of fish
     * @return String representation of the penguin being fed
     */
    public String feed() {
        Random rand = new Random();
        int amountOfFood = rand.nextInt(MAX_AMOUNT_OF_FOOD) + 1;
        String action = String.format("You feed the penguin %d"
            + " pieces of fish.%n", amountOfFood);
        action += makeNoise() + "\n";
        action += String.format("The penguin %ss away.%n", move());
        return action;
    }

    /**
     * The penguin is viewed. The penguin may be asleep.
     * @return String representation of the penguin being viewed.
     */
    public String view() {
        Random rand = new Random();
        if (rand.nextDouble() < PERCENT_OF_TIME_ASLEEP) {
            return "The penguin is asleep.\nzzzzzzzzzzzz";
        }

        String action = "The penguin flaps its flippers happily.\n";
        action += makeNoise() + "\n";
        action += String.format("The penguin %ss about the enclosure.%n",
            move());
        return action;
    }
}