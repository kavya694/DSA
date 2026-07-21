import random
import time

def merge(left, right):
    result = []
    i = j = 0

    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1

    result.extend(left[i:])
    result.extend(right[j:])
    return result

def merge_sort(arr):
    if len(arr) <= 1:
        return arr

    mid = len(arr) // 2
    left = merge_sort(arr[:mid])
    right = merge_sort(arr[mid:])

    return merge(left, right)

n = 1000

# Random Numbers
random_case = random.sample(range(1, 2001), n)

# Ascending Order
ascending_case = list(range(1, n + 1))

# Descending Order
descending_case = list(range(n, 0, -1))

# Partial Order
partial_case = list(range(1, n + 1))
temp = partial_case[500:]
random.shuffle(temp)
partial_case[500:] = temp

# Missing Numbers
missing_case = random.sample(range(1, 1501), n)

# Duplicates
duplicate_case = [random.randint(1, 100) for _ in range(n)]

cases = {
    "Random": random_case,
    "Ascending": ascending_case,
    "Descending": descending_case,
    "Partial Order": partial_case,
    "Missing Numbers": missing_case,
    "Duplicates": duplicate_case
}

for name, arr in cases.items():

    print("\n" + "=" * 60)
    print("Case:", name)

    print("\nOriginal Array:")
    print(arr)

    start = time.perf_counter()

    sorted_arr = merge_sort(arr)

    end = time.perf_counter()

    print("\nSorted Array:")
    print(sorted_arr)

    print("\nExecution Time: {:.6f} ms".format((end - start) * 1000))