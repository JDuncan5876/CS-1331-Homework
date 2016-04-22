import java.util.Iterator;

/**
 * Snaek Linked List implementation of the SinglyLinkedList interface
 *
 * I worked on this assignment alone, using only course materials.
 *
 * @author Shashank Singh
 * @author Jared Duncan (jduncan45)
 * @author Severus Snaek
 * @version 1.0
 */
public class SnaekLinkedList implements SinglyLinkedList {

    // DO NOT MODIFY THESE VARIABLE NAMES
    private SnaekNode head;
    private SnaekNode tail;
    private int size;

    /**
     * Constructor for SnaekLinkedList. Initializes size to zero. Leaves head
     * and tail as null.
     */
    public SnaekLinkedList() {
        size = 0;
    }

    @Override
    public Iterator<Position> iterator() {
        return new Iterator<Position>() {
            private SnaekNode iter = head;

            @Override
            public boolean hasNext() {
                return iter != null;
            }

            @Override
            public Position next() {
                Position p = iter.getPosition();
                iter = iter.getNext();
                return p;
            }
        };
    }

    @Override
    public void addFront(Position newPos) {
        if (newPos == null) {
            return;
        } else if (size == 0) {
            SnaekNode newNode = new SnaekNode(newPos);
            head = newNode;
            tail = newNode;
        } else {
            head = new SnaekNode(newPos, head);
        }
        size++;
    }

    @Override
    public void addEnd(Position newPos) {
        if (newPos == null) {
            return;
        }

        SnaekNode newNode = new SnaekNode(newPos);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    @Override
    public Position removeFront() {
        if (size == 0) {
            return null;
        }

        Position headPos = head.getPosition();
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
        }
        size--;
        return headPos;
    }

    @Override
    public Position removeEnd() {
        if (size == 0) {
            return null;
        }

        Position tailPos = tail.getPosition();
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            SnaekNode newTail = head;
            while (newTail.getNext() != tail) {
                newTail = newTail.getNext();
            }
            tail = newTail;
            newTail.setNext(null);
        }
        size--;
        return tailPos;
    }

    @Override
    public Position getFront() {
        if (size == 0) {
            return null;
        }
        return head.getPosition();
    }

    @Override
    public Position getEnd() {
        if (size == 0) {
            return null;
        }
        return tail.getPosition();
    }

    @Override
    public boolean contains(Position other) {
        for (Position p : this) {
            if (p.equals(other)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}