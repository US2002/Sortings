import java.util.*;

public class iterativeSorting {
    // Bubble
    // insertion
    // Selection
    // Counting

    public static void main(String[] args) {
        int[] arr1 = { 1, 5, 9, 8, 7, 4, 3, 6, 2 };
        int[] arr2 = { 5, 4, 2, 3, 6, 9, 7, 1, 8 };
        int[] arr3 = { 1, 5, 8, 7, 4, 3, 6, 2, 9 };
        int[] arr4 = { 8, 4, 2, 2, 8, 3, 3, 1, 7 };

        System.out.println("Unsorted: " + Arrays.toString(arr1));
        System.out.println("Bubble Sort: " + Arrays.toString(bubbleSort(arr1)));
        System.out.println();
        System.out.println("Unsorted: " + Arrays.toString(arr2));
        System.out.println("Insertion Sort: " + Arrays.toString(insertionSort(arr2)));
        System.out.println();
        System.out.println("Unsorted: " + Arrays.toString(arr3));
        System.out.println("Selection Sort: " + Arrays.toString(selectionSort(arr3)));
        System.out.println();
        System.out.println("Unsorted: " + Arrays.toString(arr4));
        System.out.println("Counting Sort: " + Arrays.toString(countingSort(arr4)));

    }

    private static int[] countingSort(int[] arr) {
        int largest = 0;
        // Counting Largest
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        // largest = 8

        // Making a array with largest elements index!! here arr2 of size 9 i.e 0-8
        int[] arr2 = new int[largest + 1];
        for (int i = 0; i < arr.length; i++) {
            // element of arr act as index of arr2
            // all element increase the indexed element of arr2 by 1
            arr2[arr[i]]++;
        }
        System.out.println("Before Manipulation: " + Arrays.toString(arr2));
        // AFTER process arr2 =
        // 0, 1, 2, 2, 1, 0, 0, 1, 2
        // counted the number of occurance of elemnts in arr.

        // Here we manipulate the arr2
        // using formula: arr[i] = arr[i-1] + arr[i];
        for (int i = 1; i < arr2.length; i++) {
            arr2[i] = arr2[i - 1] + arr2[i];
        }
        System.out.println("After Manipulation: " + Arrays.toString(arr2));
        // 0, 1, 3, 5, 6, 6, 6, 7, 9

        // creating new array to give the output.
        int[] arr3 = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int indx2 = arr2[arr[i]]--;
            indx2--;
            arr3[indx2] = arr[i];
        }
        return arr3;
    }

    private static int[] selectionSort(int[] arr) {
        /*
         * 1** 5 9 8 7 4 3 6 2
         * 1 2* 9 8 7 4 3 6 5*
         * 1 2 3* 8 7 4 9* 6 5
         * 1 2 3 4* 7 8* 9 6 5
         * 1 2 3 4 5* 8 9 6 7*
         * 1 2 3 4 5 6* 9 8* 7
         * 1 2 3 4 5 6 7* 8 9*
         * 1 2 3 4 5 6 7 8** 9
         * 1 2 3 4 5 6 7 8 9**
         */
        // TIME COMPLEXITY = O(N^2)

        for (int i = 0; i < arr.length - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[smallest] > arr[j]) {
                    smallest = j;
                }
            }
            swap(arr, i, smallest);
            // System.out.println(Arrays.toString(arr));
        }
        return arr;
    }

    private static int[] insertionSort(int[] arr) {
        /*
         * 5 | 4 2 3 6 9 7 1 8
         * 4 5 | 2 3 6 9 7 1 8
         * 2 4 5 | 3 6 9 7 1 8
         * 2 3 4 5 | 6 9 7 1 8
         * 2 3 4 5 6 | 9 7 1 8
         * 2 3 4 5 6 9 | 7 1 8
         * 2 3 4 5 6 7 9 | 1 8
         * 1 2 3 4 5 6 7 9 | 8
         * 1 2 3 4 5 6 7 8 9 |
         */
        // TIME COMPLEXITY = O(N^2)

        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && current < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            // placement
            arr[j + 1] = current;
            // System.out.println(Arrays.toString(arr));
        }
        return arr;
    }

    private static int[] bubbleSort(int[] arr) {
        /*
         * 1 5 8* 7 4 3 6 2 9
         * 1 5 7* 4 3 6 2 8 9
         * 1 5* 4 3 6* 2 7 8 9
         * 1 4* 3 5* 2 6 7 8 9
         * 1 3 4* 2 5 6 7 8 9
         * 1 3* 2 4 5 6 7 8 9
         * (1 2) 3 4 5 6 7 8 9
         * (1) 2 3 4 5 6 7 8 9
         */
        // TIME COMPLEXITY = O(N^2)

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
            // System.out.println(Arrays.toString(arr));
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
