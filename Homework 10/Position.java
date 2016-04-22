import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Position of a Snaek's cell
 *
 * @author Shashank Singh
 * @author Severus Snaek
 * @version 1.0
 */
public class Position {
    private int x;
    private int y;
    private Rectangle rectangle;
    private static boolean alt = true;

    /**
     * Constructor
     * @param x column number of the Snaek cell
     * @param y row number of the Snaek cell
     */
    public Position(int x, int y) {
        createRectangle();
        setX(x);
        setY(y);
    }

    /**
     * Getter method for the X position of the cell
     * @return x position of the cell
     */
    public int getX() {
        return x;
    }

    /**
     * Getter method for the Y position of the cell
     * @return y position of the cell
     */
    public int getY() {
        return y;
    }

    /**
     * Setter method for the X position of the cell
     * @param x new x position of the cell
     */
    public void setX(int x) {
        this.x = x;
        rectangle.setX(x * SnaekFX.CELL_SIZE + 1);
    }

    /**
     * Setter method for the Y position of the cell
     * @param y new y position of the cell
     */
    public void setY(int y) {
        this.y = y;
        rectangle.setY(y * SnaekFX.CELL_SIZE + 1);
    }

    /**
     * Compares if two Position objects are the same based on their X and
     * Y position
     * @param o other object to compare to
     * @return true if this Position's X and Y are the same as the other
     * Object's
     */
    @Override
    public boolean equals(Object o) {
        return this == o || o instanceof Position
                && x == ((Position) o).x && y == ((Position) o).y;
    }

    ///////////////////////////////////////////
    // DON'T WORRY ABOUT ANYTHING BELOW THIS //
    ///////////////////////////////////////////

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public int hashCode() {
        return x * 11000 + y;
    }

    /**
     * Helper method for creating Rectangle graphic for this Snaek cell
     */
    private void createRectangle() {
        rectangle = new Rectangle(SnaekFX.CELL_SIZE - 2, SnaekFX.CELL_SIZE - 2);
        if (alt) {
            rectangle.setFill(Color.DARKBLUE);
        }
        alt = !alt;
    }

    /**
     * Getter method for the Rectangle that will be displayed on the main Pane
     * @return Rectangle graphic for this Position
     */
    public Rectangle getRectangle() {
        return rectangle;
    }
}
