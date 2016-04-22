/**
 * Interface for animals which are pettable
 * @author Jared Duncan
 * @version 1.0
 */
public interface Pettable {
    double MAX_TIME_PETTABLE = 10.0;

    /**
     * The animal is pet
     * @return String representation of how the animal is pet
     */
    String pet();
}