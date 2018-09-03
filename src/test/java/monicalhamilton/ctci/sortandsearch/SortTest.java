package monicalhamilton.ctci.sortandsearch;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class SortTest {

    @Test
    public void nullArray() {
        assertSortedIs(null, null);
    }

    @Test
    public void empty() {
        assertSortedIs(new int[]{}, new int[]{});
    }

    @Test
    public void singleElement() {
        assertSortedIs(new int[]{1}, new int[]{1});
    }

    @Test
    public void inOrder() {
        assertSortedIs(new int[]{1, 2, 3}, new int[]{1, 2, 3});
    }

    @Test
    public void reverseOrder() {
        assertSortedIs(new int[]{1, 2, 3}, new int[]{3, 2, 1});
    }

    @Test
    public void randomOrderEven() {
        assertSortedIs(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{4, 0, 1, 2, 7, 8, 3, 9, 5, 6});
    }

    @Test
    public void randomOrderOdd() {
        assertSortedIs(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{4, 1, 2, 7, 8, 3, 9, 5, 6});
    }

    @Test
    public void repeatedElements() {
        assertSortedIs(new int[]{1, 1, 2, 2, 3, 3}, new int[]{3, 1, 2, 2, 3, 1});
    }

    private void assertSortedIs(int[] expected, int[] unsortedInput) {
        assertArrayEquals(expected, Sort.bubbleSort(unsortedInput == null ? null : Arrays.copyOf(unsortedInput, unsortedInput.length)));
        assertArrayEquals(expected, Sort.insertionSort(unsortedInput == null ? null : Arrays.copyOf(unsortedInput, unsortedInput.length)));
        assertArrayEquals(expected, Sort.selectionSort(unsortedInput == null ? null : Arrays.copyOf(unsortedInput, unsortedInput.length)));
        assertArrayEquals(expected, Sort.mergeSort(unsortedInput == null ? null : Arrays.copyOf(unsortedInput, unsortedInput.length)));
    }
}