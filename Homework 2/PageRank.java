/* In order to help learn course concepts, I conuslted related material
that can be found at http://stackoverflow.com/questions/13102045
/skipping-nextline-after-using-next-nextint-or-other-nextfoo-methods */
import java.util.Scanner;

public class PageRank {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] pages = {"Wikipedia", "Facebook", "TechCrunch",
            "Twitter", "BlueApron", "Instagram", "Pinterest",
            "Quora", "GrubHub", "Airbnb"};
        int[] outLinks = {10, 8, 6, 6, 4, 1, 7, 5, 2, 4};
        int[] ranks = {4, 4, 3, 4, 1, 1, 4, 3, 2, 2};

        System.out.println("Enter a page name:");
        String pageName = input.nextLine();

        System.out.printf("%nHow many outbound links does %s have?%n",
            pageName);
        int numOutLink = input.nextInt();
        input.nextLine();

        System.out.println("\nAvailable Pages:");
        for (int n = 0; n < 10; n++) {
            System.out.println(pages[n]);
        }

        System.out.printf("%nWhich of the above pages links to %s?%n",
            pageName);
        String linkedPages = input.nextLine();

        System.out.println("\nWhat damping factor would you like to use?");
        double dampingFactor = input.nextDouble();

        double pageRank = (1 - dampingFactor) / numOutLink;

        for (int n = 0; n < 10; n++) {
            if (linkedPages.contains(pages[n])) {
                pageRank += dampingFactor * ranks[n] / outLinks[n];
            }
        }

        System.out.printf("%nThe PageRank of %s is: %1.2f!%n",
            pageName, pageRank);
    }
}