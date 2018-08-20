import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class FindMinInRotatedArrayTest {
    @Test
    public void testInOrder() {
        int[] inOrderArray = new int[]{0, 1, 2};
        assertEquals(0, FindMinInRotatedArray.findMinInRotatedArray(inOrderArray));
    }

    @Test
    public void testMinInMiddle() {
        int[] inOrderArray = new int[]{2, 0, 1};
        assertEquals(0, FindMinInRotatedArray.findMinInRotatedArray(inOrderArray));
    }

    @Test
    public void testMinAtEnd() {
        int[] inOrderArray = new int[]{1, 2, 0};
        assertEquals(0, FindMinInRotatedArray.findMinInRotatedArray(inOrderArray));
    }

    @Test
    public void testEven() {
        int[] inOrderArray = new int[]{1, 4, 5, 0};
        assertEquals(0, FindMinInRotatedArray.findMinInRotatedArray(inOrderArray));
    }

    @Test
    public void testLargeArray() {
        int[] inOrderArray = new int[]{16, 20, 21, 1, 7, 9, 10, 11, 12, 13};
        assertEquals(1, FindMinInRotatedArray.findMinInRotatedArray(inOrderArray));
    }
}