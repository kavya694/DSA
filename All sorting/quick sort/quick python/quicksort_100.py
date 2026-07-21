import random
import time

def quicksort(arr):
    if len(arr) <= 1:
        return arr

    pivot = arr[len(arr) // 2]

    left = [x for x in arr if x < pivot]
    middle = [x for x in arr if x == pivot]
    right = [x for x in arr if x > pivot]

    return quicksort(left) + middle + right

n = 100

random_case = random.sample(range(1, 1001), n)

ascending_case = list(range(1, n + 1))

descending_case = list(range(n, 0, -1))

partial_case = list(range(1, n + 1))
for i in range(20):
    a = random.randint(0, n - 1)
    b = random.randint(0, n - 1)
    partial_case[a], partial_case[b] = partial_case[b], partial_case[a]

missing_case = random.sample(range(1, 201), n)

duplicate_case = [random.randint(1, 20) for _ in range(n)]

cases = {
    "Random": random_case,
    "Ascending": ascending_case,
    "Descending": descending_case,
    "Partial Order": partial_case,
    "Missing Numbers": missing_case,
    "Duplicates": duplicate_case
}

for name, arr in cases.items():
    print("\n" + "=" * 50)
    print(name)
    print("Input:")
    print(arr)

    start = time.perf_counter()

    sorted_arr = quicksort(arr)

    end = time.perf_counter()

    print("Sorted:")
    print(sorted_arr)

    print("Execution Time: {:.8f} seconds".format(end - start))