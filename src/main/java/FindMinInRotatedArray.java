/**
 * A sorted array has been rotated so that the elements might appear in the order 3 4 5 6 7 1 2.
 * How would you find the minimum element? You may assume that the array has all unique elements.
 */
public class FindMinInRotatedArray {
    public static int findMinInRotatedArray(int[] rotatedArray) {
        return findMin(rotatedArray, 0, rotatedArray.length - 1);
    }
    private static int findMin(int[] rotatedArray, int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex) {
            return rotatedArray[leftIndex];
        }
        int midIndex = (rightIndex - leftIndex) / 2 + leftIndex;
        int rightVal = rotatedArray[rightIndex];
        int midVal = rotatedArray[midIndex];
        if (midVal > rightVal) {
            return findMin(rotatedArray, midIndex + 1, rightIndex);
        } else {
            return findMin(rotatedArray, leftIndex, midIndex);
        }
    }
}
