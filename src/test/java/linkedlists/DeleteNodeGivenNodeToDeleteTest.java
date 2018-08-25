package linkedlists;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class DeleteNodeGivenNodeToDeleteTest {

    @Test
    public void testNullNode() {
        DeleteNodeGivenNodeToDelete.deleteNodeGivenNodeToDelete(null);
    }

    @Test
    public void testFirstNode() {
        SinglyLinkedNode<Integer> head = new SinglyLinkedNode<>(1);
        head.add(2);
        head.add(3);

        DeleteNodeGivenNodeToDelete.deleteNodeGivenNodeToDelete(head);

        assertEquals(Integer.valueOf(2), head.data);
        assertEquals(Integer.valueOf(3), head.next.data);
        assertNull(head.next.next);
    }

    @Test
    public void testMiddleNode() {
        SinglyLinkedNode<Integer> head = new SinglyLinkedNode<>(1);
        SinglyLinkedNode<Integer> middle = head.add(2);
        middle.add(3);

        DeleteNodeGivenNodeToDelete.deleteNodeGivenNodeToDelete(middle);

        assertEquals(Integer.valueOf(1), head.data);
        assertEquals(Integer.valueOf(3), head.next.data);
        assertNull(head.next.next);
    }

    @Test(expected = RuntimeException.class)
    public void testLastNode() {
        SinglyLinkedNode<Integer> head = new SinglyLinkedNode<>(1);
        head.add(2);
        SinglyLinkedNode<Integer> tail = head.add(3);

        DeleteNodeGivenNodeToDelete.deleteNodeGivenNodeToDelete(tail);
    }
}