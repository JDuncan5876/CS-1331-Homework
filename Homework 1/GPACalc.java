import java.util.Scanner;

public class GPACalc {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("A Credit Hours: ");
        int aCredits = in.nextInt();
        System.out.print("B Credit Hours: ");
        int bCredits = in.nextInt();
        System.out.print("C Credit Hours: ");
        int cCredits = in.nextInt();
        System.out.print("D Credit Hours: ");
        int dCredits = in.nextInt();
        System.out.print("F Credit Hours: ");
        int fCredits = in.nextInt();

        int qPoints = 4 * aCredits + 3 * bCredits
            + 2 * cCredits + dCredits;
        int creditHours = aCredits + bCredits + cCredits
            + dCredits + fCredits;
        double gpa = (double) qPoints / creditHours;

        System.out.println("GPA: " + gpa);
    }
}