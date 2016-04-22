/**
 * Interface for animals which are viewable
 * @author Jared Duncan
 * @version 1.0
 */
public interface Viewable {
    double PERCENT_OF_TIME_ASLEEP = 0.3;

    /**
     * The animal is viewed
     * @return String representation of how the animal is viewed
     */
    String view();
}