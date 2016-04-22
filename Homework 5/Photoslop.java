import java.io.IOException;

/**
 * Driver class for Photoslop program.
 * I worked on this assignment alone, using only course materials.
 * @author Jared Duncan - jduncan45
 * @version 1.0
 */
public class Photoslop {
    /**
     * Main method
     * @param args String[] arguments from command line
     * @throws IOException For I/O failures
     */
    public static void main(String... args) throws IOException {
        if (args.length < 3) {
            printUsage();
            System.exit(0);
        }
        try {
            Pic pic = new Pic(args[1]);
            ImageProcessor processor = new ImageProcessor(pic);

            if (args[0].equals("-g")) {
                Pic newPic = processor.greyscale();
                newPic.save(args[2]);
            } else if (args[0].equals("-i")) {
                Pic newPic = processor.invert();
                newPic.save(args[2]);
            } else if (args[0].equals("-c")) {
                Pixel chromaKey = new Pixel(26, 185, 19, 1);
                Pic tempPic = processor.chroma(chromaKey, 20, 40, 20);
                ImageProcessor newProcessor = new ImageProcessor(tempPic);
                Pic backgroundImage = new Pic(args[2]);
                Pic newPic = newProcessor.background(backgroundImage);
                newPic.save(args[3]);
            } else {
                printUsage();
            }
        } catch (IOException ex) {
            System.out.println("One of the files you referenced does not exist,"
                + " or is corrupted. Double-check and try again.");
        }
    }

    private static void printUsage() {
        System.out.println("Greyscale mode: ");
        System.out.println("java Photoslop -g imageFile outputFileName");
        System.out.println("");
        System.out.println("Invert mode: ");
        System.out.println("java Photoslop -i imageFile outputFileName");
        System.out.println("");
        System.out.println("Greenscreen mode: ");
        System.out.println("java Photoslop -c imageFile backgroundFile"
            + " outputFileName");
    }
}
