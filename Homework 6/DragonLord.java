/**
 * Represents the DragonLords of Westeros, a subclass of Nobility
 * @author Jared Duncan
 * @version 1.0
 */
public class DragonLord extends Nobility {
    private boolean isFireResistant;
    private int dragonCount;

    /**
     * Stores the name, fire resistance, and dragon count for the DragonLord.
     * @param name Name of the DragonLord
     * @param isFireResistant Whether or not the DragonLord is fire resistant
     * @param dragonCount Number of dragons the DragonLord has
     */
    public DragonLord(String name, boolean isFireResistant, int dragonCount) {
        super(name);
        this.isFireResistant = isFireResistant;
        this.dragonCount = dragonCount;
    }

    /**
     * toString() override. Returns the name, dragon count, and fire resistance
     * of the DragonLord.
     * @return String representation of the DragonLord
     */
    public String toString() {
        return String.format("DragonLord %s. Has %d dragons."
            + " %s fire resistant.", name, dragonCount,
            isFireResistant ? "Is" : "Isn't");
    }
}