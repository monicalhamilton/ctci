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

    private static void insertAt(int[] a, int indexToTakeFrom, int indexToInsertAt) {
        int valueToTake = a[indexToTakeFrom];
        int indexToShuffleUp = indexToTakeFrom - 1;
        while (indexToShuffleUp >= indexToInsertAt) {
            a[indexToShuffleUp + 1] = a[indexToShuffleUp];
            indexToShuffleUp--;
        }
        a[indexToInsertAt] = valueToTake;
    }
}