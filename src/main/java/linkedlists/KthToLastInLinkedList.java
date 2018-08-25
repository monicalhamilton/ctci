package linkedlists;

/**
 * 2.2
 *
 * Implement an algorithm to find the kth to last element of a singly linked list.
 */
class KthToLastInLinkedList {
    static Node findKthToLastInLinkedList(Node head, int k) {
        if (head == null) {
            return null;
        }

        // Move pointers k apart
        Node kthToLastFinder = head;
        Node endFinder = head;
        int i = 0;
        while (i < k && endFinder.next != null) {
            endFinder = endFinder.next;
            i++;
        }

        // Not enough nodes in list
        if (i < k) {
            return null;
        }

        // Slide pointers to end
        while (endFinder.next != null) {
            kthToLastFinder = kthToLastFinder.next;
            endFinder = endFinder.next;
        }
        return kthToLastFinder;
    }
}
