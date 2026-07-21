import java.util.*;

public class QuickSort100 {

    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    static void printArray(int arr[]) {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        Random rand = new Random();
        int n = 100;

        int[] randomCase = new int[n];
        int[] ascendingCase = new int[n];
        int[] descendingCase = new int[n];
        int[] partialCase = new int[n];
        int[] missingCase = new int[n];
        int[] duplicateCase = new int[n];

        // Random
        for (int i = 0; i < n; i++)
            randomCase[i] = rand.nextInt(1000) + 1;

        // Ascending
        for (int i = 0; i < n; i++)
            ascendingCase[i] = i + 1;

        // Descending
        for (int i = 0; i < n; i++)
            descendingCase[i] = n - i;

        // Partial Order
        for (int i = 0; i < n; i++)
            partialCase[i] = i + 1;

        for (int i = 0; i < 20; i++) {
            int a = rand.nextInt(n);
            int b = rand.nextInt(n);

            int temp = partialCase[a];
            partialCase[a] = partialCase[b];
            partialCase[b] = temp;
        }

        // Missing Numbers
        for (int i = 0; i < n; i++)
            missingCase[i] = rand.nextInt(200) + 1;

        // Duplicates
        for (int i = 0; i < n; i++)
            duplicateCase[i] = rand.nextInt(20) + 1;

        int[][] cases = {
                randomCase,
                ascendingCase,
                descendingCase,
                partialCase,
                missingCase,
                duplicateCase
        };

        String[] names = {
                "Random",
                "Ascending",
                "Descending",
                "Partial Order",
                "Missing Numbers",
                "Duplicates"
        };

        for (int i = 0; i < cases.length; i++) {

            int[] arr = cases[i].clone();

            System.out.println("\n======================================");
            System.out.println(names[i]);

            System.out.println("Input Array:");
            printArray(arr);

            long start = System.nanoTime();

            quickSort(arr, 0, arr.length - 1);

            long end = System.nanoTime();

            System.out.println("Sorted Array:");
            printArray(arr);

            System.out.printf("Execution Time: %.6f ms%n", (end - start) / 1000000.0);
        }
    }
}