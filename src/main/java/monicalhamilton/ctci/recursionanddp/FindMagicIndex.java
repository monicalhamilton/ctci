package monicalhamilton.ctci.recursionanddp;

/**
 * 9.3
 *
 * A magic index in an array A[1...n-1] is defined to be an index such that A[i] = i. Given a sorted array of distinct
 * integers, write a method to find a magic index, if one exists, in array A.
 *
 * FOLLOW UP
 *
 * What if the values are not distinct?
 */
public class FindMagicIndex {

    public static int noRepeats(int[] a) {
        if (a.length == 0) {
            return -1;
        }
        return noRepeats(a, 0, a.length - 1);
    }

    private static int noRepeats(int[] a, int leftIndex, int rightIndex) {
        int midIndex = (rightIndex - leftIndex) / 2 + leftIndex;
        if (midIndex == a[midIndex]) {
            return midIndex;
        }
        if (leftIndex == rightIndex) {
            return -1;
        }
        if (midIndex < a[midIndex]) {
            return noRepeats(a, leftIndex, midIndex);
        } else {
            return noRepeats(a, midIndex + 1, rightIndex);
        }
    }

    public static int withRepeats(int[] a) {
        if (a.length == 0) {
            return -1;
        }
        return withRepeats(a, 0, a.length - 1);
    }

    private static int withRepeats(int[] a, int leftIndex, int rightIndex) {
        if (leftIndex == a[leftIndex]) {
            return leftIndex;
        }
        if (rightIndex == a[rightIndex]) {
            return rightIndex;
        }
        if (a[rightIndex] < leftIndex || a[leftIndex] > rightIndex) {
                return -1;
        }

        int midIndex = (rightIndex - leftIndex) / 2 + leftIndex;
        int leftHalfResult = withRepeats(a, leftIndex, midIndex);
        if (leftHalfResult >= 0) {
            return leftHalfResult;
        }
        return withRepeats(a, midIndex + 1, rightIndex);
    }
}
