import java.util.Random;

/**
 * Class which represents sheep
 * @author Jared Duncan
 * @version 1.0
 */
public class Sheep extends Animal implements Pettable {
    /**
     * Constructor for sheep
     */
    public Sheep() {
        super("Sheep");
    }

    /**
     * Makes the sheep make noise
     * @return "Baaaaaaaaaaaaaaaaaa"
     */
    public String makeNoise() {
        return "Baaaaaaaaaaaaaaaaaa";
    }

    /**
     * Makes the sheep move
     * @return "shuffle"
     */
    public String move() {
        return "shuffle";
    }

    /**
     * The sheep is pet for a random amount of time. The sheep may stop caring
     * and walk away while you are petting it.
     * @return String representation of how the sheep is pet
     */
    public String pet() {
        Random rand = new Random();
        double timePet = rand.nextDouble() * MAX_TIME_PETTABLE;
        int minutes = (int) timePet;
        int seconds = (int) (timePet % 1 * 60);

        String action = String.format("You pet the sheep for %d minutes"
            + " and %d seconds.%n", minutes, seconds);
        action += makeNoise() + "\n";
        action += String.format("The sheep sheepishly %ss closer to you.%n",
            move());

        if (rand.nextDouble() < 0.5) {
            action += "The sheep stopped caring and left"
                + " before you finished petting it.\n";
        }

        return action;
    }
}