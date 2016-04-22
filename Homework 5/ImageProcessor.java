/**
 * Performs photoshop operations on a particular Pic
 * @author Jared Duncan
 * @version 1.0
 */
public class ImageProcessor {
    private Pic pic;

    /**
     * Constructor for ImageProcessor
     * @param pic Underlying pic object
     */
    public ImageProcessor(Pic pic) {
        this.pic = pic;
    }

    /**
     * Checks each pixel of the pic to see if it matches the key pixel. If
     * it does, its alpha value is set to zero.
     * @param key Reference pixel
     * @param dr Acceptable radius of red values to make a match with key
     * @param dg Acceptable radius of green values to make a match with key
     * @param db Acceptable radius of blue values to make a match with key
     * @return Pic with altered alpha values
     */
    public Pic chroma(Pixel key, int dr, int dg, int db) {
        int cr = key.getRed(); // "Center Red"
        int cg = key.getGreen();
        int cb = key.getBlue();

        Pic newPic = pic.deepCopy();
        Pixel[][] pixels = newPic.getPixels();
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                Pixel pixel = pixels[i][j];
                boolean matchesKey = pixel.getRed() >= cr - dr
                    && pixel.getRed() <= cr + dr
                    && pixel.getGreen() >= cg - dg
                    && pixel.getGreen() <= cg + dg
                    && pixel.getBlue() >= cb - db
                    && pixel.getBlue() <= cb + db;

                if (matchesKey) {
                    pixel.setAlpha(0);
                }
            }
        }

        return newPic;
    }

    /**
     * For every pixel in pic, if its alpha value is zero, sets its RGBA
     * values equivalent to the RGBA values of the corresponding pixel in bg.
     * @param bg Background image
     * @return Pic with background image filtered in
     */
    public Pic background(Pic bg) {
        Pic newPic = pic.deepCopy();
        Pixel[][] pixels = newPic.getPixels();
        Pixel[][] bgPixels = bg.getPixels();
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                Pixel pixel = pixels[i][j];
                Pixel bgPixel = bgPixels[i][j];
                if (pixel.getAlpha() == 0) {
                    pixel.setRed(bgPixel.getRed());
                    pixel.setGreen(bgPixel.getGreen());
                    pixel.setBlue(bgPixel.getBlue());
                    pixel.setAlpha(bgPixel.getAlpha());
                }
            }
        }
        return newPic;
    }

    /**
     * Makes a greyscale of the pic
     * @return Greyscaled pic
     */
    public Pic greyscale() {
        Pic newPic = pic.deepCopy();
        Pixel[][] pixels = newPic.getPixels();
        for (Pixel[] pixelRow : pixels) {
            for (Pixel pixel : pixelRow) {
                int average = (int) ((pixel.getRed() + pixel.getGreen()
                    + pixel.getBlue()) / 3.0);
                pixel.setRed(average);
                pixel.setGreen(average);
                pixel.setBlue(average);
            }
        }
        return newPic;
    }

    /**
     * Inverts the pic
     * @return Inverted image
     */
    public Pic invert() {
        Pic newPic = pic.deepCopy();
        Pixel[][] pixels = newPic.getPixels();
        for (Pixel[] pixelRow : pixels) {
            for (Pixel pixel : pixelRow) {
                pixel.setRed(255 - pixel.getRed());
                pixel.setGreen(255 - pixel.getGreen());
                pixel.setBlue(255 - pixel.getBlue());
            }
        }
        return newPic;
    }
}