#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdlib>
#include <ctime>
#include <chrono>

using namespace std;
using namespace chrono;

int partition(vector<int>& arr, int low, int high) {
    int pivot = arr[high];
    int i = low - 1;

    for (int j = low; j < high; j++) {
        if (arr[j] <= pivot) {
            i++;
            swap(arr[i], arr[j]);
        }
    }

    swap(arr[i + 1], arr[high]);
    return i + 1;
}

void quickSort(vector<int>& arr, int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);

        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

void printArray(vector<int> arr) {
    for (int x : arr)
        cout << x << " ";
    cout << endl;
}

int main() {

    srand(time(0));

    int n = 100;

    vector<int> randomCase(n);
    vector<int> ascendingCase(n);
    vector<int> descendingCase(n);
    vector<int> partialCase(n);
    vector<int> missingCase(n);
    vector<int> duplicateCase(n);

    // Random
    for (int i = 0; i < n; i++)
        randomCase[i] = rand() % 1000 + 1;

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
        int a = rand() % n;
        int b = rand() % n;
        swap(partialCase[a], partialCase[b]);
    }

    // Missing Numbers
    for (int i = 0; i < n; i++)
        missingCase[i] = rand() % 200 + 1;

    // Duplicates
    for (int i = 0; i < n; i++)
        duplicateCase[i] = rand() % 20 + 1;

    vector<vector<int>> cases = {
        randomCase,
        ascendingCase,
        descendingCase,
        partialCase,
        missingCase,
        duplicateCase
    };

    string names[] = {
        "Random",
        "Ascending",
        "Descending",
        "Partial Order",
        "Missing Numbers",
        "Duplicates"
    };

    for (int i = 0; i < 6; i++) {

        vector<int> arr = cases[i];

        cout << "\n==========================================" << endl;
        cout << names[i] << endl;

        cout << "Input Array:" << endl;
        printArray(arr);

        auto start = high_resolution_clock::now();

        quickSort(arr, 0, arr.size() - 1);

        auto end = high_resolution_clock::now();

        cout << "Sorted Array:" << endl;
        printArray(arr);

        auto duration = duration_cast<microseconds>(end - start);

        cout << "Execution Time: "
             << duration.count() / 1000.0
             << " ms" << endl;
    }

    return 0;
}