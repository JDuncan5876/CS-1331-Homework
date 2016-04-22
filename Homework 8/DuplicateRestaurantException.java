/**
 * Exception for when the user attempts to add a duplicate restaurant into
 * the database.
 * @author Jared Duncan
 * @version 1.0
 */
public class DuplicateRestaurantException extends RuntimeException {
    private String message;

    /**
     * Default no args constructor for DuplciateRestaurantException.
     * Message is "You cannot have more than one of the same restaurant."
     */
    public DuplicateRestaurantException() {
        this("You cannot have more than one of the same restaurant.");
    }

    /**
     * Creates a DuplicateRestaurantException with specified message
     * @param message Message of the exceptions
     */
    public DuplicateRestaurantException(String message) {
        this.message = message;
    }

    /**
     * Gets the message of the exception
     * @return Message of the exception
     */
    public String getMessage() {
        return message;
    }
}