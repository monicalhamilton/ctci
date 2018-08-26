package monicalhamilton.ctci.stacks;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayBackedStacksTest {

    @Test
    public void push() {
        ArrayBackedStacks stacks = new ArrayBackedStacks(3);

        stacks.push(7, 0);
        stacks.push(8, 1);
        stacks.push(1, 2);
        assertEquals(Integer.valueOf(7), stacks.peek(0));
        assertEquals(Integer.valueOf(8), stacks.peek(1));
        assertEquals(Integer.valueOf(1), stacks.peek(2));

        stacks.push(11, 2);
        assertEquals(Integer.valueOf(11), stacks.peek(2));
    }

    @Test
    public void popEmptyStack() {
        ArrayBackedStacks stacks = new ArrayBackedStacks(3);

        assertNull(stacks.pop(0));
    }

    @Test
    public void popFromStacks() {
        ArrayBackedStacks stacks = new ArrayBackedStacks(4);

        stacks.push(1, 3);
        stacks.push(2, 3);
        assertEquals(Integer.valueOf(2), stacks.pop(3));
        assertEquals(Integer.valueOf(1), stacks.pop(3));
        assertNull(stacks.pop(3));
    }

    @Test(expected = RuntimeException.class)
    public void throwsExceptionIfStackOutOfRange() {
        ArrayBackedStacks stacks = new ArrayBackedStacks(3);
        stacks.push(1, 10);
    }

    @Test
    public void peekMultipleTimesSameResult() {
        ArrayBackedStacks stacks = new ArrayBackedStacks(3);
        stacks.push(1, 2);
        assertEquals(Integer.valueOf(1), stacks.peek(2));
        assertEquals(Integer.valueOf(1), stacks.peek(2));
    }

    @Test
    public void peekEmptyStack() {
        ArrayBackedStacks stacks = new ArrayBackedStacks(3);
        assertNull(stacks.peek(2));
    }
}