/**
 * Keeps track of the families in a group and their children
 * @author Jared Duncan
 * @version 1.0
 */
public class Neighborhood {
    private Family[] families;
    private int numChildren;
    private int numBoys;
    private int numGirls;

    /**
     * Constructor for Neighborhood object
     * @param numFamilies Number of families in the neighborhood
     */
    public Neighborhood(int numFamilies) {
        families = new Family[numFamilies];
        numChildren = 0;
        numBoys = 0;
        numGirls = 0;

        for (int i = 0; i < numFamilies; i++) {
            families[i] = new Family(i + 1);
        }
    }

    public double getAverage() {
        return (double) numChildren / families.length;
    }

    public int getNumBoys() {
        return numBoys;
    }

    public int getNumGirls() {
        return numGirls;
    }

    public int getMaxNumChildren() {
        int maxNumChildren = Integer.MIN_VALUE;
        for (Family family : families) {
            int numChildren = family.getNumChildren();
            if (numChildren > maxNumChildren) {
                maxNumChildren = numChildren;
            }
        }
        return maxNumChildren;
    }

    public void haveChildren() {
        for (Family family : families) {
            while (!family.hasBoysAndGirls()) {
                char baby = family.haveChild();
                numChildren++;
                if (baby == 'B') {
                    numBoys++;
                } else if (baby == 'G') {
                    numGirls++;
                }
            }
        }
    }

    public String toString() {
        String output = "";
        for (Family family : families) {
            output += family.toString() + "\n";
        }
        output = output.substring(0, output.length() - 1);
        return output;
    }
}