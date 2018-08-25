package linkedlists;

/**
 * 2.3
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
