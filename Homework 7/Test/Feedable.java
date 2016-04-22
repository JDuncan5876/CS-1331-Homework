/**
 * Interface for animals which are feedable
 * @author Jared Duncan
 * @version 1.0
 */
public interface Feedable {
    int MAX_AMOUNT_OF_FOOD = 10;

    /**
     * The animal is fed
     * @return String representation of how the animal is fed
     */
    String feed();
}