/**
 * Exception describing a corruption in the Yelp database
 * @author Jared Duncan
 * @version 1.0
 */
public class CorruptDatabaseException extends Exception {
    private String message;

    /**
     * Creates exception with message "The database file is corrupted."
     */
    public CorruptDatabaseException() {
        this("The database file is corrupted.");
    }

    /**
     * Creates exception with specified message
     * @param message Message of the exception
     */
    public CorruptDatabaseException(String message) {
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