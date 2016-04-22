import java.util.Random;

/**
 * Class which represents tigers
 * @author Jared Duncan
 * @version 1.0
 */
public class Tiger extends Animal implements Viewable {
    /**
     * Constructor for tigers
     */
    public Tiger() {
        super("Tiger");
    }

    /**
     * Makes the tiger make noise
     * @return "Growl"
     */
    public String makeNoise() {
        return "Growl";
    }

    /**
     * Makes the tiger move
     * @return "run"
     */
    public String move() {
        return "run";
    }

    /**
     * The tiger is viewed. The tiger may be asleep.
     * @return String representation of the tiger being viewed.
     */
    public String view() {
        Random rand = new Random();
        if (rand.nextDouble() < PERCENT_OF_TIME_ASLEEP * 2) {
            return "The tiger is asleep.\nzzzzzzzzzzzz";
        }

        String action = "The tiger meows a deep, thunderous meow.\n";
        action += makeNoise() + "\n";
        action += String.format("The tiger %ss around the enclosure.%n",
            move());
        return action;
    }
}