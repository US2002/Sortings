import java.util.Arrays;

public class Quick_Sort {

    Quick_Sort() {
        System.out.println("AutoMatic Constructor Generated");
    }

    Quick_Sort(int[] A) {
        System.out.println("Array Received: " + Arrays.toString(A));
        int p = 0, r = A.length - 1;
        System.out.println("Here p: " + p + " & r: " + r);
        quickSort(A, p, r);
        System.out.println("Sorted the given array using\nQuick Sort: " + Arrays.toString(A));
    }

    // public static void main(String[] args) {
    // int[] A = { 15, 10, 5, 20, 25, 30, 40, 35 };
    // int p = 0;
    // int r = A.length - 1;
    // quickSort(A, p, r);
    // System.out.println(Arrays.toString(A));
    // }

    private static void quickSort(int[] A, int p, int r) {
        if (p < r) {
            int q = partition(A, p, r);
            quickSort(A, p, q - 1);
            quickSort(A, q + 1, r);
        }
    }

    private static int partition(int[] A, int p, int r) {
        int pivot = A[r];
        int i = p - 1;
        for (int j = p; j <= r - 1; j++) {
            if (A[j] <= pivot) {
                i++;
                swap(A, i, j);
            }
        }
        swap(A, i + 1, r);
        return (i + 1);
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
