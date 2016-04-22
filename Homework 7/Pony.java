import java.util.Random;

/**
 * Class which represents ponies
 * @author Jared Duncan
 * @version 1.0
 */
public class Pony extends Animal implements Pettable, Feedable {
    /**
     * Constructor for ponies
     */
    public Pony() {
        super("Pony");
    }

    /**
     * Makes the pony make noise
     * @return "Whinny"
     */
    public String makeNoise() {
        return "Whinny";
    }

    /**
     * Makes the pony move
     * @return "trot"
     */
    public String move() {
        return "trot";
    }

    /**
     * The pony is pet for a random amount of time
     * @return String representation of how the pony is pet
     */
    public String pet() {
        Random rand = new Random();
        double timePet = rand.nextDouble() * MAX_TIME_PETTABLE;
        int minutes = (int) timePet;
        int seconds = (int) (timePet % 1 * 60);

        String action = String.format("You pet the pony for %d minutes"
            + " and %d seconds.%n", minutes, seconds);
        action += makeNoise() + "\n";
        action += String.format("The pony %ss closer to you.%n", move());
        return action;
    }

    /**
     * The pony is fed a random amount of hay
     * @return String representation of the pony being fed
     */
    public String feed() {
        Random rand = new Random();
        int amountOfFood = rand.nextInt(MAX_AMOUNT_OF_FOOD) + 1;
        String action = String.format("You feed the pony %d pieces of hay.%n",
            amountOfFood);
        action += makeNoise() + "\n";
        action += String.format("The pony %ss away.%n", move());
        return action;
    }
}