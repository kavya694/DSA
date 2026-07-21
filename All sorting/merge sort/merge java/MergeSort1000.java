import java.util.*;

public class MergeSort1000 {

    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {

        int n = 1000;
        Random rand = new Random();

        int[] randomCase = new int[n];
        for (int i = 0; i < n; i++)
            randomCase[i] = rand.nextInt(200) + 1;

        int[] ascendingCase = new int[n];
        for (int i = 0; i < n; i++)
            ascendingCase[i] = i + 1;

        int[] descendingCase = new int[n];
        for (int i = 0; i < n; i++)
            descendingCase[i] = n - i;

        int[] partialCase = ascendingCase.clone();
        for (int i = 50; i < n; i++) {
            int j = 50 + rand.nextInt(n - 50);
            int temp = partialCase[i];
            partialCase[i] = partialCase[j];
            partialCase[j] = temp;
        }

        int[] missingCase = new int[n];
        for (int i = 0; i < n; i++)
            missingCase[i] = rand.nextInt(150) + 1;

        int[] duplicateCase = new int[n];
        for (int i = 0; i < n; i++)
            duplicateCase[i] = rand.nextInt(20) + 1;

        String[] names = {
                "Random",
                "Ascending",
                "Descending",
                "Partial Order",
                "Missing Numbers",
                "Duplicates"
        };

        int[][] cases = {
                randomCase,
                ascendingCase,
                descendingCase,
                partialCase,
                missingCase,
                duplicateCase
        };

        for (int i = 0; i < cases.length; i++) {

            int[] arr = cases[i].clone();

            System.out.println("\n======================================");
            System.out.println("Case: " + names[i]);

            System.out.println("Original Array:");
            printArray(arr);

            long start = System.nanoTime();

            mergeSort(arr, 0, arr.length - 1);

            long end = System.nanoTime();

            System.out.println("Sorted Array:");
            printArray(arr);

            System.out.printf("Execution Time: %.6f ms%n",
                    (end - start) / 1000000.0);
        }
    }
}