package monicalhamilton.ctci.linkedlists;

import org.junit.Test;

import monicalhamilton.ctci.linkedlists.DeleteNodeGivenNodeToDelete;
import monicalhamilton.ctci.linkedlists.Node;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class DeleteNodeGivenNodeToDeleteTest {

    @Test
    public void testNullNode() {
        DeleteNodeGivenNodeToDelete.deleteNodeGivenNodeToDelete(null);
    }

    @Test
    public void testFirstNode() {
        Node<Integer> head = new Node<>(1);
        head.add(2);
        head.add(3);

        DeleteNodeGivenNodeToDelete.deleteNodeGivenNodeToDelete(head);

        assertEquals(Integer.valueOf(2), head.data);
        assertEquals(Integer.valueOf(3), head.next.data);
        assertNull(head.next.next);
    }

    @Test
    public void testMiddleNode() {
        Node<Integer> head = new Node<>(1);
        Node<Integer> middle = head.add(2);
        middle.add(3);

        DeleteNodeGivenNodeToDelete.deleteNodeGivenNodeToDelete(middle);

        assertEquals(Integer.valueOf(1), head.data);
        assertEquals(Integer.valueOf(3), head.next.data);
        assertNull(head.next.next);
    }

    @Test(expected = RuntimeException.class)
    public void testLastNode() {
        Node<Integer> head = new Node<>(1);
        head.add(2);
        Node<Integer> tail = head.add(3);

        DeleteNodeGivenNodeToDelete.deleteNodeGivenNodeToDelete(tail);
    }
}