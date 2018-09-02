package monicalhamilton.ctci.stacks;

import org.junit.Test;

import static org.junit.Assert.*;

public class TowersOfHanoiTest {

    @Test
    public void empty_succeeds() {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> middle = new Stack<>();
        Stack<Integer> right = new Stack<>();

        TowersOfHanoi.towersOfHanoi(left, middle, right);

        assertEquals(0, left.size());
        assertEquals(0, middle.size());
        assertEquals(0, right.size());

        assertNull(right.pop());
    }

    @Test
    public void height1_succeeds() {
        Stack<Integer> left = new Stack<>();
        left.push(1);
        Stack<Integer> middle = new Stack<>();
        Stack<Integer> right = new Stack<>();

        TowersOfHanoi.towersOfHanoi(left, middle, right);

        assertEquals(0, left.size());
        assertEquals(0, middle.size());
        assertEquals(1, right.size());

        assertEquals(Integer.valueOf(1), right.pop());
        assertNull(right.pop());
    }

    @Test
    public void height2_succeeds() {
        Stack<Integer> left = new Stack<>();
        left.push(2);
        left.push(1);
        Stack<Integer> middle = new Stack<>();
        Stack<Integer> right = new Stack<>();

        TowersOfHanoi.towersOfHanoi(left, middle, right);

        assertEquals(0, left.size());
        assertEquals(0, middle.size());
        assertEquals(2, right.size());

        assertEquals(Integer.valueOf(1), right.pop());
        assertEquals(Integer.valueOf(2), right.pop());
        assertNull(right.pop());
    }

    @Test
    public void height3_succeeds() {
        Stack<Integer> left = new Stack<>();
        left.push(3);
        left.push(2);
        left.push(1);
        Stack<Integer> middle = new Stack<>();
        Stack<Integer> right = new Stack<>();

        TowersOfHanoi.towersOfHanoi(left, middle, right);

        assertEquals(0, left.size());
        assertEquals(0, middle.size());
        assertEquals(3, right.size());

        assertEquals(Integer.valueOf(1), right.pop());
        assertEquals(Integer.valueOf(2), right.pop());
        assertEquals(Integer.valueOf(3), right.pop());
        assertNull(right.pop());
    }

    @Test
    public void height4_succeeds() {
        Stack<Integer> left = new Stack<>();
        left.push(4);
        left.push(3);
        left.push(2);
        left.push(1);
        Stack<Integer> middle = new Stack<>();
        Stack<Integer> right = new Stack<>();

        TowersOfHanoi.towersOfHanoi(left, middle, right);

        assertEquals(0, left.size());
        assertEquals(0, middle.size());
        assertEquals(4, right.size());

        assertEquals(Integer.valueOf(1), right.pop());
        assertEquals(Integer.valueOf(2), right.pop());
        assertEquals(Integer.valueOf(3), right.pop());
        assertEquals(Integer.valueOf(4), right.pop());
        assertNull(right.pop());
    }

    @Test
    public void leftTowerNotConsecutive_succeeds() {
        Stack<Integer> left = new Stack<>();
        left.push(3);
        left.push(1);
        Stack<Integer> middle = new Stack<>();
        Stack<Integer> right = new Stack<>();

        TowersOfHanoi.towersOfHanoi(left, middle, right);

        assertEquals(0, left.size());
        assertEquals(0, middle.size());
        assertEquals(2, right.size());

        assertEquals(Integer.valueOf(1), right.pop());
        assertEquals(Integer.valueOf(3), right.pop());
        assertNull(right.pop());
    }

    @Test(expected = IllegalStateException.class)
    public void leftTowerOutOfOrder_fails() {
        Stack<Integer> left = new Stack<>();
        left.push(1);
        left.push(2);
        Stack<Integer> middle = new Stack<>();
        Stack<Integer> right = new Stack<>();

        TowersOfHanoi.towersOfHanoi(left, middle, right);
    }

    @Test
    public void repeatingValues_succeeds() {
        Stack<Integer> left = new Stack<>();
        left.push(2);
        left.push(1);
        left.push(1);
        left.push(0);
        Stack<Integer> middle = new Stack<>();
        Stack<Integer> right = new Stack<>();

        TowersOfHanoi.towersOfHanoi(left, middle, right);

        assertEquals(0, left.size());
        assertEquals(0, middle.size());
        assertEquals(4, right.size());

        assertEquals(Integer.valueOf(0), right.pop());
        assertEquals(Integer.valueOf(1), right.pop());
        assertEquals(Integer.valueOf(1), right.pop());
        assertEquals(Integer.valueOf(2), right.pop());
        assertNull(right.pop());
    }
}