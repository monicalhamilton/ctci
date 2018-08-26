package linkedlists;

import org.junit.Test;

import static org.junit.Assert.*;

public class IsPalindromeTest {

    @Test
    public void testEmptyList() {
        assertFalse(new IsPalindrome<>(null).check());
    }

    @Test
    public void testSingletonList() {
        assertTrue(new IsPalindrome<>(new Node<>(1)).check());
    }

    @Test
    public void testEvenNumber() {
        Node<Integer> head = new Node<>(1);
        head.add(1);
        assertTrue(new IsPalindrome<>(head).check());
    }

    @Test
    public void testOddNumber() {
        Node<Integer> head = new Node<>(1);
        head.add(2);
        head.add(1);
        assertTrue(new IsPalindrome<>(head).check());
    }

    @Test
    public void testLarger() {
        Node<Integer> head = new Node<>(1);
        head.add(2);
        head.add(1);
        head.add(1);
        head.add(2);
        head.add(1);
        assertTrue(new IsPalindrome<>(head).check());
    }

    @Test
    public void testNotPalindromeEven() {
        Node<Integer> head = new Node<>(1);
        head.add(2);
        assertFalse(new IsPalindrome<>(head).check());
    }

    @Test
    public void testNotPalindromeOdd() {
        Node<Integer> head = new Node<>(1);
        head.add(2);
        head.add(2);
        assertFalse(new IsPalindrome<>(head).check());
    }
}
