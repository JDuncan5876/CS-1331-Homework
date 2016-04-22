/**
 * Single Node in a Singly Linked List
 *
 * @author Shashank Singh
 * @author Severus Snaek
 * @version 1.0
 */
public class SnaekNode {
    private Position position;
    private SnaekNode next;

    /**
     * Constructor 1 of 2
     * @param position position of the Snaek's cell
     */
    public SnaekNode(Position position) {
        this(position, null);
    }

    /**
     * Constructor 2 of 2
     * @param position position of the Snaek's cell
     * @param next reference to next SnaekNode in the LinkedList
     */
    public SnaekNode(Position position, SnaekNode next) {
        this.position = position;
        this.next = next;
    }

    /**
     * Getter method for the Snaek cell's position
     * @return Position of the Snaek cell
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Getter method for the next SnaekNode
     * @return next SnaekNode in the Linked List
     */
    public SnaekNode getNext() {
        return next;
    }

    /**
     * Setter method for this SnaekNode's next SnaekNode
     * @param newNext new next reference to set this node's next to
     */
    public void setNext(SnaekNode newNext) {
        next = newNext;
    }
}
