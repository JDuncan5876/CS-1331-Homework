/**
 * Represents a House in Westeros. Stores the name of the house along with the
 * House's words and the number of knights the House has.
 * @author Jared Duncan
 * @version 1.0
 */
public class House extends Nobility {
    protected String words;
    protected int knightCount;

    /**
     * House constructor, sets the House's name, words, and knight count
     * @param name Name of the House
     * @param words Words of the House
     * @param knightCount Number of knights the House has
     */
    public House(String name, String words, int knightCount) {
        super(name);
        this.words = words;
        this.knightCount = knightCount;
    }

    /**
     * toString override for House. Returns the House's name, words, and knight
     * count.
     * @return String representation of the House
     */
    public String toString() {
        return String.format("House %s: %s. Has %d knights.",
            name, words, knightCount);
    }
}