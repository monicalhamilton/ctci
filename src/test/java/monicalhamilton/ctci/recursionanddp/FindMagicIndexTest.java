package monicalhamilton.ctci.recursionanddp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindMagicIndexTest {
    @Test
    public void testEmptyArray_returnsNegativeOne() {
        assertEquals(-1, FindMagicIndex.noRepeats(new int[]{}));
        assertEquals(-1, FindMagicIndex.withRepeats(new int[]{}));
    }

    @Test
    public void testNoMagicIndex_returnsNegativeOne() {
        assertEquals(-1, FindMagicIndex.noRepeats(new int[]{1, 2, 3}));
        assertEquals(-1, FindMagicIndex.withRepeats(new int[]{1, 2, 3}));
    }

    @Test
    public void testMagicIndexInZerothIndex_returnsZero() {
        assertEquals(0, FindMagicIndex.noRepeats(new int[]{0, 3, 5}));
        assertEquals(0, FindMagicIndex.withRepeats(new int[]{0, 3, 5}));
    }

    @Test
    public void testMagicIndexAtMidPoint_returnsMidpoint() {
        assertEquals(1, FindMagicIndex.noRepeats(new int[]{-1, 1, 5}));
        assertEquals(1, FindMagicIndex.withRepeats(new int[]{-1, 1, 5}));
    }

    @Test
    public void testMagicIndexAtLastIndex_returnsMidpoint() {
        assertEquals(2, FindMagicIndex.noRepeats(new int[]{-1, 0, 2}));
        assertEquals(2, FindMagicIndex.withRepeats(new int[]{-1, 0, 2}));
    }

    @Test
    public void testMagicIndexInLeftHalf_returnsIndex() {
        assertEquals(1, FindMagicIndex.noRepeats(new int[]{-1, 1, 5, 6}));
        assertEquals(1, FindMagicIndex.withRepeats(new int[]{-1, 1, 5, 6}));
    }

    @Test
    public void testMagicIndexInRightHalf_returnsIndex() {
        assertEquals(2, FindMagicIndex.noRepeats(new int[]{-1, 0, 2, 5}));
        assertEquals(2, FindMagicIndex.withRepeats(new int[]{-1, 0, 2, 5}));
    }

    @Test
    public void testMagicIndexRepeats_returnsIndex() {
        assertEquals(5, FindMagicIndex.withRepeats(new int[]{-1, 0, 0, 4, 5, 5, 8}));
    }
}
