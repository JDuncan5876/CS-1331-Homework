import java.util.Random;
public class Family {
    private String children;
    private int identifier;

    public Family(int identifier) {
        children = "";
        this.identifier = identifier;
    }

    public char haveChild() {
        Random rand = new Random();
        char child = rand.nextDouble() < 0.5 ? 'B' : 'G';
        children += child;
        return child;
    }

    public boolean hasBoysAndGirls() {
        return children.contains("B") && children.contains("G");
    }

    public int getNumChildren() {
        return children.length();
    }

    public String toString() {
        return identifier + " - " + children;
    }
}