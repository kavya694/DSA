#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdlib>
#include <ctime>
#include <chrono>

using namespace std;
using namespace chrono;

void merge(vector<int> &arr, int left, int mid, int right) {
    vector<int> L(arr.begin() + left, arr.begin() + mid + 1);
    vector<int> R(arr.begin() + mid + 1, arr.begin() + right + 1);

    int i = 0, j = 0, k = left;

    while (i < L.size() && j < R.size()) {
        if (L[i] <= R[j])
            arr[k++] = L[i++];
        else
            arr[k++] = R[j++];
    }

    while (i < L.size())
        arr[k++] = L[i++];

    while (j < R.size())
        arr[k++] = R[j++];
}

void mergeSort(vector<int> &arr, int left, int right) {
    if (left < right) {
        int mid = (left + right) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }
}

void printArray(vector<int> arr) {
    for (int x : arr)
        cout << x << " ";
    cout << endl;
}

int main() {

    srand(time(0));

    int n = 1000;

    vector<int> randomCase, ascendingCase, descendingCase, partialCase, missingCase, duplicateCase;

    // Random Numbers
    for (int i = 0; i < n; i++)
        randomCase.push_back(rand() % 200 + 1);

    // Ascending Order
    for (int i = 1; i <= n; i++)
        ascendingCase.push_back(i);

    // Descending Order
    for (int i = n; i >= 1; i--)
        descendingCase.push_back(i);

    // Partial Order
    partialCase = ascendingCase;
    random_shuffle(partialCase.begin() + 50, partialCase.end());

    // Missing Numbers
    for (int i = 0; i < n; i++)
        missingCase.push_back(rand() % 150 + 1);

    // Duplicates
    for (int i = 0; i < n; i++)
        duplicateCase.push_back(rand() % 20 + 1);

    string names[] = {
        "Random",
        "Ascending",
        "Descending",
        "Partial Order",
        "Missing Numbers",
        "Duplicates"
    };

    vector<vector<int>> cases = {
        randomCase,
        ascendingCase,
        descendingCase,
        partialCase,
        missingCase,
        duplicateCase
    };

    for (int i = 0; i < cases.size(); i++) {

        vector<int> arr = cases[i];

        cout << "\n==========================================" << endl;
        cout << "Case: " << names[i] << endl;

        cout << "Original Array:" << endl;
        printArray(arr);

        auto start = high_resolution_clock::now();

        mergeSort(arr, 0, arr.size() - 1);

        auto end = high_resolution_clock::now();

        cout << "Sorted Array:" << endl;
        printArray(arr);

        double timeTaken = duration<double, milli>(end - start).count();

        cout << "Execution Time: " << timeTaken << " ms" << endl;
    }

    return 0;
}