import java.util.Scanner;
import java.util.Random;

public class ArrayDouble {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random rand = new Random();

		int arrayLength = input.nextInt();
		int[] arr1 = new int[arrayLength];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = rand.nextInt() / 2;
            System.out.print(arr1[i] + " ");
		}
        System.out.println();

		int[] arr2 = new int[arr1.length * 2];
        for (int i = 0; i < arr2.length; i++) {
            if (i < arr1.length) {
                arr2[i] = arr1[i];
            } else {
                arr2[i] = arr1[i - arr1.length] * 2;
            }
            System.out.print(arr2[i] + " ");
        }
        System.out.println("\n" + arr1.length);
        System.out.println(arr2.length);
	}
}