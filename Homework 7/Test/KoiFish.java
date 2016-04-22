import java.util.Random;

/**
 * Class which represents koi fish
 * @author Jared Duncan
 * @version 1.0
 */
public class KoiFish extends Animal implements Feedable {
    /**
     * Constructor for koi fish
     */
    public KoiFish() {
        super("Koi Fish");
    }

    /**
     * Makes the koi fish make noise
     * @return "Gurgle gurgle"
     */
    public String makeNoise() {
        return "Gurgle gurgle";
    }

    /**
     * Makes the koi fish move
     * @return "swim"
     */
    public String move() {
        return "swim";
    }

    /**
     * The koi fish is fed a random number of pellets. Another fish may
     * randomly come and eat the pellets.
     * @return String representation of the koi fish being fed
     */
    public String feed() {
        Random rand = new Random();
        int amountOfFood = rand.nextInt(MAX_AMOUNT_OF_FOOD) + 1;
        String action = String.format("You feed the koi fish %d pellets.%n",
            amountOfFood);
        action += makeNoise() + "\n";
        action += String.format("The fish %ss away.%n", move());

        if (rand.nextDouble() < 0.25) {
            action += "Another fish came and ate the food.\n";
        }
        return action;
    }
}