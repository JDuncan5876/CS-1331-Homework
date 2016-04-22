/**
 * Represents a pixel of an image. Keeps track of red, green, blue, and alpha
 * pixel values.
 * @author Jared Duncan
 * @version 1.0
 */
public class Pixel {
    private int red;
    private int blue;
    private int green;
    private int alpha;

    /**
     * Constructor for the Pixel class
     * @param red Pixel's red value
     * @param blue Pixel's blue value
     * @param green Pixel's green value
     * @param alpha Pixel's alpha value
     */
    public Pixel(int red, int green, int blue, int alpha) {
        if (red < 0) {
            this.red = 0;
        } else if (red > 255) {
            this.red = 255;
        } else {
            this.red = red;
        }

        if (green < 0) {
            this.green = 0;
        } else if (green > 255) {
            this.green = 255;
        } else {
            this.green = green;
        }

        if (blue < 0) {
            this.blue = 0;
        } else if (blue > 255) {
            this.blue = 255;
        } else {
            this.blue = blue;
        }

        if (alpha < 0) {
            this.alpha = 0;
        } else if (alpha > 255) {
            this.alpha = 255;
        } else {
            this.alpha = alpha;
        }
    }

    /**
     * @return Pixel's red value
     */
    public int getRed() {
        return red;
    }

    /**
     * Sets pixel's red value
     * @param red New red value
     */
    public void setRed(int red) {
        this.red = red;
    }

    /**
     * @return Pixel's green value
     */
    public int getGreen() {
        return green;
    }

    /**
     * Sets pixel's green value
     * @param green New green value
     */
    public void setGreen(int green) {
        this.green = green;
    }

    /**
     * @return Pixel's blue value
     */
    public int getBlue() {
        return blue;
    }

    /**
     * Sets pixel's blue value
     * @param blue New blue value
     */
    public void setBlue(int blue) {
        this.blue = blue;
    }

    /**
     * @return Pixel's alpha value
     */
    public int getAlpha() {
        return alpha;
    }

    /**
     * Sets pixel's alpha value
     * @param alpha New alpha value
     */
    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }
}