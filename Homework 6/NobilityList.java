/**
 * A list of the Nobilities in Westeros
 * I worked on this assignment alone, using only course materials.
 * @author Jared Duncan
 * @version 1.0
 */
public class NobilityList {
    private Nobility[] nobilities;
    private int numNobilities;

    /**
     * Initializes number of nobilities to zero. Instantiates the array of
     * nobilities based on the input size.
     * @param size Initial size of the array of Nobilities
     */
    public NobilityList(int size) {
        nobilities = new Nobility[size];
        numNobilities = 0;
    }

    /**
     * Lists the nobilities in the Nobility array by printing them out one
     * at a time.
     */
    public void listNobilities() {
        for (Nobility nobility : nobilities) {
            if (nobility != null) {
                System.out.println(nobility);
            }
        }
    }

    /**
     * Adds a nobility to the Nobility array. If the array is full, it is
     * doubled in size and the nobility is then added to it.
     * @param nobility Nobility to add to the Nobility array.
     */
    public void add(Nobility nobility) {
        numNobilities++;
        for (int i = 0; i < nobilities.length; i++) {
            if (nobilities[i] == null) {
                nobilities[i] = nobility;
                return;
            }
        }
        int oldSize = doubleArraySize();
        nobilities[oldSize] = nobility;
    }

    private int doubleArraySize() {
        Nobility[] oldNobilities = nobilities;
        nobilities = new Nobility[oldNobilities.length * 2];
        for (int i = 0; i < oldNobilities.length; i++) {
            nobilities[i] = oldNobilities[i];
        }
        return oldNobilities.length;
    }
}