/**
 * Singly Linked List interface that you must implement in SnaekLinkedList
 *
 * @author Shashank Singh
 * @author Severus Snaek
 * @version 1.0
 */
public interface SinglyLinkedList extends Iterable<Position> {

    /**
     * Add a new Position to the front of the LinkedList
     *
     * If newPos is null, just return without doing anything
     *
     * @param newPos new Position to add
     */
    void addFront(Position newPos);

    /**
     * Add a new Position to the end of the LinkedList
     *
     * If newPos is null, just return without doing anything
     *
     * @param newPos new Position to add
     */
    void addEnd(Position newPos);

    /**
     * Remove and return the Position from the front of the LinkedList
     *
     * If the linked list is empty, just return null
     *
     * @return the Position that was at the front
     */
    Position removeFront();

    /**
     * Remove and return the Position from the end of the LinkedList
     *
     * If the linked list is empty, just return null
     *
     * @return the Position that was at the end
     */
    Position removeEnd();

    /**
     * Get the Position at the front of the LinkedList
     *
     * If the linked list is empty, just return null
     *
     * @return the Position that is at the front
     */
    Position getFront();

    /**
     * Get the Position at the end of the LinkedList
     *
     * If the linked list is empty, just return null
     *
     * @return the Position that is at the end
     */
    Position getEnd();

    /**
     * Checks whether the SnaekLinkedList contains the given Position
     * @param other Position to find
     * @return whether the Position is in the list
     */
    boolean contains(Position other);

    /**
     * Clears all nodes from the SnaekLinkedList
     */
    void clear();

    /**
     * Gets the number of Positions in the list
     * @return number of Positions in the list
     */
    int size();

    /**
     * Checks whether the list is empty
     * @return true if the list is empty
     */
    boolean isEmpty();
}
