import java.util.Arrays;
import java.util.Scanner;

public class recursiveSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size: ");
        int n = sc.nextInt();
        int[] A = new int[n];
        System.out.println("Enter the numbers: ");
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        System.out.println("The Array is: " + Arrays.toString(A));
        System.out.println("Choose the sorting technique:\n1. Merge Sort\n2. Quick Sort");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                Merge_Sort mS = new Merge_Sort(A);
                break;
            case 2:
                Quick_Sort qS = new Quick_Sort(A);
                break;
            default:
                System.out.println("Wrong Choice!! Exiting");
                break;
        }
    }
}
