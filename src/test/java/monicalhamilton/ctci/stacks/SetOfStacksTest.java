package monicalhamilton.ctci.stacks;

import org.junit.Test;

import static org.junit.Assert.*;

public class SetOfStacksTest {

    @Test
    public void test() {
        SetOfStacks s = new SetOfStacks(2);
        assertEquals(0, s.numStacks());

        s.push(1);
        assertEquals(1, s.numStacks());
        s.push(2);
        assertEquals(1, s.numStacks());
        s.push(3);
        assertEquals(2, s.numStacks());

        s.pop();
        assertEquals(1, s.numStacks());
        s.pop();
        assertEquals(1, s.numStacks());
        s.pop();
        assertEquals(0, s.numStacks());
    }
}
