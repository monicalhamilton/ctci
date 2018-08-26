package monicalhamilton.ctci.linkedlists;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PartitionListTest {

    @Test
    public void testAlreadyInOrder() {

        Node<Integer> head = LinkedListTestUtil.makeList(1, 2, 3);

        Node<Integer> newHead = PartitionList.partitionList(head, 2);

        assertEquals(head, newHead);
    }

    @Test
    public void testOutOfOrder() {
        Node<Integer> head = LinkedListTestUtil.makeList(1, 3, 5, 4, 2, 7);

        Node<Integer> newHead = PartitionList.partitionList(head, 5);

        assertEquals(LinkedListTestUtil.makeList(1, 3, 4, 2, 5, 7), newHead);
    }

    @Test
    public void testRepeatingValues() {
        Node<Integer> head = LinkedListTestUtil.makeList(1, 2, 2, 1, 0, 3, 1, 4, 5, 1, 3);

        Node<Integer> newHead = PartitionList.partitionList(head, 2);

        assertEquals(LinkedListTestUtil.makeList(1, 1, 0, 1, 1, 2, 2, 3, 4, 5, 3), newHead);
    }

    @Test
    public void testMissingEqual() {
        Node<Integer> head = LinkedListTestUtil.makeList(1, 5, 3, 0);

        Node<Integer> newHead = PartitionList.partitionList(head, 2);

        assertEquals(LinkedListTestUtil.makeList(1, 0, 5, 3), newHead);
    }

    @Test
    public void testMissingBelow() {
        Node<Integer> head = LinkedListTestUtil.makeList(2, 5, 3, 1);

        Node<Integer> newHead = PartitionList.partitionList(head, 1);

        assertEquals(LinkedListTestUtil.makeList(1, 2, 5, 3), newHead);
    }

    @Test
    public void testMissingAbove() {
        Node<Integer> head = LinkedListTestUtil.makeList(2, 5, 3, 1);

        Node<Integer> newHead = PartitionList.partitionList(head, 5);

        assertEquals(LinkedListTestUtil.makeList(2, 3, 1, 5), newHead);
    }
}