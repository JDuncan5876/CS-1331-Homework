import java.util.Random;

/**
 * Class which represents bears
 * @author Jared Duncan
 * @version 1.0
 */
public class Bear extends Animal implements Viewable {
    /**
     * Constructor for bears
     */
    public Bear() {
        super("Bear");
    }

    /**
     * Makes the bear make noise
     * @return "RAWR"
     */
    public String makeNoise() {
        return "RAWR";
    }

    /**
     * Makes the bear move
     * @return "lumber"
     */
    public String move() {
        return "lumber";
    }

    /**
     * The bear is viewed. The bear may be asleep.
     * @return String representation of the bear being viewed.
     */
    public String view() {
        Random rand = new Random();
        if (rand.nextDouble() < PERCENT_OF_TIME_ASLEEP) {
            return "The bear is asleep.\nzzzzzzzzzzzz";
        }

        String action = "The bear climbs a tree.\n";
        action += makeNoise() + "\n";
        action += String.format("The bear %ss about the enclosure.%n", move());
        return action;
    }
}