/**
 * Represents Northern Houses of Westeros.
 * @author Jared Duncan
 * @version 1.0
 */
public class NorthHouse extends House {
    private ColdResistance coldResistance;
    private boolean wargAbility;

    /**
     * Stores name, words, and knightCount of the House, along with the House's
     * cold resistance and whether or not they have the ability to warg.
     * @param name Name of the House
     * @param words Words of the House
     * @param knightCount Number of knights the House has.
     * @param coldResistance Cold resistance of the House
     * @param wargAbility Whether or not the House can warg
     */
    public NorthHouse(String name, String words, int knightCount,
        ColdResistance coldResistance, boolean wargAbility) {

        super(name, words, knightCount);
        this.coldResistance = coldResistance;
        this.wargAbility = wargAbility;
    }

    /**
     * toString() override. Returns superclass String but also includes North
     * and the House's cold resistance and warg abilities
     * @return String representation of the North House.
     */
    public String toString() {
        return String.format("North %s Has %s coldResistance."
            + " %s warg abilities.", super.toString(), coldResistance,
            wargAbility ? "Has" : "Does not have");
    }
}