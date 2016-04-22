/**
 * Animal abstract parent class
 * @author Jared Duncan
 * @version 1.0
 */
public abstract class Animal {
    private static int count;
    private String name;

    /**
     * Constructor for animal class
     * @param name Name of the animal
     */
    public Animal(String name) {
        this.name = name;
        count++;
    }

    /**
     * The animal makes its unique noise
     * @return String representing the noise the animal makes
     */
    public abstract String makeNoise();

    /**
     * The animal moves in its unique way
     * @return String representing the way the animal moves
     */
    public abstract String move();

    /**
     * Gets the number of Animals instantiated so far
     * @return The number of animals instantiated so far
     */
    public static int getCount() {
        return count;
    }

    /**
     * Getter method for the animal's name
     * @return The animal's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gives the string representation of this animal (functionally the same
     * as getName() method)
     * @return name of the animal
     */
    public String toString() {
        return name;
    }
}