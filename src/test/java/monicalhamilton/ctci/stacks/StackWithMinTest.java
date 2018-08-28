package monicalhamilton.ctci.stacks;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackWithMinTest {

    private StackWithMin stackWithMin;

    @Before
    public void setUp() {
        stackWithMin = new StackWithMin();
    }

    @Test
    public void emptyStack() {
        assertNull(stackWithMin.min());
    }

    @Test
    public void singleValue() {
        pushAndAssertMin(1, 1);
    }

    @Test
    public void minIsFirstValue() {
        pushAndAssertMin(1, 1);
        pushAndAssertMin(2, 1);
    }

    @Test
    public void minIsLastValue() {
        pushAndAssertMin(2, 2);
        pushAndAssertMin(1, 1);
    }

    @Test
    public void minRepeats() {
        // 3, 1, 2, 1
        pushAndAssertMin(3, 3);
        pushAndAssertMin(1, 1);
        pushAndAssertMin(2, 1);
        pushAndAssertMin(1, 1);

        popAndAssertMin(1, 1);
        popAndAssertMin(2, 1);
        popAndAssertMin(1, 3);
        popAndAssertMin(3, null);
    }

    private void pushAndAssertMin(int valToPush, Integer expectedMin) {
        stackWithMin.push(valToPush);
        assertEquals(expectedMin, stackWithMin.min());
    }

    private void popAndAssertMin(Integer expectedPop, Integer expectedMin) {
        assertEquals(expectedPop, stackWithMin.pop());
        assertEquals(expectedMin, stackWithMin.min());
    }
}