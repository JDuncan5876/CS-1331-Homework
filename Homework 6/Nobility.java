/**
 * Represents nobilities within Westeros
 * @author Jared Duncan
 * @version 1.0
 */
public class Nobility {
    protected String name;

    /**
     * Constructor for instances of Nobility. Initializes name variable.
     * @param name Name of the nobility
     */
    public Nobility(String name) {
        this.name = name;
    }

    /**
     * Sets the name of the nobility
     * @param newName New name of the nobility
     */
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * toString override, returns name + "."
     * @return String representation of nobility: name + "."
     */
    public String toString() {
        return name + ".";
    }
}