package linkedlists;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class KthToLastInLinkedListTest {

    @Test
    public void testZeroToLast() {
        SinglyLinkedNode head = makeList(1, 2, 3, 4);
        assertEquals(4, KthToLastInLinkedList.findKthToLastInLinkedList(head, 0).data);
    }

    @Test
    public void testKthToLast() {
        SinglyLinkedNode head = makeList(1, 2, 3, 4);
        assertEquals(3, KthToLastInLinkedList.findKthToLastInLinkedList(head, 1).data);
    }

    @Test
    public void testOutOfBounds() {
        SinglyLinkedNode head = makeList(1, 2, 3, 4);
        assertNull(KthToLastInLinkedList.findKthToLastInLinkedList(head, 4));
    }

    private SinglyLinkedNode makeList(int... values) {
        SinglyLinkedNode head = null;
        SinglyLinkedNode prev = null;
        for (int v : values) {
            SinglyLinkedNode n = new SinglyLinkedNode(v);
            if (head == null) {
                head = n;
            } else {
                prev.next = n;
            }
            prev = n;
        }
        return head;
    }
}