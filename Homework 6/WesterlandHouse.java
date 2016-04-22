/**
 * Represents a Westerland House of Westeros.
 * @author Jared Duncan
 * @version 1.0
 */
public class WesterlandHouse extends House {
    private int goldCount;

    /**
     * Stores the name, words, knight count, and gold count of the House.
     * @param name Name of the House
     * @param words Words of the House
     * @param knightCount Number of Knights the House has
     * @param goldCount Amount of gold the House has
     */
    public WesterlandHouse(String name, String words,
        int knightCount, int goldCount) {

        super(name, words, knightCount);
        this.goldCount = goldCount;
    }

    /**
     * toString() override. Returns parent's String representation along with
     * the amount of gold the Westerland House has.
     * @return String representation of the Westerland House.
     */
    public String toString() {
        return String.format("Westerland %s Has %d gold coins.",
            super.toString(), goldCount);
    }
}