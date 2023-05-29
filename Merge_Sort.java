import java.util.Arrays;

public class Merge_Sort {

    Merge_Sort() {
        System.out.println("AutoMatic Constructor Generated");
    }

    Merge_Sort(int[] A) {
        System.out.println("Array Received: " + Arrays.toString(A));
        int p = 0, r = A.length - 1;
        System.out.println("Here p: " + p + " & r: " + r);
        mergeSort(A, p, r);
        System.out.println("Sorted the given array using\nMerge Sort: " + Arrays.toString(A));
    }

    // public static void main(String[] args) {
    // int[] A = { 15, 10, 5, 20, 25, 30, 40, 35 };
    // int p = 0;
    // int r = A.length - 1;
    // mergeSort(A, p, r);
    // System.out.println(Arrays.toString(A));
    // }

    private static void mergeSort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            // System.out.println("q: " + q);
            // System.out.println("A: " + Arrays.toString(A));
            // System.out.println("p: " + p + " r: " + r);
            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    private static void merge(int[] A, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = A[p + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = A[q + i + 1];
        }
        // System.out.println("L: " + Arrays.toString(L) + " R: " + Arrays.toString(R));
        int i = 0, j = 0;
        for (int k = p; k < A.length; k++) {
            if (i != L.length && j != R.length) {
                if (L[i] < R[j]) {
                    A[k] = L[i];
                    i++;
                } else {
                    A[k] = R[j];
                    j++;
                }
            } else if (j < R.length) {
                A[k] = R[j];
                j++;
            } else if (i < L.length) {
                A[k] = L[i];
                i++;
            }
        }
    }
}
