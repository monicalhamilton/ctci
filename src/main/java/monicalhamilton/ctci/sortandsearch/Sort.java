package monicalhamilton.ctci.sortandsearch;

import java.util.Arrays;

public class Sort {
    public static int[] bubbleSort(int[] a) {
        if (a == null) {
            return null;
        }
        boolean sorted = false;
        int j = a.length - 1;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < j; i++) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    sorted = false;
                }
            }
            j--;
        }
        return a;
    }

    public static int[] insertionSort(int[] a) {
        if (a == null || a.length <= 1) {
            return a;
        }
        for (int indexToTakeFrom = 1; indexToTakeFrom < a.length; indexToTakeFrom++) {
            // find the spot for a[i] in a[0] to a[i-1]
            int valueToInsert = a[indexToTakeFrom];
            int indexToInsertAt = 0;
            while (valueToInsert > a[indexToInsertAt] && indexToInsertAt < indexToTakeFrom) {
                indexToInsertAt++;
            }
            insertAt(a, indexToTakeFrom, indexToInsertAt);
        }
        return a;
    }

    private static void insertAt(int[] a, int indexToTakeFrom, int indexToInsertAt) {
        int valueToTake = a[indexToTakeFrom];
        int indexToShuffleUp = indexToTakeFrom - 1;
        while (indexToShuffleUp >= indexToInsertAt) {
            a[indexToShuffleUp + 1] = a[indexToShuffleUp];
            indexToShuffleUp--;
        }
        a[indexToInsertAt] = valueToTake;
    }

    public static int[] selectionSort(int[] a) {
        if (a == null || a.length <= 1) {
            return a;
        }
        for (int i = 0; i < a.length; i++) {
            // find minimum
            int minimumIndex = i;
            for (int j = i; j < a.length; j++) {
                if (a[j] < a[minimumIndex]) {
                    minimumIndex = j;
                }
            }
            insertAt(a, minimumIndex, i);
        }
        return a;
    }

    public static int[] mergeSort(int[] a) {
        if (a == null || a.length <= 1) {
            return a;
        }
        mergeSort(a, 0, a.length - 1);
        return a;
    }

    private static void mergeSort(int[] a, int leftIndex, int rightIndex) {
        int midIndex = (rightIndex - leftIndex) / 2 + leftIndex;
        if (leftIndex < midIndex) {
            mergeSort(a, leftIndex, midIndex);
        }
        if (midIndex + 1 < rightIndex) {
            mergeSort(a, midIndex + 1, rightIndex);
        }
        merge(a, leftIndex, midIndex, midIndex + 1, rightIndex);
    }

    private static void merge(int[] a, int startLeft, int endLeft, int startRight, int endRight) {
        int[] copy = Arrays.copyOf(a, a.length);
        int leftIndex = startLeft; //
        int rightIndex = startRight; //
        int i = startLeft; //
        while (leftIndex <= endLeft || rightIndex <= endRight) {
            if (leftIndex > endLeft) {
                a[i] = copy[rightIndex];
                rightIndex++;
            } else if (rightIndex > endRight) {
                a[i] = copy[leftIndex];
                leftIndex++;
            } else {
                if (copy[leftIndex] <= copy[rightIndex]) {
                    a[i] = copy[leftIndex];
                    leftIndex++;
                } else {
                    a[i] = copy[rightIndex];
                    rightIndex++;
                }
            }
            i++;
        }
    }

    public static int[] quickSort(int[] a) {
        if (a == null || a.length <= 1) {
            return a;
        }
        quickSort(a, 0, a.length - 1);
        return a;
    }

    private static void quickSort(int[] a, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int partitionIndex = partition(a, leftIndex, rightIndex);
            quickSort(a, leftIndex, partitionIndex - 1);
            quickSort(a, partitionIndex + 1, rightIndex);
        }
    }

    private static int partition(int[] a, int leftIndex, int rightIndex) {
        int partitionValue = a[rightIndex];
        int partitionIndex = leftIndex;
        for (int i = leftIndex; i < rightIndex; i++) {
            if (a[i] <= partitionValue) {
                swap(a, i, partitionIndex);
                partitionIndex++;
            }
        }
        swap(a, partitionIndex, rightIndex);
        return partitionIndex;
    }

    private static void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    public static int[] heapSort(int[] a) {
        throw new RuntimeException("Not implemented");
    }

    private static void radixSort(int[] a) {
        throw new RuntimeException("Not implemented");
    }

    private static void countingSort(int[] a) {
        throw new RuntimeException("Not implemented");
    }
}
