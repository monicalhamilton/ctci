package linkedlists;

/**
 * 2.3
 *
 * Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
 * EXAMPLE
 * Input: the node c from the linked list a->b->c->d->e
 * Result: nothing is returned, but the new linked list looks like a- >b- >d->e
 */
public class DeleteNodeGivenNodeToDelete {

    public static void deleteNodeGivenNodeToDelete(SinglyLinkedNode n) {
        if (n == null) {
            return;
        }
        if (n.next == null) {
            throw new RuntimeException("Cannot delete the last element");
        }
        SinglyLinkedNode current = n;
        while (current.next != null) {
            current.data = current.next.data;
            if (current.next.next == null) {
                current.next = null;
                return;
            }
            current = current.next;
        }
    }
}
